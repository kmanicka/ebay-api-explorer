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

}
