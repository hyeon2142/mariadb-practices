package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;
import bookmall.vo.BookVo;
import bookshop.vo.AuthorVo;

public class BookDao {

	// select
	public List<BookVo> findAll() {

		List<BookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = getConnection();

			// 3. Statement 생성
			String sql = "select * from Book";
			pstmt = conn.prepareStatement(sql);

			// 4. binding

			// 5. SQL 실행

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int b_no = rs.getInt(1);
				String title = rs.getString(2);
				int price = rs.getInt(3);
				int Category_c_num = rs.getInt(4);

				BookVo vo = new BookVo();
				vo.setB_num(b_no);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setC_num(Category_c_num);

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
	public boolean insert(BookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into Book values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(파라미터 채우기)
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getC_num());

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
	public void update(int b_num, String title, int price, int c_num) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			// 3. SQL 준비
			String sql = "update Book set title = ?, price = ?, c_num = ? where b_num = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(파라미터 채우기)
			pstmt.setString(1, title);
			pstmt.setInt(2, price);
			pstmt.setInt(3, c_num);

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
	public void delete(int b_num) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			// 3. SQL 준비
			String sql = "delete from Book where b_num = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(파라미터 채우기)
			pstmt.setInt(1, b_num);

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
