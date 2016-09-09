/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.DataBase;
import java.sql.*;
import java.io.*;
import java.lang.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Vicky
 */
public class DBConnect {
    
    public static Connection GetConnetion()
            //throws ClassNotFoundException, SQLException
    {
       /* String datsourcename="PRSDS";
        String dburl="jdbc:odbc:"+datsourcename;
        Connection conn=null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection(dburl,"","");
            System.out.println("connected");
            return conn;
        }
        catch(ClassNotFoundException e)
        {return conn;}
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e+"connection failed");
            return conn;
        }
      */
      java.util.Properties prop = new java.util.Properties();
        prop.put("charSet", "UTF8"); // Not tested..
        Connection conn=null;
        try
        {
            File fl=new File("src\\Admin\\DataBase\\BanjaraDB.accdb");
            String path=fl.getAbsolutePath();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //conn=DriverManager.getConnection(dburl,"","",prop);
            conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ="+path, prop);
            System.out.println("connected");
            return conn;
    }catch(ClassNotFoundException e)
        {return conn;}
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e+"connection failed");
            return conn;
        }
    
}
}
