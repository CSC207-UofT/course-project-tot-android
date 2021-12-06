package com.example.course_project_tot.Controller;

import com.example.course_project_tot.Modele.User;
import com.example.course_project_tot.Modele.UserList;
import com.example.course_project_tot.View.ILoginView;

public class LoginController implements ILoginController {
    ILoginView loginView;
    public static User activeUser;

    public LoginController(ILoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public void OnLogin(String email, String password) {
        if (UserList.getInstance().contains(email)) {
            User user = UserList.getInstance().getUser(email);
            if (user.getPassword().equals(password)) {
                loginView.OnLoginSuccess("Successfully logged in.");
                activeUser = user;
            } else {
                loginView.OnLoginError("Incorrect password.");
            }
        } else {
            User user = new User(email, password);
            int loginCode = user.isValid();
            if (loginCode == 0) {
                loginView.OnLoginError("Please enter Email");
            } else if (loginCode == 1) {
                loginView.OnLoginError("Please enter A valid Email");
            } else if (loginCode == 2) {
                loginView.OnLoginError("Please enter Password");
            } else if (loginCode == 3) {
                loginView.OnLoginError("Please enter Password greater the 12 char");
            } else {
                activeUser = user;
                UserList.getInstance().add(user);
                UserList.getInstance().writeToFile();
                loginView.OnLoginSuccess("Registration Successful");
            }
        }
    }
}
