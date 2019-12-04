/*
 * Copyright (C) 2019 Pedro Parrilla
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package SM.PPN.graficos;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * La clase RectanglePPN sirve para generar un rectangulo, facilitando la asignación
 * de propiedades de dibujo de manera más sencilla que con solo Rectangle2D.
 * @author Pedro Parrilla
 */
public class RectanglePPN extends FShapePPN {
    
    /**
     * Constructor del rectangulo
     * @param x Valor x del punto
     * @param y Valor y del punto
     * @param w Alto del rectangulo
     * @param h Ancho del rectangulo
     */
    
    public RectanglePPN(int x, int y, int w, int h){
        super();
        rectangle = new Rectangle2D.Float(x, y, w, h);
    }

    @Override
    public void paint(Graphics2D g2d) {
        paintCommon(g2d);
        g2d.draw(rectangle);
        if(isRelleno){
            paintFill(g2d,rectangle);
            g2d.fill(rectangle);
        }
    }

    @Override
    public void setLocation(Point p) {
        this.setLocation(rectangle, p);
    }

    @Override
    public Point getLocation() {
        return new Point((int)rectangle.getMinX(), (int)rectangle.getMinY());
    }

    @Override
    public boolean contains(Point p) {
        return rectangle.contains(p);
    }

    @Override
    public RectanglePPN getBounds() {
        Rectangle r = rectangle.getBounds();
        return new RectanglePPN(r.x - 10, r.y - 10, r.width + 20, r.height + 20);
    }
    
    @Override
    public String toString() {
        return "Rectangulo";
    }
    
    /**
     * Función para actualizar el rectangulo en función de que dirección se dibuja
     * @param p1 Punto 1
     * @param p2 Punto 2
     */
    
    public void setRectangle(Point p1, Point p2) {
        updateRectangularShape(rectangle, p1, p2);
    }

    
    /**
     * Variable para gestionar el rectangulo
     */
    
    Rectangle2D rectangle;
        
}
