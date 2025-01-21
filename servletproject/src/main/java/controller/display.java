package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.employee;
import service.employeeservice;
@WebServlet("/display")
public class display extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		employeeservice emp=new employeeservice();
		List<employee> e=emp.display();
		
		PrintWriter writer = resp.getWriter();
		writer.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Employee Table</title>\r\n"
				+ "   <style>\r\n"
				+ "    table {\r\n"
				+ "    width: 100%;\r\n"
				+ "    border-collapse: collapse;\r\n"
				+ "    margin: 20px 0;\r\n"
				+ "    font-size: 1em;\r\n"
				+ "    text-align: left;\r\n"
				+ "    background-color: #ffffff;\r\n"
				+ "    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "th, td {\r\n"
				+ "    padding: 12px;\r\n"
				+ "    border: 1px solid #ddd;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "th {\r\n"
				+ "    background-color: #007bff;\r\n"
				+ "    color: white;\r\n"
				+ "    text-align: center;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "tr:nth-child(even) {\r\n"
				+ "    background-color: #f2f2f2;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "tr:hover {\r\n"
				+ "    background-color: #f1f1f1;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "a {\r\n"
				+ "    text-decoration: none;\r\n"
				+ "    color: #007bff;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "a:hover {\r\n"
				+ "    text-decoration: underline;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "   </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1>Employee Details</h1>\r\n"
				+ "    <table>\r\n"
				+ "        <thead>\r\n"
				+ "            <tr>\r\n"
				+ "                <th>Id</th>\r\n"
				+ "                <th>Name</th>\r\n"
				+ "                <th>Age</th>\r\n"
				+ "                <th>Salary</th>\r\n"
				+ "                <th>Action</th>\r\n"
				+ "            </tr>\r\n"
				+ "        </thead>\r\n"
				+ "        <tbody>");
		for(employee empl:e)
		{
			int id=empl.getId();
			String name=empl.getName();
			int age=empl.getAge();
			double salary=empl.getSalary();
			writer.print("<tr>\r\n"
					+ "                <td>"+id+"</td>\r\n"
					+ "                <td>"+name+"</td>\r\n"
					+ "                <td>"+age+"</td>\r\n"
					+ "                <td>"+salary+"</td>\r\n"
					+ "                <td>\r\n"
					+ "                    <a href=\"editform.html\">Edit</a> |\r\n"
					+ "                    <a href=\"delete.html\">Delete</a>\r\n"
					+ "                </td>\r\n"
					+ "            </tr>");
		}
		
	}
}
