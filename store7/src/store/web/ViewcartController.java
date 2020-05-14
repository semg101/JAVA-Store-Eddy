package store.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
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
	
	if((request.getParameter("action")).matches("add")){
		String product_id = request.getParameter("id");
		this.itemManager.add_cartItem(product_id);
	}
	
	
	
	
	if((request.getParameter("action")).matches("updatedelete")){
		if((request.getParameter("updatedelete")).matches("delete")){
		  String product_id = request.getParameter("id");
		  this.itemManager.delete_cartItem(product_id);
		  
		}
	  
		if(((request.getParameter("updatedelete")).matches("update"))){
		
		  String product_id = request.getParameter("id");
		  String quantity = request.getParameter("quantity");
		  this.itemManager.update_cartItem(product_id, quantity);
		}
		
	}	
	
	
	Map<String, Object> myModel = new HashMap<String, Object>();
	
	//To manage the display of the "checkout" button
	//The "checkout" button will be displayed if and only if there is an item in the cart
	int j=0;
	myModel.put("j", j);
	for (Item t : this.itemManager.getItems()) {
		if(t.getSex()=="men"){
			j=j+1;
		}else if(t.getSex()=="women"){
			j=j+2;
		}
		
		myModel.put("j", 1);
	}
	 
	
	myModel.put("one", 1);
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
    HttpSession session = request.getSession();//session.getCreationTime(); session.hashCode()
    session.setAttribute("user_session_id", session.getCreationTime());
	myModel.put("session", session.getAttribute("user_session_id"));//return:long
	myModel.put("items", this.itemManager.getItems());
	
	return new ModelAndView("viewcart", "model", myModel);
  }
  
  public void setItemManager(ItemManager itemManager) {
    this.itemManager = itemManager;
  }
}
