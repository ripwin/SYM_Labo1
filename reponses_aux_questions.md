# Réponses aux questions
## Question 1

Répondue dans le rapport latex

## Question 2

*Comment utiliser une icône personnalisée dans les dialogues d'alerte ?*

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
Lorsque le login est réussi, vous êtes censé chaîner une autre Activity en utilisant un Intent. Si je presse le bouton "Back" de l'interface Android, que puis-je constater ? Comment faire pour que l'application se comporte de manière plus logique ?

Avec le code fourni, le fait d'appuyer sur le bouton "Back" de l'interface Android a pour effet de revenir à l'écran d'accueil d'Android. 

On aimerait en effet plutôt revenir à l'écrand de login par exemple. Pour ce faire il suffit d'enlever la ligne 

```java
finish();
```

qui a pour effet de terminer l'activité principale après l'appel à l'activité de succès. En enlevant cette ligne, l'activité principale reste sur la pile d'activités, et le bouton "Back" permet ainsi d'y revenir depuis l'activité de succès.

## Question 4
*On pourrait imaginer une situation où cette seconde Activity fournit un résultat (par exemple l’IMEI ou une autre chaîne de caractères) que nous voudrions récupérer dans l'Activity de départ. Comment procéder ?*

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





