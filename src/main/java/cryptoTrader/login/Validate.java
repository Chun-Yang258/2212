package cryptoTrader.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import cryptoTrader.abs.LoginInterface;

/*
 * @author: Chun Yang 250653628
 * Description: This class handles the logic to validate user
 *              We use proxy design pattern and this is Real Subject class 
 *              which is the child class of Subject class
 * 
 * */

public class Validate extends LoginInterface {
	
	@Override
	public boolean Validate(String nameInput, String passwordInput) throws IOException{
		File database = new File("src/main/java/userDatabase.txt");
		BufferedReader reader = new BufferedReader(new FileReader(database));
		String line = null;
		line = reader.readLine(); // Read each line for username and password combination
		
		while(line != null) {
			String[] info = line.split(",");
			if(checkName(nameInput, info[0])) {
				if(isValid(passwordInput, info[1])) {
					return true;
				}else {
					throw new IOException("username and password does not match");
				}
			}
			line = reader.readLine();
		}
		
		return false;
	}
	
	
	public boolean isValid(String passwordInput, String passwordDB){
		return passwordInput.equals(passwordDB);
	}
	
	public boolean checkName(String nameInput, String nameDB){
		return nameInput.equals(nameDB);
	}
}
