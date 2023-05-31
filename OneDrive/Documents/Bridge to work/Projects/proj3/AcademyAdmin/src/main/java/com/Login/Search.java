package com.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//String rollno=request.getParameter("roll");  
		//int roll=Integer.valueOf(rollno); 
		String Clsid = request.getParameter("Cid");
		int Classid = Integer.valueOf(Clsid);
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnacademy", "root", "RuethS54%sO$");
			Connection con = DBConnection.initializeDatabase();
			
			Statement stmt = con.createStatement();  
			PreparedStatement ps = con.prepareStatement("select * from Students where where Cid = ?");
			ps.setInt(1,Classid);
			
			out.print("<table width=75% border=1>");
			out.print("<caption>Class Record Result : </caption>");
			
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumn = rsmd.getColumnCount();
			out.print("<tr>");
			
			for(int i=1; i<totalColumn; i++) {
				out.print("<th>" + rsmd.getColumnName(i)+"<th>");
			}
			out.print("<tr>");
			while(rs.next()) {
				out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
			}
			out.print("</table>");
			con.close();
			
		}catch (Exception e) {
			out.print(e);
		}
	}
	

}
