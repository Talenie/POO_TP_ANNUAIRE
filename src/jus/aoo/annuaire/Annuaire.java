package jus.aoo.annuaire;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/** notion d'annuaire : ensemble d'associations Personne-Numero */
public class Annuaire {
	
	// Attributs
	private Map<Personne,Numeros> annuaire;
	
	/** constructeur d'annuaire vide */
	public Annuaire(){
		annuaire = new HashMap<Personne,Numeros>();
	}
	/**
	* ajoute une nouvelle entrée dans l'annuaire. Si p n'existe pas: on crée une nouvelle
	* association (p,n) ; sinon : on ajoute n aux numéros de p
	* Correspondance interface: BOUTON Ajouter
	 * @param p une personne
	 * @param n un numéro
	 */
	public void addEntry(Personne p, String n){
		Numeros x;
		if(!(annuaire.containsKey(p))){
			x = new Numeros(n);
			annuaire.put(p,x);
		} else {
			x = annuaire.get(p);
			x.add(n);
			annuaire.put(p,x);
		}
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
			s+= entree.getKey().toString()+" "+entree.getValue().toString()+"\n";
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
