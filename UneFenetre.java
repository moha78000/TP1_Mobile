import java.awt.*;
import java.lang.reflect.Array;

import javax.swing.*;

class UneFenetre extends JFrame 
{
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250, n=4;
    
    public UneFenetre(){
        setSize(LARG,HAUT);
        setVisible(true);
        Container container = getContentPane();
        container.setLayout (new GridLayout(2 , 1)) ;
        

        
        sonMobile = new UnMobile(LARG/2, HAUT/2);
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
    
    
        Thread [] tableau = new Thread[n];

        for (int i=0; i<n; i++){
            sonMobile = new UnMobile(LARG/n, HAUT/n);
            container.add(sonMobile);
        
            Thread thread_i = new Thread(sonMobile);
            tableau[i] = thread_i;
            thread_i.start();

        
        }

    }
    
}
