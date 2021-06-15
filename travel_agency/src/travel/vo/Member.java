package travel.vo;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String tel;
	private String email;
	
	public Member() {}
	public Member(String tid,String tpwd, String tname,String ttel,String temail )
	{
		this.id=tid;
		this.pwd=tpwd;
		this.name=tname;
		this.tel=ttel;
		this.email=temail;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String tid) {
		this.id = tid;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String tpwd) {
		this.pwd = tpwd;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String tname) {
		this.name = tname;
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

}
