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
import java.awt.geom.Line2D;

/**
 * La clase LinePPN sirve para generar una línea, facilitando la asignación
 * de propiedades de dibujo de manera más sencilla que con solo Line2D.
 * @author Pedro Parrilla
 */
public class LinePPN extends ShapePPN {
    
    /**
     * Constructor por defecto
     * @param p1 Punto 1 de la línea
     * @param p2 Punto 2 de la línea
     */
    
    public LinePPN(Point p1, Point p2){
        super();
        line = new Line2D.Float(p1, p2);
    }

    @Override
    public void paint(Graphics2D g2d) {
        paintCommon(g2d);
        g2d.draw(line);
    }

    @Override
    public void setLocation(Point p) {
        int dx = (int) (p.getX() - line.getX1());
        int dy = (int) (p.getY() - line.getY1());
        Point auxp = new Point((int)line.getX2() + dx, (int)line.getY2() + dy);
        line.setLine(p, auxp);
    }

    @Override
    public Point getLocation() {
        return  new Point((int)line.getX1(), (int)line.getY1());
    }

    @Override
    public boolean contains(Point p) {
        return line.ptSegDist(p) <= 5;
    }
    
    @Override
    public RectanglePPN getBounds() {
        Rectangle r = line.getBounds();
        return new RectanglePPN(r.x, r.y, r.width, r.height);
    }
    
    @Override
    public String toString() {
        return "Linea";
    }
    
    /**
     * Función para actualizar la línea
     * @param p1 Punto 1
     * @param p2 Punto 2
     */
    
    public void setLine(Point p1, Point p2) {
        line.setLine(p1, p2);
    }
    
    
    /**
     * Variable para gestionar la línea
     */
    
    private Line2D line;

}
