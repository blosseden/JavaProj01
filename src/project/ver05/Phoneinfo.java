package project.ver05;

public class Phoneinfo {
	//멤버변수
	String name;
	String phoneNumber; 
	//생성자
	public Phoneinfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	
	}
////	//생년월일은 필수사항 아니므로 인자가 없는 경우 null로 초기화
////	public Phoneinfo(String name, String phoneNumber) {
////		super();
////		this.name = name;
////		this.phoneNumber = phoneNumber;
////		this.birthday = null;
//		
//	}
	//정보출력용 메소드
	public void showPhoneInfo() {
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
		
		}	
	}

