package project.ver07;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {
	public Scanner scan;
	HashSet <Phoneinfo> set =new HashSet<Phoneinfo>();
	int choice;

	public void start() throws MenuSelectException {

		while(true) {
			try {
				scan = new Scanner(System.in);
				printMenu();
				choice = scan.nextInt();
				scan.nextLine();

				if(choice<1||choice>5) {
					MenuSelectException menuex = new MenuSelectException();
					throw menuex;
				}
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
					System.out.println("끗");
					return;
				}
			}catch(InputMismatchException e) {
				System.out.println("숫자 쓰십쇼 제발");
			}
			catch(MenuSelectException e) {
			}
		}
	}
	public void detaInput(int choice) {
		
		String iName, iPhone, iMajor, iYear, iCp;

		System.out.println("고르십쇼 형님");
		System.out.println("1. 일-반, 2. 동-창, 3.회-사");
		choice=scan.nextInt();
		scan.nextLine();
		
		if(choice==SubMenuItem.WHOLE) {
		
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
		System.out.println("정보 입력 완료★\n");	
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
		System.out.println("검색 할 이름을 입력 하세요 : ");
		String searchName=scan.nextLine();

		Iterator<Phoneinfo> itr = set.iterator();
		while(itr.hasNext()) {
			Phoneinfo set = itr.next();
			if(searchName.equals(set.name)) {
				searchflag = true;
				set.showPhoneInfo();
				System.out.println(set);
				System.out.println("★☆요청하신 사람을 찾았습니다 ^오^☆★");
			}
		}
		if(searchflag == false) {
			NullPointerException nullex = new NullPointerException();
			throw nullex;
		}
		System.out.println("★☆그런 사람 없.어. ㅗ^오^ㅗ ☆★");
	}//end of searchInfo

	public void deleteInfo() {
		System.out.println("삭제할 이름을 입력하세요");
		String deleteName=scan.nextLine();

		Iterator<Phoneinfo> itr = set.iterator();
		while(itr.hasNext()) {
			Phoneinfo set = itr.next();
			if(deleteName.compareTo(set.name)==0) {
				itr.remove();
			}	
		}
	}//end of deleteInfo

	public static void printMenu() {
		System.out.println("\\\\골라보십쇼////");
		System.out.println("1.입력 :");
		System.out.println("2.데이터 검색 :");
		System.out.println("3.데이터 삭제 :");
		System.out.println("4.주소록 출력 :");
		System.out.println("5.프로그램 종료 :");
		System.out.println("선택 >>>");
	}
}