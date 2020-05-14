package store.web;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import store.service.SimpleProductManager;
import store.web.ShoemenController;

import junit.framework.TestCase;

public class ShoemenControllerTests extends TestCase{

	@SuppressWarnings("rawtypes")
	public void testHandleRequestView() throws Exception{
	  ShoemenController controller = new ShoemenController();
	  controller.setProductManager(new SimpleProductManager());
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("shoemen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  Map modelMap = (Map) modelAndView.getModel().get("model");
	  String nowValue = (String) modelMap.get("now");
	  assertNotNull(nowValue);
	}	
}
