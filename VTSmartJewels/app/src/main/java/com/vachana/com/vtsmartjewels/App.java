package com.vachana.com.vtsmartjewels;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.Layout;
import android.text.TextPaint;
import android.widget.Toast;

import com.cie.btp.CieBluetoothPrinter;
import com.cie.btp.DebugLog;
import com.cie.btp.PrinterWidth;

/**
 * Created by user on 25/11/2015.
 */
public class App extends Application
{

    final Messenger mMessenger = new Messenger(new PrintSrvMsgHandler());
    private String mConnectedDeviceName = "name: ";
    public static final String title_connecting = "connecting...";
    public static final String title_connected_to = "connected: ";
    public static final String title_not_connected = "not connected";
    public static CieBluetoothPrinter mPrinter = CieBluetoothPrinter.INSTANCE;
    Context ctx;
    private Activity a;

    public App(){}
    public App(Context ct)
    {
        ctx=ct;
    }
    public void initPrinters(Activity a)
    {
        this.a = a;
        try {
            mPrinter.initService(a, mMessenger);
            mPrinter.setPrinterWidth(PrinterWidth.PRINT_WIDTH_104MM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class PrintSrvMsgHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CieBluetoothPrinter.MESSAGE_STATE_CHANGE:
                    switch (msg.arg1) {
                        case CieBluetoothPrinter.STATE_CONNECTED:
                            setStatusMsg(title_connected_to + mConnectedDeviceName);

                            break;
                        case CieBluetoothPrinter.STATE_CONNECTING:
                            setStatusMsg(title_connecting);

                            break;
                        case CieBluetoothPrinter.STATE_LISTEN:
                            setStatusMsg(title_connected_to + mConnectedDeviceName);
                        case CieBluetoothPrinter.STATE_NONE:
                            setStatusMsg(title_not_connected);

                            break;
                    }
                    break;
                case CieBluetoothPrinter.MESSAGE_DEVICE_NAME:
                    mConnectedDeviceName = msg.getData().getString(
                            CieBluetoothPrinter.DEVICE_NAME);
                    break;
                case CieBluetoothPrinter.MESSAGE_STATUS:
                    DebugLog.logTrace("Message Status Received");
//                    setStatusMsg(msg.getData().getString(
//                            CieBluetoothPrinter.STATUS_TEXT));
                    break;
                case CieBluetoothPrinter.PRINT_COMPLETE:
                    setStatusMsg("PRINT OK");
                    break;
                case CieBluetoothPrinter.PRINTER_CONNECTION_CLOSED:
                    setStatusMsg("Printer Connection closed");
                    break;
                case CieBluetoothPrinter.PRINTER_DISCONNECTED:
                    setStatusMsg("Printer Connection failed");
                    break;
                default:
                    DebugLog.logTrace("Some un handled message : " + msg.what);
                    super.handleMessage(msg);
            }
        }
    }

    private void setStatusMsg(String s) {
        Toast.makeText(a, s, Toast.LENGTH_SHORT).show();
    }
    public void showPrinter(Activity act)
    {
        mPrinter.showDeviceList(act);
    }
    public void onActivityResult(int requestCode,int resultCode, Activity a){
        mPrinter.onActivityResult(requestCode, resultCode, a);
    }
    public void printUnicodeText(String s, Layout.Alignment alignNormal, TextPaint mDefaultTextPaint){
        // mPrinter.printUnicodeText(s, alignNormal, mDefaultTextPaint);
    }
    public void printDirect(Bitmap bmp){
        mPrinter.printDirect(bmp,true,127);
    }

}
