/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qw223
 */
public abstract class Entity {

    protected String symbol;
    protected int row;
    protected int column;

    public Entity put(int newRow, int newCol) {
        Entity o = Maze.maze[newRow][newCol];
        if (o instanceof Wall) {
            row = row;
            column = column;
        } else {
            row = newRow;
            column = newCol;
        }
        Maze.maze[row][column] = this;
        return o;

    }

    public abstract void create();

    @Override
    public String toString() {
        return symbol;
    }
}
