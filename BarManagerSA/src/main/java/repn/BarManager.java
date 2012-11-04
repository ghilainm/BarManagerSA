package repn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BarManager {

	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
			
		context.getBean(Test.class).test();
	}

}
