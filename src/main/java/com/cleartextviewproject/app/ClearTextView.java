package com.cleartextviewproject.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author Margarita Litkevych
 * @version 1.0
 */
public class ClearTextView extends TextView {

    public ClearTextView(Context context) {
        super(context);
    }

    public ClearTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClearTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (w > 0 && h > 0) {
            Bitmap bg = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

            Canvas canvas = new Canvas(bg);
            Drawable drawable = getBackground();
            if (drawable != null) {
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            }

            Bitmap bp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            setBackground(null);
            setTextColor(Color.BLACK);
            draw(new Canvas(bp));

            Paint eraserPaint = new Paint();
            eraserPaint.set(getPaint());
            eraserPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            canvas.drawBitmap(bp, 0, 0, eraserPaint);

            setBackground(new BitmapDrawable(getResources(), bg));
            setTextColor(Color.TRANSPARENT);
        }
    }
}
