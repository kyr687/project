package travel.vo;

public class Purchase {
	private String name;
	private String oid;
	private String tel;
	private String email;

	public Purchase() {}
	public String getName() {
		return name;
	}
	public void setName(String tname) {
		this.name = tname;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String ttel) {
		this.tel = ttel;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String temail) {
		this.email = temail;
	}
	public char[] plist(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}
}
