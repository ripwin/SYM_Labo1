# Réponses aux questions
## Question 1

Répondue dans le rapport latex

## Question 2

**Comment utiliser une icône personnalisée dans les dialogues d'alerte ?**

**Note :** Nous avons utilisé un fichier .svg pour répondre à cette question. 

Pour ajouter le pictogramme au projet, il faut faire un click droit sur le dossier res, puis cliquer sur New > Vector Asset > Local file > Sélectionner le fichier sur l'ordinateur. 

Cela ajoute l'icône dans le dossier res/drawable. 

Android utilise le concept de ressource "Drawable". Une ressource "Drawable" est un concept général pour un élément graphique qui peut être dessiné sur l'écran. Les images font partie de cette catégorie. 

Android permet également de gérer des set d'icônes adaptés aux différentes densités d'écrans existantes sur le marché. On peut ainsi spécifier les images à utiliser pour les écrans à low-density, medium-density, high-density et Extra-high-density. 

**Sources:**

Site développeur d'Android
https://developer.android.com/guide/topics/resources/drawable-resource.html 
29.09.2017



## Question 3
**Lorsque le login est réussi, vous êtes censé chaîner une autre Activity en utilisant un Intent. Si je presse le bouton "Back" de l'interface Android, que puis-je constater ? Comment faire pour que l'application se comporte de manière plus logique ?**

Avec le code fourni, le fait d'appuyer sur le bouton "Back" de l'interface Android a pour effet de revenir à l'écran d'accueil d'Android. 

On aimerait en effet plutôt revenir à l'écran de login par exemple. Pour ce faire il suffit d'enlever l'instruction 

```java
finish();
```

qui a pour effet de terminer l'activité principale après l'appel à l'activité de succès. En enlevant cette ligne, l'activité principale reste sur la pile d'activités, et le bouton "Back" permet ainsi d'y revenir depuis l'activité de succès.

## Question 4
**On pourrait imaginer une situation où cette seconde Activity fournit un résultat (par exemple l’IMEI ou une autre chaîne de caractères) que nous voudrions récupérer dans l'Activity de départ. Comment procéder ?**

Pour ce faire il faut dans un premier temps appeler l'activité secondaire avec la méthode 

```java
startActivityForResult(...);
```

plutôt que 

```java
startActivity(...);
```

Cela permet, dans l'activité secondaire, de définir un résultat qui pourra être récupérer depuis l'activité de départ. Pour se faire il suffit de spécialiser la méthode 

```java
onActivityResult(...);
```

pour récupérer le contenu de ce résultat (voir le code correspondant dans MainActivity). On notera qu'il est important de vérifier le code de retour passé en paramètre de cette méthode avant de chercher à récupérer les données. Cela permet de savoir si l'activité s'est terminée en nous fournissant un résultat ou non.

Pour effectuer cette manipulation, nous avons ajouté un bouton dans la SuccessActivity, dont le seul but est de terminer l'activité en retournant une String.


**Sources:**

Stack Overflow
https://stackoverflow.com/questions/13178056/get-data-from-another-activity
https://stackoverflow.com/questions/920306/sending-data-back-to-the-main-activity-in-android
https://developer.android.com/reference/android/app/Activity.html#startActivityForResult(android.content.Intent, int)
02.10.2017


## Question 5
La dépréciation est, dans le domaine du développement logiciel, la situation où une ancienne fonctionnalité 
est considérée comme obsolète au regard d'un nouveau standard, et où, bien qu'elle soit conservée dans les 
versions plus récentes (par souci de rétro-compatibilité, et pour donner aux développeurs le temps de 
mettre leur code source en conformité), elle pourrait disparaître à l'avenir, si bien qu'il est 
recommandé d'en abandonner l'usage. <Source : wikipédia, https://fr.wikipedia.org/wiki/D%C3%A9pr%C3%A9ciation_(informatique)>

L'utilisation de telle méthode est donc déconseiller car à tout moment l'application pourrait ne plus fonctionner.
Il est de la responsabilité du dévellopeur de se tenir informé des mis à jour sur les langages utilisées. Et de modifier
son code en conséquence. 

Dans notre cas, la méthode getDevice a été remplacé par la méthode getIMEI.

Code :
	<uses-permission android:name="android.permission.READ_PHONE_STATE" /> (manifest)

	 // Android Unique ID
	String androidId = System.getString(this.getContentResolver(),Settings.Secure.ANDROID_ID);


## Question 7
Pour répondre à cette question, l'interface de login fournie en format portrait a été remplacée par
une structure utilisant un RelativeLayout. Grâce à ce layout, il suffit de définir pour chaque élément où il se situe par rapport à son parent ou à ses pairs. Le champ de mot de passe se situe donc par exemple en dessous du champ d'utilisateur. 

**Sources**

Android Developers
https://developer.android.com/guide/topics/ui/layout/relative.html
11.10.2017


## Question 8
Il y a 3 grandes périodes dans le cycle de vie d'une application. La période dite active, qui peut être interrompu par la période
suspendue qui elle même peut être interrompue par la période arrêté.
L'entrée dans chaque état est symbolisée par une méthode et la sortie de chaque état est symbolisée par une autre méthode. Ce que l'on itilialise dans le première
doit presque toujours être stoper dans la suivante.

- onCreate : création de l'activité chargement des interfaces ou des données dans le bundle
	- va vers onStart
- onStart : lance l'application
	- va vers onResume
- onResume : l'activité s'éxecute au premier plan
	- va vers onPause
- onPause : l'activité libère des ressources (mémoire, outils..)
	- va vers onStop
- onStop : l'activité n'est plus visible (arrière plan)
	- va vers onDestroy
	- va ver onCreate : quand l'activité repasse au premier plan après avoir été tué
	- va vers onRestart : quand l'activité repasse au premier plan
- onDestroy : l'activité est quitter normalement ou détruite par le système. En cas d'exception non catch 
	- en cas de destruction d'une application pour une plus priotaire il est recommandé de sauvegarder les données
	  avec la méthode onSaveInstance(Bundle)



ressource : https://openclassrooms.com/courses/creez-des-applications-pour-android/preambule-quelques-concepts-avances

