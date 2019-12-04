package SM.PPN.imagen;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
/**
 * Clase que selecciona el valor máximo r, g o b del pixel, y tiende su valor a
 * 255 en caso de que sea mayor que 128. En otro caso lo iguala a 0.
 * Todos los valores que no sean igual que el máximo, se igualan a 0.
 * En caso de coincidir r, g o b como máximos, se le aplica a ambos.
 * @author Pedro Parrilla
 */
public class ColorMaxOp extends BufferedImageOpAdapter {
    
    /**
     * Constructor del operador por defecto
     */
    
    public ColorMaxOp(){
        
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
                
                pixelComp = colorMax(pixelComp);
                
                destRaster.setPixel(x, y, pixelComp);
            }
        }
        
        return dest;
    }
    
    /**
     * Función para asignar el valor de rgb. Esta evalúa el tamaño de cada componente,
     * y se queda con el menor, luego haciendo una comparación con 128 para saber
     * si es menor o mayor
     * @param rgb
     * @return 
     */
    
    public int[] colorMax(int[] rgb){
        int[] pixelAux = {0, 0, 0};
        
        if( rgb[0] > rgb[1] ) {
            
            if( rgb[0] > rgb[2] ) {
                pixelAux[0] = rgb[0]<128?0:255;
            } else {
                pixelAux[2] = rgb[2]<128?0:255;
            }
            
        } else if( rgb[1] > rgb[2] ) {
            pixelAux[1] = rgb[1]<128?0:255;
        } else {
            pixelAux[2] = rgb[2]<128?0:255;
        }

        
        return pixelAux;
    }

}
