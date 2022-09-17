package mcqexammanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Submitted extends JPanel implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22;
    JButton b1,b2;
    static int m;
    ImageIcon img1,img2,img3,img4,img5;
    Image res,res1,fail,pass,done;
    Color c1,c2,c3;
    static int marks,sec,min;
    static String rollno;
    boolean b,c=true;
    
    
    Submitted(){
        
        setLayout(null);
//        setBackground(new Color(206,230,240));
        c1=new Color(2,134,250);
        c2=new Color(250,159,2);
        Font f1=new Font("Comic Sans MS",Font.BOLD,22);
        Font f2=new Font("Comic Sans MS",Font.BOLD,18);
        Font f3=new Font("Comic Sans MS",Font.BOLD,30);
        img1=new ImageIcon(ClassLoader.getSystemResource("Image/result.png"));
        res=img1.getImage().getScaledInstance(1380,885,Image.SCALE_DEFAULT);
        img2=new ImageIcon(ClassLoader.getSystemResource("Image/fail.png"));
        fail=img2.getImage().getScaledInstance(150,40,Image.SCALE_DEFAULT);
        img3=new ImageIcon(ClassLoader.getSystemResource("Image/pass.png"));
        pass=img3.getImage().getScaledInstance(150,55,Image.SCALE_DEFAULT);
        img4=new ImageIcon(ClassLoader.getSystemResource("Image/done.png"));
        done=img4.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        img5=new ImageIcon(ClassLoader.getSystemResource("Image/blue.jpg"));
        res1=img5.getImage().getScaledInstance(1380,885,Image.SCALE_DEFAULT);
       
        
        l2=new JLabel("Roll Number:");
        l2.setBounds(450,175,300,40);
        l2.setForeground(Color.black);
        l2.setFont(f1);
        add(l2);
        l2.setVisible(false);
        
        l3=new JLabel("Time Taken:");
        l3.setBounds(450,220,300,40);
        l3.setForeground(Color.black);
        l3.setFont(f1);
        add(l3);
        l3.setVisible(false);
        
        l4=new JLabel("Total Questions:");
        l4.setBounds(450,265,300,40);
        l4.setFont(f1);
        l4.setForeground(Color.black);
        add(l4);
        l4.setVisible(false);
        
        l5=new JLabel("Attempted Questions:");
        l5.setBounds(450,310,300,40);
        l5.setFont(f1);
        l5.setForeground(Color.black);
        add(l5);
        l5.setVisible(false);
        
        l6=new JLabel("Correct Questions:");
        l6.setBounds(450,355,300,40);
        l6.setFont(f1);
        l6.setForeground(Color.black);
        add(l6);
        l6.setVisible(false); 
        
        l7=new JLabel("Wrong Questions:");
        l7.setBounds(450,400,300,40);
        l7.setFont(f1);
        l7.setForeground(Color.black);
        add(l7);
        l7.setVisible(false); 
        
        l8=new JLabel("Marks Obtained:");
        l8.setBounds(450,445,300,40);
        l8.setFont(f1);
        l8.setForeground(Color.black);
        add(l8);
        l8.setVisible(false); 
        
        l9=new JLabel("Total Marks:");
        l9.setBounds(450,490,300,40);
        l9.setFont(f1);
        l9.setForeground(Color.black);
        add(l9);
        l9.setVisible(false); 
        
        l10=new JLabel("Percentage:");
        l10.setBounds(450,535,300,40);
        l10.setFont(f1);
        l10.setForeground(Color.black);
        add(l10);
        l10.setVisible(false); 
        
        // roll no.
        l1=new JLabel();
        l1.setBounds(820,175,300,40);
        l1.setFont(f1);
        l1.setForeground(Color.black);
        add(l1);
        l1.setVisible(false); 
        
        //time taken min
        l11=new JLabel("00");
        l11.setBounds(820,220,40,40);
        l11.setFont(f1);
        l11.setForeground(Color.black);
        add(l11);
        l11.setVisible(false); 
        
        //time taken sec
        l12=new JLabel("00");
        l12.setBounds(850,220,40,40);
        l12.setFont(f1);
        l12.setForeground(Color.black);
        add(l12);
        l12.setVisible(false); 
        
        //total ques
        l13=new JLabel("10");
        l13.setBounds(820,265,50,40);
        l13.setFont(f1);
        l13.setForeground(Color.black);
        add(l13);
        l13.setVisible(false); 
        
        //attempted ques
        l14=new JLabel("00");
        l14.setBounds(820,310,50,40);
        l14.setFont(f1);
        l14.setForeground(Color.black);
        add(l14);
        l14.setVisible(false); 
        
        //correct ques
        l15=new JLabel("00");
        l15.setBounds(820,355,50,40);
        l15.setFont(f1);
        l15.setForeground(Color.black);
        add(l15);
        l15.setVisible(false); 
        
        //wrong ques
        l16=new JLabel("00");
        l16.setBounds(820,400,50,40);
        l16.setFont(f1);
        l16.setForeground(Color.black);
        add(l16);
        l16.setVisible(false); 
        
        //marks obtained
        l17=new JLabel("");
        l17.setBounds(820,445,50,40);
        l17.setFont(f1);
        l17.setForeground(Color.black);
        add(l17);
        l17.setVisible(false); 
        
        //total marks
        l18=new JLabel("10");
        l18.setBounds(820,490,50,40);
        l18.setFont(f1);
        l18.setForeground(Color.black);
        add(l18);
        l18.setVisible(false); 
        
        //percentage
        l19=new JLabel();
        l19.setBounds(820,535,70,50);
        l19.setFont(f1);
        l19.setForeground(Color.black);
        add(l19);
        l19.setVisible(false); 
        
         b1=new JButton("Back");
         b1.setBounds(600,685,200,60);
         b1.setBackground(c2);
         b1.setFont(f2);
         add(b1);
         b1.setVisible(false);
         b1.addActionListener(this);
         
         b2=new JButton("Show Result");
         b2.setBounds(580,665,180,60);
         b2.setBackground(c2);
         b2.setFont(f2);
         b2.addActionListener(this);
         add(b2);
         
         l20=new JLabel("Succesfully Submitted");
         l20.setBounds(500,405,500,100);
         l20.setFont(f3);
         add(l20);
         
         l21=new JLabel(img4);
         l21.setBounds(530,165,240,300);
         l21.setFont(f3);
         add(l21);
         
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
            g.drawImage(res1, 0,0,this);
        if(b){
        g.drawImage(res,0,0,this);
        String s1=l17.getText();
        int x=Integer.parseInt(s1);
         if(x<=4)
        g.drawImage(fail,600,600,this);
        else
        g.drawImage(pass,600,600,this);
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b2){
             l17.setText(""+Test.marks);
             l11.setText(""+Test.min+":");
             l12.setText(""+Test.sec);
             l15.setText(""+Test.marks);// correct ques
             int x=Integer.parseInt(Test.l15.getText());
             l14.setText(""+x);// attempted ques
             int y=x-Test.marks;
             l16.setText(""+y);// wrong ques
             int p=Test.marks;
             double p1=(double)p/10*100;
             l19.setText(p1+"%");// percentage
             l1.setText(Test.rollNo);
             
            Test.marks=0;
            Test.min=0;
            Test.sec=0;
            Test.questionId="1";
            Test.count=0;
            Test.l15.setText("");
             setBackground(Color.white);
             b=true;
             repaint();
             b2.setVisible(false);
             b1.setVisible(true);
             l21.setVisible(false);
             l20.setVisible(false);
             l1.setVisible(true);
             l2.setVisible(true);
             l3.setVisible(true);
             l4.setVisible(true);
             l5.setVisible(true);
             l6.setVisible(true);
             l7.setVisible(true);
             l8.setVisible(true);
             l9.setVisible(true);
             l10.setVisible(true);
             l11.setVisible(true);
             l12.setVisible(true);
             l13.setVisible(true);
             l14.setVisible(true);
             l15.setVisible(true);
             l16.setVisible(true);
             l17.setVisible(true);
             l18.setVisible(true);
             l19.setVisible(true);
        }
        if(e.getSource()==b1){
             setBackground(new Color(206,230,240));
             b=false;
             repaint();
             b2.setVisible(true);
             b1.setVisible(false);
             l21.setVisible(true);
             l20.setVisible(true);
             l1.setVisible(false);
             l2.setVisible(false);
             l3.setVisible(false);
             l4.setVisible(false);
             l5.setVisible(false);
             l6.setVisible(false);
             l7.setVisible(false);
             l8.setVisible(false);
             l9.setVisible(false);
             l10.setVisible(false);
             l11.setVisible(false);
             l12.setVisible(false);
             l13.setVisible(false);
             l14.setVisible(false);
             l15.setVisible(false);
             l16.setVisible(false);
             l17.setVisible(false);
             l18.setVisible(false);
             l19.setVisible(false);
             
        }
    }
}