package cryptoTrader.abs;

/*
 * @author: Chun Yang 250653628
 * Proxy Design Pattern for login
 * */
public abstract class LoginInterface {
	public abstract boolean isValid(String name, String password);
}
