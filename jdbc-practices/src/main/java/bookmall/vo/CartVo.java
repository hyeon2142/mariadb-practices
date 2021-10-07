package bookmall.vo;

public class CartVo {
	
	private int m_num;        // 회원 번호
	private int b_num;        // 책 번호
	private int quantity;     // 수량 
	
	
	@Override
	public String toString() {
		return "CartVo [m_num=" + m_num + ", b_num=" + b_num + ", quantity=" + quantity + "]";
	}
	
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
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
	

}
