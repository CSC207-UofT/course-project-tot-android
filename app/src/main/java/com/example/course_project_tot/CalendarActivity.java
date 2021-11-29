package com.example.course_project_tot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.course_project_tot.Ucontroller.PomodoroController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarActivity extends AppCompatActivity {
    //TODO: Move to user
    public static Map<LocalDate, List<Goal>> goals = new HashMap<>();

    private LocalDate curDate;

    private LinearLayout scrollLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        CalendarView calendarView = findViewById(R.id.calendarView);
        Button createGoalButton = findViewById(R.id.createGoalButton);
        scrollLinearLayout = findViewById(R.id.ll);

        curDate = LocalDate.now();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                curDate = LocalDate.of(year, month, day);
                updateGoals(curDate);
            }
        });
    }

    /**
     * Updates the list of goals for the current date.
     * @param date Date goals should be on.
     */
    public void updateGoals(LocalDate date) {
        scrollLinearLayout.removeAllViews();
        if (goals.containsKey(curDate)) {
            List<Goal> goalsOnDate = goals.get(curDate);
            for (int i = 0; i < goalsOnDate.size(); i++) {
                TextView textView = new TextView(this);
                textView.setText(goalsOnDate.get(i).getName());
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CalendarActivity.this, PomodoroController.class);
                        startActivity(intent);
                    }
                });
                scrollLinearLayout.addView(textView);
            }
        }
    }

    /**
     * On click listener for "Create Goals" button. Moves to the create goal activity.
     * @param view Object that triggered the event.
     */
    public void goToCreateGoal(View view) {
        Intent intent = new Intent(this, CreateGoalActivity.class);
        intent.putExtra("date", curDate);
        startActivity(intent);
    }
}