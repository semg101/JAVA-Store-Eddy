package store.web;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import store.service.SimpleProductManager;
import store.web.TeeshirtmenController;

import junit.framework.TestCase;

public class TeeshirtmenControllerTests extends TestCase{

	@SuppressWarnings("rawtypes")
	public void testHandleRequestView() throws Exception{
	  TeeshirtmenController controller = new TeeshirtmenController();
	  controller.setProductManager(new SimpleProductManager());
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("teeshirtmen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  Map modelMap = (Map) modelAndView.getModel().get("model");
	  String nowValue = (String) modelMap.get("now");
	  assertNotNull(nowValue);
	}	
}
