package bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.vo.AuthorVo;

public class AuthorDao {

	public List<AuthorVo> findAll() {

		List<AuthorVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = getConnection();

			// 3. Statement 생성
			String sql = "select no, name from author";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			

			// 5. SQL 실행

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				
				AuthorVo vo = new AuthorVo();
				vo.setNo(no);
				vo.setName(name);
				
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error : + e");
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

	public boolean insert(AuthorVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into author values(null, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(파라미터 채우기)
			pstmt.setString(1, vo.getName());

			// 5. SQL 실행

			int count = pstmt.executeUpdate(); // 잘되면 1 안되면 0

			result = count == 1;
			

		} catch (SQLException e) {
			System.out.println("error : + e");
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

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}

}
