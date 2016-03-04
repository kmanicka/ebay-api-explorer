package controllers;

import play.*;
import play.mvc.*;
import viewobjects.IndexView;
import viewobjects.SettingsView;

import java.util.*;

import core.shopping.calls.GeteBayTime;
import core.trading.calls.GeteBayOfficialTime;
import models.*;

public class Application extends Controller {
	
    public static void index() {    	
    	IndexView indexView = new IndexView();
        render(indexView);
    }
    
    public static void trading(){
    	render();
    }
    
    public static void shopping(){
    	render();
    }
    
    public static void settings(){
    	GeteBayTime time = new GeteBayTime();
    	time.calleBay();
    	
    	GeteBayOfficialTime officialTime = new GeteBayOfficialTime();
    	officialTime.calleBay();
    	
    	SettingsView settingsView = new SettingsView();
    	settingsView.time = time.getTime();
    	settingsView.shoppingCallAck = time.getAck();
    	settingsView.shoppingCallResponse = time.getResponseString();
    	
    	settingsView.officialTime = officialTime.getTime();
    	settingsView.tradingCallAck = officialTime.getAck();
    	settingsView.tradingCallResponse = officialTime.getResponseString();
    	
        render(settingsView);
    }
    
    public static void about(){
    	render();
    }

}