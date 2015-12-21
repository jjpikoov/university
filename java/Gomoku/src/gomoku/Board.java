/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author jjpikoov
 */
public class Board extends JPanel{
    private int boardWidth;
    private int boardHeight;
    private Data data;
    
    private int pointX;
    private int pointY;
    
    public Board(){
        data = new Data();
        addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e){
               data.changeColor(e.getX(), e.getY(), Color.BLUE);
               repaint();
           } 
        });
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.paintBoard(g);


    }
    
    public void paintBoard(Graphics g){
        data.init(this.getEdge());
        Square[][] squares = data.getSquares();

        for (int i = 0; i < 19; i++){
            for (int j = 0; j < 19; j++){
                g.setColor(Color.RED);
                g.drawRect(squares[i][j].begX, squares[i][j].begY, squares[i][j].edge, squares[i][j].edge);
                g.setColor(squares[i][j].color);
                g.fillRect(squares[i][j].begX+1, squares[i][j].begY+1, squares[i][j].edge-1, squares[i][j].edge-1);

            }
        }


    }
    
    public void setBoardSize(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        repaint();
    }
    
    public int getEdge(){
        int edge;
        if (boardHeight > boardWidth)
            edge = boardWidth;
        else
            edge = boardHeight;
        

        return edge / 20;
    }
    
    
}