package jus.aoo.annuaire;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jus.util.assertion.Ensure;
import jus.util.assertion.Invariant;
import jus.util.assertion.Require;

/**
 * 
 * @author bonhourg
 * @invariant MinUnNum : count() > 0
 */
public class Numeros {
	
	private List<String> numeros;
	

	/** Constructeur d'une liste à un seul numéro */
	public Numeros(String num) throws Invariant {
		numeros = new ArrayList<>();
		numeros.add(num);
		
		_invariant();
	}
	
	/** ajoute un numéro à la liste 
	 * 
	 * @param num
	 * @require NumeroValable : _numerovalable(num)
	 * @require NumeroNonPresent : !(this.has(num))
	 * @ensure NumeroAjoute : this.has(num)
	 */
	public void add(String num)throws Require {
		if(!(_numerovalable(num))){ throw new Require("NumeroValable");}
		if(this.has(num)){ throw new Ensure("NumeroNonPresent");}
		
		numeros.add(num);
		
		if(!(this.has(num))){ throw new Ensure("NumeroAjoute");}
		_invariant();
	}
	
	/** retourne le premier numéro de la liste (il existe forcément) */
	public String numero() {
		return numeros.get(0);
	}
	
	/** retourne true si la liste contient le numéro donné */
	public boolean has(String num) {
		return numeros.contains(num);
	}
	
	/** retourne le nombre de numéros de la liste (>=1) */
	public int count() {
		return numeros.size();
	}
	
	/** retourne la séquence des numéros séparés par des virgules dans une chaîne */
	public String toString() {
		return numeros.toString();
	}
	
	/** enlève le numéro donné de la liste. 
	 *  @require AssezdeNums : count()>1
	 */
	public void remove(String num) {
		if(! (this.count() > 1)) { throw new Require("AssezDeNums");}
		numeros.remove(num);
		_invariant();
	}
	
	// Vérifications
	
	private boolean _invariant(){
		return this.count() > 0;
	}
	
	private boolean _numerovalable(String num){
		return (num.length()==10) && (num.charAt(0)=='0') && ((num.charAt(1)=='4')||(num.charAt(1)=='6')||(num.charAt(1)=='7')||(num.charAt(1)=='1'));
	}
	
}