package jus.aoo.annuaire;

public class Test_Annuaire {
	
	public static void main (String[] args){
		Annuaire A;
		A = new Annuaire();
		Personne p;
		p = new Personne("Bonhoure","Gilles","Mr");
		String n;
		
		n = "0650403020";
		
		A.loadEntryFromFile("annuaire.txt");
		
		A.addEntry(p, n);
		System.out.println(A.toString());
		
		System.out.println("------------------\n");
		System.out.println("Noms commencant par B\n");
		System.out.println(A.toString('B'));
		
		System.out.println("------------------\n");
		System.out.println("Ajout de nouvelles entrées depuis un fichier.\n");
		A.addEntryFromFile("ajouter.txt");
		System.out.println(A.toString());
		
	
	}
}
