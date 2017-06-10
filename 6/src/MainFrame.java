import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private static AddForm addform;
	private static DisplayForm showform;
	private static Container c;
	MainFrame()
	{
		c=getContentPane();
		defaultSetFrame();
		addform=new AddForm();
		showform=new DisplayForm();
		setSize(200,400);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				System.exit(0);
			}
		});
	}	
		static void defaultSetFrame()
		{
			c.removeAll();
			JButton btn1=new JButton("INSERT DATA");
			JButton btn2=new JButton("DISPLAY REPRESENTATIVES");
			JPanel mainPanel=new JPanel();
			mainPanel.add(btn1);
			mainPanel.add(btn2);
			c.add(mainPanel);
			c.revalidate();
			c.repaint();
			
			btn1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					c.removeAll();
					c.add(addform);
					c.revalidate();
					c.repaint();
				}
			});
			
			btn2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					c.removeAll();
					c.add(showform);
					c.revalidate();
					c.repaint();
				}
			});
		}
		
		public static void main(String [] args)
		{
			new MainFrame();
		}
}
