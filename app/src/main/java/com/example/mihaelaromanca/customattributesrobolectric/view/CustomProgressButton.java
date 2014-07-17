package com.example.mihaelaromanca.customattributesrobolectric.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.mihaelaromanca.customattributesrobolectric.R;

public class CustomProgressButton extends RelativeLayout {
    private ProgressBar progressBar;
    private Button button;

    public CustomProgressButton(Context context) {
        super(context);
        init(context, null);
    }

    public CustomProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomProgressButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        final View view = inflate(context, R.layout.progress_button, this);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        button = (Button) view.findViewById(R.id.button);

        button.setText(getTextFromAttributes(attrs, context));
    }

    protected String getTextFromAttributes(AttributeSet attrs, Context  context) {
        final TypedArray a = attrs != null
                ? context.obtainStyledAttributes(attrs, R.styleable.CustomProgressButton) : null;

        if (a != null) {
            final String text = a.getString(R.styleable.CustomProgressButton_text);
            a.recycle();
            return text;
        }

        return null;
    }

    public void startProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void stopProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setOnClickListener(View.OnClickListener l) {
        super.setOnClickListener(l);
        button.setOnClickListener(l);
    }

    public Button getButton() {
        return button;
    }

    public CharSequence getText() {
        return button.getText();
    }
}
