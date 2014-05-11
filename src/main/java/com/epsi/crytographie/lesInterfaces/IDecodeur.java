package com.epsi.crytographie.lesInterfaces;

import com.epsi.crytographie.lesClasses.CMessage;

public interface IDecodeur {
	String Decoder(String message);
	CMessage Decoder(CMessage leMessage);
}
