
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;


public class Egg extends Position {
    
    private BufferedImage imageYumurta;

    public BufferedImage getImageYumurta() {
        return imageYumurta;
    }

    public void setImageYumurta(BufferedImage imageYumurta) {
        this.imageYumurta = imageYumurta;
    }
    
    public Egg(){
        
             try {
                    imageYumurta = ImageIO.read(new FileImageInputStream(new File("yumurta.png")));
             } 
             catch (IOException ex) {
                    Logger.getLogger(Egg.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
 
    public Egg(int y){
        
        setY(getDir()+y);

       try {
                    imageYumurta = ImageIO.read(new FileImageInputStream(new File("yumurta.png")));
             } 
             catch (IOException ex) {
                    Logger.getLogger(Egg.class.getName()).log(Level.SEVERE, null, ex);
             }
    } 
}
