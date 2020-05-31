Imputation Boondmanager :
Ce jar expose un service « TimeSheetService » ou la méthode « findNotCompleteTS » prend 3 arguments en entrés : 
le code consultant, date début et date fin et elle nous retourne les dates ou le consultant n’a pas imputé ou 
il n’a pas finalisé ses imputations, hors les weekends et les jours fériés.

Les entrées : Code consultant : String, Date_début : date, dat_fin : Date.

Le jar prend en configuration externe (database.properties) 

les informations de connexion à la base de données, ce dernier 

sera chargé dynamiquement via la classe DatabaseConnection (design pattern Singleton) qui sera instancier seulement si 
elle n’existe pas avant, sinon on point vers la référence existante.

Le Model :
TimeSheet : un POJO représentant la table temps de la base sous forme d’un objet java.

Le service : 
La classe TimeSheetServiceImpl propose une méthode findNotCompleteTS qui prend en paramètre un code d’un consultant, une date début et une date fin, 
elle retourne les date ou le consultant n’a pas imputé ou suffisamment peu imputé.

FileUtilities : 

Cette classe a trois méthodes : 
getListOfHolidaysFromFile: pour charger la liste des jours fériés à partir d’un fichier properties (holidays.txt).

loadValuesFromProperties: pour charger les valeur du fichier database.properties 
afin de les utiliser dans la classe DataBaseConnection.

checkIsHoliday:  pour tester si une date est un jour férié ou pas.

Pour intégrer le jar il faut ajouter dans le pom de l’application client cette dépendance Maven :

<groupId>time-management</groupId>
	<artifactId>time-management</artifactId>
<version>0.0.1-SNAPSHOT</version>


Exemple d’Appel du service : 

TimeSheetService service = new TimeSheetServiceImpl();
List<Date> times = service.findNotCompleteTS(ref_ressource, dateB, dateE);


À remplir : le fichier holidays.txt, par les jours fériers pour qui’elles 
soient chargées dynamiquement au démarrage du jar.




 


 

