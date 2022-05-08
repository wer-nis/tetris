/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figures;

import board.Board;

/**
 *
 * @author pipe
 */
public class O implements Figure {

    private int[][] O = {{2, 2}, {2, 2}};
    private int posX = 4;
    private int posY = 1;

    @Override
    public int[][] getFigure() {
        return this.O;
    }

    @Override
    public void create(Board board) {
        int y = this.posY;
        int x = this.posX;

        board.setCell(y - 1, x, 2);
        board.setCell(y - 1, x + 1, 2);
        board.setCell(y, x, 2);
        board.setCell(y, x + 1, 2);
    }

    @Override
    public boolean turnRight(Board board) {
        return true;
    }

    @Override
    public boolean canTurnRight(Board board) {
        return true;
    }

    @Override
    public boolean turnLeft(Board board) {
        return true;
    }

    @Override
    public boolean canTurnLeft(Board board) {
        return true;
    }

    @Override
    public boolean down(Board board) {
        boolean can = false;
        
        int y = this.posY;
        int x = this.posX;
        
        if(this.canDown(board)){
            board.setCell(y-1, x, 0);
            board.setCell(y-1, x+1, 0);
            
            board.setCell(y+1, x, 2);
            board.setCell(y+1, x+1, 2);
            
            can = true;
            
            this.setPosY(y+1);
        }else{
            return can;
        }
        
        return can;
    }

    @Override
    public boolean canDown(Board board) {
        boolean can = false; 
        
        int y = this.posY;
        int x = this.posX;
        
        if(y < 21 &&  board.getCell(y+1, x) == 0 && board.getCell(y+1, x+1) == 0 ){
            can = true;
        }else{
            return can;
        }
        return can;
        
    }

    @Override
    public boolean moveRight(Board board) {
        boolean can = false;
        
        int y = this.posY;
        int x = this.posX;
        
        if(this.canMoveRight(board)){
            board.setCell(y, x, 0);
            board.setCell(y-1, x, 0);
            
            
            board.setCell(y, x+2, 2);
            board.setCell(y-1, x+2, 2);
            
            can = true;
            
            this.setPosX(x+1);
        }else{
            return can;
        }
        
        return can;
    }

    @Override
    public boolean canMoveRight(Board board) {
        boolean can = false; 
        
        int y = this.posY;
        int x = this.posX;
        
        if(x < 8 &&  board.getCell(y, x+2) == 0 && board.getCell(y-1, x+2) == 0 ){
            can = true;
        }else{
            return can;
        }
        return can;
    }

    @Override
    public boolean moveLeft(Board board) {
        boolean can = false;
        
        int y = this.posY;
        int x = this.posX;
        
        if(this.canMoveLeft(board)){
            board.setCell(y, x+1, 0);
            board.setCell(y-1, x+1, 0);
            
            
            board.setCell(y, x-1, 2);
            board.setCell(y-1, x-1, 2);
            
            can = true;
            
            this.setPosX(x-1);
        }else{
            return can;
        }
        
        return can;
    }

    @Override
    public boolean canMoveLeft(Board board) {
        boolean can = false; 
        
        int y = this.posY;
        int x = this.posX;
        
        if(x > 0 &&  board.getCell(y, x-1) == 0 && board.getCell(y-1, x-1) == 0 ){
            can = true;
        }else{
            return can;
        }
        return can;
    }

    public int[][] getO() {
        return O;
    }

    public void setO(int[][] O) {
        this.O = O;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

}
