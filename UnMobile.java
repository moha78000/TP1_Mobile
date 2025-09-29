import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur, saHauteur, sonDebDessin;
    final int sonPas = 10, sonTemps=70, sonCote=40;
	Semaphore sem;
    UnMobile(int telleLargeur, int telleHauteur , Semaphore s)
    {
	super();
	saLargeur = telleLargeur;
	saHauteur = telleHauteur;
	sem = s;
	setSize(telleLargeur, telleHauteur);
    }

    
	public void run(){
		
		for (sonDebDessin=0; sonDebDessin < 1/3*(saLargeur-sonDebDessin); sonDebDessin+= sonPas){
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
	    }

		sem.syncWait();
		for(sonDebDessin=1/3*(saLargeur-sonDebDessin) ;  0 < 2/3*(saLargeur-sonDebDessin)  ; sonDebDessin+=sonPas){
			repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
		}
		sem.syncSignal();

		for(sonDebDessin=2/3*(saLargeur-sonDebDessin) ;  2/3*(saLargeur-sonDebDessin) < saLargeur   ; sonDebDessin+=sonPas){
			repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
		}


    }


	

    public void paintComponent(Graphics telCG)
    {
	super.paintComponent(telCG);
	telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}