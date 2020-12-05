<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	if(request.getParameter("language2") != null){
		session.setAttribute("language", request.getParameter("language2"));
	}
	if(session.getAttribute("language") == null){
		session.setAttribute("language", request.getParameter("language"));
	}
%>
<div id="pull-left">
<fmt:setLocale value = '<%=session.getAttribute("language") %>'/>
<fmt:bundle basename = "bundle.message" >
			&nbsp;&emsp;&emsp;&emsp;<a href="?language2=ko">Korean</a>|<a href="?language2=en">English</a>&emsp;&emsp; <br/>&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;
			<a href = 'index.jsp?sessionVal=logout'>Logout</a>
            <div class="title"><%=session.getAttribute("user_school")%><fmt:message key="univ"/><관리자모드><br>
                <div id="main-title"><fmt:message key="title"/></div>
                <div id = "sub-title"><%=session.getAttribute("user_name")%><fmt:message key="message"/></div>
            </div>
            <div onclick="location.href='./managemenu.jsp'"><div class = "shopping-bag"><h3><fmt:message key="menuManage"/></h3></div></div>
            <head>
                <nav>
                <div onclick="location.href='./manage.jsp'"><div class = "select-box"><fmt:message key="restaurant"/></div></div>
                <div onclick="location.href='./manorder.jsp'"><div class = "select-box"><fmt:message key="order"/></div></div>
                </nav>
            </head>
</div>
</fmt:bundle>