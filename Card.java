package mcqexammanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.DefaultTableModel;

class Card extends JFrame implements ActionListener
{
	CardLayout card;
	Container cn=getContentPane();
	Index inx;
	Admin ad;
	Amenu am;
	UserFillup usfp;
                     Instructions ins;
                     Test tst;
                     StudentLogin stl;
                     Submitted sub;
	
	Card()
	{
                                         super.setTitle("Exam Management System");
		card=new CardLayout();
		setLayout(card);
		
		inx=new Index();
		add("index",inx);
                
                                         stl=new StudentLogin(this);
                                         add("student",stl);
		
		ad=new Admin();
		add("admin",ad);
		
		am=new Amenu();
		add("amenu",am);
                
                                          usfp=new UserFillup(this);
                                          add("Userfillup",usfp);
                                          
                                          ins=new Instructions();
                                          add("instruction",ins);
                                          
                                          tst=new Test(this);
                                          add("test",tst);
                                          
                                          sub=new Submitted();
                                          add("submit",sub);
		
		inx.b1.addActionListener(this);
		inx.b2.addActionListener(this);
		inx.b3.addActionListener(this);
		ad.b2.addActionListener(this);
		ad.b1.addActionListener(this);
		am.b1.addActionListener(this);
		am.b2.addActionListener(this);
		usfp.b1.addActionListener(this);
		usfp.b2.addActionListener(this);
		ins.b2.addActionListener(this);
		ins.b1.addActionListener(this);
		tst.b2.addActionListener(this);
		sub.b1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
                                         if(e.getSource()==tst.b2){
                                              if(tst.r1.isSelected() || tst.r2.isSelected() || tst.r3.isSelected() || tst.r4.isSelected()) {
                                                               int a=JOptionPane.showConfirmDialog(null,"Do you really want to Submit","Select",JOptionPane.YES_NO_OPTION);
                                                               if(a==0){
                                                               tst.submit();
                                                              card.show(cn,"submit");
                                           }              
                                         }else{
                                                              JOptionPane.showMessageDialog(null,"Please Select any one Option");
                   }
                                         }
                                         if(e.getSource()==sub.b1){
                                                              tst.b1.setVisible(false);                                             
                                                              tst.b2.setVisible(false);
                                                              sub.l1.setVisible(false);
                                                              sub.l2.setVisible(false);
                                                              sub.l3.setVisible(false);
                                                              sub.l4.setVisible(false);
                                                              sub.l5.setVisible(false);
                                                              sub.l6.setVisible(false);
                                                              sub.l7.setVisible(false);
                                                              sub.l8.setVisible(false);
                                                              sub.l9.setVisible(false);
                                                              sub.l10.setVisible(false);
                                                              sub.l11.setVisible(false);
                                                              sub.l12.setVisible(false);
                                                              sub.l13.setVisible(false);
                                                              sub.l14.setVisible(false);
                                                              sub.l15.setVisible(false);
                                                              sub.l16.setVisible(false);
                                                              sub.l17.setVisible(false);
                                                              sub.l18.setVisible(false);
                                                              sub.l19.setVisible(false);
                                                           
                                                              card.show(cn,"index");
                                          }
		if(e.getSource()==inx.b1)
		{
                                                              ad.tx1.setText("");
                                                              ad.px1.setText("");
			card.show(cn,"admin");
		}
                                          if(e.getSource()==usfp.b2)
		{
                                                             stl.tx1.setText("");
                                                             stl.px1.setText("");
		}
                                          if(e.getSource()==ins.b1)
		{
			card.show(cn,"student");
                                                               stl.tx1.setText("");
                                                               stl.px1.setText("");
		}
                                           if(e.getSource()==ins.b2)
		{
			card.show(cn,"test");
		}
                                          if(e.getSource()==inx.b2)
		{
			card.show(cn,"student");
		}
		if(e.getSource()==inx.b3)
		{
			int a=JOptionPane.showConfirmDialog(null,"Do you really want to exit?","Select",JOptionPane.YES_NO_OPTION);
                                                              if(a==0)
                                                              System.exit(0);
		}
		if(e.getSource()==ad.b2)
		{
			card.show(cn,"index");
		}
		if(e.getSource()==ad.b1)
		{
                                                    String s1=ad.tx1.getText();
                                                    String s2=ad.px1.getText();
                                                    if(s1.equals("abc") && s2.equals("123"))
			card.show(cn,"amenu");
                                                    else
                                                        JOptionPane.showMessageDialog(null,"Enter correct Username & Password ");
		}
		if(e.getSource()==am.b2)
		{
			int a=JOptionPane.showConfirmDialog(null,"Do you really want to exit?","Select",JOptionPane.YES_NO_OPTION);
                                                              if(a==0)
                                                              System.exit(0);
		}
		if(e.getSource()==am.b1)
		{
			int a=JOptionPane.showConfirmDialog(null,"Do you really want to Logout?","Select",JOptionPane.YES_NO_OPTION);
                                                              if(a==0)
			card.show(cn,"admin");
                                                               am.add.tx1.setText("");
                                                               am.add.tx2.setText("");
                                                               am.add.tx3.setText("");
                                                               am.add.tx4.setText("");
                                                               am.add.tx5.setText("");
                                                               am.add.tx6.setText("");
                                                               am.add.tx7.setText("");
                                                                am.up.tx1.setText("");
                                                               am.up.tx2.setText("");
                                                               am.up.tx3.setText("");
                                                               am.up.tx4.setText("");
                                                               am.up.tx5.setText("");
                                                               am.up.tx6.setText("");
                                                               am.up.tx7.setText("");
                                                                am.dl.tx1.setText("");
                                                               am.dl.tx2.setText("");
                                                               am.dl.tx3.setText("");
                                                               am.dl.tx4.setText("");
                                                               am.dl.tx5.setText("");
                                                               am.dl.tx6.setText("");
                                                               am.dl.tx7.setText("");
                                                               ad.tx1.setText("");
                                                               ad.px1.setText("");
                                                               
                                                                DefaultTableModel dm = (DefaultTableModel)am.als.table.getModel();
                                                                dm.getDataVector().removeAllElements();
                                                                revalidate();
                                                                
                                                                 DefaultTableModel dm1 = (DefaultTableModel)am.alq.table.getModel();
                                                                dm1.getDataVector().removeAllElements();
                                                                revalidate();
		}
                                         if(e.getSource()==usfp.b1){
                                             card.show(cn,"student");
                                             stl.tx1.setText("");
                                             stl.px1.setText("");
                                             usfp.cb1.clearSelection();
                                             usfp.Name.setText("");
                                             usfp.RollNo.setText("");
                                             usfp.FathersName.setText("");
                                             usfp.MothersName.setText("");
                                             usfp.Email.setText("");
                                             usfp.ContactNo.setText("");
                                             usfp.University10.setText("Enter University Name");
                                             usfp.University10.setForeground(Color.gray);
                                             usfp.University12.setText("Enter University Name");
                                             usfp.University12.setForeground(Color.gray);
                                             usfp.UniversityG.setText("Enter University Name");
                                             usfp.UniversityG.setForeground(Color.gray);
                                             usfp.MarksG.setText("Enter Percentage");
                                             usfp.MarksG.setForeground(Color.gray);
                                             usfp.Marks12.setText("Enter Percentage");
                                             usfp.Marks12.setForeground(Color.gray);
                                             usfp.Marks10.setText("Enter Percentage");
                                             usfp.Marks10.setForeground(Color.gray);
                                             usfp.Year10.setText("Enter Passout Year");
                                             usfp.Year10.setForeground(Color.gray);
                                             usfp.Year12.setText("Enter Passout Year");
                                             usfp.Year12.setForeground(Color.gray);
                                             usfp.YearG.setText("Enter Passout Year");
                                             usfp.YearG.setForeground(Color.gray);
                                             usfp.Address.setText("");
                                         }
	
	}
}
class demo9292
{
	public static void main(String ab[])
	{
                                         int x,y;
                                         Toolkit t = Toolkit.getDefaultToolkit();
                                         Image i=t.getImage(ClassLoader.getSystemResource("Image/exam.png"));                                         
		Card m=new Card();
                                         m.setIconImage(i);
		m.setSize(1380,825);
		m.setLocation(300,100);
		m.setVisible(true);
		m.setDefaultCloseOperation(m.EXIT_ON_CLOSE);
	}
}