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

import dao.FacilityDAO;
import model.*;

@WebServlet(name = "DelFacilityServlet", urlPatterns = {"/delfacility"})
public class DelFacilityServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        FacilityDAO dao = new FacilityDAO();
        
        int facilityid = Integer.parseInt(request.getParameter("fac_id"));
        dao.DelFacility(facilityid);
        
        
        out.println("<script>");
        out.println("alert('매장 삭제가 성공적으로 반영되었습니다.');");
        out.println("location.href='./manage.jsp'");
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


