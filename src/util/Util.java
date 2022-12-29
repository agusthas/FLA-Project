package util;

import java.util.Scanner;

public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static int readInteger() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public static Integer randInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
