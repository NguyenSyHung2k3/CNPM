/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

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
    
    // Main menu form 
    
    @FXML
    private AnchorPane main_menu_form;
    
    // Resident form
    
    @FXML
    private AnchorPane resident_form;
    
    // House hold form
    
    @FXML
    private AnchorPane house_hold_form;

    // Fee form
    
    @FXML
    private AnchorPane fee_form;
    
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
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        runTime();
    }
    
}
