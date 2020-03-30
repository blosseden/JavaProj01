package project.ver08;

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
	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		int hc2 = phoneNumber.hashCode();
		int hc3 = cp.hashCode();
		
		int result = hc1 + hc2 + hc3;
		return result;	}
}
