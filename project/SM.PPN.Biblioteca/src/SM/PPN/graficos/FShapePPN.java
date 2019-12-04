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

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.geom.RectangularShape;

/**
 * La clase FShapePPN hereda de ShapePPN, añadiendo propiedades para 
 * poder generar figuras con relleno, controlando el color o el gradiente
 * @author Pedro Parrilla
 */
public abstract class FShapePPN extends ShapePPN {
    
    /**
     * Constructor por defecto
     */
    
    public FShapePPN(){
        super();
        isRelleno = false;
        isDegradado = false;
        fcolor1 = fcolor2 = Color.BLACK;
        dirDegradado = 0;
    }
    
    /**
     * Método utilizado para activar las propiedades del relleno
     * @param g2d Objeto Graphics2D
     * @param rectangle Objecto RectangularShape para el dibujo
     */
    
    public void paintFill(Graphics2D g2d, RectangularShape rectangle) {
        Paint cDegradado = Color.BLACK;
        Point p1 = new Point((int)rectangle.getX(), (int)rectangle.getY());
        Point p2;
        if( dirDegradado == HOR ){
            p2 = new Point((int)(rectangle.getX() + rectangle.getWidth()),
                           (int)rectangle.getY());
            cDegradado = new GradientPaint(p1, fcolor1, p2, fcolor2);
        } else {
            p2 = new Point((int)rectangle.getX(),
                           (int)(rectangle.getY() + rectangle.getHeight()));
            cDegradado = new GradientPaint(p1, fcolor1, p2, fcolor2);
        }
        g2d.setPaint(cDegradado);
    }
    
    /**
     * Funcion utilizada para poder dibujar la figura en cualquier dirección
     * @param shape Figura a utilizar
     * @param p1 Punto 1 del rectangulo
     * @param p2 Punto 2 del rectangulo
     */
    
    public void updateRectangularShape(RectangularShape shape, Point p1, Point p2) {
        if( p1.getX() > p2.getX() ){
            if( p1.getY() > p2.getY() ){
                shape.setFrame(p2.getX(), p2.getY(), p1.getX()- p2.getX(), p1.getY()- p2.getY());
            } else {
                shape.setFrame(p2.getX(), p1.getY(), p1.getX()- p2.getX(), p2.getY()- p1.getY());
            }
        } else{
            if( p1.getY() > p2.getY() ){
                shape.setFrame(p1.getX(), p2.getY(), p2.getX()- p1.getX(), p1.getY()- p2.getY());
            } else {
                shape.setFrame(p1.getX(), p1.getY(), p2.getX()- p1.getX(), p2.getY()- p1.getY());
            }
        }
    }
    
    /**
     * Asigno la localización de la figura, tomando como referencia la diagonal
     * superior izquierda
     * @param shape Figura utilizada
     * @param p Punto de localización
     */
    
    public void setLocation(RectangularShape shape, Point p) {
        shape.setFrameFromDiagonal(p.getX(), p.getY(),
                p.getX() + (shape.getMaxX() - shape.getMinX()), 
                p.getY() + (shape.getMaxY() - shape.getMinY()));
    }
    
    /**
     * Devolución del estado del relleno
     * @return Estado del relleno
     */

    public boolean getIsRelleno() {
        return isRelleno;
    }
    
    /**
     * Asignación del estado del relleno
     * @param isRelleno Activa o desactiva relleno
     */

    public void setIsRelleno(boolean isRelleno) {
        this.isRelleno = isRelleno;
    }
    
    /**
     * Devolución del estado del degradado
     * @return Estado del degradado
     */

    public boolean getIsDegradado() {
        return isDegradado;
    }
    
    /**
     * Asignación del estado del degradado
     * @param isDegradado Activa o desactiva degradado
     */

    public void setIsDegradado(boolean isDegradado) {
        this.isDegradado = isDegradado;
    }
    
    /**
     * Asignación del degradado completo
     * @param fcolor1 Color 1 del degradado
     * @param fcolor2 Color 2 del degradado
     * @param dirDegradado Dirección del degradado
     */
    
    public void setDegradado(Color fcolor1, Color fcolor2, int dirDegradado) {
        this.fcolor1 = fcolor1;
        this.fcolor2 = fcolor2;
        this.dirDegradado = dirDegradado;
    }
    
    /**
     * Devolución del color 1 del relleno
     * @return Color correspondiente
     */

    public Color getFcolor1() {
        return fcolor1;
    }
    
    /**
     * Asignación del color 1 del relleno
     * @param fcolor1 Color a asignar
     */

    public void setFcolor1(Color fcolor1) {
        this.fcolor1 = fcolor1;
    }
    
    /**
     * Devolución del color 2 del relleno
     * @return Color correspondiente
     */

    public Color getFcolor2() {
        return fcolor2;
    }
    
    /**
     * Asignación del color 2 del relleno
     * @param fcolor2 Color a asignar
     */

    public void setFcolor2(Color fcolor2) {
        this.fcolor2 = fcolor2;
    }
    
    /**
     * Devolución de la dirección del degradado
     * @return Dirección del degradado
     */

    public int getDirDegradado() {
        return dirDegradado;
    }
    
    /**
     * Asignación de la dirección del degradado
     * @param dirDegradado Dirección del degradado
     */

    public void setDirDegradado(int dirDegradado) {
        this.dirDegradado = dirDegradado;
    }
    
    /**
     * Dirección horizontal del degradado
     */
    
    public final static int HOR = 0;
    
    /**
     * Dirección vertical del degradado
     */
    
    public final static int VER = 1;
    
    /**
     * Control del relleno
     */
    
    boolean isRelleno;
    
    /**
     * Control del degradado
     */
    
    boolean isDegradado;
    
    /**
     * Colores del degradado
     */
    
    Color fcolor1, fcolor2;
    
    /**
     * Dirección del degradado, utilizando las constantes definidades de VER y HOR
     * 0:Horizontal
     * 1:Vertical
     */
    
    int dirDegradado;
    
}
