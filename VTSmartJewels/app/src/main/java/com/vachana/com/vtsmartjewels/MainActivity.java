package com.vachana.com.vtsmartjewels;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.cie.btp.CieBluetoothPrinter;

import VTDb.ProDBase;

public class MainActivity extends AppCompatActivity {

    Context ctx=this;
    TextView t1,t2,t3,t4;
    public static CieBluetoothPrinter mPrinter = CieBluetoothPrinter.INSTANCE;
    private App app;
    ProDBase proDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new App(MainActivity.this);
        app=(App) getApplication();
        t1= (TextView) findViewById(R.id.ttl1);
        t2= (TextView) findViewById(R.id.ttl2);
        t3= (TextView) findViewById(R.id.ttl3);

        proDB=new ProDBase();
        //=========================Printer===================


        BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mAdapter == null) {
            Toast.makeText(this, "Bt not support", Toast.LENGTH_SHORT).show();
            finish();
        }
        app.initPrinters(MainActivity.this);


        //=========================Printer Ends===================
    }

    public void getLogin(View view)
    {
        startActivity(new Intent(MainActivity.this, HomePage.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
