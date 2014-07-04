package com.epam.jjp.aop.domain;

public class Marine extends LifeForm {

	public Marine(final String name, final int MAX_HEALTH, final Weapon weapon) {
		super(name, MAX_HEALTH, weapon);

	}

	@Override
	public String toString() {

		return "Marine{" + getName() + ", " + getHealth() + "}";
	}

}
