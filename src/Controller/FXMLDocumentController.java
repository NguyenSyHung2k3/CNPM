/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controller;

import Connection.Conn;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author pv
 */
public class FXMLDocumentController implements Initializable {
    
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
    
    private AlertMessage alert = new AlertMessage();
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
