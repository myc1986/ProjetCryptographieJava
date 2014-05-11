package com.epsi.crytographie.lesClasses;

import com.epsi.crytographie.lesFonctionsStatiques.FonctionsCrypto;
import com.epsi.crytographie.lesInterfaces.IDonneeStats;

public class CDonneeStats implements IDonneeStats {
	private String _cle;
	private Integer _frequence;
	private double _pourcentage;
	
	public CDonneeStats()
	{
		_cle="";
		_frequence=0;
		_pourcentage=0;
	}
	
	public CDonneeStats(String laClee) 
	{
		_cle=FonctionsCrypto.MettreEnMajusculeSansAccent(laClee);
		_frequence=0;
		_pourcentage=0;
	}
	
	public String GetCle()
	{
		return _cle;
	}
	
	public Integer GetFrequence()
	{
		return _frequence;
	}
	
	public Double GetPourcentage()
	{
		return _pourcentage;
	}
	
	public void IncrementerFrequence(Integer leNombre)
	{
		_frequence= _frequence+leNombre;
	}
	
}
