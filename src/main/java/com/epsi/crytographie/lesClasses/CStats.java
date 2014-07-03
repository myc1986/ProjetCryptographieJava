package com.epsi.crytographie.lesClasses;

import java.util.ArrayList;

import com.epsi.crytographie.lesInterfaces.IStats;


public class CStats implements IStats {
	private ArrayList<CDonneeStats> _mesStats;
	
	public CStats()
	{
		_mesStats = new ArrayList<CDonneeStats>();
		ReinitialiserStats();
	}

	public void ReinitialiserStats()
	{
		_mesStats = new ArrayList<CDonneeStats>();
		_mesStats.add(new CDonneeStats("A"));
		_mesStats.add(new CDonneeStats("B"));
		_mesStats.add(new CDonneeStats("C"));
		_mesStats.add(new CDonneeStats("D"));
		_mesStats.add(new CDonneeStats("E"));
		_mesStats.add(new CDonneeStats("F"));
		_mesStats.add(new CDonneeStats("G"));
		_mesStats.add(new CDonneeStats("H"));
		_mesStats.add(new CDonneeStats("I"));
		_mesStats.add(new CDonneeStats("J"));
		_mesStats.add(new CDonneeStats("K"));
		_mesStats.add(new CDonneeStats("L"));
		_mesStats.add(new CDonneeStats("M"));
		_mesStats.add(new CDonneeStats("N"));
		_mesStats.add(new CDonneeStats("O"));
		_mesStats.add(new CDonneeStats("P"));
		_mesStats.add(new CDonneeStats("Q"));
		_mesStats.add(new CDonneeStats("R"));
		_mesStats.add(new CDonneeStats("S"));
		_mesStats.add(new CDonneeStats("T"));
		_mesStats.add(new CDonneeStats("U"));
		_mesStats.add(new CDonneeStats("V"));
		_mesStats.add(new CDonneeStats("W"));
		_mesStats.add(new CDonneeStats("X"));
		_mesStats.add(new CDonneeStats("Y"));
		_mesStats.add(new CDonneeStats("Z"));
	}

	public ArrayList<CDonneeStats> GetDonnees()
	{
		return _mesStats;
	}

	public void AfficherLesStats()
	{
		for (CDonneeStats uneDonnee : _mesStats) {
			System.out.println("Fr�quence "+uneDonnee.GetCle()+" : "+uneDonnee.GetFrequence());
		}
	}

	public int GetFrequenceTotale()
	{
		int valTotal = 0;
		
		for (CDonneeStats uneDonnee : _mesStats) {
			valTotal = valTotal + uneDonnee.GetFrequence();
		}
		
		return valTotal;
	}

	public double GetPourcentageCle(String uneCle)
	{
		double pourcentage = 0;
		boolean aTrouveeDonnee = false;
		int iDonnee = 0;
		
		while ((_mesStats.size()-1>= iDonnee) && !aTrouveeDonnee)
		{
			if (_mesStats.get(iDonnee).GetCle().equals(uneCle))
			{
				aTrouveeDonnee = true;
				pourcentage = ((double)_mesStats.get(iDonnee).GetFrequence()/GetFrequenceTotale())*100;
			}
			
			iDonnee++;
		}
		
		return pourcentage;
	}
	
	public void AfficherStats()
	{
		for (CDonneeStats stats : _mesStats) {
			System.out.println("Clé :"+stats.GetCle()+" "+stats.GetPourcentage());
		}
	}
}
