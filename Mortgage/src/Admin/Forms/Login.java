/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.Forms;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Vicky
 */
public class Login implements ActionListener
{
    public JFrame Loginfrm;
    JPanel LoginPanel;
    JButton btnOk;
    JLabel lblName,lblPass;
    JTextField txtName,txtPass;
    
    
    public Login()
    {
        
        Loginfrm=new JFrame("Login Form");
        Loginfrm.setSize(500,200);
        Loginfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnOk=new JButton("LOGIN");
        btnOk.setSize(100,100);
        btnOk.addActionListener(this);
        Loginfrm.setLocationRelativeTo(null);
        
        
        LoginPanel=new JPanel();
        LoginPanel.setSize(500, 200);
        LoginPanel.setBackground(Color.LIGHT_GRAY);
        LoginPanel.add(btnOk);
        
      //  LoginPanel.setLayout(new BorderLayout());        
        
        
        Loginfrm.add(LoginPanel);
        Loginfrm.setVisible(true);
        
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.Loginfrm.setVisible(false);
        try {
            MainMenu obj = new MainMenu();
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
