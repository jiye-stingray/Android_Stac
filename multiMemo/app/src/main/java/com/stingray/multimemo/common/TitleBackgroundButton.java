package com.stingray.multimemo.common;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.annotation.RequiresApi;

public class TitleBackgroundButton extends androidx.appcompat.widget.AppCompatButton {

    public TitleBackgroundButton(Context context) {
        super(context);
    }

    public TitleBackgroundButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitleBackgroundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
