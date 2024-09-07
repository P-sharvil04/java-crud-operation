package gls;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class details
 */
public class details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        
        // Display the received variables
        out.println("<html>");
        out.println("<body> <center>");
        out.println("<h1>User Name: " + uname + "</h1>");
        out.println("<h1> password: " + password + "</h1>");
        
        
        String delUrl="delete?uid="+ uid;
        out.println("<b>"+"<a href='" + delUrl + "'>" + "delete" + "</a>"+"</b>");
        
        String editUrl="edit?uid=" + uid + "&uname="+uname + "&password=" +password;
        out.println("<b>"+"<a href='" + editUrl + "'>" + "forgotpassword" + "</a>"+"</b>");
        
        String linkUrl="login.jsp";                
        out.println("<b>"+"<a href='" + linkUrl + "'>" + "login" + "</a>"+"</b>");
        
        out.println("</center></body>");
        out.println("</html>");
        
        out.close();	
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
