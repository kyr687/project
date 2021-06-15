package travel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import travel.vo.Member;
import travel.vo.Orders;

import java.util.*;

import proj.vo.Enroll;

public class TravelDAO {

	private static TravelDAO dao = new TravelDAO();
	public TravelDAO() {}

	public static TravelDAO getInstance() {
		// TODO Auto-generated method stub
		return dao;
	}
	
	public Connection connect()
	{
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel","root","root11");
		}catch(Exception e) {
			System.out.print("MDAO:connect"+e);
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();	
			}catch(Exception e){
				System.out.print("Pstmt close error"+e);
			}
		}
		if(conn != null)
		{
			try {
				conn.close();	
			}catch(Exception e){
				System.out.print("Conn close error"+e);
			}
		}
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();	
			}catch(Exception e){
				System.out.print("rs close error"+e);
			}
		}
		close(conn,pstmt);
	}

	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id=? and pwd=?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result= true;
			}else
				result = false;
			
		}catch(Exception e) {
			System.out.print("login error"+e);
		}finally {
			close(conn,pstmt,rs);
		}
		return result;
	}

	public void join(Member member) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?);");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getEmail());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.print("join error"+e);
		}finally {
			close(conn,pstmt);
		}
	}

	public ArrayList<Orders> enlist() {
		// TODO Auto-generated method stub
		ArrayList<Orders> list = new ArrayList<Orders>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Orders or = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select a.pid,b.name,a.price from product b, orders a ,member c where a.pid=b.pid and c.name = '김';");
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{	
				or = new Orders();
				or.setPid(rs.getString(1));
				or.setPrice(rs.getString(2));
				list.add(or);
			}
		}catch(Exception e) {
			System.out.print("error"+e);
		}finally {
			close(conn,pstmt,rs);
		}
		return list;
	}
	
	

}


