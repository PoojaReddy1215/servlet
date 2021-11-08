package com.xworkz.web.xworkzDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.jdbc.servlet.connection.DatabaseConnection;

public class DetailsServlet extends HttpServlet {
	public DetailsServlet() {
		System.out.println("invoked no-args constructor in DeatilsServlet");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       System.out.println("invoked service in Details Servlet");
		try {
			  
            // Initialize the database
            Connection connection = DatabaseConnection.initializeDatabase();
  
            // Create a SQL query to insert data into demo table
           
            PreparedStatement statement = connection.prepareStatement("insert into xworkz_details values(?,?,?,?)");
  
            // For the first parameter,
            // get the data using request object
            // sets the data to st pointer
            statement.setString(1, request.getParameter("NAME"));
            statement.setString(2, request.getParameter("TYPE"));
            statement.setString(3, request.getParameter("YOP"));
            statement.setString(4, request.getParameter("EDUCATION"));
            
            // Execute the insert command using executeUpdate()
            // to make changes in database
            
            statement.executeUpdate();
  
            // Close all the connections
            statement.close();
            connection.close();
            
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h1>");
		writer.print("Register Success!!!!!!!!!");
		writer.print("</h1>");
		writer.print("</body>");
		writer.print("</html>");
		}
		catch (Exception e) {
	        e.printStackTrace();

	 }
    	}
	}
	

