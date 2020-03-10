/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

/**
 *
 * @author Jorge
 */
public class Piece {
    
    private int x,y;
    
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public boolean runsInto(Piece piece) {
        if (this.x == piece.getX() && this.y == piece.getY()) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
