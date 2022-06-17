package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

                                      



public class AdminModel extends UsersModel {
    
    
    
    public int countUsers (){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // count UsersModel  ( in SQL Server ).
            String strAdd = "SELECT COUNT(Id) AS NumberOfUsers  FROM Users";
            // Return Number of UsersModel 
            ResultSet resultSetNumUsers = stmt.executeQuery(strAdd);
            while( resultSetNumUsers.next() ){
                // Get number from Database.
                int numUsers = (int) resultSetNumUsers.getInt("NumberOfUsers");
                // close SQL Server.
                dbConnection.close();
                // Count UsersModel successfully.
                return numUsers;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        
        return 0;
    }
    
    public int countQuizzesCompleted (){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // count Completed  ( in SQL Server ).
            String strAdd = "SELECT COUNT(IdUser) AS NumberOfCompleted  FROM Completed";
            // Return Number of Completed 
            ResultSet resultSetNumCompleted = stmt.executeQuery(strAdd);
            while( resultSetNumCompleted.next() ){
                // Get number of Completed from Database.
                int numCompleted = (int) resultSetNumCompleted.getInt("NumberOfCompleted");
                // close SQL Server.
                dbConnection.close();
                // Count UsersModel successfully.
                return numCompleted;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        
        return 0;
    }
    
    // Updata social media
    public void updatesocialMedia (String facebook  ,String twitter  ,String github   ,String youtube  ,String webSite  ){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Updata social media  ( in SQL Server ).
            String strUp = "UPDATE TOP (1) socialMedia SET " +
                    "facebook   ='" + facebook  + "'," +
                    "twitter    ='" + twitter   + "'," +
                    "github     ='" + github    + "'," +
                    "youtube    ='" + youtube   + "'," +
                    "webSite    ='" + webSite   + "'";
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // Updated successfully.
            //msgBox("Updated successfully.");
        }
        catch (SQLException ex){
            // Updated failed.
            errmsgBox("Updated failed");
        }
    }
    
    public void viewUser (JTable tableUser){
        String strSelect = "SELECT TOP (1000) [Id] " +
        ",[fullName]\n" +
        ",[username]\n" +
        ",[email]\n" +
        ",[phone]\n" +
        ",[score]\n" +
        "FROM [QuizApp].[dbo].[Users]";
        
        fillToJTable (strSelect , tableUser);
    }
    
    public void viewMessages (JTable tableMessages){
        String strSelect = "SELECT TOP (1000)  [Id] " +
        ",[fullName]\n" +       
        ",[email]\n" +
        ",[phoneNumber]\n" +
        ",[message]\n" +
        "FROM [QuizApp].[dbo].[messages]";
        
        fillToJTable (strSelect , tableMessages);     
    }
    
    
     public List <String> viewBoxMessages ( ){
         List<String> boxNewMessages = new ArrayList<String>();
         try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add User ( in SQL Server ).
            String strSelect = "SELECT TOP (8)  " +
                        "[fullName]\n" +       
                        ",[message]\n" +
                        "FROM [QuizApp].[dbo].[messages]";
            // SELECT  max 8 messages 
            ResultSet resultSetBoxMessages = stmt.executeQuery(strSelect);
            while( resultSetBoxMessages.next() ){
                // Get ( 8 ) --> Messages from Database.
                String dbName = resultSetBoxMessages.getString("fullName");
                String dbTextMessage = resultSetBoxMessages.getString("message");
                
                // Add [Names] & [Messages]
                boxNewMessages.add(dbName);
                boxNewMessages.add(dbTextMessage) ;
            }
            // close SQL Server.
            dbConnection.close();
            return boxNewMessages;
        }
        catch(SQLException ex){
         // check failed.
          msgBox(ex.getMessage());
        }
      return null;      
    }
    
    
    public void viewQuizzes (JTable tableQuizzes){
        String strSelect = "SELECT TOP (1000) [Id]\n" +
            ",[quizName]\n" +
            ",[tag]\n" +
            ",[details]\n" +
            "FROM [QuizApp].[dbo].[Quiz]";
        
        fillToJTable (strSelect , tableQuizzes);     
    }
    
        public void searchUser (String username , JTable tableUser){
        String strSelect = "SELECT [Id] " +
        ",[fullName]\n" +
        ",[username]\n" +
        ",[email]\n" +
        ",[phone]\n" +
        ",[score]\n" +
        "FROM [QuizApp].[dbo].[Users]\n" +
        "WHERE username LIKE '" + username + "%'";
        
        fillToJTable (strSelect , tableUser);
    }
    
    public void searchMessages (int Id , JTable tableMessages){
        String strSelect = "SELECT [Id] " +
        ",[fullName]\n" +       
        ",[email]\n" +
        ",[phoneNumber]\n" +
        ",[message]\n" +
        "FROM [QuizApp].[dbo].[messages]\n" +
        "WHERE Id = " + Id + "";
        
        fillToJTable (strSelect , tableMessages);     
    }
    
    public void searchQuizzes (String tag ,JTable tableQuizzes){
        String strSelect = "SELECT  [Id]" +
        ",[quizName]\n" +
        ",[tag]\n" +
        ",[details]\n" +
        "FROM [QuizApp].[dbo].[Quiz]\n" +
        "WHERE tag LIKE '" + tag + "%'";
        
        fillToJTable (strSelect , tableQuizzes);     
    }
    
    public void deleteMessage (int idMessage){
        try{
            setConnection();
            Statement stmt = dbConnection.createStatement();
            String strDel = "DELETE FROM messages WHERE Id = " + idMessage ;
            stmt.execute(strDel);
            dbConnection.close();
            msgBox("Deleted successfully.");
        }
        catch (SQLException ex){
            errmsgBox("Error in delete.");
        }
        
    }
    public void deleteQuiz(int idOfQuiz) {
        try{
            setConnection();
            Statement stmt = dbConnection.createStatement();
            String strDel = "DELETE FROM Quiz WHERE Id = " + idOfQuiz ;
            stmt.execute(strDel);
            dbConnection.close();
            msgBox("Deleted successfully.");
        }
        catch (SQLException ex){
            errmsgBox("Error in delete.");
        }
    }
    
    public void addQuiz (String name , String tag , String details , String [][] questions  ) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add User ( in SQL Server ).
            String strAdd = "INSERT INTO Quiz  (quizName ,tag ,details ) OUTPUT Inserted.Id "
                    + "VALUES ('"+ name + "','" + tag + "','" + details + "')" ;
            // Return ID from this Quiz
            ResultSet resultSetID = stmt.executeQuery(strAdd);
            while( resultSetID.next() ){
                // Get Id from Database.
                int dbId = (int) resultSetID.getInt("Id");
                // Array [question][Choices]
                for( String [] question : questions ) {
                    addQuestions (dbId , question);
                }
                // Add successfully.
                msgBox("Add Quiz successfully.");
            }
            // close SQL Server.
            dbConnection.close();
        }
        catch(SQLException ex){
         // check failed.
          msgBox("Wrong Add");
        }
    }

    private void addQuestions (int quizId, String [] question) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add question ( in SQL Server ).
            String strAdd = "INSERT INTO Question  (IdQuiz,question) OUTPUT Inserted.Id "
                    + "VALUES ('"+ quizId + "','" + question[0] + "')";
            // Return ID from this question
            ResultSet resultSetID = stmt.executeQuery(strAdd);
            while( resultSetID.next() ){
                // Get Id from Database.
                int dbId = (int) resultSetID.getInt("Id");
                //Add Choices
                addChoices (dbId , question);
                // close SQL Server.
                dbConnection.close();
                // Add successfully.
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          msgBox("Wrong question");
        }
        // check failed.
    }

    private void addChoices(int questionId, String[] choices) {
        int numAnswer = Integer.parseInt(choices[5]);
        // Add Answer
        switch (numAnswer){
            case 1 :
                addChoice(questionId,choices[1] , 1);
                addChoice(questionId,choices[2] , 0);
                addChoice(questionId,choices[3] , 0);
                addChoice(questionId,choices[4] , 0);
            break;
            case 2 :
                addChoice(questionId,choices[1] , 0);
                addChoice(questionId,choices[2] , 1);
                addChoice(questionId,choices[3] , 0);
                addChoice(questionId,choices[4] , 0);
            break;
            case 3 :
                addChoice(questionId,choices[1] , 0);
                addChoice(questionId,choices[2] , 0);
                addChoice(questionId,choices[3] , 1);
                addChoice(questionId,choices[4] , 0);
            break;
            case 4 :
                addChoice(questionId,choices[1] , 0);
                addChoice(questionId,choices[2] , 0);
                addChoice(questionId,choices[3] , 0);
                addChoice(questionId,choices[4] , 1);
            break;
        }
                 
    }

    private void addChoice(int questionId, String choice, int answer) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add Choices ( in SQL Server ).
            String strAdd = "INSERT INTO Choices  (IdQuestion  ,choice  ,answer ) "
                    + "VALUES ("+ questionId + ",'" + choice + "'," + answer + ")" ;
            // Return ID from this Quiz
            stmt.execute(strAdd);
            //Add Choices
            //msgBox("Add Choices successfully.");
            // close SQL Server.
            dbConnection.close();
        }
        catch(SQLException ex){
         // check failed.
          msgBox("Wrong Add");
        }        
    }

    
}