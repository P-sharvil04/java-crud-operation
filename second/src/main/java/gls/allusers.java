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
 * Servlet implementation class allusers
 */
public class allusers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allusers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	PrintWriter out= response.getWriter();

		try
		{
   Class.forName("com.mysql.cj.jdbc.Driver");
   //Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/exam1","exam1","sumo@123");
   
   Connection con= DriverManager.getConnection("jdbc:mysql://localhost/user","root","sharvil123");
   PreparedStatement pst=  con.prepareStatement("Select * from user1");
   ResultSet rs=  pst.executeQuery();
   while(rs.next())
   		{
	   String id=rs.getString(1);
	   String uname=rs.getString(2);
	   String password=rs.getString(3);
	   String linkUrl = "details?uname=" + uname + "&password=" + password+ "&uid=" + id;
       out.println("<html>");
       out.println("<body>");
       out.println("<a href='" + linkUrl + "'>" + "username= "+"<b>" +uname +"</b>" + " " + "password=" +"<b>"+ password+"</b>"+"<br>" + "</a>");
       out.println("</body>");
       out.println("</html>");
      }
   out.close();
		}//try end
    	catch(Exception e)
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
