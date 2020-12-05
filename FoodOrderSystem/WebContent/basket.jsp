
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
    FacilityDAO fdao = new FacilityDAO();
    ArrayList<BasketVO> list = (ArrayList<BasketVO>)session.getAttribute("basket_item");
    System.out.println((ArrayList<BasketVO>)session.getAttribute("basket_item"));
    if(list == null){
        list = new ArrayList<BasketVO>();
    }
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/basket.css" type="text/css">
    <!--<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>-->
</head>
<body>
    <img src="./img/Lime.png" alt="">
    <main>
		<jsp:include page="pull_left.jsp"></jsp:include>
        <div id="pull-right">
            <div class="main-box">
                <div id="right-title">
                    장바구니
                </div>
                <br>
                <div id="right-intro">
                    상품 수:<%=list.size()%>
                    <%
                        int price = 0;
                        for(int i = 0;i<list.size();i++){
                            int menuid = list.get(i).getMenuid();
                            MenuVO vo = dao.FindMenu(menuid);
                            price += vo.getPrice();
                        }
                    %>
                    
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    총 가격:<%=price%>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>

                <div class="buy-button">
                    <form action="buy">
                        요청시간:
                        <select name="hour">
                            <option value="1">1</option><option value="2">2</option><option value="3">3</option>
                            <option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option>
                            <option value="8">8</option><option value="9">9</option><option value="10">10</option>
                            <option value="11">11</option><option value="12">12</option><option value="13">13</option>
                            <option value="14">14</option><option value="15">15</option><option value="16">16</option>
                            <option value="17">17</option><option value="18">18</option><option value="19">19</option>
                            <option value="20">20</option><option value="21">21</option><option value="22">22</option>
                            <option value="23">23</option><option value="24">24</option>
                        </select>
                        시
                        <select name="minute">
                            <option value="0">00</option>
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                            <option value="50">50</option>
                        </select>
                        분
                        <input type="submit" value="주문하기">
                    </form>
                </div>

                <div class="item-list">
                    
                    <%
                        for(int i = 0; i<list.size();i++){
                            int fac = list.get(i).getFacilityid();
                            int men = list.get(i).getMenuid();
                            MenuVO vo = dao.FindMenu(men);
                            FacilityVO fvo = fdao.FindFacility(fac);
                    %>
                    <div class="item-item">
                        <div class="item-title">
                            매장명: <%=fvo.getName()%> 상품명: <%=vo.getName()%>
                        </div>
                        <div class="item-img" style="background-image: url('./img/menu/<%=vo.getName()%>.jpg')"></div>
                        <div class="item-price">
                            가격: <%=vo.getPrice()%>원
                        </div>
                        <div class="item-intro">
                            설명:<%=vo.getIntro()%>
                        </div>
                        <form action="basdel" method="GET">
                            <input type="hidden" name="menuid" value="<%=vo.getMenuid()%>">
                            <input type="submit" name="" value="삭제">
                        </form>
                    </div>
                    
                    <%
                        }
                    %>

                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

                </div>

            </div>
        </div>

    </main>
	<jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>