package project1;

import java.util.Scanner;

public class PhoneBookVer02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputStr = null;
		String pn = null;
		String bd = null;
		boolean exit=true;
		int a;
		System.out.print("1. 데이터 입력★ ");
		System.out.print("2. 프로그램 종료☆");
		System.out.println("선택 해봐");
		a=scan.nextInt();
		while(exit) {
			if(a==1) {
				int n = scan.nextInt();
				System.out.println("이름 :");
				inputStr = scan.nextLine();

				System.out.println("전화번호");
				pn = scan.nextLine();

				System.out.println("생년월일");
				bd = scan.nextLine();
			System.out.println("name : "+ inputStr);
			System.out.println("phone : "+ pn);
			System.out.println("birth : "+ bd);
			}else if(a==2) {
				System.out.println("끗 ^오^b");
				exit=false;
			}else {
				System.out.println("제대로 칠 줄 모름?");
				return;
			}
		}
	}

}

