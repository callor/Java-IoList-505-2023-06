package com.callor.iolist.persistance.sql;

public class BuyerSQL {
	
	public static final String INSERT 
		= " INSERT INTO tbl_buyer ( buid, buname, butel, buaddr) "
		+ " VALUES(#{buId},#{buName},#{buTel},#{buAddr}) ";


}
