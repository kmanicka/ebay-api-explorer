package viewobjects.shopping;

import core.shopping.BaseeBayShoppingCall;
import core.shopping.calls.GetSingleItem;

public class GetSingleItemView extends BaseShoppingView{
	
	String getItemId(){
		if (baseeBayCall == null) return null;
		
		return ((GetSingleItem)baseeBayCall).getItemId();
	}

	String getTitle(){
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getTitle();
	}
	
	String getImage() {
		if (baseeBayCall == null) return null;
		
		return ((GetSingleItem)baseeBayCall).getImage();
	}

	String getCost() {
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getCost();
	}

	String getQuantity() {
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getQuantity();
	}	
	
	String getSold() {
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getSold();
	}

	String getShipsFrom() {
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getShipsFrom();
	}
	
	String getSeller() {
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getSeller();
	}

	String getSellerFeedback() {
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getSellerFeedback();
	}

	String getSellerFeedbackPercent() {
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getSellerFeedbackPercent();
	}

	String getStore() {
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getStore();
	}

	
	String getCategory() {
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getCategory();
	}

	String getDescription() {
		if (baseeBayCall == null) return null;

		return ((GetSingleItem)baseeBayCall).getDescription();
	}


}
