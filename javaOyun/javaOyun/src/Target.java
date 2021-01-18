
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;


public class Target extends Position{
    
    
    private BufferedImage hedefImage;

    public BufferedImage getHedefImage() {
        return hedefImage;
    }

    public void setHedefImage(BufferedImage hedef) {
        this.hedefImage = hedefImage;
    }
       
     public Target(){
        
        setX(25);
        setY(100);
        
        try {
            hedefImage = ImageIO.read(new FileImageInputStream(new File("target.png")));
        } catch (IOException ex) {
            Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
