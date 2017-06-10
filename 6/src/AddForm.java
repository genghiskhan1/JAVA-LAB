/* Write a program that uses Java Swing and JDBC to create a stand-alone application:
   Create two tables namely, Representative (RepNo, RepName, State, Commission, Rate)
   and Customer (CustNo, CustName, State, Credit_Limit, RepNo) in MySQL database.
   Use appropriate Swing components to insert values in a form.
   Use another form to display Representative�s information whose Credit_Limit is above 15,000.
*/

import javax.swing.*;
import java.awt.event.*;
public class AddForm extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel Rno=new JLabel("REPRESENTATIVE NUMBER");
	JLabel Rname=new JLabel("REPRESENTATIVE NAME");
	JLabel Rstate=new JLabel("REPRESENTATIVE STATE");
	JLabel Rcomm=new JLabel("REPRESENTATIVE COMMISSION");
	JLabel Rrate=new JLabel("REPRESENTATIVE RATE");
	JTextField jRno=new JTextField(10);
	JTextField jRname=new JTextField(10);
	JTextField jRstate=new JTextField(10);
	JTextField jRcomm=new JTextField(10);
	JTextField jRrate=new JTextField(10);
	JLabel Cno=new JLabel("CUSTOMER NUMBER");
	JLabel Cname=new JLabel("CUSTOMER NAME");
	JLabel Cstate=new JLabel("CUSTOMER STATE");
	JLabel Ccredit=new JLabel("CREDIT LIMIT");
	JLabel CRepno=new JLabel("REPRESENTATIVE NUMBER");
	JTextField jCno=new JTextField(10);
	JTextField jCname=new JTextField(10);
	JTextField jCstate=new JTextField(10);
	JTextField jCcredit=new JTextField(10);
	JTextField jCRepno=new JTextField(10);
	JButton addCust=new JButton("ADD CUSTOMER");
	JButton addRep=new JButton("ADD REPRESENTATIVE");
	JButton backbtn=new JButton("BACK");
	DBHelper db;

	AddForm()
	{
		db=new DBHelper();
		setLayout();
		performAction();
	}

	void setLayout()
	{
		add(Rno);add(jRno);
		add(Rname);add(jRname);
		add(Rstate);add(jRstate);
		add(Rcomm);add(jRcomm);
		add(Rrate);add(jRrate);
		add(addRep);
		add(Cno);add(jCno);
		add(Cname);add(jCname);
		add(Cstate);add(jCstate);
		add(Ccredit);add(jCcredit);
		add(CRepno);add(jCRepno);
		add(addCust);
		add(backbtn);
	}

	void performAction()
	{
		addRep.addActionListener(new ActionListener()
		{
		     public void actionPerformed(ActionEvent e)
		     {
		    	 System.out.println("SUBMITTED");
					 Integer no=Integer.parseInt(jRno.getText());
		    	 String name=jRname.getText();
		    	 String state=jRstate.getText();
		    	 double comm=Double.parseDouble(jRcomm.getText());
		    	 double rate=Double.parseDouble(jRrate.getText());
		    	 try
		    	 {
		    		 db.insertRep(no,name,state,comm,rate);
		    	 }catch(Exception e1)
		    	 {
		    		 e1.printStackTrace();
		    	 }
		     }
		});

		addCust.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("SUBMITTED");
				Integer no=Integer.parseInt(jCno.getText());
				String name=jCname.getText();
				String state=jCstate.getText();
				int credit=Integer.parseInt(jCcredit.getText());
				int repno=Integer.parseInt(jCRepno.getText());
				try
				{
					db.insertCust(no,name,state,credit,repno);
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});

		backbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MainFrame.defaultSetFrame();
			}
		});
	}
}
