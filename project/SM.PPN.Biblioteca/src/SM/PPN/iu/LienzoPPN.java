package SM.PPN.iu;

import SM.PPN.graficos.EllipsePPN;
import SM.PPN.graficos.FShapePPN;
import SM.PPN.graficos.LinePPN;
import SM.PPN.graficos.RectanglePPN;
import SM.PPN.graficos.ShapePPN;
import SM.PPN.graficos.TrazoPPN;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Panel donde se gestionan los objetos propios definidos en gráficos, para su
 * dibujado o modificación.
 * @author Pedro Parrilla
 */
public class LienzoPPN extends javax.swing.JPanel {

    /**
     * Creates new form LienzoPPN
     */
    public LienzoPPN() {
        initComponents();
        vShape = new ArrayList();
        shape = null;
        drawtype = DrawType.LINE;
        p1 = p2 = null;
        cTrazo = fColor1 = fColor2 = Color.BLACK;
        gTrazo = 2;
        tTrazo = TrazoPPN.CONT;
        dirDegradado = FShapePPN.HOR;
        isRelleno = isRender = isTransparent = isDegradado= false;
        transp = 1.0f;
        rectangle = null;
        isSelected = false;
        areaClip = new Rectangle2D.Float(0, 0, 200, 200);
    }
    
    @Override
    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setClip(areaClip);

        vShape.forEach((s) -> {
            s.paint(g2d);
        });
        
    }
    
    /**
     * Creación de la figura según los parámetros pasados
     */
    
    private void createShape(){
        shape = null;
        switch(drawtype){
            case POINT:
            case LINE:
                shape = new LinePPN(p1, p2);
                break;
                
            case RECTANGLE:
                shape = new RectanglePPN(p1.x, p1.y, 0, 0);
                break;
            
            case ELLIPSE:
                shape = new EllipsePPN(p1.x, p1.y, 0, 0);
                break;
                
        }
        setProperties();
        vShape.add(shape);
        this.repaint();
    }
    
    /**
     * Actualización de la figura según los parámetros definidos
     * Utilizada para finalizar el dibujo
     */
    
    private void updateShape(){
        switch(drawtype){
            case LINE:
                ((LinePPN)shape).setLine(p1, p2);
                break;
            case RECTANGLE:
                ((RectanglePPN)shape).setRectangle(p1, p2);
                break;
            case ELLIPSE:
                ((EllipsePPN)shape).setEllipse(p1, p2);
                break;
        }

        this.repaint();
        
    }
    
    /**
     * Asignación de las propiedades de la figura dibujada.
     * Algunas de ellas son comunes y otras son referidas a objetos que heredan
     * de FShapePPN
     */
    
    private void setProperties(){
        shape.setTransparent(transp);
        shape.setRender(isRender);
        shape.setTrazo(cTrazo, gTrazo, tTrazo);
        if(shape instanceof FShapePPN){
            ((FShapePPN) shape).setIsRelleno(isRelleno);
            ((FShapePPN) shape).setIsDegradado(isDegradado);
            ((FShapePPN) shape).setDegradado(fColor1, fColor2, dirDegradado);
        }
    }
    
    /**
     * Devolución del array de formas
     * @return Vector de formas
     */

    public ArrayList<ShapePPN> getvShape() {
        return vShape;
    }

    /**
     * Devolución del tipo de figura a dibujar
     * @return Tipo de figura
     */
    
    public DrawType getDrawtype() {
        return drawtype;
    }
    
    /**
     * Asignación del tipo de figura a dibujar
     * @param drawtype 
     */

    public void setDrawtype(DrawType drawtype) {
        this.drawtype = drawtype;
    }
    
    /**
     * Devolución del color del trazo
     * @return Color del trazo
     */

    public Color getcTrazo() {
        return cTrazo;
    }
    
    /**
     * Asignación del color del trazo
     * @param cTrazo Color del trazo
     */

    public void setcTrazo(Color cTrazo) {
        this.cTrazo = cTrazo;
    }
    
    /**
     * Devolución del color del degradado 1
     * @return Color del degradado 1
     */

    public Color getfColor1() {
        return fColor1;
    }
    
    /**
     * Asignación del color del degradado 1
     * @param fColor1 Color del degradado 1
     */

    public void setfColor1(Color fColor1) {
        this.fColor1 = fColor1;
    }
    
    /**
     * Devolución del color del degradado 2
     * @return Color del degradado 2
     */

    public Color getfColor2() {
        return fColor2;
    }
    
    /**
     * Asignación del color del degradado 2
     * @param fColor2 Color del degradado 2
     */

    public void setfColor2(Color fColor2) {
        this.fColor2 = fColor2;
    }
    
    /**
     * Devolución del grosor del trazo
     * @return Grosor del trazo
     */

    public int getgTrazo() {
        return gTrazo;
    }
    
    /**
     * Asignación del grosor del trazo
     * @param gTrazo Grosor del trazo
     */

    public void setgTrazo(int gTrazo) {
        this.gTrazo = gTrazo;
    }
    
    /**
     * Devolución del tipo de trazo
     * @return Tipo del trazo
     */

    public int gettTrazo() {
        return tTrazo;
    }
    
    /**
     * Asignación del tipo de trazo
     * @param tTrazo Tipo del trazo
     */

    public void settTrazo(int tTrazo) {
        this.tTrazo = tTrazo;
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
     * @param dirDegradado 
     */

    public void setDirDegradado(int dirDegradado) {
        this.dirDegradado = dirDegradado;
    }
    
    /**
     * Devolución del estado relleno
     * @return Estado del relleno
     */

    public boolean getIsRelleno() {
        return isRelleno;
    }
    
    /**
     * Asignación del estado relleno
     * @param isRelleno Estado del relleno
     */

    public void setIsRelleno(boolean isRelleno) {
        this.isRelleno = isRelleno;
    }
    
    /**
     * Devolución del estado renderizado
     * @return Estado del renderizado
     */

    public boolean getIsRender() {
        return isRender;
    }
    
    /**
     * Asignación del estado renderizado
     * @param isRender Estado del renderizado
     */

    public void setIsRender(boolean isRender) {
        this.isRender = isRender;
    }
    
    /**
     * Devolución del estado transparente
     * @return Estado del transparente
     */

    public boolean getIsTransparent() {
        return isTransparent;
    }
    
    /**
     * Asignación del estado transparente
     * @param isTransparent Estado del transparente
     */

    public void setIsTransparent(boolean isTransparent) {
        this.isTransparent = isTransparent;
        
    }
    
    /**
     * Devolución del estado degradado
     * @return Estado del degradado
     */
    
    public boolean getIsDegradado() {
        return isDegradado;
    }
    
    /**
     * Asignación del estado degradado
     * @param isDegradado Estado del degradado
     */
    
    public void setIsDegradado(boolean isDegradado) {
        this.isDegradado = isDegradado;
    }
    
    /**
     * Devolución de la transparencia
     * @return Valor de la transparencia
     */

    public float getTransp() {
        return transp;
    }
    
    /**
     * Asignación de la transparencia
     * @param transp Valor de la transparencia
     */

    public void setTransp(float transp) {
        this.transp = transp;
    }
    
    /**
     * Activación de la selección de la figura
     * @param i Indice del objeto seleccionado
     */
    
    public void setSelected( int i ){
        vShape.remove(rectangle);
        rectangle = vShape.get(i).getBounds();
        rectangle.setTrazo(Color.RED, 2, TrazoPPN.PUNT);
        vShape.add(rectangle);
        isSelected = true;
        repaint();
    }
    
    /**
     * Eliminación del rectangulo que rodea la figura
     */
    
    public void deleteBound(){
        vShape.remove(rectangle);
        rectangle = null;
        isSelected = false;
        repaint();
    }
    
    /**
     * Definición del área para dibujar
     * @param w Ancho del área
     * @param h Alto del área
     */
    
    public void setAreaClip( int w, int h ){
        areaClip = new Rectangle2D.Float(0, 0, w, h);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(254, 254, 254));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento para controlar el movimiento del ratón para dibujar la figura
     * @param evt Evento generado por el ratón
     */
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        p2 = evt.getPoint();
        if(this.drawtype != DrawType.MOVE)
            updateShape();
    }//GEN-LAST:event_formMouseDragged

    /**
     * Evento para controlar el click del ratón para dibujar una nueva figura
     * @param evt Evento generado por el ratón
     */
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        p1 = p2 = evt.getPoint();
        if(this.drawtype != DrawType.MOVE)
            createShape();
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    /**
     * Vector donde se guardan las figuras a dibujar
     */
    
    private ArrayList<ShapePPN> vShape;
    
    /**
     * Figura utilizada para guardarla en el array
     */
    
    private ShapePPN shape;
    
    /**
     * Variable enumerado para indicar la figura a dibujar
     */
    
    private DrawType drawtype;
    
    /**
     * Variables puntos utilizadas para la generación de las formas
     */
    
    private Point p1, p2;
    
    /**
     * Variables del color del trazo y del relleno para el degradado
     */
    
    private Color cTrazo, fColor1, fColor2;

    /**
     * Variables utilizadas para el grosor y el tipo del trazo
     */
    
    private int gTrazo, tTrazo;
    
    /**
     * Variable que indica la dirección del degradado
     */
    
    private int dirDegradado;
    
    /**
     * Variables que controlan si la figura tiene relleno, está renderizada,
     * es transparente o tiene degradado
     */
    
    private boolean isRelleno, isRender, isTransparent, isDegradado;
    
    /**
     * Variable que establece el canal alpha de transparencia
     */
    
    private float transp;
    
    /**
     * Rectángulo que rodea al objeto seleccionado
     */
    
    private RectanglePPN rectangle;
    
    /**
     * Variable para controlar si un objeto está seleccionado para su modificación
     */
    
    private boolean isSelected;
    
    /**
     * Rectangulo utilizado para delimitar el área de dibujo
     */
    
    private Rectangle2D areaClip;
}
