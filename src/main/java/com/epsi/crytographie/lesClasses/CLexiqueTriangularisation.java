package com.epsi.crytographie.lesClasses;

import java.util.ArrayList;
import java.util.Hashtable;

import com.epsi.crytographie.lesInterfaces.ILexiqueTriangularisation;

public class CLexiqueTriangularisation extends CLexique implements ILexiqueTriangularisation {
	
	Hashtable<String, ArrayList<String>> _lesLignesTexte;
	Hashtable<String, ArrayList<String>> _lesAutresLignes;
	private int MAX_COLONNE = 0;
	private int MAX_LIGNE = 0;
	
	public CLexiqueTriangularisation()
	{
		super();
		InitialiserDictionnaireTriangularisation();
	}
	
	public void InitialiserDictionnaireTriangularisation()
	{	
		Integer iCount = 0;
		
		for (Integer i = 1; i <= MAX_LIGNE; i++) {
			StringBuilder idCase = new StringBuilder();
			idCase.append("L");
			idCase.append(i);
			
			for (Integer j = 1; j <= MAX_COLONNE; j++) {
				idCase.append("C");
				idCase.append(i);
				
				_lesCaracteres.put(idCase.toString(), "");
				
				iCount = iCount + 1;
			}
		}
	}
	
	public int GetLargeurCadrillage() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetLargeurLigneTexte() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetNombreColonneCadrillage() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetNombreLigneCadrillage() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void InitialliserDictionnaire() {
		// TODO Auto-generated method stub
		
	}

}
