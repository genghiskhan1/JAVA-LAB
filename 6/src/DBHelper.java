import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class DBHelper {

	Connection con;
	DBHelper()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/XE","root","pass");
	    }catch(Exception e)
		{
	    	e.printStackTrace();
		}
  }

	void insertRep(Integer no,String name,String state,double comm,double rate) throws SQLException
	{
		String query="INSERT INTO Representative(no,Repname,state,commission,rate) values(?,?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(query);
    stmt.setInt(1, (int)no);
		stmt.setString(2, name);
		stmt.setString(3,state);
		stmt.setFloat(4, (float)comm);
		stmt.setFloat(5, (float)rate);
		System.out.println("ROWS AFFECTED"+stmt.executeUpdate());
		stmt.close();
	}

	void insertCust(Integer no,String name,String state,int credit,int repno) throws SQLException
	{
		String query="INSERT INTO Customer(no,CustName,state,credit_limit,repno) values(?,?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(query);
    stmt.setInt(1,(int)no);
		stmt.setString(2,name);
		stmt.setString(3, state);
		stmt.setInt(4, (int)credit);
		stmt.setInt(5, (int)repno);
		System.out.println("\n\tROWS AFFECTED"+stmt.executeUpdate());
		stmt.close();
	}

	void getReps(DefaultTableModel model) throws SQLException
	{
		String query="Select Repno,Repname from Representative,Customer where Representative.Repno=Customer.Custno AND Customer.credit_limit>15000";
		Statement stmt=con.createStatement();
		ResultSet res=stmt.executeQuery(query);
		while(res.next())
		{
			String repno=res.getString(1);
			String repname=res.getString(2);
			model.addRow(new Object[]{repno,repname});
		}
		stmt.close();
	}
}
