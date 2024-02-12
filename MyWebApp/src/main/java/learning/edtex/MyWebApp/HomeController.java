package learning.edtex.MyWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
//	@RequestMapping("home")
//	public String homeRequest()
//	{
//		System.out.println("Home Request accepted");
//		return "home.jsp";
//	}
	
//Ex of keeping file in other than webapp folder. And changing config in app.props to handle this
//	@RequestMapping("page2")
//	public String handlePage2()
//	{
//		return "page2";
//	}
	
	//receiving data from client url getrequest. Using servelet obj here to capture that data
//	@RequestMapping("home")
//	public String homeRequest(HttpServletRequest req)
//	{
//		HttpSession session = req.getSession();
//		String name = req.getParameter("name");
//		System.out.println("Home Request accepted");
//		System.out.println("Field received is "+name);
//		session.setAttribute("name", name);
//		return "home.jsp";
//	}
	
// Directly using the HttpSession from spring, String name gets match directly with the key "name" 
//	@RequestMapping("home")
//	public String homeRequest(String name, HttpSession session)
//	{
//		System.out.println("Home Request accepted");
//		System.out.println("Field received is "+name);
//		session.setAttribute("name", name);
//		return "home.jsp";
//	}
	
//  using @REquestParam("parameter name") when var name diff and when there are multiple parameters
//	@RequestMapping("home")
//	public String homeRequest(@RequestParam("name") String Myname, HttpSession session)
//	{
//		System.out.println("Home Request accepted");
//		System.out.println("Field received is "+Myname);
//		session.setAttribute("name", Myname);
//		return "home.jsp";
//	}
	
	
//Using directly the class ModelAndView of Spring MVC
//Data is Model and view is here "home" we can directly send model and view
// no need session now
	
	@RequestMapping("home")
	public ModelAndView homeRequest(@RequestParam("name") String Myname)
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("Home Request accepted");//on console
		mv.addObject("name",Myname);
		mv.setViewName("home.jsp");
		System.out.println("Field received is "+Myname);//on console
		return mv;
	}

}