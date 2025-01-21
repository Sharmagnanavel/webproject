package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/displayuser")
public class displayuser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<user> l = null;
		userservice us=new userservice();
		PrintWriter wr = resp.getWriter();
		try {
			l = us.fetch();
			wr.print("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <table>\r\n"
					+ "        <thead>\r\n"
					+ "            <th>name</th>\r\n"
					+ "            <th>age</th>\r\n"
					+ "            <th>salary</th>\r\n"
					+ "        </thead>\r\n"
					+ "        <tbody>");
			for (user use: l) {
				String name = use.getName();
				int age = use.getAge();
				int salary = use.getSalary();
				wr.print(" <tr>\r\n"
						+ "                <td>"+name+"</td>\r\n"
						+ "                <td>"+age+"</td>\r\n"
						+ "                <td>"+salary+"</td>\r\n"
						+ "            </tr>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
