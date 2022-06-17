package model;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class UsersModel {
    
    // Variables to database
    
    private static String dbUrl = "jdbc:sqlserver://HP-PC:1433;databaseName=QuizApp ";
    private static  String dbUsername = "PC-HP";
    private static  String dbPassword = "123321";
    public static Connection dbConnection;
    
    // Variables to UsersModel
     private  static  int Id;
     private  static  int numOfModule;
     private  static  String fullName;
     private  static  String email;
     private  static  String username;
     private  static  String password;
     private  static  int phone;
     private  static  int score;
     
     
     public UsersModel(){
         
     }
    
     private void setUsersVariables(int id , int numOfModule , String fullName ,String username ,String email  ,String password ,int phone  , int score  ){
        Id = id;
        this.numOfModule = numOfModule;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.score = score;
         
     }
     
    //Connection to Database
    public static void setConnection(){                
        try {
            dbConnection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            //msgBox("Done");
        } 
        catch (SQLException ex) {
            errmsgBox("ErrorSQL - Connection to Database.");
        }
    }
    public void setScore (int newScore) {
        score += newScore;
    }
    
    // Get Data User
    public int getId (){
        return Id;
    }
    public int getnumOfModule (){
        return numOfModule;
    }
    public String getFullName(){
        return fullName;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public int getPhone(){
        return phone;
    }
    public int getScore () {
        return score;
    }
    
    
    
    

    
    
    // check username and password
    public boolean login(String username , String password){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Check User Validity form this Username & Password ( in SQL Server ).
            String strCheck = "select * from Users where "
                    + "username ='" + username + "' and "
                    + "Password ='" + password + "'";
            ResultSet resultSet = stmt.executeQuery(strCheck);
            while( resultSet.next() ){
                // Get data from Database.
                int dbId = (int) resultSet.getInt("Id");    
                int dbnumOfModule = (int) resultSet.getInt("numOfModule");
                String dbFullName = (String) resultSet.getString("fullName");
                int dbScore = (int) resultSet.getInt("score");
                String dbEmail = (String) resultSet.getString("email");
                int dbPhone = (int) resultSet.getInt("phone");
                // set data in User Object.
                setUsersVariables(dbId ,dbnumOfModule, dbFullName , username ,dbEmail,password ,dbPhone  ,dbScore );
                // close SQL Server.
                dbConnection.close();
                // check successfully.
                return true;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
             msgBox(ex.getMessage());
        }
        // check failed.
        return false;
    }
    
    // add New User
    public boolean signUp (String fullName ,String username ,String email  ,String password ,int phone ){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add User ( in SQL Server ).
            String strAdd = "INSERT INTO Users (fullName,username,email,Password,phone,numOfModule) OUTPUT Inserted.Id "
                    + "VALUES ('"+ fullName + "','" + username + "','" + email + "','" + password + "'," + phone + "," + 1 + ")";
            // Return ID from this user
            ResultSet resultSetID = stmt.executeQuery(strAdd);
            while( resultSetID.next() ){
                // Get Id from Database.
                int dbId = (int) resultSetID.getInt("Id");
                // set data in User Object.
                setUsersVariables(dbId , 1 ,fullName , username ,email,password ,phone  , 0 );
                // close SQL Server.
                dbConnection.close();
                // Add successfully.
                return true;
            }
            dbConnection.close();
        }
        catch(SQLException ex ){
          msgBox("Wrong Username");
        }
        // check failed.
        return false;        
    }
    
    // Updat User
    public void updateUser (String fullName ,String username ,String email  ,String password ,int phone ){
        try{
            if (password.isEmpty()){
                password = this.password;
            }
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Updata User ( in SQL Server ).
            String strUp = "UPDATE Users SET " +
                    "fullName ='" + fullName+ "'," +
                    "username ='" +username+ "'," +
                    "email ='" + email+ "'," +
                    "Password ='" + password+ "'," +
                    "phone = " + phone +
                    "WHERE Id= " + Id ;
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // Updated successfully.
            
            msgBox("Updated successfully.");
            // set New data in User Object.
            setUsersVariables( Id , numOfModule , fullName , username ,email,password , phone  , score );
        }
        catch (SQLException ex){
            // Updated failed.
            errmsgBox("Updated failed");
        }
    }
    
    // Set Any Table 
    public void fillToJTable(String tableNameOrSelectStatement, JTable table){
        try{
            // con.close();
            setConnection();
            Statement stmt = dbConnection.createStatement();
            ResultSet records;
            String SPart = tableNameOrSelectStatement.substring(0, 7).toLowerCase();
            String strSelect;
            if( "select ".equals( SPart ) ){
                strSelect = tableNameOrSelectStatement;
            }
            else{
                strSelect = "select * from " + tableNameOrSelectStatement;
            }
            records = stmt.executeQuery(strSelect);
            
            int c = records.getMetaData().getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Vector row = new Vector();
            model.setRowCount(0);
           
            while(records.next()){
                row = new Vector(c);
                for(int i = 1 ; i <= c ; i++){
                    row.add(records.getString(i));
                }
                model.addRow(row);
            }
            if(table.getColumnCount() != c){
                msgBox("JTable Columns Count Not Equal To Query Columns Count \n JTable Columns Count Is: " 
                        + table.getColumnCount() 
                        + "\n Query Columns Count Is: " + c);
            }
        }
        catch(SQLException ex){
            msgBox(ex.getMessage());
        }
      }
 
    public int countQuizzes (){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // count Quizzes ( in SQL Server ).
            String strAdd = "SELECT COUNT(Id) AS NumberOfProducts  FROM Quiz";
            // Return Number of Quizzes
            ResultSet resultSetNumQuizzes = stmt.executeQuery(strAdd);
            while( resultSetNumQuizzes.next() ){
                // Get number from Database.
                int numQuizzes = (int) resultSetNumQuizzes.getInt("NumberOfProducts");
                // close SQL Server.
                dbConnection.close();
                // Count Quizzes successfully.
                return numQuizzes;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        
        return 0;
    }
    
    public int countTag (){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // count Tags ( in SQL Server ).
            String strAdd = "SELECT COUNT(distinct tag) AS NumberOfTags  FROM Quiz";
            // Return Number of Quizzes
            ResultSet resultSetNumTags = stmt.executeQuery(strAdd);
            while( resultSetNumTags.next() ){
                // Get number from Database.
                int numTags = (int) resultSetNumTags.getInt("NumberOfTags");
                // close SQL Server.
                dbConnection.close();
                // Count Quizzes successfully.
                return numTags;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        
        return 0;
    }
    
// --- Get Url ( facebook , twitter , github , youtube , webSite ) ---
     public String getUrlfacebook(){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Get Url facebook ( in SQL Server ).
            String getUrl = "  select facebook from socialMedia";
            ResultSet resultSeturl = stmt.executeQuery(getUrl);
            while( resultSeturl.next() ){
                // Get Url from Database.
                String dbUrlfacebook = resultSeturl.getString("facebook");
                // close SQL Server.
                dbConnection.close();
                // Get successfully.
                return dbUrlfacebook;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        // get Url facebook failed.
        return "";
    }
     
     public String getUrltwitter(){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Get Url twitter ( in SQL Server ).
            String getUrl = "  select twitter  from socialMedia";
            ResultSet resultSeturl = stmt.executeQuery(getUrl);
            while( resultSeturl.next() ){
                // Get Url from Database.
                String dbUrltwitter  = resultSeturl.getString("twitter");
                // close SQL Server.
                dbConnection.close();
                // Get successfully.
                return dbUrltwitter;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        // get Url twitter failed.
        return "";
    }
     
     public String getUrlgithub (){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Get Url github ( in SQL Server ).
            String getUrl = "  select github from socialMedia";
            ResultSet resultSeturl = stmt.executeQuery(getUrl);
            while( resultSeturl.next() ){
                // Get Url from Database.
                String dbUrlgithub  = resultSeturl.getString("github");
                // close SQL Server.
                dbConnection.close();
                // Get successfully.
                return dbUrlgithub ;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        // get Url github  failed.
        return "";
    }
     
     public String getUrlyoutube (){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Get Url youtube  ( in SQL Server ).
            String getUrl = "  select youtube from socialMedia";
            ResultSet resultSeturl = stmt.executeQuery(getUrl);
            while( resultSeturl.next() ){
                // Get Url from Database.
                String dbUrlyoutube = resultSeturl.getString("youtube");
                // close SQL Server.
                dbConnection.close();
                // Get successfully.
                return dbUrlyoutube;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        // get Url youtube  failed.
        return "";
    }
     
     public String getUrlwebSite (){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Get Url webSite  ( in SQL Server ).
            String getUrl = "  select webSite from socialMedia";
            ResultSet resultSeturl = stmt.executeQuery(getUrl);
            while( resultSeturl.next() ){
                // Get Url from Database.
                String dbUrlwebSite  = resultSeturl.getString("webSite");
                // close SQL Server.
                dbConnection.close();
                // Get successfully.
                return dbUrlwebSite;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          msgBox(ex.getMessage());
        }
        // get Url webSite  failed.
        return "";
    }
    //------------------------------------------------------------------------
    // Message Box.
    public static void msgBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    // Error Message Box
    public static void errmsgBox(String message) {
        JOptionPane.showMessageDialog(null, message,"Error",JOptionPane.ERROR_MESSAGE);
    }
    //-----------------------------------------------------
}
