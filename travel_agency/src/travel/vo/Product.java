package travel.vo;

import java.util.ArrayList;

public class Product {

	private String pid;
	private String pname;
	private String country;
	private int price;
	private String detail;
	private String image;
	private ArrayList<Product> list;
	
	public Product() {}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public String getCountry() {
		return pname;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "ProductVO [pid=" + pid + ", pname=" + pname + ", price=" + price + ", image=" + image + "]";
	}	


}
