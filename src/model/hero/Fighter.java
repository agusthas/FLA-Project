package model.hero;

import model.monster.Monster;

public class Fighter extends Hero {

    public Fighter(String name) {
        super(name, 100, 10);
    }

    @Override
    public void attack(Monster monster) {
        System.out.println("Fighter " + this.name + " attacks " + monster.getName() + " for " + this.damage + " damage.");
        monster.takeDamage(this.damage);
    }
}
