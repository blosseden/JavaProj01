package project.ver07;

public class PhoneSchoolinfo extends Phoneinfo{
	
	String major;
	String year;
	
	public PhoneSchoolinfo(String name, String phoneNumber,
			String major, String year) {
		super(name,phoneNumber);
		this.major = major;
		this.year = year;
	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("전-공 :"+major);
		System.out.println("학-년 :"+year);
		
	}
	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		int hc2 = phoneNumber.hashCode();
		int hc4 = major.hashCode();
		int hc5 = year.hashCode();
		int result = hc1 + hc2 + hc4 + hc5;
		return result;	}
}
