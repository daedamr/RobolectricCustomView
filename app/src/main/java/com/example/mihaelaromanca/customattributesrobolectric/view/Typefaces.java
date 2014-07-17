package com.example.mihaelaromanca.customattributesrobolectric.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.example.mihaelaromanca.customattributesrobolectric.R;

import java.util.Hashtable;

public class Typefaces {
    private static final String TAG = "Typefaces";

    private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

    public static Typeface get(Context c, String name) {
        synchronized(cache){
            if(!cache.containsKey(name)){
                try {
                    Typeface t = Typeface.createFromAsset(
                            c.getAssets(),
                            String.format("font/%s", name)
                    );
                    cache.put(name, t);
                } catch (Exception e) {
                    Log.e(TAG, "Could not get typeface '" + name
                            + "' because " + e.getMessage());
                    return null;
                }

            }
            return cache.get(name);
        }
    }

    public static Typeface getTitilliumBold(Context c) {
        return get(c, "TitilliumText22L-Bold.otf");
    }

    public static Typeface getTitilliumRegular(Context c) {
        return get(c, "TitilliumText22L-Regular.otf");
    }

    public static void setCustomFont(Context ctx, AttributeSet attributeSet, TextView view) {
        final TypedArray a = attributeSet != null ? ctx.obtainStyledAttributes(attributeSet, R.styleable.ViewTitilliumFont) : null;
        final Typeface typeface = view.getTypeface();
        final String customFont = a != null ? a.getString(R.styleable.ViewTitilliumFont_customFont) : null;
        view.setTypeface(customFont != null ? Typefaces.get(ctx, customFont) : typeface != null && typeface.getStyle() == Typeface.BOLD ?
                Typefaces.getTitilliumBold(ctx) : Typefaces.getTitilliumRegular(ctx));
        if (a != null) {
            a.recycle();
        }
    }

}
