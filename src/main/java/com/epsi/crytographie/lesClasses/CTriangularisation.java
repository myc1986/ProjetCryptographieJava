package com.epsi.crytographie.lesClasses;

import com.epsi.crytographie.lesFonctionsStatiques.FonctionsCrypto;
import com.epsi.crytographie.lesInterfaces.IDecodeur;
import com.epsi.crytographie.lesInterfaces.IEncodeur;
import com.epsi.crytographie.lesInterfaces.ILexiqueTriangularisation;

public class CTriangularisation implements IDecodeur, IEncodeur {
	private static final int FREQUENCE_ECRIT_TEXTE = 5;
	private ILexiqueTriangularisation _monLexique;
	
	
	public CTriangularisation()
	{
		_monLexique = new CLexiqueTriangularisation();
	}
	
	public int GetLargeurCadrillage()
	{
		int largeurCadrillage = 0; 
		
		largeurCadrillage = _monLexique.GetLargeurCadrillage();
		
		return largeurCadrillage;
	}
	
	public int GetLargeurLigneTexte(Integer numeroLigneCadrillage)
	{
		int largeurLigneTexte = 0;
		
		largeurLigneTexte = _monLexique.GetLargeurLigneTexte();
		
		return largeurLigneTexte;
	}
	
	public int GetNombreLigneCadrillage()
	{
		int nbrLigneCadrillage = 0;
		
		nbrLigneCadrillage = _monLexique.GetLargeurCadrillage();
		
		return nbrLigneCadrillage;
	}

	public String Encoder(String Message) {
		// TODO Auto-generated method stub
		return null;
	}

	public CMessage Encoder(CMessage leMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	public String Decoder(String message) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CMessage Decoder(CMessage leMessage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CMessage EncoderMessage(CMessage leMessage)
	{
		leMessage.setChaineEncode(EncoderMessage(leMessage.GetMessageOrigine()));
		
		return leMessage;
	}

	public String DecoderMessage(String message)
	{
		StringBuffer leMessage = new StringBuffer();
		String messageEpure = FonctionsCrypto.MettreEnMajusculeSansAccent(message);
		
		EncoderOuDecoderMessageEpure(leMessage, messageEpure, false);
		
		return leMessage.toString();
	}
	
	private String NettoyerMessage(String message) {
		
		StringBuffer monNouveauMessage = new StringBuffer();
		
		for (char caractere : message.toCharArray()) {
			String caractereString = Character.toString(caractere);
			
			if (_monLexique.ExisteCaractere(caractereString)) {
				monNouveauMessage.append(caractereString);
			}
		}
		
		return monNouveauMessage.toString();
	}
	
	public String EncoderMessage(String message)
	{
		StringBuffer leMessage = new StringBuffer();
		String messageFormater = FonctionsCrypto.MettreEnMajusculeSansAccent(message);
		String messageEpure = NettoyerMessage(messageFormater);
		
		EncoderOuDecoderMessageEpure(leMessage, messageEpure, true);
		
		return leMessage.toString();
	}
	
	
	public CMessage DecoderMessage(CMessage leMessage)
	{
		leMessage.setChaineDecode(DecoderMessage(leMessage.GetMessageOrigine()));
		
		return leMessage;
	}
	
	private void EncoderOuDecoderMessageEpure(StringBuffer leMessage, String messageEpure, boolean encode) {
		
		Integer iCount = 1;
		StringBuilder deuxCaracteres = new StringBuilder();
		
		for (char caractere : messageEpure.toCharArray()) {
			
			Integer nombre = 0;
			String chaineRecupere = "";
			
			if (encode) {
				
				if(_monLexique.ExisteCaractere(Character.toString(caractere)))
				{
					nombre = Integer.parseInt(_monLexique.GetNumber(Character.toString(caractere)));
					leMessage.append(nombre.toString());
				}
				else
				{
					leMessage.append(Character.toString(caractere));
				}
			}
			else
			{
				if (iCount % 2 == 0) {
					deuxCaracteres.append(Character.toString(caractere));
					
					if(_monLexique.ExisteNumber(Integer.parseInt(deuxCaracteres.toString())))
					{	
						chaineRecupere = _monLexique.getCharactere(Integer.parseInt(deuxCaracteres.toString()));
						leMessage.append(chaineRecupere);
					}
					else
					{
						leMessage.append(deuxCaracteres.toString());
					}
				}
				else
				{
					deuxCaracteres = new StringBuilder();
					deuxCaracteres.append(Character.toString(caractere));
				}
			}
			
			iCount = iCount + 1;
		}
	}
}
