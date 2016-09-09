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

import Admin.Forms.MainMenu;
import Admin.Forms.MyFont;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Login extends javax.swing.JFrame {

    String t1,t2;
    public Login() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("");
        MyFont.setUIFont (new javax.swing.plaf.FontUIResource ("Akshar Unicode",Font.BOLD,16));
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

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Akshar Unicode", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SSJ ಒತ್ತಿ ಕಲಮ್");

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("Password");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnLogin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btncls))
                        .addComponent(txtuid))
                    .addComponent(txtp, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncls)
                    .addComponent(btnLogin))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("Developed By SAN Technologies");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(378, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        Admin.Authentication.AdminService srv=new Admin.Authentication.AdminService();

        boolean b=validation(t1,t2);
        if(b)
        {
                boolean flag=false;
                flag=srv.validateLogin(t1, t2);
                if(flag)
                {
                    try
                    {
                        new MainMenu();
                    }catch(IOException ie){}
                    this.setVisible(false);
                }
                else
                {JOptionPane.showMessageDialog(null,"Invalid User Id or Password");}
        }
    }
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
        { logIn();}// for enter key
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

       if(t1.equals("admin")&&t2.equals("user123")){return true;}
        else{JOptionPane.showMessageDialog(this, "Invalid Login");
           return false;}

        
    }
}
