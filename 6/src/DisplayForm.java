import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class DisplayForm extends JPanel{
	private static final long serialVersionUID = 1L;
	DBHelper db=new DBHelper();
	JButton btnback=new JButton("BACK");
	
	DisplayForm()
	{
	 btnback.addActionListener(new ActionListener()
	 {
	 	public void actionPerformed(ActionEvent e)
	 	{
			MainFrame.defaultSetFrame();
		}
 	 });
	}
	
	void display()
	{
		this.removeAll();
		DefaultTableModel model=new DefaultTableModel();
		String [] header={"REPNO","REPNAME"};
		model.setColumnIdentifiers(header);
		try
		{
			db.getReps(model);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		JTable tbl=new JTable(model);
		add(new JScrollPane(tbl));
		add(btnback);
	}
}
