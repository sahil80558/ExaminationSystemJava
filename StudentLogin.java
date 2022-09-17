package mcqexammanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Project.ConnectionProvider;

class StudentLogin extends JPanel implements ItemListener,ActionListener
{
	ImageIcon img1,img2,img3,img4,img5;
	Image lg,bg;
	JLabel l1,l2;
	JButton b1,b2,b3;
	JTextField tx1;
	JPasswordField px1;
	JCheckBox cb1;
	Color c1,c2;
                     Card ca;
        
	StudentLogin(Card ca)
	{
                                          this.ca=ca;
		setLayout(null);
		Font f1=new Font("Comic Sans MS",Font.PLAIN,25);
		Font f2=new Font("Comic Sans MS",Font.BOLD,15);
		c1=new Color(161,247,194);
		c2=new Color(250,159,2);
		
		img1=new ImageIcon(ClassLoader.getSystemResource("Image/studentl.jpg"));
		img2=new ImageIcon(ClassLoader.getSystemResource("Image/lg1.png"));
		img3=new ImageIcon(ClassLoader.getSystemResource("Image/Back.png"));
		img4=new ImageIcon(ClassLoader.getSystemResource("Image/s1.png"));
		img5=new ImageIcon(ClassLoader.getSystemResource("Image/add1.png"));
		
		lg=img1.getImage().getScaledInstance(1380,885,Image.SCALE_DEFAULT);
		bg=img4.getImage().getScaledInstance(400,505,Image.SCALE_DEFAULT);
		
		l1=new JLabel("Username");
		l1.setBounds(1045,140,120,50);
		l1.setFont(f1);
		add(l1);
		
		l1=new JLabel("Password");
		l1.setBounds(1045,270,120,50);
		l1.setFont(f1);
		add(l1);
		
		tx1=new JTextField();
		tx1.setBounds(970,210,260,45);
		tx1.setFont(f1);
		add(tx1);
		
		px1=new JPasswordField();
		px1.setBounds(970,340,260,45);
		px1.setFont(f1);
		add(px1);
		
		b1=new JButton(img2);
		b1.setBounds(940,460,140,40);
		b1.setText("Login");
		b1.setBackground(c2);
		b1.setFont(f2);
		add(b1);
                                          b1.addActionListener(this);
		
		b2=new JButton(img5);
		b2.setBounds(1120,460,140,40);
		b2.setText("Register");
		b2.setFont(f2);
		b2.setBackground(c2);
		add(b2);
                                          b2.addActionListener(this);
                
                                          b3=new JButton(img3);
		b3.setBounds(1055,530,100,40);
		b3.setText("Back");
		b3.setFont(f2);
		b3.setBackground(c2);
		add(b3);
                                          b3.addActionListener(this);
		
		cb1=new JCheckBox("Show Password");
		cb1.setBounds(970,390,160,25);
		cb1.setBackground(c1);
		cb1.addItemListener(this);
		add(cb1);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(lg,0,0,this);
		g.drawImage(bg,900,110,this);
	}
                     public void actionPerformed(ActionEvent e){
                         if(e.getSource()==b1){
                             String s1=tx1.getText();
                             String s2=px1.getText();
                             
                             try{
                                 Connection con=ConnectionProvider.getCon();
                                 Statement st=con.createStatement();
                                 String q="select *from student where rollNo='"+s2+"' and name='"+s1+"'";
                                 ResultSet rs=st.executeQuery(q);
                                 if(rs.next()){
                                     ca.card.show(ca.cn,"instruction");
                                     new Instructions(s2);
                                     tx1.setText("");
                                     px1.setText("");
                                 }
                                 else{
                                     JOptionPane.showMessageDialog(null,"Enter Correct Username & Password");
                                 }
                             }catch(Exception e1){
                                 System.out.print(e1);
                                 JOptionPane.showMessageDialog(null,e1);
                             }
                         }
                         if(e.getSource()==b2){
                             ca.card.show(ca.cn,"Userfillup");
                         }
                         if(e.getSource()==b3){
                             tx1.setText("");
                             px1.setText("");
                             ca.card.show(ca.cn,"index");
                         }
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