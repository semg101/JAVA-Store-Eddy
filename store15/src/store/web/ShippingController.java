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
	
	  //request.getCookies()[2].getValue():yes or null
	  Cookie c2 = new Cookie("use_same_address",  String.valueOf(request.getParameter("use")));
	  response.addCookie(c2);
	  
	  //request.getCookies()[3].getValue():email
	  Cookie c3 = new Cookie("email_address",  String.valueOf(request.getParameter("email")));
	  response.addCookie(c3);
	  
	//request.getCookies()[4].getValue():first name
	  Cookie c4 = new Cookie("first_name",  String.valueOf(request.getParameter("first_name")));
	  response.addCookie(c4);
	  
	  //request.getCookies()[5].getValue():last name
	  Cookie c5 = new Cookie("last_name",  String.valueOf(request.getParameter("last_name")));
	  response.addCookie(c5);
	  
	  //request.getCookies()[6].getValue():address
	  Cookie c6 = new Cookie("address",  String.valueOf(request.getParameter("address")));
	  response.addCookie(c6);
	  
	  //request.getCookies()[7].getValue():city
	  Cookie c7 = new Cookie("city",  String.valueOf(request.getParameter("city")));
	  response.addCookie(c7);
	  
	  //request.getCookies()[8].getValue():country
	  Cookie c8 = new Cookie("country",  String.valueOf(request.getParameter("country")));
	  response.addCookie(c8);
	  
	  //request.getCookies()[9].getValue():zip code
	  Cookie c9 = new Cookie("zip_code",  String.valueOf(request.getParameter("zip_code")));
	  response.addCookie(c9);
	  
	  //request.getCookies()[10].getValue():telephone
	  Cookie c10 = new Cookie("telephone",  String.valueOf(request.getParameter("telephone")));
	  response.addCookie(c10);
	  
	  
	  
	  //if(this.itemManager.getcountcustomers(request.getCookies()[0].getValue())==0){
	    this.itemManager.add_customers(request.getCookies()[3].getValue(), customer);
	  //}
	  return new ModelAndView("billing1");	
	}
	Map<String, Object> myModel = new HashMap<String, Object>();
	myModel.put("now", now);
	myModel.put("products", this.itemManager);
	myModel.put("cookies0", request.getCookies()[0].getValue());
	return new ModelAndView("shipping", "model", myModel);
  }
  
  public void setItemManager(ItemManager itemManager) {
    this.itemManager = itemManager;
  }
}
