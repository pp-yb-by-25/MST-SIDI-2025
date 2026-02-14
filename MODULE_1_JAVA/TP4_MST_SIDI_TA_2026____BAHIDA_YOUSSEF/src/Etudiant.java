package MODULE_1_JAVA.TP4_MST_SIDI_TA_2026____BAHIDA_YOUSSEF.src;

import java.sql.Date;
//on peut importer les autres bibliothèques de Date mais , 
// pour des raisons de conversions , c est mieux d utiliser SQL , 
// pour assurer la compatibilité avec le JDBC


public class Etudiant
{
    //-------------------------------------------------------------------------------------------
    //Attributs 

        private String cne,nom,prenom,genre,email,telephone,adresse,pays,commentaire;
        private Date dateNaissance;
        private byte[] photo;

    //-------------------------------------------------------------------------------------------
    //Constructeur

        public Etudiant
                    (
                        String cne, String nom, String prenom, String genre,
                        Date dateNaissance ,String email, String telephone, 
                        String adresse, String pays,  byte[] photo,String commentaire
                    )
            {
                this.cne = cne;
                this.nom = nom;
                this.prenom = prenom;
                this.genre = genre;
                this.dateNaissance = dateNaissance;
                this.email = email;
                this.telephone = telephone;
                this.adresse = adresse;
                this.pays = pays;
                this.photo = photo;
                this.commentaire = commentaire;
            }
    //-------------------------------------------------------------------------------------------
    //Getters 

        public String getCne(){return this.cne;}
        public String getNom(){return this.nom;}
        public String getPrenom(){return this.prenom;}
        public String getGenre(){return this.genre;}
        public Date   getDateNaissance(){return this.dateNaissance;}
        public String getEmail(){return this.email;}
        public String getTelephone(){return this.telephone;}
        public String getAdresse(){return this.adresse;}
        public String getPays(){return this.pays;}
        public byte[] getPhoto(){return this.photo;}
        public String getCommentaire(){return this.commentaire;}
    //-------------------------------------------------------------------------------------------
    //Setters

        public void setCne(String cne){ this.cne = cne;}
        public void setNom(String nom){ this.nom = nom;}
        public void setPrenom(String prenom){ this.prenom = prenom;}
        public void setGenre(String genre){ this.genre = genre;}
        public void setDateNaissance(Date dateNaissance){ this.dateNaissance = dateNaissance;}
        public void setEmail(String email){ this.email = email;}
        public void setTelephone(String telephone){ this.telephone = telephone;}
        public void setAdresse(String adresse){ this.adresse = adresse;}
        public void setPays(String pays){ this.pays = pays;}
        public void setPhoto(byte[] photo){ this.photo = photo;}
        public void setCommentaire(String commentaire){ this.commentaire = commentaire;}
    //-------------------------------------------------------------------------------------------

}