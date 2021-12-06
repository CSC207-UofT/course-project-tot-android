package com.example.course_project_tot.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.course_project_tot.FromJSon;
import com.example.course_project_tot.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;



public class ChartActivity extends AppCompatActivity {

    // creating a variable
    // for our graph view.
    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        graphView = findViewById(R.id.idGraphView);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        for (DataPoint d : FromJSon.returnFromJson()) {
            series.appendData(d, true, 30);
        }


        graphView.setTitle("My Graph View");


        graphView.setTitleColor(R.color.purple_200);


        graphView.setTitleTextSize(18);

        // on below line we are adding
        // data series to our graph view.
        graphView.addSeries(series);

    }

}