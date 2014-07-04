package com.epam.jjp.aop.domain;

import java.util.Random;

public class Weapon {
	private final int damage;
	private Random rnd;

	public Weapon(final int damage) {
		this.damage = damage;
	}

	public String damage(LifeForm target) {
		rnd = new Random();
		if (target.hit(rnd.nextInt(damage) + 1) == 0) {
			return "Missed";
		} else {
			return target.getName() + " was hit";
		}
	}
}
