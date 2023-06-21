package com.callor.iolist.exec;

import com.callor.iolist.config.HelpMessage;
import com.callor.iolist.controller.MainController;

public class ExecF {
	
	public static void main(String[] args) {
		MainController mainController = new MainController();
		mainController.startApp();
		
		HelpMessage.OK("야 퇴근이다!!!");
		
	}

}
