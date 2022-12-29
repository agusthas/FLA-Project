package model.hero;

import model.monster.Monster;

public abstract class Hero {
    protected String name;
    protected Integer health;
    protected Integer damage;

    public Hero(String name, Integer health, Integer damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public abstract void attack(Monster monster);

    public void takeDamage(Integer damage) {
        this.health -= damage;
    }

    public String getName() {
        return this.name;
    }

    public Integer getHealth() {
        return this.health;
    }
}
