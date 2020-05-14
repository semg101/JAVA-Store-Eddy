package store.web;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import store.service.SimpleProductManager;
import store.web.ShoewomenController;

import junit.framework.TestCase;

public class ShoewomenControllerTests extends TestCase{

	@SuppressWarnings("rawtypes")
	public void testHandleRequestView() throws Exception{
	  ShoewomenController controller = new ShoewomenController();
	  controller.setProductManager(new SimpleProductManager());
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("shoewomen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  Map modelMap = (Map) modelAndView.getModel().get("model");
	  String nowValue = (String) modelMap.get("now");
	  assertNotNull(nowValue);
	}	
}
