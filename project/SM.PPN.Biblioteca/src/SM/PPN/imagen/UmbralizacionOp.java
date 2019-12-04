package SM.PPN.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase que aplica el efecto de umbralización a la imágen, tomando como referencia
 * el valor asignado a la variable umbral
 * @author Pedro Parrilla
 */
public class UmbralizacionOp extends BufferedImageOpAdapter {
    
    /**
     * Constructor del operador de umbralización
     * @param umbral Valor del umbral
     */
    
    public UmbralizacionOp(int umbral){
        this.umbral = umbral;
    }
    
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if(src == null) {
            throw new NullPointerException("src image is null");
        }
        if(dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        int[] pixelComp;
        double umbralRGB;
        
        for( int x = 0; x < src.getWidth(); ++x ){
            for( int y = 0; y < src.getHeight(); ++y ){
                pixelComp = null;
                pixelComp = srcRaster.getPixel(x, y, pixelComp);
                
                umbralRGB = (pixelComp[0] + pixelComp[1] + pixelComp[2]) / 3;

                if (umbralRGB < this.umbral){
                    pixelComp[0] = pixelComp[1] = pixelComp[2] = 0;
                    destRaster.setPixel(x, y, pixelComp);
                } else {
                    pixelComp[0] = pixelComp[1] = pixelComp[2] = 255;
                    destRaster.setPixel(x, y, pixelComp);
                }
                
                
            }
        }
        
        return dest;
    }
    
    /**
     * Variable utilizada para definir el umbral
     */
    
    private final int umbral;

}
