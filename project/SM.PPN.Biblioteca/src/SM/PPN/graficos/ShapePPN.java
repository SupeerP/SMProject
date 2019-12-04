package SM.PPN.graficos;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

/**
 * La clase ShapePPN es utilizada para guardar atributos y métodos comunes
 * de las diferentes formas de dibujo, unificando todo así en un tipo de objeto,
 * que es el objetivo final de Shape
 * En este caso se ha creado una clase abstracta ya que las figuras tienen en común
 * diferentes métodos, asi que heredando de ShapePPN tienen que redefinirlos,
 * teniendo todas las clases una estructura similar
 * @author Pedro Parrilla
 */
public abstract class ShapePPN {
    
    /**
     * Constructor por defecto
     */
    
    public ShapePPN(){
        isTransparent = false;
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_OFF);
        transp = 1.0f;
        transparencia = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transp);
        trazo = new TrazoPPN();
    }
    
    /**
     * Pintado del objeto con sus propiedades
     * @param g2d Objeto Graphics2D utilizado para dibujar
     */
    
    public abstract void paint(Graphics2D g2d);
    
    /**
     * Asignación de la posición del objeto dibujado
     * @param p Lugar donde situar la figura
     */
    
    public abstract void setLocation(Point p);
    
    /**
     * Devolución de la posición del objeto dibujado
     * @return Punto de referencia
     */
    public abstract Point getLocation();
    
    /**
     * Comprobación si un punto está contenido en el objeto dibujado
     * @param p Punto que puede estar contenido
     * @return Si está contenido o no
     */
    
    public abstract boolean contains(Point p);
    
    /**
     * Devolución del rectangulo que rodea a la figura
     * @return Rectangulo que rodea a la figura
     */
    
    public abstract RectanglePPN getBounds();
    
    /**
     * Devolución del nombre de la figura
     * @return Nombre de la figura
     */
    @Override
    public abstract String toString();
    
    /**
     * Método utilizado para activar las propiedades de dibujo
     * @param g2d 
     */
    
    public void paintCommon(Graphics2D g2d){
        g2d.setPaint(trazo.getColor());
        g2d.setStroke(trazo.getTrazo());
        g2d.setComposite(transparencia);
        g2d.setRenderingHints(render);
    }
    
    /**
     * Devolución del estado de la transparencia
     * @return Estado de la transparencia
     */
    
    public float getTransp() {
        return transp;
    }

    /**
     * Asignación del valor de la transparencia
     * @param transp Nivel de transparencia a asignar entre 0 y 1
     */
    
    public void setTransparent(float transp) {
        transparencia  = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transp);
        this.transp = transp;
        this.isTransparent = transp != 1.0f;
    }
    
    /**
     * Devolución del estado del suavizado
     * @return Estado del suavizado
     */

    public boolean getRender() {
        return render.get(RenderingHints.KEY_ANTIALIASING) == RenderingHints.VALUE_ANTIALIAS_ON;
    }

    /**
     * Asignación del estado del renderizado
     * @param rend Estado del renderizado
     */
    
    public void setRender(boolean rend) {
        if(rend){
            render.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }else{
            render.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
    }
    
    /**
     * Devolución del objeto trazo que contiene 
     * @return Objeto TrazoPPN
     */

    public TrazoPPN getTrazo() {
        return trazo;
    }

    /**
     * Asignación de las propiedades del trazo
     * @param color Color del trazo
     * @param grosor Grosor del trazo
     * @param tipo Tipo de trazo
     */
    
    public void setTrazo(Color color, int grosor, int tipo) {
        trazo.setTrazo(color, grosor, tipo);
    }
    
    /**
     * Asignación del color del trazo
     * @param color 
     */
    public void setColorTrazo( Color color ){
        trazo.setColor(color);
    }
    
    public void setTipoTrazo( int i ){
        trazo.setTipoTrazo(i);
    }
    
    /**
     * Control del estado de la transparencia
     */
    
    boolean isTransparent;
    
    /**
     * Variable para guardar el valor de la transparencia
     */
    
    float transp;
    
    /**
     * Define el grado de transparencia
     */
    
    Composite transparencia;
    
    /**
     * Suavizado del contorno de la figura
     */
    
    RenderingHints render;
    
    /**
     * Objeto que gestiona el trazo de la figura
     */
    
    TrazoPPN trazo;
    
    
    
}
