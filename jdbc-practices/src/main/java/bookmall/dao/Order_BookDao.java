package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.Order_BookVo;

public class Order_BookDao {

	// select
	public List<Order_BookVo> findAll() {

		List<Order_BookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = getConnection();

			// 3. Statement 생성
			String sql = "select * from Order_Book";
			pstmt = conn.prepareStatement(sql);

			// 4. binding

			// 5. SQL 실행

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int o_num = rs.getInt(1);
				int b_num = rs.getInt(2);
				int quantity = rs.getInt(3);
				

				Order_BookVo vo = new Order_BookVo();
				vo.setO_num(o_num);
				vo.setB_num(b_num);
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
	public boolean insert(Order_BookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into Order_Book values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(파라미터 채우기)
			pstmt.setInt(1, vo.getO_num());
			pstmt.setInt(2, vo.getB_num());
			pstmt.setInt(3, vo.getQuantity());

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
	public void update(int o_num, int b_num, int quantity) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			// 3. SQL 준비
			String sql = "update Order_Book set quantity = ? where Order_o_num = ? and Book_b_num = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(파라미터 채우기)
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, o_num);
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
	public void delete(int o_num,int b_num) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			// 3. SQL 준비
			String sql = "delete from Order_Book where Order_o_num = ? and Book_b_num = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(파라미터 채우기)
			pstmt.setInt(1, o_num);
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
