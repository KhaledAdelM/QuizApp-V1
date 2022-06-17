package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public  class QuizModel extends UsersModel{
    private int Id;
    private String name;
    private String tag;
    private String details;
    private List  idQuestion;
    private int numQuestion = 0;
    private int score = 0;
    
    public QuizModel(){
        
    }
    
    public void CreateQuiz(String quizName) {
        getQuiz(quizName);
    }
    
    public int getNumQuestion (){
        return numQuestion;
    }
    public String getQuizName(){
        return name;
    }
    @Override
    public int getScore() {
        return score;
    }
    
    public void setQuizScore( int score){
        this.score = this.score + score;
    }
    
    private void updateScore (int newScore) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Updata User ( in SQL Server ).
            String strUp = "UPDATE Users SET " +
                    " score = " + newScore + " + ( SELECT score from Users where Id ="+ getId() + ")"+
                    " WHERE Id = " + getId() ;
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // Updated successfully.
            //msgBox("Updated successfully.");
            // set New data in User Object.
            setScore(newScore);
            
        }
        catch (SQLException ex){
            // Updated failed.
            errmsgBox("Updated failed");
        }
       
    }


    
    
    private void getQuiz(String NameQuiz) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Select QuizModel ( in SQL Server ).
            String strSelect = "SELECT  [Id]"+
                    ",[quizName]"+
                    ",[tag]"+
                    ",[details] " + "FROM Quiz " +
                    "WHERE quizName = '" + NameQuiz + "'";
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while( resultSet.next() ){
                // Set data from Database.
                Id = (int) resultSet.getInt("Id");
                name = resultSet.getString("quizName");
                tag = resultSet.getString("tag");
                details = resultSet.getString("details");
                
            }
            // close SQL Server.
            dbConnection.close();
            getIdQuestion(Id);
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        
    }
    private void getIdQuestion (int id) {
        try{
            List<String> question = new ArrayList<String>();
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Select id Questions ( in SQL Server ).
            String strSelect = "SELECT Id "+
                     "FROM Question \n" +
                    " WHERE IdQuiz =" + id;
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while( resultSet.next() ){
                // set data from Database.
                question.add(resultSet.getString("Id"));
            }
            // close SQL Server.
            dbConnection.close();
            idQuestion = question ;
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        
    }
    
    public List <String> getQuestion (){
        List<String> question = new ArrayList<String>();
        int idOfquestion = Integer.parseInt((String) idQuestion.get(numQuestion));
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Select Question  ( in SQL Server ).
            String strSelect = "SELECT q.question , c.choice , c.answer \n"+
                    "From Question q\n"+
                    "JOIN\n"+
                    "Choices c\n"+
                    "on q.Id = c.IdQuestion\n"+
                    "where q.Id =" + idOfquestion;
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while( resultSet.next() ){
                // Get data from Database.
                question.add(resultSet.getString("question"));
                question.add(resultSet.getString("choice"));
                question.add(resultSet.getString("answer"));
            }
            // close SQL Server.
            dbConnection.close();
        }
        catch( SQLException ex){
          msgBox(ex.getMessage());
        }
        catch(IndexOutOfBoundsException ex){
          msgBox(ex.getMessage());
        }
        
       numQuestion++; 
       return  question;
    }
    
    public void CheckAnswer(int answer){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Select QuizModel ( in SQL Server ).
            String strSelect = "SELECT  [answer]"+
                    "FROM Choices " +
                    "WHERE IdQuestion = " + (Integer.parseInt((String)idQuestion.get((numQuestion-1)))) ;
            ResultSet resultSet = stmt.executeQuery(strSelect);
            int i=1;
            while( resultSet.next()){
                // get answer from Database.
                if (i == answer){
                int checkAnswer = (int) resultSet.getInt("answer");
                setQuizScore(checkAnswer);
                }
                i++;
            }
            // close SQL Server.
            dbConnection.close();
            
            
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        catch(IndexOutOfBoundsException ex){
             msgBox(ex.getMessage());
        }
        
        
    }

    public void finishQuiz() {
        updateScore(score);
        increaseCompletedQuiz();
    }

    private void increaseCompletedQuiz () {
        try{
            int IdUser    =    getId();
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Updata User ( in SQL Server ).
            String strIns = "INSERT INTO Completed (IdUser,IdQuiz) " +
                    "VALUES (" + IdUser + "," +  Id + ")";
            stmt.execute(strIns);
            // close SQL Server.
            dbConnection.close();
            // Updated successfully.
            // msgBox("Updated successfully.");
        }
        catch (SQLException ex){
            // Updated failed.
            errmsgBox(ex.getMessage());
        }
    }

    

    
    
}
