
<%@page import="java.util.ArrayList"%>
<%@page pageEncoding="UTF-8"
        language="java" 
        contentType="text/html; charset=UTF-8"
        import = "javax.servlet.http.HttpSession"
        import = "controller.*"
        import = "model.*"
        import = "dao.*"
        %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
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
    if(request.getParameter("language2") != null){
		session.setAttribute("language", request.getParameter("language2"));
	}
	if(session.getAttribute("language") == null){
		session.setAttribute("language", request.getParameter("language"));
	}

%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/buyinfo.css" type="text/css">
    <!--<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>-->
</head>
<body>
    <img src="./img/Lime.png" alt="">
    <main>
		<div id="pull-left">
		<fmt:setLocale value = '<%=session.getAttribute("language") %>'/>
		<fmt:bundle basename = "bundle.message" >
			&nbsp;&emsp;&emsp;&emsp;<a href="?language2=ko">Korean</a>|<a href="?language2=en">English</a>&emsp;&emsp; <br/>&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;
			<a href = 'index.jsp?sessionVal=logout'>Logout</a>
            <div class="title"><%=session.getAttribute("user_school")%><fmt:message key="univ"/><관리자모드><br>
                <div id="main-title"><fmt:message key="title"/></div>
                <div id = "sub-title"><%=session.getAttribute("user_name")%><fmt:message key="message"/></div>
            </div>
            <div onclick="location.href='./addfa.jsp'"><div class = "shopping-bag"><h3><fmt:message key="addStore"/></h3></div></div>
            <div onclick="location.href='./delfa.jsp'"><div class = "buy-info"><h3><fmt:message key="delStore"/></h3></div></div>
            <head>
                <nav>
                <div onclick="location.href='./manage.jsp'"><div class = "select-box"><fmt:message key="restaurant"/></div></div>
                <div onclick="location.href='./manorder.jsp'"><div class = "select-box"><fmt:message key="order"/></div></div>
                </nav>
            </head>
		</div>
		</fmt:bundle>
       

       <div id="pull-right">
            <div class="main-box">
                <div id="right-title">
                    매장 삭제
                </div>
                <br>
                <div id="right-intro"1>
                    매장을 삭제합니다
                </div>

                <div class="item-list">
                    <br><br>
                    
                    <table border="1px solid black;">
                        <tr>
                            <td align="center" style="width: 300px;">매장 이름</td>
                            <td align="center"></td>
                        </tr>
                        <%
                            FacilityDAO dao = new FacilityDAO();
                            ArrayList<FacilityVO> list = dao.ListFacility_manage((String)session.getAttribute("user_id"));
                            for(int i = 0; i<list.size(); i++){
                        %>
                        <tr>
                            <td align="center" style="width: 300px;"><%=list.get(i).getName()%></td>
                            <td align="center"><a href="delfacility?fac_id=<%=list.get(i).getFacilityid()%>">삭제</a></td>
                        </tr>
                        <%}%>
                    </table>
                    

                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

                </div>

            </div>
        </div>

    </main>
	<jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>