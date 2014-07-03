package com.epsi.crytographie.Programmes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.epsi.crytographie.lesClasses.CAnalyseStaistiqueCaracteres;
import com.epsi.crytographie.lesClasses.CCesar;
import com.epsi.crytographie.lesClasses.CPermutation;
import com.epsi.crytographie.lesClasses.CPolybe;
import com.epsi.crytographie.lesFonctionsStatiques.FonctionsCrypto;
import com.epsi.crytographie.lesInterfaces.IAnalyseurCaracteres;
import com.epsi.crytographie.lesInterfaces.IDecodeur;
import com.epsi.crytographie.lesInterfaces.IEncodeur;

public class ProgCryptographie {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		CesarDecoder("C:\\Users\\Myc\\Google Drive\\Cours\\Cours EPSI\\Projet école\\projets_java\\text_analyse_fr2.txt");
		EssaiCesar("C:\\Users\\Myc\\Google Drive\\Cours\\Cours EPSI\\Projet école\\projets_java\\text_analyse_fr2.txt");
		EssaiAnalyseTexte("C:\\Users\\Myc\\Google Drive\\Cours\\Cours EPSI\\Projet école\\projets_java\\text_analyse_fr2.txt");
		EssaiPermutation("C:\\Users\\Myc\\Google Drive\\Cours\\Cours EPSI\\Projet école\\projets_java\\text_analyse_fr2.txt");
		EssaiPolybe("C:\\Users\\Myc\\Google Drive\\Cours\\Cours EPSI\\Projet école\\projets_java\\text_analyse_fr2.txt");
	}
	
	public static void EssaiPolybe(String chemin) throws FileNotFoundException, IOException
	{
		String message = FonctionsCrypto.ObtenirTexteBrut(chemin);
		
		CPolybe monProgPermutation = new CPolybe();
		
		IDecodeur monDecodeur = monProgPermutation;
		IEncodeur monEncodeur = monProgPermutation;
		
		String messageEncode = monEncodeur.Encoder(message);
		String messageDecode = monDecodeur.Decoder(messageEncode);
		
		System.out.println("Message à coder : "+message);
		System.out.println("Message codé : "+messageEncode);
		System.out.println("Message décodé : "+messageDecode);
	}
	
	public static void EssaiPermutation(String chemin) throws FileNotFoundException, IOException
	{
		String message = FonctionsCrypto.ObtenirTexteBrut(chemin);
		
		CPermutation monProgPermutation = new CPermutation();
		
		IDecodeur monDecodeur = monProgPermutation;
		IEncodeur monEncodeur = monProgPermutation;
		
		String messageEncode = monEncodeur.Encoder(message);
		String messageDecode = monDecodeur.Decoder(messageEncode);
		
		System.out.println("Message à coder : "+message);
		System.out.println("Message codé : "+messageEncode);
		System.out.println("Message décodé : "+messageDecode);
	}
	
	public static void EssaiCesar(String chemin) throws FileNotFoundException, IOException
	{
		String message = FonctionsCrypto.ObtenirTexteBrut(chemin);
		
		IDecodeur monDecodeur = new CCesar();
		IEncodeur monEncodeur = new CCesar();
		
		String messageEncode = monEncodeur.Encoder(message);
		String messageDecode = monDecodeur.Decoder(messageEncode);
		
		System.out.println("Message à coder : "+message);
		System.out.println("Message codé : "+messageEncode);
		System.out.println("Message décodé : "+messageDecode);
		
	}
	
	public static void CesarDecoder(String chemin) throws FileNotFoundException, IOException
	{
		
		boolean decode = false;
		Integer iDecalage = 0;
		
		while (!decode) {
			String message = FonctionsCrypto.ObtenirTexteBrut(chemin);
			
			CCesar monCesar = new CCesar();
			monCesar.setDecalage(iDecalage);
			
			IDecodeur monDecodeur = monCesar;
			
			String messageDecode = monDecodeur.Decoder(message);
			
			System.out.println("Message codé : "+message);
			System.out.println("Message décodé : "+messageDecode);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Ce messag est il bien décodé ? 1: OUI, 0:NON");
			String reponse = scan.nextLine();
			
			if(reponse.equals("1"))
			{
				decode = true;
				System.out.println("Message décodé Finale: "+messageDecode);
				System.out.println("Décalage : "+iDecalage.toString());
				FonctionsCrypto.GenererFichier(messageDecode, chemin);
			}
			
			iDecalage = iDecalage+1;
		}
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
