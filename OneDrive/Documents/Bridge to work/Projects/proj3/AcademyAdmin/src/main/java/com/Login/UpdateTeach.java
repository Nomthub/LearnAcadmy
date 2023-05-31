package com.Login;

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
 * Servlet implementation class UpdateTeach
 */
@WebServlet("/UpdateTeach")
public class UpdateTeach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeach() {
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
		
		int Teaid = Integer.parseInt(request.getParameter("id"));
		String Fstname = request.getParameter("Fstname");
		String Lstname = request.getParameter("lstname");
		int status=0;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnacademy", "root", "RuethS54%sO$");
			Connection con = DBConnection.initializeDatabase();
			
			PreparedStatement ps = con.prepareStatement("update teachers set FstName=? , LstName=? where Tid=?");
			ps.setString(1,Fstname);
			ps.setString(2, Lstname);
			ps.setInt(3, Teaid);
			status = ps.executeUpdate();
			
			if(status>0) {
				out.print("<p>Records saved successfully:</p>");
				request.getRequestDispatcher("setList.html").include(request, response);
			}else {
				out.print("<p>Sorry! unable to save records:</p>");
				request.getRequestDispatcher("setList.html").include(request, response);
			}
		
		}catch (Exception e) {
			out.print(e);
		}
	}

}
