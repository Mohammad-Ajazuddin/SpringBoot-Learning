package learning.edtex.project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Project1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(Project1Application.class, args);
		
		//It will give error unless Alien class is declared as @Component
		//SpringBoot will take care of instantiation if declared as @Component 
		Alien a = context.getBean(Alien.class);
		
		a.show();
		
		
//		Alien a1 = context.getBean(Alien.class);
//		
//		a1.show();
//		here 2 obs a,a1 but ob created only once bcz of singleton design.(One will be created even if getBean is not called)
// 		if @Scope(Value="prototype") is given then ob created only when getBean is called.
	}

}
