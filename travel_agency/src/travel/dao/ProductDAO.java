package travel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import travel.vo.Product;

public class ProductDAO {
	private static TravelDAO dao = new TravelDAO();
	public ProductDAO() {}

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

	public Product read(String pid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Product vo=new Product();
		try {
			String sql="select * from product where pid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, pid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				vo.setPid(rs.getString("pid"));
				vo.setPname(rs.getString("pname"));
				vo.setPrice(rs.getInt("price"));
				vo.setImage(rs.getString("image"));
			}
		}catch(Exception e) {
			System.out.println("오류:" + e.toString());
		}		
		return vo;
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			String sql="delete from tblproduct where pid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, pid);
			ps.execute();
		}catch(Exception e) {
			System.out.println("오류:" + e.toString());			
		}
	
	}

	public ArrayList<Product> list(){
		ArrayList<Product> array=new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from product;");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product vo=new Product();
				vo.setPid(rs.getString(1));
				vo.setPname(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setImage(rs.getString(4));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("오류:" + e.toString());
		}finally {
			close(conn,pstmt,rs);
		}
		return array;
	}

	public void insert(Product vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			String sql="insert into product(pid,pname,price,image) values(?,?,?,?)";
			@SuppressWarnings("null")
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getPid());
			ps.setString(2, vo.getPname());
			ps.setInt(3, vo.getPrice());
			ps.setString(4, vo.getImage());
			ps.execute();
		}catch(Exception e) {
			System.out.println("오류:" + e.toString());			
		}

	}

	public Object getPid() {
		// TODO Auto-generated method stub
		return null;
	}


}
