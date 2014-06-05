Verhaeghe Emeline, Digeon Aurélie, Galas Alain


Fonctionnalités minimales:


•Créer une classe à partir d'une fenêtre de saisie de son nom   =>Fait
•Sélectionner une classe pour pouvoir la manipuler  =>Fait
•Déplacer une classe sélectionnée sur la feuille de dessein  =>Fait
•Ajouter un attribut à une classe existante. Un attribut à au minimum un nom =>Fait
(voir Fonctionnalités Supplémentaires)
•Ajouter une méthode à une classe existante. Une méthode à au minimum un nom =>Fait
(voir Fonctionnalités Supplémentaires)


Fonctionnalités supplémentaires:


•Gestion du type et/ou de la visibilité des attributs et méthodes =>Fait
•Gestion des paramètres des méthodes (dans un premier temps sous la forme d'une simple chaîne de caractères)  =>Fait
•Suppression d'un attribut/méthode d'une classe =>Fait
•Gestion du lien d'héritage entre classes, avec point d'ancrage sur les classes pour que le lien «suive» les classes déplacées =>Fait
•Gestion des associations entre classes, avec point d’ancrage =>Fait
•Attacher un nom sur une association, le nom devra «suivre» l'association quand celle-ci se déplace (ce qu'elle fait quand les classes qu'elle relie se déplacent) =>Fait
•Sauvegarde/rechargement d'un modèle UML =>Fait
•autre fonctionnalité:
	-Bloc note lié à un projet , à l’usage de l’utilisateur pour y inscrire des mémo ou des 	TODO par exemple. =>Fait
	-Génération du code Java correspondant à l’UML. =>Fait
	-Module Undo/Redo =>Non implementé
	-Génération du code dans d’autre langages(C++)  =>Non implementé

Repartition du travail:

Aurélie:
-Gestion de toute la partie dessin (Drawing Table, et Drawing Table Controller) de tous les types d’objets ET de tous les types d’association, à la création ainsi que pour les déplacements.
-Ajout du module note.
-Rédaction des tests des packages view, controller et model

Emeline:
-Création de la vue principale, et des vues secondaires.
-Rédaction de la Javadoc
-Rédaction des tests du package model

Alain:
-Implémentation du module Open/Save
-Implémentation de la génération du code Java
-Gestion des contrôleurs de saisies pour l’ajout ou la modification de champ
-Rédaction des tests des packages controller et model