package mcqexammanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Date.*;
import Project.ConnectionProvider;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class UserFillup extends JPanel implements ActionListener,KeyListener,ItemListener
{
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    JTextField RollNo,Name,FathersName,MothersName,ContactNo,Email,University10,Marks10,Year10,University12,Marks12,Year12,UniversityG,MarksG,YearG,Address;
    JRadioButton r1,r2;
    ButtonGroup cb1;
    JTextArea ta1;
    ImageIcon img1,img2,img3,img4,img5;
    Image bg,form;
    Color c1,c2;
    String RGender,s1,s2;
    Card ca;
    
    UserFillup(Card ca)
    {
        setLayout(null);
        Font f1=new Font("Comic Sans MS",Font.BOLD,30);
        Font f2=new Font("Comic Sans MS",Font.BOLD,23);
        Font f3=new Font("Comic Sans MS",Font.BOLD,19);
        c1=new Color(2,134,250);
        c2=new Color(250,159,2);
        
        this.ca=ca;
        
        img1=new ImageIcon(ClassLoader.getSystemResource("Image/indxst.png"));
        img2=new ImageIcon(ClassLoader.getSystemResource("Image/Back.png"));
        img3=new ImageIcon(ClassLoader.getSystemResource("Image/Close.png"));
        img4=new ImageIcon(ClassLoader.getSystemResource("Image/save.png"));
        img5=new ImageIcon(ClassLoader.getSystemResource("Image/form.png"));
        bg=img1.getImage();
        form=img5.getImage().getScaledInstance(210,280,Image.SCALE_DEFAULT);
        setBackground(new Color(206,230,240));
        
        b1=new JButton(img2);
        b1.setBounds(1175,20,120,40);
        b1.setText("Back");
        b1.setBackground(c2);
        b1.setFont(f2);
        add(b1);
        
        b2=new JButton(img4);
        b2.setBounds(600,670,180,50);
        b2.setText("Save & Login");
        b2.setBackground(c2);
        b2.setFont(f3);
        add(b2);
        b2.addActionListener(this);
        
        l1=new JLabel("FILL UP THE FORM");
        l1.setBounds(100,18,300,30);
        l1.setFont(f1);
        add(l1);
        
        l2=new JLabel("Name :");
        l2.setBounds(50,100,100,30);
        l2.setFont(f2);
        add(l2);
        
        l3=new JLabel("Father's Name :");
        l3.setBounds(50,155,200,30);
        l3.setFont(f2);
        add(l3);
        
        l4=new JLabel("Mother's Name :");
        l4.setBounds(50,210,200,30);
        l4.setFont(f2);
        add(l4);
        
        l5=new JLabel("Gender:");
        l5.setBounds(50,265,200,30);
        l5.setFont(f2);
        add(l5);
        
        cb1=new ButtonGroup();
        r1=new JRadioButton("Male");
        r1.setBounds(280,265,100,40);
        r1.setFont(f2);
        r1.setBackground(new Color(206,230,240));
        cb1.add(r1);
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(420,265,150,40);
        r2.setFont(f2);
        r2.setBackground(new Color(206,230,240));
        cb1.add(r2);
        add(r2);
        
        l6=new JLabel("Contact Number:");
        l6.setBounds(50,320,200,30);
        l6.setFont(f2);
        add(l6);
        
        l7=new JLabel("Email:");
        l7.setBounds(50,375,200,30);
        l7.setFont(f2);
        add(l7);
        
        l8=new JLabel("10th :");
        l8.setBounds(50,430,200,30);
        l8.setFont(f2);
        add(l8);
        
        l9=new JLabel("12th:");
        l9.setBounds(50,485,200,30);
        l9.setFont(f2);
        add(l9);
        
        l10=new JLabel("Graduation:");
        l10.setBounds(50,540,200,30);
        l10.setFont(f2);
        add(l10);
        
        l11=new JLabel("Address:");
        l11.setBounds(50,595,200,30);
        l11.setFont(f2);
        add(l11);
        
        l12=new JLabel("Date:");
        l12.setBounds(840,22,60,30);
        l12.setFont(f3);
        add(l12);
        
        DateTimeFormatter dF= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now=LocalDateTime.now();
        
        l13=new JLabel("");
        l13.setBounds(900,22,150,30);
        l13.setFont(f3);
        l13.setText(dF.format(now));
        add(l13);
        
        l14=new JLabel("Roll Number:");
        l14.setBounds(700,100,150,30);
        l14.setFont(f3);
        add(l14);
        
        RollNo=new JTextField();
        RollNo.setBounds(850,100,350,35);
        RollNo.setFont(f3);
        add(RollNo);
        
        Name=new JTextField();
        Name.setBounds(280,100,350,35);
        Name.setFont(f3);
        add(Name);
        
        FathersName=new JTextField();
        FathersName.setBounds(280,155,350,35);
        FathersName.setFont(f3);
        add(FathersName);
        
        MothersName=new JTextField();
        MothersName.setBounds(280,210,350,35);
        MothersName.setFont(f3);
        add(MothersName);
        
        ContactNo=new JTextField();
        ContactNo.setBounds(280,320,350,35);
        ContactNo.setFont(f3);
        add(ContactNo);
        
        Email=new JTextField();
        Email.setBounds(280,375,350,35);
        Email.setFont(f3);
        add(Email);
        
        University10=new JTextField();
        University10.setBounds(280,430,350,35);
        University10.setFont(f3);
        University10.setText("Enter University Name");
        University10.setForeground(Color.gray);
        add(University10);
        University10.addKeyListener(this);
        
        Marks10=new JTextField();
        Marks10.setBounds(640,430,200,35);
        Marks10.setFont(f3);
        Marks10.setText("Enter Percentage");
        Marks10.setForeground(Color.gray);
        Marks10.addKeyListener(this);
        add(Marks10);
        
        Year10=new JTextField();
        Year10.setBounds(850,430,200,35);
        Year10.setFont(f3);
        Year10.setText("Enter Passout Year");
        Year10.setForeground(Color.gray);
        Year10.addKeyListener(this);
        add(Year10);
        
        University12=new JTextField();
        University12.setBounds(280,485,350,35);
        University12.setFont(f3);
        University12.setText("Enter University Name");
        University12.setForeground(Color.gray);
        University12.addKeyListener(this);
        add(University12);
        
        Marks12=new JTextField();
        Marks12.setBounds(640,485,200,35);
        Marks12.setFont(f3);
        Marks12.setText("Enter Percentage");
        Marks12.setForeground(Color.gray);
        add(Marks12);
        Marks12.addKeyListener(this);
        
        Year12=new JTextField();
        Year12.setBounds(850,485,200,35);
        Year12.setFont(f3);
        Year12.setText("Enter Passout Year");
        Year12.setForeground(Color.gray);
        add(Year12);
        Year12.addKeyListener(this);
        
        UniversityG=new JTextField();
        UniversityG.setBounds(280,540,350,35);
        UniversityG.setFont(f3);
        UniversityG.setText("Enter University Name");
        UniversityG.setForeground(Color.gray);
        add(UniversityG);
        UniversityG.addKeyListener(this);
        
        MarksG=new JTextField();
        MarksG.setBounds(640,540,200,35);
        MarksG.setFont(f3);
        MarksG.setText("Enter Percentage");
        MarksG.setForeground(Color.gray);
        add(MarksG);
        MarksG.addKeyListener(this);
        
        YearG=new JTextField();
        YearG.setBounds(850,540,200,35);
        YearG.setFont(f3);
        YearG.setText("Enter Passout Year");
        YearG.setForeground(Color.gray);
        YearG.addKeyListener(this);
        add(YearG);
        
        Address=new JTextField();
        Address.setBounds(280,595,772,35);
        Address.setFont(f3);
        add(Address);
        
        ta1=new JTextArea();
        ta1.setBounds(700,190,580,140);
        ta1.setFont(f3);
//        ta1.setBackground(new Color(206,230,240));
        ta1.append(" Examination Management System is managing all the\n activities related to examination from the receipt of\n Enrollment forms and Examination forms through the\n processing of results and Certificates and Grading reports.");
        add(ta1);
        ta1.setEditable(false);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bg,8,7, this);
        g.drawImage(form,1125,400, this);
        g.drawLine(0,70,1360,70);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b2){
             if(r1.isSelected()){
            RGender=r1.getText();
        }
        if(r2.isSelected()){
            RGender=r2.getText();
        }
            s1=RollNo.getText();
            s2=Name.getText();
            String s3=FathersName.getText();
            String s4=MothersName.getText();
            String s5=RGender;
            String s6=ContactNo.getText();
            String s7=Email.getText();
            String s8=University10.getText();
            String s9=Marks10.getText();
            String s10=Year10.getText();
            String s11=University12.getText();
            String s12=Marks12.getText();
            String s13=Year12.getText();
            String s14=UniversityG.getText();
            String s15=MarksG.getText();
            String s16=YearG.getText();
            String s17=Address.getText();
            String s18="0";
            
            if(s1.equals("") || s2.equals("")  ||  s3.equals("")  || s4.equals("") || s6.equals("") || s7.equals("")){
                JOptionPane.showMessageDialog(null,"Enter All Details");
            }else{
            try{
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            String q="insert into student values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"','"+s14+"','"+s15+"','"+s16+"','"+s17+"','"+s18+"')";
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Registration Completed");
            Name.setText("");
            RollNo.setText("");
            FathersName.setText("");
            MothersName.setText("");
            Email.setText("");
            ContactNo.setText("");
            University10.setText("Enter University Name");
            University10.setForeground(Color.gray);
            University12.setText("Enter University Name");
            University12.setForeground(Color.gray);
            UniversityG.setText("Enter University Name");
            UniversityG.setForeground(Color.gray);
            Marks10.setText("Enter Percentage");
            Marks10.setForeground(Color.gray);
            Marks12.setText("Enter Percentage");
            Marks12.setForeground(Color.gray);
            MarksG.setText("Enter Percentage");
            MarksG.setForeground(Color.gray);
            Year10.setText("Enter Passout Year");
            Year10.setForeground(Color.gray);
            Year12.setText("Enter Passout Year");
            Year12.setForeground(Color.gray);
            YearG.setText("Enter Passout Year");
            YearG.setForeground(Color.gray);
            Address.setText("");
            cb1.clearSelection();
             
            
            ca.card.show(ca.cn,"student");
            }catch(Exception e1){
                System.out.println(e1);
                JOptionPane.showMessageDialog(null,e1);
            }
            }
        }
    }
    public boolean show1(){
            return true;
    }
    @Override
    public void itemStateChanged(ItemEvent e){}
    @Override
    public void keyPressed(KeyEvent e){
        if(University10.isFocusOwner())
		{
			String s1=University10.getText();
			if(s1.equals("Enter University Name"))
			{
				University10.setText("");
				University10.setForeground(Color.black);
			}
		}
         if(University12.isFocusOwner())
		{
			String s1=University12.getText();
			if(s1.equals("Enter University Name"))
			{
				University12.setText("");
				University12.setForeground(Color.black);
			}
		}
          if(UniversityG.isFocusOwner())
		{
			String s1=UniversityG.getText();
			if(s1.equals("Enter University Name"))
			{
				UniversityG.setText("");
				UniversityG.setForeground(Color.black);
			}
		}
           if(Marks10.isFocusOwner())
		{
			String s1=Marks10.getText();
			if(s1.equals("Enter Percentage"))
			{
				Marks10.setText("");
				Marks10.setForeground(Color.black);
			}
		}
            if(Marks12.isFocusOwner())
		{
			String s1=Marks12.getText();
			if(s1.equals("Enter Percentage"))
			{
				Marks12.setText("");
				Marks12.setForeground(Color.black);
			}
		}
             if(MarksG.isFocusOwner())
		{
			String s1=MarksG.getText();
			if(s1.equals("Enter Percentage"))
			{
				MarksG.setText("");
				MarksG.setForeground(Color.black);
			}
		}
              if(Year10.isFocusOwner())
		{
			String s1=Year10.getText();
			if(s1.equals("Enter Passout Year"))
			{
				Year10.setText("");
				Year10.setForeground(Color.black);
			}
		}
               if(Year12.isFocusOwner())
		{
			String s1=Year12.getText();
			if(s1.equals("Enter Passout Year"))
			{
				Year12.setText("");
				Year12.setForeground(Color.black);
			}
		}
                if(YearG.isFocusOwner())
		{
			String s1=YearG.getText();
			if(s1.equals("Enter Passout Year"))
			{
				YearG.setText("");
				YearG.setForeground(Color.black);
			}
		}
    }
    
    
    public void keyReleased(KeyEvent e){
        if(University10.isFocusOwner())
		{
			String s1=University10.getText().trim();
			if(s1.equals(""))
			{
				University10.setText("Enter University Name");
				University10.setForeground(Color.gray);
			}
		}
         if(University12.isFocusOwner())
		{
			String s1=University12.getText().trim();
			if(s1.equals(""))
			{
				University12.setText("Enter University Name");
				University12.setForeground(Color.gray);
			}
                        
		}
          if(UniversityG.isFocusOwner())
		{
			String s1=UniversityG.getText().trim();
			if(s1.equals(""))
			{
				UniversityG.setText("Enter University Name");
				UniversityG.setForeground(Color.gray);
			}
			
		}
          if(Marks10.isFocusOwner())
		{
			String s1=Marks10.getText().trim();
			if(s1.equals(""))
			{
				Marks10.setText("Enter Percentage");
				Marks10.setForeground(Color.gray);
			}
			
		}
          if(Marks12.isFocusOwner())
		{
			String s1=Marks12.getText().trim();
			if(s1.equals(""))
			{
				Marks12.setText("Enter Percentage");
				Marks12.setForeground(Color.gray);
			}
		}
          if(MarksG.isFocusOwner())
		{
			String s1=MarksG.getText().trim();
			if(s1.equals(""))
			{
				MarksG.setText("Enter Passout Year");
				MarksG.setForeground(Color.gray);
			}
		}
          if(Year10.isFocusOwner())
		{
			String s1=Year10.getText().trim();
			if(s1.equals(""))
			{
				Year10.setText("Enter Passout Year");
				Year10.setForeground(Color.gray);
			}
		}
          if(Year12.isFocusOwner())
		{
			String s1=Year12.getText().trim();
			if(s1.equals(""))
			{
				Year12.setText("Enter Passout Year");
				Year12.setForeground(Color.gray);
			}
		}
          if(YearG.isFocusOwner())
		{
			String s1=YearG.getText().trim();
			if(s1.equals(""))
			{
				YearG.setText("Enter Passing Year");
				YearG.setForeground(Color.gray);
			}
		}
          
          
    }
    public void keyTyped(KeyEvent e){}
}