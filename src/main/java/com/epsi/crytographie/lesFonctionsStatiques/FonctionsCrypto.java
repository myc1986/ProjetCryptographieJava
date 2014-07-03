package com.epsi.crytographie.lesFonctionsStatiques;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.String;

public abstract class FonctionsCrypto
{	
	public static String MettreEnMajusculeSansAccent(String message)
	{
		StringBuilder messageTravail = new StringBuilder(message);
		
		messageTravail = new StringBuilder(messageTravail.toString().replaceAll("[éèê]", "e"));
		messageTravail = new StringBuilder(messageTravail.toString().replaceAll("[àâ]", "a"));
		messageTravail = new StringBuilder(messageTravail.toString().replaceAll("[ùû]", "u"));
		messageTravail = new StringBuilder(messageTravail.toString().replaceAll("[ô]", "o"));
		messageTravail = new StringBuilder(messageTravail.toString().replaceAll("[î]", "i"));
		
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
	
	public static void GenererFichier(String message, String cheminFichier, boolean encode, String mode)
	{
		try {
			
			
			
			if(encode)
			{
				cheminFichier = cheminFichier.replace(".", "encode"+mode+".");
			}
			else
			{
				cheminFichier = cheminFichier.replace(".", "decode"+mode+".");
			}
			
			BufferedWriter ceBuffer = new BufferedWriter(new FileWriter(new File(cheminFichier)));
			
			ceBuffer.write(message);
			 
			ceBuffer.close();
			}
			catch (IOException e)
			{
			e.printStackTrace();
			}
	}
}