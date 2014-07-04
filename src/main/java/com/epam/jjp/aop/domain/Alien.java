package com.epam.jjp.aop.domain;

public class Alien extends LifeForm {

	public Alien(final String name, final int MAX_HEALTH, final Weapon weapon) {
		super(name, MAX_HEALTH, weapon);
	}

	@Override
	public String toString() {

		return "Alien{" + getName() + ", " + getHealth() + "}";
	}

}
