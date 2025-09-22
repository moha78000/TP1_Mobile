import java.awt.*;
import javax.swing.*;

class UneFenetre extends JFrame 
{
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250;
    
    public UneFenetre()
    {
        setSize(LARG,HAUT);
        setVisible(true);
        Container container = getContentPane();
        container.setLayout (new GridLayout(2 , 1)) ;
        
        UnMobile sonMobile = new UnMobile(LARG/2, HAUT/2);
        UnMobile sonMobile2 = new UnMobile(LARG/2, HAUT/2);
        
        container.add(sonMobile);
        container.add(sonMobile2);
    
        
        Thread thread1 = new Thread(sonMobile);
        Thread thread2 = new Thread(sonMobile2);
    

        thread1.start(); 
        thread2.start();
	// TODO 
	// ajouter sonMobile a la fenetre
	// creer une thread1 laThread avec sonMobile
	// afficher la fenetre
	// lancer laThread 
    }
}
