package com.example.selflearning;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

public class CustomizedView extends View {
    public CustomizedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomizedView);

        int color = ta.getColor(R.styleable.CustomizedView_color, 0xffff0000);
        setBackgroundColor(color);

        ta.recycle();
    }
    public CustomizedView(Context context) {
        super(context);
    }
}
