package model.monster;

import model.hero.Hero;

public abstract class Monster {
    protected String name;
    protected Integer health;
    protected Integer damage;
    protected Integer points;

    public Monster(String name, Integer health, Integer damage, Integer points) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.points = points;
    }

    public abstract void attack(Hero hero);

    public void takeDamage(Integer damage) {
        this.health -= damage;
    }

    public String getName() {
        return this.name;
    }

    public Integer getHealth() {
        return this.health;
    }

    public Integer getPoints() {
        return this.points;
    }
}
