package com.vachana.com.vtsmartjewels.printlibs;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import com.cie.btp.DebugLog;

public class CustomWebView extends WebView {

    private int maxHeightPixels = 500;

    public CustomWebView(Context context, AttributeSet attrs, int defStyle,
                         boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
    }

    public CustomWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CustomWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomWebView(Context context) {
        super(context);
    }

    public void setMaxHeight(int pixels) {
        maxHeightPixels = pixels;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DebugLog.logTrace();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (maxHeightPixels > -1 && getMeasuredHeight() > maxHeightPixels) {
            setMeasuredDimension(getMeasuredWidth(), maxHeightPixels);
        }
    }
}