package store.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.domain.Customer;
import store.service.ItemManager;

public class ShippingController implements Controller{
  
  protected final Log logger = LogFactory.getLog(getClass());
  
  private ItemManager itemManager;

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException {
    String now = (new Date()).toString();
	logger.info("Returning shipping view with " + now);
	//return new ModelAndView("shipping", "now", now);
	if((request.getParameter("submit")).matches("submit")){
	  Customer customer = new Customer();
	  customer.setAddress(request.getParameter("address"));
	  customer.setCity(request.getParameter("city"));
	  customer.setCountry(request.getParameter("country"));
	  customer.setEmail(request.getParameter("email"));
	  customer.setFirst_name(request.getParameter("first_name"));
	  customer.setLast_name(request.getParameter("last_name"));
	  customer.setTelephone(request.getParameter("telephone"));
	  customer.setZip_code(request.getParameter("zip_code"));
	  Cookie c1 = new Cookie("same_address",  String.valueOf(request.getParameter("use")));
	  response.addCookie(c1);
	  
	  if(this.itemManager.getcountcustomers(request.getCookies()[0].getValue())==0){
	    this.itemManager.add_customers(request.getCookies()[0].getValue(), customer);
	  }
	  return new ModelAndView("billing1");	
	}
	Map<String, Object> myModel = new HashMap<String, Object>();
	myModel.put("now", now);
	myModel.put("products", this.itemManager);
	myModel.put("cookies2", request.getCookies()[0].getValue());
	return new ModelAndView("shipping", "model", myModel);
  }
  
  public void setItemManager(ItemManager itemManager) {
    this.itemManager = itemManager;
  }
}
