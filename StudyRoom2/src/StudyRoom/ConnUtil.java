package StudyRoom;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnUtil {
	private static DataSource ds;
	static {
		
		try {
			InitialContext ctx= new InitialContext();
			ds= (DataSource)ctx.lookup("java:comp/env/jdbc/mydb");
			
		}catch(NamingException ne) {
			ne.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}

