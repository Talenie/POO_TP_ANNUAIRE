package jus.aoo.annuaire;

import jus.util.assertion.Ensure;
import jus.util.assertion.Require;

public class Personne {
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
	 * Change le nom d'une personne
	 * @param nom
	 * @require NomExistant : nom!=null
	 */
	public void changernom(String nom) throws Require{
		if(!(nom!=null)){ throw new Require("NomExistant");}
		this.nom = nom;
	}
	/**
	 * Change le prenom d'une personne
	 * @param prenom
	 * @require PrenomExistant : prenom!=null
	 */
	public void changerprenom(String prenom) throws Require{
		if(!(prenom!=null)){ throw new Require("PrenomExistant");}
		this.prenom = prenom;
	}
	/**
	 * Cahnge la civilité d'une personne
	 * @param civilite
	 * @require CiviliteExistante : civilite!=null
	 */
	public void changercivilite(String civilite) throws Require{
		if(!(civilite!=null)){ throw new Require("CiviliteExistante");}
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
	 * 
	 * @param nom
	 * @param prenom
	 * @param civilite
	 * @require ArgumentsNonNuls : (nom!=null) && (prenom!=null) && (civilite!=null)
	 */
	public Personne(String nom,String prenom,String civilite) throws Require{
		if(!((nom!=null) && (prenom!=null) && (civilite!=null))){ throw new Require("ArgumentsNonNuls"); }
		identite(nom,prenom,Civilite.fromString(civilite));
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
	public boolean memenom(Personne p) throws Require{
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
}
