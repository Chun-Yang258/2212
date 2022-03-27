package cryptoTrader.abs;

import java.io.IOException;

/*
 * @author: Chun Yang 250653628
 * Proxy Design Pattern for login
 * This is Subject class - parent class
 * */
public abstract class LoginInterface {
	public abstract boolean Validate(String name, String password) throws IOException;
}
