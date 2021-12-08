package com.example.course_project_tot.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.course_project_tot.View.CreateGoalPresenter;
import com.example.course_project_tot.R;

import java.time.LocalDate;

public class CreateGoalActivity extends AppCompatActivity implements CreateGoalPresenter.View {
    private CreateGoalPresenter presenter;
    private LocalDate date;

    private TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_goal);

        Intent intent = getIntent();
        date = (LocalDate) intent.getSerializableExtra("date");

        presenter = new CreateGoalPresenter(this);

        dateText = findViewById(R.id.editTextDate);
        updateDate(date);
    }


    /**
     * On click listener for "Create Goals" button. A goal is created with values from the text fields
     * and added to the list of goals of the current user.
     * @param view Object that triggered the event.
     */
    public void createGoal(View view) {
        EditText nameText = findViewById(R.id.editTextName);
        EditText descriptionText = findViewById(R.id.editTextDescription);
        EditText numHoursText = findViewById(R.id.editTextNumberHours);

        presenter.addGoal(date, nameText, descriptionText, numHoursText);
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void updateDate(LocalDate date) {
        dateText.setText(date.toString());
    }

    @Override
    public void setNameError(String error) {
        EditText nameText = findViewById(R.id.editTextName);
        nameText.setError(error);
    }
}
