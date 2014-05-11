package com.epsi.crytographie.lesClasses;

import com.epsi.crytographie.lesFonctionsStatiques.FonctionsCrypto;
import com.epsi.crytographie.lesInterfaces.IDecodeur;
import com.epsi.crytographie.lesInterfaces.IEncodeur;
import com.epsi.crytographie.lesInterfaces.ILexiquePermutation;

public class CPermutation implements IEncodeur, IDecodeur {
	private ILexiquePermutation _monLexique;
	
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

	public CMessage DecoderMessage(CMessage leMessage)
	{
		leMessage.setChaineDecode(DecoderMessage(leMessage.GetMessageOrigine()));
		
		return leMessage;
	}
	
	public CPermutation()
	{
		this._monLexique=new CLexiquePermutation();
	}

	public String Decoder(String message) {
		return DecoderMessage(message);
	}

	public CMessage Decoder(CMessage leMessage) {
		return DecoderMessage(leMessage);
	}

	public String Encoder(String Message) {
		return EncoderMessage(Message);
	}

	public String EncoderMessage(String message)
	{
		StringBuffer leMessage = new StringBuffer();
		String messageFormater = FonctionsCrypto.MettreEnMajusculeSansAccent(message);
		String messageEpure = NettoyerMessage(messageFormater);
		
		EncoderOuDecoderMessageEpure(leMessage, messageEpure, true);
		
		return leMessage.toString();
	}

	private void EncoderOuDecoderMessageEpure(StringBuffer leMessage, String messageEpure, boolean encode) {
		
		for (char caractere : messageEpure.toCharArray()) {
			String caractereStringOrg = Character.toString(caractere);
			Integer nombre = 0;
			String chainePermute = "";
			
			if(_monLexique.ExisteCaractere(caractereStringOrg) && _monLexique.ExisteCaracterePermute(caractereStringOrg))
			{
				if (encode) {
					nombre = Integer.parseInt(_monLexique.GetNumber(caractereStringOrg));
					chainePermute = _monLexique.getCharacterePermute(nombre);
				}
				else
				{
					nombre = _monLexique.GetNumberPermute(caractereStringOrg);
					chainePermute = _monLexique.getCharactere(nombre);
				}
				
				leMessage.append(chainePermute);
			}
			else
			{
				System.out.println("Caract�res non pr�sent dans le dictionnaire de permutation : "+caractereStringOrg);
				leMessage.append(caractereStringOrg);
			}
		}
	}
	
	public CMessage Encoder(CMessage leMessage) {
		return EncoderMessage(leMessage);
	}
}
