import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
	int saLargeur, saHauteur, sonDebDessin;
	final int sonPas = 10, sonTemps=50, sonCote=40;
	static Semaphore sem;
	UnMobile(int telleLargeur, int telleHauteur , Semaphore s)
    {
	super();
	saLargeur = telleLargeur;
	saHauteur = telleHauteur;
	sem = s;
	setSize(telleLargeur, telleHauteur);
    }

    
	public void run(){
		
		for (sonDebDessin = 0; sonDebDessin < saLargeur / 3; sonDebDessin += sonPas){
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
	    }
		System.out.println("Mobile en attente de la section critique : " + Thread.currentThread().getName());
		
		sem.syncWait();
		for(sonDebDessin=saLargeur / 3 ;  sonDebDessin< 2*(saLargeur)/3 ; sonDebDessin+=sonPas){
			repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
		}
		sem.syncSignal();
		System.out.println("Mobile sorti de la section critique : " + Thread.currentThread().getName());

		for(sonDebDessin=2*(saLargeur)/3 ; sonDebDessin < saLargeur - sonPas  ; sonDebDessin+=sonPas){
			repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
		}


    }


	

    public void paintComponent(Graphics telCG)
    {
	super.paintComponent(telCG);
	   if (sonDebDessin >= saLargeur / 3 && sonDebDessin < (2 * saLargeur) / 3) {
            telCG.setColor(Color.RED); // mobile en section critique
        }
	telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}