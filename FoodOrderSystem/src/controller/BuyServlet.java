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

import dao.MenuDAO;
import dao.OrderDAO;
import model.*;
import java.util.*;
import java.text.*;

@WebServlet(name = "BuyServlet", urlPatterns = {"/buy"})
public class BuyServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        MenuDAO menudao = new MenuDAO();
        int hour = Integer.parseInt(request.getParameter("hour"));
        int minute = Integer.parseInt(request.getParameter("minute"));
        Date dt= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String time2 = sdf.format(dt);
        OrderDAO orderdao = new OrderDAO();
        
        ArrayList<BasketVO> list = (ArrayList<BasketVO>)session.getAttribute("basket_item");
        for(int i=0; i<list.size();i++){
            String memberid = list.get(i).getMemberid();
            int facilityid = list.get(i).getFacilityid();
            int menuid = list.get(i).getMenuid();
            MenuVO menuvo = menudao.FindMenu(menuid);
            int price = menuvo.getPrice();
            String todate = time2 + hour + ":" + minute + ":" + "00";
            int end = 1;
            OrderVO ordervo = new OrderVO();
            ordervo.setMemberid(memberid);
            ordervo.setFacilityid(facilityid);
            ordervo.setMenuid(menuid);
            ordervo.setPrice(price);
            ordervo.setTodate(todate);
            ordervo.setEnd(end);
            orderdao.AddOrder(ordervo);
        }
        session.setAttribute("basket_item", new ArrayList<BasketVO>());
        out.println("<script>");
        out.println("alert('주문이 완료되었습니다.');");
        out.println("location.href='./buyInfo.jsp'");
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


