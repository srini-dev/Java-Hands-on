/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.Forms;
import Admin.MetalRate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import  Sales.*;

import Mescellanious.*;
import java.awt.Toolkit;



/**
 *
 * @author Vicky
 */
public class MainMenu implements ActionListener
{

    private static void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         public JFrame Mainfm=new JFrame();
         JPanel PanelfirstMenu=new JPanel();
         public static  JPanel PanelsecoundMenu=new JPanel();
         public static  JPanel PanelInfo=new JPanel();
         JButton btnSales,btnPurchase,btnMescellinous,btnMaster,btnadmin,btnReport,btnhome;
         public  static JPanel pnlstdhelp;
         JLabel l1,l2,l3,l4,l5,l6l,l7,l8,l9;
         public MainMenu() throws IOException
         {
            Mainfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            Mainfm.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Admin\\Authentication\\1.png"));
            Mainfm.setTitle(MetalRate.titl);
            Mainfm.setSize(1024, 980);
         
       
        pnlstdhelp=new HomePnl();
        setMainPanel(pnlstdhelp);
        // JPanel p1=new samplecollegedemo.pnlCollegeInfo();
         //setInfoPanel(p1);

        Mainfm.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        Mainfm.setLayout(new BorderLayout());
        
        Mainfm.getContentPane().add(BorderLayout.NORTH,PanelfirstMenu);
        Mainfm.getContentPane().add(BorderLayout.CENTER,PanelsecoundMenu);
        Mainfm.getContentPane().add(BorderLayout.SOUTH,PanelInfo);  
        
        l1=new JLabel("Developed By");
        l2=new JLabel("SAN TECHNOLOGIES");
         l1.setFont(new java.awt.Font("Times New Roman", 1, 18));
         l2.setFont(new java.awt.Font("Times New Roman", 1, 24));
         l1.setForeground(Color.yellow);
         l2.setForeground(Color.YELLOW);
        PanelInfo.add(l1);

        PanelInfo.add(l2);
        

        PanelfirstMenu.setPreferredSize(new Dimension(1024, 30));
        PanelsecoundMenu.setPreferredSize(new Dimension(1024, 550));
        PanelInfo.setPreferredSize(new Dimension(1024, 530));
        PanelfirstMenu.setLayout(new BoxLayout(PanelfirstMenu, BoxLayout.X_AXIS));
        
       // Graphics g=new Graphics();
         // g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        
        PanelfirstMenu.setBackground(Color.LIGHT_GRAY);
        PanelsecoundMenu.setBackground(Color.GRAY);
        PanelInfo.setBackground(Color.GRAY);
        
       // btnstudent= new JButton("Student");
      //  ImageIcon start = new ImageIcon("images.group.png");
        btnSales=new JButton(" Sales ");
        btnSales.setSize(150,100);
        btnPurchase=new JButton(" Purchase ");
        btnPurchase.setSize(150,100);
       btnMescellinous=new JButton("Mescellanious Details");
        btnMaster=new JButton("  Master   ");
        btnadmin=new JButton("Administration");
         btnReport  = new JButton(" Report ");
         btnhome=new JButton("  Home  ");         
         btnhome.addActionListener(this);
         btnSales.addActionListener( this);
         btnPurchase.addActionListener( this);
         btnMescellinous.addActionListener( this);
         btnMaster.addActionListener( this);
         btnadmin.addActionListener( this);
         btnReport.addActionListener( this);
         
         
         PanelfirstMenu.add(Box.createRigidArea(new Dimension(35,0)));
         btnhome.setBounds(0, 0, 200, 50);
        PanelfirstMenu.add(btnhome);
         
         
        PanelfirstMenu.add(Box.createRigidArea(new Dimension(25,0)));
         btnSales.setBounds(0, 0, 200, 50);
        PanelfirstMenu.add(btnSales);
        
        btnPurchase.setBounds(0, 0, 200, 50);
        PanelfirstMenu.add(Box.createRigidArea(new Dimension(25,0)));
      //  PanelfirstMenu.add( btnPurchase);
        
        btnMescellinous.setSize(250,30);
        PanelfirstMenu.add(Box.createRigidArea(new Dimension(25,0)));
        //PanelfirstMenu.add(btnMescellinous);
        
        PanelfirstMenu.add(Box.createRigidArea(new Dimension(25,0)));
       // PanelfirstMenu.add(btnMaster);
        
        PanelfirstMenu.add(Box.createRigidArea(new Dimension(25,0)));
        //PanelfirstMenu.add(btnadmin);
        
        PanelfirstMenu.add(Box.createRigidArea(new Dimension(25,0)));
        //PanelfirstMenu.add(btnReport);
        shoDayRepo();
          
        Mainfm.setVisible(true);
         }

         public void shoDayRepo()
        {
             PanelInfo.removeAll();
            PanelInfo.repaint();
            pnlstdhelp= new DayReport();

            firstset(pnlstdhelp);

         }
         public void firstset(JPanel subPanel)
        {
            JPanel PanelInfo=  Admin.Forms.MainMenu.PanelInfo;
            PanelInfo.removeAll();
            PanelInfo.add(subPanel);
            PanelInfo.validate();
            PanelInfo.repaint();
         }
           @Override
    public void actionPerformed(ActionEvent e)
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      if(e.getSource()==btnhome)
      {
         PanelInfo.removeAll();
         PanelInfo.repaint();
         PanelsecoundMenu.removeAll();  /* remove and refresh*/
         PanelsecoundMenu.repaint();                                  
         pnlstdhelp = new HomePnl();
         setMainPanel(pnlstdhelp);
         PanelInfo.add(l1);
        PanelInfo.add(l2);
         pnlstdhelp= new DayReport();
         firstset(pnlstdhelp);
        // PanelInfo.setBackground(Color.LIGHT_GRAY);
      }        
        if(e.getSource()==btnSales)
   {
      Admin.Forms.MainMenu.PanelInfo.removeAll();
      Admin.Forms.MainMenu.PanelInfo.repaint();
      pnlstdhelp= new Sales.SalesToolbar();
       
      setMainPanel(pnlstdhelp);
       PanelInfo.add(l1);
        PanelInfo.add(l2);
   }
    
   if(e.getSource()==btnPurchase)
   {
       PanelInfo.removeAll();
       PanelInfo.repaint();
      pnlstdhelp= new Purchase.PurchaseToolBar();
       
      setMainPanel(pnlstdhelp);
       PanelInfo.add(l1);
        PanelInfo.add(l2);
   }
    
   if(e.getSource()==btnMescellinous)
   { PanelInfo.removeAll();
       PanelInfo.repaint();
       
      pnlstdhelp= new Mescellanious.Mescellanious_Toolbar();
       
      setMainPanel(pnlstdhelp);
       PanelInfo.add(l1);
        PanelInfo.add(l2);
   }
    
   if(e.getSource()==btnMaster)
   {
        PanelInfo.removeAll();
       PanelInfo.repaint();
      pnlstdhelp= new Master.Master_Toolbar();
       
      setMainPanel(pnlstdhelp);
       PanelInfo.add(l1);
        PanelInfo.add(l2);
   }
    
   if(e.getSource()==btnadmin)
   {
        PanelInfo.removeAll();
       PanelInfo.repaint();
      pnlstdhelp= new Admin.PanelAdmin();
       
      setMainPanel(pnlstdhelp);
       PanelInfo.add(l1);
        PanelInfo.add(l2);
   }
   
   if(e.getSource()==btnReport)
   {
        PanelInfo.removeAll();
       PanelInfo.repaint();
      //pnlstdhelp= new Report.AttendPanel();
      setMainPanel(pnlstdhelp);
       PanelInfo.add(l1);
        PanelInfo.add(l2);
   }
    
    
    }
    
    public static void setMainPanel(JPanel subPanel) {
        PanelsecoundMenu.removeAll();
        PanelsecoundMenu.add(subPanel);
        PanelsecoundMenu.validate();
        PanelsecoundMenu.repaint();
    }
     public static void setInfoPanel(JPanel subPanel) {
        PanelInfo.removeAll();
        PanelInfo.add(subPanel);
        PanelInfo.validate();
        PanelInfo.repaint();
    }
    
     public static void main(String[] args) throws IOException
    {
      MainMenu obj=new MainMenu();
      
    }
}