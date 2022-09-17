package mcqexammanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Admin extends JPanel implements ItemListener
{
	ImageIcon img1,img2,img3,img4;
	Image lg;
	JLabel l1,l2;
	JButton b1,b2;
	JTextField tx1;
	JPasswordField px1;
	JCheckBox cb1;
	Color c1,c2;
	Admin()
	{
		setLayout(null);
		Font f1=new Font("Comic Sans MS",Font.PLAIN,25);
		Font f2=new Font("Comic Sans MS",Font.BOLD,15);
		c1=new Color(161,247,194);
		c2=new Color(250,159,2);
		
		img1=new ImageIcon(ClassLoader.getSystemResource("Image/lgbg.png"));
		img2=new ImageIcon(ClassLoader.getSystemResource("Image/lg1.png"));
		img3=new ImageIcon(ClassLoader.getSystemResource("Image/Back.png"));
		img4=new ImageIcon(ClassLoader.getSystemResource(""));
		
		lg=img1.getImage();
		
		l1=new JLabel("Username");
		l1.setBounds(1045,140,120,50);
		l1.setFont(f1);
		add(l1);
		
		l1=new JLabel("Password");
		l1.setBounds(1045,270,120,50);
		l1.setFont(f1);
                                         l1.setOpaque(false);
		add(l1);
		
		tx1=new JTextField();
		tx1.setBounds(1010,210,200,45);
		tx1.setFont(f1);
		add(tx1);
		
		px1=new JPasswordField();
		px1.setBounds(1010,340,200,45);
		px1.setFont(f1);
		add(px1);
		
		b1=new JButton(img2);
		b1.setBounds(980,460,100,40);
		b1.setText("Login");
		b1.setBackground(c2);
		b1.setFont(f2);
		add(b1);
		
		b2=new JButton(img3);
		b2.setBounds(1120,460,100,40);
		b2.setText("Back");
		b2.setFont(f2);
		b2.setBackground(c2);
		add(b2);
		
		cb1=new JCheckBox("Show Password");
		cb1.setBounds(1010,390,160,25);
		cb1.setOpaque(false);
		cb1.addItemListener(this);
		add(cb1);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(lg,0,5,this);
	}
	public void itemStateChanged(ItemEvent e)
	{
		String s1=px1.getText();
		if(cb1.isSelected())
		{
			px1.setEchoChar((char)0);
		}
		else
		{
			px1.setEchoChar('*');
		}
	}
}