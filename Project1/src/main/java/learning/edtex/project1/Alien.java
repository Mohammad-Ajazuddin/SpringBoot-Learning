package learning.edtex.project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value="prototype") prototype design not singleton
public class Alien {
	private int aid;
	private String aname;
	private String tech;
	
	@Autowired			// checks for type laptop
//	@Qualifier("MyLap")  // checks for name MyLap
	private Laptop laptop;
	
	Alien()
	{
		System.out.println("Object Created");
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	public void show()
	{
		System.out.println("In show");
		laptop.compile();//This will give error as laptop must be instantiated. Though we declare @Component
					//SB takes care of instantiation. But alien class dependent on laptop. But it doesnt know abt this obj
			//we should tell it to look for laptop obj, by using @Autowired annotation for laptop obj in alien class 
	}
}
