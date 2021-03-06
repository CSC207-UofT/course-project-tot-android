package com.example.course_project_tot.View;

import com.example.course_project_tot.Modele.Goal;
import com.example.course_project_tot.Modele.User;
import com.example.course_project_tot.Modele.UserList;

import java.time.LocalDate;
import java.util.List;

public class CalendarPresenter {
    private View view;

    public CalendarPresenter(View view){
        this.view = view;
    }

    public void updateGoalList(LocalDate date) {
        view.clearGoalList();
        User currentUser = UserList.getInstance().getCurrentUser();
        List <Goal> goals = currentUser.getGoalsByDate(date);
        if (goals != null) {
            for (Goal goal : goals) {
                view.addGoalToList(goal.getId(), goal.getName());
            }
        }
    }


    public interface View {
        void clearGoalList();
        void addGoalToList(String id, String name);
    }
}
