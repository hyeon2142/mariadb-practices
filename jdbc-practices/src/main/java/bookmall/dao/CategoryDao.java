package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bookmall.vo.CategoryVo;

public class CategoryDao {
	
	
	// select
	public List<CategoryVo> findAll() { 

		List<CategoryVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = getConnection();

			// 3. Statement 생성
			String sql = "select * from Category";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			

			// 5. SQL 실행

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int c_no = rs.getInt(1);
				String c_name = rs.getString(2);
				
				CategoryVo vo = new CategoryVo();
				vo.setC_num(c_no);
				vo.setC_name(c_name);
				
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
	public boolean insert(CategoryVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into Category values(null, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(파라미터 채우기)
			pstmt.setString(1, vo.getC_name());

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
	public void update(int c_num, String c_name) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			// 3. SQL 준비
			String sql = "update Category set c_name = ? where c_num = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(파라미터 채우기)
			pstmt.setString(1, c_name);
			pstmt.setInt(2, c_num);

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
	public void delete(int c_num) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			// 3. SQL 준비
			String sql = "delete from Category where c_num = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(파라미터 채우기)
			pstmt.setInt(1, c_num);

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
