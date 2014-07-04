package com.epam.jjp.aop.domain;

public class Predator extends LifeForm {

	public Predator(final String name, final int MAX_HEALTH, final Weapon weapon) {
		super(name, MAX_HEALTH, weapon);
	}

	@Override
	public String toString() {

		return "Predator{" + getName() + ", " + getHealth() + "}";
	}

}
