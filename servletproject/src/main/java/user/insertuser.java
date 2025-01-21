package user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/adduser")
public class insertuser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		int salary = Integer.parseInt(req.getParameter("salary"));
		
		user u=new user(name, age, salary);
		userservice us=new userservice();
		try {
			boolean n = us.insert(u);
			if(!n)
			{
				System.out.println("data is inserted");
			}
			else {
				System.out.println("data is  not inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
