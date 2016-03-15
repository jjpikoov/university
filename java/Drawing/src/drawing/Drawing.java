/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import drawing.graphics.Colors;
import drawing.graphics.Plane;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author jjpikoov
 */
public class Drawing {

    public static void main(String[] args) {
        Frame frame = new Frame("Drawer");
        frame.setSize(500, 500);

        frame.setLocationRelativeTo(null);
        
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent event){
                System.exit(0);
            }
        });

        Colors colors = new Colors();
        
        
        Plane plane = new Plane();
        frame.add(plane);
        frame.add(colors.getColors());

        
        BorderLayout boarderLayout = new BorderLayout();
        boarderLayout.addLayoutComponent(colors.getColors(), BorderLayout.WEST);
        boarderLayout.addLayoutComponent(plane, BorderLayout.CENTER);
        frame.setLayout(boarderLayout);
        
        frame.setVisible(true);
    }
    
}
