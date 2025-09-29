import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

class Exclusion{};
public class Affichage extends Thread{
	String texte; 
	static Exclusion exclusionImpression = new Exclusion();

	public Affichage (String txt){texte=txt;}
	
	public void run(){
		//section critique
		synchronized(exclusionImpression){
			for (int i=0; i<texte.length(); i++){
		    	System.out.print(texte.charAt(i)); // ressource critique
		    	try {sleep(100);} catch(InterruptedException e){};
			} 
		}
		//fin section critique
	}
}