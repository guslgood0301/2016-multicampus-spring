package aop01;

import org.springframework.stereotype.Component;

@Component("boy")
public class Boy implements IPerson {

	@Override
	public String doSomething() {
		System.out.println("컴퓨터로 게임을 한다.");
		return "I'm a Boy";
	}
	
}
