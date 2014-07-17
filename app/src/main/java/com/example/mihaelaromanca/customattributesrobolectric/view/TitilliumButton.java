package com.example.mihaelaromanca.customattributesrobolectric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class TitilliumButton extends Button {
    public TitilliumButton(Context context) {
        super(context);
        Typefaces.setCustomFont(context, null, this);
    }

    public TitilliumButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typefaces.setCustomFont(context, null, this);
    }

    public TitilliumButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typefaces.setCustomFont(context, null, this);
    }
}
