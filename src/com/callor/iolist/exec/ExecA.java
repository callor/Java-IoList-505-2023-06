package com.callor.iolist.exec;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.callor.iolist.config.DBConnection;
import com.callor.iolist.models.BuyerDto;
import com.callor.iolist.persistance.BuyerDao;

public class ExecA {
	
	public static void main(String[] args) {
		
		// SqlSession 을 자동으로 생성할 객체 가져오기
		SqlSessionFactory sessionFactory = DBConnection.getSessionFactory();
		
		// SqlSession 정보 추출하기
		// openSession(true) : true 를 설정하면 자동으로 COMMIT 이 일어난다
		SqlSession sqlSession =  sessionFactory.openSession(true);
		
		// mybatis 야 BuyerDao interface 를 참조하여
		// Query 를 실행할 method 를 만들어달라 
		BuyerDao buyerDao = sqlSession.getMapper(BuyerDao.class);
		
		List<BuyerDto> buyerList = buyerDao.selectAll();
//		System.out.println(buyerList.toString());
		for(BuyerDto dto : buyerList) {
			System.out.println(dto.toString());
		}
		
	}

}
