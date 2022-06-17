package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.*;
import static model.UsersModel.errmsgBox;
import static model.UsersModel.msgBox;
import static quizapp.QuizApp.oppForme;
import view.*;



public class SignUpController {
    private SignUpView signUpView;
    private UsersModel signUpModel;

    SignUpController(SignUpView signUpView, UsersModel signUpModel) {
        this.signUpModel =   signUpModel;
        this.signUpView  =   signUpView;
        // sign Up
        this.signUpView.signUpListener (new SignUpListenerButton());
        // Login
        this.signUpView.loginMouseMoved(new LoginMouseListener());

    }

    class SignUpListenerButton implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = signUpView.getFullName();
            String username = signUpView.getUsername();
            String password = signUpView.getPassword();
            String email = signUpView.getEmail();
            int phone = Integer.parseInt(signUpView.getPhone());
            boolean checkLogin = signUpModel.signUp(name, username, email, password, phone);
            System.out.println(checkLogin);
            if (checkLogin) {
                msgBox("SIGN UP SUCCESSFULLY");
                signUpView.setVisible(false);
                LoginView loginView = new LoginView();
                UsersModel loginModel = new UsersModel();
                LoginController login = new LoginController(loginView , loginModel);
                oppForme (loginView,"QuizApp || Login");
            } 
            else {
                errmsgBox("Invalid username or phone");
            }
        }
    }
    class LoginMouseListener implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {
            signUpView.setVisible(false);
            LoginView loginView = new LoginView();
            UsersModel loginModel = new UsersModel();
            LoginController login = new LoginController(loginView , loginModel);
            oppForme (loginView,"QuizApp || Login");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // Not supported yet.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // Not supported yet.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Not supported yet.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Not supported yet.
        }
        
    }
}
