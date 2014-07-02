package com.epsi.crytographie.lesClasses;

import java.util.ArrayList;
import java.util.Hashtable;

import com.epsi.crytographie.lesInterfaces.ILexique;

public abstract class CLexique implements ILexique, Cloneable {
	protected Hashtable<String,String> _lesCaracteres;
	protected Hashtable<String, String> _lesClesCaracteres;
	
	public CLexique()
	{
		_lesCaracteres= new Hashtable<String,String>();
		_lesClesCaracteres = new Hashtable<String, String>();		
	}
	
	protected ArrayList<String> GetAlphabetFrancaisMajuscule()
	{
		ArrayList<String> _aphabetFrancais = new ArrayList<String>();
		
		_aphabetFrancais.add("A");
		_aphabetFrancais.add("B");
		_aphabetFrancais.add("C");
		_aphabetFrancais.add("D");
		_aphabetFrancais.add("E");
		_aphabetFrancais.add("F");
		_aphabetFrancais.add("G");
		_aphabetFrancais.add("H");
		_aphabetFrancais.add("I");
		_aphabetFrancais.add("J");
		_aphabetFrancais.add("K");
		_aphabetFrancais.add("L");
		_aphabetFrancais.add("M");
		_aphabetFrancais.add("N");
		_aphabetFrancais.add("O");
		_aphabetFrancais.add("P");
		_aphabetFrancais.add("Q");
		_aphabetFrancais.add("R");
		_aphabetFrancais.add("S");
		_aphabetFrancais.add("T");
		_aphabetFrancais.add("U");
		_aphabetFrancais.add("V");
		_aphabetFrancais.add("W");
		_aphabetFrancais.add("X");
		_aphabetFrancais.add("Y");
		_aphabetFrancais.add("Z");
		
		return _aphabetFrancais;
	}
	
	protected ArrayList<String> GetListNombreParOrdreCroissant(int debut, int fin)
	{
		ArrayList<String> _laListeDesNombres = new ArrayList<String>();
		
		if (debut<=fin) {
			for (int i = debut; i <=fin; i++) {
				_laListeDesNombres.add(String.valueOf(i));
			}
		}
		
		return _laListeDesNombres;
	}
	
	public boolean ExisteCaractere(String valeur)
	{
		return _lesClesCaracteres.containsKey(valeur);
	}
	
	public boolean ExisteNumber(Integer nombre)
	{
		return _lesCaracteres.containsKey(nombre.toString());
	}
	
	public String getCharactere(int cle)
	{
		return _lesCaracteres.get(Integer.toString(cle));
	}
	
	public String GetNumber(String caractere)
	{
		return _lesClesCaracteres.get(caractere);
	}
	
	public int GetNombreElement()
	{
		return _lesClesCaracteres.size();
	}
}
