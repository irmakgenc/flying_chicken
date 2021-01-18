
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Action extends JPanel implements KeyListener,ActionListener{

    Chicken tavuk = new Chicken();
    Egg y = new Egg(tavuk.getY());
    Cat kedi = new Cat();
    Cat kedi2 = new Cat();
    Cat kedi3 = new Cat();
    Target hedef = new Target();
    Target hedef2 = new Target();
    Target hedef3 = new Target();
    
    
    private  int hedefsayisi = 0;
    BufferedImage bulut;
    Timer timer = new Timer(5,this);
    int bayrak1 = 0;
    int bayrak2 = 0;
    int bayrak3 = 0;
    int yDir = 0;
    int flag2 = 0;
    int DirTavukY = 0;
    int flag3 = 0;   
    int level =1;
    int x = 0;
    int kontrolbayrak1 = 1;
    int kontrolbayrak2 = 1;
    int kontrolbayrak3 = 1;
    int byrk = 1;
    int byrk2 = 1;
    int byrk3 = 1;
    Font font = new Font("verdana",Font.PLAIN,20);
    int puan = 0;
    
     public Action() {
        try {
            bulut = ImageIO.read(new FileImageInputStream(new File("bulut.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        timer.start(); 
    }

     public void kontrolkedi(){
         
        if( ((kedi.getX()  <= tavuk.getX() + tavuk.getImage().getWidth()/70 && tavuk.getX() + tavuk.getImage().getWidth()/150 <= kedi.getX()  + kedi.getKediImage().getWidth() /120) && (kedi.getY()  < (tavuk.getY() + tavuk.getImage().getHeight()/70) && tavuk.getY() < kedi.getY()+kedi.getKediImage().getHeight()/70)) ||
            ((kedi2.getX() <= tavuk.getX() + tavuk.getImage().getWidth()/70 && tavuk.getX() + tavuk.getImage().getWidth()/150 <= kedi2.getX() + kedi.getKediImage().getWidth() /120) && (kedi2.getY() < (tavuk.getY() + tavuk.getImage().getHeight()/70) && tavuk.getY() < kedi2.getY()+kedi.getKediImage().getHeight()/70)) ||         
            ((kedi3.getX() <= tavuk.getX() + tavuk.getImage().getWidth()/70 && tavuk.getX() + tavuk.getImage().getWidth()/150 <= kedi3.getX() + kedi.getKediImage().getWidth() /120) &&(kedi3.getY() < (tavuk.getY() + tavuk.getImage().getHeight()/70) && tavuk.getY() < kedi3.getY()+kedi.getKediImage().getHeight()/70)))
        {
             timer.stop();
             
             String message = "\t\t\tGame over!\n" + "\t\t\tTotal Point: " + puan + "P";
             JOptionPane.showMessageDialog(this, message);
             System.exit(0);
        }     
     }
    
     public void mesaj(){
          String message2 = " -This game contains 5 levels.\n -Level changes depending on the scores.\n                                       RULES:\n -At first press ENTER to start to game and move the chicken!!\n -Press CRTL to throw egg!!\n -Hit targets and earn points!!";
          JOptionPane.showMessageDialog(this, message2);
     }
           
     public void kontrolhedef(){
         
         if(flag2==1 && flag3 != 1){
                if(((hedef.getX()  <= (tavuk.getX()+25) && (tavuk.getX()+25) <= (hedef.getX() + hedef.getHedefImage().getWidth()/5)  ) && (hedef.getY()  <= (y.getY()+12) && (y.getY()+12) <= (hedef.getY() + hedef.getHedefImage().getHeight()/5))))
                {
                    bayrak1 = 1;
                    kontrolbayrak1 = 0;        
                }  
                
                
                else if((hedef2.getX() +600  <= (tavuk.getX()+25) && (tavuk.getX()+25) <=(hedef2.getX() + 660 + hedef2.getHedefImage().getWidth()/2)) && ((hedef2.getY() +250) <= y.getY()+12 && y.getY() <= (hedef2.getY() +250)))  
                {
                    bayrak2 = 1;
                    kontrolbayrak2 = 0;
                }
                
                else if((hedef3.getX() <= (tavuk.getX()+25) && (tavuk.getX()+25 )<= ((hedef3.getX() + hedef3.getHedefImage().getWidth()/8)) ) && ((hedef3.getY() +150) <= y.getY()+12 && y.getY()+12 <= (hedef3.getY()+150)))
                {
                    bayrak3 = 1;
                    kontrolbayrak3 = 0;
                }
         }
      
         if(flag2==1 && flag3 == 1){
             
                if(((hedef.getX()  <= (tavuk.getX()+25) && (tavuk.getX()+25) <= (hedef.getX() + hedef.getHedefImage().getWidth()/5)  ) && (hedef.getY()  <= (y.getY()+12+tavuk.getY()) && (y.getY()+12+tavuk.getY()) <= (hedef.getY() + hedef.getHedefImage().getHeight()/5))))
                {
                    bayrak1 = 1;
                    if(kontrolbayrak1 == 1)
                    {
                        hedefsayisi++;
                        puan= puan + 2;
                    }
                    kontrolbayrak1 = 0;
                }  
             
                if(((hedef2.getX() +600) <= (tavuk.getX()+25) && (tavuk.getX()+25) <=(hedef2.getX() + 660 + hedef2.getHedefImage().getWidth()/2)) && ((hedef2.getY() +250) <= (y.getY()+12 + tavuk.getY()) && (y.getY()+12+tavuk.getY()) <= (hedef2.getY() +250 +hedef2.getHedefImage().getHeight()/2)))  
                {
                    bayrak2 = 1;
                    if(kontrolbayrak2 == 1)
                    {
                        hedefsayisi++;
                        puan++;
                    } 
                    kontrolbayrak2 = 0;
              }   
              
                if(((hedef3.getX() <= (tavuk.getX()+25) && (tavuk.getX()+25 )<= (hedef3.getX() + hedef3.getHedefImage().getWidth()/8) ) && ((hedef3.getY() +150) <= (y.getY()+12+tavuk.getY()) && (y.getY()+12+tavuk.getY()) <= (hedef3.getY()+150+hedef3.getHedefImage().getHeight()/8))))
                {
                    bayrak3 = 1;
                      if(kontrolbayrak3 == 1)
                      {
                        hedefsayisi++;
                        puan = puan + 3;
                      }
                    kontrolbayrak3 = 0;
                }
         }       
     }
     
    @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        g.drawImage(bulut, 0, 0, this);
        g.drawImage(tavuk.getImage(),tavuk.getX(),tavuk.getY(), tavuk.getImage().getWidth()/50,tavuk.getImage().getHeight()/50,this);
   
                      if(tavuk.getY() > 549){
                        kedi.x = (int)(Math.random()*400);
                        kedi.y = (int) (Math.random()*400);
                        kedi.setX(kedi.x);
                        kedi.setY(kedi.y);
                        
                        kedi2.x = (int)(Math.random()*400);
                        kedi2.y = (int) (Math.random()*400);
                        kedi2.setX(kedi2.x);
                        kedi2.setY(kedi2.y);
                        
                        kedi3.x = (int)(Math.random()*400);
                        kedi3.y = (int) (Math.random()*400);
                        kedi3.setX(kedi3.x);
                        kedi3.setY(kedi3.y);
                        
                        kontrolbayrak1= 1;
                        kontrolbayrak2= 1;
                        kontrolbayrak3= 1;                                      
                        hedef.setY(x-20);
                        hedef2.setY(x-100);
                        hedef3.setY(x+50);
                        x += 100;
                        
                        if(hedef.getY()>450)
                            hedef.setY(100);
                        
                        if(hedef2.getY()>450)
                            hedef2.setY(100);
                        
                        if(hedef3.getY()>450)
                            hedef3.setY(100);
                      }
      
        g.drawImage(kedi.getKediImage(),kedi.getX(),kedi.getY()    , kedi.getKediImage().getWidth()/70,kedi.getKediImage().getHeight()/70,this);
        g.drawImage(kedi2.getKediImage(),kedi2.getX(),kedi2.getY() , kedi2.getKediImage().getWidth()/70,kedi2.getKediImage().getHeight()/70,this);
        g.drawImage(kedi3.getKediImage(),kedi3.getX(),kedi3.getY() , kedi3.getKediImage().getWidth()/70,kedi3.getKediImage().getHeight()/70,this);
       
            Graphics2D g2D = (Graphics2D) g;
            float alpha = (float) 0.4;
            AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2D.setComposite(composite);// opacity of image hedef
        
                        if(kontrolbayrak1 == 1)
                            g.drawImage(hedef.getHedefImage(), hedef.getX(), hedef.getY(),hedef.getHedefImage().getWidth()/5,hedef.getHedefImage().getHeight()/5, this);
                     
                        if(kontrolbayrak2 == 1)
                            g.drawImage(hedef2.getHedefImage(), hedef2.getX()+600, hedef2.getY()+250,hedef2.getHedefImage().getWidth()/2,hedef2.getHedefImage().getHeight()/2, this);
                     
                        if(kontrolbayrak3 == 1)
                            g.drawImage(hedef3.getHedefImage(), hedef3.getX(), hedef3.getY()+150 ,hedef3.getHedefImage().getWidth()/8,hedef3.getHedefImage().getHeight()/8, this);
         
            alpha = (float) 1.0;
            composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2D.setComposite(composite);// opacity of image hedef
        
                         
                        if(flag2==1 && flag3 != 1)
                            g.drawImage(y.getImageYumurta(),tavuk.getX() + 25 ,y.getY()+ 12 , y.getImageYumurta().getWidth()/100,y.getImageYumurta().getHeight()/100,this);     
                    
                        if(flag2==1 && flag3 == 1)
                            g.drawImage(y.getImageYumurta(),tavuk.getX() + 25 ,y.getY()+ 12 + tavuk.getY(), y.getImageYumurta().getWidth()/100,y.getImageYumurta().getHeight()/100,this);                        
         
         
        kontrolhedef();
        kontrolkedi();   
          
        g.setFont(font);
        g.setColor(Color.BLUE);
          
                        if(hedefsayisi == 0 && flag3 != 1)
                            g.drawString("Level1 : Earn 5 point!!", 250, 300);
     
                        if(hedefsayisi >= 3 && byrk == 1){
                            g.drawString("Level2: Earn 10 points!!", 250, 300);
                            
                            if(hedefsayisi >= 4){
                                 byrk = 0;
                            }
                        }
                        
                        if(hedefsayisi >= 5 && byrk2 == 1){
                            g.drawString("Level3: Earn 15 points!!", 250, 300);
                            
                            if(hedefsayisi >= 6){
                                 byrk2 = 0;
                            }
                        }
                        
                         if(hedefsayisi >= 7 && byrk3 == 1){
                            g.drawString("Level4: Earn 20 points!!", 250, 300);
                            
                            if(hedefsayisi >= 8){
                                 byrk3 = 0;
                            }
                        }
          
                         if(hedefsayisi >= 9){
                            g.drawString("Level5: Earn 25 points!!", 250, 300);
                            
                            if(hedefsayisi >= 10){
                                 byrk = 0;
                                 System.exit(0);
                            }
                        }  
    }

    @Override
    public void repaint() {
        if(flag2 == 1 && flag3 != 1)
        {  
             yDir += 3;
             y.setDir(yDir);
             y.setY(y.getDir());
        }
        
        if(flag2 == 1 && flag3 == 1)
        { 
             yDir += 3;
             y.setDir(yDir);
             y.setY(y.getDir());
        }
         
        if(flag3 == 1){
             DirTavukY += 1;
             tavuk.setDir(DirTavukY);
             tavuk.setY(tavuk.getDir());
             
             if(tavuk.getY() > 550)
             {
                 tavuk.setY(0);
                 DirTavukY = 0;
                 tavuk.setDir(0);
             }
        }
        super.repaint();
    }
   
    @Override
    public void keyTyped(KeyEvent e) {  
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        
        if(c == KeyEvent.VK_LEFT){
            
            if(tavuk.getX() <= 0)
                   tavuk.setX(0); 
            else
                tavuk.setX(tavuk.getX() - 20);  
        }
        
        else if(c == KeyEvent.VK_RIGHT){
        
            if(tavuk.getX() >= 720)
                   tavuk.setX(720);             
            else
                 tavuk.setX(tavuk.getX() + 20);
        }
        
        if(c == KeyEvent.VK_CONTROL){
             
             yDir = 0;
             y.setY(0);
             y.setDir(0);
             tavuk.flag = 1;
             flag2 = 1;
         }
         
        if(c == KeyEvent.VK_ENTER)
             flag3 = 1;  
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    } 
}
