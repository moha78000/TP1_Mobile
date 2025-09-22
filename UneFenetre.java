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
        UnMobile sonMobile = new UnMobile(LARG, HAUT);
        container.add(sonMobile);
        Thread thread = new Thread(sonMobile);
        thread.start();
	// TODO 
	// ajouter sonMobile a la fenetre
	// creer une thread laThread avec sonMobile
	// afficher la fenetre
	// lancer laThread 
    }
}
