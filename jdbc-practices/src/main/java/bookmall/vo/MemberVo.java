package bookmall.vo;

public class MemberVo {
	
	private int m_num;          // 회원 번호
	private String name;        // 회원 이름
	private String email;       // 이메일
	private String password;    // 비밀번호
	private String tel;         // 휴대폰 번호
	
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "MemberVo [m_num=" + m_num + ", name=" + name + ", email=" + email + ", password=" + password + ", tel="
				+ tel + "]";
	}
	
	

}
