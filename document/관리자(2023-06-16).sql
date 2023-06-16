-- Iolist 관리자 화면

/*
iolist 라는 TABLESPACE(저장소) 를 생성
실제 저장되는 파일은 iolist.dbf 이다
처음 시작하는 크기는 1M(byte) 이고
용량이 부족할 경우 자동으로 확장하는데 1K(Byte) 단위로 확장
*/
CREATE TABLESPACE iolist
DATAFILE 'C:/app/data/iolist.dbf'
SIZE 1M AUTOEXTEND ON NEXT 1K;

/*
oracle 12c 이상에서 사용자에 대한 권한정책이 변경되었다

사용자 ID : C## 이라는 prefix 를 기본적으로 사용해야하고
system 과 관련된 몇가지 사항을 기본으로 접근하지 못하도록 하고 있다

사용자 ID, TABLEPSACE 접근 권한을 12c 이전 정책으로 되돌리는 설정

CREATE USER C##iolist IDENTIFIED BY 12341234
DEFAULT TABLESPACE iolist;

이 설정은 사용자를 만드는 경우 항상 실행해 주어야 한다
*/
ALTER SESSION SET "_ORACLE_SCRIPT" = true;


/*
새로운 사용자(SCHEME)를 생성하고
접속 비번을 12341234 로 설정하라
이 사용자 정보를 통해서 접근할수 있는 저장소는 iolist 이다
*/
CREATE USER iolist IDENTIFIED BY 12341234
DEFAULT TABLESPACE iolist;

/*
생성한 iolist 사용자가
DB에 접속하고, TABLE을 생성하고, CRUD 를 실행하는 부분
각각 별도의 권한 정책에 의하여 허가를 해주야 한다
학습 목적상 세세한 권한 정책을 부여하기가 불편하여

Oralce 의 SYSDBA(SYSTEM) 권한보다 한단계 낮은 DBA 권한을 부여한다

DBA 권한은 Oralce DBMS System 설정을 변경하는 것 외에
대부분의 권한을 갖는다

*/
GRANT DBA TO iolist;



