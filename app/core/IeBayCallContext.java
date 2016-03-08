package core;

public interface IeBayCallContext {
	public Boolean isSandbox();

	public String getDevName();

	public String getAppName();

	public String getCertName();

	public String getRuName();
	
	public String getAuthToken();
}
