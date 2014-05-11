package com.epsi.crytographie.lesClasses;

import java.util.Hashtable;

import com.epsi.crytographie.lesEnums.ELangue;
import com.epsi.crytographie.lesInterfaces.IBaseBigramme;

public class CBaseBigrammeFrancais implements IBaseBigramme
{
	private Hashtable<String, Double> _maBase;
	
	public CBaseBigrammeFrancais()
	{
		_maBase = new Hashtable<String, Double>();
		_maBase.put("A", new Double(8.4));
		_maBase.put("B", new Double(1.06));
		_maBase.put("C", new Double(3.03));
		_maBase.put("D", new Double(4.18));
		_maBase.put("E", new Double(17.26));
		_maBase.put("F", new Double(1.12));
		_maBase.put("G", new Double(1.27));
		_maBase.put("H", new Double(0.92));
		_maBase.put("I", new Double(7.34));
		_maBase.put("J", new Double(0.31));
		_maBase.put("K", new Double(0.05));
		_maBase.put("L", new Double(6.01));
		_maBase.put("M", new Double(2.96));
		_maBase.put("N", new Double(7.13));
		_maBase.put("O", new Double(5.26));
		_maBase.put("P", new Double(3.01));
		_maBase.put("Q", new Double(0.99));
		_maBase.put("R", new Double(6.65));
		_maBase.put("S", new Double(8.08));
		_maBase.put("T", new Double(7.07));
		_maBase.put("U", new Double(5.74));
		_maBase.put("V", new Double(1.32));
		_maBase.put("W", new Double(0.04));
		_maBase.put("X", new Double(0.45));
		_maBase.put("Y", new Double(0.30));
		_maBase.put("Z", new Double(0.12));
	}
	
	private double ObtenirPourcentageReference(String cle)
	{
		return _maBase.get(cle);
	}

	public double GetPourcentageReference(String laClee) {
		return ObtenirPourcentageReference(laClee);
	}
	
	public ELangue GetLangue() {
		return ELangue.FRANCAIS;
	}
}
