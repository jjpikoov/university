/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.graphics;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author jjpikoov
 */
public class Colors extends List{
    
    public static Color color;
    
    public Colors(){
        super(4);
        add("Black");
        add("Red");
        add("Green");
        add("Blue");
        
        addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((Integer) e.getItem() == 0){
                    Colors.color = Color.BLACK;
                }
                if ((Integer) e.getItem() == 1){
                    Colors.color = Color.RED;
                }
                if ((Integer) e.getItem() == 2){
                    Colors.color = Color.GREEN;
                }
                if ((Integer) e.getItem() == 3){
                    Colors.color = Color.BLUE;
                }

            }
        });
    }
    
    public List getColors(){
        return this;
    }

    
    
    
}
