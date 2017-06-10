/* Create a Telephone Directory Application using Servlet that searches the database 
   based on phone number or name. Also show database table creation with inserting 5 
   values to the table.
   Database Name: OnlineDirectory
   Table Design:
   Table Name: Telephone_Directory
   Attributes: Phone_Number, Name, Address, Company, Pin_Code.
 */

import java.io.IOException;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TelephoneSearch
 */
@WebServlet("/TelephoneSearch")
public class TelephoneSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelephoneSearch() {
        super();
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://localhst:3306/OnlineDirectory");
        }catch(Exception e){e.printStackTrace();}
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		PrintWriter pw=response.getWriter();
		if(name!=null)
		{
			if(!name.isEmpty())
			{
				pw.println("\n\tDETAILS");
			}
			try
			{
				Statement s=conn.createStatement();
				String sql="Select *from TelePhone Directory where name='"+name+"'";
				ResultSet rs=s.executeQuery(sql);
				while(rs.next())
				{
					pw.println("NAME: "+rs.getString("name"));
					pw.println("\nPHONE NUMBER:"+rs.getString("number"));
					pw.println("\nADDRESS:"+rs.getString("address"));
					pw.println("\nCOMPANY:"+rs.getString("company"));
					pw.println("\nPIN CODE:"+rs.getString("pin"));
				}
				
			}catch(Exception e){e.printStackTrace();}
		}
		
		if(number!=null)
		{
			if(!number.isEmpty())
			{
				pw.println("\n\tDETAILS");
			}
			try
			{
				Statement s=conn.createStatement();
				String sql="Select *from TelephoneDirectory where number='"+number+"'";
				ResultSet rs=s.executeQuery(sql);
				while(rs.next())
				{
					pw.println("NAME:"+rs.getString("name"));
					pw.println("\nPHONE NUMBER:"+rs.getString("number"));
					pw.println("\nADDRESS:"+rs.getString("address"));
					pw.println("\nCOMPANY:"+rs.getString("company"));
					pw.println("\n\tPIN CODE:"+rs.getString("pin"));
				}
			}catch(Exception e){e.printStackTrace();}
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
