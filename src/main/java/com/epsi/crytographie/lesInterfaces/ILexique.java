package com.epsi.crytographie.lesInterfaces;

public interface ILexique {
	
	boolean ExisteCaractere(String valeur);
	
	boolean ExisteNumber(Integer nombre);
	
	String getCharactere(int cle);
	
	String GetNumber(String caractere);
	
	int GetNombreElement();
}
