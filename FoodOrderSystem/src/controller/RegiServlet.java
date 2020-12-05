package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.*;

@WebServlet(name = "RegiServlet", urlPatterns = {"/register"})
public class RegiServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        MemberDAO dao = new MemberDAO();
        String id = request.getParameter("id");
        String pwd = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String school = request.getParameter("school");
        int right = Integer.parseInt(request.getParameter("right"));
        MemberVO vo = new MemberVO(id, pwd, name, school,phone, right);
        
        if(id.equals("") || id.length() == 0 ||pwd.equals("") || pwd.length() == 0 ||phone.equals("") || phone.length() == 0){
            out.println("<script>");
            out.println("alert('존재하지 않는 아이디입니다.');");
            out.println("history.back();");
            out.println("</script>");
        }else{
            dao.AddMember(vo);
            RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
            dis.forward(request, response);
        }
        vo = dao.FindMember(id);
        
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
