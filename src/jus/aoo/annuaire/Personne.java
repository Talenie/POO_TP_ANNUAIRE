package jus.aoo.annuaire;

public class Personne {
	// Attributs
	private String nom;
	private String prenom;
	private Civilite civilite;
	
	public void identite(String nom,String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Personne(String nom,String prenom,Civilite civ){
		identite(nom,prenom);
		this.civilite = civ;
	}
}
