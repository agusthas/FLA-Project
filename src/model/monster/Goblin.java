package model.monster;

import model.hero.Hero;

public class Goblin extends Monster {
    public Goblin(String name) {
        super(name, 50, 15, 200);
    }

    @Override
    public void attack(Hero hero) {
        System.out.println("Goblin " + this.name + " attacks " + hero.getName() + " for " + this.damage + " damage.");
        hero.takeDamage(this.damage);
    }
}
