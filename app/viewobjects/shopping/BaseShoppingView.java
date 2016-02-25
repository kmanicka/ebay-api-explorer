package viewobjects.shopping;

public class BaseShoppingView {
	public String requestString;
	public String responseString;
	
	public String isOutputActive(){
		return (responseString==null)?  "" : "active";
	}

	public String isInputActive(){
		return (responseString==null)?  "active" : "";
	}
}
