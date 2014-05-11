package com.epsi.crytographie.lesClasses;

import java.util.Hashtable;

import com.epsi.crytographie.lesEnums.ELangue;
import com.epsi.crytographie.lesInterfaces.IBaseBigramme;

public class CBaseBigrammeAnglais implements IBaseBigramme
{
	private Hashtable<String, Double> _maBase;
	
	public CBaseBigrammeAnglais()
	{
		_maBase = new Hashtable<String, Double>();
		_maBase.put("A", new Double(8.8));
		_maBase.put("B", new Double(1.67));
		_maBase.put("C", new Double(3.18));
		_maBase.put("D", new Double(3.99));
		_maBase.put("E", new Double(12.56));
		_maBase.put("F", new Double(2.17));
		_maBase.put("G", new Double(1.80));
		_maBase.put("H", new Double(5.27));
		_maBase.put("I", new Double(7.24));
		_maBase.put("J", new Double(0.14));
		_maBase.put("K", new Double(0.63));
		_maBase.put("L", new Double(4.04));
		_maBase.put("M", new Double(2.60));
		_maBase.put("N", new Double(7.38));
		_maBase.put("O", new Double(7.47));
		_maBase.put("P", new Double(1.91));
		_maBase.put("Q", new Double(0.09));
		_maBase.put("R", new Double(6.42));
		_maBase.put("S", new Double(6.59));
		_maBase.put("T", new Double(9.15));
		_maBase.put("U", new Double(2.79));
		_maBase.put("V", new Double(1));
		_maBase.put("W", new Double(1.89));
		_maBase.put("X", new Double(0.21));
		_maBase.put("Y", new Double(1.65));
		_maBase.put("Z", new Double(0.07));
	}
	
	private double ObtenirPourcentageReference(String cle)
	{
		return _maBase.get(cle);
	}

	public double GetPourcentageReference(String laClee) {
		return ObtenirPourcentageReference(laClee);
	}

	public ELangue GetLangue() {
		return ELangue.ANGLAIS;
	}
}
