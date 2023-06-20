package com.callor.iolist.exec;

import com.callor.iolist.service.BuyerService;
import com.callor.iolist.service.impl.BuyerServiceImplV2;

public class ExecC {
	public static void main(String[] args) {
		BuyerService buyerService = new BuyerServiceImplV2();
//		buyerService.findByBuId();
		
		buyerService.insert();
		buyerService.printList();
		
		
	}

}
