package model.factory;

import model.monster.Dragon;
import model.monster.Goblin;
import model.monster.Monster;
import model.monster.Slime;

public class MonsterFactory {
    public static Monster generateRandomMonster() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                return new Goblin("Green");
            case 1:
                return new Dragon("Blue Eyes White Dragon");
            default:
                return new Slime("Slimey");
        }
    }
}
