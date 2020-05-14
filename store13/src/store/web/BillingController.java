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
		
	}
	
	Map<String, Object> myModel = new HashMap<String, Object>();
	myModel.put("now", now);
	myModel.put("products", this.itemManager);
	myModel.put("cookies2", request.getCookies()[0].getValue());
	myModel.put("cookies3", request.getCookies()[1].getValue());
	//Map<String, Object> myModel = new HashMap<String, Object>();
	//myModel.put("now", now);
	//myModel.put("products", this.productManager.getAccessoriesmen());
	return new ModelAndView("billing", "model", myModel);
  }
  
  public void setItemManager(ItemManager itemManager) {
    this.itemManager = itemManager;
  }
  
 
}
