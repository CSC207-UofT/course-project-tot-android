package com.example.course_project_tot;

import android.widget.EditText;
import com.example.course_project_tot.Controller.LoginController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateGoalPresenter {
    private View view;

    public CreateGoalPresenter(View view) {
        this.view = view;
    }

    public void updateDate(LocalDate date) {
        view.updateDate(date);
    }

    public void addGoal(LocalDate date, EditText nameText, EditText descriptionText, EditText numHoursText) {
        String name = nameText.getText().toString();
        String description = descriptionText.getText().toString();
        String numHours = numHoursText.getText().toString();
        int hours = 1;
        if (name.isEmpty()) {
            view.setNameError("Name cannot be empty");
        }
        if (!numHours.isEmpty()) {
            hours = Integer.parseInt(numHours);
        }
        Goal goal = new Goal.Builder(name).description(description).timeRequired(hours).date(date).build();
        if (LoginController.activeUser.goals.containsKey(date)) {
            LoginController.activeUser.goals.get(date).add(goal);
        } else {
            List<Goal> goals = new ArrayList<>();
            goals.add(goal);
            LoginController.activeUser.goals.put(date, goals);
        }
    }

    public interface View {
        void updateDate(LocalDate date);
        void setNameError(String error);
    }
}

