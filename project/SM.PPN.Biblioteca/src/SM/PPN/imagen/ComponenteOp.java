package SM.PPN.imagen;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
/**
 * Clase que aplica la operación (i*3)%256 a cada componente del pixel.
 * @author Pedro Parrilla
 */
public class ComponenteOp extends BufferedImageOpAdapter {
    
    /**
     * Constructor del operador por defecto
     */
    
    public ComponenteOp(){
        
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
                
                for( int i = 0; i < 3; ++i ){
                    pixelComp[i] = (pixelComp[i]*3)%256;
                }
                
                destRaster.setPixel(x, y, pixelComp);
            }
        }
        
        return dest;
    }

}
