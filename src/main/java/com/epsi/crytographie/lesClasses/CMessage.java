package com.epsi.crytographie.lesClasses;

public class CMessage {
	private String _messageOrigine;
	private String _chaineDecode;
	private String _chaineEncode;
	
	public void setChaineDecode(String chaineDecode) {
		this._chaineDecode = chaineDecode;
	}

	public void setChaineEncode(String chaineEncode) {
		this._chaineEncode = chaineEncode;
	}
	
	public CMessage(String message)
	{
		this._chaineDecode="";
		this._chaineEncode="";
		this._messageOrigine=message;
	}
	
	public CMessage(CFichier leFichier)
	{
		this._chaineDecode="";
		this._chaineEncode="";
		this._messageOrigine=leFichier.ObtenirTexteBrutSurUneLigne();
	}
	
	public String getMessageDecode()
	{
		return this._chaineDecode;
	}
	
	public String GetMessageEncode()
	{
		return this._chaineEncode;
	}
	
	public String GetMessageOrigine()
	{
		return this._messageOrigine;
	}
}
