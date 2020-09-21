
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
public class Squirrel extends Entity implements Movable {

    protected int pointsCollected = 0;
    protected int totalNutsEaten = 0;

    public Squirrel() {
        symbol = "@";
    }

    public void create() {
        boolean isValid = false;
        int inputR = 0;
        int inputC = 0;

        do {
            System.out.println("Enter the Squirrel position (row , column): ");
            Scanner input = new Scanner(System.in);
            if (input.hasNextLine()) {
                String line = input.nextLine();
                String[] coordinate = line.split(",");
                if (coordinate.length == 2) {
                    inputR = Integer.parseInt(coordinate[0].trim());
                    inputC = Integer.parseInt(coordinate[1].trim());
                    if (Maze.available(inputR, inputC)) {
                        System.out.println("User input accepted.");
                        isValid = true;
                    } else {
                        System.out.println("Invalid position. Enter again!");
                        isValid = false;
                    }
                } else {
                    System.out.println("Invalid position. Enter again!");
                    isValid = false;
                }
            }
        } while (isValid == false);
        this.put(inputR, inputC);
    }

    @Override
    public void move(char direction) {
        int newRow = row;
        int newCol = column;

        switch (direction) {
            case 'r':
                newCol = column + 1;
                break;
            case 'l':
                newCol = column - 1;
                break;
            case 'u':
                newRow = row - 1;
                break;
            case 'd':
                newRow = row + 1;
                break;
        }

        Maze.maze[row][column] = null;
        Entity e = this.put(newRow, newCol);

        if (e instanceof Nut) {
            pointsCollected = pointsCollected + ((Nut) e).NutritionPoints;
            totalNutsEaten++;
        }
    }

    public void getSocre() {
        System.out.println("Total points: " + pointsCollected + "\n"
                + "Total nuts collected: " + totalNutsEaten);
    }
}
