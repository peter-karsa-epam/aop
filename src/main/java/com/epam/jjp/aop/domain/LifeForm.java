package com.epam.jjp.aop.domain;

public abstract class LifeForm {
	private final String name;
	private int health;
	private final Weapon weapon;

	public LifeForm(final String name, final int MAX_HEALTH, final Weapon weapon) {
		this.name = name;
		this.health = MAX_HEALTH;
		this.weapon = weapon;
	}

	public int hit(int i) {
		return health -= i;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public boolean isDead() {
		if (health < 1) {
			return true;
		} else {
			return false;
		}
	}

	public Weapon getWeapon() {
		return weapon;
	}

}
