package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.callor.iolist.config.DBContract;
import com.callor.iolist.models.IolistDto;

/*
 *  1. 판매내역 등록(장바구니 담기)
 *  2. 장바구니 전체 리스트
 *  3. 기간별 리스트
 *  4. 고객별 리스트
 *  5. 상품별 리스트
 *  6. 고객 + 거래기간별 리스트
 */
public interface IolistDao {

	@Select("SELECT * FROM " 
			+ DBContract.TABLE.IOLIST 
			+ " ORDER BY ioDate, ioTime")
	public List<IolistDto> selectAll();
	
	// 기간별 리스트
	@Select("SELECT * FROM " 
			+ DBContract.TABLE.IOLIST
			+ " WHERE io_date BETWEEN #{sDate} AND #{eDate} "
			+ " ORDER BY ioDate, ioTime")
	public List<IolistDto> selectBetwenDate(String sDate, String eDate);

	// 고객별 리스트
	@Select("SELECT * FROM " 
			+ DBContract.TABLE.IOLIST
			+ " WHERE ioBuid = #{buid} "
			+ " ORDER BY ioDate, ioTime")
	public List<IolistDto> selectByBuyer(String buId);
	
	// 상품별 리스트
	@Select("SELECT * FROM " 
			+ DBContract.TABLE.IOLIST
			+ " WHERE ioPcode = #{pCode} "
			+ " ORDER BY ioDate, ioTime")
	public List<IolistDto> selectByProduct(String pCode);
	
	// 고객 + 기간별 리스트
	@Select("SELECT * FROM " 
			+ DBContract.TABLE.IOLIST
			+ " WHERE ioBuid = #{buId} "
			+ " AND ioDate BETWEEN #{sDate} AND #{eDate} "
			+ " ORDER BY ioDate, ioTime")
	public List<IolistDto> selectByBuyerBetweenDate(String buId,String sDate, String eDate);
	
	// 상품 + 기간별 리스트
	@Select("SELECT * FROM " 
			+ DBContract.TABLE.IOLIST
			+ " WHERE ioPcode = #{pCode} "
			+ " AND ioDate BETWEEN #{sDate} AND #{eDate} "
			+ " ORDER BY ioDate, ioTime")
	public List<IolistDto> selectByProductBetweenDate(String pCode,String sDate, String eDate);
	
	@Insert("INSERT INTO " 
			+ DBContract.TABLE.IOLIST 
			+ " ( ioDate, ioTime, ioBuId,"
			+ " ioPCode, ioQuan, ioPrice, ioTotal)" 
			
			+ " VALUES ( #{ioDate}, #{ioTime}, #{ioBuId},"
			+ " #{ioPCode}, #{ioQuan}, #{ioPrice}, #{ioTotal})" 
			)
	public int insert(IolistDto iolistDto);
	
}
