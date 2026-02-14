package MODULE_1_JAVA.TP4_MST_SIDI_TA_2026____BAHIDA_YOUSSEF.src;


public class Main {
    public static void main(String [] args)
    {
        EtudiantDAO gestEtud = new EtudiantDAO();

        // des objets de classe etudiant
        Etudiant e1 = new Etudiant(
            "F88776655", "DUBOIS", "Marie", "F", 
            java.sql.Date.valueOf("2002-07-04"), 
            "marie.dubois@etudiant.fr", "+33612345678", "12 Rue de Rivoli", "France", 
            null, "Étudiante en échange"
        );
        Etudiant e2 = new Etudiant(
            "M13002244", "ALAMI", "Sami", "H", 
            java.sql.Date.valueOf("2000-12-23"), 
            "sami.alami@mail.com", "0612345678", "Av. Hassan II", "Maroc", 
            null, "Étudiant sérieux"
        );
        Etudiant e3 = new Etudiant(
            "G14556677", "BENNANI", "Sara", "F", 
            java.sql.Date.valueOf("2002-05-15"), 
            "sara.b@gmail.com", "0655443322", "Quartier Agdal", "Maroc", 
            null, "Inscrite en Master"
        );
        Etudiant e4 = new Etudiant(
            "R12233445", "IDRISSI", "Omar", "H", 
            java.sql.Date.valueOf("2001-09-10"), 
            "omar.id@yahoo.fr", "0677889900", "Rue Farahat", "Maroc", 
            null, "Redoublant"
        );
        Etudiant e5 = new Etudiant(
            "D99887766", "CHERRADI", "Leila", "F", 
            java.sql.Date.valueOf("1999-01-30"), 
            "leila.ch@outlook.com", "0622331144", "Hay Riad", "Maroc", 
            null, "Déléguée de classe"
        );
        

        //Tester la méthode Enregistrer() l'étudiant e2 et e4 -----------------------------------------------------------------------------------------------
            
            //gestEtud.enregistrer(e1);
            //gestEtud.enregistrer(e2);
            //gestEtud.enregistrer(e3);
            //gestEtud.enregistrer(e4);
            //gestEtud.enregistrer(e5);
            

            
            //System.out.println("L'étudiant : " + e2.getNom() + " " + e2.getPrenom() +" existe : " + gestEtud.exist(e2.getCne()));
            //System.out.println("L'étudiant : " + e3.getNom() + " " + e3.getPrenom() +" existe : " + gestEtud.exist(e3.getCne()));
            //System.out.println("L'étudiant : " + e4.getNom() + " " + e4.getPrenom() +" existe : " + gestEtud.exist(e4.getCne()));
           
            
        //Tester la méthode SupprimerEtudiant()   e2------------------------------------------------------------------------------------------------

            /*

            if(gestEtud.supprimerEtudiant(e2.getCne()))
            {
                System.out.println("L'étudiant : " + e2.getNom() + " " + e2.getPrenom() +" est supprimé ");
                System.out.println("L'étudiant : " + e2.getNom() + " " + e2.getPrenom() +" existe : " + gestEtud.exist(e2.getCne()));
            }

            */

            //gestEtud.supprimerEtudiant(e1.getCne());
            //gestEtud.supprimerEtudiant(e2.getCne());
            //gestEtud.supprimerEtudiant(e3.getCne());
            //gestEtud.supprimerEtudiant(e4.getCne());
            //gestEtud.supprimerEtudiant(e5.getCne());


        //Tester la méthode miseajourEtudiant()   e4------------------------------------------------------------------------------------------------
            
            //if(gestEtud.exist(e4.getCne()))
            //{
                    //gestEtud.miseajourEtudiant(e4);
                    //gestEtud.affichageEtudiant(e4);
            //}
            
            
        //Tester la méthode chercherEtudiant()------------------------------------------------------------------------------------------------

            //gestEtud.affichageEtudiant(gestEtud.chercherEtudiant(e3.getCne())); -> infos
            //gestEtud.affichageEtudiant(gestEtud.chercherEtudiant(e1.getCne()));
            //gestEtud.affichageEtudiant(gestEtud.chercherEtudiant(e2.getCne()));
            //gestEtud.affichageEtudiant(gestEtud.chercherEtudiant(e4.getCne()));
            //gestEtud.affichageEtudiant(gestEtud.chercherEtudiant(e5.getCne()));  -> n'existe pas 

        //Tester la méthode exist() --------------------------------------------------------------------------------------------------------------------------------

            //gestEtud.exist(e3.getCne());
            //gestEtud.exist(e5.getCne());

        //Tester la méthode listEtudiants() et AfficherEtudiant()------------------------------------------------------------------------------------------------

                
            //gestEtud.affichageListeEtudiant(gestEtud.listEtudiant());
        // tester la méthode closeConnection()

        gestEtud.closeConnection();
        new InterfaceEtudiantDAO();

    }
    
}
