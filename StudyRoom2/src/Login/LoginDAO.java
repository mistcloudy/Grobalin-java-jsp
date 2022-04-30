package Login;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class LoginDAO {

	private Connection getConnection() {

		Connection con = null;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mydb");
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("Connection �뿰寃� �떎�뙣!!!!!!!!!!!!!!!!!!");
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
			// �쁽�옱 id媛믪씠 萸먭� �뱾�뼱�삱吏� 紐⑤Ⅴ誘�濡� ?
			pstmt = con.prepareStatement("select * from S_MEMBER where M_Name=?");
			pstmt.setString(1, M_Name);
			// 議고쉶�븯�뒗 而ㅻ━, db�쓽 蹂��솕 �뾾�뒗 寃쎌슦<->db蹂��솕媛� �엳�뒗 寃쎌슦�뒗 .executeUpdate();
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