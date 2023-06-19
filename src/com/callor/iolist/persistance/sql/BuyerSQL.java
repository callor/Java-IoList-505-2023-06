package com.callor.iolist.persistance.sql;

import com.callor.iolist.config.DBContract;

public class BuyerSQL {
	
	public static final String INSERT 
		= " INSERT INTO tbl_buyer ( buid, buname, butel, buaddr) "
		+ " VALUES(#{buId},#{buName},#{buTel},#{buAddr}) ";

	public static final String UPDATE 
			= " UPDATE " + DBContract.TABLE.BUYER + " SET "
			+ " buName	= #{buName}, "
			+ " buTel	= #{buTel}, "
			+ " buAddr	= #{buAddr},"
			+ " WHERE buId	= #{buId} "
			+ "";
	

}
