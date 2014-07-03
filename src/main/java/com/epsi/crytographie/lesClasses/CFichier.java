package com.epsi.crytographie.lesClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CFichier {
	String _cheminFichier;
	StringBuilder _contenuFichier;
	
	public CFichier(String cheminFichier)
	{
		File monFile = new File(cheminFichier);
		
		if (monFile.exists()) {
			_cheminFichier = cheminFichier;
		}
		else
		{
			System.out.println("Ce fichier n'existe pas");
		}
	}
	
	public CFichier(StringBuilder contenuFichier)
	{
		_contenuFichier = contenuFichier;
	}
	
	public String ObtenirTexteBrutSurUneLigne()
	{
		String chaine = "";
		
		if (new File(_cheminFichier).exists()) {
			
			InputStream unFichier;
			InputStreamReader reader;
			BufferedReader monBuffer;
			StringBuilder monBuilderString;
			
			try {
				
				unFichier = new FileInputStream(_cheminFichier);
				reader = new InputStreamReader(unFichier);
				monBuffer = new BufferedReader(reader);
				String ligne = "";
				monBuilderString = new StringBuilder();
				
				while ((ligne = monBuffer.readLine())!=null)
				{
					monBuilderString.append(ligne);
				}
				
				monBuffer.close();
				chaine = monBuilderString.toString();
				
			} catch (Exception e) {
				System.out.println("Ce fichier n'existe pas ou n'est pas accessible");
			} 
		}
		else
		{
			System.out.println("Ce fichier n'existe pas");
		}
		
		return chaine;
	}
	
	public ArrayList<String> ObtenirLignesTexte()
	{
		
		ArrayList<String> lesLignes = new ArrayList<String>();
		
		if (new File(_cheminFichier).exists()) {
			InputStream unFichier;
			InputStreamReader reader;
			BufferedReader monBuffer;
			try {
				unFichier = new FileInputStream(_cheminFichier);
				reader = new InputStreamReader(unFichier);
				monBuffer = new BufferedReader(reader);
				
				String ligne = "";
				
				
				while ((ligne = monBuffer.readLine())!=null)
				{
					lesLignes.add(ligne);
				}
				
				monBuffer.close();
				
			}catch(Exception e)
			{
				System.out.println("Ce fichier n'existe pas ou n'est pas accessible");
			}
		}
		else
		{
			System.out.println("Ce fichier n'existe pas");
		}
		
		return lesLignes;
	}
	
	public void CreerFichierSortie(String cheminFichierSortie)
	{
		
	}
}
