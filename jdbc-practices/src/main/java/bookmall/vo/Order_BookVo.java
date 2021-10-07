package bookmall.vo;

public class Order_BookVo {
	
	private int o_num;     // 주문 번호
	private int b_num;     // 책 번호
	private int quantity;  // 수량
	private int price;     // 가격
	
	@Override
	public String toString() {
		return "Order_BookVo [o_num=" + o_num + ", b_num=" + b_num + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
