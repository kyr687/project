package travel_agency.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.vo.Purchase;

@WebServlet(value={"/list"})
public class PurchaseController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    Purchase dao=new Purchase();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String path=request.getServletPath();
		RequestDispatcher dis=null;
		switch(path) {
			request.setAttribute("pageName", "/list.jsp");
			dis=request.getRequestDispatcher("/index.jsp");
			dis.forward(request, response);
			break;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
