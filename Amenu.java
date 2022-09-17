package mcqexammanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Project.ConnectionProvider;
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

class Amenu extends JPanel 
{
	AddQues add;
	UpdateQues up;
	AllQues alq;
	DeleteQues dl;
	AllStudents als;
	JButton b1,b2;
	JLabel l1,l2;
	Color c1,c2;
	ImageIcon img1,img2,img3,img4,img5,img6;
	JTabbedPane tp1;
        
	Amenu()
	{
		setLayout(null);
		tp1=new JTabbedPane();
		Font f1=new Font("Comic Sans MS",Font.BOLD,30);
		Font f2=new Font("Comic Sans MS",Font.BOLD,24);
		Font f3=new Font("Comic Sans MS",Font.BOLD,15);
		c1=new Color(2,134,250);
		c2=new Color(250,159,2);
		setBackground(c1);
		img1=new ImageIcon(ClassLoader.getSystemResource("Image/addnew.png"));
		img2=new ImageIcon(ClassLoader.getSystemResource("Image/Updateq.png"));
		img3=new ImageIcon(ClassLoader.getSystemResource("Image/allques.png"));
		img4=new ImageIcon(ClassLoader.getSystemResource("Image/deleteques.png"));
		img5=new ImageIcon(ClassLoader.getSystemResource("Image/allstudent.png"));
		img6=new ImageIcon(ClassLoader.getSystemResource("Image/Updateq.png"));
		
		add=new AddQues();
		up=new UpdateQues();
		alq=new AllQues();
		dl=new DeleteQues();
		als=new AllStudents();
		
		tp1.setBounds(0,75,1380,630);
		tp1.setBackground(c2);
		tp1.setFont(f2);
		tp1.addTab("Add Questions",img1,add);
		tp1.addTab("Update Question",img2,up);
		tp1.addTab("All Question",img3,alq);
		tp1.addTab("Delete Question",img4,dl);
		tp1.addTab("All Students Results",img5,als);
		add(tp1);
		
		b1=new JButton("Logout");
		b1.setBounds(1110,27,100,40);
		b1.setFont(f3);
		b1.setBackground(c2);
		add(b1);
		
		b2=new JButton("Exit");
		b2.setBounds(1240,27,100,40);
		b2.setFont(f3);
		b2.setBackground(c2);
		add(b2);
				
		l1=new JLabel("Dashboard");
		l1.setBounds(600,0,200,70);
		l1.setFont(f1);
		add(l1);
	}
}
class AddQues extends JPanel implements ActionListener
{
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7;
	ImageIcon img1,img2,img3;
	Image bk;
	Color c1,c2;
	
	AddQues()
	{
		setLayout(null);
		setBackground(new Color(230,92,106));
		setForeground(Color.black);
		c2=new Color(250,159,2);
	                     Font f=new Font("Comic Sans MS",Font.BOLD,19);
		Font f1=new Font("Comic Sans MS",Font.BOLD,26);
		c1=new Color(2,134,250);
		
		img1=new ImageIcon(ClassLoader.getSystemResource("Image/light-blue-background.jpg"));
		img2=new ImageIcon(ClassLoader.getSystemResource("Image/save.png"));
		img3=new ImageIcon(ClassLoader.getSystemResource("Image/clear.png"));
		bk=img1.getImage();
		
		l1=new JLabel("Question ID:");
		l1.setBounds(100,60,170,40);
		l1.setFont(f1);
		add(l1);
		
		tx7=new JTextField();
		tx7.setBounds(280,60,80,40);
		tx7.setFont(f1);
		add(tx7);
		
		l3=new JLabel("Question:");
		l3.setBounds(100,120,170,40);
		l3.setFont(f1);
		add(l3);
		
		l4=new JLabel("Option 1:");
		l4.setBounds(100,180,170,40);
		l4.setFont(f1);
		add(l4);
		
		l5=new JLabel("Option 2:");
		l5.setBounds(100,240,170,40);
		l5.setFont(f1);
		add(l5);
		
		l6=new JLabel("Option 3:");
		l6.setBounds(100,300,170,40);
		l6.setFont(f1);
		add(l6);
		
		l7=new JLabel("Option 4:");
		l7.setBounds(100,360,170,40);
		l7.setFont(f1);
		add(l7);
		
		l8=new JLabel("Answer:");
		l8.setBounds(100,420,170,40);
		l8.setFont(f1);
		add(l8);
		
		tx1=new JTextField();
		tx1.setBounds(250,120,1000,38);
		tx1.setFont(f1);
		add(tx1);
		
		tx2=new JTextField();
		tx2.setBounds(250,180,1000,38);
		tx2.setFont(f1);
		add(tx2);
		
		tx3=new JTextField();
		tx3.setBounds(250,240,1000,38);
		tx3.setFont(f1);
		add(tx3);
		
		tx4=new JTextField();
		tx4.setBounds(250,300,1000,38);
		tx4.setFont(f1);
		add(tx4);
		
		tx5=new JTextField();
		tx5.setBounds(250,360,1000,38);
		tx5.setFont(f1);
		add(tx5);
		
		tx6=new JTextField();
		tx6.setBounds(250,420,1000,38);
		tx6.setFont(f1);
		add(tx6);
		
		b1=new JButton(img2);
		b1.setBounds(570,475,130,48);
		b1.setFont(f);
		b1.setBackground(c2);
		b1.setText("Save");
		add(b1);
                                          b1.addActionListener(this);
		
		b2=new JButton(img3);
		b2.setBounds(740,475,130,48);
		b2.setFont(f);
		b2.setBackground(c2);
		b2.setText("Clear");
                                          b2.addActionListener(this);
		add(b2);

	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bk,0,0,this);
	}
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==b1){
                String s1=tx7.getText();
                String s2=tx1.getText();
                String s3=tx2.getText();
                String s4=tx3.getText();
                String s5=tx4.getText();
                String s6=tx5.getText();
                String s7=tx6.getText();
                    if(s1.equals("") || s2.equals("")  ||  s3.equals("")  || s4.equals("")  || s5.equals("") || s6.equals("") || s7.equals("") ){
                 JOptionPane.showMessageDialog(null,"Please Enter Correct Details");
             }else{
                try{
                    Connection con=ConnectionProvider.getCon();
                    Statement st=con.createStatement();
                    String q="insert into ques values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
                    st.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Data Inserted");
                    tx1.setText("");
                    tx2.setText("");
                    tx3.setText("");
                    tx4.setText("");
                    tx5.setText("");
                    tx6.setText("");            
                    tx7.setText("");            
                    con.close();
                }catch(Exception e1){
                    System.out.println(e1);
                    JOptionPane.showMessageDialog(null, e1);
                }
                    }
            }
            if(e.getSource()==b2){
                
                tx1.setText("");
                tx2.setText("");
                tx3.setText("");
                tx4.setText("");
                tx5.setText("");
                tx6.setText("");            
                tx7.setText("");            
            }
        }
}
class UpdateQues extends JPanel implements ActionListener
{
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7;
	ImageIcon img1,img2,img3,img4;
	Image bk;
	Color c1,c2;
	
	UpdateQues()
	{
		setLayout(null);
		setBackground(new Color(230,92,106));
		setForeground(Color.black);
	                     Font f=new Font("Comic Sans MS",Font.BOLD,19);
		Font f1=new Font("Comic Sans MS",Font.BOLD,26);
		c1=new Color(2,134,250);
		c2=new Color(250,159,2);
		
		img1=new ImageIcon(ClassLoader.getSystemResource("Image/light-blue-background.jpg"));
		img2=new ImageIcon(ClassLoader.getSystemResource("Image/save.png"));
		img3=new ImageIcon(ClassLoader.getSystemResource("Image/clear.png"));
		img4=new ImageIcon(ClassLoader.getSystemResource("Image/search.png"));
		bk=img1.getImage();
		
		l1=new JLabel("Question ID:");
		l1.setBounds(100,60,170,40);
		l1.setFont(f1);
		add(l1);
		
		tx7=new JTextField();
		tx7.setBounds(280,60,75,40);
		tx7.setFont(f1);
		add(tx7);
		
		l3=new JLabel("Question:");
		l3.setBounds(100,120,170,40);
		l3.setFont(f1);
		add(l3);
		
		l4=new JLabel("Option 1:");
		l4.setBounds(100,180,170,40);
		l4.setFont(f1);
		add(l4);
		
		l5=new JLabel("Option 2:");
		l5.setBounds(100,240,170,40);
		l5.setFont(f1);
		add(l5);
		
		l6=new JLabel("Option 3:");
		l6.setBounds(100,300,170,40);
		l6.setFont(f1);
		add(l6);
		
		l7=new JLabel("Option 4:");
		l7.setBounds(100,360,170,40);
		l7.setFont(f1);
		add(l7);
		
		l8=new JLabel("Answer:");
		l8.setBounds(100,420,170,40);
		l8.setFont(f1);
		add(l8);
		
		tx1=new JTextField();
		tx1.setBounds(250,120,1000,38);
		tx1.setFont(f1);
		add(tx1);
		
		tx2=new JTextField();
		tx2.setBounds(250,180,1000,38);
		tx2.setFont(f1);
		add(tx2);
		
		tx3=new JTextField();
		tx3.setBounds(250,240,1000,38);
		tx3.setFont(f1);
		add(tx3);
		
		tx4=new JTextField();
		tx4.setBounds(250,300,1000,38);
		tx4.setFont(f1);
		add(tx4);
		
		tx5=new JTextField();
		tx5.setBounds(250,360,1000,38);
		tx5.setFont(f1);
		add(tx5);
		
		tx6=new JTextField();
		tx6.setBounds(250,420,1000,38);
		tx6.setFont(f1);
		add(tx6);
                
		b1=new JButton(img2);
		b1.setBounds(570,475,130,48);
		b1.setFont(f);
		b1.setBackground(c2);
		b1.setText("Update");
		add(b1);
                                         b1.addActionListener(this);
		
		b2=new JButton(img3);
		b2.setBounds(740,475,130,48);
		b2.setFont(f);
		b2.setBackground(c2);
		b2.setText("Clear");
		add(b2);
                                         b2.addActionListener(this);
                                         
                                         b3=new JButton(img4);
		b3.setBounds(365,60,140,40);
		b3.setFont(f);
		b3.setBackground(c2);
		b3.setText("Search");
                                         b3.addActionListener(this);
		add(b3);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bk,0,0,this);
	}
        public void actionPerformed(ActionEvent e){
            String s1=tx7.getText();
            String s2=tx1.getText();
            String s3=tx2.getText();
            String s4=tx3.getText();
            String s5=tx4.getText();
            String s6=tx5.getText();
            String s7=tx6.getText();
            
            if(e.getSource()==b3){
                    if(s1.equals("")){
                 JOptionPane.showMessageDialog(null,"Please Enter Correct Details");
             }else{
            try{
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                String q="select * from ques where ID='"+s1+"' ";
                ResultSet rs=st.executeQuery(q);
                if(rs.next()){
                    tx1.setText(rs.getString(2));
                    tx2.setText(rs.getString(3));
                    tx3.setText(rs.getString(4));
                    tx4.setText(rs.getString(5));
                    tx5.setText(rs.getString(6));
                    tx6.setText(rs.getString(7));
                    tx7.setText(rs.getString(1));
                }
                else{
                JOptionPane.showMessageDialog(null, "Enter Correct Question ID");
                }
                con.close();
                
            }catch(Exception e1){
                System.out.println(e1);
            }
            
                    }
        }
            if(e.getSource()==b1){
                    if(s1.equals("") || s2.equals("")  ||  s3.equals("")  || s4.equals("")  || s5.equals("") || s6.equals("") || s7.equals("")){
                 JOptionPane.showMessageDialog(null,"Please Enter Correct Details");
             }else{
                try{
                    Connection con=ConnectionProvider.getCon();
                    Statement st=con.createStatement();
                    String q="update ques set Ques='"+s2+"',Opt1='"+s3+"',Opt2='"+s4+"',Opt3='"+s5+"',Opt4='"+s6+"',Ans='"+s7+"' where ID='"+s1+"' ";
                    st.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Data Updated");
                    tx1.setText("");
                     tx2.setText("");
                     tx3.setText("");
                     tx4.setText("");
                     tx5.setText("");
                     tx6.setText("");
                     tx7.setText("");
                    con.close();
                }catch(Exception e1){
                    System.out.println(e1);
                }
                    }
            }
        
    if(e.getSource()==b2){
        tx1.setText("");
        tx2.setText("");
        tx3.setText("");
        tx4.setText("");
        tx5.setText("");
        tx6.setText("");
        tx7.setText("");
    }    
}
}
class AllQues extends JPanel implements ActionListener
{
	JButton b1,b2;
	ImageIcon img1;
	Image bk;
	Color c1,c2;
                     JTable table;
                     JScrollPane jsp;
                     Object rows[][]=new Object[100][100];
                     String columns[]={"Id","Question","Option 1","Option 2","Option 3","Option 4","Answer"};
                     TableModel model;
                     DefaultTableCellRenderer cellRenderer;
            
	AllQues()
	{
		setLayout(new BorderLayout());
		setBackground(new Color(230,92,106));
		setForeground(Color.black);
	                     Font f=new Font("Comic Sans MS",Font.BOLD,19);
		Font f1=new Font("Comic Sans MS",Font.BOLD,23);
		c1=new Color(2,134,250);
                                         c2=new Color(250,159,2);
		
		img1=new ImageIcon(ClassLoader.getSystemResource("Image/light-blue-background.jpg"));
		bk=img1.getImage();
                
                                          model=new DefaultTableModel(rows,columns);
		table=new JTable(model);
//                                          table.setBounds(0,0, 1000,700);
                                          table.setRowHeight(table.getRowHeight() + 20);
                                          table.getColumnModel().getColumn(2).setPreferredWidth(100);
                                          cellRenderer = new DefaultTableCellRenderer();
                                          cellRenderer.setHorizontalAlignment(JLabel.CENTER);
                                          table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
                                          table.setFont(f);
                                          table.setBackground(new Color(206,230,240));
                                          jsp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                                          add("Center",jsp);
                                          
                                          b1=new JButton("Show All Questions");
                                          b1.setBounds(100,100,170,50);
                                          b1.setBackground(c2);
                                          b1.setFont(f1);
                                          add("South",b1);
                                          b1.addActionListener(this);
                                          
                                          b2=new JButton("Clear All");
                                          b2.setBounds(100,100,170,50);
                                          b2.setBackground(c2);
                                          b2.setFont(f1);
//                                          add("South",b2);
                                          b2.addActionListener(this);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bk,0,0,this);
	}
         public void actionPerformed(ActionEvent e){
             if(e.getSource()==b1)
            try{
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                String q="select * from ques";
                ResultSet rs=st.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                table.getColumnModel().getColumn(0).setPreferredWidth(40);
                table.getColumnModel().getColumn(1).setPreferredWidth(500);
                table.getColumnModel().getColumn(2).setPreferredWidth(300);
                table.getColumnModel().getColumn(3).setPreferredWidth(300);
                table.getColumnModel().getColumn(4).setPreferredWidth(300);
                table.getColumnModel().getColumn(5).setPreferredWidth(300);
                table.getColumnModel().getColumn(6).setPreferredWidth(300);
            }catch(Exception e1){
                System.out.println(e1);
            }
        }
         }
class DeleteQues extends JPanel implements ActionListener
{
                     JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7;
	ImageIcon img1,img2,img3,img4;
	Image bk;
	Color c1,c2;
	
	DeleteQues()
	{
		setLayout(null);
		setBackground(new Color(230,92,106));
		setForeground(Color.black);
	                     Font f=new Font("Comic Sans MS",Font.BOLD,19);
		Font f1=new Font("Comic Sans MS",Font.BOLD,26);
		c1=new Color(2,134,250);
                                         c2=new Color(250,159,2);
		
		img1=new ImageIcon(ClassLoader.getSystemResource("Image/light-blue-background.jpg"));
		bk=img1.getImage();
                                          img2=new ImageIcon(ClassLoader.getSystemResource("Image/delete.png"));
		img3=new ImageIcon(ClassLoader.getSystemResource("Image/clear.png"));
		img4=new ImageIcon(ClassLoader.getSystemResource("Image/search.png"));
		bk=img1.getImage();
		
		l1=new JLabel("Question ID:");
		l1.setBounds(100,60,170,40);
		l1.setFont(f1);
		add(l1);
		
		tx7=new JTextField();
		tx7.setBounds(280,60,75,40);
		tx7.setFont(f1);
		add(tx7);
		
		l3=new JLabel("Question:");
		l3.setBounds(100,120,170,40);
		l3.setFont(f1);
		add(l3);
		
		l4=new JLabel("Option 1:");
		l4.setBounds(100,180,170,40);
		l4.setFont(f1);
		add(l4);
		
		l5=new JLabel("Option 2:");
		l5.setBounds(100,240,170,40);
		l5.setFont(f1);
		add(l5);
		
		l6=new JLabel("Option 3:");
		l6.setBounds(100,300,170,40);
		l6.setFont(f1);
		add(l6);
		
		l7=new JLabel("Option 4:");
		l7.setBounds(100,360,170,40);
		l7.setFont(f1);
		add(l7);
		
		l8=new JLabel("Answer:");
		l8.setBounds(100,420,170,40);
		l8.setFont(f1);
		add(l8);
		
		tx1=new JTextField();
		tx1.setBounds(250,120,1000,38);
		tx1.setFont(f1);
		add(tx1);
		
		tx2=new JTextField();
		tx2.setBounds(250,180,1000,38);
		tx2.setFont(f1);
		add(tx2);
		
		tx3=new JTextField();
		tx3.setBounds(250,240,1000,38);
		tx3.setFont(f1);
		add(tx3);
		
		tx4=new JTextField();
		tx4.setBounds(250,300,1000,38);
		tx4.setFont(f1);
		add(tx4);
		
		tx5=new JTextField();
		tx5.setBounds(250,360,1000,38);
		tx5.setFont(f1);
		add(tx5);
		
		tx6=new JTextField();
		tx6.setBounds(250,420,1000,38);
		tx6.setFont(f1);
		add(tx6);
                
		b1=new JButton(img2);
		b1.setBounds(570,475,130,48);
		b1.setFont(f);
		b1.setBackground(c2);
		b1.setText("Delete");
		add(b1);
                                         b1.addActionListener(this);
		
		b2=new JButton(img3);
		b2.setBounds(740,475,130,48);
		b2.setFont(f);
		b2.setBackground(c2);
		b2.setText("Clear");
		add(b2);
                                         b2.addActionListener(this);
                                         
                                         b3=new JButton(img4);
		b3.setBounds(365,60,140,40);
		b3.setFont(f);
		b3.setBackground(c2);
		b3.setText("Search");
                                         b3.addActionListener(this);
		add(b3);
		
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bk,0,0,this);
	}
        public void actionPerformed(ActionEvent e){
            String s1=tx7.getText();
            String s2=tx1.getText();
            String s3=tx2.getText();
            String s4=tx3.getText();
            String s5=tx4.getText();
            String s6=tx5.getText();
            String s7=tx6.getText();
            if(e.getSource()==b2){
                tx1.setText("");
                tx2.setText("");
                tx3.setText("");
                tx4.setText("");
                tx5.setText("");
                tx6.setText("");
                tx7.setText("");
            }
             if(e.getSource()==b3){
                 if(s1.equals("")){
                 JOptionPane.showMessageDialog(null,"Please Enter Correct Details");
             }else{
            try{
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                String q="select * from ques where ID='"+s1+"' ";
                ResultSet rs=st.executeQuery(q);
                
                if(rs.next()){
                    tx1.setText(rs.getString(2));
                    tx2.setText(rs.getString(3));
                    tx3.setText(rs.getString(4));
                    tx4.setText(rs.getString(5));
                    tx5.setText(rs.getString(6));
                    tx6.setText(rs.getString(7));
                    tx7.setText(rs.getString(1));
                }else{
                    JOptionPane.showMessageDialog(null, "Enter Correct Question ID");
                }
                con.close();
                
            }catch(Exception e1){
                System.out.println(e1);
            }
                 }
             }
             if(e.getSource()==b1){
                 if(s1.equals("") || s2.equals("")  ||  s3.equals("")  || s4.equals("")  || s5.equals("") || s6.equals("") || s7.equals("")){
                 JOptionPane.showMessageDialog(null,"Please Enter Correct Details");
             }
             else{
                 try{
                     Connection con=ConnectionProvider.getCon();
                     Statement st=con.createStatement();
                     String q="delete from ques where ID='"+s1+"'";
                     st.executeUpdate(q);
                     JOptionPane.showMessageDialog(null,"Data Deleted");
                     tx1.setText("");
                     tx2.setText("");
                     tx3.setText("");
                     tx4.setText("");
                     tx5.setText("");
                     tx6.setText("");
                     tx7.setText("");
                     con.close();
                 }catch(Exception e1){
                     System.out.println(e1);
                 }
             }
             }
            
        }
        
}
class AllStudents extends JPanel implements ActionListener
{
	JButton b1;
	ImageIcon img1;
	Image bk;
	Color c1,c2;
                     TableModel model;
                     JTable table;
                     JScrollPane jsp;
                     Object rows[][]=new Object[100][100];
                     String columns[]=new String[18];
	
	AllStudents()
	{
		setLayout(new BorderLayout());
		setBackground(new Color(230,92,106));
		setForeground(Color.black);
	                     Font f=new Font("",Font.BOLD,19);
		Font f1=new Font("",Font.BOLD,14);
		c1=new Color(2,134,250);
                                         c2=new Color(250,159,2);
		
		img1=new ImageIcon(ClassLoader.getSystemResource("Image/light-blue-background.jpg"));
		bk=img1.getImage();
                                          
                                          model=new DefaultTableModel(rows,columns);
                                          table=new JTable(model);
                                          table.setFont(f1);
                                          table.setBackground(new Color(206,230,240));
                                          table.setRowHeight(table.getRowHeight(30)+10);
                                          jsp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                                          add("Center",jsp);
                                          
                                          b1=new JButton("Show All Students");
                                          b1.setBounds(200,200,100,50);
                                          b1.setBackground(c2);
                                          b1.setFont(f);
                                          add("South",b1);
                                          b1.addActionListener(this);
                                          
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bk,0,0,this);
	}
                     public void actionPerformed(ActionEvent e){
                         if(e.getSource()==b1){
                             try{
                                          Connection con=ConnectionProvider.getCon();
                                          Statement st=con.createStatement();
                                          ResultSet rs=st.executeQuery("select * from student");
                                          table.setModel(DbUtils.resultSetToTableModel(rs));
                                          table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                                          table.getColumnModel().getColumn(0).setPreferredWidth(40);
                                          table.getColumnModel().getColumn(1).setPreferredWidth(300);
                                          table.getColumnModel().getColumn(2).setPreferredWidth(300);
                                          table.getColumnModel().getColumn(3).setPreferredWidth(300);
                                          table.getColumnModel().getColumn(4).setPreferredWidth(55);
                                          table.getColumnModel().getColumn(5).setPreferredWidth(150);
                                          table.getColumnModel().getColumn(6).setPreferredWidth(250);
                                          table.getColumnModel().getColumn(7).setPreferredWidth(400);
                                          table.getColumnModel().getColumn(8).setPreferredWidth(50);
                                          table.getColumnModel().getColumn(9).setPreferredWidth(50);
                                          table.getColumnModel().getColumn(10).setPreferredWidth(400);
                                          table.getColumnModel().getColumn(11).setPreferredWidth(50);
                                          table.getColumnModel().getColumn(12).setPreferredWidth(50);
                                          table.getColumnModel().getColumn(13).setPreferredWidth(300);
                                          table.getColumnModel().getColumn(14).setPreferredWidth(50);
                                          table.getColumnModel().getColumn(15).setPreferredWidth(50);
                                          table.getColumnModel().getColumn(16).setPreferredWidth(400);
                                          table.getColumnModel().getColumn(17).setPreferredWidth(50);
                                          }catch(Exception e1){
                                              System.out.println(e1);
                                          }
                         }
                     }
}
