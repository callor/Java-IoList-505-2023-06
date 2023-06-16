-- Iolist DBA 화면
/*
Project 에 필요한 TABLE 을 생성하고
SEQUENCE 등을 생성한다

CRUD 코드를 테스트 한다
*/

-- 상품정보 테이블 생성
CREATE TABLE tbl_product (
    pCode	VARCHAR2(13)		PRIMARY KEY,
    pName	nVARCHAR2(50)	NOT NULL,	
    pItem	nVARCHAR2(10)	NOT NULL,	
    pIPrice	NUMBER,		
    pOPrice	NUMBER		
);

-- 거래처 정보 테이블 생성
CREATE TABLE tbl_buyer (
    buId	VARCHAR2(10)		PRIMARY KEY,
    buName	nVARCHAR2(20)	NOT NULL,	
    buTel	VARCHAR2(15)	NOT NULL,	
    buAddr	nVARCHAR2(125)		
);

-- 판매내역 Table 에서 사용할 SEQUENCE 객체 생성하기
-- 일련번호를 자동으로 생성하기 위한 객체

/*
1 부터 1씩 자동으로 증가하는 일련번호를 만들겠다
*/
CREATE SEQUENCE seq_iolist 
START WITH 1 INCREMENT BY 1;

-- 판매내역 테이블 생성
CREATE TABLE tbl_iolist (
    ioSEQ	NUMBER		PRIMARY KEY,
    ioDate	VARCHAR2(10)	NOT NULL,	
    ioTime	VARCHAR2(10)	NOT NULL,	
    ioBuId	VARCHAR2(10)	NOT NULL,	
    ioPCode	VARCHAR2(13)	NOT NULL,	
    ioQuan	NUMBER	NOT NULL,	
    ioPrice	NUMBER	NOT NULL,	
    ioTotal	NUMBER		
);

/*
tbl_iolist 에 데이터를 추가(INSERT)할때 ioSEQ 칼럼에 자동 증가된 값을
추가하기 위하여 항상 seq_iolist.NEXTVAL 이라는 코드를 입력해야 한다
간혹 실수로 해당 코드를 생략하면 INSERT 명령에서 오류가 발생한다.
테이블 생성할때 DEFAULT 옵션을 설정하여 자동으로 실행되도록 하여보자
*/
INSERT INTO tbl_iolist(ioSEQ) VALUES( seq_iolist.NEXTVAL);

-- ioSEQ DEFAULT 설정하기 위하여 DROP 후 CREATE 실행
DROP TABLE tbl_iolist;

/*
Table 생성할때 ioSEQ 칼럼을 다음과 같이 설정
    ioSEQ	NUMBER	DEFAULT seq_iolist.NEXTVAL PRIMARY KEY ,
    
    tbl_iolist 테이블에 INSERT 를 실행할때마다 자동으로 
    seq_iolist.NEXTVAL 코드가 실행될 것이다
*/
CREATE TABLE tbl_iolist (
    ioSEQ	NUMBER	DEFAULT seq_iolist.NEXTVAL PRIMARY KEY ,
    ioDate	VARCHAR2(10)	NOT NULL,	
    ioTime	VARCHAR2(10)	NOT NULL,	
    ioBuId	VARCHAR2(10)	NOT NULL,	
    ioPCode	VARCHAR2(13)	NOT NULL,	
    ioQuan	NUMBER	NOT NULL,	
    ioPrice	NUMBER	NOT NULL,	
    ioTotal	NUMBER		
);

INSERT INTO tbl_iolist (ioDate, ioTime, ioBuID, ioPCode, ioQuan, ioPrice )
VALUES('2023-06-16','11:32:00','0000000001','8801000000022',10,120000);
SELECT * FROM tbl_iolist;




