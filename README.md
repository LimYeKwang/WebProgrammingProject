# WebProgrammingProject
지능웹 프로그래밍 프로젝트 과제입니다.


1. 이클립스에서 첨부된 파일을 임포트합니다.(zip 파일)
파일 - import - General - Existing Projects into Workspace - Select archive file - browse
-> 내려받은 zip파일 선택 -> Finish

2. 라이브러리가 없어 오류가 발생할경우, 아래의 라이브러리를 WEB-INF -> lib 에 저장해야합니다.
- cos.jar
- jstl-1.2.jar
- mysql-connector-java-5.1.49.jar

3. servlet api파일을 가져옵니다.
프로젝트 오른쪽클릭 -> properties -> Java Build Path -> Libraries -> classPath -> Add External Jars
-> 본인 톰캣 디렉토리의 lib폴더 안에있는 servlet-api.jar 파일 선택 후 저장

4. 첨부되어있는 sql 파일을 실행하여 데이터베이스(테이블)를 구성합니다. (스키마는 미리 생성해두어야함)

5. 데이터베이스 연결 설정을 변경합니다.
Java Resources -> src -> dao -> DAO.java 파일의 connDB() 메소드를 변경(본인으 데이터베이스 주소에 맞도록)

