package com.callor.iolist.service.impl;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.iolist.config.DBConnection;
import com.callor.iolist.config.HelpMessage;
import com.callor.iolist.config.Line;
import com.callor.iolist.models.BuyerDto;
import com.callor.iolist.models.IolistDto;
import com.callor.iolist.models.ProductDto;
import com.callor.iolist.persistance.BuyerDao;
import com.callor.iolist.persistance.IolistDao;
import com.callor.iolist.persistance.ProductDao;
import com.callor.iolist.service.BuyerService;
import com.callor.iolist.service.IolistService;
import com.callor.iolist.service.ProductService;

public class IolistServiceImplV1 implements IolistService{
	
	// Iolist와 Buyer, Product 기능을 서로 연결하는 것
	// 의존성 주입(Dependency Injection)
	protected final Scanner scan;

	protected final IolistDao iolistDao;
	protected final BuyerDao buyerDao;
	protected final ProductDao productDao;
	
	protected final BuyerService buyerService;
	protected final ProductService productService;
	
	public IolistServiceImplV1() {
		scan = new Scanner(System.in);
		
		SqlSession sqlSession 
		= DBConnection.getSessionFactory().openSession(true);
		
		iolistDao = sqlSession.getMapper(IolistDao.class);
		buyerDao = sqlSession.getMapper(BuyerDao.class);
		productDao = sqlSession.getMapper(ProductDao.class);
		
		buyerService = new BuyerServiceImplV2();
		productService = new ProductServiceImplV1();

	}	
	
	@Override
	public void printIolist(IolistDto iolist) {

		// TODO Auto-generated method stub
		System.out.printf("%d\t",iolist.ioSEQ);
		System.out.printf("%s\t",iolist.ioDate);
		System.out.printf("%s\t",iolist.ioTime);
		
		System.out.printf("%s\t","고객ID");
		System.out.printf("%s\t","고객명");
		
		System.out.printf("%s\t","상품코드");
		System.out.printf("%s\t","상품명");
		
		System.out.printf("%d\t",iolist.ioPrice);
		System.out.printf("%d\t",iolist.ioQuan);
		System.out.printf("%d\n",iolist.ioTotal);
		
	}

	@Override
	public void printList() {
		List<IolistDto> iolists = iolistDao.selectAll();
		this.printList(iolists);
	}

	@Override
	public void printList(List<IolistDto> iolists) {

		System.out.println(Line.sLine(100));
		System.out.println("SEQ\t거래일자\t거래시각\t고객ID\t고객명\t"
				+ "상품코드\t상품명\t판매단가\t수량\t합계");
		System.out.println(Line.sLine(100));
		for(IolistDto dto : iolists) {
			this.printIolist(dto);
		}
	}

	@Override
	public void input() {
		while(true) {
			System.out.println(Line.dLine(70));
			System.out.println("장바구니 담기 - v1");
			System.out.println(Line.dLine(70));
			
			BuyerDto buyerDto = null;
			while(true) {
				buyerDto = buyerService.findByBuName();
				if(buyerDto == null) {
					HelpMessage.CONFIRM(
							"장바구니 담기를 종료할까요?", 
							"Y:종료 >> ");
					String yesNo = scan.nextLine();
					if(yesNo.equalsIgnoreCase("Y")) return ;
					else continue;
				}
				break;
			}
			
			ProductDto productDto = null;
			while(true) {
				productDto = productService.findByPName();
				if(productDto == null) {
					HelpMessage.CONFIRM(
							"장바구니 담기를 종료할까요?", 
							"Y:종료 >> ");
					String yesNo = scan.nextLine();
					if(yesNo.equalsIgnoreCase("Y")) return;
					else continue;
				}
				break;
			}
		}
	}

	@Override
	public void selectBetwenDate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectByBuyer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectByProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectByBuyerBetweenDate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectByProductBetweenDate() {
		// TODO Auto-generated method stub
		
	}

}
