package com.callor.iolist.controller;

import java.util.Scanner;

import com.callor.iolist.config.AnsiConsol;
import com.callor.iolist.config.HelpMessage;
import com.callor.iolist.config.Line;
import com.callor.iolist.service.BuyerService;
import com.callor.iolist.service.IolistService;
import com.callor.iolist.service.ProductService;
import com.callor.iolist.service.impl.BuyerServiceImplV2;
import com.callor.iolist.service.impl.IolistServiceImplV1;
import com.callor.iolist.service.impl.ProductServiceImplV1;

public class MainController {
	
	protected final Scanner scan;
	protected final BuyerService buyerService;
	protected final ProductService productService;
	protected final IolistService iolistService;
	
	public MainController() {
		scan = new Scanner(System.in);
		buyerService= new BuyerServiceImplV2();
		productService = new ProductServiceImplV1();
		iolistService = new IolistServiceImplV1();
	}
	
	protected void header() {
		System.out.println(Line.dLine(100));
		System.out.println("우리 쇼핑몰 ERP 2023");
		System.out.println(Line.dLine(100));
	}
	
	protected void nav() {
		String[] navs = {
				"상품관리",
				Line.sLine(100),
				"\t\t1. 상품 리스트",
				"\t\t2. 상품등록 및 수정",
				Line.sLine(100),
				"고객관리",
				Line.sLine(100),
				"\t\t3. 고객리스트",
				"\t\t4. 고객등록 및 수정",
				Line.sLine(100),
				"상품판매",
				Line.sLine(100),
				"\t\t5. 장바구니 담기",
				"\t\t6. 전체 리스트",
				"\t\t7. 기간별 리스트",
				"\t\t8. 구매자별 리스트",
				"\t\t9. 상품별 리스트",
				Line.sLine(100),
				"QUIT. 끝내기",
				Line.dLine(100),
		};
		for(String nav : navs) {
			System.out.println(AnsiConsol.CYAN(nav));
		}
	}
	
	public void startApp() {
		this.header();
		while(true) {
			this.nav();
			System.out.print("업무선택 >> ");
			String strSelect = scan.nextLine();
			if(strSelect.equals("QUIT")) return;
			int intSelect = 0;
			try {
				intSelect = Integer.valueOf(strSelect);
			} catch (Exception e) {
				HelpMessage.ERROR("업무선택은 1 ~ 9 정수로 선택하세요");
				continue;
			}
			
			switch(intSelect) {
			case 1 :
				// 상품 전체리스트
				productService.printList();
				break;
			case 2 :
				// 상품 등록 및 수정
				productService.insert();
				break;
			case 3 :
				// 고객 전체리스트
				buyerService.printList();
				break;
			case 4 :
				// 고객 등록 및 수정
				buyerService.insert();
				break;
				
			case 5 : 
				// 장바구니 추가
				iolistService.input();
				break;
			case 6 :
				// 장바구니 전체 리스트
				iolistService.printList();
				break;
				
			case 7 :
				// 기간별 리스트
				iolistService.selectBetwenDate();
				break;
			case 8 :
				// 고객별 리스트
				iolistService.selectByBuyer();
				break;
			case 9 :
				// 상품별 리스트
				iolistService.selectByProduct();
				break;
			default :
				HelpMessage.ALERT("업무선택은 1 ~ 9까지 ");
			}
		}
		
		
		
	}
	
	
	
	

}
