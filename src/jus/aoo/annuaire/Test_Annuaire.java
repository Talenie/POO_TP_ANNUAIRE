package jus.aoo.annuaire;

public class Test_Annuaire {
	
	public static void main (String[] args){
		Annuaire A;
		A = new Annuaire();
		Personne p;
		p = new Personne("Gilles","Bonhoure","Mr");
		String n;
		n = "0650403020";
		
		A.loadEntryFromFile("annuaire.txt");
		
		A.addEntry(p, n);
		System.out.println(A.toString());
	}
}
