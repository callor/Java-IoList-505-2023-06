package com.callor.iolist.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.iolist.config.DBContract;
import com.callor.iolist.models.IolistDto;

/*
 *  판매 등록
 *  1. 판매내역 등록(장바구니 담기)
 *  2. 장바구니 전체 리스트
 *  3. 기간별 리스트
 *  4. 고객별 리스트
 *  5. 상품별 리스트
 *  6. 고객 + 거래기간별 리스트
 *  
 *  
 *  리스트의 공통사항
 *  거래내용, 상품정보, 고객정보 이 3가지 정보를 묶어서
 *  한번에 보여줘야 한다
 *  =================================================
 *  seq 거래일자 거래시각 고객ID 고객명 상품코드 상품명 판매단가 수량 판매금액 
 */

public interface IolistService {
	
	public void printIolist(IolistDto iolist);
	public void printList();
	public void printList(List<IolistDto> iolists);	
	
	public void input();
	
	// 기간별 리스트
	public void selectBetwenDate();

	// 고객별 리스트
	public void selectByBuyer();
	
	// 상품별 리스트
	public void selectByProduct();
	
	// 고객 + 기간별 리스트
	public void selectByBuyerBetweenDate();
	
	/**
	 *  상품 + 기간별 리스트
	 */
	public void selectByProductBetweenDate();

}
