/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qw223
 */
public abstract class Nut extends Entity {

    public static final int totalNuts = 5;
    protected int NutritionPoints = 0;
    protected String Name;

    @Override
    public void create() {
        while(true){
            int randRow = (int) (Math.random() * Maze.Max_Maze_Row + 1);
            int randCol = (int) (Math.random() * Maze.Max_Maze_Col + 1);
            
            if (Maze.available(randRow, randCol)){
                this.put(randRow, randCol);
                
                break;
            }
        }   
    }

}
