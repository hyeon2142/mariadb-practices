package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;


public class CartDao {

	// select
		public List<CartVo> findAll() { 

			List<CartVo> result = new ArrayList<>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn = getConnection();

				// 3. Statement 생성
				String sql = "select * from Cart";
				pstmt = conn.prepareStatement(sql);

				// 4. binding
				

				// 5. SQL 실행

				rs = pstmt.executeQuery();
				while (rs.next()) {
					int Member_m_num = rs.getInt(1);
					int Book_b_num = rs.getInt(2);
					int quantity = rs.getInt(3);
					
					CartVo vo = new CartVo();
					vo.setM_num(Member_m_num);
					vo.setB_num(Book_b_num);
					vo.setQuantity(quantity);
					
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
		public boolean insert(CartVo vo) {
			boolean result = false;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = getConnection();

				// 3. SQL 준비
				String sql = "insert into Cart values(?, ?, ?)";
				pstmt = conn.prepareStatement(sql);

				// 4. 바인딩(파라미터 채우기)
				pstmt.setInt(1, vo.getM_num());
				pstmt.setInt(2, vo.getB_num());
				pstmt.setInt(3, vo.getQuantity());

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

			return result;

		}
		
		// update
		public void update(int m_num, int b_num, int quantity) {
			boolean result = false;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = getConnection();

				// 3. SQL 준비
				String sql = "update Cart set quantity = ? where Member_m_num = ? and Book_b_num = ?";
				pstmt = conn.prepareStatement(sql);

				// 4. 바인딩(파라미터 채우기)
				pstmt.setInt(1, quantity);
				pstmt.setInt(2, m_num);
				pstmt.setInt(3, b_num);

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
		public void delete(int m_num, int b_num) {
			boolean result = false;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = getConnection();

				// 3. SQL 준비
				String sql = "delete from Cart where Member_m_num = ? and Book_b_num = ?";
				pstmt = conn.prepareStatement(sql);

				// 4. 바인딩(파라미터 채우기)
				pstmt.setInt(1, m_num);
				pstmt.setInt(2, b_num);

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
