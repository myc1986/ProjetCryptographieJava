package com.epsi.crytographie.lesClasses;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.epsi.crytographie.lesEnums.ELangue;
import com.epsi.crytographie.lesFonctionsStatiques.FonctionsCrypto;
import com.epsi.crytographie.lesInterfaces.IAnalyseurCaracteres;
import com.epsi.crytographie.lesInterfaces.IBaseBigramme;
import com.epsi.crytographie.lesInterfaces.IStats;

public class CAnalyseStaistiqueCaracteres implements IAnalyseurCaracteres{
	private IStats _maStats;
	private ArrayList<IBaseBigramme> _maBaseBigramme;
	
	public CAnalyseStaistiqueCaracteres()
	{
		_maStats = new CStats();
		_maBaseBigramme = new ArrayList<IBaseBigramme>();
		_maBaseBigramme.add(new CBaseBigrammeFrancais());
		_maBaseBigramme.add(new CBaseBigrammeAnglais());
	}
	
	public void AnalyserFichierCode()
	{
		
	}
	
	public void AnalyserFichier(String leFichier)
	{
		StringBuilder monBuilderString;
		
		try
		{	
			monBuilderString = ObtenirTexteBrut(leFichier);
			
			AnalyserTexteBrut(monBuilderString);
		} catch (Exception e) {

		}
	}

	private StringBuilder ObtenirTexteBrut(String leFichier)
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
		
		return monBuilderString;
	}

	public void AnalyserTexteBrut(StringBuilder monBuilderString) {
		for (CDonneeStats cetteDonnee : _maStats.GetDonnees())
		{
			Integer frequenceTrouvee = 0;
			
			frequenceTrouvee=FonctionsCrypto.MettreEnMajusculeSansAccent(monBuilderString.toString()).split(cetteDonnee.GetCle()).length-1;
			
			if (frequenceTrouvee<=0) {
				frequenceTrouvee = 0;
			}
			
			cetteDonnee.IncrementerFrequence(frequenceTrouvee);
		}
	}
	
	public double GetPourcentageUneDonnee(String laCle)
	{
		String cleeEnMajuscule = FonctionsCrypto.MettreEnMajusculeSansAccent(laCle);
		
		double pourcentage = 0;
		
		pourcentage = _maStats.GetPourcentageCle(cleeEnMajuscule);

		return pourcentage;
	}
	
	public ELangue GetLangueTexte(String unFichier)
	{
		AnalyserFichier(unFichier);

		return DeterminerLangueText();
	}
	
	private ELangue DeterminerLangueText()
	{
		ELangue laLangue = null;
		double plusPetitEcart = 0;
		boolean estLaPremiereValeur = true;

		for (IBaseBigramme uneBase : _maBaseBigramme) 
		{
			if (estLaPremiereValeur)
			{
				plusPetitEcart = CalulerCumulEcartLangueDuTexte(uneBase);
				estLaPremiereValeur = false;
				laLangue = uneBase.GetLangue();
			}
			else
			{
				if (plusPetitEcart>CalulerCumulEcartLangueDuTexte(uneBase)) 
				{
					laLangue = uneBase.GetLangue();
				}
			}
		}
		
		return laLangue;
	}
	
	private double CalulerCumulEcartLangueDuTexte(IBaseBigramme laBaseBigramme)
	{	
		double cumulEcart =0;
		
		for (CDonneeStats laDonnee : _maStats.GetDonnees())
		{
			cumulEcart = cumulEcart + Math.abs((double)(GetPourcentageUneDonnee(laDonnee.GetCle()) - laBaseBigramme.GetPourcentageReference(laDonnee.GetCle())));
		}
		
		return cumulEcart;
	}

	public ELangue ObtenirLangueDuTexte(String cheminFichierTexte) {
		return GetLangueTexte(cheminFichierTexte);
	}

	public ELangue ObtenirLangueDuTexteCode(String cheminFichierTexte) {
		return GetLangueTexte(cheminFichierTexte);
	}
	
	public IStats GetStats()
	{
		return _maStats;
	}
}
