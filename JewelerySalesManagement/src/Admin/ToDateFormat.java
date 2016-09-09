/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import java.text.SimpleDateFormat;


public class ToDateFormat {


    public static String TD()
    {
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date dy=new java.util.Date();
        String td=df.format(dy);
        System.out.println(td);
        return td;

    }
    
    
    public static String DToD(String df)
    {
        String str=df;
        System.out.println(str);
        String yy,mm,dd;
        String dat[]=str.split("-");
        yy=dat[0];
        mm=dat[1];
        dd=dat[2];
        String str2=mm+"/"+dd+"/"+yy;
        return str2;

    }
    public static String DToD2(String df)
    {
        String str=df;
        System.out.println(str);
        String yy,mm,dd;
        String dat[]=str.split("-");
        yy=dat[0];
        mm=dat[1];
        dd=dat[2];
        String str2=dd+"/"+mm+"/"+"14";
        
        return str2;

    }


}
