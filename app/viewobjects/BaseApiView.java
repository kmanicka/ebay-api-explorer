package viewobjects;

import core.BaseeBayCall;

public class BaseApiView {

	public BaseeBayCall baseeBayCall;

	public void setBaseApiView(BaseeBayCall baseeBayCall) {
		this.baseeBayCall = baseeBayCall;
	}
	
	public String isOutputActive(){
		return (baseeBayCall==null || baseeBayCall.getResponseString()==null)?  "" : "active";
	}

	public String isInputActive(){
		return (baseeBayCall == null || baseeBayCall.getResponseString()==null)?  "active" : "";
	}
	
	public String getRequestString(){
		if (baseeBayCall == null) return null;

		return baseeBayCall.getRequestString();
	}
	
	public String getResponseString(){
		if (baseeBayCall == null) return null;

		return baseeBayCall.getResponseString();
	}
	
}
