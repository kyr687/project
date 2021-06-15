package travel_agency.controller;

import java.io.File;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import travel.dao.ProductDAO;
import travel.vo.Product;


@WebServlet(value={"/productlist","/read","/insert","/delete"})
public class ProductController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    ProductDAO dao=new ProductDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		RequestDispatcher dis=null;
		
		switch(path) {
		case "/delete":
			Product vo=dao.read(request.getParameter("pid"));
			if(vo.getImage()!=null) {
				File file=new File("c:/images/"+vo.getImage());
				file.delete();
			}
			dao.delete(request.getParameter("pid"));
			response.sendRedirect("list");
			break;	
		case "/read":
			request.setAttribute("vo", dao.read(request.getParameter("pid")));
			dis=request.getRequestDispatcher("read.jsp");
			dis.forward(request, response);
			break;	
		case "/insert":
			if(dao.getPid()!=null) {
				request.setAttribute("pid",Integer.parseInt((String) dao.getPid())+1);
			}else {
				request.setAttribute("pid", "P001");
			}
			dis=request.getRequestDispatcher("insert.jsp");
			dis.forward(request, response);
			break;			
		case "/productlist":
			request.setAttribute("list", dao.list());
			dis=request.getRequestDispatcher("productlist.jsp");
			dis.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path=request.getServletPath();
		
		//이미지파일업로드
		String uploadPath="c:/images";
		MultipartRequest multi=new MultipartRequest(
				request, 
				uploadPath, 
				1024*1024*10, 
				"UTF-8", 
				new DefaultFileRenamePolicy());
		Product vo=new Product();
		vo.setPid(multi.getParameter("pid"));
		vo.setPname(multi.getParameter("pname"));
		vo.setPrice(Integer.parseInt(multi.getParameter("price")));
		vo.setImage(multi.getFilesystemName("image"));
		
		switch(path) {
		case "/insert":
			dao.insert(vo);
			response.sendRedirect("list");
			break;
		}
	}

}
