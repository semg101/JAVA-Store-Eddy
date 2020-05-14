package store.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import store.domain.Customer;
import store.service.ItemManager;

public class ShippingController extends SimpleFormController {
	
  private ItemManager itemManager;
  
  
  public ShippingController() { 
    setCommandClass(Customer.class);
    setCommandName("customer");
    setFormView("shipping");
  }

  protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    System.out.println(getCommandName()); 
    this.itemManager.add_customers(request.getCookies()[0].getValue(), (Customer)command);
    this.itemManager.add_customers();
    
    
    return new ModelAndView(new RedirectView(getSuccessView()));
  }
  
  public void setItemManager(ItemManager itemManager) {
    this.itemManager = itemManager;
  }
}