/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author jjpikoov
 */
public class MenuBar extends JMenuBar{
    
    public MenuBar(){
        JMenu game = new JMenu("Game");
        JMenu settings = new JMenu("Settings");
        JMenu help = new JMenu("Help");
        
        add(game);
        add(settings);
        add(help);
    }
}
