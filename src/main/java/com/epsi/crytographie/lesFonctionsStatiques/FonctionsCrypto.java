package com.epsi.crytographie.lesFonctionsStatiques;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.String;

public abstract class FonctionsCrypto
{	
	public static String MettreEnMajusculeSansAccent(String message)
	{
		StringBuilder messageTravail = new StringBuilder(message);
		
		messageTravail = new StringBuilder(messageTravail.toString().replaceAll("[����]", "e"));
		messageTravail = new StringBuilder(messageTravail.toString().replaceAll("[���]", "a"));
		messageTravail = new StringBuilder(messageTravail.toString().replaceAll("[��]", "u"));
		messageTravail = new StringBuilder(messageTravail.toString().replaceAll("[��]", "o"));
		messageTravail = new StringBuilder(messageTravail.toString().replaceAll("[��]", "i"));
		
		return messageTravail.toString().toUpperCase();
	}
	
	public static String ObtenirTexteBrut(String leFichier)
			throws FileNotFoundException, IOException {
		InputStream unFichier;
		InputStreamReader reader;
		BufferedReader monBuffer;
		StringBuilder monBuilderString;
		unFichier = new FileInputStream(leFichier);
		reader = new InputStreamReader(unFichier);
		monBuffer = new BufferedReader(reader);
		String ligne = "";
		monBuilderString = new StringBuilder();
		
		while ((ligne = monBuffer.readLine())!=null)
		{
			monBuilderString.append(ligne);
		}
		
		monBuffer.close();
		
		return monBuilderString.toString();
	}
}