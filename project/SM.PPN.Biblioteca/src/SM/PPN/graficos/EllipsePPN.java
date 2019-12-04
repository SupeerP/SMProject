package SM.PPN.graficos;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
 * La clase EllipsePPN sirve para generar una elipse, facilitando la asignación
 * de propiedades de dibujo de manera más sencilla que con solo Ellipse2D.
 * @author Pedro Parrilla
 */
public class EllipsePPN extends FShapePPN {
    
    /**
     * Constructor de la elipse
     * @param x Valor x del punto
     * @param y Valor y del punto
     * @param w Alto de la elipse
     * @param h Ancho de la elipse
     */
    
    public EllipsePPN(int x, int y, int w, int h){
        super();
        ellipse = new Ellipse2D.Float(x, y, w, h);
    }

    @Override
    public void paint(Graphics2D g2d) {
        paintCommon(g2d);
        g2d.draw(ellipse);
        if(isRelleno){
            paintFill(g2d,ellipse);
            g2d.fill(ellipse);
        }
    }

    @Override
    public void setLocation(Point p) {
        this.setLocation(ellipse, p);
    }

    @Override
    public Point getLocation() {
        return new Point((int)ellipse.getCenterX(), (int)ellipse.getCenterY());
    }

    @Override
    public boolean contains(Point p) {
        return ellipse.contains(p);
    }

    @Override
    public RectanglePPN getBounds() {
        Rectangle r = ellipse.getBounds();
        return new RectanglePPN(r.x - 10, r.y - 10, r.width + 20, r.height + 20);
    }
    
    @Override
    public String toString() {
        return "Elipse";
    }
    
    /**
     * Función para actualizar la elipse en función de que dirección se dibuja
     * @param p1 Punto 1
     * @param p2 Punto 2
     */
    
    public void setEllipse(Point p1, Point p2) {
        updateRectangularShape(ellipse, p1, p2);
    }

    
    /**
     * Variable para gestionar la elipse
     */
    
    Ellipse2D ellipse;
       
}
