package com.vachana.com.vtsmartjewels.printlibs;

import android.graphics.Bitmap;

public interface LibraryMessageListener {
    void onImageCreated(Bitmap bmp, int w, int h);
}
