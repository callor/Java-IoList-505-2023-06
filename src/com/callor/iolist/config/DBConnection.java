package com.callor.iolist.config;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class DBConnection {
	
	/*
	 * MyBatis 를 통하여 DBMS 에 접속하는 helper class
	 * Middle Ware 라고도 한다.
	 * 
	 * Java -> JDBC -> DBMS
	 * Java -> Mybatis -> JDBC -> DBMS
	 * 
	 * MyBatis 에서 DBMS 에 연결할때 Connection Pool 을 통하여 연결
	 * Connection Pool 은 미리 DBMS 에 연결할 통로(Session)를 만들어 두고
	 * 필요에 따라 통로를 배정받아 SQL Query 를 보내고 데이터를 받는다
	 * 
	 */
	private static SqlSessionFactory sqlSessionFactory;
	
	/*
	 * static block, static 생성자
	 * static 으로 선언된 변수, 객체 등을 초기화 하기 위한 코드를
	 * 작성하는 block
	 */
	static {
		
		/*
		 * 1. Data Source 를 설정 : DBMS 에 Connection 하는 도구
		 * 2. DBMS 에 연결하기 위한 환경 설정
		 * 3. 설정된 환경과 Data Source 등을 연결
		 * 4. Mapper interface (Dao) 를 설정
		 * 5. SessionFactory 만들기
		 */
		
		// PooledDataSource 는
		// 10 개정도의 DB 연결 Connection 을 만들어 pool 에 보관
		DataSource dataSource = new PooledDataSource(
				DBContract.JDBC_DRIVER,
				DBContract.URL,
				DBContract.USER_NAME,
				DBContract.PASSWORD
				);
		
		// DBMS 의 transaction을 자동으로 수행하는 helper Class
		TransactionFactory transactionFactory 
			= new JdbcTransactionFactory();
		
		// DBMS 연결을 위한 환경 설정 만들기
		Environment environment = new Environment("dev", 
				transactionFactory, dataSource);
		
		// DataSource + TransactionFactory + 환경설정 을 묶어서
		// DBMS 연결 초기화 데이터로 만들기
		Configuration configuration = new Configuration(environment);
		
		// Dao 인터페이스(객체)를 Mybatis 에게 알리기
		// Dao 인터페이스가 저장된 package 를 등록한다
		// Dao 인터페이스를 개별적으로 등록 할수도 있지만,
		// 여기에서는 package 를 통째로 등록한다
		configuration.addMappers("com.callor.iolist.persistance");

		// SessionFactory 생성하기
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(configuration);
		
	} // static block end
	public static SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;
	}

}
