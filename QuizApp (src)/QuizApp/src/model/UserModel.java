
package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class UserModel extends UsersModel  {
    
    public List<String> getQuizzes (){
        List<String> list = new ArrayList<String>();  
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Select Quiz Name & Tag ( in SQL Server ).
            String strSelect = "select * from Quiz ORDER BY tag ASC";
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while( resultSet.next() ){
                // Get data from Database.
                list.add((String) resultSet.getString("tag"));
                list.add((String) resultSet.getString("quizName"));
            }
            // close SQL Server.
            dbConnection.close();
            // Select successfully.
            return list;    
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        // Select failed.
        return list;
    }
    public boolean checkQuiz(String quizName){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Check Quiz  ( in SQL Server ).
            String strSelect = "SELECT  *"+
                    "FROM Quiz " +
                    "WHERE quizName = '" + quizName + "'";
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while( resultSet.next() ){
                // close SQL Server.
                dbConnection.close();
                // Found Quiz
                return true;
            }
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        //NOT FOUND
        return false;
    }
    public int searchQuiz (String nameQuiz){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Select id Quiz ( in SQL Server ).
            String strSelect = "select * from Quiz where quizName ='"+
                    nameQuiz +  "'";
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while( resultSet.next() ){
                // Get Quiz from Database.
                int idQuiz = (int) resultSet.getInt("Id");
                // close SQL Server.
                dbConnection.close();
                // Select successfully.
                return idQuiz;
            }
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        return 0;
    }
    
    public List<String> getTags (){
        List<String> list = new ArrayList<String>();  
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Select Tag Quiz ( in SQL Server ).
            String strSelect = "select * from Quiz ORDER BY tag ASC";
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while( resultSet.next() ){
                // Get data from Database.
                list.add((String) resultSet.getString("tag"));
            }
            // close SQL Server.
            dbConnection.close();
            // Select successfully.
            return list;
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        // Select failed.
        return list;
    }
    
    
    
    
    public void sendMessage (String fullName , String email , String strPhoneNumber , String textMessage){
        try{
            int intPhone    =    Integer.parseInt(strPhoneNumber);
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Updata UserModel ( in SQL Server ).
            String strUp = "INSERT INTO messages (fullName,email,phoneNumber,message) " +
                    "VALUES ('" + fullName + "','" +  email + "'," + intPhone + ",'"+ textMessage + "')";
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // Updated successfully.
            msgBox("Updated successfully.");
        }
        catch (SQLException | NumberFormatException ex){
            // Updated failed.
            errmsgBox(ex.getMessage());
        }
    }
    
    
}
