/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qw223
 */
public class Wall extends Entity {
    protected final int row;
    protected final int column;
    
    
    public Wall(int row, int column){
        this.row = row;
        this.column = column;
        symbol = "*";
    }
    
    @Override
    public void create(){
    }
}
