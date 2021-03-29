package aop02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("aop02/applicationContext.xml");
		IPerson person = context.getBean("girl", IPerson.class);
		try { person.doSomething(); } catch(Exception e) {}
	}
	
	
}
