package com.callor.iolist.config;

/*
 * DBMS 접속정보,
 * 테이블 정보
 * 칼럼 정보를 static 변수로 선언하는 클래스
 */
public class DBContract {
	
	// oracle DBMS 접속 정보 설정
	public static final String JDBC_DRIVER 
			= "oracle.jdbc.driver.OracleDriver";
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER_NAME = "iolist";
	public static final String PASSWORD = "12341234";
	
	// table 정보 설정
	public static class TABLE {
		public static final String BUYER = " tbl_buyer ";
		public static final String PRODUCT = " tbl_product ";
		public static final String IOLIST = " tbl_iolist ";
	}
	
	// 칼럼 index 정보 설정
	public static class INDEX {
		public static class BUYER {
			public static final int BU_ID = 1;
			public static final int BU_NAME = 2;
			public static final int BU_TEL = 3;
			public static final int BU_ADDR = 4;
		}
		public static class PRODUCT {
			public static final int P_CODE = 1;
			public static final int P_NAME = 2;
			public static final int P_ITEM = 3;
			public static final int P_IPRICE = 4;
			public static final int P_OPRICE = 5;
		}
		public static class IOLIST {
			public static final int IO_SEQ = 1;
			public static final int IO_DATE = 2;
			public static final int IO_TIME = 3;
			public static final int IO_BUID = 4;
			public static final int IO_PCODE = 5;
			
			public static final int IO_QUAN = 6;
			public static final int IO_PRICE = 7;
			public static final int IO_TOTAL = 8;
		}
	}
	
	
	

}
