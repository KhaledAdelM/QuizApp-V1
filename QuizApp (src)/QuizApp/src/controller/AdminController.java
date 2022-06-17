package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static model.UsersModel.errmsgBox;
import static model.UsersModel.msgBox;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.*;
import static quizapp.QuizApp.oppForme;
import view.*;


public class AdminController {
    private AdminModel adminModel;
    private AdminView adminView;
    
    
    AdminController(AdminView adminView, AdminModel adminModel) {
       this.adminView   =   adminView;
       this.adminModel  =   adminModel;
       //Set Home JPanel Data
       setHomeData();
       //Set Box Messages
       loadingBoxMessages();
       // Home Button
       this.adminView.homeButton (new homeButtonListenerButton());
       //Set Table Users
       this.adminView.jButtonUsers (new usersListenerButton());
       //Set Table Quizzes
       this.adminView.jButtonQuizzes (new quizzesListenerButton());
       //Set Table Messages
       this.adminView.jButtonMessages (new messagesListenerButton());
       // search User --> USERNAME
       this.adminView.searchUser (new SearchUserKeyReleased());
        // search Quiz --> TAG
       this.adminView.searchQuiz (new SearchQuizKeyReleased());
        // search Message --> ID
       this.adminView.searchMessage (new SearchMessageKeyReleased());
       // Delete Quiz
       this.adminView.deleteQuiz (new deleteQuizListenerButton());
       // Delete Message
       this.adminView.deleteMessage (new deleteMessagesListenerButton());
       // set Data Admin Profile
       this.adminView.settingsProfile (new settingsProfileListenerButton());
       // update Profile
       this.adminView.updataProfile (new updataProfileListenerButton());
       // Add Quizzes
        this.adminView.addQuiz (new addQuizListenerButton());
       // logout
       this.adminView.logout(new logoutListenerButton());
    }
    
    private void setHomeData (){
       adminView.setTotalUsers(adminModel.countUsers());
       adminView.setTotalQuizzes(adminModel.countQuizzes());
       adminView.setTotalQuizzesCompleted(adminModel.countQuizzesCompleted());
       adminView.setFullNameAdmin(adminModel.getFullName());
       adminModel.viewUser(adminView.setjTableNewUsers());
    }
    
    private void loadingBoxMessages (){
        List<String> boxNewMessages =  adminModel.viewBoxMessages();
        JPanel [] jPanel = adminView.getJPanelBoxMessages ();
        JLabel [] BoxName = adminView.getJLabelNameBoxMessages ();
        JLabel [] BoxTextMessages = adminView.getJLabelTexBoxMessages();
        for(int i = 0 ,x=0 ; i < boxNewMessages.size() ; i = i +2 , x++){
            jPanel[x].setVisible(true);
            BoxName[x].setText(boxNewMessages.get(i));
            BoxTextMessages[x].setText(
                    (boxNewMessages.get(i+1).length() > 40) ? 
                            boxNewMessages.get(i+1).substring(0, 40) :  
                            boxNewMessages.get(i+1));     
        }
     }
    class homeButtonListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          setHomeData(); 
        }  
    }
    
    class usersListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           adminModel.viewUser(adminView.setjTableUsers()); 
        }  
    }
    class quizzesListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           adminModel.viewQuizzes(adminView.setjTableQuizzes()); 
        }  
    }
    class messagesListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           adminModel.viewMessages(adminView.setjTableMessages()); 
        }  
    }
    
    class SearchUserKeyReleased implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            try{
                String  strUsernameTosearchUser       =   adminView.getTextSearchUser();
                if(!strUsernameTosearchUser.isEmpty()){
                adminModel.searchUser(strUsernameTosearchUser, adminView.setjTableUsers());
                }else{
                    adminModel.viewUser(adminView.setjTableUsers());
                }
            }catch (NumberFormatException ex){
                errmsgBox("Search by USERNAME");
            }
        }
    }
    class SearchQuizKeyReleased implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            try{
                String  strTagTosearchQuizzes       =   adminView.getTextSearchQuiz();
                if(!strTagTosearchQuizzes.isEmpty()){
                    adminModel.searchQuizzes(strTagTosearchQuizzes, adminView.setjTableQuizzes());
                }else{
                    adminModel.viewQuizzes(adminView.setjTableQuizzes());
                }
            }catch (NumberFormatException ex){
                errmsgBox("Search by TAG");
            }
        }
    }
    
    class SearchMessageKeyReleased implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            try{
                String  strIdTosearchMessages       =   adminView.getTextSearchMessage();
                if(!strIdTosearchMessages.isEmpty()){
                    int  idTosearchMessages       =   Integer.parseInt(strIdTosearchMessages);
                    adminModel.searchMessages(idTosearchMessages, adminView.setjTableMessages());
                }else{
                    adminModel.viewMessages(adminView.setjTableMessages());
                }
            }catch (NumberFormatException ex){
            errmsgBox("Search by ID");
            }
        }
    }
    class deleteQuizListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int idOfQuiz = adminView.idQuizToDelete ();
            if (idOfQuiz != 0) {  
                adminModel.deleteQuiz(idOfQuiz);
            }
        }  
    }
    class deleteMessagesListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int idOfMessage = adminView.idMessageToDelete ();
           if (idOfMessage != 0) {  
                adminModel.deleteMessage(idOfMessage);
            }
        }  
    }

    class settingsProfileListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.setTestFullNameProfile(adminModel.getFullName());
            adminView.setTestUsernameProfile(adminModel.getUsername());
            adminView.setTestPhoneProfile(adminModel.getPhone()+"");
            adminView.setTestEmailProfile(adminModel.getEmail());
            adminView. setTestFacebookProfile(adminModel.getUrlfacebook()); 
            adminView.setTestTwitterProfile(adminModel.getUrltwitter());
            adminView.setTestGithubProfile(adminModel.getUrlgithub()); 
            adminView.setTestYoutubeProfile(adminModel.getUrlyoutube()); 
            adminView.setTestWebSiteProfile(adminModel.getUrlwebSite()); 
        }  
    }
    
    class updataProfileListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String  fullName    =    adminView.getTestFullNameProfile();
                String  username    =   adminView.getTestUsernameProfile();
                String  email       =   adminView.getTestEmailProfile();
                int  phone       =   Integer.parseInt(adminView.getTestPhoneProfile());
                String  password    =   adminView.getTestPasswordProfile();
                String  urlFacebook =   adminView.getTestFacebookProfile();
                String  urlTwitter  =   adminView.getTestTwitterProfile();
                String  urlGithub   =   adminView.getTestGithubProfile();
                String  urlYoutube  =   adminView.getTestYoutubeProfile();
                String  urlWebSite  =   adminView.getTestWebSiteProfile();
                adminModel.updateUser(fullName, username, email, password, phone);
                adminModel.updatesocialMedia(urlFacebook, urlTwitter, urlGithub, urlYoutube, urlWebSite);
                //msgBox("Updated successfully");
            }catch (NumberFormatException ex){
                errmsgBox("Updated failed");
            }
        }  
    }
    
    class addQuizListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String nameOfQuiz    =   adminView.getNameOfQuiz ();
            String tagOfQuiz    =   adminView.getTagOfQuiz ();
            String detailsOfQuiz    =   adminView.getDetailsOfQuiz ();
            String [][] questionsOfQuiz    =   adminView.getQuestionsOfQuiz ();
            adminModel.addQuiz(nameOfQuiz, tagOfQuiz, detailsOfQuiz, questionsOfQuiz);            
        }

    }
    class logoutListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginView loginView = new LoginView();
            UsersModel loginModel = new UsersModel();
            LoginController login = new LoginController(loginView , loginModel);
            oppForme (loginView,"QuizApp || Login");   
            adminView.setVisible(false);
        }

    }
    
}
