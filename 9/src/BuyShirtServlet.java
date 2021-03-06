/* Write a JSP and Servlet Program to do the following to buy a T-Shirt online:
   A set of checkboxes to select your T-Shirt accessories such as �belt�, �cap�,
   �hair-band� , text area / text field to enter your T-Shirt tag-line,  Radio-button
   that allows the user to choose between T-Shirt with chest pocket and Combo Box to
   choose your T-Shirt color
   Create appropriate labels for these GUI Components and a button called �Click Me�
   which when pressed will Insert the details entered into a table called �TShirts�.
   An OrderNo is generated by adding �1� to the existing �OrderNo�. If �TShirts� table
   is empty the initial value of �OrderNo� is 100. This �OrderNo� is also inserted
   into the �TShirts� table .
   Display all the records of the �TShirts� table in tabular form
   PS: Frontend display should be in JSP and the business logic should be written in Servlet Class.
*/

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyShirtServlet
 */
@WebServlet("/BuyShirtServlet")
public class BuyShirtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyShirtServlet() {
        super();
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/XE");
        }catch(Exception e){}
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String []accessories=request.getParameterValues("accessories");
		String tag=request.getParameter("tag");
		String color=request.getParameter("color");
		Integer pocket=Integer.parseInt(request.getParameter("pocket"));

		String acc="";
		for(String s:accessories)
		{
			acc+=s+"";
		}

		String sql="Insert into tshirt (tag,color,pocket,acc) values(?,?,?,?)";
		try
		{
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,"tag");
			stmt.setString(2, "color");
			stmt.setString(3, "pocket");
			stmt.setString(4, "acc");
			stmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("show.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
