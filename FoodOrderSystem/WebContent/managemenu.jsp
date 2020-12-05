
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
    <link rel="stylesheet" href="./css/buyinfo.css" type="text/css">
    <!--<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>-->
</head>
<body>
    <img src="./img/Lime.png" alt="">
    <main>
        <jsp:include page="pull_left_manager.jsp"></jsp:include>
              <div id="pull-right">
            <div class="main-box">
                <div id="right-title">
                    메뉴 추가
                </div>
                <br>
                <div id="right-intro"1>
                    추가할 메뉴 정보를 입력하시오
                </div>

                <div class="item-list">
                    <br><br>
                    <form action="addmenu" method="post" enctype="multipart/form-data">
                        메뉴 이름: <input type="text" name="menu_name"><br><br><br>
                        메뉴 소개: <input type="text" name="menu_intro"><br><br><br>
                        메뉴 가격: <input type="text" name="menu_price"><br><br><br>
                        <input type="file" name="menu_image"><br><br><br>
                        <input type="submit" value="추가하기">
                    </form>
                    
                    <br><br><br>
                    <h2>메뉴 목록</h2><br>
                    <table border="1px solid black;">
                        <tr>
                            <td align="center" style="width: 300px;">메뉴 이름</td>
                            <td align="center"></td>
                        </tr>
                        <%
                            MenuDAO dao = new MenuDAO();
                            int facilityid = (int)session.getAttribute("facilityid");
                            ArrayList<MenuVO> list = dao.ListMenu(facilityid);
                            for(int i = 0; i<list.size();i++){   
                            %>
                        <tr>
                            <td align="center" style="width: 300px;"><%=list.get(i).getName()%></td>
                            <td align="center"><a href="delmenu?menuid=<%=list.get(i).getMenuid()%>">삭제</a></td>
                        </tr>
                        
                        <%
                            }
                        %>
                    </table>
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

                </div>
                

            </div>
        </div>
                    
                    

                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

                </div>

            </div>
        </div>

    </main>
	<jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>