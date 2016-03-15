/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

/**
 *
 * @author jjpikoov
 */
public class Plane extends Canvas{


    private ArrayList<Shape> shapes = new ArrayList<>();
    private Shape shape = null;
    private Point start;
    private Point end;

    ArrayList<Shape> buffer = new ArrayList<>();
    

    
    public Plane(){
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                end = e.getPoint();


                shape = new Line(start, end, Colors.color);
                
                shapes.removeAll(shapes);
                shapes.add(shape);

                repaint();
            }
        });
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                start = e.getPoint();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if ((start.x >= 0 && start.x <= 400) && (start.y >= 0 && start.y <= 400)
                        && (end.x >= 0 && end.x <= 400) && (end.y >= 0 && end.y <= 400)){
                  
                
                    buffer.add(shape);

                }
                repaint();
            }
        });
        
        addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e){
               int key = e.getKeyCode();
               
               if (key == KeyEvent.VK_BACK_SPACE){
                   buffer.removeAll(buffer);
                   shapes.removeAll(shapes);
                   repaint();
               }
               else if (key == KeyEvent.VK_L){
                   shapes.removeAll(shapes);
                   shapes.addAll(buffer);

                   if (!shapes.isEmpty()){
                       shapes.remove(shapes.size() -1);
                       buffer.remove(buffer.size() -1);
                   }
                   repaint();
               }
               else if (key == KeyEvent.VK_F){
                   shapes.removeAll(shapes);
                   shapes.addAll(buffer);
                   
                   if (!shapes.isEmpty()){
                       shapes.remove(0);
                       buffer.remove(0);
                   }
                   repaint();
               }
           }
        });
        
        setSize(400, 400);
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        shapes.addAll(buffer);
        for (Shape s : shapes){
            g2d.setColor(((Line) s).color);
            g2d.draw(s);
        }
    }
}
