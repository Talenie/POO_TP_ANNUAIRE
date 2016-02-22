package jus.aoo.annuaire;

import jus.util.assertion.Ensure;
import jus.util.assertion.Require;

public class Personne implements Comparable<Personne> {
	// Attributs
	private String nom;
	private String prenom;
	private Civilite civilite;
	
	//Setteurs
	/**
	 * Definit l'identité compléte d'une personne
	 * @param nom
	 * @param prenom
	 * @param civilite
	 * @require ArgumentsNonNuls : (nom!=null) && (prenom!=null) && (civilite!=null)
	 * @ensure PersonneBienDefinie : (this.nom.equals(nom)) && (this.prenom.equals(prenom)) && (this.civilite = civilite)
	 */
	public void identite(String nom,String prenom,Civilite civilite) throws Require{
		if(!((nom!=null) && (prenom!=null) && (civilite!=null))){ throw new Require("ArgumentsNonNuls"); }
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		if(!((this.nom.equals(nom)) && (this.prenom.equals(prenom)) && (this.civilite == civilite))){ 
			throw new Ensure("PersonneBienDefinie"); 
		}
	}
	
	
	/**
	 * Change la civilité d'une personne, si celle ci n'est pas déjà connue
	 * @param civilite
	 * @require CiviliteExistante : civilite!=null
	 * @require CiviliteCouranteInconnue : this.civilite==Civilite.INCONNU
	 * @require NouvelleCiviliteConnue : Civilite.fromString(civilite)!=Civilite.INCONNU
	 */
	public void changercivilite(String civilite) throws Require{
		if(!(civilite!=null)){ throw new Require("CiviliteExistante");}
		if(!(this.civilite==Civilite.INCONNU)){ throw new Require("CiviliteCouranteInconnue");}
		if(!(Civilite.fromString(civilite)!=Civilite.INCONNU)){ throw new Require("NouvelleCiviliteConnue");}
		this.civilite = Civilite.fromString(civilite);
	}
	
	//Constructeurs
	/**
	 * Crée une personne avec un nom et un prénom.
	 * @param nom
	 * @param prenom
	 * @require ArgumentsNonNuls : (nom!=null) && (prenom!=null)
	 */
	public Personne(String nom,String prenom)throws Require{
		if(!((nom!=null) && (prenom!=null) )){ throw new Require("ArgumentsNonNuls"); }
		identite(nom,prenom,Civilite.INCONNU);
	}
	/**
	 * Crée une personne a partir du nom, du prenom et de la civilité fournie
	 * @param nom
	 * @param prenom
	 * @param civilite
	 * @require ArgumentsNonNuls : (nom!=null) && (prenom!=null) && (civilite!=null)
	 */
	public Personne(String nom,String prenom,String civilite) throws Require{
		if(!((nom!=null) && (prenom!=null) && (civilite!=null))){ throw new Require("ArgumentsNonNuls"); }
		identite(nom,prenom,Civilite.fromString(civilite));
	}
	
	
	public Personne(int civilite, String nom, String prenom){
		identite(nom,prenom,Civilite.fromint(civilite));
	}
	
	//Getteurs
	public String nom(){
		return nom;
	}
	
	public String prenom(){
		return prenom;
	}
	
	public String civilite(){
		return civilite.toString();
	}
	
	// Fonctions utiles
	/**
	 * Comparaison des noms et prénoms
	 * @param p
	 * @return true si les deux ont les mêmes nom et prénoms
	 * @require PersonneExiste : p!=null
	 */
	public boolean memenomprenom(Personne p) throws Require{
		if(!(p!=null)){throw new Require("PersonneExiste");}
		return p.nom().equals(this.nom)&&p.prenom().equals(this.prenom);
	}
	
	public int hashCode(){
		return((nom+prenom).hashCode());
	}
	
	
	// toString
	public String toString(){
		return civilite.toString()+" "+nom+" "+prenom;
	}
	
	public String toStringsimple(){
		return civilite.toStringsimple()+" "+nom+" "+prenom;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	@Override
	public int compareTo(Personne o) {
		if(nom != o.nom()) {
			return nom.compareTo(o.nom());
		}
		else {
			return prenom.compareTo(o.prenom());
		}
	}
}
