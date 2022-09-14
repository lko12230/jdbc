package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/profile")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String Id=request.getParameter("id");
		String Name=request.getParameter("username");
		String Email=request.getParameter("email");
		String Mobile_Number=request.getParameter("mobile");
		String Password=request.getParameter("password");
		try
		{
Class.forName("com.mysql.cj.jdbc.Driver");
String url ="jdbc:mysql://localhost:3306/trangile";
String username1="root";
String password1="Ayush@123";
Connection conn=DriverManager.getConnection(url, username1, password1);
		String query="insert into employee values(?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setInt(1, Integer.parseInt(Id));
		ps.setString(2, Name);
		ps.setString(3, Email);
		ps.setString(4, Mobile_Number);
		ps.setString(5, Password);
		int rs=ps.executeUpdate();
		if(rs>0)
		{
		pw.println("successfully stored");
		}
		else {
			pw.println("not stored");
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	}
