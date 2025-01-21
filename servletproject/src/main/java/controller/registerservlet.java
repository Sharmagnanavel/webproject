 package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.employee;
import service.employeeservice;
@WebServlet("/insert")
public class registerservlet extends HttpServlet{
	private employeeservice employeeservice;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt( req.getParameter("id"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		double salary=Double.parseDouble(req.getParameter("salary"));
		
		employee e=new employee(id, name, age, salary);
		
		
		employeeservice emp=new employeeservice();
		PrintWriter writer = resp.getWriter();
		try {
			
			int n=emp.save(e);
			System.out.println(n);
			if(n!=0)
			{
				writer.print("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "<title>Success - Employee Management</title>\r\n"
						+ "<style>\r\n"
						+ "    /* Reset and base styling */\r\n"
						+ "    * {\r\n"
						+ "        margin: 0;\r\n"
						+ "        padding: 0;\r\n"
						+ "        box-sizing: border-box;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    body {\r\n"
						+ "        font-family: 'Arial', sans-serif;\r\n"
						+ "        background: linear-gradient(to bottom right, #c9d6ff, #e2e2e2);\r\n"
						+ "        display: flex;\r\n"
						+ "        flex-direction: column;\r\n"
						+ "        justify-content: center;\r\n"
						+ "        align-items: center;\r\n"
						+ "        min-height: 100vh;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    h1, p {\r\n"
						+ "        color: white;\r\n"
						+ "        text-align: center;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    h1 {\r\n"
						+ "        background-color: #28a745;\r\n"
						+ "        padding: 15px;\r\n"
						+ "        margin-bottom: 20px;\r\n"
						+ "        border-radius: 8px;\r\n"
						+ "        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\r\n"
						+ "        font-size: 24px;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    p {\r\n"
						+ "        font-size: 18px;\r\n"
						+ "        font-weight: bold;  /* Making the message bold */\r\n"
						+ "        margin-bottom: 20px;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    button {\r\n"
						+ "        background-color: #007bff;\r\n"
						+ "        color: white;\r\n"
						+ "        padding: 10px 25px;\r\n"
						+ "        border: none;\r\n"
						+ "        border-radius: 5px;\r\n"
						+ "        cursor: pointer;\r\n"
						+ "        font-size: 16px;\r\n"
						+ "        transition: background-color 0.3s ease, transform 0.2s ease;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    button:hover {\r\n"
						+ "        background-color: #0056b3;\r\n"
						+ "        transform: scale(1.05);\r\n"
						+ "    }\r\n"
						+ "</style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <h1>Success!</h1>\r\n"
						+ "    <p>Employee data has been successfully added to the database.</p>\r\n"
						+ "    <button onclick=\"window.location.href='welcome.html';\">Back to Employee Management</button>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
			}
			else{
				writer.print("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Failure - Employee Management</title>\r\n"
						+ "    <style>\r\n"
						+ "        /* Reset and base styling */\r\n"
						+ "        * {\r\n"
						+ "            margin: 0;\r\n"
						+ "            padding: 0;\r\n"
						+ "            box-sizing: border-box;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        body {\r\n"
						+ "            font-family: 'Arial', sans-serif;\r\n"
						+ "            background: linear-gradient(to bottom right, #c9d6ff, #e2e2e2);\r\n"
						+ "            display: flex;\r\n"
						+ "            flex-direction: column;\r\n"
						+ "            justify-content: center;\r\n"
						+ "            align-items: center;\r\n"
						+ "            min-height: 100vh;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        h1, p {\r\n"
						+ "            color: white;\r\n"
						+ "            text-align: center;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        h1 {\r\n"
						+ "            background-color: #dc3545;\r\n"
						+ "            padding: 15px;\r\n"
						+ "            margin-bottom: 20px;\r\n"
						+ "            border-radius: 8px;\r\n"
						+ "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\r\n"
						+ "            font-size: 24px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        p {\r\n"
						+ "            font-size: 18px;\r\n"
						+ "            font-weight: bold;  /* Making the message bold */\r\n"
						+ "            margin-bottom: 20px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        button {\r\n"
						+ "            background-color: #007bff;\r\n"
						+ "            color: white;\r\n"
						+ "            padding: 10px 25px;\r\n"
						+ "            border: none;\r\n"
						+ "            border-radius: 5px;\r\n"
						+ "            cursor: pointer;\r\n"
						+ "            font-size: 16px;\r\n"
						+ "            transition: background-color 0.3s ease, transform 0.2s ease;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        button:hover {\r\n"
						+ "            background-color: #0056b3;\r\n"
						+ "            transform: scale(1.05);\r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <h1>Failure!</h1>\r\n"
						+ "    <p>Employee data could not be saved. Please try again.</p>\r\n"
						+ "    <button onclick=\"window.location.href='addemp.html';\">Back to Employee Management</button>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
				System.out.println("data is not saved");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}	
