package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.employee;

public class employeeservice {
	static String url="jdbc:postgresql://localhost:5432/employee";
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
	
	public int save(employee e) throws SQLException
	{
		int id=e.getId();
		String name=e.getName();
		int age=e.getAge();
		double salary=e.getSalary();
		
		String s="Insert into employee values(?,?,?,?)";
		PreparedStatement per=con.prepareStatement(s);
		per.setInt(1, id);
		per.setString(2, name);
		per.setInt(3, age);
		per.setDouble(4, salary);
		return per.executeUpdate();	
	}
	public int update(employee e) throws SQLException
	{
		int id=e.getId();
		String name=e.getName();
		int age=e.getAge();
		double salary=e.getSalary();
		
		String s="update employee set salary=?,age=?,name=? where id=?";
		PreparedStatement per=con.prepareStatement(s);
		per.setDouble(1, salary);
		per.setInt(2,age);
		per.setString(3, name);
		per.setInt(4, id);
		
		return per.executeUpdate();
		
	}
	public int delete(int id)
	{
		int n=0;
		String sql="delete from employee where id=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			n=statement.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return n;
	}
	public List<employee> display() {
		List<employee> emp=new ArrayList();
		try {
			Statement statement = con.createStatement();
			String sql="select * from employee";
			
			ResultSet rs = statement.executeQuery(sql);
			
			int i=0;
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				Double salary=rs.getDouble(4);
				emp.add(new employee(id, name, age, salary));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
		
	}

}










