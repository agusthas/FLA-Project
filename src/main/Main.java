package main;

import model.Team;
import model.hero.Archer;
import model.hero.Fighter;
import model.hero.Mage;
import util.FileHandler;
import util.Util;

import java.util.List;

public class Main {
    private static Team seedTeam() {
        return new Team.TeamBuilder("Group 1")
                .addHero(new Mage("Made"))
                .addHero(new Fighter("Fadim"))
                .addHero(new Archer("Velencia"))
                .build();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the game!");
            System.out.println("1. Start adventure");
            System.out.println("2. Print previous adventure");
            System.out.println("3. Exit");
            int choose = Util.readInteger();
            switch (choose) {
                case 1:
                    Util.clearScreen();
                    Adventure adventure = new Adventure(seedTeam());
                    adventure.start();
                    return;
                case 2:
                    FileHandler fileHandler = FileHandler.getInstance();
                    List<String> lines = fileHandler.readLines();
                    if (lines == null) {
                        System.out.println("No previous adventure found!");
                    } else {
                        System.out.println("Previous adventure:");
                        for (String line : lines) {
                            System.out.println("\t" + line);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}