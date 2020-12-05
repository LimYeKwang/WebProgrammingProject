
<%@page import="java.util.ArrayList"%>
<%@page pageEncoding="UTF-8"
        language="java" 
        contentType="text/html; charset=UTF-8"
        %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/main.css" type="text/css">
    <!--<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>-->
    <style>
h1, p{
	position: absolute;
	left: 150px;
}

</style>
</head>
<body>
    <img src="./img/Lime.png" alt="">
    <main>
        <div id="pull-right">
            <div class="main-box">
            <br/><br/><br/><br/><br/><br/><br/><br/>
				<h1>요청하신 페이지를 찾을 수 없습니다</h1><br/><br/><br/>
				<p><a href = "index.jsp">메인으로</a>
            </div>
        </div>

    </main>
	<jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>