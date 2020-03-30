package project.ver07;

class Name {

}

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

	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		int hc2 = phoneNumber.hashCode();
		int result = hc1 + hc2;
		return result;
	}
	@Override
	public boolean equals(Object obj) {

		Phoneinfo phoneinfo = (Phoneinfo)obj;
		if(phoneinfo.name.equals(this.name) &&
				phoneinfo.phoneNumber.equals(this.phoneNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
	public void showPhoneInfo() {
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);

	}
}
//"Phoneinfo 이름 :\n" + name + ", 전화번호 :"
//			+ phoneNumber
