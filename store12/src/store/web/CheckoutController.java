package store.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.domain.Item;
import store.service.ItemManager;

public class CheckoutController implements Controller{
  
  protected final Log logger = LogFactory.getLog(getClass());
  
  private ItemManager itemManager;

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException {
    String now = (new Date()).toString();
	logger.info("Returning viewcart view with " + now);
	
	//Calculate the subtotal of items in the cart for a particular user
	float total= 0;
	
	for (Item item : this.itemManager.getItems(request.getCookies()[0].getValue())) {
		total = (float) (total + item.getTotal());
	}
	
	//Insert the subtotal in the table orders
	if(this.itemManager.getcountorders(request.getCookies()[0].getValue())==0){
	  this.itemManager.add_orders(request.getCookies()[0].getValue(), total);
	}
	
	//The number of items of a particular user
    int numberofitems = this.itemManager.user_items(request.getCookies()[0].getValue());
	
	Map<String, Object> myModel = new HashMap<String, Object>();
	
	myModel.put("total", total);
	
	myModel.put("numberofitems", numberofitems);
	
	myModel.put("message", "");
	myModel.put("sex", "men");
	myModel.put("sex2", "women");
	myModel.put("categoryid1", 1);
	myModel.put("categoryid2", 2);
	myModel.put("categoryid3", 3);
	myModel.put("categoryid4", 4);
	myModel.put("categoryid5", 5);
	
	myModel.put("now", now);
	myModel.put("items", this.itemManager.getItems(request.getCookies()[0].getValue()));
	
	return new ModelAndView("checkout", "model", myModel);
  }
  
  public void setItemManager(ItemManager itemManager) {
    this.itemManager = itemManager;
  }
}
