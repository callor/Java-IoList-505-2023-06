package com.callor.iolist.config;

public class HelpMessage {

	public static final void ERROR(String message) {
		ERROR(message,"");
	}
	public static final void ERROR(String message, String data) {
		System.out.println(AnsiConsol.RED(Line.sLine(70)));
		System.out.println(AnsiConsol.RED(message));
		System.out.println(AnsiConsol.RED(data));
		System.out.println(AnsiConsol.RED(Line.sLine(70)));
	}

}
