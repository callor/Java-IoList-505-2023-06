package com.callor.iolist.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	protected final String DATE = "DATE";
	protected final String TIME = "TIME";
	
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
		
		System.out.printf("%s\t",iolist.ioBuId);
		System.out.printf("%s\t",
				buyerDao.findById(iolist.ioBuId).buName );
		
		System.out.printf("%s\t",iolist.ioPCode);
		System.out.printf("%s\t",
				productDao.findById(iolist.ioPCode).pName );
		
		System.out.printf("%d\t",iolist.getIoPrice());
		System.out.printf("%d\t",iolist.getIoQuan());
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
	
	protected Map<String, String> getDateTime() {
		
		// 현재 날짜와 시각을 getter
		// Java 1.8 이후에 사용하는 새로운 날째 객체
		LocalDateTime localDateTime = LocalDateTime.now(); 
		
		// 날짜와 시간데이터를 문자열로 변환 하기 위한 도구
		DateTimeFormatter strDate = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		DateTimeFormatter strTime = DateTimeFormatter.ofPattern("HH-mm-ss");
		
		String curDate = strDate.format(localDateTime);
		String curTime = strTime.format(localDateTime);
		
		/*
		 * Java의 Map<?,?> class 를 사용하여 임시 Dto 객체 만들기
		 * Map class 이용한 객체는 key,value 가 쌍으로 이루어진 데이터 객체
		 */
		// String type의 key, 
		// String type의 value 를 갖는 임시 Dto 객체
		// JS 의 JSON 객체와 유사한 구조
		// dateTime = {
		//		DATE : curDate,
		//		TIME : curTime	
		// }
		Map<String, String> dateTime = new HashMap<>();
		dateTime.put(DATE, curDate);
		dateTime.put(TIME, curTime);
		return dateTime;
	}
	

	@Override
	public void input() {
		while(true) {
			
			// 장바구니 객체 시작
			IolistDto iolistDto = new IolistDto();
			
			// 현재 날짜와 시각을 세팅
			Map<String, String> dateTime = this.getDateTime();
			iolistDto.ioDate = dateTime.get(DATE);
			iolistDto.ioTime = dateTime.get(TIME);
			
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
			} // 고객정보 조회
			HelpMessage.ALERT("조회한 고객정보 : " + buyerDto.toString());
			
			iolistDto.ioBuId = buyerDto.buId;
			String message = String.format("조회한 고객코드 %s, 고객이름 %s",
					iolistDto.ioBuId, buyerDto.buName);
			HelpMessage.ALERT(message);
			
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
			} // 상품정보 조회 end
			HelpMessage.ALERT("조회한 상품정보 : " + productDto.toString());
			iolistDto.ioPCode = productDto.pCode;
			
			message = String.format("검색한 상품코드 : %s, 상품이름 : %s",
					iolistDto.ioPCode, productDto.pName);
			HelpMessage.ALERT(message);
			
			/*
			 *  판매단가 입력
			 *  판매단가는 기본적으로 상품정보에 등록되어 있다.
			 *  보통은 상품정보에 등록된 판매단가를 그대로 사용하고
			 *  필요에 따라 판매단가를 변경하여 사용한다
			 */
			while(true) {
				System.out.println(Line.sLine(70));
				System.out.println("판매단가를 입력해 주세요 QUIT:종료");
				System.out.println("판매단가를 그대로 사용하려면 Enter");
				System.out.printf("판매단가 (%s) >> ",productDto.pOPrice);
				
				String strPrice = scan.nextLine();
				if(strPrice.equals("QUIT")) return;
				
				try {
					int intPrice = Integer.valueOf(strPrice);
					iolistDto.setIoPrice(intPrice);
				} catch (Exception e) {
					// TODO: handle exception
					// 그냥 Enter 를 눌렀을 경우, 
					// 또는 숫자 이외의 문자가 입력된 경우
					if(strPrice.isBlank()) {
						iolistDto.setIoPrice(productDto.pOPrice);
					} else {
						HelpMessage.ERROR(
							String.format("판매단가는 정수로 입력하세요 (%s)", 
									strPrice)
						);
						continue;
					}
				} // end try
				break;
			}
			HelpMessage.ALERT("입력한 판매단가 : " + iolistDto.getIoPrice());
			

			while(true) {
				System.out.println("상품 판매 수량을 입력하세요 QUIT;종료");
				System.out.print("수량 >> ");
				String strQuan = scan.nextLine();
				if(strQuan.equals("QUIT")) return;
				else if(strQuan.isBlank()) {
					HelpMessage.ERROR("수량을 입력해야 합니다");
					continue;
				}
				try {
					int intQuan = Integer.valueOf(strQuan);
					iolistDto.setIoQuan(intQuan);
				} catch (Exception e) {
					HelpMessage.ERROR(
							String.format("수량은 정수로 입력하세요 (%s)",strQuan));
					continue;
				}
				break;
			}
			HelpMessage.ALERT("입력한 수량 : " + iolistDto.getIoQuan());
			HelpMessage.ALERT("계산된 합계 : " + iolistDto.ioTotal);
			
			int result = iolistDao.insert(iolistDto);
			if(result > 0) {
				HelpMessage.OK("장바구니 추가 OK");
			} else {
				HelpMessage.ERROR("장바구니 추가 실패!!");
			}
		} // 제일 바깥쪽 while, 장바구니 등록을 연속으로 처리하기 위한 것
	}

	@Override
	public void selectBetwenDate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectByBuyer() {
		// TODO Auto-generated method stub
		BuyerDto buyerDto = buyerService.findByBuName();
		if(buyerDto == null) {
			HelpMessage.ERROR("고객정보가 없습니다");
		} else {
			List<IolistDto> iolists 
				= iolistDao.selectByBuyer(buyerDto.buId);
			this.printList(iolists);
		}
		
	}

	@Override
	public void selectByProduct() {
		// TODO Auto-generated method stub
		ProductDto productDto = productService.findByPName();
		if(productDto == null) {
			HelpMessage.ERROR("상품 정보를 찾을 수 없습니다");
		} else {
			List<IolistDto> iolists 
			= iolistDao.selectByProduct(productDto.pCode) ;
			this.printList(iolists);
		}
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
