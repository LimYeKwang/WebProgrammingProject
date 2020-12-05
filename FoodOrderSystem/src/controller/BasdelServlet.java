package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

@WebServlet(name = "BasdelServlet", urlPatterns = {"/basdel"})
public class BasdelServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        int menuid = Integer.parseInt(request.getParameter("menuid"));
        ArrayList<BasketVO> list = (ArrayList<BasketVO>)session.getAttribute("basket_item");
        for(int i = 0; i<list.size();i++){
            if(list.get(i).getMenuid() == menuid){
                list.remove(i);
                session.setAttribute("basket_item", list);
                break;
            }
        }
        
        out.println("<script>");
        out.println("alert('삭제가 완료되었습니다.');");
        out.println("location.href='./basket.jsp'");
        out.println("</script>");
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}


