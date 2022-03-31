package cryptoTrader.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cryptoTrader.abs.LoginInterface;
import cryptoTrader.gui.ErrorUI;
import cryptoTrader.gui.LoginWindow;
import cryptoTrader.gui.MainUI;

/*
 * @author: Chun Yang 250653628
 * Description: This is Login Server handle the logic to validate user
 *              We use proxy design pattern and this is Proxy class
 * 
 * */

public class LoginServer extends LoginInterface implements ActionListener {
	
	private JTextField usernameInput;
	private JPasswordField passwordInput;
	private Validate user;
	
	public LoginServer(JTextField username, JPasswordField password) {
		this.usernameInput = username;
		this.passwordInput = password;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean isValid = false;
		try {
			isValid = Validate(usernameInput.getText(), new String(passwordInput.getPassword()));
		} catch(IOException err) {
			new ErrorUI(err.getMessage());
		}
		if(isValid) {
			// if account is valid, we redirect to Main UI
			LoginWindow.getInstance().dispose();
			MainUI.main(null);
		}else {
			new ErrorUI("user does not exit");
		}
	}
	
	@Override
	public boolean Validate(String name, String password) throws IOException{
		if(user == null){
		user = new Validate();
		}
		return user.Validate(name, password);
	}
}