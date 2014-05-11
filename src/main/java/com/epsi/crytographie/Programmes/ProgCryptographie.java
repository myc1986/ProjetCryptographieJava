package com.epsi.crytographie.Programmes;

import com.epsi.crytographie.lesClasses.CAnalyseStaistiqueCaracteres;
import com.epsi.crytographie.lesClasses.CCesar;
import com.epsi.crytographie.lesClasses.CPermutation;
import com.epsi.crytographie.lesClasses.CPolybe;
import com.epsi.crytographie.lesInterfaces.IAnalyseurCaracteres;
import com.epsi.crytographie.lesInterfaces.IDecodeur;
import com.epsi.crytographie.lesInterfaces.IEncodeur;

public class ProgCryptographie {
	
	public static void main(String[] args) {
		EssaiAnalyseTexte("C:\\Users\\Myc\\Google Drive\\Cours\\Cours EPSI\\Projet �cole\\projets_java\\text_analyse_fr2.txt");
		
		EssaiPermutation();
		EssaiPolybe();
	}
	
	public static void EssaiPolybe()
	{
		String message = "Bonjour, nous l'avons fait";
		
		CPolybe monProgPermutation = new CPolybe();
		
		IDecodeur monDecodeur = monProgPermutation;
		IEncodeur monEncodeur = monProgPermutation;
		
		String messageEncode = monEncodeur.Encoder(message);
		String messageDecode = monDecodeur.Decoder(messageEncode);
		
		System.out.println("Message à coder : "+message);
		System.out.println("Message codé : "+messageEncode);
		System.out.println("Message décodé : "+messageDecode);
	}
	
	public static void EssaiPermutation()
	{
		String message = "Bonjour, nous l'avons fait";
		
		CPermutation monProgPermutation = new CPermutation();
		
		IDecodeur monDecodeur = monProgPermutation;
		IEncodeur monEncodeur = monProgPermutation;
		
		String messageEncode = monEncodeur.Encoder(message);
		String messageDecode = monDecodeur.Decoder(messageEncode);
		
		System.out.println("Message à coder : "+message);
		System.out.println("Message codé : "+messageEncode);
		System.out.println("Message décodé : "+messageDecode);
	}
	
	public void EssaiCesar()
	{
		String message = "Bonjour, nous l'avons déjà fait ";
		
		IDecodeur monDecodeur = new CCesar();
		IEncodeur monEncodeur = new CCesar();
		
		String messageEncode = monEncodeur.Encoder(message);
		String messageDecode = monDecodeur.Decoder(messageEncode);
		
		System.out.println("Message à coder : "+message);
		System.out.println("Message codé : "+messageEncode);
		System.out.println("Message décodé : "+messageDecode);
	}
	
	private static void EssaiAnalyseTexte(String cheminFicherTexte)
	{
		IAnalyseurCaracteres monAnalyseur = new CAnalyseStaistiqueCaracteres();
		
		
		switch(monAnalyseur.ObtenirLangueDuTexte(cheminFicherTexte))
		{
			case FRANCAIS:
				System.out.println("Le texte est en francais");
				break;
			case ANGLAIS:
				System.out.println("Le texte est en anglais");
				break;
			default:
				System.out.println("Impossible de déterminé la langue");
				break;
		}
	}
}
