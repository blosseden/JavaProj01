package project.ver05;

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
}
