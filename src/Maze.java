
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author qw223
 */
public class Maze {

    public final static int Max_Maze_Row = 20;
    public final static int Max_Maze_Col = 50;
    public static Entity[][] maze = new Entity[Max_Maze_Row][Max_Maze_Col];
    private static int mazeRowIndex = 0;

    public static void create(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename + ".txt"));
            String line = "";

            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '*') {
                        maze[mazeRowIndex][i] = new Wall(mazeRowIndex, i);
                    } else if (line.charAt(i) == ' ') {
                        maze[mazeRowIndex][i] = null;
                    }
                }
                mazeRowIndex = mazeRowIndex + 1;
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void display() {
        for (int i = 0; i < Max_Maze_Row; i++) {
            for (int j = 0; j < Max_Maze_Col; j++) {
                if (maze[i][j] == null) {
                    System.out.printf(" ");
                } else {
                    System.out.printf("%s", maze[i][j]);
                }
            }
            System.out.printf("\n");
        }
    }

    public static boolean available(int row, int col) {
        if (row >= Max_Maze_Row || row <= 0 || col >= Max_Maze_Col || col <= 0) {
            return false;
        } else if (maze[row][col] == null) {
            return true;
        } else {
            return false;
        }
    }

}
