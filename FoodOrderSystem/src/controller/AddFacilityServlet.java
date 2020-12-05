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

@WebServlet(name = "AddFacilityServlet", urlPatterns = {"/addfacility"})
public class AddFacilityServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        FacilityDAO dao = new FacilityDAO();
        
        String managerid = (String)session.getAttribute("user_id");
        String name = request.getParameter("fac_name");
        String intro = request.getParameter("fac_intro");
        int sort = Integer.parseInt(request.getParameter("fac_sort"));
        String school = (String)session.getAttribute("user_school");
        FacilityVO vo = new FacilityVO();
        vo.setManagerid(managerid);
        vo.setName(name);
        vo.setIntro(intro);
        vo.setSort(sort);
        vo.setSchool(school);
        
        dao.AddFacility(vo);
        out.println("<script>");
        out.println("alert('매장 추가가 성공적으로 반영되었습니다.');");
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


