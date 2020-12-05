
<%@page import="java.util.ArrayList"%>
<%@page pageEncoding="UTF-8"
        language="java" 
        contentType="text/html; charset=UTF-8"
        import = "javax.servlet.http.HttpSession"
        import = "controller.*"
        import = "model.*"
        import = "dao.*"
        %>
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset='utf-8'");
    session = request.getSession();
    if(session.isNew()){
        out.println("<script>");
        out.println("alert('세션이 종료되었습니다. 다시 로그인하십시오')");
        out.println("location.href='./index.jsp'");
        out.println("</script>");
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/main.css" type="text/css">
    <!--<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>-->
</head>
<body>
    <img src="./img/Lime.png" alt="">
    <main>
		<jsp:include page="pull_left.jsp"></jsp:include>
        <div id="pull-right">
            <div class="main-box">
                <%
                    FacilityDAO dao = new FacilityDAO();
                    ArrayList<FacilityVO> list = dao.ListFacility((String)session.getAttribute("user_school"),2);
                    for(int i = 0; i<list.size();i++){
                %>
                <div class="store-box">
                    <div id = "store-name"><%=list.get(i).getName()%></div>
                    <form action="./selected.jsp" method="POST">
                        <input type="submit" value="선택하기">
                        <input type="hidden" name="facility_id" value="<%=list.get(i).getFacilityid()%>">
                    </form>
                </div>
                <%
                    }
                %>
                <div class="store-box" style="background-color:gray">
                    <div id = "store-name">미등록</div>
                    <form action="./selected.jsp" method="POST">
                        <input type="button" value="선택불가">
                    </form>
                </div>
                
                <div class="store-box" style="background-color:gray">
                    <div id = "store-name">미등록</div>
                    <form action="./selected.jsp" method="POST">
                        <input type="button" value="선택불가">
                    </form>
                </div>
                
                <div class="store-box" style="background-color:gray">
                    <div id = "store-name">미등록</div>
                    <form action="./selected.jsp" method="POST">
                        <input type="button" value="선택불가">
                    </form>
                </div>
                
                <div class="store-box" style="background-color:gray">
                    <div id = "store-name">미등록</div>
                    <form action="./selected.jsp" method="POST">
                        <input type="button" value="선택불가">
                    </form>
                </div>
                
                <div class="store-box" style="background-color:gray">
                    <div id = "store-name">미등록</div>
                    <form action="./selected.jsp" method="POST">
                        <input type="button" value="선택불가">
                    </form>
                </div>
                
                <div class="store-box" style="background-color:gray">
                    <div id = "store-name">미등록</div>
                    <form action="./selected.jsp" method="POST">
                        <input type="button" value="선택불가">
                    </form>
                </div>

            </div>
        </div>

    </main>
	<jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>