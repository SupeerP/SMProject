package SM.PPN.imagen;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
/**
 * Clase que aplica el efecto Sepia a la imagen.
 * @author Pedro Parrilla
 */
public class SepiaOp extends BufferedImageOpAdapter {
    
    /**
     * Constructor por defecto
     */
    
    public SepiaOp(){
        
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
        
        for( int x = 0; x < src.getWidth(); ++x ){
            for( int y = 0; y < src.getHeight(); ++y ){
                pixelComp = null;
                pixelComp = srcRaster.getPixel(x, y, pixelComp);
                
                double sepiaR = Math.min(255, 0.393*pixelComp[0] + 0.686*pixelComp[1] + 0.189*pixelComp[2]);
                double sepiaG = Math.min(255, 0.349*pixelComp[0] + 0.686*pixelComp[1] + 0.168*pixelComp[2]);
                double sepiaB = Math.min(255, 0.272*pixelComp[0] + 0.534*pixelComp[1] + 0.131*pixelComp[2]);
                pixelComp[0] = (int) sepiaR;
                pixelComp[1] = (int) sepiaG;
                pixelComp[2] = (int) sepiaB;
                destRaster.setPixel(x, y, pixelComp);
            }
        }
        
        return dest;
    }
}
