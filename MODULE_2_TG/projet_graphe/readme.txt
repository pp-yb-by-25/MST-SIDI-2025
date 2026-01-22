Documentation du Projet : MST-SIDI-2025 (Théorie des Graphes)

Ce projet est une application de bureau complète développée en Python, permettant de créer, manipuler et analyser des graphes à l'aide d'algorithmes mathématiques standards, avec un système de gestion d'utilisateurs et d'archivage des résultats.
1. Prérequis et Installation
Version de Python recommandée

    Python 3.8 ou version supérieure est requise pour assurer la compatibilité avec les bibliothèques de calcul et d'interface graphique.

Bibliothèques installées automatiquement

Le script inclut un gestionnaire d'installation automatique. Au premier lancement, il vérifie et installe les dépendances suivantes via pip :

    networkx : Pour la création, la manipulation et l'étude de la structure des graphes complexes.

    matplotlib : Pour la visualisation graphique du réseau.

    fpdf : Pour la génération de rapports professionnels au format PDF.

    tkinter (généralement inclus avec Python) : Pour l'interface utilisateur.

2. Fonctionnalités Principales
Gestion des Graphes

    Édition Manuelle : Ajouter des sommets, créer des arêtes avec des poids spécifiques, et supprimer des éléments.

    Importation CSV : Charger des structures de graphes depuis un fichier externe (Colonnes : source, target, weight).

    Génération Aléatoire : Créer instantanément un graphe de 7 sommets et 10 arêtes pour des tests rapides.

Algorithmes Inclus

L'application permet d'exécuter et de visualiser en rouge les résultats des algorithmes suivants :

    Parcours : BFS (Largeur) et DFS (Profondeur).

    Coloration : Algorithme Glouton et Welsh-Powell (avec gestion de palette de couleurs).

    Arbre Couvrant Minimum (MST) : Algorithmes de Prim et Kruskal.

    Plus Court Chemin : Algorithme de Dijkstra.

    Optimisation de Flux : Algorithme de Ford-Fulkerson (Flot Max).

3. Système Multi-Utilisateurs

L'application intègre une base de données locale SQLite (users_labo.db) pour gérer la confidentialité :

    Inscription : Enregistrement d'un nom, email et mot de passe.

    Sécurité : Les mots de passe ne sont pas stockés en clair, ils sont hachés via SHA-256.

    Sessions : Chaque utilisateur accède à son propre espace de travail. Le nom de l'utilisateur connecté s'affiche dans l'en-tête et sur les rapports exportés.

4. Guide de l'Archive et Historique

Le système d'archives permet de conserver une trace de tous les calculs effectués durant une session.

    Traitement en cours : À chaque exécution d'algorithme, le résultat textuel s'affiche dans le panneau de droite et une capture d'image du graphe est générée.

    Sauvegarde : En cliquant sur "Sauvegarder Historique", les données (titre, texte, chemin de l'image, date) sont envoyées vers la base de données SQLite.

    Consultation : Le bouton "Archives" permet de basculer la vue pour consulter les anciens résultats enregistrés par l'utilisateur connecté.

5. Exportation des Résultats

L'application propose deux modes d'exportation en PDF :

    Exportation Globale ("Exporter Rapport PDF") : Génère un document contenant l'intégralité des analyses effectuées durant la session actuelle, incluant le nom de l'auteur, les détails textuels et les images des graphes.

    Exportation par Date ("Exporter Archives par Date") :

        Cliquez sur le bouton bleu dans la barre latérale droite.

        Saisissez une date au format AAAA-MM-JJ (ex: 2025-05-20).

        L'application filtre la base de données et génère un PDF contenant uniquement les travaux effectués à cette date précise.

Utilisation Rapide (Workflow)

    Lancez le script et créez un compte.

    Dessinez votre graphe (ou importez un CSV via le bouton "Générer Template" pour voir le format).

    Lancez un algorithme (ex: Dijkstra).

    Sauvegardez le résultat pour l'envoyer en base de données.

    Exportez votre travail final en PDF pour remise de projet.