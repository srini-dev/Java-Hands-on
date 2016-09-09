package com.vachana.com.vtsmartjewels;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Calendar;

import VTDb.AllTabs;
import VTDb.ProDBase;

public class PayActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{

    ProDBase PDb;
    Context ctx=this;
    EditText txt1,txt2,txt3,txt5,txt6;
    Button txt4;
    Button btns,btne,btnn,btnnew;
    String t1,t2,t3,t4,t5,t6;
    int td1=0;
    double td2=0;
    int td3=0;
    String td4="";
    double td5=0,td6=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("SMART JEWELLERS");
        toolbar.setSubtitle("P a y m e nt  D e t a i l s");
        ListView lst,lst2;
        lst= (ListView) findViewById(R.id.billsPay);
        txt1= (EditText) findViewById(R.id.tbl1);
        txt2= (EditText) findViewById(R.id.tbl2);
        txt3= (EditText) findViewById(R.id.tbl3);
        txt4= (Button) findViewById(R.id.tbl4);
        txt5= (EditText) findViewById(R.id.tbl5);
        txt6= (EditText) findViewById(R.id.tbl6);

        btns= (Button) findViewById(R.id.btnsavpay);
       // btns= (Button) findViewById(R.id.btnsavpay);
        btnnew= (Button) findViewById(R.id.button4);
        lst2=(ListView) findViewById(R.id.paylist);
        getBildata();
        lst.setOnItemClickListener(this);
        lst2.setOnItemLongClickListener(this);

        txt4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Calendar calender = Calendar.getInstance();
                Dialog mDialog = new DatePickerDialog(PayActivity.this, mDatesetListener, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH));
                mDialog.show();
            }

            DatePickerDialog.OnDateSetListener mDatesetListener = new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker arg0, int yer, int mnth, int dat) {
                    mnth = mnth + 1;
                    String my_date = dat + "/" + mnth + "/" + yer;
                    txt4.setText(my_date);
                }
            };
        });


        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = validatefields();
                //if found updates
                if (flag == true) {
                    PDb = new ProDBase();
                    boolean f = PDb.insertBillsPay(td1, td2, td3, td4, td5, td6);

                    if (f == true) {
                        Toast.makeText(ctx, " F is true ", Toast.LENGTH_LONG).show();
                        Toast.makeText(ctx, "Data Saved Successfully", Toast.LENGTH_LONG).show();
                        PDb.updatePay(td1,td6);
                        getBildata();
                        getPayInfo();
                        clearTxt();
                    } else {
                        Toast.makeText(ctx, " Data Not Saved ", Toast.LENGTH_LONG).show();
                    }
                }


            }

            public boolean validatefields() {
                t1 = txt1.getText().toString();
                t2 = txt2.getText().toString();
                t3 = txt3.getText().toString();
                t4 = txt4.getText().toString();
                t5 = txt5.getText().toString();
                t6 = txt6.getText().toString();


                if (txt1.length() == 0) {
                    Toast.makeText(ctx, "Bill No should not be blank", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (txt2.length() == 0) {
                    Toast.makeText(ctx, "Bill Amount should not be blank", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (txt3.length() == 0) {
                    Toast.makeText(ctx, "Pay Id should not be blank", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (txt4.length() == 0) {
                    Toast.makeText(ctx, "Pay Date should not be blank", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (txt5.length() == 0) {
                    Toast.makeText(ctx, "Pay Amount should not be blank", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (txt6.length() == 0) {
                    Toast.makeText(ctx, "Balance should not be blank", Toast.LENGTH_LONG).show();
                    return false;
                }


                try {
                    td1 = Integer.valueOf(txt1.getText().toString());
                    td2 = Double.valueOf(txt2.getText().toString());
                    ;
                    td3 = Integer.valueOf(txt3.getText().toString());
                    td4 = txt4.getText().toString();
                    td5 = Double.valueOf(txt5.getText().toString());
                    td6 = Double.valueOf(txt6.getText().toString());

                    return true;
                } catch (Exception e) {
                    Toast.makeText(ctx, "Should be in numeric", Toast.LENGTH_LONG).show();
                    return false;
                }

            }

        });
        txt6.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View arg0, boolean arg1) {
                double a = 0, b = 0, c = 0;
                try {
                    DecimalFormat d1 = new DecimalFormat("0.00");
                    a = Double.valueOf(txt2.getText().toString());
                    b = Double.valueOf(txt5.getText().toString());
                    c = a - b;
                    txt6.setText(String.valueOf(d1.format(c)));
                } catch (Exception e) {
                }
                //	Toast.makeText(ctx, "Total Focused" , Toast.LENGTH_LONG).show();

            }
        });

        btnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pn=0;
                try{pn=Integer.valueOf(txt3.getText().toString());}catch(Exception e){}
                pn=pn+1;
                txt3.setText(String.valueOf(pn));
                Toast.makeText(ctx, "Do" , Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getBildata()
    {

        try{


            int x=0,y=0;


            PDb=new ProDBase();
            Cursor cur;
            cur= PDb.getAllBilsList();


            //Toast.makeText(ctx, cur.getCount(),Toast.LENGTH_LONG).show();
            String[] bilFields=new String[]{AllTabs.keyb_bn,AllTabs.keyb_dat,AllTabs.keyb_cstnam,AllTabs.keyb_totamt};
            Log.d("msg3", "Done here");
            int[] toViewIds=new int[]{R.id.blp1,R.id.blp2,R.id.blp3,R.id.blp4};
            Log.d("msg4", "Done here");
            try {

                double a1=0,a2=0;
                int a3=0;
                String nam,dat;
                cur.moveToFirst();
                do
                {
                    // a3=cur.getInt(2);
                    a1=cur.getDouble(5);
//                    if (a3==y){a2=a2+a1;}
                    a2=a2+a1;
                    //nam=cur.getString(3);}
                    // dat=cur.getString(2);
                }while(cur.moveToNext());


                DecimalFormat df = new DecimalFormat("0.00");


               // @SuppressWarnings("deprecation")
               // SimpleCursorAdapter mca = new SimpleCursorAdapter(ctx, R.layout.bill_pay_layout, cur, bilFields, toViewIds);
               // Log.d("msg6", "Done here");
//                ListView gsList=(ListView)findViewById(R.id.billsPay);
////
//                gsList.setAdapter(mca);
                ListView gsList = (ListView) findViewById(R.id.billsPay);
                cur.moveToFirst();
                if (cur.getColumnCount() != 0) {
                    SpecialCursorAdapters invItems = new SpecialCursorAdapters(this, R.layout.bill_pay_layout, cur, bilFields, toViewIds);
                    gsList.setAdapter(invItems);

                }


            }
            catch(Exception e)
            {
                Log.d("msg5", e.toString());
            }

        }
        catch(Exception e){}
    }
    public void getPayInfo()
    {

        try{


            int x=0,y=0;


            PDb=new ProDBase();
            Cursor cur;
            int bin=0;
            try{bin=Integer.valueOf(txt1.getText().toString());}catch (Exception e){}
            cur= PDb.getPaidList(bin);


            //Toast.makeText(ctx, cur.getCount(),Toast.LENGTH_LONG).show();
            String[] bilFields=new String[]{AllTabs.keyc_pid,AllTabs.keyc_pamt,AllTabs.keyc_pdat,AllTabs.keyc_pamt,AllTabs.keyc_bal};
            Log.d("msg3", "Done here");
            int[] toViewIds=new int[]{R.id.blpd1,R.id.blpd2,R.id.blpd3,R.id.blpd4,R.id.blpd5};
            Log.d("msg4", "Done here");
            try {

                double a1=0,a2=0;
                int a3=0;
                String nam,dat;
                cur.moveToFirst();
                do
                {
                    // a3=cur.getInt(2);
                    a1=cur.getDouble(5);
//                    if (a3==y){a2=a2+a1;}
                    a2=a2+a1;
                    //nam=cur.getString(3);}
                    // dat=cur.getString(2);
                }while(cur.moveToNext());


                DecimalFormat df = new DecimalFormat("0.00");


                // @SuppressWarnings("deprecation")
                // SimpleCursorAdapter mca = new SimpleCursorAdapter(ctx, R.layout.bill_pay_layout, cur, bilFields, toViewIds);
                // Log.d("msg6", "Done here");
//                ListView gsList=(ListView)findViewById(R.id.billsPay);
////
//                gsList.setAdapter(mca);
                ListView gsList = (ListView) findViewById(R.id.paylist);
                cur.moveToFirst();
                if (cur.getColumnCount() != 0) {
                    PaidSpecialCursorAdapters invItems = new PaidSpecialCursorAdapters(this, R.layout.bill_paid_layout, cur, bilFields, toViewIds);
                    gsList.setAdapter(invItems);
                }
            }
            catch(Exception e)
            {
                Log.d("msg5", e.toString());
            }

        }
        catch(Exception e){}
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String sln1 = "", bno = "";
        sln1 = ((TextView) view.findViewById(R.id.blp1)).getText().toString();
        bno = ((TextView) view.findViewById(R.id.blp4)).getText().toString();
        txt1.setText(sln1);
        txt2.setText(bno);

        getNextPId();
        getPayInfo();

    }
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        int pid=0,itmcod,qty;
        double py,bal=0;
        final double totbal;
        final String sln1,pi;
        //Toast.makeText(ctx, "Long Clicked", Toast.LENGTH_LONG).show();

        pi =((TextView)view.findViewById(R.id.blpd1)).getText().toString();
        int p1=0,p2=0;
        try{p2=Integer.valueOf(txt3.getText().toString());
        p1=Integer.valueOf(pi);
        }catch(Exception e){}
        py =Double.valueOf(((TextView) view.findViewById(R.id.blpd4)).getText().toString());
        try{bal=Double.valueOf(txt2.getText().toString());}catch (Exception e){}
        totbal=(py+bal);
        AlertDialog.Builder ab=new AlertDialog.Builder(ctx);

        ab.setTitle("Delete");
        p1=p1+1;
        ab.setMessage("Do you Want to Delete " + p2);

        if(p2==p1)
        {

        ab.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int x0 = 0, x1 = 0, x2 = 0;
                x1 = Integer.valueOf(pi);
                try {
                    x0 = Integer.valueOf(txt1.getText().toString());
                } catch (Exception e) {
                    genMsg("Please pick the Bill No");
                }

                PDb = new ProDBase();
                boolean flag = false;

                flag = PDb.delPaidItm(x0, x1);
                if (flag) {
                    Toast.makeText(ctx, "Item Deleted Success Fully", Toast.LENGTH_LONG).show();
                    arrangeList(x0, x1);
                    PDb.updatePay(x0, totbal);
                    getPayInfo();
                    getBildata();

                    dialog.dismiss();
                } else {
                    Toast.makeText(ctx, "Sorry Failed To Deleted", Toast.LENGTH_LONG).show();
                }

            }


        });}
        else {

            ab.setMessage("Tap on customer name You can delete only last row ");

        }
        ab.show();
        return false;
    }
    public void clearTxt()
    {
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");

    }
    public void getNextPId()
    {
        String x="",y="";
        int n=0;
        PDb=new ProDBase();
        try{x=txt1.getText().toString();
        }catch (Exception e){}
        Cursor cr=PDb.getNextPayId(x);
        if(cr!=null)
        {n=cr.getCount();//null pointer
        n=n+1;
        txt3.setText(String.valueOf(n));}
    }
    public void arrangeList(int x0,int x2)
    {

        PDb=new ProDBase();
        Cursor cur= PDb.getNextItmNoInBill(String.valueOf(x0));
        cur.moveToFirst();
        int i=x2,j=x2+1,siz=0,l=0;

        siz=cur.getCount();
        String itms[]=new String[siz];

        if(siz!=0)
        {

            do
            {


//                j=cur.getInt(2);
//                itms[k]=String.valueOf(j);

                PDb.modifySalItmForSlnRearange(i, j,x0);
                i++;
                j++;


            }while(cur.moveToNext());
            cur.close();
        }
    }
    public void genMsg(String Msg)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(PayActivity.this).create();
        alertDialog.setMessage(Msg);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}
        });
        alertDialog.show();
    }

}

class SpecialCursorAdapters extends SimpleCursorAdapter
{
    private int[] colors = new int[] { 0xFF6600, 0xFFFFFFFF };
    Context ctx;
    int lout;
    Cursor c;
    public SpecialCursorAdapters(Context context, int layout, Cursor cr, String[] from, int[] to)
    {
        super(context, layout, cr, from, to);
        ctx=context;lout=layout;c=cr;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = View.inflate(ctx, lout, null);
        View row = convertView;
        c.moveToPosition(position);

        TextView xp1 = (TextView) convertView.findViewById(R.id.blp1);
        TextView xp2 = (TextView) convertView.findViewById(R.id.blp2);
        TextView xp3 = (TextView) convertView.findViewById(R.id.blp3);
        TextView xp4 = (TextView) convertView.findViewById(R.id.blp4);



        DecimalFormat df1 = new DecimalFormat("0.00");
        Double tot = c.getDouble(9);

        xp1.setText(String.valueOf(c.getInt(1)));
        xp2.setText(String.valueOf(c.getString(3)));
        xp3.setText(String.valueOf(c.getString(4)));
        xp4.setText(df1.format(tot));


        return row;
    }

}
class PaidSpecialCursorAdapters extends SimpleCursorAdapter
{
    private int[] colors = new int[] { 0xFF6600, 0xFFFFFFFF };
    Context ctx;
    int lout;
    Cursor c;
    public PaidSpecialCursorAdapters(Context context, int layout, Cursor cr, String[] from, int[] to)
    {
        super(context, layout, cr, from, to);
        ctx=context;lout=layout;c=cr;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = View.inflate(ctx, lout, null);
        View row = convertView;
        c.moveToPosition(position);

        TextView xp1 = (TextView) convertView.findViewById(R.id.blpd1);
        TextView xp2 = (TextView) convertView.findViewById(R.id.blpd2);
        TextView xp3 = (TextView) convertView.findViewById(R.id.blpd3);
        TextView xp4 = (TextView) convertView.findViewById(R.id.blpd4);
        TextView xp5 = (TextView) convertView.findViewById(R.id.blpd5);


        DecimalFormat df1 = new DecimalFormat("0.00");
        Double pa = c.getDouble(5);
        Double pb = c.getDouble(6);

        xp1.setText(String.valueOf(c.getInt(3)));
        xp2.setText(String.valueOf(c.getString(2)));
        xp3.setText(String.valueOf(c.getString(4)));
        xp4.setText(df1.format(pa));
        xp5.setText(df1.format(pb));


        return row;
    }

}
