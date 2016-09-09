/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RepFrm.java
 *
 * Created on Mar 16, 2015, 12:04:59 PM
 */

package Forms.Reports;

import Admin.Database.DBConnect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author user
 */
public class TRepFrm extends javax.swing.JInternalFrame {

    /** Creates new form RepFrm */
    public TRepFrm() {
        super(null,false,false,false,false);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));this.updateUI();
        //this.setDesktopIcon(null);
        initComponents();
    }
    Connection conn=null;
    public TRepFrm(String fileName,HashMap param) throws SQLException, ClassNotFoundException
    {
        this();
        conn=new DBConnect().GetConnetion();
        try{
            File fl=new File("src\\Forms\\Reports\\STrnRep.jrxml");
            String rep=fl.getAbsolutePath();
            JasperReport rep2=JasperCompileManager.compileReport(rep);
            JasperPrint print=JasperFillManager.fillReport(rep2,param,conn);
            JRViewer viewer=new JRViewer(print);
            Container c=getContentPane();
            c.setLayout(new BorderLayout());
            c.add(viewer);
        }catch(Exception e){JOptionPane.showMessageDialog(this,"IFrame Expt"+e);}
        finally{try{conn.close();System.out.println("Closed");}catch(Exception e){JOptionPane.showMessageDialog(this,"From Report Close Failed"+e);}}
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sanlogo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
