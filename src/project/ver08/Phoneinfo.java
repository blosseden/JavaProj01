package project.ver08;

import java.io.Serializable;

public class Phoneinfo implements Serializable {
	//멤버변수
	String name;
	String phoneNumber; 
	//생성자
	public Phoneinfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;

	}
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
