
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
    FacilityDAO dao = new FacilityDAO();
    MenuDAO dao2 = new MenuDAO();
    FacilityVO vo;
    if(request.getParameter("facility_id") == null)
    	vo = dao.FindFacility(Integer.parseInt((String)session.getAttribute("facility_id")));
    else{
    	vo = dao.FindFacility(Integer.parseInt(request.getParameter("facility_id")));
    	session.setAttribute("facility_id",request.getParameter("facility_id"));
    }
    ArrayList<MenuVO> list = dao2.ListMenu(vo.getFacilityid());
%>

<!DOCTYPE html>
<html lang="ko">
<head>
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/select.css" type="text/css">
    <!--<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
</head>
<body>
    <img src="./img/Lime.png" alt="">
    <main>
	<jsp:include page="pull_left.jsp"></jsp:include>
       

        <div id="pull-right">
            
            <div class="main-box">
                
                <div id="right-title">
                    <%=vo.getName()%>에 오신것을 환영합니다.
                </div>
                <div id="right-intro">
                    소개: <%=vo.getIntro()%>
                </div>
                
                <div class="item-list">
                    
                <%
                    for(int i = 0; i<list.size();i++){
                        
                    
                %>
                    <div class="item-item">
                        <div class="item-title">
                            이름: <%=list.get(i).getName()%>
                        </div>
                        <div class="item-img" style="background-image: url('./img/menu/<%=list.get(i).getName()%>.jpg')"></div>
                        <div class="item-price">
                            가격: <%=list.get(i).getPrice()%>
                        </div>
                        <div class="item-intro">
                            설명: <%=list.get(i).getIntro()%>
                        </div>
                        <form action="basket" method="GET">
                            <input type="submit" name="" value="장바구니에 담기">
                            <input type="hidden" name="menuid" value="<%=list.get(i).getMenuid()%>">
                            <input type="hidden" name="facilityid" value="<%=vo.getFacilityid()%>">
                        </form>
                    </div>
                    <%
                      }
                    %>

                    <div class="review-edit">
                        Review
                    </div>
                    
                    <div class="review-list">
                        <table border="1px solid black">

                        <tr>
                            <td align="center" style="width: 30px;">번호</td>
                            <td align="center" style="width: 100px;">작성자</td>
                            <td align="center" style="width: 400px;">내용</td>
                            <td align="center">별점</td>
                        </tr>
                        <%
                            ReviewDAO reviewdao = new ReviewDAO();
                            ArrayList<ReviewVO> reviewvo = reviewdao.ListReview(vo.getFacilityid());
                            for(int i = 0; i< reviewvo.size();i++)
                            {
                        %>
                        <tr>
                            <td align="center" style="width: 30px;"><%=i%></td>
                            <td align="center" style="width: 100px;"><%=reviewvo.get(i).getId()%></td>
                            <td align="center" style="width: 400px;"><%=reviewvo.get(i).getText()%></td>
                            <td align="center"><%=reviewvo.get(i).getScore()%></td>
                        </tr>
                        <%
                            }
                        %>
                        </table>
                        
                        <form action="addre">
                            <br>Review 작성하기<br>
                            <textarea name="text" id="" cols="50" rows="5"></textarea>
                            별점:
                            <select name="score" id="">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                            <input type="hidden" name ="facilityid"value="<%=vo.getFacilityid()%>">
                            <input type="submit" value="작성하기">
                            
                        </form>
                    </div>
                    
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

                </div>

            </div>
        </div>

    </main>
	<jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>