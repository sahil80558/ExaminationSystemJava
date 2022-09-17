package mcqexammanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;
import java.sql.*;
import Project.ConnectionProvider;

class Test extends JPanel implements ActionListener,ItemListener{
   
    public JButton b1,b2,b3;
    Color c1,c2,c3,c4;
    ImageIcon img1,img2,img3,img4;
    public static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
    Image bg;
    public  JRadioButton r1,r2,r3,r4;
    ButtonGroup bg1;
    public String rolln;
    public static String questionId="1";
    public String answer;
    static int min=0;
    static int sec=0;
    static int  marks=0;
    static String rollNo;
    static int count;
    Timer time;
    Card cd1;
    JComboBox cb1;
    boolean ar[]=new boolean[10];
    
     public void answerCheck(){
         // marks increment if right
          int x=Integer.parseInt(l15.getText());
//            if(ar[x]==false){
         String studentAnswer="";
         if(r1.isSelected()){
             studentAnswer=r1.getText();
         }
         else if(r2.isSelected()){
             studentAnswer=r2.getText();
         }
         else if(r3.isSelected()){
             studentAnswer=r3.getText();
         }
         else{
             studentAnswer=r4.getText();
         }
         if(studentAnswer.equals(answer)){
             marks=marks+1;
             String marks1=String.valueOf(marks);
             l17.setText(marks1);
             count++;
//             ar[x]=true;
         }
//            }
//            if(ar[x]==true){
//               String studentAnswer="";
//         if(r1.isSelected()){
//             studentAnswer=r1.getText();
//         }
//         else if(r2.isSelected()){
//             studentAnswer=r2.getText();
//         }
//         else if(r3.isSelected()){
//             studentAnswer=r3.getText();
//         }
//         else{
//             studentAnswer=r4.getText();
//         }
//         if(!studentAnswer.equals(answer)){
//             marks=marks-1;
//             String marks1=String.valueOf(marks);
//             l17.setText(marks1);
//             ar[x]=false;
//         }
//         }
         // question no. change
         int questionId1=Integer.parseInt(questionId);
         questionId1=questionId1+1;
         questionId=String.valueOf(questionId1);
         r1.setSelected(false);
         r2.setSelected(false);
         r3.setSelected(false);
         r4.setSelected(false);
         // last ques hide next button
         if(questionId.equals("10")){
             b1.setVisible(false);
         }
     }
     public void question(){
         try{
             Connection con=ConnectionProvider.getCon();
             Statement st=con.createStatement();
              String q2="select * from ques where ID='"+questionId+"'";
            ResultSet rs2=st.executeQuery(q2);
            while(rs2.next()){
                l15.setText(rs2.getString(1));
                l18.setText(rs2.getString(2));
                r1.setText(rs2.getString(3));
                r2.setText(rs2.getString(4));
                r3.setText(rs2.getString(5));
                r4.setText(rs2.getString(6));
                answer=rs2.getString(7);
                bg1.clearSelection();
            }
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
     }
     public void submit(){
         b1.setVisible(true);
         cb1.setVisible(false);
        l20.setVisible(false);
        cb1.setSelectedIndex(0);
         rollNo=l9.getText();
         answerCheck();
             for(int i=0;i<=9;i++){
             ar[i]=false;
         }
//         new Submitted();
         try{
             Connection con=ConnectionProvider.getCon();
             Statement st=con.createStatement();
             String q="update student set marks='"+marks+"' where rollNo='"+rolln+"'";
             st.executeUpdate(q);
             String marks1=String.valueOf(marks);
//             JOptionPane.showMessageDialog(null, marks1);
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         
//         marks=0;
//            min=0;
//            sec=0;
//            questionId="1";
            rolln="";
            answer="";
            time.stop();
            l19.setText("");
            l9.setText("");
            l11.setText("");
            l17.setText("");
            l18.setText("");
            r1.setText("");
            r2.setText("");
            r3.setText("");
            r4.setText("");
            bg1.clearSelection();
//            setVisible(false);
     }
     
    Test(Card ca){
        
        setLayout(null);
        Font f1=new Font("Comic Sans MS",Font.BOLD,33);
        Font f2=new Font("Comic Sans MS",Font.BOLD,21);
        Font f4=new Font("Comic Sans MS",Font.BOLD,20);
        Font f3=new Font("Comic Sans MS",Font.BOLD,19);

        c1=new Color(2,134,250);
        c2=new Color(250,159,2);
        c3=new Color(229, 255, 0);
        c4=new Color(255, 136, 71);
        this.cd1=ca;
        
        setBackground(new Color(206,230,240));
        
        img1=new ImageIcon(ClassLoader.getSystemResource("Image/indxst.png"));
        img2=new ImageIcon(ClassLoader.getSystemResource("Image/Next.png"));
        img3=new ImageIcon(ClassLoader.getSystemResource("Image/Close.png"));
        img4=new ImageIcon(ClassLoader.getSystemResource("Image/save.png"));
        bg=img1.getImage();
        
        for(int i=0;i<=9;i++){
             ar[i]=false;
         }
        
        cb1=new JComboBox();
        cb1.setBounds(235,420,60,30);
        cb1.setFont(f3);
//        add(cb1);
        for(int i=1;i<=10;i++){
            cb1.addItem(""+i);
        }
        cb1.setVisible(false);
        cb1.setSelectedIndex(0);
        cb1.addItemListener(this);
         
        l20=new JLabel("Jump to Question");
        l20.setBounds(18,420,300,30);
        l20.setFont(f2);
        l20. setForeground(c3);
//        add(l20);
        l20.setVisible(false);
        
        l1=new JLabel("Welcome");
        l1.setBounds(85,18,300,30);
        l1.setFont(f1);
        l1. setForeground(c3);
        add(l1);
        
        l2=new JLabel("Date:");
        l2.setBounds(840,22,60,30);
        l2.setFont(f3);
        l2. setForeground(c3);
        add(l2);
        
        DateTimeFormatter dF= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now=LocalDateTime.now();
        
        l3=new JLabel("");
        l3.setBounds(900,22,150,30);
        l3.setFont(f3);
        l3.setText(dF.format(now));
        l3. setForeground(c3);
        add(l3);
        
        l4=new JLabel("Total Time:");
        l4.setBounds(1100,13,120,30);
        l4.setFont(f3);
        l4. setForeground(c3);
        add(l4);
        
        l5=new JLabel("Time Taken:");
        l5.setBounds(1100,48,120,30);
        l5.setFont(f3);
        l5. setForeground(c3);
        add(l5);
        
        l6=new JLabel("10 Min");
        l6.setBounds(1225,13,150,30);
        l6.setFont(f3);
        l6. setForeground(c3);
        add(l6);
        
        l7=new JLabel("00");
        l7.setBounds(1225,48,30,30);
        l7.setFont(f3);
        l7. setForeground(Color.red);
        add(l7);
        
        l19=new JLabel();
        l19.setBounds(1255,48,30,30);
        l19.setFont(f3);
        l19. setForeground(Color.red);
        add(l19);
        
        l8=new JLabel("Roll Number:");
        l8.setBounds(18,150,140,30);
        l8.setFont(f2);
        l8. setForeground(c3);
        add(l8);
        
        //Roll No.
        l9=new JLabel("");
        l9.setBounds(163,150,150,30);
        l9.setFont(f2);
        l9. setForeground(c4);
        add(l9);
        
         l10=new JLabel("Name:");
        l10.setBounds(18,190,75,30);
        l10.setFont(f2);
        l10. setForeground(c3);
        add(l10);
        
        //Name
        l11=new JLabel("");
        l11.setBounds(94,190,250,30);
        l11.setFont(f2);
        l11. setForeground(c4);
        add(l11);
        
        l12=new JLabel("Total Question:");
        l12.setBounds(18,230,210,30);
        l12.setFont(f2);
        l12. setForeground(c3);
        add(l12);
        
        //Total Ques
        l13=new JLabel("10");
        l13.setBounds(235,230,210,30);
        l13.setFont(f2);
        l13. setForeground(c4);
        add(l13);
        
        l14=new JLabel("Question Number:");
        l14.setBounds(18,270,210,30);
        l14.setFont(f2);
        l14. setForeground(c3);
        add(l14);
        
        //Ques No.
        l15=new JLabel("00");
        l15.setBounds(235,270,210,30);
        l15.setFont(f2);
        l15. setForeground(c4);
        add(l15);
        
        l16=new JLabel("Marks Obtained:");
        l16.setBounds(18,310,210,30);
        l16.setFont(f2);
        l16. setForeground(c3);
        add(l16);
        
        //Marks
        l17=new JLabel("00");
        l17.setBounds(235,310,210,30);
        l17.setFont(f2);
        l17. setForeground(c4);
        add(l17);
        
        l18=new JLabel("Q.");
        l18.setBounds(380,20,900,300);
        l18.setFont(f2);
//        l18. setForeground(c4);
        add(l18);
        
        bg1=new ButtonGroup();
        
        r1=new JRadioButton();
        r1.setBounds(380,250,900,60);
        r1.setFont(f2);
        bg1.add(r1);
        add(r1);
        
        r2=new JRadioButton();
        r2.setBounds(380,320,900,60);
        r2.setFont(f2);
        bg1.add(r2);
        add(r2);
        
        r3=new JRadioButton();
        r3.setBounds(380,390,900,60);
        r3.setFont(f2);
        bg1.add(r3);
        add(r3);
        
        r4=new JRadioButton();
        r4.setBounds(380,460,900,60);
        r4.setFont(f2);
        bg1.add(r4);
        add(r4);
              
        b1=new JButton(img2);
        b1.setBounds(530,600,140,45);
        b1.setText("Next");
        b1.setBackground(c2);
        b1.setFont(f4);
        add(b1);
        b1.addActionListener(this);
        b1.setVisible(false);
        
        b2=new JButton(img4);
        b2.setBounds(1030,600,140,45);
        b2.setText("Submit");
        b2.setBackground(c2);
        b2.setFont(f4);
        add(b2);
        b2.setVisible(false);
//        b2.addActionListener(ca);
        
        b3=new JButton();
        b3.setBounds(70,600,200,45);
        b3.setText("Start Test");
        b3.setBackground(c2);
        b3.setFont(f4);
        add(b3);
        b3.addActionListener(this);
        
    }
    public void dis(){
        b1.setVisible(true);
        b2.setVisible(true);
        cb1.setVisible(true);
        l20.setVisible(true);
         rolln=Instructions.rollno;
        l9.setText(rolln);
        //first ques and student details
        try{
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            String q="select * from student where rollNo='"+rolln+"' ";
            ResultSet rs=st.executeQuery(q);
            while(rs.next()){
                l11.setText(rs.getString(2));
            }
            String q2="select * from ques where ID='"+questionId+"'";
            ResultSet rs2=st.executeQuery(q2);
            while(rs2.next()){
                l15.setText(rs2.getString(1));
                l18.setText(rs2.getString(2));
                r1.setText(rs2.getString(3));
                r2.setText(rs2.getString(4));
                r3.setText(rs2.getString(5));
                r4.setText(rs2.getString(6));
                answer=rs2.getString(7);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        // timer
           time=new Timer(1000,new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e){
                   l19.setText(String.valueOf(sec));
                   l7.setText(String.valueOf(min));
                   
                   if(sec==60){
                       sec=0;
                       min++;
                       if(min==5){
                           time.stop();
                           submit();
                           cd1.card.show(cd1.cn,"submit");
                       }
                   }
                   sec++;
               }
           });
           time.start();
    }
     @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b3){
            dis();
        }
        if(e.getSource()==b1){
            if(r1.isSelected() || r2.isSelected() || r3.isSelected() || r4.isSelected()){
//             int x=Integer.parseInt(questionId);
//            System.out.println(x);
//            cb1.setSelectedIndex(x);
            answerCheck();
            question();
            }else{
                JOptionPane.showMessageDialog(null,"Please select any one option");
            }
        }
//        if(e.getSource()==b2){
//            
//        }
    }
     @Override
    public void itemStateChanged(ItemEvent e){
       if (e.getStateChange() == ItemEvent.SELECTED) {
          Object item = e.getItem();
       String s1=(String)item;
       questionId=s1;
       
       try{
       Connection con=ConnectionProvider.getCon();
       Statement st=con.createStatement();
                     String q2="select * from ques where ID='"+questionId+"'";
            ResultSet rs2=st.executeQuery(q2);
            while(rs2.next()){
                l15.setText(rs2.getString(1));
                l18.setText(rs2.getString(2));
                r1.setText(rs2.getString(3));
                r2.setText(rs2.getString(4));
                r3.setText(rs2.getString(5));
                r4.setText(rs2.getString(6));
                answer=rs2.getString(7);
                bg1.clearSelection();
            }
       }catch(Exception e1){
           System.out.println(e1);
           JOptionPane.showMessageDialog(null,e1);
       }
       
       }
    }
     @Override
    public void paintComponent(Graphics g){
       
        super.paintComponent(g);
        g.setColor(new Color(55, 102, 138));
        g.fillRect(0, 0, 1380, 100);
        g.fillRect(0, 0, 350, 825);
        g.drawImage(bg,8,7, this);
//        g.drawLine(0,100,400,100);
    }
}
