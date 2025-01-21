package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class userservice {
	static String url="jdbc:postgresql://localhost:5432/usermanage";
	static String username="postgres";
	static String pwd="123";
	static Connection con;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			
			con=DriverManager.getConnection(url, username, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean insert(user u) throws SQLException
	{
		
		int age = u.getAge();
		int salary = u.getSalary();
		String name = u.getName();
		String sql="insert into usermanage values(?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, name);
		st.setInt(2, age);
		st.setInt(3, salary);
		boolean n=st.execute();
		System.out.println(n);
		return n;
		
	}
	
	public List<user> fetch() throws SQLException
	{
		List<user> l = new ArrayList<user>();
		Statement st = con.createStatement();
		String sql="select * from usermanage";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			String name = rs.getString(1);
			int age = rs.getInt(2);
			int salary = rs.getInt(3);
			l.add(new user(name, age, salary));
		}
		 return l;
	}
}
