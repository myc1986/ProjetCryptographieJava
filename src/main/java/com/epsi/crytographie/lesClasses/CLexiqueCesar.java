package com.epsi.crytographie.lesClasses;

import java.util.ArrayList;

import com.epsi.crytographie.lesInterfaces.ILexiqueCesar;

public class CLexiqueCesar extends CLexique implements Cloneable, ILexiqueCesar {

	public CLexiqueCesar()
	{
		super();
		InitialiserLesDictionnaires();
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
	
	public void InitialiserLesDictionnaires()
	{
		InitialiserDictionnaireCaracteres();
		InitialiserDictionnaireClesCaracteres();
	}

	public void InitialiserDictionnaire() {
		InitialiserLesDictionnaires();
	}
}
