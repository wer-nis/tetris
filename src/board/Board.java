/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package board;

/**
 *
 * @author pipe
 */
public class Board {
    
   private int height;
    
   private int width;
   
   private int[][] board;
   
   public void createDefaultBoard(){
       int boardC[][] = new int [22][10];
       for (int i = 0; i < 22; i++) {
           for (int j = 0; j < 10; j++) {
               boardC[i][j] = 0;
           }
       }
       this.height = 22;
       this.width = 10;
       this.board = boardC;
   }
   
   public void createBoard(int height, int width){
       int boardC[][] = new int[height+2][width];
       for (int i = 0; i < height+2; i++) {
           for (int j = 0; j < width; j++) {
               boardC[i][j] = 0;
           }
       }
       this.height = height+2;
       this.width = width;
       this.board = boardC;
   }
   
   public int getCell(int column, int row){
       return this.board[column][row];
   }
   
   public void setCell(int column, int row, int cellValue){
       this.board[column][row] = cellValue;
   }
   
   public int getHeight(){
       return this.height;
   }
   
   public int getWidth(){
       return this.width;
   }
   
   public int[][] getBoard(){
       return this.board;
   }

   public void printBoard(Board b){
       for (int i = 0; i < b.height; i++) {
           for (int j = 0; j < b.width; j++) {
               System.out.print(b.getCell(i, j));
           }
           System.out.println();
       }
   }
}
