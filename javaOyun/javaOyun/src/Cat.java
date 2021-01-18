
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;


public class Cat extends Position{
    
    private BufferedImage kediImage;
   int x,y;

    public BufferedImage getKediImage() {
        return kediImage;
    }

    public void setKediImage(BufferedImage kediImage) {
        this.kediImage = kediImage;
    }
    
    public Cat(){
        
         x = (int)(Math.random()*720);
         y = (int) (Math.random()*550);
            
        setX(x);
        setY(y);
        try {
            kediImage = ImageIO.read(new FileImageInputStream(new File("kedi.png")));
        } catch (IOException ex) {
            Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
