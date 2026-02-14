package MODULE_1_JAVA.TP4_MST_SIDI_TA_2026____BAHIDA_YOUSSEF.src;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class EtudiantDAO 
{
    //Atrributs
        private Connection connection;
        //private Statement stat;
    //Constructeur
        public EtudiantDAO()
        {
            connecter();
        }
    //Methdoes
        //Connecter
            public void connecter() 
            {
                String url  = "jdbc:mysql://localhost:3306/dbgestion?user=root&password=root";
                try{
                    this.connection = DriverManager.getConnection(url);
                }
                catch(SQLException e)
                {
                        e.printStackTrace();
                }
            }
        //Enregistrer un objet etudiant
            public boolean enregistrer(Etudiant etudiant)
            {
                //On utilise preparedStatement
                String requete  = "INSERT INTO etudiant (cne, nom, prenom, genre, dateNaissance , email, telephone, adresse, pays, photo, commentaire)"+
                                  " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement prepStatement = connection.prepareStatement(requete))
                {       
                    prepStatement.setString(1,etudiant.getCne());
                    prepStatement.setString(2,etudiant.getNom());
                    prepStatement.setString(3,etudiant.getPrenom());
                    prepStatement.setString(4,etudiant.getGenre());
                    prepStatement.setDate(5,etudiant.getDateNaissance());
                    prepStatement.setString(6,etudiant.getEmail());
                    prepStatement.setString(7,etudiant.getTelephone());
                    prepStatement.setString(8,etudiant.getAdresse());
                    prepStatement.setString(9,etudiant.getPays());
                    prepStatement.setBytes(10,etudiant.getPhoto());
                    prepStatement.setString(11,etudiant.getCommentaire());

                    prepStatement.executeUpdate();
                    return true;
                }

                catch(SQLException e)
                {
                    e.printStackTrace();
                    return false;
                }
            }
        //Supprimer un etudiant selon son CNE
            public boolean supprimerEtudiant(String cne)
            {
                //On sélectionne l'étudiant concerné selon cne
                String requete = "DELETE FROM etudiant WHERE cne=?";
                try(PreparedStatement prepStatement = connection.prepareStatement(requete))
                {
                    prepStatement.setString(1, cne);
                    prepStatement.executeUpdate();
                    System.out.println("Etudiant <"+cne+"> est supprimé");
                    return true;
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                    return false;
                }
            }
        //Mise à jour d'un étudiant objet
            public boolean miseajourEtudiant(Etudiant etudiant)
            {
                Scanner sc = new Scanner(System.in);
                
                System.out.print("Entrer le nouveau Nom : ");
                String nom = sc.nextLine();
                System.out.print("Entrer le nouveau Prenom : ");
                String prenom = sc.nextLine(); 
                System.out.print("Entrer le nouveau Genre (H/F) : ");
                String genre = sc.nextLine();
                System.out.print("Entrer la nouvelle dateNaissance (aaaa-mm-jj) : ");
                String dateNaissanceStr = sc.nextLine();
                System.out.print("Entrer le nouvel email : ");
                String email = sc.nextLine();
                System.out.print("Entrer le nouveau telephone : ");
                String telephone = sc.nextLine();
                System.out.print("Entrer la nouvelle adresse : ");
                String adresse = sc.nextLine();
                System.out.print("Entrer le nouveau pays : ");
                String pays = sc.nextLine();  
                System.out.print("Entrer le nouveau Commantaire : ");
                String commentaire = sc.nextLine();
                

                String requete = "UPDATE etudiant SET  nom = ?, prenom = ? , genre = ? , dateNaissance = ? , email = ? , telephone = ? , adresse = ? , pays = ? , commentaire = ? WHERE cne = ? ";
                try(PreparedStatement prepStatement = connection.prepareStatement(requete))
                {
                    prepStatement.setString(1,nom);
                    prepStatement.setString(2,prenom);
                    prepStatement.setString(3,genre);
                    prepStatement.setDate(4,java.sql.Date.valueOf(dateNaissanceStr));
                    prepStatement.setString(5,email);
                    prepStatement.setString(6,telephone);
                    prepStatement.setString(7,adresse);
                    prepStatement.setString(8,pays);
                    prepStatement.setString(9,commentaire);
                    prepStatement.setString(10, etudiant.getCne());

                    if(prepStatement.executeUpdate()>0)
                    {
                        System.out.println("Etudiant à été mis à jour ! ");
                        sc.close();
                        return true;    
                    }
                    return false;
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                    sc.close();
                    return false;
                }
            }
        // Mise a jour de etudiant methode 2 pour interaface
        public boolean modifierInfos(Etudiant etudiant/* ,String cne,String nom,String prenom,String genre,String date,String email,String telephone,String adresse,String pays,String commentaire*/)
            {
                String requete = "UPDATE etudiant SET  nom = ?, prenom = ? , genre = ? , dateNaissance = ? , email = ? , telephone = ? , adresse = ? , pays = ? , commentaire = ? WHERE cne = ? ; ";
                try(PreparedStatement prepStatement = connection.prepareStatement(requete))
                {
                    prepStatement.setString(1,etudiant.getNom());
                    prepStatement.setString(2,etudiant.getPrenom());
                    prepStatement.setString(3,etudiant.getGenre());
                    prepStatement.setDate(4,etudiant.getDateNaissance());
                    prepStatement.setString(5,etudiant.getEmail());
                    prepStatement.setString(6,etudiant.getTelephone());
                    prepStatement.setString(7,etudiant.getAdresse());
                    prepStatement.setString(8,etudiant.getPays());
                    prepStatement.setString(9,etudiant.getCommentaire());
                    prepStatement.setString(10, etudiant.getCne());

                    if(prepStatement.executeUpdate()>0)
                    {
                        return true;    
                    }
                    return false;
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                    return false;
                }
            }
        // Chercher un étudiant selon son cne
            public Etudiant chercherEtudiant(String cne)
            {
                Etudiant etudiant = new Etudiant(null,null,null,null,null,null,null,null,null,null,null);
                String requete = "SELECT * FROM etudiant WHERE cne = ?";
                try(PreparedStatement prepStateemnt = connection.prepareStatement(requete))
                {
                    prepStateemnt.setString(1,cne);
                    
                    try(ResultSet resultSet = prepStateemnt.executeQuery())
                    {
                        if(resultSet.next())
                        {
                            etudiant.setCne(resultSet.getString(1));
                            etudiant.setNom(resultSet.getString(2));
                            etudiant.setPrenom(resultSet.getString(3));
                            etudiant.setGenre(resultSet.getString(4));
                            etudiant.setDateNaissance(resultSet.getDate(5));
                            etudiant.setEmail(resultSet.getString(6));
                            etudiant.setAdresse(resultSet.getString(7));
                            etudiant.setTelephone(resultSet.getString(8));
                            etudiant.setPays(resultSet.getString(9));
                            etudiant.setPhoto(resultSet.getBytes(10));
                            etudiant.setCommentaire(resultSet.getString(11));

                            return etudiant;
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        // Existe un étudiant selon son cne
            public boolean exist(String cne)
            {
                String requete = "SELECT * FROM etudiant WHERE cne= ?";
                try(PreparedStatement prepStatement = connection.prepareStatement(requete))
                {
                    prepStatement.setString(1,cne);

                    try(ResultSet rs = prepStatement.executeQuery())
                    {
                        if(rs.next())
                        {
                            if(rs.getString(1)!=null)
                            {
                                System.out.println("Etudiant <" + rs.getString(2) + " " + rs.getString(3)  +"> Existe !!!");
                                return true;
                            }
                        }
                        System.out.println("Etudiant <" + cne + "> n' existe pas encore !!");
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                catch (SQLException e) 
                {
                    e.printStackTrace();
                    return false;
                }

                return false;
            }
        // Affichage la liste des étudiants
            public ArrayList<Etudiant> listEtudiant()
            {
                ArrayList<Etudiant> lstEtudiant = new ArrayList<>();
                String requete = "SELECT cne FROM dbgestion.etudiant";
                try( Statement statement = connection.createStatement())
                {
                    ResultSet rs = statement.executeQuery(requete);
                    Etudiant etudiant;
                    while(rs.next())
                    {
                        etudiant = chercherEtudiant(rs.getString(1));
                        lstEtudiant.add(etudiant);
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
                return lstEtudiant;
            }
        // Affichage Etudiant 
            public void affichageEtudiant(Etudiant etudiant)
            {
                if(etudiant!=null)
                {
                    String infos =  "\n--------------------------------------------\n" + 
                                    "\nCne : " + etudiant.getCne() + 
                                    "\nNom : " + etudiant.getNom() + 
                                    "\nPrenom : " + etudiant.getPrenom() + 
                                    "\nGenre : " + etudiant.getGenre() + 
                                    "\nDate de naissance : " + etudiant.getDateNaissance() + 
                                    "\nEmail : " + etudiant.getEmail() + 
                                    "\nTelephone : " + etudiant.getTelephone() + 
                                    "\nAdresse : " + etudiant.getAdresse() + 
                                    "\nPays : " + etudiant.getPays() + 
                                    "\nPhoto : " + etudiant.getPhoto() + 
                                    "\nCommentaire : " + etudiant.getCommentaire() +
                                    "\n--------------------------------------------\n";
                    System.out.println(infos);
                }
                else{System.out.println("Cet étudiant n'existe pas encore !");}
                     
            }
        //Affichage de liste des étudiants 
            public void affichageListeEtudiant(ArrayList<Etudiant> lst)
            {
                for(Etudiant e:lst)
                {
                    this.affichageEtudiant(e);
                }
            }
        // Close Connetion
            public void closeConnection()
            {
                try{
                     if(connection != null){connection.close();}
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        //-----------------------------------------------------------
    
}
