package store.web;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import store.service.SimpleProductManager;
import store.web.HatwomenController;

import junit.framework.TestCase;

public class HatwomenControllerTests extends TestCase{

	@SuppressWarnings("rawtypes")
	public void testHandleRequestView() throws Exception{
	  HatwomenController controller = new HatwomenController();
	  controller.setProductManager(new SimpleProductManager());
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("hatwomen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  Map modelMap = (Map) modelAndView.getModel().get("model");
	  String nowValue = (String) modelMap.get("now");
	  assertNotNull(nowValue);
	}	
}
