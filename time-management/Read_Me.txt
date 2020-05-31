Imputation Boondmanager :
Ce jar expose un service � TimeSheetService � ou la m�thode � findNotCompleteTS � prend 3 arguments en entr�s : 
le code consultant, date d�but et date fin et elle nous retourne les dates ou le consultant n�a pas imput� ou 
il n�a pas finalis� ses imputations, hors les weekends et les jours f�ri�s.

Les entr�es : Code consultant : String, Date_d�but : date, dat_fin : Date.

Le jar prend en configuration externe (database.properties) 

les informations de connexion � la base de donn�es, ce dernier 

sera charg� dynamiquement via la classe DatabaseConnection (design pattern Singleton) qui sera instancier seulement si 
elle n�existe pas avant, sinon on point vers la r�f�rence existante.

Le Model :
TimeSheet : un POJO repr�sentant la table temps de la base sous forme d�un objet java.

Le service : 
La classe TimeSheetServiceImpl propose une m�thode findNotCompleteTS qui prend en param�tre un code d�un consultant, une date d�but et une date fin, 
elle retourne les date ou le consultant n�a pas imput� ou suffisamment peu imput�.

FileUtilities : 

Cette classe a trois m�thodes : 
getListOfHolidaysFromFile: pour charger la liste des jours f�ri�s � partir d�un fichier properties (holidays.txt).

loadValuesFromProperties: pour charger les valeur du fichier database.properties 
afin de les utiliser dans la classe DataBaseConnection.

checkIsHoliday:  pour tester si une date est un jour f�ri� ou pas.

Pour int�grer le jar il faut ajouter dans le pom de l�application client cette d�pendance Maven :

<groupId>time-management</groupId>
	<artifactId>time-management</artifactId>
<version>0.0.1-SNAPSHOT</version>


Exemple d�Appel du service : 

TimeSheetService service = new TimeSheetServiceImpl();
List<Date> times = service.findNotCompleteTS(ref_ressource, dateB, dateE);


� remplir : le fichier holidays.txt, par les jours f�riers pour qui�elles 
soient charg�es dynamiquement au d�marrage du jar.




 


 

