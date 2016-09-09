/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin.Authentication;

import Admin.Database.DBConnect;
import Forms.MyFont;
import java.awt.Font;
import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;
public class Authentication
{
    boolean flag=false;
    Connection conn=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    String nam="";
    String inp;
    private boolean validno(String nam)
    {
        if(nam.equals("-"))
        {
            String hd="";
            hd=readSLKey();
            flag=addmno(hd,inp);
            if(flag)
            {
                JOptionPane.showMessageDialog(null, "Key Activation Successfull");
                new Login().setVisible(true);
            }else{JOptionPane.showMessageDialog(null, "Sorry The key is Invalid");}
        }else{JOptionPane.showMessageDialog(null, "Sorry The key is Invalid");}
        return true;
    }
    public boolean addmno(String mno,String key)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("Update Auth Set matchno = ? where key = ?");
            ps.setString(1,mno);
            ps.setString(2,key);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0)
            {
                flag=true;
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Not found"+e);}
        return flag;
    }
    public void getmno()
    {
        inp=JOptionPane.showInputDialog("Insert Key");
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("SELECT matchno FROM Auth where key = ?");
            ps.setString(1,inp);
            System.out.println("--"+inp);
            rs=ps.executeQuery();
            while(rs.next())
            {
                  nam=rs.getString("matchno");
            }
            validno(nam);
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Not a valid key"+e);}
        finally{try{conn.close();System.out.println("close");}catch(Exception e){System.out.println(e);}}
    }
    public void getmn()
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("SELECT matchno FROM Auth where ino = ?");
            ps.setString(1,"1");
            rs=ps.executeQuery();
            while(rs.next())
            {
                  nam=rs.getString("matchno");
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Not a valid key"+e);}
        finally{try{conn.close();System.out.println("close");}catch(Exception e){System.out.println(e);}}
    }
    public void directlog()
    {
        String hd="";
        hd=readSLKey();
        if(nam.equals(""))
        {
            getmn();
            if(nam.equals("-")||nam.equals(hd))
            {
                if(nam.equals(hd)){new Login().setVisible(true);}else{getmno();}
            }else{JOptionPane.showMessageDialog(null,"Sorry Invalid System Please Contact Administration");}
        }
    }

    public void checkSLKFile()throws IOException
    {
        File fil=new File("src\\dbInf.mft");
        if(fil.exists())
        {
            String hd="",ff="";
            hd=readSLKey();
            ff=readSLKeyFrmFile(fil);
            boolean b=matchSLKey(hd,ff);
            if(b)
            {new Login().setVisible(true);}
            else
            {new SecurityForm().setVisible(true);}
            System.out.println("yes");

        }
        else
        {
            String hd=readSLKey();
            writeSLKey(hd,fil);
            new ConfigsFrm();
            System.out.println("NO");
        }
    }
    public String readSLKey()
    {
        String result = "";
    try {
      File file = File.createTempFile("realhowto",".vbs");
      file.deleteOnExit();
      FileWriter fw = new java.io.FileWriter(file);

      String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                  +"Set colDrives = objFSO.Drives\n"
                  +"Set objDrive = colDrives.item(\"" + "c" + "\")\n"
                  +"Wscript.Echo objDrive.SerialNumber";  // see note
      fw.write(vbs);
      fw.close();
      Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
      BufferedReader input =
        new BufferedReader
          (new InputStreamReader(p.getInputStream()));
      String line;
      while ((line = input.readLine()) != null) {
         result += line;
      }
      input.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    return result.trim();


    }
    public String readSLKeyFrmFile(File fil)throws IOException
    {
        String ky="";
        FileInputStream fis=new FileInputStream(fil);
        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(isr);
        ky=br.readLine();
        return ky.trim();

    }
    public void writeSLKey(String hd,File fil)throws IOException
    {
        FileOutputStream fos=new FileOutputStream(fil);
        byte ky[]=hd.getBytes();
        fos.write(ky);

    }
    public boolean matchSLKey(String hd,String ff)
    {
        if(hd.equals(ff))
        {
            
        return true;
        }
        else
        return false;
    }
    public static void main(String[] args)throws IOException
    {
        Authentication ath=new Authentication();
         MyFont.setUIFont (new javax.swing.plaf.FontUIResource ("Tunga",Font.BOLD,16));
        ath.directlog();
    }

}
