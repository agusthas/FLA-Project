package model;

import model.hero.Hero;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final List<Hero> heroes;
    private Integer points;

    private Team(String name, List<Hero> heroes) {
        this.name = name;
        this.heroes = heroes;
        this.points = 0;
    }

    public String getName() {
        return this.name;
    }

    public final List<Hero> getHeroes() {
        return this.heroes;
    }

    public void removeHero(Hero hero) {
        this.heroes.remove(hero);
    }

    public void addPoints(Integer points) {
        this.points += points;
    }

    public Integer getPoints() {
        return this.points;
    }

    public boolean isAlive() {
        return this.heroes.size() > 0;
    }

    public static class TeamBuilder {
        private final String name;
        private final List<Hero> heroes;

        public TeamBuilder(String name) {
            this.name = name;
            this.heroes = new ArrayList<>();
        }

        public TeamBuilder addHero(Hero hero) {
            this.heroes.add(hero);
            return this;
        }

        public final Team build() {
            return new Team(this.name, this.heroes);
        }
    }
}
