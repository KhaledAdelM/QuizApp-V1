package quizapp;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import javax.swing.JFrame;
import view.*;
import model.*;
import controller.*;



public class QuizApp {

    
    public static void main(String[] args) {
        createTheme ();
        LoginView loginView = new LoginView();
        UsersModel loginModel = new UsersModel();
        LoginController login = new LoginController(loginView , loginModel);
        oppForme (loginView,"QuizApp || Login");
        
        
    }
    // open Frame
      public static void oppForme (JFrame jFrame , String title){
          try{
            jFrame.setLocationRelativeTo(null);
            //ImageIcon imgicon = new ImageIcon("D:'\'FCAIHU'\'2021-2022'\'Software Engineering -2'\'Project'\'java MVC'\'QuizApp'\'src'\'quizapp'\'Logo.png");
            //jFrame.setIconImage(imgicon.getImage());
            jFrame.setTitle(title);
            //JFrame.setDefaultLookAndFeelDecorated(true);
            jFrame.setVisible(true);}
            catch (IllegalArgumentException ex){
                // set Message.
            }
      }
    //Create new theme
    private static void createTheme (){
        try {
            //FlatCobalt2IJTheme.setup();
            //FlatGitHubDarkIJTheme.setup();
            FlatOneDarkIJTheme.setup();
        }catch(Exception e){
            //msgBox(e.getMessage());
        }
    }
}
