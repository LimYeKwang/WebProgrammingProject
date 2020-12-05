<%-- 
    Document   : main
    Created on : 2020. 8. 8., 오전 12:16:10
    Author     : Lim
--%>
<%@page pageEncoding="UTF-8"
        language="java" 
        contentType="text/html; charset=UTF-8"
        %>
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset='utf-8'");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/register.css" type="text/css">
    <script type="text/javascript" src="./js/validation.js"></script>
</head>
<body>
    <head>
        <nav>

        </nav>
    </head>

    <main>
        <div id="pull-left">
            <div class="title">Welcome to<br><div id="main-title">미음</div></div>
        </div>
        <img src="./img/Lime.png">
        <div id="pull-right">
            <div class="login-box">
                <form name = "register" action="register" method="POST">
                    <div id="login-title">Register</div><br>
                    <input type="text" name="id" id = "id"placeholder="아이디"><br>
                    <input type="password" name="password" id = "password" placeholder="비밀번호"><br>
                    <input type="text" name="name" id = "name" placeholder="이름">
                    <input type="text" name="phone" id = "phone" placeholder="전화번호"><br>
                    <br>
                    <select name="school" id="" >
                        <optgroup label="학교 선택">학교 선택</optgroup>
                        <option value="kyonggi">경기대학교</option>
                    </select>
                    <select name="right" id="">
                        <optgroup label="유형">유형</optgroup>
                        <option value="2">매점 관리자</option>
                        <option value="1">학생</option>
                    </select>
                    <br>
                    <input type="button" onclick="CheckRegister()" value="회원가입">
                    <a href="index.jsp"><input type="button" value="뒤로가기"></a>
                </form>
                
            </div>
        </div>

        <div id="image"></div>
    </main>
	<jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>
