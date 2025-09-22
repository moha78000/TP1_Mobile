class Exclusion{};

public class Affichage extends Thread{
    String texte;
    static Exclusion exclusionImpression = new Exclusion();
    public Affichage(String txt){texte = txt;}
    public void run(){
        synchronized(exclusionImpression){
            for (int i=0; i<texte.length(); i++){
                System.out.println(texte.charAt(i));
                try{
                    sleep(100);
                }
                catch (InterruptedException e){}; 
                
            }
        }
    }




}
