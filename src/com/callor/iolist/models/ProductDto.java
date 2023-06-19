package com.callor.iolist.models;

public class ProductDto {
	
	public String pCode;//	VARCHAR2(13)
	public String pName;//	nVARCHAR2(50)
	public String pItem;//	nVARCHAR2(10)
	private int pIPrice;//	NUMBER
	public int pOPrice;//	NUMBER
	
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(String pCode, String pName, String pItem, int pIPrice, int pOPrice) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.pItem = pItem;
		this.pIPrice = pIPrice;
		this.pOPrice = pOPrice;
	}
	
	/*
	 * 매입단가를 setting(입력)하면 
	 * 매출단가를 자동으로 계산하여 저장하기
	 * 매입단가를 DTO 에 저장할때는
	 * 		pIPrice = 얼마 를 사용하지 않고
	 * 		setIPrice(얼마) 코드를 사용한다
	 */
	public void setIPrice(int iprice) {
		
		// iprice + iprice * 0.22
		float oprice = iprice * 1.22F;
		
		// (int)(oprice / 10) : 소수점이하 자르기
		oprice = Math.round(oprice / 10) * 10; // 소수점 첫자리 반올림
		
		this.pOPrice = (int)oprice;
		
	}
	/*
	 * pIPrice 는 변수에 직접 접근할수 없도록 private 으로 선언했다
	 * 만약 외부에서 ProductDto 객체를 통하여 pIPrice 값을 읽으려고 하면
	 * private 으로 선언된 관계상 값을 읽지 못한다
	 * 외부에서 값을 읽기(참조)를 할수 있도록 getter() method 로 선언
	 * 
	 * 데이터 클래스에서 private 으로 선언된 칼럼(속성, 변수)는 
	 * getter(), setter() method 가 있어야 한다
	 */
	public int getIPrice() {
		return this.pIPrice;
	}
	
	@Override
	public String toString() {
		return "ProductDto [pCode=" + pCode + ", pName=" + pName + ", pItem=" + pItem + ", pIPrice=" + pIPrice
				+ ", pOPrice=" + pOPrice + "]";
	}

}
