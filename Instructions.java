package mcqexammanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Project.ConnectionProvider;

class Instructions extends JPanel implements ActionListener
{
    JButton b1,b2;
    JTextArea ta1;
    JLabel l1;
    ImageIcon img1,img2,img3,img4;
    Image bg;
    Color c1,c2;
    public static  String rollno;
    Instructions()
    {
        setLayout(null);
        Font f1=new Font("Comic Sans MS",Font.BOLD,30);
        Font f2=new Font("Comic Sans MS",Font.BOLD,19);
        Font f3=new Font("Comic Sans MS",Font.BOLD,25);
        c1=new Color(2,134,250);
        c2=new Color(250,159,2);
        
        img1=new ImageIcon(ClassLoader.getSystemResource("Image/indxst.png"));
        img2=new ImageIcon(ClassLoader.getSystemResource("Image/Back.png"));
        img3=new ImageIcon(ClassLoader.getSystemResource("Image/Close.png"));
        img4=new ImageIcon(ClassLoader.getSystemResource("Image/Next.png"));
        bg=img1.getImage();
        setBackground(new Color(206,230,240));
        
        b1=new JButton(img2);
        b1.setBounds(1175,20,120,40);
        b1.setText("Back");
        b1.setBackground(c2);
        b1.setFont(f2);
        add(b1);
        
        b2=new JButton(img4);
        b2.setBounds(600,670,180,50);
        b2.setText("Next");
        b2.setBackground(c2);
        b2.setFont(f2);
        b2.addActionListener(this);
        add(b2);
        
        l1=new JLabel("Instructions");
        l1.setBounds(100,18,300,30);
        l1.setFont(f1);
        add(l1);
        
        ta1=new JTextArea();
        ta1.setBounds(30,90,1310,545);
        ta1.setFont(f3);
        ta1.setText(" During the exam:\n" +
"\n" +
" 1. The student may not use his or her textbook, course notes, or receive help from a\n proctor or any other outside source.\n" +
"\n" +
" 2. Students must complete the 10-question multiple-choice exam within the 10-minute time \n frame allotted for the exam.\n" +
"\n" +
" 3.Students must not stop the session and then return to it. This is especially important\n" +
" in the online environment where the system will time-out and not allow the student Or you \n reenter the exam.\n" +
"\n" +
" Number of Question: 10 \n" +
" Exam Duration: 10 min \n" +
" All the Best!");
        add(ta1);
        ta1.setEditable(false);
        
    }
        Instructions(String s1){
           rollno=s1;
//        JOptionPane.showMessageDialog(this,rollno);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bg,8,7, this);
        g.drawLine(0,70,1360,70);
    }
    @Override
    public void actionPerformed(ActionEvent e){
//        if(e.getSource()==b2){
//      
//        }
    }
}