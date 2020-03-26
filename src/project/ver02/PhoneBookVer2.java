package project.ver02;

import java.util.Scanner;

public class PhoneBookVer2 {
	
public static String OKorNOT(int n) {
	
	while(true) {
		
	String str = "";
	switch (n) {
	
	case 1:
		str = "선택1";
		str = "입력하렴^오^ ";break;
	case 2:
		System.exit(0);
		str = "선택2";
		str = "끝났어여";
	}
	return str;
	}
}
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	while(true) {
	System.out.print("1. 데이터 입력★ ");
	System.out.print("2. 프로그램 종료☆");
	int n = scan.nextInt();
	System.out.print(OKorNOT(n));
	System.out.println("이름 :");
	String inputStr = scan.next();
	
	System.out.println("전화번호");
	String pn = scan.next();
	
	System.out.println("생년월일");
	String bd = scan.next();
	
	System.out.println("name : "+ inputStr);
	System.out.println("phone : "+ pn);
	System.out.println("birth : "+ bd);
	System.out.println("선택하렴");
		
		
		}
	}
}
