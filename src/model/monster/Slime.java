package model.monster;

import model.hero.Hero;

public class Slime extends Monster {
    public Slime(String name) {
        super(name, 50, 5, 100);
    }

    @Override
    public void attack(Hero hero) {
        System.out.println("Slime " + this.name + " attacks for " + this.damage + " damage.");
        hero.takeDamage(this.damage);
    }
}
