package bookmall.vo;

public class OrderVo {
	
	private int o_num;            // 주문번호
	private int ordernum;         // 식별번호
	private int payment;          // 결제금액
	private String address;       // 주소
	private int m_num;            // 회원번호
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	
	@Override
	public String toString() {
		return "OrderVo [o_num=" + o_num + ", ordernum=" + ordernum + ", payment=" + payment + ", address=" + address
				+ ", m_num=" + m_num + "]";
	}
	

}
