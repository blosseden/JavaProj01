package project1;

import ver01.Phoneinfo;

public class PhoneBookVer01 {

	public static void main(String[] args) {
		
		Phoneinfo p1 = new Phoneinfo("토니스타크","010-1111-1111",
				"70-01-01");
		
		Phoneinfo p2 = new Phoneinfo("브루스배너","010-2222-2222");
		
		p1.showPhoneInfo();
		p2.showPhoneInfo();//생년월일 안뜸
		
	}

}
