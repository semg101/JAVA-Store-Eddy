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
	myModel.put("now", now);
	myModel.put("sex", "men");
	myModel.put("sex2", "women");
	myModel.put("categoryid1", 1);
	myModel.put("categoryid2", 2);
	myModel.put("categoryid3", 3);
	myModel.put("categoryid4", 4);
	myModel.put("categoryid5", 5);
	myModel.put("param", request.getParameter("id"));
	myModel.put("param_action", request.getParameter("action"));
	myModel.put("items", this.itemManager.getItems());
	return new ModelAndView("viewcart", "model", myModel);
  }
  
  public void setItemManager(ItemManager itemManager) {
    this.itemManager = itemManager;
  }
}
