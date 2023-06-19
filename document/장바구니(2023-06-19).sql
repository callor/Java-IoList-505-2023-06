-- iolist USER 화면

-- 현재 설치된 Oracle DBMS 에 포함된 모든 Table 을 보여달라
SELECT * FROM all_tables;

-- iolist User 가 접근(CRUD 실행)할수 있는 Table 을 보여달라
SELECT * FROM all_tables WHERE OWNER = 'IOLIST';

-- tbl_product TABLE 의 속성(Domain)을 보여달라
-- DBMS 에서 Domain : table 의 속성(칼럼)의 데이터 type 
DESCRIBE tbl_product;

INSERT INTO tbl_buyer ( buid, buname, butel, buaddr)
VALUES('0000000001','홍길동','010-1111-1111','서울특별시');

INSERT INTO tbl_buyer ( buid, buname, butel, buaddr)
VALUES('0000000002','성춘향','010-2222-2222','전라북도 남원시');

INSERT INTO tbl_buyer ( buid, buname, butel, buaddr)
VALUES('0000000003','이몽룡','010-3333-3333','한양시특별시');

INSERT INTO tbl_buyer ( buid, buname, butel, buaddr)
VALUES('0000000004','김춘향','010-4444-4444','함경도 함흥');

INSERT INTO tbl_buyer ( buid, buname, butel, buaddr)
VALUES('0000000005','이길용','010-5555-5555','광주광역시');

COMMIT ;
SELECT * FROM tbl_buyer;

-- PK 를 기준으로 조회(SELECT)하면 결과는 1개 이거나 null 이다
SELECT * FROM tbl_buyer WHERE buid = '0000000001';
SELECT * FROM tbl_buyer WHERE buid = '0000000007';

-- PK 이외의 칼럼을 기준으로 조회하면 비록 1개의 결과만 보일지라도
-- 이 결과는 1개 이상인 것으로 본다.
-- 이 결과는 empty 이거나 1개 이상이다
SELECT * FROM tbl_buyer WHERE buName = '홍길동';

/* 
중간문자열 검색
Full Text Search : 칼럼의 데이터의 문자열을 모두 검색하여 일치하는 데이터 찾기
SELECT 조회 명령 실행 과정에서 가장 느린 Query

칼럼의 데이터 중에 일부라도 일치하는 문자열이 있는 데이터 조회하기
*/
-- 이름 중간 문자열 검색
-- 홍 이라는 문자열로 시작되는 모든 이름
-- 첫글자가 홍 인 이름들
SELECT * FROM tbl_buyer WHERE buName LIKE '홍%';

-- 향 이라는 문자열로 끝나는 모든 이름
-- 끝 글자가 향 인 이름들
SELECT * FROM tbl_buyer WHERE buName LIKE '%향';

-- 길 이라는 문자열이 포함된 모든 이름
-- 시작글자, 끝글자, 중간글자 상관없이 길 이라는 문자열이 포함된 모든 이름
SELECT * FROM tbl_buyer WHERE buName LIKE '%길%' ;

-- 연결된 문자열 생성하기
SELECT '강' || '가' || '딘' FROM dual;

/*
표준 SQL 에서는 아주 단순한 연산을 수행하는 SELECT 문을 지원한다
숫자의 4칙연산, 문자열 연결하기 등 간단히 SELECT 명령을 통하여
결과를 확인할 수 있다.

그런데, Oracle 에서는 FROM(FROM 절) 키워드가 생략된 SELECT 명령을
허용하지 않는다.
그래서 의미없는 DUMMY Table 을 하나 마련해 두었다
Oracle 에서 단순 연산을 위한 SELECT 에서는 dual table 을 사용하여 수행한다
*/
SELECT 30 + 40; -- 표준 SQL 문법
SELECT * FROM dual;
SELECT 30 + 40 FROM dual;

SELECT 30 + 40 FROM tbl_buyer;

-- 문자열 연결 : '||'  을 사용하여 연결
SELECT '강' || '가' || '딘' FROM dual;

-- 사칙연산
SELECT 30 + 40 FROM dual;
SELECT 30 - 40 FROM dual;
SELECT 30 * 40 FROM dual;
SELECT 30 / 40 FROM dual;

-- 연산
SELECT 30 + 40 + 50 + 60 FROM dual;

-- 함수를 사용한 연산
-- 테이블에 데이터가 몇개 있느냐?
SELECT COUNT(*) FROM tbl_buyer;

-- 이름에 길 문자열이 포함된 고객이 몇명이냐
SELECT COUNT(*) FROM tbl_buyer WHERE buName LIKE '%길%' ;

-- 현재 저장된 데이터 중에서 가장 큰 buid 값은 얼마냐
SELECT MAX(buid) FROM tbl_buyer;

-- 현재 저장된 데이터 중에서 가장 작은 buid 값은 얼마냐
SELECT MIN(buid) FROM tbl_buyer;












