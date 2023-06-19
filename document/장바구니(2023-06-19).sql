-- iolist USER 화면

-- 현재 설치된 Oracle DBMS 에 포함된 모든 Table 을 보여달라
SELECT * FROM all_tables;

-- iolist User 가 접근(CRUD 실행)할수 있는 Table 을 보여달라
SELECT * FROM all_tables WHERE OWNER = 'IOLIST';

-- tbl_product TABLE 의 속성(Domain)을 보여달라
-- DBMS 에서 Domain : table 의 속성(칼럼)의 데이터 type 
DESCRIBE tbl_product;

/* 
중간문자열 검색
Full Text Search : 칼럼의 데이터의 문자열을 모두 검색하여 일치하는 데이터 찾기
SELECT 조회 명령 실행 과정에서 가장 느린 Query

*/





