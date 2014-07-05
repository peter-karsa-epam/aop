package com.epam.jjp.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.jjp.aop.domain.Battle;

/**
 * Hello world!
 * 
 */
public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");

		Battle newBattle = context.getBean("battleOuterRim", Battle.class);
		newBattle.start();
		newBattle.getWinnerCorp();
	}
}
