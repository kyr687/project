package travel.service;

import java.util.ArrayList;

import travel.dao.TravelDAO;
import travel.service.TravelService;
import travel.vo.Member;
import travel.vo.Orders;

public class TravelService {
	
	private static TravelService service = new TravelService();
	public TravelDAO dao = TravelDAO.getInstance();
	private TravelService() {}

	public static TravelService getInstance() {
		// TODO Auto-generated method stub
		return service;
	}

	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.login(id, pwd);
	}
	
	public void join(Member member) {
		// TODO Auto-generated method stub
		dao.join(member);
	}

	public ArrayList<Orders> enlist() {
		// TODO Auto-generated method stub
		ArrayList<Orders> list = dao.enlist();
		return list;
	}
	


}
