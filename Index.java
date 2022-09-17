package mcqexammanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Index extends JPanel
{
	JButton b1,b2,b3;
	ImageIcon img1,img2,img3,img4;
	Image bg,ad,usr;
                     Color c2; 
	Index()
	{
		setLayout(null);
		Font f2=new Font("Comic Sans MS",Font.BOLD,15);
                                          c2=new Color(250, 124, 92);
		img1=new ImageIcon(ClassLoader.getSystemResource("Image/indexbg.png"));
		img2=new ImageIcon(ClassLoader.getSystemResource("Image/indxst.png"));
		img3=new ImageIcon(ClassLoader.getSystemResource("Image/indxad.png"));
		img4=new ImageIcon(ClassLoader.getSystemResource("Image/Close.png"));
		
		bg=img1.getImage();
		
		b1=new JButton(img3);
		b1.setBounds(680,630,150,80);
		b1.setForeground(Color.black);
		b1.setText("Admin");
		b1.setFont(f2);
		b1.setBackground(Color.white);
                                         b1.setBackground(c2);
		add(b1);
		
		b2=new JButton(img2);
		b2.setBounds(940,630,150,80);
		b2.setText("User");
		b2.setFont(f2);
		b2.setForeground(Color.black);
		b2.setBackground(Color.white);
                                         b2.setBackground(c2);
		add(b2);
		
		b3=new JButton(img4);
		b3.setBounds(1180,630,150,80);
		b3.setForeground(Color.black);
		b3.setFont(f2);
		b3.setText("Exit");
		b3.setBackground(c2);
		add(b3);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(bg,0,5,this);
	}
}