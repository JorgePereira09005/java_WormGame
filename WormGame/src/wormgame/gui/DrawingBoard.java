/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author Jorge
 */
public class DrawingBoard extends JPanel implements Updatable{
    
    private WormGame game;
    private int pieceLength;
    
    public DrawingBoard(WormGame game, int pieceLength) {
        super.setBackground(Color.GRAY);
        this.game = game;
        this.pieceLength = pieceLength;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);
        
        for (Piece piece : this.game.getWorm().getPieces() ) {
            graphics.setColor(Color.BLACK);
            graphics.fill3DRect(piece.getX()*this.pieceLength, piece.getY()*this.pieceLength, this.pieceLength, this.pieceLength, true);
        }
        graphics.setColor(Color.RED);
        graphics.fillOval(this.game.getApple().getX()*this.pieceLength, this.game.getApple().getY()*this.pieceLength, this.pieceLength, this.pieceLength);
        
        this.update();
    }
    
    @Override
    public void update() {
        super.repaint();
    }
}
