# DataBase 연동 프로젝트

## DataBase Table 의 구분
- Master Table, Work Table 의 구분
- `Master Data` : 어플리케이션을 사용하는 초기에 대량의 데이터를 추가하고, 운영하는 과정에서는 주로 조회(SELECT)를 수행하는 데이터
- `Work Data` : 어플리케이션을 (계속)운영하는 과정에서 수시로 데이터의 INSERT가 이루어지는 데이터

- Master Data 를 보관하는 Table 을 Master Table 이라고 한다.
- Work Data 를 보관하는 Table 을 Work Table 또는 Slave Table 이라고 한다.

## Entity 와 Relation 의 구분
- 주로 Master Data 에 해당하는 부분을 Entity 라고 한다.
- Work Data 에 해당하는 부분은 주로 Relation 이라고 한다.
- Work Data 는 Master Data 인 Entity 와 항상 연동되는 데이터이다