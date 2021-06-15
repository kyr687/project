package travel_agency.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import travel.service.TravelService;
import travel.vo.Orders;
import travel_agency.controller.Controller;

@WebServlet(value={"/cart"})

public class CartController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TravelService service = TravelService.getInstance();
		ArrayList<Orders> list = service.enlist();
		
		request.setAttribute("list",list);
		HttpUtil.forward(request, response, "cartlist.jsp");
		
	}


}
