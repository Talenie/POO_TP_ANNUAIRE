package jus.aoo.annuaire;

public enum Civilite {
	INCONNU("Inconnu",""),
	MELLE("Mademoiselle","Melle"),
	MME("Madame","Mme"),
	MR("Monsieur","Mr");
	
	private String civilitecomplete;
	private String civilitesimple;
	
	private Civilite(String s1,String s2){
		civilitecomplete = s1;
		civilitesimple = s2;
	}
	
	public String toString(){
		return civilitecomplete;
	}
	
	public String toStringsimple(){
		return civilitesimple;
	}
	
	public static Civilite fromString(String civilite){
		if(civilite.equals("Madame")||civilite.equals("Mme")){return MME;}
		if(civilite.equals("Monsieur")||civilite.equals("Mr")){return MR;}
		if(civilite.equals("Mademoiselle")||civilite.equals("Melle")){return MELLE;}
		return INCONNU;
	}
	
	public static Civilite fromint(int civilite){
		if(civilite==2){return MME;}
		if(civilite==3){return MR;}
		if(civilite==1){return MELLE;}
		return INCONNU;
	}
}
