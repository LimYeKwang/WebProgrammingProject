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

@WebServlet(name = "BasketServlet", urlPatterns = {"/basket"})
public class BasketServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        String memberid = (String)session.getAttribute("user_id");
        int facilityid = Integer.parseInt(request.getParameter("facilityid"));
        int menuid = Integer.parseInt(request.getParameter("menuid"));
        
        BasketVO vo = new BasketVO(memberid, facilityid, menuid);
        ArrayList<BasketVO> list = (ArrayList<BasketVO>)session.getAttribute("basket_item");
        if(list == null){
            list = new ArrayList<BasketVO>();
            list.add(vo);
            session.setAttribute("basket_item",list);
        }else{
            list.add(vo);
            session.setAttribute("basket_item", list);
        }
        
        out.println("<script>");
        out.println("alert('추가가 완료되었습니다.');");
        out.println("history.back();");
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


