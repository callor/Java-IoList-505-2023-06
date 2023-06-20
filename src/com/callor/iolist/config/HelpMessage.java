package com.callor.iolist.config;

public class HelpMessage {

	public static final void ALERT(String message) {
		System.out.println(AnsiConsol.GREEN(Line.sLine(70)));
		System.out.println(AnsiConsol.GREEN(message));
		System.out.println(AnsiConsol.GREEN(Line.sLine(70)));
	}
	
	public static final void OK(String message) {
		System.out.println(AnsiConsol.PURPLE(Line.sLine(70)));
		System.out.println(AnsiConsol.PURPLE(message));
		System.out.println(AnsiConsol.PURPLE(Line.sLine(70)));
	}
	
	
	public static final void ERROR(String message) {
		ERROR(message,"");
	}
	public static final void ERROR(String message, String prompt) {
		System.out.println(AnsiConsol.RED(Line.sLine(70)));
		System.out.println(AnsiConsol.RED(message));
		if(!prompt.equals(""))
			System.out.print(AnsiConsol.RED(prompt));
		else
			System.out.println(AnsiConsol.RED(Line.sLine(70)));
	}

	public static final void CONFIRM(String message, String prompt) {
		System.out.println(AnsiConsol.CYAN(Line.sLine(70)));
		System.out.println(AnsiConsol.CYAN(message));
		if(!prompt.equals("")) {
			System.out.print(AnsiConsol.CYAN(prompt));
		} else {
			System.out.println(AnsiConsol.CYAN(Line.sLine(70)));
		}
	}

	
	
}
