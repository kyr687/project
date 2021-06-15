package travel.vo;

public class Orders extends Product{

	private String oid;
	private String pid;
	private int price;
	public Orders() {}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", pid=" + pid + ", price=" + price +"]";
	}	

}
