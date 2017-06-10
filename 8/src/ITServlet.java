/* Create a Servlet to file IT returns that accepts personal information, salary
   information and Tax deduction details from the user and write the information 
   into a file. Also accept the name of the person and display in on the page.
*/

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ITServlet
 */
@WebServlet("/ITServlet")
public class ITServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ITServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		Double salary=Double.parseDouble(request.getParameter("salary"));
		Double deduction=Double.parseDouble(request.getParameter("deduction"));
		double income=0.3*(salary-deduction);
		response.getWriter().append("NAME:"+name).append("\nGender:"+gender).append("\nSALARY:"+salary).append("\nDEDUCTION:"+deduction).append("\nINCOME:"+income);
		@SuppressWarnings("resource")
		PrintWriter w=new PrintWriter("data.txt");
		w.println("NAME:"+name);
		w.println("GENDER:"+gender);
		w.println("SALARY:"+salary);
		w.println("TAX DEDUCTIONS:"+deduction);
		w.println("INCOME TAX:"+income);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
