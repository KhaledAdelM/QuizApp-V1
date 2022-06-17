
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import static model.UsersModel.errmsgBox;
import model.*;
import static model.UsersModel.errmsgBox;
import static model.UsersModel.msgBox;
import static quizapp.QuizApp.oppForme;
import view.*;


public class UserController {

    private UserView userView;
    private UserModel userModel;
    UserController(UserView userView, UserModel userModel) {
        this.userView    =   userView;
        this.userModel   =   userModel;
        // Set Home Data
        setHomeData();
        // Home Button
       this.userView.homeButton (new homeButtonListenerButton());
        // Set Profile Data
        this.userView.profileButton(new ProfileListenerButton());
        // Send Message Button
        this.userView.sendMessageButton(new SendMessageListenerButton());
        // Set settings Data
        this.userView.settingsButton(new SettingsListenerButton());
        // updata Profile
        this.userView.updataProfileButton(new UpdataProfileListenerButton());
        // Set Quizzes
        this.userView.quizzesButton(new QuizzesListenerButton());
        // Start Quiz
        this.userView.startQuizButton(new StartQuizListenerButton());
        // logout
       this.userView.logout(new logoutListenerButton());
        
    }
    private void setHomeData(){
        userView.setFullNameUser(userModel.getFullName());
        userView.setNumOfQuizzes(userModel.countQuizzes()+"");
        userView.setNumOfTags(userModel.countTag()+"");
        userView.facebookIconMouseClicked(new UrlMouseListener(userModel.getUrlfacebook()));
        userView.youtubeIconMouseClicked(new UrlMouseListener(userModel.getUrlyoutube()));
        userView.githubIconMouseClicked(new UrlMouseListener(userModel.getUrlgithub()));
        userView.twitterIconMouseClicked(new UrlMouseListener(userModel.getUrltwitter()));
        userView.webSiteIconMouseClicked(new UrlMouseListener(userModel.getUrlwebSite()));
    }
    class homeButtonListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          setHomeData(); 
        }  
    }
    class UrlMouseListener implements MouseListener {
        private String url;
        UrlMouseListener(String url){
            this.url = url;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
            URI uri= new URI(url);
            java.awt.Desktop.getDesktop().browse(uri);
            }   
            catch (IOException   ex) {
               errmsgBox(ex.getMessage());
            }                
            catch (URISyntaxException ex) {
                errmsgBox(ex.getMessage());
            }
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
    class ProfileListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            userView.setProfileScore ( userModel.getScore()+"" );
            userView.setProfileFullName ( userModel.getFullName() );
            userView.setProfileUsername ( userModel.getUsername() );
            userView.setProfileEmail ( userModel.getEmail() );
            userView.setProfilePhone ( userModel.getPhone()+"" );
        }
    }
    class SendMessageListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username =   userView.getUsernameToSendMessage();
            String email    =   userView.getEmailToSendMessage();
            String phone   =    userView.getphoneToSendMessage();
            String textMessage  =   userView.getTextMessage();
            userModel.sendMessage(username, email, phone, textMessage);
        }
    }
    class SettingsListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            userView.setIDSettings (userModel.getId() +"");
            userView.setFullNameSettings (userModel.getFullName() );
            userView.setUsernameSettings (userModel.getUsername() );
            userView.setEmailSettings (userModel.getEmail() );
            userView.setPhoneSettings ( userModel.getPhone()+"");
        }
    }
    class UpdataProfileListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           try{
                String  fullName    =    userView.getFullNameSettings();
                String  username    =   userView.getUsernameSettings();
                String  email       =   userView.getEmailSettings();
                int  phone       =   Integer.parseInt(userView.getPhoneSettings());
                String  password    =   userView.getPasswordSettings();
                userModel.updateUser(fullName, username, email, password, phone);
            }catch (NumberFormatException ex){
                errmsgBox("Updated failed");
            }
        }
    }
    class StartQuizListenerButton implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) { 
            String sNameQuiz = (String) userView.getQuiz ();
            if(userModel.checkQuiz(sNameQuiz)){
                QuizView quizView = new QuizView();
                QuizModel quizModel = new QuizModel();
                quizModel.CreateQuiz(sNameQuiz);
                QuizControler quizController = new QuizControler(quizView , quizModel);
                oppForme (quizView,"QuizApp || "+sNameQuiz);
                quizView.setVisible(true);
                
            }else{
                msgBox("Choice Any Quizssas");
            }
        }
    }
    
    class logoutListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginView loginView = new LoginView();
            UsersModel loginModel = new UsersModel();
            LoginController login = new LoginController(loginView , loginModel);
            oppForme (loginView,"QuizApp || Login");   
            userView.setVisible(false);
        }

    }
    class QuizzesListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            List<String> quizzes = new ArrayList<String>();  
            List<String> tags = new ArrayList<String>();
            quizzes = userModel.getQuizzes();
            tags = userModel.getTags();
            String [] arrayQuizzes = new String [quizzes.size()];
            quizzes.toArray(arrayQuizzes);
            String [] arrayTags = new String [tags.size()];
            tags.toArray(arrayTags);
            userView.Load(arrayQuizzes,arrayTags);
        }

    }
    
}
