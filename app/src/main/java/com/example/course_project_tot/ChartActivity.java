package com.example.course_project_tot;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ChartActivity extends Activity {
    LinearLayout linearChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearChart = (LinearLayout) findViewById(R.id.linearChart);
        int color_loop[] = { 1, 2, 2, 2, 3, 3, 3, 3, 1, 1 };
        int heightLoop[] = { 300, 200, 200, 200, 100, 100, 100, 100, 300, 300 };
        for (int j = 0; j < color_loop.length; j++) {
            drawChart(1, color_loop[j], heightLoop[j]);
        }
    }

    public void drawChart(int count, int color, int height) {
        System.out.println(count + color + height);
        if (color == 3) {
            color = Color.RED;
        } else if (color == 1) {
            color = Color.BLUE;
        } else if (color == 2) {
            color = Color.GREEN;
        }

        for (int k = 1; k <= count; k++) {
            View view = new View(this);
            view.setBackgroundColor(color);
            view.setLayoutParams(new LinearLayout.LayoutParams(25, height));
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view
                    .getLayoutParams();
            params.setMargins(3, 0, 0, 0); // substitute parameters for left,
            // top, right, bottom
            view.setLayoutParams(params);
            linearChart.addView(view);
        }
    }
}