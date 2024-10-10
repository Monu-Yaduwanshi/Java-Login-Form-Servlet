package com.service11;

import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginDBconnect extends HttpServlet {
	
	

//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        
        

//        String url = "jdbc:mysql://localhost:3306/logindata";
//        String dbUsername = "root";
//        String dbPassword = "root";
        
        

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            
            
//            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            
            
//            Connection conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logindata","root","root");
//            String sql = "SELECT * FROM users WHERE username=? AND password=?";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, username);
//            statement.setString(2, password);
//            ResultSet result = statement.executeQuery();
//
//            if (result.next()) {
//                response.sendRedirect("success.html");
//            } else {
//                response.sendRedirect("login.html");
//            }
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logindata", "root", "root");
	        
	        String sql = "SELECT * FROM users WHERE username=? AND password=?";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, username);
	        statement.setString(2, password);
	        ResultSet result = statement.executeQuery();

	        if (result.next()) {
	            response.sendRedirect("success.html");
	        } else {
	            response.sendRedirect("login.html");
	        }
	        conn.close();
	    } catch (SQLException e) {
	        // Database access error
	        request.setAttribute("error", "Database access error: " + e.getMessage());
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    } catch (ClassNotFoundException e) {
	        // MySQL JDBC driver not found
	        request.setAttribute("error", "MySQL JDBC driver not found: " + e.getMessage());
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    } catch (Exception e) {
	        // Other unexpected errors
	        request.setAttribute("error", "Unexpected error: " + e.getMessage());
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    }
	}}

