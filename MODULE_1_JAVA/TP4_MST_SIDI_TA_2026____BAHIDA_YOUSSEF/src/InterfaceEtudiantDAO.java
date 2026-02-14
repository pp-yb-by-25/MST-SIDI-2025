package MODULE_1_JAVA.TP4_MST_SIDI_TA_2026____BAHIDA_YOUSSEF.src;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/*

public class InterfaceEtudiantDAO extends JFrame implements ActionListener{

    private JTextField txtCne, txtNom, txtPrenom, txtGenre,
            txtDate, txtEmail, txtTel, txtAdresse, txtPays, txtCommentaire;

    private JButton btnChercher, btnModifier,btnAfficher,btnImage,btnAjouter,btnSupprimer;

    private EtudiantDAO gestEtud = new EtudiantDAO(); ;
    private Etudiant etudiantCourant;

    public InterfaceEtudiantDAO(){
        
        setTitle("Gestion Etudiant");
        setSize(450, 450);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(13,2,10,10));

        txtCne = new JTextField();
        txtNom = new JTextField();
        txtPrenom = new JTextField();
        txtGenre = new JTextField();
        txtDate = new JTextField();
        txtEmail = new JTextField();
        txtTel = new JTextField();
        txtAdresse = new JTextField();
        txtPays = new JTextField();
        txtCommentaire = new JTextField();

        p.add(new JLabel("CNE",SwingConstants.CENTER));
        p.add(txtCne);
        p.add(new JLabel("Nom",SwingConstants.CENTER));
        p.add(txtNom);
        p.add(new JLabel("Prenom",SwingConstants.CENTER));
        p.add(txtPrenom);
        p.add(new JLabel("Genre",SwingConstants.CENTER));
        p.add(txtGenre);
        p.add(new JLabel("Date (yyyy-mm-dd)",SwingConstants.CENTER));
        p.add(txtDate);
        p.add(new JLabel("Email",SwingConstants.CENTER));
        p.add(txtEmail);
        p.add(new JLabel("Telephone",SwingConstants.CENTER));
        p.add(txtTel);
        p.add(new JLabel("Adresse",SwingConstants.CENTER));
        p.add(txtAdresse);
        p.add(new JLabel("Pays",SwingConstants.CENTER));
        p.add(txtPays);
        p.add(new JLabel("Commentaire",SwingConstants.CENTER));
        p.add(txtCommentaire);

        btnChercher = new JButton("Chercher_Etudiant");
        btnModifier = new JButton("Modifier_Etudiant");
        btnAfficher = new JButton("Afficher_CNEs");
        btnImage    = new JButton("Afficher_Photo");
        btnAjouter  = new JButton("Ajouter_Etudiant");
        btnSupprimer  = new JButton("Supprimer_Etudiant");

        p.add(btnChercher);
        p.add(btnModifier);
        p.add(btnAfficher);
        p.add(btnImage);
        p.add(btnAjouter);
        p.add(btnSupprimer);

        this.add(p);

        // ----------------------------
        // Actions
        // ----------------------------

        btnChercher.addActionListener(this);
        btnModifier.addActionListener(this);
        btnAfficher.addActionListener(this);
        btnImage.addActionListener(this);
        btnAjouter.addActionListener(this);
        btnSupprimer.addActionListener(this);

        this.setVisible(true);
    }


    //Action Performed
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnChercher)
        {
            String cne = JOptionPane.showInputDialog(this,"Veuillez saisir le CNE de l'étudiant");
            

            etudiantCourant = gestEtud.chercherEtudiant(cne);

            if(etudiantCourant == null){
                JOptionPane.showMessageDialog(this,"Etudiant introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
                return;
            }
            txtCne.setText(etudiantCourant.getCne());
            txtNom.setText(etudiantCourant.getNom());
            txtPrenom.setText(etudiantCourant.getPrenom());
            txtGenre.setText(etudiantCourant.getGenre());
            txtDate.setText(String.valueOf(etudiantCourant.getDateNaissance()));
            txtEmail.setText(etudiantCourant.getEmail());
            txtTel.setText(etudiantCourant.getTelephone());
            txtAdresse.setText(etudiantCourant.getAdresse());
            txtPays.setText(etudiantCourant.getPays());
            txtCommentaire.setText(etudiantCourant.getCommentaire());
        }
        else if(e.getSource()== btnModifier)
        {

            if(etudiantCourant == null){
                JOptionPane.showMessageDialog(this,"Cherchez d'abord un étudiant");
                return;
            }

            etudiantCourant.setNom(txtNom.getText());
            etudiantCourant.setPrenom(txtPrenom.getText());
            etudiantCourant.setGenre(txtGenre.getText());
            etudiantCourant.setDateNaissance(java.sql.Date.valueOf(txtDate.getText()));
            etudiantCourant.setEmail(txtEmail.getText());
            etudiantCourant.setTelephone(txtTel.getText());
            etudiantCourant.setAdresse(txtAdresse.getText());
            etudiantCourant.setPays(txtPays.getText());
            etudiantCourant.setCommentaire(txtCommentaire.getText());

            boolean modifier = gestEtud.miseajourEtudiantInterface(etudiantCourant, txtCne.getText(),txtNom.getText(), txtPrenom.getText(), txtGenre.getText(),txtDate.getText(), txtEmail.getText(), txtTel.getText(), txtAdresse.getText(), txtPays.getText(), txtCommentaire.getText());
            if(modifier){JOptionPane.showMessageDialog(this,"Mise à jour réussie");}
            else{JOptionPane.showMessageDialog(this,"Erreur lors de l'ajout");}
            
        }
        else if(e.getSource()== btnAfficher)
        {
            ArrayList<Etudiant> lst = gestEtud.listEtudiant();
            String infos = "";
            for(Etudiant etudiant : lst)
            {
                infos = infos + etudiant.getCne() +"\n";

            }
            JOptionPane.showMessageDialog(this,infos);
        }
        else if(e.getSource()== btnImage)
        {
            String infos = " ";
            JOptionPane.showMessageDialog(this,infos);
        }
        else if(e.getSource()== btnAjouter)
        {
            try
            {
                Etudiant etudiant = new Etudiant(
                txtCne.getText(),
                txtNom.getText(),
                txtPrenom.getText(),
                txtGenre.getText(),
                java.sql.Date.valueOf(txtDate.getText()),   
                txtEmail.getText(),
                txtTel.getText(),
                txtAdresse.getText(),
                txtPays.getText(),
                null,                                       
                txtCommentaire.getText()
                );

                boolean ajouter = gestEtud.enregistrer(etudiant);

                if(ajouter){JOptionPane.showMessageDialog(this,"Etudiant ajouté avec succès","",JOptionPane.INFORMATION_MESSAGE);}
                else{JOptionPane.showMessageDialog(this,"Erreur lors de l'ajout");}

            }
            catch(IllegalArgumentException ex)
            {
                    JOptionPane.showMessageDialog(this, "Format de date invalide (yyyy-mm-dd)","",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()== btnSupprimer)
        {
            String cne = txtCne.getText();
            try
            {
                if(gestEtud.supprimerEtudiant(cne))
                {
                    JOptionPane.showMessageDialog(this, "Etudiant est supprimé", "Suppression ", JOptionPane.DEFAULT_OPTION, null);
                }
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }
}

*/

import java.io.File;
import java.nio.file.Files;
import java.sql.SQLException;

public class InterfaceEtudiantDAO extends JFrame implements ActionListener {

    private JTextField txtCne, txtNom, txtPrenom, txtGenre,
            txtDate, txtEmail, txtTel, txtAdresse, txtPays, txtCommentaire;

    private JButton btnChercher, btnModifier, btnAfficher , btnAjouter, btnSupprimer, btnChoisirPhoto;
    private JLabel lblPhoto; // Zone d'affichage de l'image

    private EtudiantDAO gestEtud = new EtudiantDAO();
    private Etudiant etudiantCourant;
    private byte[] photoBytes = null; // Pour stocker temporairement l'image choisie

    public InterfaceEtudiantDAO() {
        setTitle("Gestion Étudiant - MST SIDI");
        setSize(800, 500); // Fenêtre plus large pour l'image
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        // -infos
        JPanel pForm = new JPanel(new GridLayout(10, 2, 10, 10));
        pForm.setBorder(BorderFactory.createTitledBorder("Informations"));

        txtCne = new JTextField();
        txtNom = new JTextField();
        txtPrenom = new JTextField();
        txtGenre = new JTextField();
        txtDate = new JTextField();
        txtEmail = new JTextField();
        txtTel = new JTextField();
        txtAdresse = new JTextField();
        txtPays = new JTextField();
        txtCommentaire = new JTextField();

        pForm.add(new JLabel(" CNE:")); pForm.add(txtCne);
        pForm.add(new JLabel(" Nom:")); pForm.add(txtNom);
        pForm.add(new JLabel(" Prénom:")); pForm.add(txtPrenom);
        pForm.add(new JLabel(" Genre:")); pForm.add(txtGenre);
        pForm.add(new JLabel(" Date (yyyy-mm-dd):")); pForm.add(txtDate);
        pForm.add(new JLabel(" Email:")); pForm.add(txtEmail);
        pForm.add(new JLabel(" Téléphone:")); pForm.add(txtTel);
        pForm.add(new JLabel(" Adresse:")); pForm.add(txtAdresse);
        pForm.add(new JLabel(" Pays:")); pForm.add(txtPays);
        pForm.add(new JLabel(" Commentaire:")); pForm.add(txtCommentaire);

        // photo
        JPanel pPhoto = new JPanel(new BorderLayout(10, 10));
        pPhoto.setBorder(BorderFactory.createTitledBorder("Photo de l'étudiant"));
        
        lblPhoto = new JLabel("Aucune Image", SwingConstants.CENTER);
        lblPhoto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lblPhoto.setPreferredSize(new Dimension(200, 200));
        
        btnChoisirPhoto = new JButton("Choisir une photo...");
        btnChoisirPhoto.addActionListener(this);
        
        pPhoto.add(lblPhoto, BorderLayout.CENTER);
        pPhoto.add(btnChoisirPhoto, BorderLayout.SOUTH);

        //Boutons
        JPanel pButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        btnChercher = new JButton("Chercher");
        btnModifier = new JButton("Modifier");
        btnAfficher = new JButton("Lister CNEs");
        btnAjouter = new JButton("Ajouter");
        btnSupprimer = new JButton("Supprimer");

        pButtons.add(btnAjouter);
        pButtons.add(btnModifier);
        pButtons.add(btnChercher);
        pButtons.add(btnSupprimer);
        pButtons.add(btnAfficher);

        //Positionnement
        add(pForm, BorderLayout.WEST);
        add(pPhoto, BorderLayout.CENTER);
        add(pButtons, BorderLayout.SOUTH);

        // Ecouteurs
        btnChercher.addActionListener(this);
        btnModifier.addActionListener(this);
        btnAfficher.addActionListener(this);
        btnAjouter.addActionListener(this);
        btnSupprimer.addActionListener(this);

        setVisible(true);
    }

    // Méthode utilitaire pour afficher une image redimensionnée
    private void afficherImage(byte[] imgData) {
        if (imgData != null) {
            ImageIcon icon = new ImageIcon(imgData);
            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            lblPhoto.setIcon(new ImageIcon(img));
            lblPhoto.setText("");
        } else {
            lblPhoto.setIcon(null);
            lblPhoto.setText("Aucune Image");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // choisir photo
        if (e.getSource() == btnChoisirPhoto) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    File f = chooser.getSelectedFile();
                    photoBytes = Files.readAllBytes(f.toPath());
                    afficherImage(photoBytes);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erreur chargement image");
                }
            }
        }

        // chercher
        else if (e.getSource() == btnChercher) {
            String cne = JOptionPane.showInputDialog(this, "Saisir CNE:");
            etudiantCourant = gestEtud.chercherEtudiant(cne);

            if (etudiantCourant != null) {
                txtCne.setText(etudiantCourant.getCne());
                txtNom.setText(etudiantCourant.getNom());
                txtPrenom.setText(etudiantCourant.getPrenom());
                txtGenre.setText(etudiantCourant.getGenre());
                txtDate.setText(String.valueOf(etudiantCourant.getDateNaissance()));
                txtEmail.setText(etudiantCourant.getEmail());
                txtTel.setText(etudiantCourant.getTelephone());
                txtAdresse.setText(etudiantCourant.getAdresse());
                txtPays.setText(etudiantCourant.getPays());
                txtCommentaire.setText(etudiantCourant.getCommentaire());
                photoBytes = etudiantCourant.getPhoto();
                afficherImage(photoBytes);
            } else {
                JOptionPane.showMessageDialog(this, "Étudiant introuvable !");
            }
        }

        // ajouter
        else if (e.getSource() == btnAjouter) {
            try {
                Etudiant etu = new Etudiant(txtCne.getText(), txtNom.getText(), txtPrenom.getText(), 
                    txtGenre.getText(), java.sql.Date.valueOf(txtDate.getText()), txtEmail.getText(), 
                    txtTel.getText(), txtAdresse.getText(), txtPays.getText(), photoBytes, txtCommentaire.getText());
                
                if (gestEtud.enregistrer(etu)) {
                    JOptionPane.showMessageDialog(this, "Étudiant ajouté !");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur: " + ex.getMessage());
            }
        }

        // modifier
        else if (e.getSource() == btnModifier) {
            if (etudiantCourant == null) {
                JOptionPane.showMessageDialog(this, "Cherchez un étudiant d'abord");
                return;
            }
            try {
                    // On met à jour l'objet avec le contenu actuel des champs de texte
                    etudiantCourant.setNom(txtNom.getText());
                    etudiantCourant.setPrenom(txtPrenom.getText());
                    etudiantCourant.setGenre(txtGenre.getText());
                    etudiantCourant.setDateNaissance(java.sql.Date.valueOf(txtDate.getText()));
                    etudiantCourant.setEmail(txtEmail.getText());
                    etudiantCourant.setTelephone(txtTel.getText());
                    etudiantCourant.setAdresse(txtAdresse.getText());
                    etudiantCourant.setPays(txtPays.getText());
                    etudiantCourant.setCommentaire(txtCommentaire.getText());
                    etudiantCourant.setPhoto(photoBytes); 
                    if (gestEtud.modifierInfos(etudiantCourant)) {
                        JOptionPane.showMessageDialog(this, "Modification réussie dans la base de données !");
                    } 
                    else {
                        JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour .", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
            } 
            catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage());
            }
        }
            
        // supprimer
        else if (e.getSource() == btnSupprimer) {
            if (gestEtud.supprimerEtudiant(txtCne.getText())) {
                JOptionPane.showMessageDialog(this, "Supprimé !");
                // On vide tous les champs de texte
                txtCne.setText(""); 
                txtNom.setText("");
                txtPrenom.setText("");
                txtGenre.setText("");
                txtDate.setText("");
                txtEmail.setText("");
                txtTel.setText("");
                txtAdresse.setText("");
                txtPays.setText("");
                txtCommentaire.setText("");

                // On réinitialise la zone de photo
                lblPhoto.setIcon(null);
                lblPhoto.setText("Aucune Image");
                photoBytes = null;       
                etudiantCourant = null;
            }
        }
        
        // lister les cnes 
        else if (e.getSource() == btnAfficher) {
            ArrayList<Etudiant> lst = gestEtud.listEtudiant();
            StringBuilder sb = new StringBuilder("Liste des CNEs:\n");
            for (Etudiant et : lst) sb.append(et.getCne()).append("\n");
            JOptionPane.showMessageDialog(this, sb.toString());
        }
    }
}



