package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.*;
import static model.UsersModel.errmsgBox;
import static quizapp.QuizApp.oppForme;
import view.*;

public class LoginController {
    
    private UsersModel loginModel;
    private LoginView loginView;

    public LoginController(LoginView loginView, UsersModel loginModel) {
        this.loginModel  =   loginModel;
        this.loginView   =   loginView;
        // Login
        this.loginView.loginListener (new LoginListener());
        // sign Up
        this.loginView.signUpMouseMoved(new SignUpMouseListener());
    }
    class LoginListener implements ActionListener{
            String username;
            String password ;
        @Override
        public void actionPerformed(ActionEvent e) {
            username = loginView.getUsername();
            password = loginView.getPassword();
            boolean checkLogin = loginModel.login(username, password);
            System.out.println(checkLogin);
            if (checkLogin) openModule();
            else {
                errmsgBox("Invalid username or password");
            }
        }
        private void openModule() {
            if (loginModel.getnumOfModule() == 1){
                UserView userView = new UserView();
                UserModel userModel =  new UserModel();
                userModel.login(username, password);
                UserController userController = new UserController(userView , userModel);
                oppForme (userView,"QuizApp || " + userModel.getFullName());
                //System.out.println("User");
            }else if (loginModel.getnumOfModule() == 2){
                AdminView adminView = new AdminView();
                AdminModel adminModel = new AdminModel() ;
                adminModel.login(username, password);
                AdminController adminController = new AdminController(adminView , adminModel);
                oppForme (adminView,"QuizApp || " + adminModel.getFullName());
                //System.out.println("Admin");
            }
            loginView.setVisible(false);
        }
    }
    
    class SignUpMouseListener implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {
            loginView.setVisible(false);
            SignUpView signUpView = new SignUpView();
            UsersModel signUpModel = new UsersModel();
            SignUpController SignUp = new SignUpController(signUpView , signUpModel);
            oppForme (signUpView,"QuizApp || Sign Up");
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
