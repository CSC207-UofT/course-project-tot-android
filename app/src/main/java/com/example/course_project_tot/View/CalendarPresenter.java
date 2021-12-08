package com.example.course_project_tot.View;

import android.content.Context;

import java.time.LocalDate;

public class CalendarPresenter {
    private View view;

    public CalendarPresenter(View view){
        this.view = view;
    }


    public interface View {
        void updateGoalList(LocalDate date, Context context);
    }
}
