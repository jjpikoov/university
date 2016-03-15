/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.graphics;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Line2D;

/**
 *
 * @author jjpikoov
 */
public class Line extends Line2D.Double{
    
    Color color;
    
    public Line(Point start, Point end, Color color){
        super.x1 = start.x;
        super.y1 = start.y;
        super.x2 = end.x;
        super.y2 = end.y;
        this.color = color;
    }
    
}
