package common;

public class Util {
	public static String getEnvVariable(String name) {
		String value = System.getenv(name); 
		System.out.println("Env Variable : " + name + " = " + value);
		return value;
	}
}
