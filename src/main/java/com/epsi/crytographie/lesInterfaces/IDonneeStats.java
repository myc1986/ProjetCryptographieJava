package com.epsi.crytographie.lesInterfaces;

public interface IDonneeStats {
	String GetCle();
	
	Integer GetFrequence();
	
	Double GetPourcentage();
	
	void IncrementerFrequence(Integer leNombre);
}
