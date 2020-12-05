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

import dao.ReviewDAO;
import model.*;

@WebServlet(name = "AddReviewServlet", urlPatterns = {"/addre"})
public class AddReivewServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        ReviewDAO dao = new ReviewDAO();
        ReviewVO vo = new ReviewVO();
        
        int facilityid = Integer.parseInt(request.getParameter("facilityid"));
        String user_id = (String)session.getAttribute("user_id");
        String text = request.getParameter("text");
        int score = Integer.parseInt(request.getParameter("score"));
        
        vo.setText(text);
        vo.setFacilityid(facilityid);
        vo.setId(user_id);
        vo.setScore(score);

        dao.AddReview(vo);
        
        
        out.println("<script>");
        out.println("alert('리뷰가 성공적으로 반영되었습니다.');");
        out.println("location.href='./restaurant.jsp'");
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


