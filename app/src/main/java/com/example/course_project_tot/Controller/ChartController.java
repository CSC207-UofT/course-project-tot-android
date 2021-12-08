package com.example.course_project_tot.Controller;

import android.graphics.Canvas;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.BaseSeries;
import com.jjoe64.graphview.series.DataPointInterface;

import java.time.LocalDate;


public abstract class ChartController {
    private BaseSeries<DataPoint> series;

    public ChartController() {

    }
    public BaseSeries<DataPoint> getSeries(LocalDate date){
        return this.series;

    }


}
