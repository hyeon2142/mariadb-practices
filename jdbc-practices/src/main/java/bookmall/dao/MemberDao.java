package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.MemberVo;

public class MemberDao {

	// select
		public List<MemberVo> findAll() { 

			List<MemberVo> result = new ArrayList<>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn = getConnection();

				// 3. Statement 생성
				String sql = "select * from Member";
				pstmt = conn.prepareStatement(sql);

				// 4. binding
				

				// 5. SQL 실행

				rs = pstmt.executeQuery();
				while (rs.next()) {
					int m_num = rs.getInt(1);
					String name = rs.getString(2);
					String email = rs.getString(3);
					String password = rs.getString(4);
					String tel = rs.getString(5);
					
					MemberVo vo = new MemberVo();
					vo.setM_num(m_num);
					vo.setName(name);
					vo.setEmail(email);
					vo.setPassword(password);
					vo.setTel(tel);
					
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
		public boolean insert(MemberVo vo) {
			boolean result = false;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = getConnection();

				// 3. SQL 준비
				String sql = "insert into Member values(null, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);

				// 4. 바인딩(파라미터 채우기)
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getEmail());
				pstmt.setString(3, vo.getPassword());
				pstmt.setString(4, vo.getTel());

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
		public void update(int m_num, String name, String email, String password, String tel) {
			boolean result = false;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = getConnection();

				// 3. SQL 준비
				String sql = "update Member set name = ?, email = ?, password = ?, tel = ? where m_num = ?";
				pstmt = conn.prepareStatement(sql);

				// 4. 바인딩(파라미터 채우기)
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.setString(3, password);
				pstmt.setString(4, tel);

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
		public void delete(int m_num) {
			boolean result = false;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = getConnection();

				// 3. SQL 준비
				String sql = "delete from Member where m_num = ?";
				pstmt = conn.prepareStatement(sql);

				// 4. 바인딩(파라미터 채우기)
				pstmt.setInt(1, m_num);

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
