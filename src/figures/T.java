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
public class T implements Figure {

    private int T[][] = {{0, 3, 0}, {3, 3, 3}};
    private int posX = 3;
    private int posY = 1;
    private int state = 0;

    @Override
    public void create(Board board) {
        int y = this.posY;
        int x = this.posX;

        board.setCell(y - 1, x + 1, 3);
        board.setCell(y, x, 3);
        board.setCell(y, x + 1, 3);
        board.setCell(y, x + 2, 3);
    }

    @Override
    public int[][] getFigure() {
        return this.T;
    }

    @Override
    public boolean turnRight(Board board) {
        boolean can = this.canTurnRight(board);
        int y = this.posY;
        int x = this.posX;
        int stat = this.state;

        if (can && stat == 0) {
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y, x, 0);
            board.setCell(y, x + 1, 0);
            board.setCell(y, x + 2, 0);

            board.setCell(y, x + 1, 3);
            board.setCell(y, x + 2, 3);
            board.setCell(y - 1, x + 1, 3);
            board.setCell(y + 1, x + 1, 3);

            this.posY = y + 1;
            this.posX = x + 1;

            this.setState(2);
        } else if (can && stat == 1) {
            board.setCell(y - 1, x, 0);
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y - 1, x + 2, 0);
            board.setCell(y, x + 1, 0);

            board.setCell(y - 1, x, 3);
            board.setCell(y, x + 1, 3);
            board.setCell(y - 1, x + 1, 3);
            board.setCell(y - 2, x + 1, 3);

            this.setState(3);
        } else if (can && stat == 2) {
            board.setCell(y, x, 0);
            board.setCell(y - 1, x, 0);
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y - 2, x, 0);

            board.setCell(y - 1, x - 1, 3);
            board.setCell(y - 1, x, 3);
            board.setCell(y, x, 3);
            board.setCell(y - 1, x + 1, 3);

            this.posX = x - 1;

            this.setState(1);
        } else if (can && stat == 3) {
            board.setCell(y - 1, x, 0);
            board.setCell(y, x + 1, 0);
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y - 2, x + 1, 0);

            board.setCell(y - 1, x, 3);
            board.setCell(y - 1, x + 1, 3);
            board.setCell(y - 1, x + 2, 3);
            board.setCell(y - 2, x + 1, 3);

            this.posY = y - 1;

            this.setState(0);
        }

        return can;
    }

    @Override
    public boolean canTurnRight(Board board) {
        boolean can = false;
        int y = this.posY;
        int x = this.posX;
        int stat = this.state;

        if (y < 20 && stat == 0 && board.getCell(y + 1, x + 1) == 0) {
            can = true;
        } else if (y > 1 && stat == 1 && board.getCell(y - 2, x + 1) == 0) {
            can = true;
        } else if (x > 0 && stat == 2 && board.getCell(y - 1, x - 1) == 0) {
            can = true;
        } else if (x < 9 && stat == 3 && board.getCell(y - 1, x + 2) == 0) {
            can = true;
        }

        return can;

    }

    @Override
    public boolean turnLeft(Board board) {
        boolean can = this.canTurnRight(board);
        int y = this.posY;
        int x = this.posX;
        int stat = this.state;

        if (can && stat == 0) {
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y, x, 0);
            board.setCell(y, x + 1, 0);
            board.setCell(y, x + 2, 0);

            board.setCell(y -1, x + 1, 3);
            board.setCell(y , x, 3);
            board.setCell(y , x + 1, 3);
            board.setCell(y+1, x + 1, 3);

            this.posY = y + 1;

            this.setState(3);
        } else if (can && stat == 1) {
            board.setCell(y - 1, x, 0);
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y - 1, x + 2, 0);
            board.setCell(y, x + 1, 0);

            board.setCell(y, x + 1, 3);
            board.setCell(y - 1, x + 1, 3);
            board.setCell(y - 1, x + 2, 3);
            board.setCell(y - 2, x + 1, 3);

            this.posX = x + 1;

            this.setState(2);
        } else if (can && stat == 2) {
            board.setCell(y, x, 0);
            board.setCell(y - 1, x, 0);
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y - 2, x, 0);

            board.setCell(y - 1, x-1, 3);
            board.setCell(y - 1, x, 3);
            board.setCell(y - 1, x + 1, 3);
            board.setCell(y - 2, x , 3);

            this.posX = x - 1;
            this.posY = y - 1;

            this.setState(0);
        } else if (can && stat == 3) {
            board.setCell(y - 1, x, 0);
            board.setCell(y, x + 1, 0);
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y - 2, x + 1, 0);

            board.setCell(y, x + 1, 3);
            board.setCell(y - 1, x, 3);
            board.setCell(y - 1, x + 1, 3);
            board.setCell(y - 1, x + 2, 3);

            this.setState(1);
        }

        return can;
    }

    @Override
    public boolean canTurnLeft(Board board) {
        boolean can = false;
        int y = this.posY;
        int x = this.posX;
        int stat = this.state;

        if (y < 20 && stat == 0 && board.getCell(y + 1, x + 1) == 0) {
            can = true;
        } else if (y > 1 && stat == 1 && board.getCell(y - 2, x + 1) == 0) {
            can = true;
        } else if (x > 0 && stat == 2 && board.getCell(y - 1, x - 1) == 0) {
            can = true;
        } else if (x < 9 && stat == 3 && board.getCell(y - 1, x + 2) == 0) {
            can = true;
        }

        return can;
    }

    @Override
    public boolean down(Board board) {
        boolean can = canDown(board);
        int y = this.posY;
        int x = this.posX;
        int stat = this.state;

        if (can && stat == 0) {
            board.setCell(y, x, 0);
            board.setCell(y, x + 1, 0);
            board.setCell(y, x + 2, 0);
            board.setCell(y - 1, x + 1, 0);

            board.setCell(y, x + 1, 3);
            board.setCell(y + 1, x, 3);
            board.setCell(y + 1, x + 1, 3);
            board.setCell(y + 1, x + 2, 3);

            this.setPosY(y + 1);
        } else if (can && stat == 1) {
            board.setCell(y - 1, x, 0);
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y - 1, x + 2, 0);
            board.setCell(y, x + 1, 0);

            board.setCell(y, x, 3);
            board.setCell(y, x + 1, 3);
            board.setCell(y, x + 2, 3);
            board.setCell(y + 1, x + 1, 3);

            this.setPosY(y + 1);
        } else if (can && stat == 2) {
            board.setCell(y - 2, x, 0);
            board.setCell(y - 1, x, 0);
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y, x, 0);

            board.setCell(y - 1, x, 3);
            board.setCell(y, x, 3);
            board.setCell(y, x + 1, 3);
            board.setCell(y + 1, x, 3);

            this.setPosY(y + 1);
        } else if (can && stat == 3) {
            board.setCell(y - 2, x + 1, 0);
            board.setCell(y - 1, x, 0);
            board.setCell(y - 1, x + 1, 0);
            board.setCell(y, x + 1, 0);

            board.setCell(y, x, 3);
            board.setCell(y - 1, x + 1, 3);
            board.setCell(y, x + 1, 3);
            board.setCell(y + 1, x + 1, 3);

            this.setPosY(y + 1);
        }

        return can;
    }

    @Override
    public boolean canDown(Board board) {
        boolean can = false;
        int y = this.posY;
        int x = this.posX;
        int stat = this.state;

        if (y < 21 && stat == 0
                && board.getCell(y + 1, x) == 0
                && board.getCell(y + 1, x + 1) == 0
                && board.getCell(y + 1, x + 2) == 0) {
            can = true;
        } else if (y < 21 && stat == 1
                && board.getCell(y, x) == 0
                && board.getCell(y + 1, x + 1) == 0
                && board.getCell(y, x + 2) == 0) {
            can = true;
        } else if (y < 21 && stat == 2
                && board.getCell(y + 1, x) == 0
                && board.getCell(y, x + 1) == 0) {
            can = true;
        } else if (y < 21 && stat == 3
                && board.getCell(y, x) == 0
                && board.getCell(y + 1, x + 1) == 0) {
            can = true;
        }
        return can;
    }

    @Override
    public boolean moveRight(Board board) {
        boolean can = this.canMoveRight(board);
        int y = this.posY;
        int x = this.posX;
        int stat = this.state;
        
        if(can && stat == 0){
            board.setCell(y, x, 0);
            board.setCell(y, x+1, 0);
            board.setCell(y, x+2, 0);
            board.setCell(y-1, x+1, 0);
            
            board.setCell(y, x+1, 3);
            board.setCell(y, x+2, 3);
            board.setCell(y, x+3, 3);
            board.setCell(y-1, x+2, 3);
            
            this.posX = x+1;
        }else if( can && stat == 1){
            board.setCell(y-1, x, 0);
            board.setCell(y-1, x+1, 0);
            board.setCell(y-1, x+2, 0);
            board.setCell(y, x+1, 0);
            
            board.setCell(y-1, x+1, 3);
            board.setCell(y-1, x+2, 3);
            board.setCell(y-1, x+3, 3);
            board.setCell(y, x+2, 3);
            
            this.posX = x+1;
        }else if( can && stat == 2){
            board.setCell(y-2, x, 0);
            board.setCell(y-1, x, 0);
            board.setCell(y-1, x+1, 0);
            board.setCell(y, x, 0);
            
            board.setCell(y-2, x+1, 3);
            board.setCell(y-1, x+1, 3);
            board.setCell(y-1, x+2, 3);
            board.setCell(y, x+1, 3);
            
            this.posX = x+1;
        }else if(can && stat == 3){
            board.setCell(y-2, x+1, 0);
            board.setCell(y-1, x, 0);
            board.setCell(y-1, x+1, 0);
            board.setCell(y, x+1, 0);
            
            board.setCell(y-2, x+2, 3);
            board.setCell(y-1, x+1, 3);
            board.setCell(y-1, x+2, 3);
            board.setCell(y, x+2, 3);
            
            this.posX = x+1;
        }
       
        return can;
    }

    @Override
    public boolean canMoveRight(Board board) {
        boolean can = false;
        int y = this.posY;
        int x = this.posX;
        int stat = this.state;
        
        if(x+2 < 9 && stat == 0 &&
           board.getCell(y-1, x+2) == 0 &&
           board.getCell(y, x+3) == 0){
            can = true;
        }else  if(x+2 < 9 && stat == 1 &&
                  board.getCell(y-1, x+3) == 0&&
                  board.getCell(y, x+2) == 0){
            can = true;
        }else if(x+1<9 && stat == 2 &&
                 board.getCell(y-2, x+1) == 0 &&
                 board.getCell(y-1, x+2) == 0 &&
                 board.getCell(y, x+1) == 0){
            can = true;
        }else if(x+1<9 && stat == 3 &&
                 board.getCell(y-2, x+2) == 0 &&
                 board.getCell(y-1, x+2) == 0 &&
                 board.getCell(y, x+2) == 0){
            can = true;
        }
        
        return can;
    }

    @Override
    public boolean moveLeft(Board board) {
        boolean can = this.canMoveLeft(board);
        int y = this.posY;
        int x = this.posX;
        int stat = this.state;
        
        if(can && stat == 0){
            board.setCell(y, x, 0);
            board.setCell(y, x+1, 0);
            board.setCell(y, x+2, 0);
            board.setCell(y-1, x+1, 0);
            
            board.setCell(y-1, x, 3);
            board.setCell(y, x+1, 3);
            board.setCell(y, x, 3);
            board.setCell(y, x-1, 3);
            
            this.posX = x-1;
        }else if( can && stat == 1){
            board.setCell(y-1, x, 0);
            board.setCell(y-1, x+1, 0);
            board.setCell(y-1, x+2, 0);
            board.setCell(y, x+1, 0);
            
            board.setCell(y-1, x+1, 3);
            board.setCell(y-1, x, 3);
            board.setCell(y-1, x-1, 3);
            board.setCell(y, x, 3);
            
            this.posX = x-1;
        }else if( can && stat == 2){
            board.setCell(y-2, x, 0);
            board.setCell(y-1, x, 0);
            board.setCell(y-1, x+1, 0);
            board.setCell(y, x, 0);
            
            board.setCell(y-2, x-1, 3);
            board.setCell(y-1, x-1, 3);
            board.setCell(y-1, x, 3);
            board.setCell(y, x-1, 3);
            
            this.posX = x-1;
        }else if(can && stat == 3){
            board.setCell(y-2, x+1, 0);
            board.setCell(y-1, x, 0);
            board.setCell(y-1, x+1, 0);
            board.setCell(y, x+1, 0);
            
            board.setCell(y-2, x, 3);
            board.setCell(y-1, x, 3);
            board.setCell(y-1, x-1, 3);
            board.setCell(y, x, 3);
            
            this.posX = x-1;
        }
       
        return can;
    }

    @Override
    public boolean canMoveLeft(Board board) {
        boolean can = false;
        int y = this.posY;
        int x = this.posX;
        int stat = this.state;
        
        if(x > 0 && stat == 0 &&
           board.getCell(y-1, x) == 0 &&
           board.getCell(y, x-1) == 0){
            can = true;
        }else  if(x > 0 && stat == 1 &&
                  board.getCell(y-1, x-1) == 0&&
                  board.getCell(y, x) == 0){
            can = true;
        }else if(x> 0 && stat == 2 &&
                 board.getCell(y-2, x-1) == 0 &&
                 board.getCell(y-1, x-1) == 0 &&
                 board.getCell(y, x-1) == 0){
            can = true;
        }else if(x> 0 && stat == 3 &&
                 board.getCell(y-2, x) == 0 &&
                 board.getCell(y-1, x-1) == 0 &&
                 board.getCell(y, x) == 0){
            can = true;
        }
        
        return can;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
