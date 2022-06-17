package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;



public class UserView extends javax.swing.JFrame {

    
    CardLayout cardLayoutPage ;
    DefaultMutableTreeNode tNQuizzes;
    public UserView() {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        initComponents();
        cardLayoutPage = (CardLayout) (jPanelRight.getLayout());
        
    }


   
    //-----------------
    public void setFullNameUser (String fullName){
        FullNameUser.setText(fullName);
    }
    public void setNumOfQuizzes (String strNumOfQuizzes){
        numOfQuizzes.setText(strNumOfQuizzes);
    }
    public void setNumOfTags (String strNumOfTags){
        numOfTags.setText(strNumOfTags);
    }
    public void facebookIconMouseClicked( MouseListener facebookIconMouseListener) { 
        facebookIcon.addMouseListener(facebookIconMouseListener);
    } 
    public void youtubeIconMouseClicked( MouseListener youtubeIconMouseListener) { 
        youtubeIcon.addMouseListener(youtubeIconMouseListener);
    }
    public void githubIconMouseClicked( MouseListener githubIconMouseListener) { 
        githubIcon.addMouseListener(githubIconMouseListener);
    }
    public void twitterIconMouseClicked( MouseListener twitterIconMouseListener) { 
        twitterIcon.addMouseListener(twitterIconMouseListener);
    }
    public void webSiteIconMouseClicked( MouseListener webSiteIconMouseListener) { 
        webIcon.addMouseListener(webSiteIconMouseListener);
    }
    public void letsGoButton (ActionListener letsGoListenerButton) {                                       
        jButtonLetsGo.addActionListener(letsGoListenerButton);
    }
    public void setProfileScore (String score){
        jLabelScore.setText(score);
    }
    public void setProfileFullName (String fullNmae){
        myProfilFullName.setText(fullNmae);
    }
    public void setProfileUsername (String username){
        myProfileUsernameDel.setText(username);
    }
    public void setProfileEmail (String email){
        myProfileEmail.setText(email);
    }
    public void setProfilePhone (String phone){
        myProfilePhone.setText(phone);
    }
    public void profileButton (ActionListener profileListenerButton) {                                       
        jButtonMyProfile.addActionListener(profileListenerButton);
    }
    public String getUsernameToSendMessage (){
       return nameMessage.getText();
    }
    public String getEmailToSendMessage (){
       return emailMessage.getText();
    }
    public String getphoneToSendMessage (){
       return PhoneMessage.getText();
    }
    public String getTextMessage (){
       return jTextAreaMessage.getText();
    }
    public void sendMessageButton (ActionListener sendMessageListenerButton) {                                       
        sendMessage.addActionListener(sendMessageListenerButton);
    }
    public void setIDSettings (String Id){
        jLabelID.setText(Id);
    }
    public void setFullNameSettings (String strfullName){
        fullName.setText(strfullName);
        jTextFieldName.setText(strfullName);
    }
    public void setUsernameSettings (String strUsername){
        username.setText("@"+strUsername);
        jTextFieldUsername.setText(strUsername);
    }
    public void setEmailSettings (String email){
        jTextFieldEmail.setText(email);
    }
    public void setPhoneSettings (String phone){
        jTextFieldPhone.setText(phone);
    }
    public void settingsButton (ActionListener settingsListenerButton) {                                       
        jButtonSettings.addActionListener(settingsListenerButton);
    }
    public String getFullNameSettings ( ){
        return jTextFieldName.getText();
    }
    public String getUsernameSettings ( ){
        return jTextFieldUsername.getText();
    }
    public String getEmailSettings ( ){
        return jTextFieldEmail.getText();
    }
    public String getPhoneSettings ( ){
        return jTextFieldPhone.getText();
    }
    public String getPasswordSettings ( ){
        return jPasswordFieldPassword.getText();
    }
    public void updataProfileButton (ActionListener updataProfileListenerButton) {                                       
        ButtonUpdata.addActionListener(updataProfileListenerButton);
    }
    public void homeButton (ActionListener homeListenerButton) {                                       
        jButtonHome.addActionListener(homeListenerButton);
    }
     public void Load (String [] aQuizzes , String [] atags)
    {
        DefaultTreeModel model;  
        tNQuizzes = new DefaultMutableTreeNode("Quizzes");
        for(int x=0; x < atags.length;x++)
        {
            
        if(x==0){
          DefaultMutableTreeNode tagNode;
          tagNode = new DefaultMutableTreeNode(aQuizzes[x]);
          tNQuizzes.add(tagNode);
            for(int i=0; i < aQuizzes.length;i=i+2) {
               if(aQuizzes[i].equals(atags[x])){
                   tagNode.add(new DefaultMutableTreeNode(aQuizzes[i+1]));
               }
          }         
        }else if(!atags[x].equals(atags[x-1]))
        {
          DefaultMutableTreeNode tagNode;
          tagNode = new DefaultMutableTreeNode(atags[x]);
          tNQuizzes.add(tagNode);
          for(int i=0; i < aQuizzes.length;i=i+2) {
               if(aQuizzes[i].equals(atags[x])){
                   tagNode.add(new DefaultMutableTreeNode(aQuizzes[i+1]));
               }
          }
        }
        }
        model = (DefaultTreeModel)jTreeQuizzes.getModel();
        model.setRoot(tNQuizzes);
        jTreeQuizzes.setModel(model);
    }
    public void quizzesButton (ActionListener quizzesListenerButton) {                                       
        jButtonQuizzes.addActionListener(quizzesListenerButton);
    }
    public String getQuiz () {                                       
        return NameQuiz.getText();
    }        
    public void startQuizButton (ActionListener startQuizListenerButton) {                                       
        jButtonStartQuiz.addActionListener(startQuizListenerButton);
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelLeft = new javax.swing.JPanel();
        LogoIcon = new javax.swing.JLabel();
        Welcome = new javax.swing.JLabel();
        FullNameUser = new javax.swing.JLabel();
        jButtonHome = new javax.swing.JButton();
        jButtonMyProfile = new javax.swing.JButton();
        jButtonQuizzes = new javax.swing.JButton();
        jButtonAddMessages = new javax.swing.JButton();
        jButtonSettings = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jPanelRight = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        HomeIcon = new javax.swing.JLabel();
        DetailsApp = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        numOfQuizzes = new javax.swing.JLabel();
        QuizzesIcon = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        numOfTags = new javax.swing.JLabel();
        TagIcon = new javax.swing.JLabel();
        jButtonLetsGo = new javax.swing.JButton();
        jPanelContactUs = new javax.swing.JPanel();
        ContactUsIcon = new javax.swing.JLabel();
        ContactUs = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        facebookIcon = new javax.swing.JLabel();
        twitterIcon = new javax.swing.JLabel();
        youtubeIcon = new javax.swing.JLabel();
        githubIcon = new javax.swing.JLabel();
        webIcon = new javax.swing.JLabel();
        jButtonSendMessage = new javax.swing.JButton();
        MyProfile = new javax.swing.JPanel();
        jPanelProfile = new javax.swing.JPanel();
        jPanelDetail1 = new javax.swing.JPanel();
        myProfileUsernameDel = new javax.swing.JLabel();
        myProfilFullName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        EmaiIcon = new javax.swing.JLabel();
        myProfileEmail = new javax.swing.JLabel();
        PhoneIcon = new javax.swing.JLabel();
        myProfilePhone = new javax.swing.JLabel();
        SettingsIcon = new javax.swing.JLabel();
        jPanelScore = new javax.swing.JPanel();
        ScoreIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelScore = new javax.swing.JLabel();
        MyFavorites = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Quizzes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTreeQuizzes = new javax.swing.JTree();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NameQuiz = new javax.swing.JTextField();
        jButtonStartQuiz = new javax.swing.JButton();
        SendMessages = new javax.swing.JPanel();
        jPanelUP = new javax.swing.JPanel();
        MessageIcon = new javax.swing.JLabel();
        jPanelDown = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        nameMessage = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        emailMessage = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        PhoneMessage = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMessage = new javax.swing.JTextArea();
        sendMessage = new javax.swing.JButton();
        Settings = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jPanelDetail = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        fullName = new javax.swing.JLabel();
        jPanelDetails = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanelName = new javax.swing.JPanel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanelUsername = new javax.swing.JPanel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelEmail = new javax.swing.JPanel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanelPhone = new javax.swing.JPanel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanelPassword = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        ButtonUpdata = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelLeft.setBackground(new java.awt.Color(0, 32, 74));
        jPanelLeft.setPreferredSize(new java.awt.Dimension(250, 552));

        LogoIcon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LogoIcon.setText("Welcome");

        Welcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Welcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Logo.png"))); // NOI18N

        FullNameUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FullNameUser.setText("Khaled Adel");

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

        jButtonMyProfile.setBackground(new java.awt.Color(0, 32, 74));
        jButtonMyProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_users_16px.png"))); // NOI18N
        jButtonMyProfile.setText("My Profile");
        jButtonMyProfile.setFocusable(false);
        jButtonMyProfile.setPreferredSize(new java.awt.Dimension(250, 20));
        jButtonMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMyProfileActionPerformed(evt);
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

        jButtonAddMessages.setBackground(new java.awt.Color(0, 32, 74));
        jButtonAddMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_group_message_16px.png"))); // NOI18N
        jButtonAddMessages.setText("Send Messages");
        jButtonAddMessages.setFocusable(false);
        jButtonAddMessages.setPreferredSize(new java.awt.Dimension(250, 30));
        jButtonAddMessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMessagesActionPerformed(evt);
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

        jButtonLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Logout_16px.png"))); // NOI18N
        jButtonLogout.setToolTipText("");
        jButtonLogout.setFocusable(false);
        jButtonLogout.setPreferredSize(new java.awt.Dimension(250, 30));
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLeftLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLeftLayout.createSequentialGroup()
                        .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLeftLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Welcome)
                                    .addComponent(FullNameUser)
                                    .addComponent(LogoIcon)))
                            .addGroup(jPanelLeftLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonQuizzes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddMessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FullNameUser)
                .addGap(18, 18, 18)
                .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonQuizzes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanelLeft);

        jPanelRight.setBackground(new java.awt.Color(204, 255, 255));
        jPanelRight.setLayout(new java.awt.CardLayout());

        HomeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Learning-App.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quizzes");

        numOfQuizzes.setBackground(new java.awt.Color(255, 255, 255));
        numOfQuizzes.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        numOfQuizzes.setForeground(new java.awt.Color(255, 255, 255));
        numOfQuizzes.setText("91,055");

        QuizzesIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_questions_64px_1.png"))); // NOI18N

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tag");

        numOfTags.setBackground(new java.awt.Color(255, 255, 255));
        numOfTags.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        numOfTags.setForeground(new java.awt.Color(255, 255, 255));
        numOfTags.setText("9,555");

        TagIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_hot_price_tag_64px_3.png"))); // NOI18N

        jButtonLetsGo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLetsGo.setText("Let's Go");
        jButtonLetsGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLetsGoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DetailsAppLayout = new javax.swing.GroupLayout(DetailsApp);
        DetailsApp.setLayout(DetailsAppLayout);
        DetailsAppLayout.setHorizontalGroup(
            DetailsAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetailsAppLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DetailsAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(DetailsAppLayout.createSequentialGroup()
                        .addComponent(QuizzesIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numOfQuizzes)))
                .addGap(18, 41, Short.MAX_VALUE)
                .addGroup(DetailsAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(DetailsAppLayout.createSequentialGroup()
                        .addComponent(TagIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numOfTags)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(DetailsAppLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButtonLetsGo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DetailsAppLayout.setVerticalGroup(
            DetailsAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetailsAppLayout.createSequentialGroup()
                .addGroup(DetailsAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetailsAppLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(DetailsAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DetailsAppLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(QuizzesIcon))
                            .addGroup(DetailsAppLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numOfQuizzes))))
                    .addGroup(DetailsAppLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGroup(DetailsAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DetailsAppLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(TagIcon))
                            .addGroup(DetailsAppLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numOfTags)))))
                .addGap(18, 18, 18)
                .addComponent(jButtonLetsGo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanelContactUs.setRequestFocusEnabled(false);

        ContactUsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/ContactUs.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contact Us ");

        facebookIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Facebook_32px_1.png"))); // NOI18N

        twitterIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_twitter_circled_32px.png"))); // NOI18N

        youtubeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_YouTube_32px.png"))); // NOI18N

        githubIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_github_32px.png"))); // NOI18N

        webIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Website_32px.png"))); // NOI18N

        jButtonSendMessage.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSendMessage.setText("Send Message");
        jButtonSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContactUsLayout = new javax.swing.GroupLayout(ContactUs);
        ContactUs.setLayout(ContactUsLayout);
        ContactUsLayout.setHorizontalGroup(
            ContactUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContactUsLayout.createSequentialGroup()
                .addGroup(ContactUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ContactUsLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel4))
                    .addGroup(ContactUsLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(facebookIcon)
                        .addGap(18, 18, 18)
                        .addComponent(twitterIcon)
                        .addGap(18, 18, 18)
                        .addComponent(youtubeIcon)
                        .addGap(18, 18, 18)
                        .addComponent(githubIcon)
                        .addGap(18, 18, 18)
                        .addComponent(webIcon))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContactUsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContactUsLayout.setVerticalGroup(
            ContactUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContactUsLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(17, 17, 17)
                .addGroup(ContactUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContactUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(githubIcon)
                        .addComponent(webIcon))
                    .addComponent(facebookIcon)
                    .addComponent(twitterIcon)
                    .addComponent(youtubeIcon))
                .addGap(18, 18, 18)
                .addComponent(jButtonSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelContactUsLayout = new javax.swing.GroupLayout(jPanelContactUs);
        jPanelContactUs.setLayout(jPanelContactUsLayout);
        jPanelContactUsLayout.setHorizontalGroup(
            jPanelContactUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactUsLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(ContactUsIcon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(ContactUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelContactUsLayout.setVerticalGroup(
            jPanelContactUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactUsLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(ContactUsIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ContactUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DetailsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HomeIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContactUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelContactUs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(HomeIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DetailsApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelRight.add(Home, "Home");

        jPanelDetail1.setLayout(new java.awt.BorderLayout(0, -5));

        myProfileUsernameDel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        myProfileUsernameDel.setText("@Username");
        jPanelDetail1.add(myProfileUsernameDel, java.awt.BorderLayout.PAGE_END);

        myProfilFullName.setBackground(new java.awt.Color(0, 0, 0));
        myProfilFullName.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        myProfilFullName.setText("Khaled Adel");
        jPanelDetail1.add(myProfilFullName, java.awt.BorderLayout.PAGE_START);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Avatar.png"))); // NOI18N

        EmaiIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_email_sign_16px.png"))); // NOI18N

        myProfileEmail.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        myProfileEmail.setText("Khaled@gmail.com");

        PhoneIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_phone_16px.png"))); // NOI18N

        myProfilePhone.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        myProfilePhone.setText("01157715742");

        SettingsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_settings_16px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanelProfileLayout = new javax.swing.GroupLayout(jPanelProfile);
        jPanelProfile.setLayout(jPanelProfileLayout);
        jPanelProfileLayout.setHorizontalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfileLayout.createSequentialGroup()
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EmaiIcon)
                            .addComponent(PhoneIcon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myProfilePhone)
                            .addComponent(myProfileEmail)))
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelDetail1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SettingsIcon))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelProfileLayout.setVerticalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfileLayout.createSequentialGroup()
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProfileLayout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jPanelDetail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13)))
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(SettingsIcon)))
                .addGap(18, 18, 18)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myProfileEmail)
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(EmaiIcon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myProfilePhone)
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(PhoneIcon)))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        ScoreIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/MyProfile.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Score");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelScore.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabelScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelScore.setText("900,089");
        jLabelScore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelScoreLayout = new javax.swing.GroupLayout(jPanelScore);
        jPanelScore.setLayout(jPanelScoreLayout);
        jPanelScoreLayout.setHorizontalGroup(
            jPanelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelScoreLayout.createSequentialGroup()
                .addComponent(jLabelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScoreIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelScoreLayout.setVerticalGroup(
            jPanelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelScoreLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(ScoreIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelScore)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MyProfileLayout = new javax.swing.GroupLayout(MyProfile);
        MyProfile.setLayout(MyProfileLayout);
        MyProfileLayout.setHorizontalGroup(
            MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jPanelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MyProfileLayout.setVerticalGroup(
            MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MyProfileLayout.createSequentialGroup()
                        .addComponent(jPanelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelRight.add(MyProfile, "MyProfile");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MyFavoritesLayout = new javax.swing.GroupLayout(MyFavorites);
        MyFavorites.setLayout(MyFavoritesLayout);
        MyFavoritesLayout.setHorizontalGroup(
            MyFavoritesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyFavoritesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1039, Short.MAX_VALUE))
        );
        MyFavoritesLayout.setVerticalGroup(
            MyFavoritesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyFavoritesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        jPanelRight.add(MyFavorites, "MyFavorites");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTreeQuizzes.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeQuizzes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreeQuizzesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTreeQuizzes);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/OnlineQuiz.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Quiz");

        NameQuiz.setEditable(false);
        NameQuiz.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NameQuiz.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonStartQuiz.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonStartQuiz.setForeground(new java.awt.Color(255, 255, 255));
        jButtonStartQuiz.setText("START");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButtonStartQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NameQuiz)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(307, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonStartQuiz)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout QuizzesLayout = new javax.swing.GroupLayout(Quizzes);
        Quizzes.setLayout(QuizzesLayout);
        QuizzesLayout.setHorizontalGroup(
            QuizzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizzesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        QuizzesLayout.setVerticalGroup(
            QuizzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuizzesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelRight.add(Quizzes, "Quizzes");

        MessageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/New message.png"))); // NOI18N

        javax.swing.GroupLayout jPanelUPLayout = new javax.swing.GroupLayout(jPanelUP);
        jPanelUP.setLayout(jPanelUPLayout);
        jPanelUPLayout.setHorizontalGroup(
            jPanelUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUPLayout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(MessageIcon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelUPLayout.setVerticalGroup(
            jPanelUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MessageIcon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("Name");

        nameMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameMessageActionPerformed(evt);
            }
        });

        jLabel14.setText("Email");

        emailMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailMessageActionPerformed(evt);
            }
        });

        jLabel15.setText("Phone");

        PhoneMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneMessageActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel17.setText("Message");

        jTextAreaMessage.setColumns(20);
        jTextAreaMessage.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMessage);

        sendMessage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sendMessage.setForeground(new java.awt.Color(255, 255, 255));
        sendMessage.setText("Send");

        javax.swing.GroupLayout jPanelDownLayout = new javax.swing.GroupLayout(jPanelDown);
        jPanelDown.setLayout(jPanelDownLayout);
        jPanelDownLayout.setHorizontalGroup(
            jPanelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDownLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDownLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(PhoneMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDownLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(nameMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDownLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(emailMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanelDownLayout.setVerticalGroup(
            jPanelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDownLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDownLayout.createSequentialGroup()
                        .addGroup(jPanelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(nameMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDownLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel14)
                                    .addComponent(emailMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(PhoneMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelDownLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(sendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SendMessagesLayout = new javax.swing.GroupLayout(SendMessages);
        SendMessages.setLayout(SendMessagesLayout);
        SendMessagesLayout.setHorizontalGroup(
            SendMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SendMessagesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SendMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelUP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SendMessagesLayout.createSequentialGroup()
                        .addComponent(jPanelDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        SendMessagesLayout.setVerticalGroup(
            SendMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SendMessagesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelRight.add(SendMessages, "SendMessages");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Avatar.png"))); // NOI18N

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID.setText("Id User");

        jPanelDetail.setLayout(new java.awt.BorderLayout(0, -5));

        username.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        username.setText("@Username");
        jPanelDetail.add(username, java.awt.BorderLayout.PAGE_END);

        fullName.setBackground(new java.awt.Color(0, 0, 0));
        fullName.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        fullName.setText("Khaled Adel");
        jPanelDetail.add(fullName, java.awt.BorderLayout.PAGE_START);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel16.setText("SETTINGS");

        jLabel8.setText("Name");

        javax.swing.GroupLayout jPanelNameLayout = new javax.swing.GroupLayout(jPanelName);
        jPanelName.setLayout(jPanelNameLayout);
        jPanelNameLayout.setHorizontalGroup(
            jPanelNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("@");

        javax.swing.GroupLayout jPanelUsernameLayout = new javax.swing.GroupLayout(jPanelUsername);
        jPanelUsername.setLayout(jPanelUsernameLayout);
        jPanelUsernameLayout.setHorizontalGroup(
            jPanelUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsernameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanelUsernameLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelUsernameLayout.setVerticalGroup(
            jPanelUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsernameLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jLabel9.setText("Email");

        javax.swing.GroupLayout jPanelEmailLayout = new javax.swing.GroupLayout(jPanelEmail);
        jPanelEmail.setLayout(jPanelEmailLayout);
        jPanelEmailLayout.setHorizontalGroup(
            jPanelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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

        jLabel10.setText("Phone Number");

        javax.swing.GroupLayout jPanelPhoneLayout = new javax.swing.GroupLayout(jPanelPhone);
        jPanelPhone.setLayout(jPanelPhoneLayout);
        jPanelPhoneLayout.setHorizontalGroup(
            jPanelPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPhoneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelPhoneLayout.setVerticalGroup(
            jPanelPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPhoneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel19.setText("Password");

        javax.swing.GroupLayout jPanelPasswordLayout = new javax.swing.GroupLayout(jPanelPassword);
        jPanelPassword.setLayout(jPanelPasswordLayout);
        jPanelPasswordLayout.setHorizontalGroup(
            jPanelPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPasswordLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelPasswordLayout.setVerticalGroup(
            jPanelPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasswordLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        ButtonUpdata.setForeground(new java.awt.Color(255, 255, 255));
        ButtonUpdata.setText("Updata");

        javax.swing.GroupLayout jPanelDetailsLayout = new javax.swing.GroupLayout(jPanelDetails);
        jPanelDetails.setLayout(jPanelDetailsLayout);
        jPanelDetailsLayout.setHorizontalGroup(
            jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(ButtonUpdata, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDetailsLayout.setVerticalGroup(
            jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addComponent(jPanelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addComponent(jPanelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(ButtonUpdata, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SettingsLayout = new javax.swing.GroupLayout(Settings);
        Settings.setLayout(SettingsLayout);
        SettingsLayout.setHorizontalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsLayout.createSequentialGroup()
                .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingsLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelID)
                            .addComponent(jPanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SettingsLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jPanelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(506, Short.MAX_VALUE))
        );
        SettingsLayout.setVerticalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(SettingsLayout.createSequentialGroup()
                        .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(jPanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRight.add(Settings, "Settings");

        jSplitPane1.setRightComponent(jPanelRight);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        cardLayoutPage.show(jPanelRight, "Home");
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMyProfileActionPerformed
        cardLayoutPage.show(jPanelRight, "MyProfile");
        
    }//GEN-LAST:event_jButtonMyProfileActionPerformed

    private void jButtonQuizzesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuizzesActionPerformed
        cardLayoutPage.show(jPanelRight, "Quizzes");
        
    }//GEN-LAST:event_jButtonQuizzesActionPerformed

    private void jButtonAddMessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMessagesActionPerformed
        cardLayoutPage.show(jPanelRight, "SendMessages");
    }//GEN-LAST:event_jButtonAddMessagesActionPerformed

    private void jButtonSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSettingsActionPerformed
        cardLayoutPage.show(jPanelRight, "Settings");     
    }//GEN-LAST:event_jButtonSettingsActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonLetsGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLetsGoActionPerformed
        cardLayoutPage.show(jPanelRight, "Quizzes");
    }//GEN-LAST:event_jButtonLetsGoActionPerformed

    private void jButtonSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendMessageActionPerformed
        cardLayoutPage.show(jPanelRight, "SendMessages");
    }//GEN-LAST:event_jButtonSendMessageActionPerformed

    private void nameMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameMessageActionPerformed

    private void emailMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailMessageActionPerformed

    private void PhoneMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneMessageActionPerformed

    private void jTreeQuizzesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreeQuizzesMouseClicked
        try{
        tNQuizzes = (DefaultMutableTreeNode)jTreeQuizzes.getSelectionPath().getLastPathComponent();
        NameQuiz.setText(tNQuizzes.getUserObject().toString());
        }catch(NullPointerException ex){
            
        }
    }//GEN-LAST:event_jTreeQuizzesMouseClicked

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
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonUpdata;
    private javax.swing.JPanel ContactUs;
    private javax.swing.JLabel ContactUsIcon;
    private javax.swing.JPanel DetailsApp;
    private javax.swing.JLabel EmaiIcon;
    private javax.swing.JLabel FullNameUser;
    private javax.swing.JPanel Home;
    private javax.swing.JLabel HomeIcon;
    private javax.swing.JLabel LogoIcon;
    private javax.swing.JLabel MessageIcon;
    private javax.swing.JPanel MyFavorites;
    private javax.swing.JPanel MyProfile;
    private javax.swing.JTextField NameQuiz;
    private javax.swing.JLabel PhoneIcon;
    private javax.swing.JTextField PhoneMessage;
    private javax.swing.JPanel Quizzes;
    private javax.swing.JLabel QuizzesIcon;
    private javax.swing.JLabel ScoreIcon;
    private javax.swing.JPanel SendMessages;
    private javax.swing.JPanel Settings;
    private javax.swing.JLabel SettingsIcon;
    private javax.swing.JLabel TagIcon;
    private javax.swing.JLabel Welcome;
    private javax.swing.JTextField emailMessage;
    private javax.swing.JLabel facebookIcon;
    private javax.swing.JLabel fullName;
    private javax.swing.JLabel githubIcon;
    private javax.swing.JButton jButtonAddMessages;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonLetsGo;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonMyProfile;
    private javax.swing.JButton jButtonQuizzes;
    private javax.swing.JButton jButtonSendMessage;
    private javax.swing.JButton jButtonSettings;
    private javax.swing.JButton jButtonStartQuiz;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelScore;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContactUs;
    private javax.swing.JPanel jPanelDetail;
    private javax.swing.JPanel jPanelDetail1;
    private javax.swing.JPanel jPanelDetails;
    private javax.swing.JPanel jPanelDown;
    private javax.swing.JPanel jPanelEmail;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelName;
    private javax.swing.JPanel jPanelPassword;
    private javax.swing.JPanel jPanelPhone;
    private javax.swing.JPanel jPanelProfile;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JPanel jPanelScore;
    private javax.swing.JPanel jPanelUP;
    private javax.swing.JPanel jPanelUsername;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextAreaMessage;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JTree jTreeQuizzes;
    private javax.swing.JLabel myProfilFullName;
    private javax.swing.JLabel myProfileEmail;
    private javax.swing.JLabel myProfilePhone;
    private javax.swing.JLabel myProfileUsernameDel;
    private javax.swing.JTextField nameMessage;
    private javax.swing.JLabel numOfQuizzes;
    private javax.swing.JLabel numOfTags;
    private javax.swing.JButton sendMessage;
    private javax.swing.JLabel twitterIcon;
    private javax.swing.JLabel username;
    private javax.swing.JLabel webIcon;
    private javax.swing.JLabel youtubeIcon;
    // End of variables declaration//GEN-END:variables
}
