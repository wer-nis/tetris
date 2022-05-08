/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import board.Board;
import figures.Figure;
import figures.I;
import figures.J;
import figures.L;
import figures.O;
import figures.S;
import figures.T;
import figures.Z;

/**
 *
 * @author pipe
 */
public class prueba {
    public static void main(String[] args) {
        Board tablero = new Board();
        tablero.createDefaultBoard();
        Figure f = new T();
        
        f.create(tablero);
        f.turnRight(tablero);
        f.turnRight(tablero);
        f.turnRight(tablero);
        f.moveLeft(tablero);
        f.moveLeft(tablero);
        f.moveLeft(tablero);
        f.moveLeft(tablero);
        /*f.moveRight(tablero);
        for (int i = 0; i < 22; i++) {
            //f.down(tablero);
            f.moveRight(tablero);
        }
        /*f.turnLeft(tablero);
        f.down(tablero);*/
        
        tablero.printBoard(tablero);
        
        
    }
}
