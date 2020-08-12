
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author qw223
 */
public class HungrySquirrelGame {

    public static void main(String[] args) {
        Maze.create("Maze");

        Squirrel s = new Squirrel();
        s.create();

        createNuts();
        Maze.display();

        movements(s);

        s.getSocre();
    }

    public static void createSquirrel() {
        Squirrel s = new Squirrel();
        s.create();
    }

    public static void createNuts() {
        Nut[] nuts = new Nut[Nut.totalNuts];
        for (int i = 0; i < nuts.length; i++) {
            double randNut = Math.random();
            if (randNut > 0.5) {
                nuts[i] = new Peanut();
                nuts[i].create();
            } else {
                nuts[i] = new Almond();
                nuts[i].create();
            }
        }
    }

    public static void movements(Squirrel s) {
        while (s.totalNutsEaten < 5) {
            System.out.println("Which direction to go (u,d,l,r or QUIT): ");
            Scanner input = new Scanner(System.in);
            if (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.length() > 0) {
                    if (line.equalsIgnoreCase("QUIT")) {
                        System.out.println("User quits game.");
                        break;
                    } else {
                        char orient = Character.toLowerCase(line.charAt(0));
                        if (orient == 'r' || orient == 'l' || orient == 'u' || orient == 'd') {
                            s.move(orient);
                        } else {
                            System.out.println("Invalid command. Try again!");
                        }

                        Maze.display();
                    }
                } else {
                    System.out.println("Invalid command. Try again!");
                }
            }
        }
        if (s.totalNutsEaten == 5)
        System.out.println("Squirrel successfully collected all the nuts.");
    }
}
