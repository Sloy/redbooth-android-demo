package com.sloydev.redbooth.view.component;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.jmpergar.awesometext.AwesomeTextHandler;
import com.sloydev.redbooth.R;

public class UrgentSpanRenderer implements AwesomeTextHandler.ViewSpanRenderer {
    @Override public View getView(String text, Context context) {
        TextView label = new TextView(context);
        label.setBackgroundResource(R.drawable.span_urgent_background);
        label.setTextSize(dipsToPixels(context, 14));
        label.setTextColor(context.getResources().getColor(R.color.white));
        label.setText(R.string.label_urgent);
        return label;
    }

    public static int dipsToPixels(Context ctx, float dips) {
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (dips * scale + 0.5f);
    }
}
