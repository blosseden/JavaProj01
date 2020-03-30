package project.ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {
	Scanner scan = new Scanner(System.in);
	HashSet <Phoneinfo> set =new HashSet<Phoneinfo>();
	int choice;
	
	public PhoneBookManager() {
		try {
			ObjectInputStream in =
					new ObjectInputStream(new FileInputStream("src/project/ver08/PhoneBook.obj"));
			while(true) {
				Phoneinfo phoneinfo =(Phoneinfo)in.readObject();
				set.add(phoneinfo);
				if(phoneinfo==null) break;
			}
		}catch(IOException e) {
		}
		catch(Exception e) {
		}

	}

	public void start() {

		while(true) {
			printMenu();
			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case MenuItem.INPUT:
				detaInput(choice);
				break;
			case MenuItem.SEARCH:
				searchInfo();
				break;
			case MenuItem.DELETE:
				deleteInfo();
				break;
			case MenuItem.ALLDATA:
				detaAllData();
				break;
			case MenuItem.END:
				savePersonInfo();
				System.out.println("끗");
				return;
			}
		}
	}//end of start

	public void detaInput(int choice) {
		Scanner scan = new Scanner(System.in);

		String iName, iPhone, iMajor, iYear, iCp;

		System.out.println("고르십쇼 형님");
		System.out.println("1. 일-반, 2. 동-창, 3.회-사");
		choice=scan.nextInt();
		scan.nextLine();
		if(choice==SubMenuItem.WHOLE) {
			//입력값 저장
			System.out.println("써보란 말이야");
			System.out.println("이름 :"); iName=scan.nextLine();	
			System.out.println("전화번호 :"); iPhone=scan.nextLine();
			Phoneinfo phoneinfo =new Phoneinfo(iName, iPhone);
			set.add(phoneinfo);

		}
		else if(choice==SubMenuItem.SCHOOL) {
			System.out.println("써보란 말이야");

			System.out.println("이름 :"); iName=scan.nextLine();	
			System.out.println("전화번호 :"); iPhone=scan.nextLine();
			System.out.println("전공");iMajor=scan.nextLine();
			System.out.println("학년");iYear=scan.nextLine();
			PhoneSchoolinfo phoneinfo =new PhoneSchoolinfo(iName, iPhone, iMajor, iYear);
			set.add(phoneinfo);
		} 
		else if(choice==SubMenuItem.CAMPANY) {
			System.out.println("써보란 말이야");

			System.out.println("이름 :"); iName=scan.nextLine();	
			System.out.println("전화번호 :"); iPhone=scan.nextLine();
			System.out.println("회사명");iCp=scan.nextLine();
			PhoneCompanyinfo phoneinfo =new PhoneCompanyinfo(iName, iPhone, iCp);
			set.add(phoneinfo);
		}
		System.out.println("정보 입력 완료★");
		System.out.println("");
	}//end of detaInput

	public void detaAllData() {
		Iterator<Phoneinfo> itr = set.iterator();
		while(itr.hasNext()) {
			Phoneinfo set = itr.next();
			set.showPhoneInfo();
		}
		System.out.println("정보 출력이라능");
		System.out.println("");
	}//end of showAllData

	public void searchInfo() {
		boolean searchflag = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("검색 할 이름을 입력 하세요 : ");
		String searchName=scan.nextLine();

		Iterator<Phoneinfo> itr = set.iterator();
		while(itr.hasNext()) {
			Phoneinfo set = itr.next();
			if(searchName.equals(set.name)) {
				searchflag = true;
				set.showPhoneInfo();
				System.out.println(set);
			}
		}
		if(searchflag == true) {
			System.out.println("★☆요청하신 사람을 찾았습니다 ^오^☆★");
		}
		else {
			System.out.println("★☆그런 사람 없.어. ㅗ^오^ㅗ ☆★");
		}
	}//end of searchInfo

	public void deleteInfo() {
		Scanner scan=new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요");
		String deleteName=scan.nextLine();
		int deleteIndex=-1;

		Iterator<Phoneinfo> itr = set.iterator();
		while(itr.hasNext()) {
			Phoneinfo set = itr.next();
			if(deleteName.compareTo(set.name)==0) {
				itr.remove();
			}	
		}
	}//end of deleteInfo

	public void savePersonInfo() {

		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/project/ver08/PhoneBook.obj")
					);
			Iterator<Phoneinfo> itr = set.iterator();
			while(itr.hasNext()) {
				Phoneinfo set = itr.next();
				out.writeObject(set);
			}
		}
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}
	public static void printMenu() {
		System.out.println("\\\\골라보십쇼////");
		System.out.println("1.입력 :");
		System.out.println("2.데이터 검색 :");
		System.out.println("3.데이터 삭제 :");
		System.out.println("4.주소록 출력 :");
		System.out.println("5.프로그램 종료 :");
		System.out.println("선택 :");
		
	}
}

