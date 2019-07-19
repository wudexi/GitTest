package com.junit.demo.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.demo.web.action.UserNameAct;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/servlet-context.xml","classpath:/META-INF/spring/root-context.xml"})
public class UserLogin {
	
	@Autowired
 	public RequestMappingHandlerAdapter handlerAdapter;
    
	@Autowired
	public UserNameAct userNameAct;
	
    private static MockHttpServletRequest request;
 
    private static MockHttpServletResponse response;
	
	
	@Test
	public void username() throws Exception {
		/* ApplicationContext app = new GenericXmlApplicationContext("META-INF/spring/root-context.xml");
		 UserNameAct act =  (UserNameAct) app.getBean("userNameAct");
		 System.out.println(act.login());*/
		

		
	}
	
	 
	    @BeforeClass
	    public static void before() {
	        request = new MockHttpServletRequest();
	        request.setCharacterEncoding("UTF-8");
	        response = new MockHttpServletResponse();
	    }
	 
	    @Test
	    public void testList() {
	        request.setRequestURI("/login");
	        request.setMethod(HttpMethod.POST.name());
	        ModelAndView mv = null;
	        try {
	            mv = handlerAdapter.handle(request, response, new HandlerMethod(userNameAct, "login"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        Assert.assertNotNull(mv);
	        Assert.assertEquals(response.getStatus(), 200);
	       // Assert.assertEquals(mv.getViewName(), "/job/job_list");
	    }
}
