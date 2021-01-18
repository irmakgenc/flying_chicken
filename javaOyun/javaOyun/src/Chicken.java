
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;


public class Chicken extends Position {
    
    private BufferedImage tavukImage;

    public BufferedImage getImage() {
        return tavukImage;
    }

    public void setImage(BufferedImage image) {
        this.tavukImage = image;
    }
    
    public Chicken(){
       
        setX(0);
        setY(4);
        
        try {
            tavukImage = ImageIO.read(new FileImageInputStream(new File("tavuk1.png")));
        } catch (IOException ex) {
            Logger.getLogger(Chicken.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }  
}
