package com.example.proiectandroid3;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;

public class DesenPieChart extends View {
    public DesenPieChart(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        for (int i = 0; i < 1; i++) {
            paint.setColor(Color.rgb(0,0,255));

            Paint paint2 = new Paint();
            paint2.setColor(Color.WHITE);
            paint2.setStyle(Paint.Style.FILL);
            canvas.drawPaint(paint2);

            paint2.setColor(Color.BLACK);
            paint2.setTextSize(50);
            canvas.drawText("Masini virtuale vs containere 60%-40%", 20, 50, paint2);

            canvas.drawArc(
                    100,
                    100,
                    600,
                    600,
                    0,
                    144,
                    true,
                    paint
            );
            paint.setColor(Color.rgb(0,255,0));
            canvas.drawArc(
                    100,
                    100,
                    600,
                    600,
                    144,
                    216,
                    true,
                    paint
            );
        }
    }
}
