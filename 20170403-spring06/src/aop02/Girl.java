package aop02;

import org.springframework.stereotype.Component;

@Component("girl")
public class Girl implements IPerson {

	@Override
	public String doSomething() {
		System.out.println("TV로 드라마를 본다.");
		// if(1 == 1) throw new FireException("화재발생");
		return "I'm a Girl";
	}
	
}
