package com.vachana.com.vtsmartjewels;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.system.OsConstants;
import android.text.Editable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cie.btp.CieBluetoothPrinter;
import com.cie.btp.DebugLog;
import com.vachana.com.vtsmartjewels.printlibs.BillImage;
import com.vachana.com.vtsmartjewels.printlibs.LibraryMessageListener;
import com.vachana.com.vtsmartjewels.printlibs.bean.Bill;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import VTDb.AllTabs;
import VTDb.ProDBase;

public class SalesPage extends AppCompatActivity implements LibraryMessageListener,AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {

    TextView st1,st4,st5,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
    EditText bt1;
    AutoCompleteTextView st3;
    Button bt2,adds,sav,del,nw,btnGen,btnprt,btnsub,adRat,btnclr,btnedt;
    double stt4=0,wtsTot=0;
    int btt1=0,stt1=0,stt2=0,bn,stt5=0,bns=0;
    String btt2,btt3,stt3,bdate,btime;
    double btt4,btt5,btt6,btt7,btt8,btt9;
    Context ctx=this;
    ProDBase PDb;
    ListView lst1,lst2;

    int gbn=0,gbns=0,gsln=0,gb=0;
    String gitm="";
    double gwts=0.0;

    //++++++WV 1+++++++++++++++++++++
    WebView webview;
    //++++++++END++++++++++++++++++++++

    //========PRT 1=========================
    private static final int STORAGE_PERMISSION_RC = 123;
    private ImageView imagePreview;
    private Bill b = new Bill();
    private Bitmap bmp;
    private SharedPreferences sp;
    public static CieBluetoothPrinter mPrinter = CieBluetoothPrinter.INSTANCE;
    private App app=null;
    //============END======================

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_page);



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("VT S M A R T - J E W E L L S");
//        toolbar.setSubtitle("Sales");



        st3= (AutoCompleteTextView) findViewById(R.id.slt3);
        st4= (TextView) findViewById(R.id.slt4);
        st5= (TextView) findViewById(R.id.slt5);

        bt1= (EditText)findViewById(R.id.blt1);
        bt2= (Button) findViewById(R.id.blt2);
        bt3= (TextView) findViewById(R.id.blt3);
        bt4= (TextView) findViewById(R.id.blt4);
        bt5= (TextView) findViewById(R.id.blt5);
        bt6= (TextView) findViewById(R.id.blt6);
        bt7= (TextView) findViewById(R.id.blt7);
        bt8= (TextView) findViewById(R.id.blt8);
        bt9= (TextView) findViewById(R.id.blt9);
        adds= (Button) findViewById(R.id.sbtnadd);
        sav= (Button) findViewById(R.id.sbtnsav);
        del= (Button) findViewById(R.id.sbtndel);
        nw= (Button) findViewById(R.id.sbtnnew);
        btnGen= (Button) findViewById(R.id.sbtgen);
        btnprt= (Button) findViewById(R.id.sbtnprt);
        btnsub= (Button) findViewById(R.id.sbtnsub);
        btnclr= (Button) findViewById(R.id.sbtnclr);
        btnedt= (Button) findViewById(R.id.sbtnedt);
        adRat= (Button) findViewById(R.id.button3);
        lst1= (ListView) findViewById(R.id.soldItms);
        lst2= (ListView) findViewById(R.id.soldItms);
        PDb=new ProDBase();
        nextBno();
       bt7.setEnabled(false);
       bt8.setEnabled(false);
        //bt2.setText("Calender");
        lst1.setOnItemClickListener(this);
        lst2.setOnItemLongClickListener(this);
        int x=Integer.valueOf(bt1.getText().toString());
        Toast.makeText(ctx, "Calling",Toast.LENGTH_LONG).show();
        setCurDate();


        genDataOnWeb(x);
        gettabdata(x);
        nextBnoSub();
        getBildata();
        getTotWt();
        checkPayment(x);

        @SuppressWarnings("unchecked")
        List<String> lst=PDb.putINamesInAddopter();
        st3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lst));

        //+++++++++++++++++++++++
        //========PRT 2====================
        app=new App(SalesPage.this);
        app=(App) getApplication();

        BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mAdapter == null) {
            Toast.makeText(this, "Bt not support", Toast.LENGTH_SHORT).show();
            finish();
        }
        app.initPrinters(SalesPage.this);
        //===========END==================================
        btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = 0;
                x = Integer.valueOf(bt1.getText().toString());
                genDataOnWeb(x);

                AlertDialog alertDialog = new AlertDialog.Builder(SalesPage.this).create();
                alertDialog.setMessage("Bill Generated Successfully");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int x = 0;
                        x = Integer.valueOf(bt1.getText().toString());
                        genDataOnWeb(x);
                    }
                });
                alertDialog.show();
            }
        });
        btnprt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
//
                app.printDirect(bmp);
            }
        });
        //+++++++++++++++++++++
        bt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Calendar calender = Calendar.getInstance();
                Dialog mDialog = new DatePickerDialog(SalesPage.this, mDatesetListener, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH));
                mDialog.show();
            }

            DatePickerDialog.OnDateSetListener mDatesetListener = new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker arg0, int yer, int mnth, int dat) {
                    mnth = mnth + 1;
                    String my_date = dat + "/" + mnth + "/" + yer;
                    bt2.setText(my_date);
                }
            };
        });

        bt6.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View arg0, boolean arg1) {
                double a = 0, b = 0, c = 0;
                try {
                    DecimalFormat d1 = new DecimalFormat("0.000");
                    a = Double.valueOf(bt4.getText().toString());
                    b = Double.valueOf(bt5.getText().toString());
                    c = a * (b / 100);
                    bt6.setText(String.valueOf(d1.format(c)));
                } catch (Exception e) {
                }
                //	Toast.makeText(ctx, "Total Focused" , Toast.LENGTH_LONG).show();

            }
        });
        bt8.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View arg0, boolean arg1) {
                double a = 0, b = 0, c = 0;
                try {
                    DecimalFormat d1 = new DecimalFormat("0.00");
                    a = Double.valueOf(bt6.getText().toString());
                    b = Double.valueOf(bt7.getText().toString());
                    c = a * b;
                    bt8.setText(String.valueOf(d1.format(c)));
                } catch (Exception e) {
                }
                //	Toast.makeText(ctx, "Total Focused" , Toast.LENGTH_LONG).show();

            }
        });
        adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag = validatefields();
                if (flag == true) {

                    flag = PDb.insertSalData(stt1, stt2, stt3, stt4,stt5);
                    if (flag == true) {
                        Toast.makeText(ctx, "Data Saved Successfully", Toast.LENGTH_LONG).show();
                        gentabdata();
                        gettabdataforNew(stt1);
                        getTotWt();
                        st4.setText("");

                    } else {
                        Toast.makeText(ctx, " Data Not saved", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(ctx, " No Items in the this Bill", Toast.LENGTH_LONG).show();
                }

            }

            public boolean validatefields() {
                String sbtt1 = bt1.getText().toString();
                //String sbtt2=st2.getText().toString();
                String sbtt3 = st3.getText().toString();
                String sbtt4 = st4.getText().toString();


                if (bt1.length() == 0) {
                    Toast.makeText(ctx, "Bill No should not be blank", Toast.LENGTH_LONG).show();
                    return false;
                }
                //if(st2.length()==0){Toast.makeText(ctx, "Date should not be blank",Toast.LENGTH_LONG).show();return false;}
                if (sbtt3.length() == 0) {
                    Toast.makeText(ctx, "Item name should not be blank", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (st4.length() == 0) {
                    Toast.makeText(ctx, "Total Weight should not be blank", Toast.LENGTH_LONG).show();
                    return false;
                }
//                if (bt2.length() == 0) {
//                    Toast.makeText(ctx, "Date should not be blank", Toast.LENGTH_LONG).show();
//                    return false;
//                }
//                if (bt3.length() == 0) {
//                    Toast.makeText(ctx, "Customer name should not be blank", Toast.LENGTH_LONG).show();
//                    return false;
//                }


                try {
                    stt1 = Integer.valueOf(bt1.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(ctx, "Should be in numeric", Toast.LENGTH_LONG).show();
                    return false;
                }

                stt2 = getNextItmNInBil();
                stt3 = st3.getText().toString();
                stt5=Integer.valueOf(st5.getText().toString());
                try {
                    stt4 = Double.valueOf(st4.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(ctx, "Should be in numeric", Toast.LENGTH_LONG).show();
                    return false;
                }


                return true;


            }
        });
        sav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean flag=validatefields();
                //if found updates
                if(flag==true)
                {
                    Cursor crs=PDb.findBillByBn_sbn(btt1,stt5);
                    if(crs.getCount()>0) {
                        flag = PDb.updateBillsData(btt1, btt2, btt3, btt4, btt5, btt6, btt7, btt8, stt5);
                        if (flag == true) {
                            Toast.makeText(ctx, "Data Modified Successfully", Toast.LENGTH_LONG).show();
                            gettabdata(btt1);
                            gettabdataforNew(btt1);
                            getBildata();

                        } else {
                            Toast.makeText(ctx, " Data Not Modified", Toast.LENGTH_LONG).show();
                        }
                    }
                    //if not found saves
                    else {
                        flag = PDb.insertBillsData(btt1, btt2, btt3, btt4, btt5, btt6, btt7, btt8, stt5);
                        if (flag == true) {
                            Toast.makeText(ctx, "Data Saved Successfully", Toast.LENGTH_LONG).show();
                            gettabdata(btt1);
                            getBildata();

                        } else {
                            Toast.makeText(ctx, " Data Not saved", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else
                {Toast.makeText(ctx, " No Items in the this Bill", Toast.LENGTH_LONG).show();}

            }

            public boolean validatefields()
            {
                String sbtt1=bt1.getText().toString();
                String sbtt2=bt2.getText().toString();
                String sbtt3=bt3.getText().toString();
                String sbtt4=bt4.getText().toString();
                String sbtt5=bt5.getText().toString();
                String sbtt6=bt6.getText().toString();
                String sbtt7=bt7.getText().toString().trim();
                String sbtt8=bt8.getText().toString();


                if(bt1.length()==0){Toast.makeText(ctx, "Bill No should not be blank",Toast.LENGTH_LONG).show();return false;}
                if(bt2.length()==0){Toast.makeText(ctx, "Date should not be blank",Toast.LENGTH_LONG).show();return false;}
                if(bt3.length()==0){Toast.makeText(ctx, "Customer name should not be blank",Toast.LENGTH_LONG).show();return false;}
                if(bt4.length()==0){Toast.makeText(ctx, "Total Weight should not be blank",Toast.LENGTH_LONG).show();return false;}
                if(bt5.length()==0){Toast.makeText(ctx, "Percentage should not be blank",Toast.LENGTH_LONG).show();return false;}
                if(bt6.length()==0){Toast.makeText(ctx, "Fine type should not be blank",Toast.LENGTH_LONG).show();return false;}
               // if(bt7.length()==0){Toast.makeText(ctx, "Rate should not be blank",Toast.LENGTH_LONG).show();return false;}
                //if(bt8.length()==0){Toast.makeText(ctx, "Total should not be blank",Toast.LENGTH_LONG).show();return false;}




                try {
                    btt1 = Integer.valueOf(bt1.getText().toString());


                    btt2 = bt2.getText().toString();
                    btt3 = bt3.getText().toString();
                    btt4 = Double.valueOf(bt4.getText().toString());
                    btt5 = Double.valueOf(bt5.getText().toString());
                    btt6 = Double.valueOf(bt6.getText().toString());
                    btt7 = 0.0;
                    btt8 = 0.0;
                    stt5=Integer.valueOf(st5.getText().toString());
                    return true;
                }catch (Exception e){Toast.makeText(ctx, "Should be in numeric",Toast.LENGTH_LONG).show();return false;}

            }

        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x=0;
                try{x=Integer.valueOf(bt1.getText().toString());}catch (Exception e){}
                boolean b=PDb.delSalItmByBN(x);
                if (b==true)
                {Toast.makeText(ctx, "Deleted",Toast.LENGTH_LONG).show();
                    gettabdata(x);}
                else
                {Toast.makeText(ctx, "Not Deleted",Toast.LENGTH_LONG).show();}


            }
        });
        nw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cr=PDb.getAllBillNo();
                setCurDate();
                cr.moveToFirst();
                int count=0;
                count=cr.getCount();
                count=count+1;
                bt1.setText(String.valueOf(count));
//
                bt4.setText("");

                bt5.setText("");
                bt6.setText("");
                bt7.setText("");
                bt8.setText("");
                bt9.setText("");
                bt3.setText("");
                st3.setText("");
                st4.setText("");
                st5.setText("");
                int xx=count+ 1;
                gettabdataforNew(count);
                //bt1.setText(String.valueOf(5));
                nextBnoSub();
                genDataOnWeb(count);
                //checkPayment();
                adds.setEnabled(true);

            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // bt1.setText(String.valueOf(bn));
                st3.setText("");
                st4.setText("");
                nextBnoSub();
                st5.setText(String.valueOf(bns));
                bt4.setText("");
                bt5.setText("");
                bt6.setText("");
                bt7.setText("");
                bt8.setText("");

                //bt3.setText("");

            }
        });


    }
    public void editSalitems(View view)
    {
        validateVal();

    }
    public void validateVal() {
        int a1 = 0, a2 = 0, a3 = 0;
        String a4 = "=";
        double a5 = 0.0, a55 = 0.0,x=0.0,y=0.0,z=0.0;
        boolean b = false;
        try {
            a1 = Integer.valueOf(bt1.getText().toString());
            a2 = Integer.valueOf(st5.getText().toString());
            a3 = gsln;
            a5 = Double.valueOf(st4.getText().toString());
            b = PDb.editItmWts(a1, a2, a3, a5);
            x=gwts;
            y=a5;
            z=(x>y)?(x-y):(y-x);



        } catch (Exception e) {
            Toast.makeText(ctx, e.toString() + a4, Toast.LENGTH_LONG).show();
        }
        a4 = a1 + " " + a2 + " " + a5;
        if (b == true)
        { Toast.makeText(ctx, "Modified "+z,Toast.LENGTH_LONG).show();
        gettabdata(a1);
            gettabdataforNew(a1);
            adds.setEnabled(true);
            getTotWt();
            try{a55=Double.valueOf(bt5.getText().toString());
            a55=a55+z;
            PDb.editTotWts(a1,a2,a55);}catch(Exception e){}
            getTotWt();
            st3.setText("");
            st4.setText("");}
        else
            Toast.makeText(ctx, "Not Modified "+a4,Toast.LENGTH_LONG).show();







    }
    public void clearSalitems(View view)
    {
       // st3.setText("");
        st4.setText("");
        adds.setEnabled(true);
    }

    public int getVilCount()
    {
        Cursor cr=PDb.getAllBillNo();
        setCurDate();
        cr.moveToFirst();
        int count=0;
        count=cr.getCount();
        return count;
    }
    public void showSales(View view) {

//        showCustomLIst();
        getBildata();
        getTotWt();

        int x=0;
        try{x=Integer.valueOf(bt1.getText().toString());}catch (Exception e){}
        genDataOnWeb(x);
        gettabdataforNew(x);
        gettabdata(x);
        checkPayment(x);

    }

    public void showCustomLIst()
    {
        LayoutInflater layoutInflater = LayoutInflater.from(SalesPage.this);

        View promptView = layoutInflater.inflate(R.layout.bill_pay_layout, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SalesPage.this);
        alertDialogBuilder.setTitle("Customer List");
        alertDialogBuilder.setView(promptView);
        new PayActivity().getBildata();
        alertDialogBuilder.show();
    }

    public void getTotWt()
    {
        int x=0,y=0;
        try{x=Integer.valueOf(bt1.getText().toString());
            y=Integer.valueOf(st5.getText().toString());}catch (Exception e){}

        PDb=new ProDBase();
        Cursor cur= PDb.getTotWts(x,y);
        double a1=0,a2=0;
        int a3=0;
        String nam,dat;
        if (cur.getCount()!=0) {
            cur.moveToFirst();
            do {
                if (cur.getInt(2)==y)
                { a1 = cur.getDouble(5);
                a2 = a2 + a1;}
            } while (cur.moveToNext());
        }
        DecimalFormat df = new DecimalFormat("0.000");

        bt4.setText(String.valueOf(df.format(a2)));


    }

    public void gentabdata()
    {
        Toast.makeText(ctx, "Genrated data", Toast.LENGTH_LONG).show();
        try{


               int x=0;
            int y=0;
            try{x=Integer.valueOf(bt1.getText().toString());
                y=Integer.valueOf(st5.getText().toString());}catch (Exception e){}

            PDb=new ProDBase();
            Cursor cur;

            cur= PDb.getAllItmsList(x);

                //Toast.makeText(ctx, cur.getCount(),Toast.LENGTH_LONG).show();
                String[] frmFields = new String[]{AllTabs.keya_sln, AllTabs.keya_bnsub, AllTabs.keya_itmnam, AllTabs.keya_wts};
                Log.d("msg3", "Done here");
                int[] toViewIds = new int[]{R.id.bd1, R.id.bd2, R.id.bd3, R.id.bd4};
            Log.d("msg4", "Done here");
                try {

                    double a1 = 0, a2 = 0;
                    int a3 = 0;
                    String nam, dat;
                    cur.moveToFirst();
                    do {
                        // a3=cur.getInt(2);
                        a1 = cur.getDouble(5);
//                    if (a3==y){a2=a2+a1;}
                        a2 = a2 + a1;
                        //nam=cur.getString(3);}
                        // dat=cur.getString(2);

                    } while (cur.moveToNext());

                    Cursor c = PDb.findBillInfo(x);
                    if (c!=null) {
                        bt2.setText(c.getString(3));
                        bt3.setText(c.getString(4));
                    }

                    DecimalFormat df = new DecimalFormat("0.000");


                    @SuppressWarnings("deprecation")
                    SimpleCursorAdapter mca = new SimpleCursorAdapter(ctx, R.layout.bill_no_layout, cur, frmFields, toViewIds);
                    Log.d("msg6", "Done here");
//                ListView gsList=(ListView)findViewById(R.id.soldItms);
//
                    // gsList.setAdapter(mca);
                    ListView gsList = (ListView) findViewById(R.id.soldItms);
                    cur.moveToFirst();
                    if (cur.getColumnCount() != 0) {
                        SpecialCursorAdapter invItems = new SpecialCursorAdapter(this, R.layout.bill_no_layout, cur, frmFields, toViewIds);
                        gsList.setAdapter(invItems);

                    }


                } catch (Exception e) {
                    Log.d("msg5", e.toString());
                }

        }
        catch(Exception e){}
    }

    public void gettabdata(int x)
    {
        Toast.makeText(ctx, "Genrated data", Toast.LENGTH_LONG).show();
        try{


         //   int x=0;
            int y=0;
            try{//x=Integer.valueOf(bt1.getText().toString());
                y=Integer.valueOf(st5.getText().toString());}catch (Exception e){}

            PDb=new ProDBase();
            Cursor cur;

            cur= PDb.getAllItmsList(x);
            cur.moveToFirst();
            if(cur.getCount()!=0) {
                //Toast.makeText(ctx, cur.getCount(),Toast.LENGTH_LONG).show();
                String[] frmFields = new String[]{AllTabs.keya_sln, AllTabs.keya_bnsub, AllTabs.keya_itmnam, AllTabs.keya_wts};
                Log.d("msg3", "Done here");
                int[] toViewIds = new int[]{R.id.bd1, R.id.bd2, R.id.bd3, R.id.bd4};
                Log.d("msg4", "Done here");
                try {

                    double a1 = 0, a2 = 0;
                    int a3 = 0;
                    String nam, dat;
                    cur.moveToFirst();
                    do {
                        // a3=cur.getInt(2);
                        a1 = cur.getDouble(5);
//                    if (a3==y){a2=a2+a1;}
                        a2 = a2 + a1;
                        //nam=cur.getString(3);}
                        // dat=cur.getString(2);

                    } while (cur.moveToNext());

                    Cursor c = PDb.findBillInfo(x);
                    if (c!=null) {
                        bt2.setText(c.getString(3));
                        bt3.setText(c.getString(4));
                    }

                    DecimalFormat df = new DecimalFormat("0.000");


                    @SuppressWarnings("deprecation")
                    SimpleCursorAdapter mca = new SimpleCursorAdapter(ctx, R.layout.bill_no_layout, cur, frmFields, toViewIds);
                    Log.d("msg6", "Done here");
//                ListView gsList=(ListView)findViewById(R.id.soldItms);
//
                    // gsList.setAdapter(mca);
                    ListView gsList = (ListView) findViewById(R.id.soldItms);
                    cur.moveToFirst();
                    if (cur.getColumnCount() != 0) {
                        SpecialCursorAdapter invItems = new SpecialCursorAdapter(this, R.layout.bill_no_layout, cur, frmFields, toViewIds);
                        gsList.setAdapter(invItems);

                    }


                } catch (Exception e) {
                    Log.d("msg5", e.toString());
                }
         }//cur test bull if closed
        }
        catch(Exception e){}
    }
    public void gettabdataforNew(int x)
    {

       bt1.setText(String.valueOf(x));
        int y=0;
        Cursor cur1=null;
            PDb=new ProDBase();
            {cur1= PDb.getAllItmsList(x);}


                String[] frmFields = new String[]{AllTabs.keya_bnsub, AllTabs.keya_sln, AllTabs.keya_itmnam, AllTabs.keya_wts};
                Log.d("msg3", "Done here");
                int[] toViewIds = new int[]{R.id.bd1, R.id.bd2, R.id.bd3, R.id.bd4};
                Log.d("msg4", "Done here");

        int txt=0;
        TextView txtv= (TextView) findViewById(R.id.bd3);
        if (cur1.getCount()!=0) {
            cur1.moveToFirst();
            do {
                txt=Integer.valueOf(cur1.getInt(2));
                if(txt==1)
                {txtv.setTextColor(Color.parseColor("#bdbdbd"));}

            } while (cur1.moveToNext());
        }
        try {



                    @SuppressWarnings("deprecation")
                SimpleCursorAdapter mca = new SimpleCursorAdapter(ctx, R.layout.bill_no_layout, cur1, frmFields, toViewIds);
                Log.d("msg6", "Done here");
                ListView gsList=(ListView)findViewById(R.id.soldItms);

                gsList.setAdapter(mca);



                } catch (Exception e) {
                    Log.d("msg5", e.toString());
                }


    }
    public void getBildata()
    {

        int x=0,y=0;
        try{
            x=Integer.valueOf(bt1.getText().toString());
            y=Integer.valueOf(st5.getText().toString());
        }catch (Exception e){}


        Cursor cur=PDb.findBillByBn_sbn(x,y);
        if(cur.getCount()!=0){
//            bt2.setText(cur.getString(3));
//            bt3.setText(cur.getString(4));
            bt4.setText(String.valueOf(cur.getDouble(5)));
            bt5.setText(String.valueOf(cur.getDouble(6)));
            bt6.setText(String.valueOf(cur.getDouble(7)));
            bt7.setText(String.valueOf(cur.getDouble(8)));
            bt8.setText(String.valueOf(cur.getDouble(9)));


        }
        else{
            bt5.setText("");
            bt6.setText("");
            bt7.setText("");
            bt8.setText("");}

        Cursor cr= PDb.getAllBillData(x);
        if (cr.getCount() != 0) {
            double a7=0,a8=0,a9=0,q=0;
            cr.moveToFirst();
            do {

                a7 = cr.getDouble(7);
                a8 = cr.getDouble(8);
                a9 = cr.getDouble(9);

                q = q + a7;
            } while (cr.moveToNext());
            DecimalFormat d1 = new DecimalFormat("0.00");
            DecimalFormat d2 = new DecimalFormat("0.000");

            bt9.setText(String.valueOf(d2.format(q)));
            bt7.setText(String.valueOf(d1.format(a8)));
            bt8.setText(String.valueOf(d1.format(a9)));

        }

    }
    //+++++++++++++++++++WEB ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void genDataOnWeb(int x1)
    {


        String nm=bt3.getText().toString();
        String dt=bt2.getText().toString();
        int no= 0;
        int t=5;
        try{no=Integer.valueOf(bt1.getText().toString());}catch (Exception e){}

        double a5 = 0,a4 = 0, a6 = 0, a7 = 0, a8 = 0,p= 0,q= 0,r=0;

        DecimalFormat d2 = new DecimalFormat("0.00");
        String a3="",a2="";

        StringBuilder builder = new StringBuilder();
        builder.append("<html><head></head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso- ISO8859-1\" />" );
        builder.append("<body><table border=\"0\" width=\"560px\" >" );
        builder.append("<tr><td colspan=\"3\"><center><font size=\"6\"><b>ವಿಜಯಕುಮಾರ ಟಂಕಸಾಲಿ</b></font></td></tr>" );
        builder.append("<tr><td colspan=\"3\"><center><font size=\"6\" ><b>ವಿ ಜ ಯ ಪೂ ರ</b></font></center></td></tr>");
        builder.append("<tr><td colspan=\"3\"><center><font size=\"6\"><b>9980614888</b></font></td></tr>" );
        builder.append("<tr></td><td colspan=\"3\"><font size=\"5\">Bill No : <n>"+ no+"</b></font></font></td></tr>");
        builder.append("<tr></td><td colspan=\"3\"><font size=\"5\">Bill Date :.<n>"+dt+"</b></font></font></td></tr>");
        builder.append("<tr></td><td colspan=\"3\"><font size=\"5\">Customer Name :<n>"+nm+"</b></font></font></td></tr>");
        //builder.append("<tr><td colspan=\"3\" ><font size=\"5\">Bill Time: " + btime + "</font></font></td></tr>");

        if (t==5)
        {builder.append("<tr><td colspan=\"3\"><center><b>---------------------------------------------------------------------------------------</b></center></td></tr>");}
        builder.append("<tr><td width=\"30px\"><b><font size=\"5\"><b>SN  </b></font></b></td>" +
                "<td width=\"250px\" ><b><font size=\"5\"><b>Perticulars  </b></font></b></td>" +
                "<td  width=\"180px\" align=\"right\"><b><font size=\"5\"><b>Weight</b></font></b></td></tr>");

        builder.append("<tr><td colspan=\"3\"><center><b>---------------------------------------------------------------------------------------</b></center></td></tr>");
        DecimalFormat d1 = new DecimalFormat("0.000");
        PDb=new ProDBase();
        Cursor curs= PDb.getAllItmsList(x1);
        int its=0;
        its=curs.getCount();
        PDb=new ProDBase();
        Cursor crs= PDb.getAllBillData(x1);

        for (int i=0;i<=its;i++) {

            int nn=1;
            PDb=new ProDBase();
            Cursor cur= PDb.getAllItmsList(x1);

            PDb=new ProDBase();
            Cursor cr= PDb.getAllBillData(x1);
            double a1 = 0;
            if (cur.getCount() != 0) {
                cur.moveToFirst();

                do {
                    if (cur.getInt(2) == i)
                    {  a1 = cur.getDouble(4);

                    builder.append("<tr><td width=\"30px\"><b><font size=\"5\"><b>" + nn + "</b></font></b></td>" +
                            "<td width=\"280px\" ><b><font size=\"5\"><b>" + cur.getString(4) + "</b></font></b></td>" +
                            "<td  width=\"180px\" align=\"right\"><b><font size=\"5\"><b>" + d1.format(cur.getDouble(5)) + "</b></font></b></td></tr>");
                        nn++;
                }
                } while (cur.moveToNext());
            }


            if (cr.getCount() != 0) {
//                builder.append("<tr><td colspan=\"3\"><center><b>---------------------------------------------------------------------------------------</b></center></td></tr>");
                cr.moveToFirst();
                do {
                    if (cr.getInt(2) == i) {
                        a2 = cr.getString(3);
                        a3 = cr.getString(4);
                        a4 = cr.getDouble(5);
                        a5 = cr.getDouble(6);
                        a6 = cr.getDouble(7);
                        a7 = cr.getDouble(8);
                        a8 = cr.getDouble(9);
                        q=q+a6;

                        builder.append("<tr><td width=\"30px\"><b><font size=\"5\"><b></b></font></b></td>" +
                                "<td width=\"280px\"colspan=\"2\" ><b><font size=\"5\"><b>Total   " + d1.format(a4)+"   X   "+d2.format(a5) + "  %=  " + d1.format(a6) + "</b></font></b></td>");
//                                "<td  width=\"180px\" align=\"right\"><b><font size=\"5\"><b>"  + d1.format(a6) + "</b></font></b></td></tr>");
//                        builder.append("<tr><td width=\"30px\"><b><font size=\"5\"><b></b></font></b></td>" +
//                                "<td width=\"280px\" ><b><font size=\"5\"><b>Percentage</b></font></b></td>" +
//                                "<td  width=\"180px\" align=\"right\"><b><font size=\"5\"><b>" + d2.format(a5) + "%</b></font></b></td></tr>");
//                        builder.append("<tr><td width=\"30px\"><b><font size=\"5\"><b></b></font></b></td>" +
//                                "<td width=\"280px\" ><b><font size=\"5\"><b>Fine</b></font></b></td>" +
//                                "<td  width=\"180px\" align=\"right\"><b><font size=\"5\"><b>" + d1.format(a7) + "</b></font></b></td></tr>");
//                        builder.append("<tr><td width=\"30px\"><b><font size=\"5\"><b></b></font></b></td>" +
//                                "<td width=\"280px\" ><b><font size=\"5\"><b>Rate</b></font></b></td>" +
//                                "<td  width=\"180px\" align=\"right\"><b><font size=\"5\"><b>" + d2.format(a7) + "</b></font></b></td></tr>");
//                        builder.append("<tr><td width=\"30px\"><b><font size=\"5\"><b></b></font></b></td>" +
//                                "<td width=\"280px\" ><b><font size=\"5\"><b>Total Amt</b></font></b></td>" +
//                                "<td  width=\"180px\" align=\"right\"><b><font size=\"5\"><b>" + d2.format(a8) + "</b></font></b></td></tr>");

                    }
                } while (cr.moveToNext());
                           }

            t=6;
        }
        builder.append("<tr><td colspan=\"3\"><center><b>---------------------------------------------------------------------------------------</b></center></td></tr>");
        DecimalFormat dc2 = new DecimalFormat("0.00");

        builder.append("<tr><td width=\"280px\" colspan=\"3\" ><b><font size=\"6\"><b>Rate "+ a7 +" X "+ d1.format(q)+"  =  "+dc2.format(a8)+" </b></font></b></td>" );
//                "<td  width=\"180px\" align=\"right\"><b><font size=\"5\"><b>" + p + "</b></font></b></td></tr>");
        if (t==5)
//        {builder.append("<tr><td colspan=\"3\"><center><b>---------------------------------------------------------------------------------------</b></center></td></tr>");}
        builder.append("<tr><td colspan=\"3\"><center><b>Thank You</b></center></td></tr>");

//        builder.append("<tr><td colspan=\"3\"><center><b>---------------------------------------------------------------------------------------</b></center></td></tr>");

        int x= 1500,j=1;
//        j++;
//        if (j < 6) {
//            x = x + 45;
//        } else if (j < 45) {
//            x = x + 30;
//            x = x + 30;
//        } else {
//            x = x + 45;
//        }
        builder.append("</table></html>");

                webview = (WebView) findViewById(R.id.webview);
                webview.loadData(builder.toString(), "text/html", "UTF-8");
                new BillImage(SalesPage.this, 70, builder.toString(), webview.getId(),x);


    }
    //+++++++++++++++++++WEB ++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Override
    public void onImageCreated(Bitmap bmp, int w, int h) {
        DebugLog.logTrace("w: " + w + " h: " + h);
        this.bmp = bmp.copy(Bitmap.Config.ARGB_8888, true);
        // imagePreview.setImageBitmap(this.bmp);
        try {
            String path = Environment.getExternalStorageDirectory()
                    .toString();
            OutputStream fOut;
            File file = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "test.png");
            file.createNewFile();
            fOut = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
//        bmp.recycle();
    }

    //+++++++++++++++++++END ++++++++++++++++++++++++++++++++++++++++++++++++++++++


    public void nextBno()
    {
        int count=0;
        Cursor cr=PDb.getAllBillNo();
        if(cr==null)
        Log.d("newTest1","Yes" );
        setCurDate();
        cr.moveToFirst();
        if(cr!=null) {
            count = cr.getCount();
            String cnt = String.valueOf(count);
            if (count == 0) {
                String ct=String.valueOf(count + 1);
                bt1.setText(ct);
                Log.d("newTest1 true 0", ct);
            } else if (count > 0) {
                bt1.setText(cnt);
                bn = count + 1;
                Log.d("newTest1 true >1", cnt);
                gettabdataforNew(bn);
            }
        }

    }
    public void nextBnoSub()
    {
        int count=0;
        int x=0;
        try{x=Integer.valueOf(bt1.getText().toString());}catch (Exception e){}
        Cursor cr=PDb.getAllBillNoSub(x);

        cr.moveToFirst();
        count=cr.getCount();
//        if (cr==null)
//        Toast.makeText(SalesPage.this, "Yes",Toast.LENGTH_LONG).show();
//        else
//            Toast.makeText(SalesPage.this, "No",Toast.LENGTH_LONG).show();
        String cnt=String.valueOf(count);
        if(count==0)
        {st5.setText("1");}

        else
        {
            count=count;
            st5.setText(String.valueOf(count));
            bns=count+1;

            }


    }
    public int getNextItmNInBil()
    {
        String x="",y="";
        int n=0;
        try{x=bt1.getText().toString();y=st5.getText().toString();
            }catch (Exception e){}
        Cursor cr=PDb.getNextItmNoInBill(x, y);
        n=cr.getCount();
        n=n+1;
        return n;
    }


    public void setCurDate()
    {
        int year,month,day;
        bdate="";btime="";
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c.getTime());
        bt2.setText(formattedDate);
//        Toast.makeText(ctx, formattedDate,Toast.LENGTH_LONG).show();
        SimpleDateFormat df1 = new SimpleDateFormat("HH:MM");
        String formattedDate1 = df1.format(c.getTimeInMillis());
        //Toast.makeText(ctx, formattedDate1.toString() , Toast.LENGTH_LONG).show();
        bdate=formattedDate;
        btime=formattedDate1;


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        gsln=0;gbns=0;
        int bn=0,sbn=0;
        gwts=0.0;
        String sln1="", bns="";
        gitm="";

        sln1 =((TextView)view.findViewById(R.id.bd2)).getText().toString();
        gsln=Integer.valueOf(sln1);
        bns =((TextView)view.findViewById(R.id.bd1)).getText().toString();
        //Toast.makeText(ctx, gitm+" "+sln1 , Toast.LENGTH_LONG).show();
        sbn=Integer.valueOf(bns);
           try{bn=Integer.valueOf(bt1.getText().toString());}catch(Exception e){}
        Cursor cr=null;
        try
        {
            cr=PDb.findSalsByBn_Sln_Itm(bn,sbn,gsln);
        }catch(Exception e){}
        if(cr!=null){
            gbns=cr.getInt(2);
            gsln=cr.getInt(3);
            gitm=cr.getString(4);
            gwts=cr.getDouble(5);
       st5.setText(String.valueOf(gbns));
        st3.setText(gitm);
        st4.setText(String.valueOf(gwts));


            Cursor cur=PDb.findBillByBn_sbn(bn,sbn);
            if(cur.getCount()!=0){
                bt4.setText(String.valueOf(cur.getDouble(5)));
                bt5.setText(String.valueOf(cur.getDouble(6)));
                bt6.setText(String.valueOf(cur.getDouble(7)));
                bt7.setText(String.valueOf(cur.getDouble(8)));
                bt8.setText(String.valueOf(cur.getDouble(9)));
                adds.setEnabled(false);

            }
            else{
                bt5.setText("");
                bt6.setText("");
                bt7.setText("");
                bt8.setText("");}
            getTotWt();}
    }
    public void addRate(View view)
    {
        showInputDialog();
    }
    protected void showInputDialog() {

        int x=0;
        double a7=0,q=0;
        try{x=Integer.valueOf(bt1.getText().toString());}catch (Exception er){}
        PDb=new ProDBase();
        Cursor cr= PDb.getAllBillData(x);


        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(SalesPage.this);

        View promptView = layoutInflater.inflate(R.layout.activity_sold_item_layout, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SalesPage.this);
        alertDialogBuilder.setTitle("Enter the RATE");
        alertDialogBuilder.setView(promptView);
        if (cr.getCount() != 0) {
            cr.moveToFirst();
            do {

                a7 = cr.getDouble(7);
                q = q + a7;
            } while (cr.moveToNext());
        }
        final EditText txt1 = (EditText) promptView.findViewById(R.id.fins);
        final EditText txt2 = (EditText) promptView.findViewById(R.id.rats);
        final EditText txt3 = (EditText) promptView.findViewById(R.id.tots);

            txt1.setText(String.valueOf(q));

        //======================
        txt2.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View arg0, boolean arg1) {
                double a = 0, b = 0, c = 0;
                try {

                    DecimalFormat d1 = new DecimalFormat("0.00");
                    DecimalFormat d2 = new DecimalFormat("0.000");
                    a = Double.valueOf(txt1.getText().toString());
                    b = Double.valueOf(txt2.getText().toString());
                    c = a * b;

                    txt3.setText(String.valueOf(d1.format(c)));
                } catch (Exception e) {
                }
                //	Toast.makeText(ctx, "Total Focused" , Toast.LENGTH_LONG).show();

            }
        });
        //=========================

        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int x0=0;
                        double x1=0.0,x2=0.0,x3=0.0;
                        try{x0=Integer.valueOf(bt1.getText().toString());
                            x2=Double.valueOf(txt3.getText().toString());
                             x1=Double.valueOf(txt2.getText().toString());
                            x3=Double.valueOf(txt1.getText().toString()); }catch (Exception e){}
                        //bt8.setVisibility(View.VISIBLE);
                        DecimalFormat d1 = new DecimalFormat("0.00");
                        DecimalFormat d2 = new DecimalFormat("0.000");
                        bt7.setText(String.valueOf(d2.format(x1)));
                        bt8.setText(String.valueOf(d1.format(x2)));
                        bt9.setText(String.valueOf(d1.format(x3)));
                        boolean b=PDb.editTotRats(x0,x1,x2);
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        int sln=0,itmcod,qty;
        double prc;
        final String sln1,bns;
        //Toast.makeText(ctx, "Long Clicked", Toast.LENGTH_LONG).show();

        bns =((TextView)view.findViewById(R.id.bd1)).getText().toString();
        sln1 =((TextView)view.findViewById(R.id.bd2)).getText().toString();

        //String inam=((TextView)view.findViewById(R.id.c2)).getText().toString();
        AlertDialog.Builder ab=new AlertDialog.Builder(ctx);

        ab.setTitle("Delete");

        ab.setMessage("Do you Want to Delete " + sln1);
        //Toast.makeText(ctx, "Long Clicked"+sln1, Toast.LENGTH_LONG).show();
        ab.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int x0 = 0,x1=0,x2=0;
                x0 = Integer.valueOf(bt1.getText().toString());
                x1 = Integer.valueOf(bns);
                x2 = Integer.valueOf(sln1);
                PDb = new ProDBase();
                boolean flag = false;

                flag = PDb.delSalItmBySln(x0,x1,x2);
                if (flag) {
                    Toast.makeText(ctx, "Item Deleted Successfully", Toast.LENGTH_LONG).show();
                    arrangeList(x0, x1, x2);
                    gettabdata(x0);;
                    gettabdataforNew(x0);
                    getTotWt();
                    adds.setEnabled(true);
                    st3.setText("");st4.setText("");
                    //modify bills table after del rec---------------------
//                    stxt1=stbno.getText().toString();
//                    stt1=Integer.valueOf(stxt1.toString());
//                    stxt10=sdt.getText().toString();
//                    String sts="";
//                    if(btot==0){sts="Deleted";}else{sts="Modified";}
//                    pdb.modifyBillsDataOnDel(stt1, btot,sts,stxt10);
                    //------------------------------------------------------
                    dialog.dismiss();
                } else {
                    Toast.makeText(ctx, "Sorry Failed To Deleted", Toast.LENGTH_LONG).show();
                }

            }


        });
        ab.show();
        return false;
    }
    public void arrangeList(int x0,int x1,int x2)
    {

        Cursor cur= PDb.getSalItmsList(x0, x1);
        cur.moveToFirst();
        int i=x2,j=x2+1,k=x1,siz=0,l=0;

        siz=cur.getCount();
        String itms[]=new String[siz];

        if(siz!=0)
        {

            do
            {


//                j=cur.getInt(2);
//                itms[k]=String.valueOf(j);

                PDb.modifySalItmForSlnRearange(i, j,x0,k);
                i++;
                j++;


            }while(cur.moveToNext());
            cur.close();
        }
    }
    public int diffs(double oldval,double newval)
    {
        int x=0;
        if(oldval!=newval)
        {}
        return x;
    }
    public void  checkPayment(int x)
    {

       // nextBno();
        setCurDate();
       // int x=0;
        x=Integer.valueOf(bt1.getText().toString());
        Cursor crs=PDb.findPaid(x);
        if(crs!=null) {
            if (crs.getCount()!= 0) {
                adds.setEnabled(false);
                sav.setEnabled(false);

                btnsub.setEnabled(false);
                adRat.setEnabled(false);
                btnclr.setEnabled(false);
                btnedt.setEnabled(false);
            } else {
                adds.setEnabled(true);
                sav.setEnabled(true);

                btnsub.setEnabled(true);
                adRat.setEnabled(true);
                btnclr.setEnabled(true);
                btnedt.setEnabled(true);
            }
        }
    }

}
class SpecialCursorAdapter extends SimpleCursorAdapter


{
    private int[] colors = new int[] { 0xFF6600, 0xFFFFFFFF };
    Context ctx;
    int lout;
    Cursor c;
    public SpecialCursorAdapter(Context context, int layout, Cursor cr, String[] from, int[] to)
    {
        super(context,layout, cr, from, to);
        ctx=context;lout=layout;c=cr;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = View.inflate(ctx, lout, null);
        View row = convertView;
        c.moveToPosition(position);

        TextView x1 = (TextView) convertView.findViewById(R.id.bd1);
        TextView x2 = (TextView) convertView.findViewById(R.id.bd2);
        TextView x3 = (TextView) convertView.findViewById(R.id.bd3);
        TextView x4 = (TextView) convertView.findViewById(R.id.bd4);


        DecimalFormat df1 = new DecimalFormat("0.000");
        Double wts = c.getDouble(5);

        x1.setText(String.valueOf(c.getInt(2)));
        x2.setText(String.valueOf(c.getInt(3)));
        x3.setText(String.valueOf(c.getString(4)));
        x4.setText(df1.format(wts));


        return row;
    }

}
