package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bookmall.vo.OrderVo;

public class OrderDao {

	// select
		public List<OrderVo> findAll() {

			List<OrderVo> result = new ArrayList<>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn = getConnection();

				// 3. Statement 생성
				String sql = "select * from `Order`";
				pstmt = conn.prepareStatement(sql);

				// 4. binding

				// 5. SQL 실행

				rs = pstmt.executeQuery();
				while (rs.next()) {
					int o_no = rs.getInt(1);
					int ordernum = rs.getInt(2);
					int payment = rs.getInt(3);
					String address = rs.getString(4);
					int Member_m_num = rs.getInt(5);
	
					OrderVo vo = new OrderVo();
					vo.setO_num(o_no);
					vo.setOrdernum(ordernum);
					vo.setPayment(payment);
					vo.setAddress(address);
					vo.setM_num(Member_m_num);

					result.add(vo);
				}

			} catch (SQLException e) {
				System.out.println("error : " + e);
			} finally {
				// clean up
				try {
					if (rs != null) {
						rs.close();
					}

					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return result;
		}

		// insert
		public boolean insert(OrderVo vo) {
			boolean result = false;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = getConnection();

				// 3. SQL 준비
				String sql = "insert into `Order` values(null,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);

				// 4. 바인딩(파라미터 채우기)
				pstmt.setInt(1, vo.getOrdernum());
				pstmt.setInt(2, vo.getPayment());
				pstmt.setString(3, vo.getAddress());
				pstmt.setInt(4, vo.getM_num());

				// 5. SQL 실행

				int count = pstmt.executeUpdate(); // 잘되면 1 안되면 0

				result = count == 1;
				System.out.println("정상 실행");

			} catch (SQLException e) {
				System.out.println("error : " + e);
				e.printStackTrace();
			} finally {
				// clean up
				try {
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return result;

		}

		// update
		public void update(int o_num, int ordernum, int payment, String address, int m_num) {
			boolean result = false;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = getConnection();

				// 3. SQL 준비
				String sql = "update `Order` set ordernum = ?, payment = ?, address = ?, Member_m_num = ? where o_num = ?";
				pstmt = conn.prepareStatement(sql);

				// 4. 바인딩(파라미터 채우기)
				pstmt.setInt(1, ordernum);
				pstmt.setInt(2, payment);
				pstmt.setString(3, address);
				pstmt.setInt(4, m_num);
				pstmt.setInt(5, o_num);

				// 5. SQL 실행

				int count = pstmt.executeUpdate(); // 잘되면 1 안되면 0

				result = count == 1;

				System.out.println("정상 실행");

			} catch (SQLException e) {
				System.out.println("error : " + e);
			} finally {
				// clean up
				try {
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		// delete
		public void delete(int o_num) {
			boolean result = false;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = getConnection();

				// 3. SQL 준비
				String sql = "delete from `Order` where o_num = ?";
				pstmt = conn.prepareStatement(sql);

				// 4. 바인딩(파라미터 채우기)
				pstmt.setInt(1, o_num);

				// 5. SQL 실행

				int count = pstmt.executeUpdate(); // 잘되면 1 안되면 0

				result = count == 1;

			} catch (SQLException e) {
				System.out.println("error : " + e);
			} finally {
				// clean up
				try {
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		private Connection getConnection() throws SQLException {
			Connection conn = null;
			try {
				// 1. JDBC Driver 로딩
				Class.forName("org.mariadb.jdbc.Driver");

				// 2. 연결하기
				String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
				conn = DriverManager.getConnection(url, "root", "root");
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패:" + e);
			}

			return conn;
		}
	
}
