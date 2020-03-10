/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author Jorge
 */
public class Worm {
    
//    private int originalX, originalY;    
    private Direction direction;
    private ArrayList<Piece> pieces;
    private boolean grow;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.direction = originalDirection;
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(originalX, originalY));
        this.grow = false;
    }
    
    public Direction getDirection() {
        return this.direction;
    }
    
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
    
    public int getLength() {
        return this.pieces.size();
    }
    
    public List<Piece> getPieces() {
        return this.pieces;
    }
    
    public void move() {
        
        if (this.pieces.size() < 3 ) {
            this.addPiece();
        }
        else if (this.pieces.size() >= 3 && !this.grow) {
            this.addPiece();
            this.pieces.remove(0);
        } 
        else if (this.grow) {
            this.addPiece();
            this.grow = false;
        }
  
    }
    
//Worm worm = new Worm(5, 5, Direction.RIGHT);
//        System.out.println(worm.getPieces());
//        worm.move();
//        System.out.println(worm.getPieces());
//        worm.move();
//        System.out.println(worm.getPieces());
//        worm.move();
//        System.out.println(worm.getPieces());
//
//        worm.grow();
//        System.out.println(worm.getPieces());
//        worm.move();
//        System.out.println(worm.getPieces());
//
//        worm.setDirection(Direction.LEFT);
//        System.out.println(worm.runsIntoItself());
//        worm.move();
//        System.out.println(worm.runsIntoItself());    
//[(5,5)]
//[(5,5), (6,5)]
//[(5,5), (6,5), (7,5)]
//[(6,5), (7,5), (8,5)]
//[(6,5), (7,5), (8,5)]
//[(6,5), (7,5), (8,5), (9,5)]
//false
//true
    
    public void grow() {
        if (this.pieces.size() >= 3) {
            this.grow = true;
        }
    }
    
    public void addPiece() {
        int x = 0;
        int y = 0;

        switch (this.direction) {
            case UP:
                x = this.pieces.get(this.pieces.size() - 1).getX();
                y = this.pieces.get(this.pieces.size() - 1).getY() - 1;
                this.pieces.add(new Piece(x,y));
                break;
            case RIGHT:
                x = this.pieces.get(this.pieces.size() - 1).getX() + 1;
                y = this.pieces.get(this.pieces.size() - 1).getY();
                this.pieces.add(new Piece(x,y));
                break;
            case DOWN:
                x = this.pieces.get(this.pieces.size() - 1).getX();
                y = this.pieces.get(this.pieces.size() - 1).getY() + 1;
                this.pieces.add(new Piece(x,y));
                break;
            case LEFT:
                x = this.pieces.get(this.pieces.size() - 1).getX() - 1;
                y = this.pieces.get(this.pieces.size() - 1).getY();
                this.pieces.add(new Piece(x,y));
                break;
            }
    }
    
    public boolean runsInto(Piece piece) {
        for (Piece p : this.pieces) {
            if (p.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself() {
        for (int i = 0; i < this.pieces.size() - 1; i++) {
            if (this.pieces.get(this.pieces.size() - 1).runsInto(this.pieces.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    public Piece getHead() {
        return this.pieces.get(this.pieces.size()-1);
    }
}
