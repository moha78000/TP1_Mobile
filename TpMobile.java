//programme d'un mobile se deplacant de la gauche vers la droite de la fenetre-ecran
import java.awt.*;
import javax.swing.*;

public class TpMobile
{
    public static void main(String[] telsArgs) {
	
        new UneFenetre();
        Affichage TA = new Affichage("AAA");
		Affichage TB = new Affichage("BB");
		Affichage TC = new Affichage("CCC");
		Affichage TD = new Affichage("DD");

		TB.start();
		TC.start();
		TA.start();
		TD.start();
 	
    }
}
