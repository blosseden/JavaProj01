package project.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PhoneBookManager {
	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;
	public PhoneBookManager(String id, String pw) {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection(
				"jdbc:oracle:thin://@localhost:1521:orcl", id , pw);
		System.out.println("오라클 db 연결성공");
	}
	catch (ClassNotFoundException e) {
		System.out.println("오라클 드라이버 로딩 실패");
		e.printStackTrace();
	}
	catch (SQLException e) {
		System.out.println("DB 연결 실패");
		e.printStackTrace();
	}
	catch (Exception e) {
		System.out.println(" 알 수 없는 예외 발생");
	}
}//end of Connect
public PhoneBookManager() {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection(
				"jdbc:oracle:thin://@localhost:1521:orcl",
				"kosmo", "1234");
		System.out.println("오라클 DB연결 성공");
	}
		catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩실패");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(" 알 수 없는 예외 발생");
		}
	}
	public void start() {
		Scanner scan = new Scanner(System.in);
		int choice;
		while(true) {
			printMenu();
			choice = scan.nextInt();

			switch(choice) {
			case 1:
				detaInput();
				break;
			case 2:
				searchInfo();
				break;
			case 3:
				deleteInfo();
				break;
			case 4:
				detaAllData();
				break;
			case 5:
				System.out.println("끗");
				return;
			}
		}
	}
	public void detaInput() {
		
	try {
		String query = "INSERT INTO phonebook_tb VALUES (seq_phonebook.nextval,?,?,?)";
		
		psmt = con.prepareStatement(query);
		
		String iName, iPhone, iBirth;
		Scanner scan = new Scanner(System.in);
		System.out.println("써보란 말이야");

		System.out.println("이름 :"); iName=scan.nextLine();	
		System.out.println("전화번호 :"); iPhone=scan.nextLine();
		System.out.println("생년월일 :"); iBirth=scan.nextLine();

		System.out.println("");
		
		psmt.setString(1, iName);
		psmt.setString(2, iPhone);
		psmt.setString(3, iBirth);
		
		psmt.executeUpdate();
		
		System.out.println("정보 입력 완료★");
		System.out.println("");
		
	}
	catch(SQLException e) {
		System.out.println("DB 연결 실패");
		e.printStackTrace();
	}
	catch(Exception e) {
	System.out.println("알 수 없는 예외발생");
	}
}
	public void detaAllData() {
		try {
			stmt = con.createStatement();
			
			String query = "SELECT name,phonenumber, birth FROM phonebook_tb";
			
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				String name = rs.getString(1); // 인덱스 1
				String phonenumber = rs.getString(2);
				String birth = rs.getString(3);
				System.out.println("이름 : " + name);
				System.out.println("전화번호 : " + phonenumber);
				System.out.println("생일 : " + birth);
			}
		}
		catch(SQLException e) {
		System.out.println("쿼리오류발생");
		e.printStackTrace();	
		}
		System.out.println("정보 출력이라능");
		System.out.println("");
	//end of showAllData
}
	public void searchInfo() {
		
		try {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색 할 이름을 입력 하세요 :");
		String searchName=scan.nextLine();
		
			stmt = con.createStatement();
			String query = "SELECT name, phonenumber, birth FROM phonebook_tb where name like '%" + searchName +"%'";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String name = rs.getString(1);
				String phonenumber = rs.getString(2);
				String birth = rs.getString(3);
				
				System.out.println("이름 :"+name); 
				System.out.println("전화번호 :"+phonenumber); 
				System.out.println("생년월일 :"+birth);
				
			}
		} catch (SQLException e) {
			System.out.println("쿼리오류");
			e.printStackTrace();
		}
	}
	public void deleteInfo() {
	try {	
		String query = "delete from phonebook_tb where name = ?";
		psmt = con.prepareStatement(query);
		
		Scanner scan=new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요");
		String iName = scan.nextLine();
		
		psmt.setString(1,iName);
		
		psmt.executeUpdate();
		System.out.println("삭☆제★");
	} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
	}
}

	public static void printMenu() {
		System.out.println("\\\\골라보십쇼 형님////");
		System.out.println("1.입력 :");
		System.out.println("2.데이터 검색 :");
		System.out.println("3.데이터 삭제 :");
		System.out.println("4.주소록 출력 :");
		System.out.println("5.프로그램 종료 :");
		System.out.println("선택 :");
	}
}