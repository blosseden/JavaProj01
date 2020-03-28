 package project.ver05;

import java.util.Scanner;

public class PhoneBookManager {
	Scanner scan = new Scanner(System.in);
	public Phoneinfo[] myInfo; 
	public int numOfInfo;//정보를 추가할 때 마다 +1 증가
	int choice;

	public PhoneBookManager(int num) {
		myInfo=new Phoneinfo[num];
		numOfInfo=0;
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
				System.out.println("끗");
				return;
			}
		}
	}
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
			Phoneinfo phoneinfo = new Phoneinfo(iName, iPhone);

			myInfo[numOfInfo++] = phoneinfo;
		}
		else if(choice==SubMenuItem.SCHOOL) {
			System.out.println("써보란 말이야");

			System.out.println("이름 :"); iName=scan.nextLine();	
			System.out.println("전화번호 :"); iPhone=scan.nextLine();
			System.out.println("전공");iMajor=scan.nextLine();
			System.out.println("학년");iYear=scan.nextLine();
			myInfo[numOfInfo++] =
					new PhoneSchoolinfo(iName, iPhone, iMajor, iYear);			
		} 
		else if(choice==SubMenuItem.CAMPANY) {
			System.out.println("써보란 말이야");

			System.out.println("이름 :"); iName=scan.nextLine();	
			System.out.println("전화번호 :"); iPhone=scan.nextLine();
			System.out.println("회사명");iCp=scan.nextLine();
			myInfo[numOfInfo++] =
					new PhoneCompanyinfo(iName, iPhone, iCp);	
		}
		System.out.println("정보 입력 완료★");
		System.out.println("");
	}
	
	public void detaAllData() {
		for(int i=0; i<numOfInfo; i++) {
			myInfo[i].showPhoneInfo();
		}
		System.out.println("정보 출력이라능");
		System.out.println("");
	}//end of showAllData

	public void searchInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색 할 이름을 입력 하세요 : ");
		String searchName=scan.nextLine();

		for(int i=0; i<numOfInfo;i++) {
			System.out.println("");
			System.out.println("검색중인 이름 : "+myInfo[i].name);
			if(searchName.compareTo(myInfo[i].name)==0) {
				myInfo[i].showPhoneInfo();
				System.out.println("너가 찾은 존함이 이분이십니까?");
				System.out.println("");
			}
		}
	}
	public void deleteInfo() {
		Scanner scan=new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요");
		String deleteName=scan.nextLine();
		/*
		 배열의 요소중 삭제된 요소의 인덱스값을 저장할 용도의 변수
		 요소를 삭제한후 빈자리를 채울때 사용할 예정임
		 */
		int deleteIndex=-1;
		for(int i=0;i<numOfInfo;i++) {
			if(deleteName.compareTo(myInfo[i].name)==0) {
				//요소를 삭제하기 위해 참조값을 null로 변경
				myInfo[i]=null;

				//삭제된 요소의 인덱스값 저장
				deleteIndex=i;

				//전체 카운트변수 -1 차감
				numOfInfo--;
			}
		}

		if(deleteIndex==-1) {
			System.out.println("삭제된게 없는걸?");
		}
		else {
			for(int i=deleteIndex; i<numOfInfo;i++) {
				myInfo[i]=myInfo[i+1];
			}
			System.out.println("("+deleteIndex+")가셨습니다ㅠㅠㅠㅠ");
			System.out.println("");
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