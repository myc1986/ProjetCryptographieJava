package com.epsi.crytographie.lesClasses;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import com.epsi.crytographie.lesInterfaces.ILexiquePermutation;

public class CLexiquePermutation extends CLexique  implements ILexiquePermutation{
	private Hashtable<Integer, String> _lesCaracteresPermutees;
	private Hashtable<String, Integer> _lesClesCaracteresPermutes;
	private ArrayList<String> lesNombres;
	
	public CLexiquePermutation()
	{
		super();
		
		_lesCaracteresPermutees = new Hashtable<Integer, String>();
		_lesClesCaracteresPermutes = new Hashtable<String, Integer>();
		lesNombres = new ArrayList<String>();
		
		InitialiserDictionnaireNormal();
		InitialiserDictionnairesPermutes();
	}
	
	public void InitialiserDictionnaireNormal()
	{
		InitialiserDictionnaireCaracteres();
		InitialiserDictionnaireClesCaracteres();
	}
	
	private void InitialiserDictionnaireClesCaracteres()
	{
		ArrayList<String> alphabet = GetAlphabetFrancaisMajuscule();
		
		for (int i = 0; i < alphabet.size(); i++) {
			_lesClesCaracteres.put(alphabet.get(i).toString(), String.valueOf(i+1));
		}
	}
	
	private void InitialiserDictionnaireCaracteres()
	{
		ArrayList<String> alphabet = GetAlphabetFrancaisMajuscule();
		
		for (int i = 0; i < alphabet.size(); i++) {
			_lesCaracteres.put(String.valueOf(i+1), alphabet.get(i).toString());
		}
	}
	
	public void InitialiserDictionnairesPermutes()
	{
		ArrayList<String> lesLettres = new ArrayList<String>();
		lesLettres = GetAlphabetFrancaisMajuscule();
		
		lesNombres = new ArrayList<String>();
		lesNombres = GetListNombreParOrdreCroissant(1, 26);
		
		for (String unElement : lesLettres)
		{
			Random monTirage = new Random();
			
			Integer nbrAleatoire = 0;
			boolean nbrTrouve = false;
			
 			while (!nbrTrouve) {
				nbrAleatoire = monTirage.nextInt(ObtenirPlusGrandNombre(lesNombres)+1);
				
				if (contientElement(nbrAleatoire.toString()))
				{
					nbrTrouve = true;
					
					_lesCaracteresPermutees.put(nbrAleatoire, unElement);
					_lesClesCaracteresPermutes.put(unElement, nbrAleatoire);
					
					System.out.println("Nbr Tir�e: "+nbrAleatoire.toString());
					
					RetirerElementDansLesNombres(nbrAleatoire.toString());
				}
			}
		}
	}
	
	public boolean ExisteCaracterePermute(String valeur)
	{
		return _lesClesCaracteresPermutes.containsKey(valeur);
	}
	
	public boolean ExisteNumberPermute(Integer nombre)
	{
		return _lesCaracteresPermutees.containsKey(nombre);
	}
	
	public String getCharacterePermute(int cle)
	{
		return _lesCaracteresPermutees.get(cle);
	}
	
	public Integer GetNumberPermute(String caractere)
	{
		return _lesClesCaracteresPermutes.get(caractere);
	}
	
	public Integer GetNombreElementPermute()
	{
		return _lesClesCaracteresPermutes.size();
	}

	public Integer ObtenirPlusGrandNombre(ArrayList<String> laListe)
	{
		Integer plusGrandNbr = 0;
		boolean estLePremierElement = true;
		
		for (String nbrInteger : laListe) {
			Integer nbrParse = Integer.parseInt(nbrInteger);
			
			if (estLePremierElement) {
				plusGrandNbr = nbrParse;
				estLePremierElement = false;
			}
			
			if (nbrParse > plusGrandNbr) {
				plusGrandNbr = nbrParse;
			}
		}
		
		return plusGrandNbr;
	}
	
	public boolean contientElement(String value)
	{
		boolean reponse = false;
		int iCount = 0;
		
		while ((!reponse) && (iCount < lesNombres.size())) 
		{
			if (lesNombres.get(iCount).equals(value)) {
				reponse = true;
			}
			
			iCount = iCount +1;
		}
		
		return reponse;
	}

	public void RetirerElementDansLesNombres(String value)
	{
		boolean reponse= false;
		int iCount = 0;
		int indexNbr = 0;
		
		while ((!reponse) && (iCount < lesNombres.size())) 
		{
			if (lesNombres.get(iCount).equals(value)) {
				reponse = true;
				indexNbr = iCount;
			}
			
			iCount = iCount +1;
		}
		
		if (reponse) {
			lesNombres.remove(indexNbr);
		}
	}

	public void IniialiserDictionnaire() {
		InitialiserDictionnaireNormal();
		InitialiserDictionnairesPermutes();
	}
}
