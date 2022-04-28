package Login;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class LoginDAO {

	private Connection getConnection() {

		Connection con = null;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/GlobalStudy");
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("Connection 연결 실패!!!!!!!!!!!!!!!!!!");
		}
		return con;
	}
	
	public boolean idCheck(String M_Name) {
		boolean result = true;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			// 현재 id값이 뭐가 들어올지 모르므로 ?
			pstmt = con.prepareStatement("select * from S_MEMBER where M_Name=?");
			pstmt.setString(1, M_Name);
			// 조회하는 커리, db의 변화 없는 경우<->db변화가 있는 경우는 .executeUpdate();
			rs = pstmt.executeQuery();
			if (!rs.next())
				result = false;
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ss) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ss) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ss) {
				}
		}
		return result;
	}
	
}