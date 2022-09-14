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
 * Servlet implementation class update3
 */
@WebServlet("/profile5")
public class update3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		String Id = request.getParameter("id");
		String Password = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/trangile";
			String username1 = "root";
			String password1 = "Ayush@123";
			Connection conn = DriverManager.getConnection(url, username1, password1);
			String query = "update employee set Password=? where Id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Password);
			ps.setInt(2, Integer.parseInt(Id));
			int rs = ps.executeUpdate();
			if (rs>0) {
			pw.println("Password successfully updated ");
				//response.sendRedirect("profile2");
			} else {
				pw.println("Password not successfully updated ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	}
	