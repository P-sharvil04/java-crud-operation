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
import java.sql.ResultSet;

/**
 * Servlet implementation class validate
 */
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uname = request.getParameter("uname");
		String password= request.getParameter("password");
		
		   PrintWriter out=response.getWriter();
			try
			{
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   //Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/exam1","exam1","sumo@123");
	   Connection con= DriverManager.getConnection("jdbc:mysql://localhost/user","root","sharvil123");
	   PreparedStatement pst=  con.prepareStatement("Select * from user1 WHERE uname=? AND password=?");
	   pst.setString(1,uname);
	   pst.setString(2,password);
	   ResultSet rs=  pst.executeQuery();

	   if (rs.next()) {	   		
		   String id1=rs.getString(1);
		   String uname1=rs.getString(2);
		   String pass=rs.getString(3);
	   		String linkUrl = "details?uname=" + uname1 + "&password=" + pass+ "&uid=" + id1;
	   		out.println("<html>");
	   		out.println("<body>");
	   		out.println("<a href='" + linkUrl + "'>" + uname +password + "</a>");
			out.println("<a href=\"allusers\">show book details</a>");
	      	out.println("</body>");
	      	out.println("</html>");
	      	
	   }
	   else 
		   
		   response.sendRedirect("error.jsp");  
			
			 
		  out.close();
			}catch(Exception e)
			{
				System.out.println(e);
			
			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
