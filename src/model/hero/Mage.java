package model.hero;

import model.monster.Monster;

public class Mage extends Hero {
    private Integer mana;

    public Mage(String name) {
        super(name, 50, 20);
        this.mana = 100;
    }

    public void chargeMana() {
        this.mana += 10;
        System.out.println("Mage " + this.name + " charges mana. Mana: " + this.mana);
    }

    @Override
    public void attack(Monster monster) {
        chargeMana();
        if (this.mana >= 20) {
            System.out.println("Mage " + this.name + " attacks " + monster.getName() + " for " + this.damage + " damage.");
            monster.takeDamage(this.damage);
            this.mana -= 20;
        } else {
            System.out.println("Mage " + this.name + " does not have enough mana to attack.");
        }
    }
}
