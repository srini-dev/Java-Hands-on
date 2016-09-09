package com.vachana.com.vtsmartjewels.printlibs;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cie.btp.DebugLog;
import com.vachana.com.vtsmartjewels.printlibs.bean.Bill;

public class BillImage {
    private WebView mWebView;
    private Bill bil;
    private int width = 0;
    private int height = 0;
    private int lins=2200;
    private LibraryMessageListener mListener;
    private Activity activity;
    private String name = "";
    private String html = "<p>No Data yet</p>";


    public BillImage(final Activity activity, int printerSize, String data,int id,int lin) {
        DebugLog.setDebugMode(true);
        this.activity = activity;
        //lin=lin*75;
        //lins=lin;
        this.mListener = (LibraryMessageListener) activity;
        CustomRelativeLayout popWindow = new CustomRelativeLayout(activity);
        mWebView = popWindow.getTheWebView();
        mWebView = (WebView)activity.findViewById(id);
        mWebView.setDrawingCacheEnabled(true);
        mWebView.setInitialScale(100);
        mWebView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                //Toast.makeText(activity, "onPageFinished", Toast.LENGTH_SHORT).show();
                DebugLog.logTrace("width: " + mWebView.getMeasuredWidth() + " width: " + view.getMeasuredWidth());
                DebugLog.logTrace("height: " + mWebView.getMeasuredHeight() + " height: " + view.getMeasuredHeight());
                Bitmap bitmap = Bitmap.createBitmap(584, 5000, Bitmap.Config.ARGB_8888);
                int xx=view.getMeasuredHeight();

                Log.d("WebSize", String.valueOf(xx));
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                int iHeight = bitmap.getHeight();
                canvas.drawBitmap(bitmap, 0, 0, paint);
                mWebView.draw(canvas);
                saveImage(bitmap, "");
            }
        });
        String htmlDocument = "<html><head><body>" +
                data +
                "</body></head></html>";
        mWebView.loadDataWithBaseURL(null, htmlDocument, "text/HTML", "UTF-8", null);
    }

    private void init(Context context) {
        this.mListener = (LibraryMessageListener) context;
    }

    private boolean saveImage(Bitmap bmp, String name) {
        DebugLog.logTrace();
        if (bmp != null) {
            mListener.onImageCreated(bmp, 584, 110);
        }
//        mWebView.destroy();
        return false;
    }


    class Background extends AsyncTask<Void, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            final Bitmap bitmap = Bitmap.createBitmap(584, 110, Bitmap.Config.ARGB_8888);
            activity.runOnUiThread(
                    new Runnable() {
                        public void run() {
                            Canvas canvas = new Canvas(bitmap);
                            mWebView.draw(canvas);
                        }
                    });
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            saveImage(result, name);
        }
    }

    public class CustomRelativeLayout extends RelativeLayout {

        private WebView mWebView;

        public CustomRelativeLayout(Context context) {
            super(context);
            mWebView = new CustomWebView(context);
            mWebView.setScrollContainer(false);
            LayoutParams params = new LayoutParams(584, 110);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            mWebView.setLayoutParams(params);
            addView(mWebView);
        }

        public WebView getTheWebView() {
            return mWebView;
        }
    }
}




