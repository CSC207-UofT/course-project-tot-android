package com.example.course_project_tot.Ucontroller;

import com.example.course_project_tot.UModel.User;
import com.example.course_project_tot.UModel.UserList;
import com.example.course_project_tot.UView.ILoginView;

public class LoginController implements ILoginController {
    ILoginView loginView;
    UserList userList;
    public static User activeUser;

    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
        userList = new UserList(); // TODO: This should be read from a file
    }

    @Override
    public void OnLogin(String email, String password) {
        User user = new User(email, password); // TODO: This should be retrieved from the userList
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
            loginView.OnLoginSuccess("login Successful");
            activeUser = user;
        }
        userList.add(user); // TODO: Make a separate registration method
    }
}
