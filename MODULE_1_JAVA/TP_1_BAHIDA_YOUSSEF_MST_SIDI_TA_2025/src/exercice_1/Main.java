package MODULE_1_JAVA.TP1_BAHIDA_YOUSSEF_MASTER_SIDI_TA_2025.exercice_1;
import java.io.File;

public class Main {
    public static void main (String [] args )
    {
        GestionDossier gd1 = new GestionDossier(new File("D:\\test"));

        gd1.dir();


    }
}
