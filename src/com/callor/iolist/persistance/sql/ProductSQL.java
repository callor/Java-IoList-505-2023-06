package com.callor.iolist.persistance.sql;

import com.callor.iolist.config.DBContract;

public class ProductSQL {

	public static final String INSERT = 
			"INSERT INTO " + DBContract.TABLE.PRODUCT
			+ "(pCode, pName, pItem, pIPrice, pOPrice) "
			+ "VALUES(#{pCode}, #{pName}, "
			+ " #{pItem}, #{pIPrice}, #{pOPrice})";
	
	public static final String UPDATE = 
			" UPDATE " + DBContract.TABLE.PRODUCT
			+ " SET pName = #{pName},"
			+ " pItem = #{pItem},"
			+ " pIPrice = #{pIPrice},"
			+ " pOPrice = #{pOPrice}"
			+ " WHERE pCode = #{pCode}";
	
}
