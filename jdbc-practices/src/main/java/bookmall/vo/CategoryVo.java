package bookmall.vo;

public class CategoryVo {

	private int c_num;                // 카테고리 번호
	private String c_name;            // 카테고리 이름
	
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [c_num=" + c_num + ", c_name=" + c_name + "]";
	}
	
	
}
