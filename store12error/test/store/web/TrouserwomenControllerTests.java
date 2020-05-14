package store.web;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import store.service.SimpleProductManager;
import store.web.TrouserwomenController;

import junit.framework.TestCase;

public class TrouserwomenControllerTests extends TestCase{

	@SuppressWarnings("rawtypes")
	public void testHandleRequestView() throws Exception{
	  TrouserwomenController controller = new TrouserwomenController();
	  controller.setProductManager(new SimpleProductManager());
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("trouserwomen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  Map modelMap = (Map) modelAndView.getModel().get("model");
	  String nowValue = (String) modelMap.get("now");
	  assertNotNull(nowValue);
	}	
}
