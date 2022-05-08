/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package figures;

import board.Board;

/**
 *
 * @author pipe
 */
public interface Figure {
   
   public void create(Board board);
   public int[][] getFigure();
   public boolean turnRight (Board board);
   public boolean canTurnRight (Board board);
   public boolean turnLeft(Board board);
   public boolean canTurnLeft(Board board);
   public boolean down (Board board);
   public boolean canDown(Board board);
   public boolean moveRight(Board board);
   public boolean canMoveRight(Board board);
   public boolean moveLeft(Board board);
   public boolean canMoveLeft(Board board);
}
