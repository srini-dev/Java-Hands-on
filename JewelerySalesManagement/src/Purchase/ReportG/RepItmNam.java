package Purchase.ReportG;


//import Sales.Report.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IFrame.java
 *
 * Created on Dec 8, 2014, 1:30:08 PM
 */

/**
 *
 * @author user
 */
public class RepItmNam extends javax.swing.JInternalFrame {

    /** Creates new form IFrame */
    Connection conn;
    public RepItmNam() {

        super("Testing Report viewer",true,true,true,true);
        initComponents();
        setBounds(10,10,600,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        System.out.println("1");
    }
    /*public IFrame(String fileName) throws SQLException, ClassNotFoundException
    {
        this(fileName,null);
        System.out.println("Report called 2");
    }*/
    public RepItmNam(String fileName,HashMap param) throws SQLException, ClassNotFoundException
    {
        this();
        System.out.println("2");
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("Jdbc:Odbc:RRSDS","","");
        System.out.println("3");
        try{
           String rep="D:/MyProjects/RRSPrj/src/Purchase/ReportG/RepItmNam.jrxml";
           JasperReport rep2=JasperCompileManager.compileReport(rep);
            JasperPrint print=JasperFillManager.fillReport(rep2, param,conn);
            System.out.println("4");
            JRViewer viewer=new JRViewer(print);
            System.out.println("5");
            Container c=getContentPane();
            System.out.println("6");
            c.setLayout(new BorderLayout());
            System.out.println("7");
            c.add(viewer);
            System.out.println("8");
        }catch(Exception e){System.out.println("IFrame Expt"+e);}
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
