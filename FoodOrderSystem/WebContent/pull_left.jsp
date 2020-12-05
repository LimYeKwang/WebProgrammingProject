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
<fmt:setLocale value = '<%=session.getAttribute("language") %>'/>
<fmt:bundle basename = "bundle.message" >
<div id="pull-left">
			&nbsp;&emsp;&emsp;&emsp;<a href="?language2=ko">Korean</a>|<a href="?language2=en">English</a>&emsp;&emsp; <br/>&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;
			<a href = 'index.jsp?sessionVal=logout'>Logout</a>
            <div class="title"><%=session.getAttribute("user_school")%> <fmt:message key="univ"/><br>
                <div id="main-title"><fmt:message key="title"/></div>
                <div id = "sub-title"><%=session.getAttribute("user_name")%> <fmt:message key="message"/></div>
            </div>
            <div onclick="location.href='./basket.jsp'"><div class = "shopping-bag"><h3><fmt:message key="shoppingBag"/></h3></div></div>
            <div onclick="location.href='./buyInfo.jsp'"><div class = "buy-info"><h3><fmt:message key="buyinfo"/></h3></div></div>
            <head>
                <nav>
                <div onclick="location.href='./restaurant.jsp'"><div class = "select-box"><fmt:message key="restaurant"/></div></div>
                <div onclick="location.href='./cafe.jsp'"><div class = "select-box"><fmt:message key="cafe"/></div></div>
                </nav>
            </head>
</div>
</fmt:bundle>	