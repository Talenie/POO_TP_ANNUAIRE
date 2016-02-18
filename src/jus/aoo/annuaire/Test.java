package jus.aoo.annuaire;

public class Test {

	public static void main (String[] args){
		
		Numeros num = new Numeros("0326568954");
		
		num.add("0667640099");
		num.add("0123564578");

		System.out.println("Liste des numéros : " + num.toString());
		
		System.out.println("Affichage du premier numéro : " + num.numero() + "\n");
		
		System.out.println("Le numéro 0667640099 est il contenu ? (o) " + num.has("0667640099"));
		System.out.println("Le numéro 0323235689 est il contenu ? (n) " + num.has("0323235689"));
		
		System.out.println("Combien de numéros ? (3) " + num.count());
		
		System.out.println("On va supprimer le numéro 0667640099");
		num.remove("0667640099");
		System.out.println("Nouvelle liste " + num);
		
		
	}
	
}
