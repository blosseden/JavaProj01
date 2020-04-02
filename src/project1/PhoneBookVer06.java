package project1;

import project.ver06.MenuSelectException;
import project.ver06.PhoneBookManager;

public class PhoneBookVer06 {

	public static void main(String[] args) {
		PhoneBookManager bookManager =new PhoneBookManager(100);
		while(true) {
		try {
			bookManager.start();
		} catch (MenuSelectException e) {
			e.printStackTrace();
			}
		}
	}
}

