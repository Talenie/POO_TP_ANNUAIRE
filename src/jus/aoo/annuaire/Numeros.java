package jus.aoo.annuaire;

import java.util.LinkedList;
import java.util.List;

import jus.util.assertion.Require;

/**
 * 
 * @author bonhourg
 * @invariant MinUnNum : count() > 0
 */
public class Numeros {
	
	private List<String> numeros;
	

	/** Constructeur d'une liste à un seul numéro */
	public Numeros(String num) {
		numeros = new LinkedList<>();
		numeros.add(num);
	}
	
	/** ajoute un numéro à la liste */
	public void add(String num) {
		numeros.add(num);
	}
	
	/** retourne le premier numéro de la liste (il existe forcément) */
	public String numero() {
		return numeros.get(0);
	}
	
	/** retourne true si la liste contient le numéro donné */
	public boolean has(String num) {
		for (String c_num : numeros) {
			if(c_num == num) return true;
		}
		return false;
	}
	
	/** retourne le nombre de numéros de la liste (>=1) */
	public int count() {
		return numeros.size();
	}
	
	/** retourne la séquence des numéros séparés par des virgules dans une chaîne */
	public String toString() {
		return numeros.toString();
		/*
		String str = "";
		for (String c_num : numeros) {
			str += " " + c_num;
		}
		return str;*/
	}
	
	/** enlève le numéro donné de la liste. 
	 *  @require: count()>1
	 */
	public void remove(String num) {
		if(! (this.count() > 1)) {
			throw new Require("AssezDeNums");
		} else {
			int indice = 0;
			for (String c_num : numeros) {
				if(c_num == num) break;
				indice++;
			}
			numeros.remove(indice);
		}
	}
	
}