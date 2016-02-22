package jus.aoo.annuaire;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/** notion d'annuaire : ensemble d'associations Personne-Numero */
public class Annuaire {
	
	// Attributs
	private Map<Personne,Numeros> annuaire;
	
	/** constructeur d'annuaire vide */
	public Annuaire(){
		annuaire = new TreeMap<Personne,Numeros>();
	}
	/**
	* ajoute une nouvelle entrée dans l'annuaire. Si p n'existe pas: on crée une nouvelle
	* association (p,n) ; sinon : on ajoute n aux numéros de p
	* Correspondance interface: BOUTON Ajouter
	 * @param p une personne
	 * @param n un numéro
	 */
	public void addEntry(Personne p, String n){
		if(annuaire.containsKey(p)) {
			annuaire.get(p).add(n);
		}
		else {
			annuaire.put(p, new Numeros(n));
		}
	}
	/**
	* chargement de l'annuaire depuis un fichier texte (le contenu de l'annuaire est remplacé)
	* chaque ligne du fichier est de la forme :
	* Civilite Nom Prenom "Numero1" "Numero2" .... <CR> (Civilite = Mr ou Mme ou Melle)
	* Correspondance interface: BOUTON Charger
	*/	
	public void loadEntryFromFile(String file){
		//Il faut trier le tout avant de l'insérer car la méthode importFromFile ne permet pas de trier le fichier
		Map<Personne,Numeros> map = Util.importFromFile(file);
		annuaire.clear();
		annuaire.putAll(map);
	}
	
	/**
	* ajout des entrées contenues dans un fichier texte chaque ligne du fichier est de la forme :
	* Civilite Nom Prenom "Numero1" "Numero2" ....
	* Correspondance interface: BOUTON Importer
	*/
	public void addEntryFromFile(String file) {
		Map<Personne,Numeros> map = Util.importFromFile(file);
		annuaire.putAll(map);
	}
	
	/**
	* retourne le premier numéro de la personne, si la personne est absente retourne null
	* Correspondance interface: BOUTON Numéro
	*/
	public String getNumber(Personne p){
		Numeros n;
		n = annuaire.get(p);
		if (n==null){return null;}
		return n.numero();
	}
	
	/**
	* retourne les numéros de la personne, si la personne est absente retourne null
	* Correspondance interface: BOUTON Numéros
	*/
	public String getNumbers(Personne p){
		Numeros n;
		n = annuaire.get(p);
		if (n==null){return null;}
		return n.toString();
		
	}
	/**
	* retourne l'intégralité de l'annuaire dans un ordre quelconque : une personne par ligne
	* suivie de ses numéros de téléphone
	* Correspondance interface: BOUTON Print Répertoire
	*/
	public String toString(){
		String s ="";
		for (Entry<Personne,Numeros> entree : annuaire.entrySet()) {
			s+= entree.getKey().toStringsimple()+" "+entree.getValue().toString()+"\n";
		}
		return s;
	}
	
	/**
	* retourne la liste des personnes dont le nom commence par la lettre donnée (minuscule ou majuscule)
	* (une personne par ligne, avec ses numéros)
	*/
	public String toString(char c) {
		String s = "";
		for (Entry<Personne,Numeros> entree : annuaire.entrySet()) {
			char fc = entree.getKey().nom().charAt(0);
			if(fc > c) {
				return s;
			} else if(fc == c) { s += entree.toString() + "\n"; }
		}
		return s;
	}
	
	/**
	* retourne la première personne ayant le numero donné, null si aucune personne
	* Correspondance interface: BOUTON Personne
	*/
	public Personne annuInverse(String num){
		for (Entry<Personne,Numeros> entree : annuaire.entrySet()) {
			if(entree.getValue().has(num)){return entree.getKey();}
		}
		return null;
	}
	
	/**
	* supprime la personne de l'annuaire, si elle est présente
	* Correspondance interface: BOUTON Supprimer (si le champ "numero" est vide)
	*/
	public void remove(Personne p){
		annuaire.remove(p);
	}
	/**
	* supprime le numero donné de la personne, s'il n'y a plus qu'un numéro dans la liste supprime la personne
	* Correspondance interface: BOUTON Supprimer (si le champ "numero" est rempli)
	*/
	public void remove(Personne p,String num){
		Numeros n;
		n = annuaire.get(p);
		if(n.count()==1){this.remove(p);}
		else{
			n.remove(num);
			annuaire.put(p,n);
		}
	}
	
}
