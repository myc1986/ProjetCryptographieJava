package com.epsi.crytographie.lesInterfaces;

import java.util.ArrayList;

public interface ILexiquePermutation extends ILexique {
	
	void IniialiserDictionnaire();
	
	boolean ExisteCaracterePermute(String valeur);
	
	boolean ExisteNumberPermute(Integer nombre);
	
	String getCharacterePermute(int cle);
	
	Integer GetNumberPermute(String caractere);
	
	Integer GetNombreElementPermute();
	
	Integer ObtenirPlusGrandNombre(ArrayList<String> laListe);
	
	boolean contientElement(String value);
	
	void RetirerElementDansLesNombres(String value);
}
