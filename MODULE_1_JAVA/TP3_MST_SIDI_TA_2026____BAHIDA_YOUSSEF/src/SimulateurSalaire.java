package MODULE_1_JAVA.TP3_MST_SIDI_TA_2026____BAHIDA_YOUSSEF.src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SimulateurSalaire extends JFrame implements ActionListener 
{
    
    // Attributs -------------------------------------------------------

        // ComboBox
            private JComboBox<Integer> echell_cb,echelon_cb;
            private JComboBox<String> zone_cb;
        // Boutons Radio 
            private JRadioButton btn_Oui,btn_Non;
            private ButtonGroup marier_Grp ;
        // Spinner
            private JSpinner nb_enfant;
        // Label resultat
            private JLabel lb_resultat = new JLabel("",SwingConstants.LEFT); ;
        // Boutons effacer , enreg , quitter
            private JButton btn_effacer,btn_enregistrer,btn_quitter;
        // Couleurs utilisées
            private Color lbColor;
            private Color comboColor;
            private Color resultColor;
        // Font
            private Font lb_font;

    // Constructeurs  ----------------------------------------------------

        public SimulateurSalaire()
        {
            // Configuration initiale
                this.setTitle("Simulateur Salaire");
                this.setResizable(false);
                this.setSize(650,820);
                this.setLayout(null);
                this.setBackground(Color.LIGHT_GRAY);
                this.setIconImage(new ImageIcon(getClass().getResource("icones/iconInterface.png")).getImage());
                this.setLocation(450,100);
                
            // Éléments 
                // Couleurs utilisées
                    lbColor       = new Color(221, 153, 255);  
                    comboColor    = new Color(204, 204, 0);
                    resultColor   = new Color(204, 255, 204);
                // Font 
                    lb_font = new Font("Arial",Font.BOLD,18);
                    
                // Echelle 
                    JLabel lb_echell = new JLabel("Echelle",SwingConstants.CENTER);
                    lb_echell.setOpaque(true);
                    lb_echell.setBackground(lbColor);
                    lb_echell.setBounds(100,150,150,40);
                    lb_echell.setFont(lb_font);
                    
                    echell_cb = new JComboBox<>(new Integer[]{8,9,10,11});
                    echell_cb.setBackground(comboColor);
                    echell_cb.setFont(lb_font);
                    echell_cb.setBounds(270,150,150,40);
                    //Ajout 
                        this.add(lb_echell);
                        this.add(echell_cb);

                // Echelon
                    JLabel lb_echelon = new JLabel("Echelon",SwingConstants.CENTER);
                    lb_echelon.setOpaque(true);
                    lb_echelon.setBackground(lbColor);
                    lb_echelon.setBounds(100,220,150,40);
                    lb_echelon.setFont(lb_font);
                    
                    echelon_cb = new JComboBox<>(new Integer[]{1,2,3,4,5,6,7,8,9,10});
                    echelon_cb.setBackground(comboColor);
                    echelon_cb.setFont(lb_font);
                    echelon_cb.setBounds(270,220,150,40);
                    //Ajout 
                        this.add(lb_echelon);
                        this.add(echelon_cb);

                // Zone 
                    JLabel lb_zone = new JLabel("Zone",SwingConstants.CENTER);
                    lb_zone.setOpaque(true);
                    lb_zone.setBackground(lbColor);
                    lb_zone.setBounds(100,290,150,40);
                    lb_zone.setFont(lb_font);
                    
                    zone_cb = new JComboBox<>(new String[]{"A","B","C"});
                    zone_cb.setBackground(comboColor);
                    zone_cb.setFont(lb_font);
                    zone_cb.setBounds(270,290,150,40);
                    //Ajout 
                        this.add(lb_zone);
                        this.add(zone_cb);

                // Marier 
                    JLabel lb_marier = new JLabel("Marié",SwingConstants.CENTER);
                    lb_marier.setOpaque(true);
                    lb_marier.setBackground(lbColor);
                    lb_marier.setBounds(100,360,150,40);
                    lb_marier.setFont(lb_font);
                    
                    btn_Oui = new JRadioButton("oui");
                    btn_Non = new JRadioButton("non");

                    btn_Oui.setFont(lb_font);
                    btn_Non.setFont(lb_font);

                    btn_Oui.setBounds(270,360,80,40);
                    btn_Non.setBounds(350,360,80,40);

                    marier_Grp =  new ButtonGroup();

                    marier_Grp.add(btn_Non);
                    marier_Grp.add(btn_Oui);
                    //Ajout 
                        this.add(lb_marier);
                        this.add(btn_Oui);
                        this.add(btn_Non);

                // Nombre d'enfants
                    JLabel lb_nbEnfant = new JLabel("Nombre d'enfant",SwingConstants.CENTER);
                    lb_nbEnfant.setOpaque(true);
                    lb_nbEnfant.setBackground(lbColor);
                    lb_nbEnfant.setBounds(100,420,150,40);
                    lb_nbEnfant.setFont(lb_font);
                    
                    nb_enfant = new JSpinner(new SpinnerNumberModel(0,0,4,1));
                    nb_enfant.setBackground(comboColor);
                    nb_enfant.setFont(lb_font);
                    nb_enfant.setBounds(270,420,150,40);
                    //Ajout 
                        this.add(lb_nbEnfant);
                        this.add(nb_enfant);

                // Resultat de calcul de salaire
                    lb_resultat.setText("Resultat :");
                    lb_resultat.setOpaque(true);
                    lb_resultat.setBackground(resultColor);
                    lb_resultat.setBounds(100,500,320,40);
                    lb_resultat.setFont(lb_font);
                    //Ajout
                        this.add(lb_resultat);

                // Boutons effacer , enregitrer , quitter 
                    //redimmensionner les images
                    
                    btn_effacer     = new JButton(new ImageIcon((new ImageIcon(getClass().getResource("icones/iconDelete.png")).getImage()).getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
                    btn_enregistrer = new JButton(new ImageIcon((new ImageIcon(getClass().getResource("icones/iconDonee.png")).getImage()).getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
                    btn_quitter     = new JButton(new ImageIcon((new ImageIcon(getClass().getResource("icones/iconExit.png")).getImage()).getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
                    
                    btn_effacer.setBounds(180,650,70,70);
                    btn_enregistrer.setBounds(270,650,70,70);
                    btn_quitter.setBounds(450,650,70,70);
                    //ajout 
                        this.add(btn_effacer);
                        this.add(btn_enregistrer);
                        this.add(btn_quitter);

            // Listeners

                btn_effacer.addActionListener(this);
                btn_enregistrer.addActionListener(this);
                btn_quitter.addActionListener(this);

            // SetVisible
                this.setVisible(true);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    // Methodes ----------------------------------------------------------
        // ActionListener
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    if(e.getSource()==btn_effacer)
                    {
                        if(JOptionPane.showConfirmDialog(this, 
                            "Voulez-vous réinitialiser le simulateur ?",
                            "Réinitialisation",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.DEFAULT_OPTION,
                            (new ImageIcon
                                (new ImageIcon(
                                    getClass().getResource("icones/iconEffacerFait.gif")
                            ).getImage().getScaledInstance(150, 150, Image.SCALE_FAST))))==JOptionPane.YES_NO_OPTION)
                        {
                            echell_cb.setSelectedIndex(0);
                            echelon_cb.setSelectedIndex(0);
                            zone_cb.setSelectedIndex(0);

                            btn_Non.setSelected(false);
                            btn_Oui.setSelected(false);

                            nb_enfant.setValue(0);
                            
                            lb_resultat.setText("Resultat : ");
                        }
                    }
                    else if(e.getSource()==btn_enregistrer)
                    {
                        // salaire= echell*500+echlon*100+zone+marie+nb_enfant*300;
                        if(JOptionPane.showConfirmDialog(
                            this,
                            "Voulez vous calculer le salaire ?",
                            "Calculer",JOptionPane.YES_NO_OPTION,
                            JOptionPane.DEFAULT_OPTION,
                            new ImageIcon(
                                new ImageIcon(
                                    getClass().getResource("icones/iconDone.gif")
                                ).getImage().getScaledInstance(150, 150, Image.SCALE_FAST)
                            )
                        )==JOptionPane.YES_NO_OPTION)
                        {

                            int valZone = 0;
                            switch((String)zone_cb.getSelectedItem())
                            {
                                case "A":
                                    valZone = 0;
                                    break;
                                case "B":
                                    valZone = 100;
                                    break;
                                case "C":
                                    valZone = 200;
                                    break;
                            }
                            int valMarie = btn_Oui.isSelected() ? 30 : 0;
                            int salaire  = ((Integer) echell_cb.getSelectedItem())*500 
                                          + ((Integer) echelon_cb.getSelectedItem())*100
                                          +  valZone + valMarie +((Integer) nb_enfant.getValue())*300;
                            //resultat.setText("Resultat : " + salaire + " Dirhams");             
                                          
                            
                            lb_resultat.setText("Resultat : " + (double) salaire + " Dirhams");
                        }
                    }
                    else if(e.getSource()==btn_quitter)
                    {
                        if(JOptionPane.showConfirmDialog(
                            this,
                            "Voulez-vous quitter",
                            "Quitter",JOptionPane.YES_NO_OPTION,
                            JOptionPane.DEFAULT_OPTION,
                            (new ImageIcon(
                                new ImageIcon(getClass().getResource("icones/iconexitt.gif")).getImage().
                                getScaledInstance(150, 150, Image.SCALE_FAST)
                            )
                        )

                        )==JOptionPane.YES_NO_OPTION)
                        {
                            System.exit(0);
                        }
                    }
                    else{}
                    
            }
           


        
    // --------------------------------------------------------------------------------------------------------

}
