package project1;

import project.ver07.MenuSelectException;
import project.ver07.PhoneBookManager;

public class PhoneBookVer07 {

	public static void main(String[] args) {
		PhoneBookManager bookManager =new PhoneBookManager();
			try {
				bookManager.start();
			} catch (MenuSelectException e) {
				e.printStackTrace();
		}
	}
}

