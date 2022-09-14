package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet(description = "login employee", urlPatterns = { "/profile1" })
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		String Id = request.getParameter("id");
		String Name = request.getParameter("username");
		String Password = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/trangile";
			String username1 = "root";
			String password1 = "Ayush@123";
			Connection conn = DriverManager.getConnection(url, username1, password1);
			String query = "select * from employee where Name=? and Id=? and Password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Name);
			ps.setInt(2, Integer.parseInt(Id));
			ps.setString(3, Password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
		//	pw.println("successfully signed in");
			response.sendRedirect("home?Name="+Name);
			} else {
				pw.println("not signed in");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
}
