package test;

public class DeptVo {
	private Long no;
	private String name;
	
	public Long getNo() {
		return no;
	}
	@Override
	public String toString() {
		return "DeptVo [no=" + no + ", name=" + name + "]";
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
