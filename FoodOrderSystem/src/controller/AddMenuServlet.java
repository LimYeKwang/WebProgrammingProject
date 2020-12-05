package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MenuDAO;
import model.*;

@WebServlet(name = "AddMenuServlet", urlPatterns = {"/addmenu"})
public class AddMenuServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		
        String filename = "";
        //String realFolder = "./WebContent/img";
		String realFolder = "/Users/im-yegwang/eclipse-workspace/FoodOrderSystem/WebContent/img/menu";
		//String realFolder=request.getRealPath("image/menu");
		//String realFolder = request.getContextPath() + "/WebContent/img/menu";
		//String realFolder = request.getSession().getServletContext().getRealPath("img/menu");
		System.out.print(realFolder);
		int maxSize = 5*1024*1024;
		String encType = "utf-8";
        
        MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
        
        Enumeration files = multi.getFileNames();
		String fname = (String) files.nextElement();
		String fileName = multi.getFilesystemName(fname);
		
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        MenuDAO dao = new MenuDAO();
        MenuVO vo = new MenuVO();
        String name = multi.getParameter("menu_name");
        String intro = multi.getParameter("menu_intro");
        int price = Integer.parseInt(multi.getParameter("menu_price"));
        vo.setName(name);
        vo.setIntro(intro);
        vo.setPrice(price);
        
        File upfile = new File(realFolder + "/" + fileName);
        File renamefile = new File(realFolder + "/" + name+".jpg");
        upfile.renameTo(renamefile);
        
        
        vo.setFacilityid((int)session.getAttribute("facilityid"));
        
        dao.AddMenu(vo);
        out.println("<script>");
        out.println("alert('추가처리가 완료되었습니다.');");
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


