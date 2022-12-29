package model.monster;

import model.hero.Hero;

public class Dragon extends Monster {
    public Dragon(String name) {
        super(name, 200, 50, 1000);
    }

    @Override
    public void attack(Hero hero) {
        System.out.println("Dragon " + this.name + " attacks " + hero.getName() + " for " + this.damage + " damage.");
        hero.takeDamage(this.damage);
    }
}
