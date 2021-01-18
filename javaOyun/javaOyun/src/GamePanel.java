
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;


public class GamePanel extends JFrame {

    public GamePanel(String title) throws HeadlessException {
        super(title);
    }

   public static void main(String[] args){
      
       
       GamePanel ekran = new GamePanel("flying chicken");
       ekran.setBackground(Color.black);
       ekran.setResizable(false);
       ekran.setFocusable(false);
       ekran.setSize(800,600);
       ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ekran.setLocationRelativeTo(null);
       
       Chicken tavuk = new Chicken();
   
       Action komut = new Action();
       komut.setFocusable(true);
       komut.requestFocus();
       komut.addKeyListener(komut);
       komut.setFocusTraversalKeysEnabled(false);

       Egg yumurta = new Egg();
  
       Cat kedi = new Cat();

       ekran.add(komut);
       ekran.setVisible(true);
       komut.mesaj();  
   }
}

