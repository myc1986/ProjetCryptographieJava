package com.epsi.crytographie.lesClasses;

import java.util.ArrayList;

import com.epsi.crytographie.lesInterfaces.ILexiquePolybe;

public class CLexiquePolybe extends CLexique implements ILexiquePolybe {
	private static final int MAX_COLONNE = 5;
	
	public CLexiquePolybe()
	{
		super();
		
		InitialiserDictionnairePolybe();
	}
	
	public void InitialiserDictionnairePolybe()
	{
		ArrayList<String> lesLettres = new ArrayList<String>();
		lesLettres = GetAlphabetFrancaisMajuscule();
		
		Integer iCount = 0;
		
		for (Integer iLigne = 1; iLigne <= MAX_COLONNE; iLigne++) {
			
			
			for (Integer iColonne = 1; iColonne <= MAX_COLONNE; iColonne++) {
				StringBuilder monIdCase = new StringBuilder();
				monIdCase.append(iLigne);
				monIdCase.append(iColonne);
				
				_lesCaracteres.put(monIdCase.toString(), lesLettres.get(iCount).toString());
				_lesClesCaracteres.put(lesLettres.get(iCount).toString(), monIdCase.toString());
				
				iCount = iCount + 1;
			}
		}
	}

	public void InitialiserDictionnaire() {
		InitialiserDictionnairePolybe();
	}
}
