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
public class I implements Figure{
    
    private int[][] I ={{1,1,1,1}};
    
    private int state = 0;
    private int posX = 3;
    private int posY = 1;
  
    @Override
    public void create(Board board ) {
        if(this.canPut(board)){
            for (int i = 3; i < 7 ; i++) {
                    board.setCell(1, i, 1);
            }
        }
    }
    
    private boolean canPut(Board board){
        boolean can = true;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                if(board.getCell(i, j) != 0){
                    return false;
                }
            }
        }
        return can;
    }
    
    @Override
    public int[][] getFigure (){
        return this.I;
    }
    @Override
    public boolean turnRight (Board board){
        boolean can = true;
        
        int y = this.getPosY();
        int x = this.getPosX();
        if(this.getState() == 0 && this.canTurnRight(board) ){
            board.setCell(y, x, 0);
            board.setCell(y, x+2, 0);
            board.setCell(y, x+3, 0);
            
            board.setCell(y-1, x+1, 1);
            board.setCell(y+1, x+1, 1);
            board.setCell(y+2, x+1, 1);
            
            this.setState(1);
            this.setPosY(y+2);
            this.setPosX(x+1);
            
        }
        else if(this.canTurnRight(board) && this.getState() == 1){
            board.setCell(y, x, 0);
            board.setCell(y-1, x, 0);
            board.setCell(y-3, x, 0);
            
            board.setCell(y-2, x-2, 1);
            board.setCell(y-2, x-1, 1);
            board.setCell(y-2, x+1, 1);
            
            this.setState(0);
            this.setPosX(x-2);
            this.setPosY(y-2);
        }        
        else{
            return false;
        }
        return can;
    }
    
    @Override
    public boolean canTurnRight (Board board){
        boolean can = true;
        int y = this.getPosY();
        int x = this.getPosX();
        
        if(this.getState() == 0 && y < 20){
            if(board.getCell(y-1, x+1) != 0 ||
               board.getCell(y+1, x+1)!=0 ||
               board.getCell(y+2, x+1)!=0){
                return false;
            }
        }
        else if(this.getState() == 1 && x > 1 && x < 7){
           if(board.getCell(y-2, x-2) != 0 ||
              board.getCell(y-2, x-1)!=0 ||
              board.getCell(y-2, x+1)!=0){
               return false;
           }
        }
        else{
            return false;
        }
        
        return can;
    }
    
    @Override
    public boolean turnLeft(Board board){
        boolean can = true;
        
        int y = this.getPosY();
        int x = this.getPosX();
        
        if(canTurnLeft(board) && this.getState() == 0){
            board.setCell(y, x, 0);
            board.setCell(y, x+1, 0);
            board.setCell(y, x+3, 0);
            
            board.setCell(y-1, x+2, 1);
            board.setCell(y+1, x+2, 1);
            board.setCell(y+2, x+2, 1);
            
            this.setState(1);
            this.setPosY(y+2);
            this.setPosX(x+2);
        }
        else if(canTurnLeft(board) && this.getState() == 1){
            board.setCell(y, x, 0);
            board.setCell(y-1, x, 0);
            board.setCell(y-3, x, 0);
            
            board.setCell(y-2, x-1, 1);
            board.setCell(y-2, x+1, 1);
            board.setCell(y-2, x+2, 1);
            
            this.setState(0);
            this.setPosY(y-2);
            this.setPosX(x-1);
        }
        else{
            return false;
        }
        
        return can;
    }
    
    @Override
    public boolean canTurnLeft(Board board){
        boolean can = true;
        
        int y = this.getPosY();
        int x = this.getPosX();
        
        if(this.getState() == 0 && y < 20){
            if(board.getCell(y-1, x+2) != 0 &&
               board.getCell(y+1, x+2) != 0 &&
               board.getCell(y+2, x+2) != 0 ){
                return false;
            }
        }
        else if(this.getState() == 1 && x >1 && x < 8){
            if(board.getCell(y-2, x-1) != 0 &&
               board.getCell(y-2, x+1) != 0 &&
               board.getCell(y-2, x+2) != 0 ){
                return false;
            }
        }
        else{
            return false;
        }
        
        return can;
    }
    
    @Override
    public boolean down (Board board){
        boolean can = true;
        
        int x = this.getPosX();
        int y = this.getPosY();
        
        if(this.getState() == 0){
            if(this.canDown(board)){
                board.setCell(y, x, 0);
                board.setCell(y, x+1, 0);
                board.setCell(y, x+2, 0);
                board.setCell(y, x+3, 0);
                
                board.setCell(y+1, x, 1);
                board.setCell(y+1, x+1, 1);
                board.setCell(y+1, x+2, 1);
                board.setCell(y+1, x+3, 1);
                
                this.setPosY(y+1);
            }
            else{
                return false;
            }
        }
        else{
            if(this.canDown(board)){
            
                board.setCell(y-3, x, 0);
            
                board.setCell(y+1, x, 1);
            
                this.setPosY(y+1);
            }
            else{
                return false;
            }
        }
        
        return can;
    }
    
    @Override
    public boolean canDown(Board board){
        boolean can = true;
        
        int x = this.getPosX();
        int y = this.getPosY();
        
        if(this.getState() == 0 && y < 21){
            if(board.getCell(y+1, x) != 0 || 
               board.getCell(y+1, x+1) != 0 ||
               board.getCell(y+1, x+2) != 0 ||
               board.getCell(y+1, x+3) != 0){
                return false;
            }
        }
        else if(this.getState() == 1 && y < 21){
            if(board.getCell(y+1, x) != 0){
                return false;
            }
        }
        else{
            return false;
        }
        
        return can;
    }
    
    @Override
    public boolean moveRight(Board board){
        boolean can = true;
        
        int y = this.getPosY();
        int x = this.getPosX();
        
        if(this.canMoveRight(board) && this.getState() == 0){
            board.setCell(y, x, 0);
            
            board.setCell(y, x+4, 1);
            
            this.setPosX(x+1);
            
        }
        else if(this.canMoveRight(board) && this.getState() == 1){
            board.setCell(y, x, 0);
            board.setCell(y-1, x, 0);
            board.setCell(y-2, x, 0);
            board.setCell(y-3, x, 0);
            
            board.setCell(y, x+1, 1);
            board.setCell(y-1, x+1, 1);
            board.setCell(y-2, x+1, 1);
            board.setCell(y-3, x+1, 1);
            
            this.setPosX(x+1);
        }
        else{
            return false;
        }
        
        return can;
    }
    
    @Override
    public boolean canMoveRight(Board board){
        boolean can = true;
        
        int y = this.getPosY();
        int x = this.getPosX();
        
        if(this.getState() == 0 && x+3 < 9){
            if(board.getCell(y, x+4) != 0){
                return false;
            }
        }
        else if(this.getState() == 1 && x < 9){
            if(board.getCell(y, x+1) != 0 ||
               board.getCell(y+1, x+1) != 0 ||
               board.getCell(y+2, x+1) != 0 ||
               board.getCell(y+3, x+1) != 0){
                return false;
            }
        }
        else{
            return false;
        }
        
        return can;
    }
    
    @Override
    public boolean moveLeft(Board board){
        boolean can = true;
        
        int y = this.getPosY();
        int x = this.getPosX();
        
        if(this.canMoveLeft(board) && this.getState() == 0){
            board.setCell(y, x+3, 0);
            
            board.setCell(y, x-1, 1);
            
            this.setPosX(x-1);
        }
        else if(this.canMoveLeft(board) && this.getState() == 1){
            board.setCell(y, x, 0);
            board.setCell(y-1, x, 0);
            board.setCell(y-2, x, 0);
            board.setCell(y-3, x, 0);
            
            board.setCell(y, x-1, 1);
            board.setCell(y-1, x-1, 1);
            board.setCell(y-2, x-1, 1);
            board.setCell(y-3, x-1, 1);
            
            this.setPosX(x-1);
        }
        else{
            return false;
        }
        return can;
    }
    
    @Override
    public boolean canMoveLeft(Board board){
        boolean can = true;
        
        int y = this.getPosY();
        int x = this.getPosX();
        
        if(this.getState() == 0 && x > 0){
            if(board.getCell(y, x-1) != 0){
                return false;
            }
        }
        else if(this.getState() == 1 && x > 0){
            if(board.getCell(y, x-1) != 0 ||
               board.getCell(y-1, x-1) != 0 ||
               board.getCell(y-2, x-1) != 0 ||
               board.getCell(y-3, x-1) != 0){
                return false;
            }
        }
        else{
            return false;
        }
        
        return can;
    }
    
    public int getPosX(){
        return this.posX;
    }
    
    public void setPosX(int x){
        this.posX = x;
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public void setPosY(int y){
        this.posY = y;
    }
    
    public int getState(){
        return this.state;
    }
    public void setState(int s){
        this.state = s;
    }
}
