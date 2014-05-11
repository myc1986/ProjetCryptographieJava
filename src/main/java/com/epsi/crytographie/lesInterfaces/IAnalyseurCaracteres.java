package com.epsi.crytographie.lesInterfaces;

import com.epsi.crytographie.lesEnums.ELangue;

public interface IAnalyseurCaracteres {
	ELangue ObtenirLangueDuTexte(String cheminFichierTexte);
	ELangue ObtenirLangueDuTexteCode(String cheminFichierTexte);
}