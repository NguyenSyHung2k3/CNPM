/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author pv
 */
public class AdminController implements Initializable{
    
    // Header
    
    @FXML
    private Label current_form;

    @FXML
    private Label date_form;
    
    @FXML
    private Circle top_profile;
    
    // dashboard buttons
    
    @FXML
    private Button main_menu_btn;
    
    @FXML
    private Button resident_btn;
    
    @FXML
    private Button house_hold_btn;
    
    @FXML
    private Button fee_btn;

    @FXML
    private Button statistical_btn;
    
    @FXML
    private Button signout_btn;
    
    // Main menu form 
    
    @FXML
    private AnchorPane main_menu_form;
    
    // Resident form
    
    @FXML
    private AnchorPane resident_form;
    
    @FXML
    private Button resident_add_btn;
    
    @FXML
    private Button resident_change_btn;

    @FXML
    private Button resident_delete_btn;
    
    // House hold form
    
    @FXML
    private AnchorPane house_hold_form;
    
    @FXML
    private Button house_hold_add_btn;
    
    @FXML
    private Button house_hold_change_btn;

    @FXML
    private Button house_hold_delete_btn;

    // Fee form
    
    @FXML
    private AnchorPane fee_form;
    
    // Mandatory Fee Form
    
    @FXML
    private AnchorPane mandatory_fee_form;
    
    @FXML
    private Button mandatory_fee_btn;
    
    @FXML
    private Button add_mandatory_fee_btn;
    
    // Voluntary Fee Form
    
    @FXML
    private AnchorPane voluntary_fee_form;
    
    @FXML
    private Button add_voluntary_fee_btn;
    
    @FXML
    private Button voluntary_fee_btn;
    
    // Total Fee Form
    
    @FXML
    private AnchorPane total_fee_form;

    
    
    
    
    @FXML
    private Button total_fee_btn;
    
    
    
    
    
    // Statistical form

    @FXML
    private AnchorPane statistical_form;
    
    
    // Switch form 
    
    public void switchForm(ActionEvent e){
        if(e.getSource() == main_menu_btn){
            main_menu_form.setVisible(true);
            resident_form.setVisible(false);
            house_hold_form.setVisible(false);
            fee_form.setVisible(false);
            statistical_form.setVisible(false);
        }
        if(e.getSource() == resident_btn){
            main_menu_form.setVisible(false);
            resident_form.setVisible(true);
            house_hold_form.setVisible(false);
            fee_form.setVisible(false);
            statistical_form.setVisible(false);
        }
        if(e.getSource() == house_hold_btn){
            main_menu_form.setVisible(false);
            resident_form.setVisible(false);
            house_hold_form.setVisible(true);
            fee_form.setVisible(false);
            statistical_form.setVisible(false);
        }
        if(e.getSource() == fee_btn){
            main_menu_form.setVisible(false);
            resident_form.setVisible(false);
            house_hold_form.setVisible(false);
            fee_form.setVisible(true);
            statistical_form.setVisible(false);
        }
        if(e.getSource() == statistical_btn){
            main_menu_form.setVisible(false);
            resident_form.setVisible(false);
            house_hold_form.setVisible(false);
            fee_form.setVisible(false);
            statistical_form.setVisible(true);
        }
    }
    
    // date_time
    
    public void runTime() {
        new Thread() {
            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> {
                        if (date_form != null) {
                            date_form.setText(format.format(new Date()));
                        } else {
                            // Handle the case where date_form is null
                            System.err.println("date_form is null");
                        }
                    });
                }
            }
        }.start();
    }
    
    // Sign out Button
    
    public void signout(){
        signout_btn.getScene().getWindow().hide();
        
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            root.setOnMousePressed((MouseEvent event) ->{
                
                x = event.getSceneX();
                y = event.getSceneY();
                                
            });
            
            root.setOnMouseDragged((MouseEvent event) ->{
                
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
                stage.setOpacity(0.8);
                
            });
            
            root.setOnMouseReleased((MouseEvent event) ->{
                
                stage.setOpacity(1);
                
            });
            
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    // Resident Form
    
    private double x=0;
    private double y=0;
    
    public void addResident() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/AddResident.fxml"));

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
    }
    
    // House Hold Form
    
    public void addHouseHold() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/AddHouseHold.fxml"));

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
    }
    
    // Fee Form
    
    // Switch Fee Form (Mandatory Fee, Voluntary Fee, Total Fee)
    
    public void switchFeeForm(ActionEvent e){
        if(e.getSource() == mandatory_fee_btn){
            mandatory_fee_form.setVisible(true);
            voluntary_fee_form.setVisible(false);
            total_fee_form.setVisible(false);
        }
        if(e.getSource() == voluntary_fee_btn){
            mandatory_fee_form.setVisible(false);
            voluntary_fee_form.setVisible(true);
            total_fee_form.setVisible(false);
        }
        if(e.getSource() == total_fee_btn){
            mandatory_fee_form.setVisible(false);
            voluntary_fee_form.setVisible(false);
            total_fee_form.setVisible(true);
        }
    }
    
    // Mandatory Form
    
    public void addMandatoryFee() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/AddMandatoryFee.fxml"));

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
    }
    
    // Voluntary Form
    
    public void addVoluntaryFee() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/AddVoluntaryFee.fxml"));

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
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        runTime();
    }
    
}
