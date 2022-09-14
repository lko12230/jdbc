package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update1
 */
@WebServlet("/profile3")
public class update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String Id = request.getParameter("id");
		String Email = request.getParameter("email");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/trangile";
			String username1 = "root";
			String password1 = "Ayush@123";
			Connection conn = DriverManager.getConnection(url, username1, password1);
			String query = "update employee set Email=? where Id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Email);
			ps.setInt(2, Integer.parseInt(Id));
			int rs = ps.executeUpdate();
			if (rs>0) {
			pw.println("Email successfully updated ");
				//response.sendRedirect("profile2");
			} else {
				pw.println("Email not successfully updated ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	


