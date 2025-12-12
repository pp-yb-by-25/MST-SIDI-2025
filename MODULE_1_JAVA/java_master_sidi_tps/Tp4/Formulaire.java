package MODULE_1_JAVA.java_master_sidi_tps.Tp4;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Formulaire extends Frame implements ActionListener {
    // Déclaration des champs
    TextField cneField, nomField, prenomField, villeField, emailField;
    Checkbox hommeCheckbox, femmeCheckbox;
    Checkbox arCheckbox, frCheckbox, enCheckbox, esCheckbox;
    Button effacerButton, enregistrerButton;
    Choice villeChoice;
    
    public Formulaire() {
        // Frame settings
        setTitle("Formulaire AWT");
        setSize(400, 350);
        setLayout(new BorderLayout());
        
        // Panel principal pour les champs
        Panel panelChamps = new Panel();
        panelChamps.setLayout(new GridLayout(7, 2, 5, 5));
        
        // CNE
        panelChamps.add(new Label("CNE"));
        cneField = new TextField();
        panelChamps.add(cneField);
        
        // Nom
        panelChamps.add(new Label("Nom"));
        nomField = new TextField();
        panelChamps.add(nomField);
        
        // Prénom
        panelChamps.add(new Label("Prénom"));
        prenomField = new TextField();
        panelChamps.add(prenomField);
        
        // Sexe
        panelChamps.add(new Label("Sexe"));
        Panel sexePanel = new Panel();
        CheckboxGroup sexeGroup = new CheckboxGroup();
        hommeCheckbox = new Checkbox("Homme", sexeGroup, false);
        femmeCheckbox = new Checkbox("Femme", sexeGroup, false);
        sexePanel.add(hommeCheckbox);
        sexePanel.add(femmeCheckbox);
        panelChamps.add(sexePanel);
        
        // Ville
        panelChamps.add(new Label("Ville"));
        villeChoice = new Choice();
        villeChoice.add("Casablanca");
        villeChoice.add("Rabat");
        villeChoice.add("Fès");
        villeChoice.add("Marrakech");
        panelChamps.add(villeChoice);
        
        // Email
        panelChamps.add(new Label("Email"));
        emailField = new TextField();
        panelChamps.add(emailField);
        
        // Langue
        panelChamps.add(new Label("Langue"));
        Panel languePanel = new Panel();
        arCheckbox = new Checkbox("AR");
        frCheckbox = new Checkbox("FR");
        enCheckbox = new Checkbox("EN");
        esCheckbox = new Checkbox("ES");
        languePanel.add(arCheckbox);
        languePanel.add(frCheckbox);
        languePanel.add(enCheckbox);
        languePanel.add(esCheckbox);
        panelChamps.add(languePanel);
        
        add(panelChamps, BorderLayout.CENTER);
        
        // Panel pour les boutons
        Panel panelButtons = new Panel();
        effacerButton = new Button("Effacer");
        enregistrerButton = new Button("Enregistrer");
        effacerButton.addActionListener(this);
        enregistrerButton.addActionListener(this);
        panelButtons.add(effacerButton);
        panelButtons.add(enregistrerButton);
        
        add(panelButtons, BorderLayout.SOUTH);
        
        // Menu
        MenuBar menuBar = new MenuBar();
        Menu fichierMenu = new Menu("Fichier");
        fichierMenu.add(new MenuItem("Enregistrer"));
        fichierMenu.add(new MenuItem("Effacer"));
        fichierMenu.add(new MenuItem("Quitter"));
        menuBar.add(fichierMenu);
        
        Menu helpMenu = new Menu("Help");
        helpMenu.add(new MenuItem("Question ?"));
        helpMenu.add(new MenuItem("A propos"));
        menuBar.setHelpMenu(helpMenu);
        setMenuBar(menuBar);
        
        // Fermer la fenêtre
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == effacerButton) {
            cneField.setText("");
            nomField.setText("");
            prenomField.setText("");
            emailField.setText("");
            hommeCheckbox.setState(false);
            femmeCheckbox.setState(false);
            arCheckbox.setState(false);
            frCheckbox.setState(false);
            enCheckbox.setState(false);
            esCheckbox.setState(false);
            villeChoice.select(0);
        } else if(e.getSource() == enregistrerButton) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\parco\\MST\\MST_SIDI_25_Sem1\\MODULE_1_JAVA\\java_master_sidi_tps\\Tp4\\data.txt", true))) {
                bw.write("CNE: " + cneField.getText());
                bw.newLine();
                bw.write("Nom: " + nomField.getText());
                bw.newLine();
                bw.write("Prénom: " + prenomField.getText());
                bw.newLine();
                bw.write("Sexe: " + (hommeCheckbox.getState() ? "Homme" : "Femme"));
                bw.newLine();
                bw.write("Ville: " + villeChoice.getSelectedItem());
                bw.newLine();
                bw.write("Email: " + emailField.getText());
                bw.newLine();
                bw.write("Langue: " + 
                         (arCheckbox.getState() ? "AR " : "") +
                         (frCheckbox.getState() ? "FR " : "") +
                         (enCheckbox.getState() ? "EN " : "") +
                         (esCheckbox.getState() ? "ES " : ""));
                bw.newLine();
                bw.write("-----------------------------");
                bw.newLine();
                bw.flush();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new Formulaire();
    }
}
