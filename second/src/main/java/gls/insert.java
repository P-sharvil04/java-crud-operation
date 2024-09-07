package gls;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class insert
 */
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname= request.getParameter("uname"); 
		String password= request.getParameter("password");
		String email= request.getParameter("email");
		String contact= request.getParameter("contact");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String insertSQL="insert into user1 (uname,password,email,contact) values (?,?,?,?)";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/user","root","sharvil123");
			PreparedStatement pst=con.prepareStatement(insertSQL);
		
			pst.setString(1,uname);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4, contact);
			pst.executeUpdate();
			
			out.println("added user in database");
			out.println("<a href =\"validate\">Show user</a>");
			System.out.print("user Added");


			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		doGet(request, response);
	}

}
