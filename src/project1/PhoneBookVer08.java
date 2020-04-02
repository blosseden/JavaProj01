package project1;

import project.ver08.MenuSelectException;
import project.ver08.PhoneBookManager;

public class PhoneBookVer08 {

	public static void main(String[] args) {
		PhoneBookManager bookManager =new PhoneBookManager();
			try {
				bookManager.start();
			} catch (MenuSelectException e) {
				e.printStackTrace();
		}
	}
}

