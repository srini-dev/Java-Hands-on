package com.vachana.com.vtsmartjewels;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cie.btp.CieBluetoothPrinter;

import VTDb.ProDBase;

public class HomePage extends AppCompatActivity {

    Context ctx=this;
    public static CieBluetoothPrinter mPrinter = CieBluetoothPrinter.INSTANCE;
    private App app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        new App(HomePage.this);
        app=(App) getApplication();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //=========================Printer===================


        BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mAdapter == null) {
            Toast.makeText(this, "Bt not support", Toast.LENGTH_SHORT).show();
            finish();
        }
        app.initPrinters(HomePage.this);


        //=========================Printer Ends===================


    }
    public void showConfigs(View view)
    {
        app.showPrinter(HomePage.this);
        // startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
    }
    public void showSales(View view)
    {
        startActivity(new Intent(HomePage.this, SalesPage.class));
    }
    public void showAbout(View view)
    {


        //String inam=((TextView)view.findViewById(R.id.c2)).getText().toString();
        AlertDialog.Builder ab=new AlertDialog.Builder(ctx);

        ab.setTitle("Contact ");
        ab.setMessage("For More Different Kind of Billing Apps\nD Srinivas  \nPhone 97432929271 \nYelahanka New Town \nBangalore - 64");


        ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }


        });
        ab.show();
    }
    public void showPays(View view)
    {
        startActivity(new Intent(HomePage.this, PayActivity.class));
    }

}
