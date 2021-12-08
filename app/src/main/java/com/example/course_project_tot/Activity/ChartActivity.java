package com.example.course_project_tot.Activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.course_project_tot.Controller.LineChartController;
import com.example.course_project_tot.Controller.BarChartController;
import com.example.course_project_tot.R;
import com.jjoe64.graphview.GraphView;

import java.time.LocalDate;


public class ChartActivity extends AppCompatActivity {
    private Button find;
    // creating a variable
    // for our graph view.
    GraphView graphView1;
    GraphView graphView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        graphView1 = findViewById(R.id.idGraphView1);

        graphView1.setTitle("30days Accomplishment Line Chart");

        graphView1.setTitleColor(R.color.purple_200);

        graphView1.setTitleTextSize(70);
        // on below line we are adding
        // data series to our line graph view.
        LineChartController series1 = new LineChartController();
        graphView1.addSeries(series1.getSeries(LocalDate.now().minusDays(30)));


        graphView2 = findViewById(R.id.idGraphView2);

        graphView2.setTitle("30days Accomplishment Bar Chart");

        graphView2.setTitleColor(R.color.purple_200);

        graphView2.setTitleTextSize(70);
        // on below line we are adding
        // data series to our graph view.
        BarChartController series2 = new BarChartController();
        graphView2.addSeries(series2.getSeries(LocalDate.now().minusDays(30)));
    }

}