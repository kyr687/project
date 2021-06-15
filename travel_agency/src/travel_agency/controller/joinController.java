package travel_agency.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel_agency.controller.HttpUtil;
import travel.service.TravelService;
import travel.vo.Member;

public class joinController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
	
		Member member = new Member(id,pwd,name,tel,email);
		
		TravelService service = TravelService.getInstance();
		service.join(member);
		
		HttpUtil.forward(request, response, "/result/yjoin.html");		
	}
}
