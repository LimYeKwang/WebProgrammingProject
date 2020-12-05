package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        
        MemberVO vo = new MemberVO();
        MemberDAO dao = new MemberDAO();
        String id = request.getParameter("id");
        String pwd = request.getParameter("password");
        vo = dao.FindMember(id);
        
        if(vo == null){
            out.println("<script>");
            out.println("alert('존재하지 않는 아이디입니다.');");
            out.println("location.href='./index.jsp'");
            out.println("</script>");
        }else if(!pwd.equals(vo.getPassword())){
            System.out.println(pwd);
            System.out.println(vo.getPassword());
            out.println("<script>");
            out.println("alert('비밀번호를 잘못입력하셨습니다.');");
            out.println("location.href='./index.jsp'");
            out.println("</script>");
        }else{
            session.setAttribute("user_id", vo.getId());
            session.setAttribute("user_pw", vo.getPassword());
            session.setAttribute("user_name", vo.getName());
            session.setAttribute("user_phone", vo.getPhone());
            session.setAttribute("user_right", vo.getRight());
            session.setAttribute("user_school", vo.getSchool());
            response.sendRedirect("restaurant.jsp");
        }
        
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
