package model.hero;

import model.monster.Monster;
import util.Util;

public class Archer extends Hero {
    public Archer(String name) {
        super(name, 50, 30);
    }

    @Override
    public void attack(Monster monster) {
        if (isMiss()) {
            System.out.println("Archer " + this.name + " attacks " + monster.getName() + " for " + this.damage + " damage.");
            monster.takeDamage(this.damage);
        } else {
            System.out.println("Archer " + this.name + " misses " + monster.getName() + ".");
        }
    }

    private boolean isMiss() {
        return Util.randInt(0, 100) > 30; // 30% chance to miss
    }
}
