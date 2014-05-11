package com.epsi.crytographie.lesInterfaces;

import com.epsi.crytographie.lesClasses.CMessage;

public interface IEncodeur {
	String Encoder(String Message);
	CMessage Encoder(CMessage leMessage);
}
