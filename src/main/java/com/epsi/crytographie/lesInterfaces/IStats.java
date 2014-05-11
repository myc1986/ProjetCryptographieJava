package com.epsi.crytographie.lesInterfaces;

import java.util.ArrayList;

import com.epsi.crytographie.lesClasses.CDonneeStats;

public interface IStats {
	void ReinitialiserStats();
	
	ArrayList<CDonneeStats> GetDonnees();
	
	void AfficherLesStats();
	
	int GetFrequenceTotale();
	
	double GetPourcentageCle(String uneCle);
}
