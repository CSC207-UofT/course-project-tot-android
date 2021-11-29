package com.example.course_project_tot.UModel;

import android.os.CountDownTimer;
import android.view.View;

import java.util.Locale;

public class PomodoroModel {
    private static final long START_TIME_IN_MILLIS = 1200000;

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    public void turnOn(){
        mTimerRunning = true;
    }

    public void turnOff(){
        mTimerRunning = false;
    }

    public boolean getStatus(){
        return mTimerRunning;
    }

}
