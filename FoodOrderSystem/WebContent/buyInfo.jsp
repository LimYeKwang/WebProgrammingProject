
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
    MenuDAO dao = new MenuDAO();
    FacilityDAO facilitydao = new FacilityDAO();
    OrderDAO orderdao = new OrderDAO();
    ArrayList<OrderVO> list = orderdao.ListOrder((String)session.getAttribute("user_id"));
    if(list == null){
        list = new ArrayList<OrderVO>();
    }
    int count = 0;
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
		<jsp:include page="pull_left.jsp"></jsp:include>
        <div id="pull-right">
            <div class="main-box">
                <div id="right-title">
                    주문 정보
                </div>
                <br>
                <div class="item-list">
                    <%
                        for(int i = 0; i<list.size();i++){
                            if(list.get(i).getEnd() == 0){
                                count++;
                                continue;
                            }
                            MenuVO menuvo = dao.FindMenu(list.get(i).getMenuid());
                            FacilityVO facilityvo = facilitydao.FindFacility(menuvo.getFacilityid());
                    %>
                    <div class="item-item">
                        <div class="item-title">
                            매장명: <%=facilityvo.getName()%> 상품명: <%=menuvo.getName()%>
                        </div>
                        <div class="item-img" style="background-image: url('./img/menu/<%=menuvo.getName()%>.jpg')"></div>
                        <div class="item-date">
                            주문일시: <%=list.get(i).getDate()%>
                        </div>
                        <div class="item-todate">
                            예약시간: <%=list.get(i).getTodate()%>
                        </div>
                        <form action="delor" method="GET">
                            <input type="hidden" name="orderid" value="<%=list.get(i).getId()%>">
                            <input type="submit" name="" value="주문취소">
                        </form>
                    </div>
                            <%
                                }
                            %>
                    

                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                </div>
                <div id="right-intro">
                    상품 수:<%=list.size()-count%>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>

            </div>
        </div>

            </div>
        </div>

    </main>
	<jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>