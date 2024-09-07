package gls;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class edit
 */
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("Edit user");
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        out.println(uname);
        out.println("<form action='editaction' method='POST'>");
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='uid' value='"+uid+"'/></td></tr>");  
        out.print("<tr><td>user Name:</td><td><input type='text' name='uname' value='"+uname+"'/></td></tr>");  
        out.print("<tr><td>pasword:</td><td><input type='text' name='password' value='"+password+"'/></td></tr>"); 
        out.println("<tr><td></td><td><input type='submit'value='edit user'></td>");
        out.println("</table></form>");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
