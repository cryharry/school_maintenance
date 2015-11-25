package school_info;

public class InfoBean {
	private int school_info_id; 
	private String gwanhal; 
	private String sch_name; 
	private String sulrip; 
	private String tel; 
	private String fax; 
	private String post; 
	private String address; 
	private String homepage;
	
	public int getSchool_info_id() {
		return school_info_id;
	}
	public void setSchool_info_id(int school_info_id) {
		this.school_info_id = school_info_id;
	}
	public String getGwanhal() {
		return gwanhal;
	}
	public void setGwanhal(String gwanhal) {
		this.gwanhal = gwanhal;
	}
	public String getSch_name() {
		return sch_name;
	}
	public void setSch_name(String sch_name) {
		this.sch_name = sch_name;
	}
	public String getSulrip() {
		return sulrip;
	}
	public void setSulrip(String sulrip) {
		this.sulrip = sulrip;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
}
