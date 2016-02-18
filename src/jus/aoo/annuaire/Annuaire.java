package jus.aoo.annuaire;

public class Annuaire {

	/** notion d'annuaire : ensemble d'associations Personne-Numero */
	public class Annuaire {
		
	}
	/** constructeur d'annuaire vide */
	public Annuaire(){
		
	}
	/**
	* ajoute une nouvelle entrée dans l'annuaire. Si p n'existe pas: on crée une nouvelle
	* association (p,n) ; sinon : on ajoute n aux numéros de p
	* Correspondance interface: BOUTON Ajouter
	*/
	public void addEntry(Personne p, String n){
		
	}
	/**
	* chargement de l'annuaire depuis un fichier texte (le contenu de l'annuaire est remplacé)
	* chaque ligne du fichier est de la forme :
	* Civilite Nom Prenom "Numero1" "Numero2" .... <CR> (Civilite = Mr ou Mme ou Melle)
	* Correspondance interface: BOUTON Charger
	*/
	public void loadEntryFromFile(String file){
		
	}
	/**
	* retourne le premier numéro de la personne, si la personne est absente retourne null
	* Correspondance interface: BOUTON Numéro
	*/
	public String getNumber(Personne p){
		
	}
	/**
	* retourne les numéros de la personne, si la personne est absente retourne null
	* Correspondance interface: BOUTON Numéros
	*/
	public String getNumbers(Personne p){
		
	}
	/**
	* retourne l'intégralité de l'annuaire dans un ordre quelconque : une personne par ligne
	* suivie de ses numéros de téléphone
	* Correspondance interface: BOUTON Print Répertoire
	*/
	public String toString(){
		
	}
	/**
	* retourne la première personne ayant le numero donné, null si aucune personne
	* Correspondance interface: BOUTON Personne
	*/
	public Personne annuInverse(String num){
		
	}
	/**
	* supprime la personne de l'annuaire, si elle est présente
	* Correspondance interface: BOUTON Supprimer (si le champ "numero" est vide)
	*/
	public void remove(Personne p){
		
	}
	/**
	* supprime le numero donné de la personne, s'il n'y a plus qu'un numéro dans la liste supprime la personne
	* Correspondance interface: BOUTON Supprimer (si le champ "numero" est rempli)
	*/
	public void remove(Personne p,String num){
		
	}
	
}
