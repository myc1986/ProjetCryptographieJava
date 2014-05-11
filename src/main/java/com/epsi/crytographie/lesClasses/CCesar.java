package com.epsi.crytographie.lesClasses;

import com.epsi.crytographie.lesFonctionsStatiques.FonctionsCrypto;
import com.epsi.crytographie.lesInterfaces.IDecodeur;
import com.epsi.crytographie.lesInterfaces.IEncodeur;
import com.epsi.crytographie.lesInterfaces.ILexiqueCesar;

public class CCesar implements IEncodeur, IDecodeur{
	private int _decalage;
	private ILexiqueCesar _monLexique;
	
	public CMessage EncoderMessage(CMessage leMessage)
	{
		leMessage.setChaineEncode(EncoderMessage(leMessage.GetMessageOrigine()));
		
		return leMessage;
	}
	
	public CMessage DecoderMessage(CMessage leMessage)
	{
		leMessage.setChaineDecode(DecoderMessage(leMessage.GetMessageEncode()));
		
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
	
	public CCesar()
	{
		this._decalage=2;
		this._monLexique = new CLexiqueCesar();
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
			
			if(_monLexique.ExisteCaractere(caractereStringOrg))
			{
				if (encode) {
					nombre = Math.abs(Integer.parseInt(_monLexique.GetNumber(caractereStringOrg))+_decalage) % _monLexique.GetNombreElement();
				}
				else
				{
					nombre = Math.abs(Integer.parseInt(_monLexique.GetNumber(caractereStringOrg))-_decalage) % _monLexique.GetNombreElement();
				}
				
				if (nombre == 0) {
					leMessage.append(_monLexique.getCharactere(_monLexique.GetNombreElement()));
				} else {
					leMessage.append(_monLexique.getCharactere(nombre));
				}
			}
			else
			{
				leMessage.append(caractereStringOrg);
			}
		}
	}
	
	public CMessage Encoder(CMessage leMessage) {
		return EncoderMessage(leMessage);
	}
}
