package SM.PPN.graficos;

import java.awt.BasicStroke;
import java.awt.Color;

/**
 * La clase trazo tal y como su nombre indica, gestiona el color, el tipo y el
 * grosor del borde de la figura a dibujar
 * @author Pedro Parrilla
 */
public class TrazoPPN {
    
    /**
     * Constructor por defecto
     */
    
    public TrazoPPN(){
        color = Color.BLACK;
        grosor = 2;
        tipo = CONT;
        trazo = new BasicStroke(grosor);
    }

    /**
     * Devolución del color del trazo
     * @return El color activo
     */
    
    public Color getColor() {
        return color;
    }
    
    /**
     * Asignación de un nuevo color
     * @param color Color
     */

    public void setColor( Color color ) {
        this.color = color;
    }
    
    /**
     * Devolución del grosor del trazo
     * @return El grosor del trazo
     */
    
    public int getGrosor(){
        return grosor;
    }
    
    /**
     * Asignación del grosor del trazo
     * @param grosor Grosor
     */
    
    public void setGrosor(int grosor){
        this.grosor = grosor;
        this.setTrazo(grosor, tipo);
    }
    
    /**
     * Devolución del tipo del trazo
     * @return tipo del trazo
     */
    
    public int getTipoTrazo(){
        return tipo;
    }
    
    /**
     * Asignación del tipo de trazo
     * @param tipo Tipo del trazo
     */
    
    public void setTipoTrazo(int tipo){
        if(tipo >= 0 && tipo <= 2){
            this.tipo = tipo;
            this.setTrazo(grosor, tipo);
        }
    }
    
    /**
     * Devolución del color del trazo
     * @return El stoke activo
     */

    public BasicStroke getTrazo() {
        return trazo;
    }
    
    /**
     * Asignación de un nuevo tipo de trazo
     * @param grosor El grosor del trazo
     * @param tipo El tipo de trazo (0 continuo, 1 puntos, 2 líneas )
     */

    public void setTrazo( int grosor, int tipo ) {
        this.grosor = grosor;
        switch (tipo) {
            case CONT:{
                BasicStroke bs = new BasicStroke(grosor);
                this.trazo = bs;
                break;
            }
            case PUNT: {
                float discontinuidadTrazo[] = {1.0f, 1.0f};
                BasicStroke bs;
                bs = new BasicStroke(grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0.0f, discontinuidadTrazo, 100.0f);
                this.trazo = bs;
                break;
            }
            case LINE:{
                float discontinuidadTrazo[] = {5.0f, 2.0f};
                BasicStroke bs;
                bs = new BasicStroke(grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0.0f, discontinuidadTrazo, 100.0f);
                this.trazo = bs;
                break;
            }
            default:
                break;
        }
    }
    
    /**
     * Asignación de los parámetros que componen el trazo
     * @param color El color del trazo
     * @param grosor El grosor del trazo
     * @param tipo El tipo de trazo
     */
    public void setTrazo( Color color, int grosor, int tipo ){
        this.setTrazo(grosor, tipo);
        this.setColor(color);
    }
    
    /**
     * Variable utilizada para indicar el trazo continuo
     */
    
    public final static int CONT = 0;
    
    /**
     * Variable utilizada para indicar el trazo con puntos
     */
    
    public final static int PUNT = 1;
    
    /**
     * Variable utilizada para indicar el trazo con líneas
     */
    
    public final static int LINE = 2;
    
    /**
     * Variable para el color del trazo
     */
    
    private Color color;
    
    /**
     * Variable que gestiona el trazo, indicando el grosor y el tipo de este
     */
    
    private BasicStroke trazo;
    
    /**
     * Variable para el grosor del trazo
     */
    
    private int grosor;
    
    /**
     * Variable para el tipo del trazo
     */
    
    private int tipo;
}
