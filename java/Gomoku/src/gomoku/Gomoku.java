/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author jjpikoov
 */
public class Gomoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame frame = new Frame("Gomoku");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event){
                System.exit(0);
            }
        });


               
        MenuBar menuBar = new MenuBar();
        Status status = new Status();
        final Board board = new Board();
        
        
        board.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e){
                Dimension size = e.getComponent().getSize();
                board.setBoardSize(size.width - 20, size.height - 20);
            }
        });
        
        frame.add(menuBar);
        frame.add(board);
        frame.add(status);



        
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.addLayoutComponent(menuBar, BorderLayout.PAGE_START);
        borderLayout.addLayoutComponent(board, BorderLayout.CENTER);
        borderLayout.addLayoutComponent(status, BorderLayout.PAGE_END);
        

//        
//
        frame.setLayout(borderLayout);
        frame.setVisible(true);
        board.setBoardSize(board.getSize().width, board.getSize().height);
    }
    
}
