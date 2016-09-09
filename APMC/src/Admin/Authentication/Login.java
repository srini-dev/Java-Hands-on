/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Login.java
 *
 * Created on Jul 16, 2014, 4:59:54 PM
 */

package Admin.Authentication;

import APMCMain.MainFrm;
import java.awt.Toolkit;
import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Login extends javax.swing.JFrame {
    Connection conn=null;
    String t1,t2;
    boolean flag=false;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    List lst=null;
    public Login() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Banjara Jewellery Shop");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Admin\\Authentication\\1.png"));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btncls = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtuid = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtp = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 51));

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 0));
        jLabel1.setText("A.P.M.C");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setOpaque(false);

        btncls.setFont(new java.awt.Font("Tahoma", 1, 12));
        btncls.setText("CLOSE");
        btncls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclsActionPerformed(evt);
            }
        });
        btncls.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnclsKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("Password");

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("Login ID");

        txtuid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtuidKeyPressed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });

        txtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpActionPerformed(evt);
            }
        });
        txtp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtp)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncls))
                    .addComponent(txtuid))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncls)
                    .addComponent(btnLogin))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("Developed By SAN Technologies");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnclsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclsActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnclsActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        logIn();
    }//GEN-LAST:event_btnLoginActionPerformed

    public void logIn()
    {
        t1=txtuid.getText();
        t2=txtp.getText();
        Admin.AdminService srv=new Admin.AdminService();

        boolean b=validation(t1,t2);
        if(b)
        {
                boolean flag=false;
                flag=srv.validateLogin(t1, t2);
                if(flag)
                {
                  try{new MainFrm();}catch(IOException ie){}this.setVisible(false);
                }
                else
                {JOptionPane.showMessageDialog(null,"Invalid User Id or Password");}
        }
    }
//----------------------counting no--------------------------------------------
    int cnt;
    public void countlogs() throws IOException
    {
        getNextno();
        if(cnt<=10)
        {
              boolean flag=false;
              String inp=String.valueOf(cnt);
              flag=savecst(inp);
              if(flag)
              {
                  try{new MainFrm();}catch(IOException ie){}this.setVisible(false);
              }else{System.out.println("Error counting");}
        }else{this.setVisible(false);JOptionPane.showMessageDialog(this, "Sorry This Software Cant Open Please Contact Administrator");}
        
    }
    public boolean savecst(String inp)
    {
        try
        {
            Double a=0.0;
           // conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into count values(?)");
            ps.setString(1, inp);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
    public void getNextno()
    {
        List ls=null;
        ls=getNxtN();
        int cod=ls.size();
        int nxt=cod+1;
        cnt=nxt;
    }
    public List getNxtN()
    {
        lst= new LinkedList();
        try
        {
           // conn=new DBConnect().GetConnetion();
            String cod;
            ps= conn.prepareStatement("SELECT number FROM count");
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("number");
                lst.add(cod);
            }
        }catch(Exception e)
        {System.out.println("error getting"+e);}
        finally{try{conn.close();System.out.println("close...");}catch(Exception e1){System.out.println("........."+e1);}}
        return lst;
    }
 //--------------------------------------counting ends-------------------------------------
    private void txtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpActionPerformed

    private void txtuidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuidKeyPressed
         int a = evt.getKeyCode();
        if (a == 10)
        { txtp.requestFocus();}// for enter key
       if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
	   txtp.requestFocus();
           }
    }//GEN-LAST:event_txtuidKeyPressed

    private void txtpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpKeyPressed
         int a = evt.getKeyCode();
        if (a == 10)
        { btnLogin.requestFocus();}// for enter key
       if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
	   txtuid.requestFocus();
        }
    }//GEN-LAST:event_txtpKeyPressed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
         int a = evt.getKeyCode();
        if (a == 10)
        { btnLogin.doClick();}// for enter key
       if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
	   txtp.requestFocus();
        }
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) {
	   btncls.requestFocus();
        }
    }//GEN-LAST:event_btnLoginKeyPressed

    private void btnclsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnclsKeyPressed
        int a = evt.getKeyCode();
        if (a == 10)
        {System.exit(0);}// for enter key
       if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
	   txtp.requestFocus();
        }
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) {
	   btnLogin.requestFocus();
        }
    }//GEN-LAST:event_btnclsKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btncls;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtp;
    private javax.swing.JTextField txtuid;
    // End of variables declaration//GEN-END:variables

    public boolean validation(String t1,String t2)
    {
       if(t1.length()==0)
       {JOptionPane.showMessageDialog(null,"User Id Should Not be Blank");
       return false;}
       else if(t2.length() == 0 )
       {JOptionPane.showMessageDialog(null,"Password Should Not be Blank");
        return false;}

       if(t1.equals("admin") && t2.equals("user123")){return true;}
 else
       {
           return false;}

        
    }
}
