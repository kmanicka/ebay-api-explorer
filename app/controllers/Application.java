package controllers;

import play.*;
import play.mvc.*;
import viewobjects.IndexView;

import java.util.*;

import core.shopping.calls.GeteBayTime;
import core.trading.calls.GeteBayOfficialTime;
import models.*;

public class Application extends Controller {

	static String getEnvVariable(String name) {
		return System.getenv(name);
	}

	
    public static void index() {
    	GeteBayTime time = new GeteBayTime();
    	time.calleBay();
    	
    	GeteBayOfficialTime officialTime = new GeteBayOfficialTime();
    	officialTime.calleBay();
    	
    	IndexView indexView = new IndexView();
    	indexView.time = time.getTime();
    	indexView.officialTime = officialTime.getTime();
    	
        render(indexView);
    }

}