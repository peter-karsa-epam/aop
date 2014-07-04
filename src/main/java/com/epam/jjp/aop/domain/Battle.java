package com.epam.jjp.aop.domain;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class Battle {
	private final String name;
	private final Planet planet;
	private List<LifeForm> marines;
	private List<LifeForm> aliens;
	private List<LifeForm> predators;
	private static Logger LOGGER = Logger.getAnonymousLogger();

	public Battle(final String name, final List<LifeForm> marines,
			final List<LifeForm> aliens, final List<LifeForm> predators,
			Planet planet) {
		this.name = name;
		this.planet = planet;
		this.marines = marines;
		this.aliens = aliens;
		this.predators = predators;

	}

	public void start() {
		fight();
	}

	//@Before("execution(* com.epam.jjp.aop.aspects.AspectLogObject.BeforeMethod(..))")
	//@After("execution(* com.epam.jjp.aop.aspects.AspectLogObject.AfterMethod(..))")
	private boolean fightRound(List<LifeForm> offense, List<LifeForm> defense) {
		boolean eliminated = false;
		for (int i = 0; i < offense.size(); i++) {
			if (i < defense.size()) {
				LOGGER.info(offense.get(i).getWeapon().damage(defense.get(i)));
			} else {
				break;
			}
		}

		for (int j = 0; j < defense.size(); j++) {
			if (defense.get(j).isDead()) {
				defense.remove(j);
			}
		}

		if (defense.size() < 1) {
			eliminated = true;
		}

		return eliminated;
	}

	boolean marineEliminated = false;
	boolean aliensEliminated = false;
	boolean predatorsEliminated = false;

	private void fight() {
		while (!oneCorpStanding()) {
			marineEliminated = fightRound(aliens, marines);
			aliensEliminated = fightRound(marines, aliens);
			predatorsEliminated = fightRound(aliens, predators);
			aliensEliminated = fightRound(predators, aliens);
			marineEliminated = fightRound(predators, marines);
			predatorsEliminated = fightRound(marines, predators);
		}
	}

	private boolean oneCorpStanding() {
		int countTrues = 0;
		if (marineEliminated) {
			countTrues++;
		}
		if (aliensEliminated) {
			countTrues++;
		}
		if (predatorsEliminated) {
			countTrues++;
		}

		return countTrues == 2;
	}

	public String getName() {
		return name;
	}

	public Planet getPlanet() {
		return planet;
	}

	public List<LifeForm> getMarines() {
		return marines;
	}

	public List<LifeForm> getAliens() {
		return aliens;
	}

	public List<LifeForm> getPredators() {
		return predators;
	}

	public String getWinnerCorp() {
		String winner = "There has been something else...";

		if (!marineEliminated) {
			winner = "Marines won at " + this.getPlanet();
		}
		if (!aliensEliminated) {
			winner = "Aliens won at " + this.getPlanet();
		}
		if (!predatorsEliminated) {
			winner = "Predators won at " + this.getPlanet();
		}

		return winner;
	}

}
