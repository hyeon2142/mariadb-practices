package bookmall.vo;

public class BookVo {

	private int b_num;        // 책 번호
	private String title;     // 책 제목
	private int price;        // 가격
	private int c_num;        // 카테고리 번호
	
	@Override
	public String toString() {
		return "BookVo [b_num=" + b_num + ", title=" + title + ", price=" + price + ", c_num=" + c_num + "]";
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	
}
