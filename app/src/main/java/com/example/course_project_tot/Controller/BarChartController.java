package com.example.course_project_tot.Controller;

import com.example.course_project_tot.Modele.User;
import com.example.course_project_tot.Modele.UserList;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.BarGraphSeries;

import java.time.LocalDate;


public class BarChartController extends ChartController {
    private BarGraphSeries<DataPoint> series;

    public BarChartController() {
        this.series = new BarGraphSeries<>();
    }

    @Override
    public BarGraphSeries<DataPoint> getSeries(LocalDate date){
        for(int day =0; day < 31; day++){

            int time = 0;
            DataPoint point = new DataPoint(day,time);
            this.series.appendData(point, true, 30);
            date = date.plusDays(1);
        }

        return this.series;
    }



}
