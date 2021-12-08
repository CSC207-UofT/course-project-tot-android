package com.example.course_project_tot.Controller;

import com.example.course_project_tot.Modele.User;
import com.example.course_project_tot.Modele.UserList;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.time.LocalDate;


public class LineChartController extends ChartController {
    private LineGraphSeries<DataPoint> series;

    public LineChartController() {
        this.series = new LineGraphSeries<>();
    }

    @Override
    public LineGraphSeries<DataPoint> getSeries(LocalDate date){
        for(int day =0; day < 31; day++){

            int time = 0;

            DataPoint point = new DataPoint(day,time);
            this.series.appendData(point, true, 30);
            date = date.plusDays(1);
        }

        return this.series;
    }


}