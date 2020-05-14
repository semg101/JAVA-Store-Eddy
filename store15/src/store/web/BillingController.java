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

import store.service.ItemManager;

public class BillingController implements Controller{
  
  protected final Log logger = LogFactory.getLog(getClass());
  
  private ItemManager itemManager;

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException {
    String now = (new Date()).toString();
	logger.info("Returning billing view with " + now);
	//return new ModelAndView("billing", "now", now);
	
	if((request.getParameter("submit")).matches("submit")){
		//request.getCookies()[1].getValue():total
		//request.getCookies()[3].getValue():email address
		//String.valueOf(request.getParameter("card_number")).substring(12):last four digits of a credit card number
		this.itemManager.add_orders(request.getCookies()[3].getValue(), request.getCookies()[1].getValue(), String.valueOf(request.getParameter("card_number")).substring(12));
		this.itemManager.add_receipts(this.itemManager.getItems(request.getCookies()[0].getValue()), request.getCookies()[3].getValue());
		this.itemManager.chargecreditcard();
		
	}
	
	
	Map<String, Object> myModel = new HashMap<String, Object>();
	myModel.put("now", now);
	myModel.put("products", this.itemManager);
	myModel.put("cookies0", request.getCookies()[0].getValue());//Id=15.......
	myModel.put("cookies1", request.getCookies()[1].getValue());//total
	myModel.put("cookies2", request.getCookies()[2].getValue());//same address: yes or null
	myModel.put("cookies3", request.getCookies()[3].getValue());// email address
	
	
	if (request.getCookies()[2].getValue().matches("yes")){
		myModel.put("cookies4", request.getCookies()[4].getValue());// first name
		myModel.put("cookies5", request.getCookies()[5].getValue());// last name
		myModel.put("cookies6", request.getCookies()[6].getValue());// address
		myModel.put("cookies7", request.getCookies()[7].getValue());// city
		myModel.put("cookies8", request.getCookies()[8].getValue());// country
		myModel.put("cookies9", request.getCookies()[9].getValue());// zip code
		myModel.put("cookies10", request.getCookies()[10].getValue());// telephone
	}
	//Map<String, Object> myModel = new HashMap<String, Object>();
	//myModel.put("now", now);
	//myModel.put("products", this.productManager.getAccessoriesmen());
	return new ModelAndView("billing", "model", myModel);
  }
  
  public void setItemManager(ItemManager itemManager) {
    this.itemManager = itemManager;
  }
  
 
}
