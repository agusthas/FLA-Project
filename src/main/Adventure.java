package main;

import model.Team;
import model.factory.MonsterFactory;
import model.hero.Hero;
import model.monster.Monster;
import util.FileHandler;
import util.Util;

import java.util.List;

public class Adventure {
    Team team;
    FileHandler fileHandler = FileHandler.getInstance();

    public Adventure(Team team) {
        this.team = team;
    }

    public void start() {
        introduction();
        Util.clearScreen();
        System.out.println("Starting adventure with team: " + this.team.getName());
        System.out.println("========================================");
        List<Hero> heroes = this.team.getHeroes();
        for (Hero hero : heroes) {
            System.out.println(hero.getName());
        }
        System.out.println("========================================");

        // Game loop
        int maxGameLoop = Util.randInt(3, 5);
        for (int gameLoop = 0; gameLoop < maxGameLoop; gameLoop++) {
            Monster monster = MonsterFactory.generateRandomMonster();
            System.out.println("A wild " + monster.getName() + " appeared!");

            // Prompt user to select a hero
            int heroIndex;
            do {
                System.out.println("Select a hero to attack the monster:");
                for (int i = 0; i < heroes.size(); i++) {
                    System.out.println((i + 1) + ". " + heroes.get(i).getName() + " (" + heroes.get(i).getHealth() + " HP)");
                }
                heroIndex = Util.readInteger() - 1;
            } while (heroIndex < 0 || heroIndex >= heroes.size());
            Hero hero = heroes.get(heroIndex);

            // Battle loop
            while (hero.getHealth() > 0 && monster.getHealth() > 0) {
                try {
                    Thread.sleep(1000);
                    hero.attack(monster);
                    if (monster.getHealth() <= 0) {
                        System.out.println("Monster defeated!");
                        team.addPoints(monster.getPoints());
                        break;
                    }
                    monster.attack(hero);
                    if (hero.getHealth() <= 0) {
                        System.out.println("Hero defeated!");
                        team.removeHero(hero);
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!team.isAlive()) {
                gameOver();
                break;
            }
        }
        end();
    }

    private void introduction() {
        List<String> lines = List.of(
                "All begin with a simple story...",
                "Once upon a time...",
                "There was a team of heroes with a powerful ambition...",
                "An ambition to get a good grades in `Framework Layer Architecture` course...",
                "They were ready to fight for it...",
                "They were ready to fight for their dreams...",
                "They were ready to fight for their future...",
                "They know the path is not an easy one...",
                "This is the story of their adventure..."
        );
        // Make the line appears one by one with a delay of n milliseconds
        // Use Thread.sleep(n) to delay the execution of the next line
        // Use System.out.println(line) to print the line
        lines.forEach(line -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(line);
        });
    }

    private void gameOver() {
        fileHandler.appendLine("Team [" + this.team.getName() + "], Points: [" + this.team.getPoints() + "] --- Game Over\n");
        System.out.println("Game Over!");
    }

    private void end() {
        fileHandler.appendLine("Team [" + this.team.getName() + "], Points: [" + this.team.getPoints() + "] --- End of the adventure\n");
        Util.clearScreen();
        List<String> lines = List.of(
                "And so the adventure ended...",
                "The heroes returned home...",
                "The villagers echoed their names...",
                "The heroes were celebrated...",
                "But the heroes knew...",
                "This is not enough until they have truly achieved their ambition...",
                "This is not the end of their story...",
                "This is not the end of their adventure...",
                "This is just the beginning...",
                "The end."
        );
        lines.forEach(line -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(line);
        });
    }
}
