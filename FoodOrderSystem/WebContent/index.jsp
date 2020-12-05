<%-- 
    Document   : index
    Created on : 2020. 8. 8., 오전 12:57:29
    Author     : Lim
--%>

<%@page pageEncoding="UTF-8"
        language="java" 
        contentType="text/html; charset=UTF-8"
        %>
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset='utf-8'");
    if(request.getParameter("sessionVal") != null){
    	if(request.getParameter("sessionVal").equals("logout")){
    		request.removeAttribute("sessionVal");
       	 	out.println("<script>");
      		out.println("alert('로그아웃 되었습니다. 다시 로그인하십시오')");
      		out.println("</script>");	
    	}
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/Login.css" type="text/css">
    <!--<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>-->
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
                <form action="login" method="POST" id="login">
                    <div id="login-title">Login</div><br>
                    <input type="text" name="id" placeholder="아이디"><br>
                    <input type="password" name="password" placeholder="비밀번호"><br>
                    <input type="submit" value="로그인">
                    <a href="register.jsp"><input type="button" value="회원가입"></a>
                </form>
                
            </div>
        </div>

    </main>
    <jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>
