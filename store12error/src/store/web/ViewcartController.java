package store.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.domain.Item;
import store.service.ItemManager;

public class ViewcartController implements Controller{
  
  protected final Log logger = LogFactory.getLog(getClass());
  
  private ItemManager itemManager;

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException {
    String now = (new Date()).toString();
	logger.info("Returning viewcart view with " + now);
	//return new ModelAndView("viewcart", "now", now);
	//String parameter_id = request.getParameter("id");
	//String parameter_action = request.getParameter("action");
	
	//We are going to create a permanent session that will last a month
    Object user_session_id;
    //Map<String, Object> persistent_session = new HashMap<String, Object>();
	if(request.getCookies()==null){
	  //Session
      HttpSession session = request.getSession();//session.getCreationTime(); session.hashCode()
      session.setAttribute("user_session_id", session.getCreationTime());
      user_session_id = session.getAttribute("user_session_id");
      //persistent_session.put("session", user_session_id);//return:long
    
	  //Create a cookie
      Cookie c = new Cookie("userID",  String.valueOf(user_session_id));
      //Cookie c = new Cookie("userID",  String.valueOf(persistent_session.get("session")));
	  c.setMaxAge(60*60*24*30); //The cookie will expire within one month
      response.addCookie(c);  //Sent the cookie to the browser
	
	}else{
		user_session_id = request.getCookies()[0].getValue();
		//persistent_session.put("session", user_session_id);//return:long
		
	}
	
	
	
	
	
	//To add an item in the cart
	if((request.getParameter("action")).matches("add")){
		String product_id = request.getParameter("id");
		this.itemManager.add_cartItem(product_id, user_session_id);
	}
	
    //To update or delete an item in the cart
	if((request.getParameter("action")).matches("updatedelete")){
		//To delete an item in the cart
		if((request.getParameter("updatedelete")).matches("delete")){
		  String product_id = request.getParameter("id");
		  this.itemManager.delete_cartItem(product_id, user_session_id);
		  
		}
	    
		//To update an item the cart
		if(((request.getParameter("updatedelete")).matches("update"))){
		
		  String product_id = request.getParameter("id");
		  String quantity = request.getParameter("quantity");
		  this.itemManager.update_cartItem(product_id, quantity, user_session_id);
		}
		
	}	
	
	//The number of items of a particular user
	int numberofitems = this.itemManager.user_items(user_session_id);
	
	
	Map<String, Object> myModel = new HashMap<String, Object>();
	
	//To manage the display of the "checkout" button
	//The "checkout" button will be displayed if and only if there is an item in the cart
	int j=0;
	myModel.put("j", j);
	for (Item t : this.itemManager.getItems(user_session_id)) {
		if(t.getSex()=="men"){
			j=j+1;
		}else if(t.getSex()=="women"){
			j=j+2;
		}
		
		myModel.put("j", 1);
	}
	 
	
	myModel.put("numberofitems", numberofitems);
	myModel.put("one", 1);
	myModel.put("c", 1);
	myModel.put("now", now);
	myModel.put("message", "");
	myModel.put("sex", "men");
	myModel.put("sex2", "women");
	myModel.put("categoryid1", 1);
	myModel.put("categoryid2", 2);
	myModel.put("categoryid3", 3);
	myModel.put("categoryid4", 4);
	myModel.put("categoryid5", 5);
	myModel.put("param", request.getParameter("id"));
	myModel.put("param_action", request.getParameter("action"));
	
	myModel.put("cookies", request.getCookies());//return:Cookie[]
	myModel.put("user_session_id", user_session_id);
	myModel.put("cookies2", request.getCookies()[0].getValue());//return:long session.getAttribute("user_session_id")
	
	myModel.put("items", this.itemManager.getItems(user_session_id));
	
	return new ModelAndView("viewcart", "model", myModel);
  }
  
  public void setItemManager(ItemManager itemManager) {
    this.itemManager = itemManager;
  }
}
