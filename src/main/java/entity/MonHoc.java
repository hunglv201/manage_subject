package entity;

public class MonHoc {
	int id;
	String tenmh;
	int sotc;
	
	
	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonHoc(int id, String tenmh, int sotc) {
		super();
		this.id = id;
		this.tenmh = tenmh;
		this.sotc = sotc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenmh() {
		return tenmh;
	}
	public void setTenmh(String tenmh) {
		this.tenmh = tenmh;
	}
	public int getSotc() {
		return sotc;
	}
	public void setSotc(int sotc) {
		this.sotc = sotc;
	}
	
	
}
