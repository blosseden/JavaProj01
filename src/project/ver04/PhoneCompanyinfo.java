package project.ver04;

public class PhoneCompanyinfo extends Phoneinfo {
	
	String cp;
	
	public PhoneCompanyinfo(String name, String phoneNumber,
			String cp) {
		super(name,phoneNumber);
		this.cp = cp;
	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회-사");
	}
}
