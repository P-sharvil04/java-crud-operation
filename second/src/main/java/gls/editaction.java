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
 * Servlet implementation class editaction
 */
public class editaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editaction() {
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
		    PrintWriter out = response.getWriter();
		    String uid = request.getParameter("uid");
		    String uname = request.getParameter("uname"); 
		    String password = request.getParameter("password");
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        String updateSQL = "UPDATE user1 SET uname=?, password=? WHERE uid=?";
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "sharvil123");
		        PreparedStatement pst = con.prepareStatement(updateSQL);
		        pst.setString(1, uname);
		        pst.setString(2, password);
		        pst.setString(3, uid);
		        pst.executeUpdate();
		        out.println("User Updated");
		        out.println("<a href=\"allusers\">Show users</a>");
		        System.out.print("User Updated");
		    } catch (Exception e) {
		        System.out.print(e);
		    }
		    doGet(request, response);
		}
	}


