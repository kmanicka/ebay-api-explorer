package controllers;

import common.IConstants;
import core.IeBayCallContext;
import core.shopping.calls.GetSingleItem;
import play.mvc.Controller;
import viewobjects.shopping.GetSingleItemView;

public class EBayApp extends Controller implements IConstants {

	public static void home() {
		render();
	}

	public static void search(String query) {
		render(query);
	}

	public static void item(String itemid) {

		GetSingleItemView viewObject = new GetSingleItemView();

		if (itemid != null) {
			IeBayCallContext eBayCallContext = Application.geteBayCallContext();
			GetSingleItem getSingleItem = new GetSingleItem(itemid);
			getSingleItem.calleBay(eBayCallContext);

			viewObject.setBaseApiView(getSingleItem);

			render(viewObject);
		} 
		
		home();
	}

	public static void myebay() {
		render();
	}

}
