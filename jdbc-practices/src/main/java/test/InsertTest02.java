package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static boolean insert(String name) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "root", "root");

			// 3. SQL 준비
			String sql = "insert into dept values(null,?)";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩(파라미터 채우기)
			pstmt.setString(1, name);
			
			// 5. SQL 실행
			
			int count = pstmt.executeUpdate();                // 잘되면 1 안되면 0
			
			result = count == 1;
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error : + e");
		} finally {
			// clean up
			try {
				if(pstmt != null) {
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
	

}
