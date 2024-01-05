/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controller;

import Connection.Conn;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author pv
 */
public class FXMLDocumentController implements Initializable {
    
    // Log in 
    
    @FXML
    private AnchorPane log_in_form;
    
    @FXML
    private PasswordField login_password;

    @FXML
    private TextField login_username;
    
    @FXML
    private Button login_btn;
    
    @FXML
    private CheckBox login_showPassword_checkBox;
    
    @FXML
    private TextField login_showPassword;
    
    @FXML
    private Hyperlink createYourAccount;
    
    @FXML
    private Hyperlink forgotYourPassword;
    
    // Sign up
    
    @FXML
    private AnchorPane sign_up_form;
    
    @FXML
    private Hyperlink alreadyHaveAccount;
    
    @FXML
    private TextField signup_gmail;
    
    @FXML
    private PasswordField signup_password;
    
    @FXML
    private TextField signup_showPassword;

    @FXML
    private CheckBox signup_showPassword_checkBox;

    @FXML
    private TextField signup_username;
    
    @FXML
    private Button create_btn;
    
    // Forgot Password
    
    @FXML
    private AnchorPane forgot_password_form;
    
    @FXML
    private Hyperlink backToLogin;
    
    @FXML
    private Button forgot_btn;

    @FXML
    private TextField forgot_gmail;

    @FXML
    private PasswordField forgot_password;
    
    @FXML
    private TextField forgot_showPassword;

    @FXML
    private CheckBox forgot_showPassword_checkBox;
    
    @FXML
    private TextField forgot_username;
    

    
    private AlertMessage alert = new AlertMessage();
    
    //checking email
    public static boolean validEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    private double x=0;
    private double y=0;
    
    public void login(){
        Conn c = new Conn();
        String username = login_username.getText();
        String password = login_password.getText();
        String query = "select * from account where username = '"+username+"'and _password = '"+password+"'";
        
        try{
            
            ResultSet rs = c.s.executeQuery(query);
            if(login_username.getText().isEmpty() || login_password.getText().isEmpty()){
                alert.errorMessage("Please fill out the username/password");
            } else{
                if(rs.next()){
                    
                    alert.successMessage("Successfully Login");

                    login_btn.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/Admin.fxml"));

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    root.setOnMousePressed((MouseEvent e)->{
                        x = e.getSceneX();
                        y = e.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent e)->{
                        stage.setX(e.getScreenX() - x);
                        stage.setY(e.getScreenY() - y);
                    });
                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();
                    

                } else {
                    alert.errorMessage("Wrong username/password");
                    login_username.setText("");
                    login_password.setText("");
                }
            }
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void loginShowPassword(){
        if(login_showPassword_checkBox.isSelected()){
            login_showPassword.setText(login_password.getText());
            login_password.setVisible(false);
            login_showPassword.setVisible(true);
        } else {
            login_password.setText(login_showPassword.getText());
            login_password.setVisible(true);
            login_showPassword.setVisible(false);
        }
    }
    
    public void switchForm(ActionEvent e){
        if(e.getSource() == createYourAccount){
            log_in_form.setVisible(false);
            sign_up_form.setVisible(true);
            forgot_password_form.setVisible(false);
        }
        if(e.getSource() == alreadyHaveAccount){
            log_in_form.setVisible(true);
            sign_up_form.setVisible(false);
            forgot_password_form.setVisible(false);
        }
        if(e.getSource() == forgotYourPassword){
            log_in_form.setVisible(false);
            sign_up_form.setVisible(false);
            forgot_password_form.setVisible(true);
        }
        if(e.getSource() == backToLogin){
            log_in_form.setVisible(true);
            sign_up_form.setVisible(false);
            forgot_password_form.setVisible(false);
        }
    }
    
    public void createAccount(){
        Conn c = new Conn();
        String username = signup_username.getText();
        String password = signup_password.getText();
        String gmail = signup_gmail.getText();
        String query = "insert into account values('"+username+"', '"+password+"', '"+gmail+"')";
        
        try{
            if(username.isEmpty() || password.isEmpty() || gmail.isEmpty()){
                alert.errorMessage("Please fill all the blank fields");
                signup_gmail.setText("");
                signup_username.setText("");
                signup_password.setText("");   
                signup_showPassword.setText("");
            } else if(password.length() < 9){
                alert.errorMessage("Password must contains 9 letters");
                signup_gmail.setText("");
                signup_username.setText("");
                signup_password.setText(""); 
                signup_showPassword.setText("");
            } else {
                String check = "select * from account where username = '"+username+"'";
                ResultSet rs = c.s.executeQuery(check);
                if(rs.next()){
                    alert.errorMessage("Already have this username");
                    signup_gmail.setText("");
                    signup_username.setText("");
                    signup_password.setText("");  
                    signup_showPassword.setText("");
                } else if(!validEmail(gmail)){
                    alert.errorMessage("Invalid Gmail");
                } else {
                    c.s.executeUpdate(query);
                    alert.confirmationMessage("Successfully create a new account!");
                    signup_gmail.setText("");
                    signup_username.setText("");
                    signup_password.setText("");   
                    signup_showPassword.setText("");
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void signupShowPassword(){
        if(signup_showPassword_checkBox.isSelected()){
            signup_showPassword.setText(signup_password.getText());
            signup_password.setVisible(false);
            signup_showPassword.setVisible(true);
        } else {
            signup_password.setText(signup_showPassword.getText());
            signup_password.setVisible(true);
            signup_showPassword.setVisible(false);
        }
    }
    
    // Forgot form
    
    public void forgotShowPassword(){
        if(forgot_showPassword_checkBox.isSelected()){
            forgot_showPassword.setText(forgot_password.getText());
            forgot_password.setVisible(false);
            forgot_showPassword.setVisible(true);
        } else {
            forgot_password.setText(forgot_showPassword.getText());
            forgot_password.setVisible(true);
            forgot_showPassword.setVisible(false);
        }
    }
    
    public void proceed(){
        Conn c = new Conn();
        String username = forgot_username.getText();
        String password = forgot_password.getText();
        String gmail = forgot_gmail.getText();
        String query = "update account set _password = '"+password+"' where username = '"+username+"' and email = '"+gmail+"'";
        
        try{
            if(username.isEmpty() || password.isEmpty() || gmail.isEmpty()){
                alert.errorMessage("Please fill all the blank fields");
                forgot_gmail.setText("");
                forgot_username.setText("");
                forgot_password.setText("");  
                forgot_showPassword.setText("");
            } else if(password.length() < 9){
                alert.errorMessage("Password must contains 9 letters");
                forgot_gmail.setText("");
                forgot_username.setText("");
                forgot_password.setText("");
                forgot_showPassword.setText("");
            } else {
                String check = "select * from account where username = '"+username+"' and email = '"+gmail+"'";
                ResultSet rs = c.s.executeQuery(check);
                if(rs.next()){
                    c.s.executeUpdate(query);
                    alert.confirmationMessage("Successfully change your password!");
                    forgot_gmail.setText("");
                    forgot_username.setText("");
                    forgot_password.setText(""); 
                    forgot_showPassword.setText("");
                } else {
                    alert.errorMessage("This username/gmail didn't exist!");
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
