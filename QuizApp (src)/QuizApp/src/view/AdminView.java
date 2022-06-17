package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import static model.UsersModel.errmsgBox;
import static model.UsersModel.msgBox;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class AdminView extends javax.swing.JFrame {
 
    CardLayout cardLayoutPage ;
    CardLayout cardLayoutPageAddQuizzes;
    // Table Model
    DefaultTableModel dtmMessages = new DefaultTableModel();
    DefaultTableModel dtmQuizzes = new DefaultTableModel();
    DefaultTableModel dtmUsers = new DefaultTableModel();
    DefaultTableModel dtmNewUsers = new DefaultTableModel();
    // TO add Quizzes
    String  nameQuiz;
    String  tagQuiz;
    String  detailsQuiz;
    String [][] questionsQuiz = new String[6][6];
    int numOfQuestion = 0 ;

    public AdminView() {
        initComponents();
        cardLayoutPage = (CardLayout) (jPanelRight.getLayout());
        cardLayoutPageAddQuizzes = (CardLayout) (AddQuiz.getLayout());
        // Box Messages is Empty
        Massagebox1.setVisible(false);
        Massagebox2.setVisible(false);
        Massagebox3.setVisible(false);
        Massagebox4.setVisible(false);
        Massagebox5.setVisible(false);
        Massagebox6.setVisible(false);
        Massagebox7.setVisible(false);
        Massagebox8.setVisible(false);
        //Create Quizzes Table
        String [] quizzesColumns = {"ID","Quiz Name","Tag","Details"};
        setColumn(dtmQuizzes, jTQuizzes ,quizzesColumns);
        //Create Messages Table
        String [] messagesColumns = {"ID","Name","Email","Phone","Text Message"};
        setColumn(dtmMessages, jTMessages ,messagesColumns);
        //Create Users Table
        String [] userColumns = {"ID","Name","Username","Email","Phone","Score"};
        setColumn(dtmUsers, jTUsers ,userColumns);
        setColumn(dtmNewUsers, jTNewUser ,userColumns);
    }

    


    
    private void setColumn(DefaultTableModel tableModel, JTable jTable,String [] columns){
        jTable.setModel(tableModel);
        jTable.getTableHeader().setReorderingAllowed(false); // not allow re-ordering of columns
        for (String column :columns){
            tableModel.addColumn(column);
        }
    }
    //---------------------------------------------
    public void setTotalUsers (int totalUsers){
        jLabelTotalUsers.setText(""+totalUsers);
    }
    public void setTotalQuizzes (int totalQuizzes){
        jLabelTQuizzes.setText(""+totalQuizzes);
    }
    public void setTotalQuizzesCompleted (int totalQuizzesCompleted){
        jLabelTotalQuizzesCompleted.setText(""+totalQuizzesCompleted);
    }
    public void setFullNameAdmin (String fullName){
        fullNameAdmin.setText(fullName);
    }
    public JPanel [] getJPanelBoxMessages (){
        JPanel [] jPanel = {Massagebox1 ,Massagebox2 ,Massagebox3,Massagebox4,Massagebox5,Massagebox6,Massagebox7,Massagebox8};
        return jPanel;
    }
    public JLabel []  getJLabelTexBoxMessages(){
        JLabel [] BoxTextMessages = {Title1 ,Title2,Title3,Title4,Title5,Title6,Title7,Title8};
        return BoxTextMessages;
    }
    public JLabel [] getJLabelNameBoxMessages (){
        JLabel [] BoxName = {Username1 ,Username2 ,Username3,Username4,Username5,Username6,Username7,Username8};
        return BoxName;
    }
    public JTable setjTableNewUsers(){
        return jTNewUser;
    }
    public JTable setjTableUsers(){
        return jTUsers;
    }
    public JTable setjTableQuizzes(){
        return jTQuizzes;
    }
    public JTable setjTableMessages(){
        return jTMessages;
    }
    public void homeButton (ActionListener homeButtonListenerButton) {                                       
        jButtonSettings.addActionListener(homeButtonListenerButton);
    }
    public void jButtonUsers (ActionListener usersListenerButton){
        jButtonUsers.addActionListener(usersListenerButton);
    }
    public void jButtonQuizzes (ActionListener quizzesListenerButton){
        jButtonQuizzes.addActionListener(quizzesListenerButton);
    }
    public void jButtonMessages (ActionListener messagesListenerButton){
        jButtonMessages.addActionListener(messagesListenerButton);
        jButtonMore.addActionListener(messagesListenerButton);
    }
    public String getTextSearchUser(){
        return SearchUser.getText();
    }
    public String getTextSearchQuiz(){
        return SearchQuiz.getText();
    }
    public String getTextSearchMessage(){
        return SearchMessage.getText();
    }
    public void searchUser (KeyListener SearchUserKeyReleased) {                                       
        SearchUser.addKeyListener(SearchUserKeyReleased);
    }
    public void searchQuiz (KeyListener SearchQuizKeyReleased) {                                       
        SearchQuiz.addKeyListener(SearchQuizKeyReleased);
    }
    public void searchMessage (KeyListener SearchMessageKeyReleased) {                                       
        SearchMessage.addKeyListener(SearchMessageKeyReleased);
    }
    public int idMessageToDelete (){
        try{
        int numOfRow = jTMessages.getSelectedRow();
        int idOfMessage = Integer.parseInt((String) jTMessages.getModel().getValueAt(numOfRow, 0));
        return idOfMessage;
        }catch(ArrayIndexOutOfBoundsException ex){
            msgBox("Select Message To Delete");
        }
        return 0;
    }
    public int idQuizToDelete (){
        try{
        int numOfRow = jTQuizzes.getSelectedRow();
        int idOfQuiz = Integer.parseInt((String) jTQuizzes.getModel().getValueAt(numOfRow, 0));
        return idOfQuiz;
        }catch(ArrayIndexOutOfBoundsException ex){
            msgBox("Select Quiz To Delete");
        }
        return 0;
    }
    public void deleteQuiz (ActionListener deleteQuizListenerButton) {                                       
        ButtonDeleteQuiz.addActionListener(deleteQuizListenerButton);
    }
    public void deleteMessage (ActionListener deleteMessagesListenerButton) {                                       
        ButtonDeleteMessage.addActionListener(deleteMessagesListenerButton);
    }
    public void settingsProfile (ActionListener settingsProfileListenerButton) {                                       
        jButtonSettings.addActionListener(settingsProfileListenerButton);
    }
    public void setTestFullNameProfile (String name){
        jTextFieldName.setText(name);
        FullName.setText(name);
    }
    public void setTestUsernameProfile (String username){
        jTextFieldUsername.setText(username);
        Username.setText("@"+username);
    }
    public void setTestEmailProfile (String email){
        jTextFieldEmail.setText(email);
    }
    public void setTestPhoneProfile (String phone){
         jTextFieldPhone.setText(phone);
    }
    public void setTestFacebookProfile (String facebook){
         jTextFieldFacebook.setText(facebook);
    }
    public void setTestTwitterProfile (String twitter){
         jTextFieldTwitter.setText(twitter);
    }
    public void setTestGithubProfile (String github){
         jTextFieldGithub.setText(github);
    }
    public void setTestYoutubeProfile (String youtube){
         jTextFieldYoutube.setText(youtube);
    }
    public void setTestWebSiteProfile (String webSite){
         jTextFieldWebSite.setText(webSite);
    }
    
    public String getTestFullNameProfile ( ){
        return jTextFieldName.getText();
    }
    public String getTestUsernameProfile ( ){
        return jTextFieldUsername.getText();
    }
    public String getTestEmailProfile ( ){
        return jTextFieldEmail.getText();
    }
    public String getTestPhoneProfile ( ){
        return  jTextFieldPhone.getText();
    }
    public String getTestPasswordProfile ( ){
        return  jPasswordFieldUpdeta.getText();
    }
    public String getTestFacebookProfile ( ){
        return  jTextFieldFacebook.getText();
    }
    public String getTestTwitterProfile ( ){
        return  jTextFieldTwitter.getText();
    }
    public String getTestGithubProfile ( ){
        return  jTextFieldGithub.getText();
    }
    public String getTestYoutubeProfile ( ){
        return  jTextFieldYoutube.getText();
    }
    public String getTestWebSiteProfile ( ){
        return  jTextFieldWebSite.getText();
    }
    public void updataProfile (ActionListener updataProfileListenerButton) {                                       
        buttonUpdata.addActionListener(updataProfileListenerButton);
    }
    public String getNameOfQuiz (){
        return nameQuiz;
    }
    public String getTagOfQuiz (){
        return tagQuiz;
    }
    public String getDetailsOfQuiz (){
        return detailsQuiz;
    }
    public String [][] getQuestionsOfQuiz (){
        return questionsQuiz;
    }
    public void addQuiz (ActionListener aaddQuizListenerButton) {                                       
        jButtonDoneQuiz.addActionListener(aaddQuizListenerButton);
    }
    public void logout (ActionListener logoutListenerButton) {                                       
        jButtonLogout.addActionListener(logoutListenerButton);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupAnyQTrue = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelLeft = new javax.swing.JPanel();
        LogoIcon = new javax.swing.JLabel();
        jLabelWelcome = new javax.swing.JLabel();
        fullNameAdmin = new javax.swing.JLabel();
        jLabelAdmin = new javax.swing.JLabel();
        jButtonHome = new javax.swing.JButton();
        jButtonUsers = new javax.swing.JButton();
        jButtonQuizzes = new javax.swing.JButton();
        jButtonMessages = new javax.swing.JButton();
        jButtonSettings = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jPanelRight = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        JPNumOfUsers = new javax.swing.JPanel();
        IconUser = new javax.swing.JLabel();
        jLabelUsers1 = new javax.swing.JLabel();
        jLabelTotalUsers = new javax.swing.JLabel();
        JPTotalQuizzes = new javax.swing.JPanel();
        IconQuizzes = new javax.swing.JLabel();
        jLabelTotalQuizzes = new javax.swing.JLabel();
        jLabelTQuizzes = new javax.swing.JLabel();
        JPTotalQuizzesCompleted = new javax.swing.JPanel();
        IconQuizzesCompleted = new javax.swing.JLabel();
        jLabelQuizzesCompleted = new javax.swing.JLabel();
        jLabelQuizzesCompleted2 = new javax.swing.JLabel();
        jLabelTotalQuizzesCompleted = new javax.swing.JLabel();
        jPanelBoxMessages = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Massagebox1 = new javax.swing.JPanel();
        Username1 = new javax.swing.JLabel();
        Title1 = new javax.swing.JLabel();
        Massagebox2 = new javax.swing.JPanel();
        Username2 = new javax.swing.JLabel();
        Title2 = new javax.swing.JLabel();
        Massagebox3 = new javax.swing.JPanel();
        Username3 = new javax.swing.JLabel();
        Title3 = new javax.swing.JLabel();
        Massagebox4 = new javax.swing.JPanel();
        Username4 = new javax.swing.JLabel();
        Title4 = new javax.swing.JLabel();
        Massagebox5 = new javax.swing.JPanel();
        Username5 = new javax.swing.JLabel();
        Title5 = new javax.swing.JLabel();
        Massagebox6 = new javax.swing.JPanel();
        Username6 = new javax.swing.JLabel();
        Title6 = new javax.swing.JLabel();
        Massagebox7 = new javax.swing.JPanel();
        Username7 = new javax.swing.JLabel();
        Title7 = new javax.swing.JLabel();
        Massagebox8 = new javax.swing.JPanel();
        Username8 = new javax.swing.JLabel();
        Title8 = new javax.swing.JLabel();
        Morebox = new javax.swing.JPanel();
        jButtonMore = new javax.swing.JButton();
        NewUsers = new javax.swing.JScrollPane();
        jTNewUser = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        Users = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        SearchUser = new javax.swing.JTextField();
        TableUsers = new javax.swing.JScrollPane();
        jTUsers = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Quizzes = new javax.swing.JPanel();
        SearchQuiz = new javax.swing.JTextField();
        TableQuizzes = new javax.swing.JScrollPane();
        jTQuizzes = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        searchMessages1 = new javax.swing.JLabel();
        ButtonDeleteQuiz = new javax.swing.JButton();
        Messages = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        SearchMessage = new javax.swing.JTextField();
        TableMessages = new javax.swing.JScrollPane();
        jTMessages = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        ButtonDeleteMessage = new javax.swing.JButton();
        searchMessages = new javax.swing.JLabel();
        Settings = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelDetail = new javax.swing.JPanel();
        Username = new javax.swing.JLabel();
        FullName = new javax.swing.JLabel();
        jPanelDetails = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanelName = new javax.swing.JPanel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanelUsername = new javax.swing.JPanel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanelEmail = new javax.swing.JPanel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanelPassword = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPasswordFieldUpdeta = new javax.swing.JPasswordField();
        jPanelPhone = new javax.swing.JPanel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jPanelFacebook = new javax.swing.JPanel();
        jTextFieldFacebook = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanelTwitter = new javax.swing.JPanel();
        jTextFieldTwitter = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanelGithub = new javax.swing.JPanel();
        jTextFieldGithub = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanelYoutube = new javax.swing.JPanel();
        jTextFieldYoutube = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanelWebSite = new javax.swing.JPanel();
        jTextFieldWebSite = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        buttonUpdata = new javax.swing.JButton();
        AddQuiz = new javax.swing.JPanel();
        AddNewQuiz = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldNameQuiz = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldTagQuiz = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAreaDetails = new javax.swing.JTextArea();
        jButtonAddQuiz = new javax.swing.JButton();
        imgQuiz = new javax.swing.JLabel();
        AddNewQuestions = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldIDQuiz = new javax.swing.JTextField();
        jLabelNumQuestion = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldNameQuestion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldChoice1 = new javax.swing.JTextField();
        jRadioButtonChoice1 = new javax.swing.JRadioButton();
        jTextFieldChoice2 = new javax.swing.JTextField();
        jRadioButtonChoice2 = new javax.swing.JRadioButton();
        jTextFieldChoice3 = new javax.swing.JTextField();
        jRadioButtonChoice3 = new javax.swing.JRadioButton();
        jTextFieldChoice4 = new javax.swing.JTextField();
        jRadioButtonChoice4 = new javax.swing.JRadioButton();
        jButtonDoneQuiz = new javax.swing.JButton();
        jButtonAddQuestion = new javax.swing.JButton();
        imgQuiz1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1480, 720));
        setResizable(false);

        jPanelLeft.setBackground(new java.awt.Color(0, 32, 74));
        jPanelLeft.setPreferredSize(new java.awt.Dimension(250, 552));

        LogoIcon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LogoIcon.setText("Welcome");

        jLabelWelcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelWelcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Logo.png"))); // NOI18N

        fullNameAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fullNameAdmin.setText("Khaled 0 Adel");

        jLabelAdmin.setText("Admin");

        jButtonHome.setBackground(new java.awt.Color(253, 180, 75));
        jButtonHome.setForeground(new java.awt.Color(0, 0, 0));
        jButtonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_home_16px_1.png"))); // NOI18N
        jButtonHome.setText("Home");
        jButtonHome.setFocusable(false);
        jButtonHome.setPreferredSize(new java.awt.Dimension(250, 20));
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });

        jButtonUsers.setBackground(new java.awt.Color(0, 32, 74));
        jButtonUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_users_16px.png"))); // NOI18N
        jButtonUsers.setText("Users");
        jButtonUsers.setFocusable(false);
        jButtonUsers.setPreferredSize(new java.awt.Dimension(250, 20));
        jButtonUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsersActionPerformed(evt);
            }
        });

        jButtonQuizzes.setBackground(new java.awt.Color(0, 32, 74));
        jButtonQuizzes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_questions_16px.png"))); // NOI18N
        jButtonQuizzes.setText("Quizzes");
        jButtonQuizzes.setFocusable(false);
        jButtonQuizzes.setPreferredSize(new java.awt.Dimension(250, 20));
        jButtonQuizzes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuizzesActionPerformed(evt);
            }
        });

        jButtonMessages.setBackground(new java.awt.Color(0, 32, 74));
        jButtonMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_group_message_16px.png"))); // NOI18N
        jButtonMessages.setText("Messages");
        jButtonMessages.setFocusable(false);
        jButtonMessages.setPreferredSize(new java.awt.Dimension(250, 30));
        jButtonMessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMessagesActionPerformed(evt);
            }
        });

        jButtonSettings.setBackground(new java.awt.Color(0, 32, 74));
        jButtonSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_settings_16px_1.png"))); // NOI18N
        jButtonSettings.setText("Settings");
        jButtonSettings.setFocusable(false);
        jButtonSettings.setPreferredSize(new java.awt.Dimension(250, 30));
        jButtonSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSettingsActionPerformed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(0, 32, 74));
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_add_32px.png"))); // NOI18N
        jButtonAdd.setFocusable(false);
        jButtonAdd.setPreferredSize(new java.awt.Dimension(250, 30));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Logout_16px.png"))); // NOI18N
        jButtonLogout.setToolTipText("");
        jButtonLogout.setFocusable(false);
        jButtonLogout.setPreferredSize(new java.awt.Dimension(250, 30));

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLeftLayout.createSequentialGroup()
                        .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLeftLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelWelcome)
                                    .addComponent(fullNameAdmin)
                                    .addGroup(jPanelLeftLayout.createSequentialGroup()
                                        .addComponent(LogoIcon)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelAdmin))))
                            .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonQuizzes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLeftLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoIcon)
                    .addComponent(jLabelAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullNameAdmin)
                .addGap(18, 18, 18)
                .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonQuizzes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanelLeft);

        jPanelRight.setBackground(new java.awt.Color(204, 255, 255));
        jPanelRight.setLayout(new java.awt.CardLayout());

        JPNumOfUsers.setPreferredSize(new java.awt.Dimension(200, 200));

        IconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_users_64px.png"))); // NOI18N

        jLabelUsers1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelUsers1.setText("Users");

        jLabelTotalUsers.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabelTotalUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalUsers.setText("15,555");

        javax.swing.GroupLayout JPNumOfUsersLayout = new javax.swing.GroupLayout(JPNumOfUsers);
        JPNumOfUsers.setLayout(JPNumOfUsersLayout);
        JPNumOfUsersLayout.setHorizontalGroup(
            JPNumOfUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNumOfUsersLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(IconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabelUsers1)
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jLabelTotalUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPNumOfUsersLayout.setVerticalGroup(
            JPNumOfUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNumOfUsersLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(JPNumOfUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsers1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IconUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalUsers)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        JPTotalQuizzes.setPreferredSize(new java.awt.Dimension(200, 200));

        IconQuizzes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_questions_64px_1.png"))); // NOI18N

        jLabelTotalQuizzes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTotalQuizzes.setText("Total Quizzes");

        jLabelTQuizzes.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabelTQuizzes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTQuizzes.setText("1,555");
        jLabelTQuizzes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelTQuizzes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTQuizzes.setOpaque(true);
        jLabelTQuizzes.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout JPTotalQuizzesLayout = new javax.swing.GroupLayout(JPTotalQuizzes);
        JPTotalQuizzes.setLayout(JPTotalQuizzesLayout);
        JPTotalQuizzesLayout.setHorizontalGroup(
            JPTotalQuizzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTotalQuizzesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(IconQuizzes, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalQuizzes)
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(jLabelTQuizzes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPTotalQuizzesLayout.setVerticalGroup(
            JPTotalQuizzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTotalQuizzesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(JPTotalQuizzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotalQuizzes, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IconQuizzes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTQuizzes)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        JPTotalQuizzesCompleted.setPreferredSize(new java.awt.Dimension(200, 200));

        IconQuizzesCompleted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_completed_task_64px.png"))); // NOI18N

        jLabelQuizzesCompleted.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelQuizzesCompleted.setText("Total Quizzes");

        jLabelQuizzesCompleted2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelQuizzesCompleted2.setText("Completed");

        jLabelTotalQuizzesCompleted.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabelTotalQuizzesCompleted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalQuizzesCompleted.setText("155,555");

        javax.swing.GroupLayout JPTotalQuizzesCompletedLayout = new javax.swing.GroupLayout(JPTotalQuizzesCompleted);
        JPTotalQuizzesCompleted.setLayout(JPTotalQuizzesCompletedLayout);
        JPTotalQuizzesCompletedLayout.setHorizontalGroup(
            JPTotalQuizzesCompletedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTotalQuizzesCompletedLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(IconQuizzesCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPTotalQuizzesCompletedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelQuizzesCompleted)
                    .addComponent(jLabelQuizzesCompleted2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JPTotalQuizzesCompletedLayout.createSequentialGroup()
                .addComponent(jLabelTotalQuizzesCompleted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPTotalQuizzesCompletedLayout.setVerticalGroup(
            JPTotalQuizzesCompletedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTotalQuizzesCompletedLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(JPTotalQuizzesCompletedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPTotalQuizzesCompletedLayout.createSequentialGroup()
                        .addComponent(jLabelQuizzesCompleted2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelQuizzesCompleted))
                    .addComponent(IconQuizzesCompleted, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalQuizzesCompleted)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 80));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_group_message_16px.png"))); // NOI18N
        jLabel1.setText("New Messages");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 163;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 18, 12);
        jPanel1.add(jLabel1, gridBagConstraints);

        jPanelBoxMessages.add(jPanel1);

        Massagebox1.setFocusTraversalPolicyProvider(true);
        Massagebox1.setPreferredSize(new java.awt.Dimension(400, 60));
        Massagebox1.setLayout(new java.awt.GridBagLayout());

        Username1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Username1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_user_32px.png"))); // NOI18N
        Username1.setText("Username1");
        Username1.setPreferredSize(new java.awt.Dimension(400, 32));
        Massagebox1.add(Username1, new java.awt.GridBagConstraints());

        Title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title1.setText("Title: the problem in HTML quiz ");
        Title1.setPreferredSize(new java.awt.Dimension(400, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Massagebox1.add(Title1, gridBagConstraints);

        jPanelBoxMessages.add(Massagebox1);

        Massagebox2.setFocusTraversalPolicyProvider(true);
        Massagebox2.setPreferredSize(new java.awt.Dimension(400, 60));
        Massagebox2.setLayout(new java.awt.GridBagLayout());

        Username2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Username2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_user_32px.png"))); // NOI18N
        Username2.setText("Username1");
        Username2.setPreferredSize(new java.awt.Dimension(400, 32));
        Massagebox2.add(Username2, new java.awt.GridBagConstraints());

        Title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title2.setText("Title: the problem in HTML quiz ");
        Title2.setPreferredSize(new java.awt.Dimension(400, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Massagebox2.add(Title2, gridBagConstraints);

        jPanelBoxMessages.add(Massagebox2);

        Massagebox3.setFocusTraversalPolicyProvider(true);
        Massagebox3.setPreferredSize(new java.awt.Dimension(400, 60));
        Massagebox3.setLayout(new java.awt.GridBagLayout());

        Username3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Username3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_user_32px.png"))); // NOI18N
        Username3.setText("Username1");
        Username3.setPreferredSize(new java.awt.Dimension(400, 32));
        Massagebox3.add(Username3, new java.awt.GridBagConstraints());

        Title3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title3.setText("Title: the problem in HTML quiz ");
        Title3.setPreferredSize(new java.awt.Dimension(400, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Massagebox3.add(Title3, gridBagConstraints);

        jPanelBoxMessages.add(Massagebox3);

        Massagebox4.setFocusTraversalPolicyProvider(true);
        Massagebox4.setPreferredSize(new java.awt.Dimension(400, 60));
        Massagebox4.setLayout(new java.awt.GridBagLayout());

        Username4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Username4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_user_32px.png"))); // NOI18N
        Username4.setText("Username1");
        Username4.setPreferredSize(new java.awt.Dimension(400, 32));
        Massagebox4.add(Username4, new java.awt.GridBagConstraints());

        Title4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title4.setText("Title: the problem in HTML quiz ");
        Title4.setPreferredSize(new java.awt.Dimension(400, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Massagebox4.add(Title4, gridBagConstraints);

        jPanelBoxMessages.add(Massagebox4);

        Massagebox5.setFocusTraversalPolicyProvider(true);
        Massagebox5.setPreferredSize(new java.awt.Dimension(400, 60));
        Massagebox5.setLayout(new java.awt.GridBagLayout());

        Username5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Username5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_user_32px.png"))); // NOI18N
        Username5.setText("Username1");
        Username5.setPreferredSize(new java.awt.Dimension(400, 32));
        Massagebox5.add(Username5, new java.awt.GridBagConstraints());

        Title5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title5.setText("Title: the problem in HTML quiz ");
        Title5.setPreferredSize(new java.awt.Dimension(400, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Massagebox5.add(Title5, gridBagConstraints);

        jPanelBoxMessages.add(Massagebox5);

        Massagebox6.setFocusTraversalPolicyProvider(true);
        Massagebox6.setPreferredSize(new java.awt.Dimension(400, 60));
        Massagebox6.setLayout(new java.awt.GridBagLayout());

        Username6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Username6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_user_32px.png"))); // NOI18N
        Username6.setText("Username1");
        Username6.setPreferredSize(new java.awt.Dimension(400, 32));
        Massagebox6.add(Username6, new java.awt.GridBagConstraints());

        Title6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title6.setText("Title: the problem in HTML quiz ");
        Title6.setPreferredSize(new java.awt.Dimension(400, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Massagebox6.add(Title6, gridBagConstraints);

        jPanelBoxMessages.add(Massagebox6);

        Massagebox7.setFocusTraversalPolicyProvider(true);
        Massagebox7.setPreferredSize(new java.awt.Dimension(400, 60));
        Massagebox7.setLayout(new java.awt.GridBagLayout());

        Username7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Username7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_user_32px.png"))); // NOI18N
        Username7.setText("Username1");
        Username7.setPreferredSize(new java.awt.Dimension(400, 32));
        Massagebox7.add(Username7, new java.awt.GridBagConstraints());

        Title7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title7.setText("Title: the problem in HTML quiz ");
        Title7.setPreferredSize(new java.awt.Dimension(400, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Massagebox7.add(Title7, gridBagConstraints);

        jPanelBoxMessages.add(Massagebox7);

        Massagebox8.setFocusTraversalPolicyProvider(true);
        Massagebox8.setPreferredSize(new java.awt.Dimension(400, 60));
        Massagebox8.setLayout(new java.awt.GridBagLayout());

        Username8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Username8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_user_32px.png"))); // NOI18N
        Username8.setText("Username1");
        Username8.setPreferredSize(new java.awt.Dimension(400, 32));
        Massagebox8.add(Username8, new java.awt.GridBagConstraints());

        Title8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title8.setText("Title: the problem in HTML quiz ");
        Title8.setPreferredSize(new java.awt.Dimension(400, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Massagebox8.add(Title8, gridBagConstraints);

        jPanelBoxMessages.add(Massagebox8);

        Morebox.setMinimumSize(new java.awt.Dimension(411, 80));
        Morebox.setPreferredSize(new java.awt.Dimension(400, 90));
        Morebox.setLayout(new java.awt.GridBagLayout());

        jButtonMore.setText("More");
        jButtonMore.setPreferredSize(new java.awt.Dimension(100, 25));
        jButtonMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoreActionPerformed(evt);
            }
        });
        Morebox.add(jButtonMore, new java.awt.GridBagConstraints());

        jPanelBoxMessages.add(Morebox);

        jTNewUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        NewUsers.setViewportView(jTNewUser);

        jLabel11.setText("New Users");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(JPNumOfUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(JPTotalQuizzes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(JPTotalQuizzesCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(NewUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jPanelBoxMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JPTotalQuizzesCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPTotalQuizzes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPNumOfUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(NewUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addComponent(jPanelBoxMessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelRight.add(Home, "Home");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_search_32px.png"))); // NOI18N

        SearchUser.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableUsers.setViewportView(jTUsers);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setText("USERS");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel31.setText("USERNAME");

        javax.swing.GroupLayout UsersLayout = new javax.swing.GroupLayout(Users);
        Users.setLayout(UsersLayout);
        UsersLayout.setHorizontalGroup(
            UsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableUsers)
                    .addGroup(UsersLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(190, 190, 190)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addGap(0, 303, Short.MAX_VALUE)))
                .addContainerGap())
        );
        UsersLayout.setVerticalGroup(
            UsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UsersLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(UsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SearchUser, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(TableUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelRight.add(Users, "Users");

        SearchQuiz.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTQuizzes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableQuizzes.setViewportView(jTQuizzes);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setText("QUIZZES");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel30.setText("TAG");

        searchMessages1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchMessages1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_search_32px.png"))); // NOI18N

        ButtonDeleteQuiz.setForeground(new java.awt.Color(255, 255, 255));
        ButtonDeleteQuiz.setText("Delete");

        javax.swing.GroupLayout QuizzesLayout = new javax.swing.GroupLayout(Quizzes);
        Quizzes.setLayout(QuizzesLayout);
        QuizzesLayout.setHorizontalGroup(
            QuizzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizzesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QuizzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableQuizzes, javax.swing.GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)
                    .addGroup(QuizzesLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(190, 190, 190)
                        .addComponent(searchMessages1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(QuizzesLayout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(ButtonDeleteQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        QuizzesLayout.setVerticalGroup(
            QuizzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuizzesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(QuizzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SearchQuiz)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchMessages1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(TableQuizzes, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ButtonDeleteQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelRight.add(Quizzes, "Quizzes");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setText("ID");

        SearchMessage.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTMessages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TableMessages.setViewportView(jTMessages);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setText("MESSAGES");

        ButtonDeleteMessage.setForeground(new java.awt.Color(255, 255, 255));
        ButtonDeleteMessage.setText("Delete");

        searchMessages.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_search_32px.png"))); // NOI18N

        javax.swing.GroupLayout MessagesLayout = new javax.swing.GroupLayout(Messages);
        Messages.setLayout(MessagesLayout);
        MessagesLayout.setHorizontalGroup(
            MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableMessages)
                    .addGroup(MessagesLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(190, 190, 190)
                        .addComponent(searchMessages)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 378, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(MessagesLayout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(ButtonDeleteMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MessagesLayout.setVerticalGroup(
            MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessagesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(searchMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(TableMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ButtonDeleteMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelRight.add(Messages, "Messages");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Avatar.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Admin");

        jPanelDetail.setLayout(new java.awt.BorderLayout(0, -5));

        Username.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Username.setText("@Username");
        jPanelDetail.add(Username, java.awt.BorderLayout.PAGE_END);

        FullName.setBackground(new java.awt.Color(0, 0, 0));
        FullName.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        FullName.setText("Khaled Adel");
        jPanelDetail.add(FullName, java.awt.BorderLayout.PAGE_START);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel16.setText("SETTINGS");

        jLabel8.setText("Name");

        javax.swing.GroupLayout jPanelNameLayout = new javax.swing.GroupLayout(jPanelName);
        jPanelName.setLayout(jPanelNameLayout);
        jPanelNameLayout.setHorizontalGroup(
            jPanelNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelNameLayout.setVerticalGroup(
            jPanelNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNameLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setText("Username");

        javax.swing.GroupLayout jPanelUsernameLayout = new javax.swing.GroupLayout(jPanelUsername);
        jPanelUsername.setLayout(jPanelUsernameLayout);
        jPanelUsernameLayout.setHorizontalGroup(
            jPanelUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsernameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelUsernameLayout.setVerticalGroup(
            jPanelUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsernameLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setText("Email");

        javax.swing.GroupLayout jPanelEmailLayout = new javax.swing.GroupLayout(jPanelEmail);
        jPanelEmail.setLayout(jPanelEmailLayout);
        jPanelEmailLayout.setHorizontalGroup(
            jPanelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmailLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelEmailLayout.setVerticalGroup(
            jPanelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmailLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel10.setText("Password");

        javax.swing.GroupLayout jPanelPasswordLayout = new javax.swing.GroupLayout(jPanelPassword);
        jPanelPassword.setLayout(jPanelPasswordLayout);
        jPanelPasswordLayout.setHorizontalGroup(
            jPanelPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPasswordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(218, 218, 218))
            .addGroup(jPanelPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPasswordFieldUpdeta, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPasswordLayout.setVerticalGroup(
            jPanelPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasswordLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordFieldUpdeta, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel29.setText("Phone Number");

        javax.swing.GroupLayout jPanelPhoneLayout = new javax.swing.GroupLayout(jPanelPhone);
        jPanelPhone.setLayout(jPanelPhoneLayout);
        jPanelPhoneLayout.setHorizontalGroup(
            jPanelPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPhoneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelPhoneLayout.setVerticalGroup(
            jPanelPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPhoneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel24.setText("Facebook");

        javax.swing.GroupLayout jPanelFacebookLayout = new javax.swing.GroupLayout(jPanelFacebook);
        jPanelFacebook.setLayout(jPanelFacebookLayout);
        jPanelFacebookLayout.setHorizontalGroup(
            jPanelFacebookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFacebookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFacebookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jTextFieldFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelFacebookLayout.setVerticalGroup(
            jPanelFacebookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFacebookLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldFacebook, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel25.setText("Twitter");

        javax.swing.GroupLayout jPanelTwitterLayout = new javax.swing.GroupLayout(jPanelTwitter);
        jPanelTwitter.setLayout(jPanelTwitterLayout);
        jPanelTwitterLayout.setHorizontalGroup(
            jPanelTwitterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTwitterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTwitterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jTextFieldTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelTwitterLayout.setVerticalGroup(
            jPanelTwitterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTwitterLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldTwitter, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel26.setText("Github");

        javax.swing.GroupLayout jPanelGithubLayout = new javax.swing.GroupLayout(jPanelGithub);
        jPanelGithub.setLayout(jPanelGithubLayout);
        jPanelGithubLayout.setHorizontalGroup(
            jPanelGithubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGithubLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGithubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jTextFieldGithub, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelGithubLayout.setVerticalGroup(
            jPanelGithubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGithubLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldGithub, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel27.setText("Youtube");

        javax.swing.GroupLayout jPanelYoutubeLayout = new javax.swing.GroupLayout(jPanelYoutube);
        jPanelYoutube.setLayout(jPanelYoutubeLayout);
        jPanelYoutubeLayout.setHorizontalGroup(
            jPanelYoutubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelYoutubeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelYoutubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jTextFieldYoutube, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelYoutubeLayout.setVerticalGroup(
            jPanelYoutubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelYoutubeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldYoutube, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel28.setText("WebSite");

        javax.swing.GroupLayout jPanelWebSiteLayout = new javax.swing.GroupLayout(jPanelWebSite);
        jPanelWebSite.setLayout(jPanelWebSiteLayout);
        jPanelWebSiteLayout.setHorizontalGroup(
            jPanelWebSiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWebSiteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelWebSiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jTextFieldWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelWebSiteLayout.setVerticalGroup(
            jPanelWebSiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWebSiteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldWebSite, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        buttonUpdata.setForeground(new java.awt.Color(255, 255, 255));
        buttonUpdata.setText("Updata");

        javax.swing.GroupLayout jPanelDetailsLayout = new javax.swing.GroupLayout(jPanelDetails);
        jPanelDetails.setLayout(jPanelDetailsLayout);
        jPanelDetailsLayout.setHorizontalGroup(
            jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel16))
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(buttonUpdata, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jPanelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)
                                .addComponent(jPanelWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanelPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanelFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanelGithub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanelTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanelYoutube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelDetailsLayout.setVerticalGroup(
            jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jPanelTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelYoutube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jPanelFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelGithub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jPanelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                                .addComponent(jPanelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(buttonUpdata, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        javax.swing.GroupLayout SettingsLayout = new javax.swing.GroupLayout(Settings);
        Settings.setLayout(SettingsLayout);
        SettingsLayout.setHorizontalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(SettingsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SettingsLayout.setVerticalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingsLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(jPanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jPanelDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelRight.add(Settings, "Settings");

        AddQuiz.setLayout(new java.awt.CardLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel17.setText("ADD QUIZZES");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Name");

        jTextFieldNameQuiz.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Tag");

        jTextFieldTagQuiz.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Details");

        jAreaDetails.setColumns(20);
        jAreaDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jAreaDetails.setRows(5);
        jScrollPane1.setViewportView(jAreaDetails);

        jButtonAddQuiz.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAddQuiz.setText("Add");
        jButtonAddQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddQuizActionPerformed(evt);
            }
        });

        imgQuiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/OnlineQuiz.png"))); // NOI18N

        javax.swing.GroupLayout AddNewQuizLayout = new javax.swing.GroupLayout(AddNewQuiz);
        AddNewQuiz.setLayout(AddNewQuizLayout);
        AddNewQuizLayout.setHorizontalGroup(
            AddNewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewQuizLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(AddNewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewQuizLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButtonAddQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(865, Short.MAX_VALUE))
                    .addGroup(AddNewQuizLayout.createSequentialGroup()
                        .addGroup(AddNewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(AddNewQuizLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(AddNewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jTextFieldNameQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(jTextFieldTagQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imgQuiz)
                        .addGap(180, 180, 180))))
        );
        AddNewQuizLayout.setVerticalGroup(
            AddNewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewQuizLayout.createSequentialGroup()
                .addGroup(AddNewQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewQuizLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNameQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTagQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddNewQuizLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(imgQuiz)))
                .addGap(15, 15, 15)
                .addComponent(jButtonAddQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        AddQuiz.add(AddNewQuiz, "AddNewQuiz");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel20.setText("ADD QUESTIONS");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("ID Quiz");

        jTextFieldIDQuiz.setEditable(false);
        jTextFieldIDQuiz.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldIDQuiz.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIDQuiz.setText("****");

        jLabelNumQuestion.setText("Question - 1");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Question");

        jTextFieldNameQuestion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldNameQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameQuestionActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Choices");

        jTextFieldChoice1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldChoice1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonGroupAnyQTrue.add(jRadioButtonChoice1);
        jRadioButtonChoice1.setText("True");

        jTextFieldChoice2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldChoice2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonGroupAnyQTrue.add(jRadioButtonChoice2);
        jRadioButtonChoice2.setText("True");

        jTextFieldChoice3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldChoice3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonGroupAnyQTrue.add(jRadioButtonChoice3);
        jRadioButtonChoice3.setText("True");

        jTextFieldChoice4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldChoice4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonGroupAnyQTrue.add(jRadioButtonChoice4);
        jRadioButtonChoice4.setText("True");

        jButtonDoneQuiz.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDoneQuiz.setText("Done");
        jButtonDoneQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoneQuizActionPerformed(evt);
            }
        });

        jButtonAddQuestion.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAddQuestion.setText("Add");
        jButtonAddQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddQuestionActionPerformed(evt);
            }
        });

        imgQuiz1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/OnlineQuiz.png"))); // NOI18N

        javax.swing.GroupLayout AddNewQuestionsLayout = new javax.swing.GroupLayout(AddNewQuestions);
        AddNewQuestions.setLayout(AddNewQuestionsLayout);
        AddNewQuestionsLayout.setHorizontalGroup(
            AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22)
                            .addComponent(jTextFieldNameQuestion)
                            .addComponent(jLabelNumQuestion)
                            .addComponent(jTextFieldChoice1)
                            .addComponent(jTextFieldChoice2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                            .addComponent(jTextFieldChoice3, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                            .addComponent(jTextFieldChoice4, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonChoice1)
                            .addComponent(jRadioButtonChoice2)
                            .addComponent(jRadioButtonChoice3)
                            .addComponent(jRadioButtonChoice4)))
                    .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel23))
                    .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIDQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel21)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(imgQuiz1)
                .addGap(180, 180, 180))
            .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel20))
                    .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonDoneQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(843, Short.MAX_VALUE))
        );
        AddNewQuestionsLayout.setVerticalGroup(
            AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIDQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabelNumQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNameQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonChoice1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonChoice2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonChoice3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddNewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldChoice4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonChoice4)))
                    .addGroup(AddNewQuestionsLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(imgQuiz1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDoneQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        AddQuiz.add(AddNewQuestions, "AddNewQuestions");

        jPanelRight.add(AddQuiz, "AddQuiz");

        jSplitPane1.setRightComponent(jPanelRight);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1474, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsersActionPerformed
        cardLayoutPage.show(jPanelRight, "Users");
    }//GEN-LAST:event_jButtonUsersActionPerformed

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        cardLayoutPage.show(jPanelRight, "Home");
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonQuizzesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuizzesActionPerformed
        cardLayoutPage.show(jPanelRight, "Quizzes");
    }//GEN-LAST:event_jButtonQuizzesActionPerformed

    private void jButtonMessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMessagesActionPerformed
        cardLayoutPage.show(jPanelRight, "Messages");
        
    }//GEN-LAST:event_jButtonMessagesActionPerformed

    private void jButtonSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSettingsActionPerformed
        cardLayoutPage.show(jPanelRight, "Settings");
    }//GEN-LAST:event_jButtonSettingsActionPerformed

    private void jButtonMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoreActionPerformed
        cardLayoutPage.show(jPanelRight, "Messages");
    }//GEN-LAST:event_jButtonMoreActionPerformed

    private void jTextFieldNameQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameQuestionActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        cardLayoutPage.show(jPanelRight, "AddQuiz");
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonAddQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddQuizActionPerformed
        if(!jTextFieldNameQuiz.getText().isEmpty() || !jTextFieldTagQuiz.getText().isEmpty() || !jAreaDetails.getText().isEmpty()){
            nameQuiz =   jTextFieldNameQuiz.getText();
            tagQuiz  =   jTextFieldTagQuiz.getText();
            detailsQuiz  =   jAreaDetails.getText();
            cardLayoutPageAddQuizzes.show(AddQuiz, "AddNewQuestions");
            jButtonDoneQuiz.setEnabled(false);
        }else{
            errmsgBox("Complete");
        }
    }//GEN-LAST:event_jButtonAddQuizActionPerformed

    private void jButtonAddQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddQuestionActionPerformed
        jLabelNumQuestion.setText("Question  - " + (numOfQuestion));
        String nameQuestion=  jTextFieldNameQuestion.getText();
        String Choice1=  jTextFieldChoice1.getText();
        String Choice2=  jTextFieldChoice2.getText();
        String Choice3=  jTextFieldChoice3.getText();
        String Choice4=  jTextFieldChoice4.getText();
        setQuestion( nameQuestion, Choice1,  Choice2, Choice3, Choice4);
        if(numOfQuestion == 6){jButtonDoneQuiz.setEnabled(true);}
    }//GEN-LAST:event_jButtonAddQuestionActionPerformed

    private void setQuestion(  String nameQuestion,String Choice1, String Choice2,String Choice3,String Choice4){
        int numAnswer = getNumSelectionButton(buttonGroupAnyQTrue);
       if (numAnswer != 0  && numOfQuestion < 6){
            questionsQuiz[numOfQuestion][0]    =    nameQuestion;
            questionsQuiz[numOfQuestion][1]    =    Choice1;    
            questionsQuiz[numOfQuestion][2]    =    Choice2;
            questionsQuiz[numOfQuestion][3]    =    Choice3;
            questionsQuiz[numOfQuestion][4]    =    Choice4;
            questionsQuiz[numOfQuestion][5]    =    String.valueOf(numAnswer);
            numOfQuestion++;
            jLabelNumQuestion.setText("Question  - " + (numOfQuestion+1));
            jTextFieldNameQuestion.setText("");
            jTextFieldChoice1.setText("");
            jTextFieldChoice2.setText("");
            jTextFieldChoice3.setText("");
            jTextFieldChoice4.setText("");
        }else if (numOfQuestion >= 6){
            msgBox("mix 6 Question");
        }
   }
     private int getNumSelectionButton (ButtonGroup buttonGroup){
        try{
        if(buttonGroup.getSelection().equals(jRadioButtonChoice1.getModel())){
            return 1;
        }else if(buttonGroup.getSelection().equals(jRadioButtonChoice2.getModel())){
            return 2;
        }else if(buttonGroup.getSelection().equals(jRadioButtonChoice3.getModel())){
            return 3;
        }else if(buttonGroup.getSelection().equals(jRadioButtonChoice4.getModel())){
            return 4;
        }}catch(NullPointerException ex){
            errmsgBox("Choose the right choice");
        }
        return 0;
    }
    private void jButtonDoneQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoneQuizActionPerformed
        cardLayoutPageAddQuizzes.show(AddQuiz, "AddNewQuiz");
        jTextFieldNameQuiz.setText("");
        jTextFieldTagQuiz.setText("");
        jAreaDetails.setText("");
        jTextFieldNameQuestion.setText("");
        jTextFieldChoice1.setText("");
        jTextFieldChoice2.setText("");
        jTextFieldChoice3.setText("");
        jTextFieldChoice4.setText("");
    }//GEN-LAST:event_jButtonDoneQuizActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddNewQuestions;
    private javax.swing.JPanel AddNewQuiz;
    private javax.swing.JPanel AddQuiz;
    private javax.swing.JButton ButtonDeleteMessage;
    private javax.swing.JButton ButtonDeleteQuiz;
    private javax.swing.JLabel FullName;
    private javax.swing.JPanel Home;
    private javax.swing.JLabel IconQuizzes;
    private javax.swing.JLabel IconQuizzesCompleted;
    private javax.swing.JLabel IconUser;
    private javax.swing.JPanel JPNumOfUsers;
    private javax.swing.JPanel JPTotalQuizzes;
    private javax.swing.JPanel JPTotalQuizzesCompleted;
    private javax.swing.JLabel LogoIcon;
    private javax.swing.JPanel Massagebox1;
    private javax.swing.JPanel Massagebox2;
    private javax.swing.JPanel Massagebox3;
    private javax.swing.JPanel Massagebox4;
    private javax.swing.JPanel Massagebox5;
    private javax.swing.JPanel Massagebox6;
    private javax.swing.JPanel Massagebox7;
    private javax.swing.JPanel Massagebox8;
    private javax.swing.JPanel Messages;
    private javax.swing.JPanel Morebox;
    private javax.swing.JScrollPane NewUsers;
    private javax.swing.JPanel Quizzes;
    private javax.swing.JTextField SearchMessage;
    private javax.swing.JTextField SearchQuiz;
    private javax.swing.JTextField SearchUser;
    private javax.swing.JPanel Settings;
    private javax.swing.JScrollPane TableMessages;
    private javax.swing.JScrollPane TableQuizzes;
    private javax.swing.JScrollPane TableUsers;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title2;
    private javax.swing.JLabel Title3;
    private javax.swing.JLabel Title4;
    private javax.swing.JLabel Title5;
    private javax.swing.JLabel Title6;
    private javax.swing.JLabel Title7;
    private javax.swing.JLabel Title8;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel Username1;
    private javax.swing.JLabel Username2;
    private javax.swing.JLabel Username3;
    private javax.swing.JLabel Username4;
    private javax.swing.JLabel Username5;
    private javax.swing.JLabel Username6;
    private javax.swing.JLabel Username7;
    private javax.swing.JLabel Username8;
    private javax.swing.JPanel Users;
    private javax.swing.ButtonGroup buttonGroupAnyQTrue;
    private javax.swing.JButton buttonUpdata;
    private javax.swing.JLabel fullNameAdmin;
    private javax.swing.JLabel imgQuiz;
    private javax.swing.JLabel imgQuiz1;
    private javax.swing.JTextArea jAreaDetails;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddQuestion;
    private javax.swing.JButton jButtonAddQuiz;
    private javax.swing.JButton jButtonDoneQuiz;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonMessages;
    private javax.swing.JButton jButtonMore;
    private javax.swing.JButton jButtonQuizzes;
    private javax.swing.JButton jButtonSettings;
    private javax.swing.JButton jButtonUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAdmin;
    private javax.swing.JLabel jLabelNumQuestion;
    private javax.swing.JLabel jLabelQuizzesCompleted;
    private javax.swing.JLabel jLabelQuizzesCompleted2;
    private javax.swing.JLabel jLabelTQuizzes;
    private javax.swing.JLabel jLabelTotalQuizzes;
    private javax.swing.JLabel jLabelTotalQuizzesCompleted;
    private javax.swing.JLabel jLabelTotalUsers;
    private javax.swing.JLabel jLabelUsers1;
    private javax.swing.JLabel jLabelWelcome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBoxMessages;
    private javax.swing.JPanel jPanelDetail;
    private javax.swing.JPanel jPanelDetails;
    private javax.swing.JPanel jPanelEmail;
    private javax.swing.JPanel jPanelFacebook;
    private javax.swing.JPanel jPanelGithub;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelName;
    private javax.swing.JPanel jPanelPassword;
    private javax.swing.JPanel jPanelPhone;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JPanel jPanelTwitter;
    private javax.swing.JPanel jPanelUsername;
    private javax.swing.JPanel jPanelWebSite;
    private javax.swing.JPanel jPanelYoutube;
    private javax.swing.JPasswordField jPasswordFieldUpdeta;
    private javax.swing.JRadioButton jRadioButtonChoice1;
    private javax.swing.JRadioButton jRadioButtonChoice2;
    private javax.swing.JRadioButton jRadioButtonChoice3;
    private javax.swing.JRadioButton jRadioButtonChoice4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTMessages;
    private javax.swing.JTable jTNewUser;
    private javax.swing.JTable jTQuizzes;
    private javax.swing.JTable jTUsers;
    private javax.swing.JTextField jTextFieldChoice1;
    private javax.swing.JTextField jTextFieldChoice2;
    private javax.swing.JTextField jTextFieldChoice3;
    private javax.swing.JTextField jTextFieldChoice4;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFacebook;
    private javax.swing.JTextField jTextFieldGithub;
    private javax.swing.JTextField jTextFieldIDQuiz;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNameQuestion;
    private javax.swing.JTextField jTextFieldNameQuiz;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldTagQuiz;
    private javax.swing.JTextField jTextFieldTwitter;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JTextField jTextFieldWebSite;
    private javax.swing.JTextField jTextFieldYoutube;
    private javax.swing.JLabel searchMessages;
    private javax.swing.JLabel searchMessages1;
    // End of variables declaration//GEN-END:variables
}
