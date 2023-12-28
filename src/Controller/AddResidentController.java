/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.Conn;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author pv
 */
public class AddResidentController implements Initializable{
    
    @FXML
    private AnchorPane add_resident_form;
    
    @FXML
    private Button close_btn;

    @FXML
    private TextField resident_age;

    @FXML
    private Button resident_confirm_btn;

    @FXML
    private ComboBox<?> resident_gender;

    @FXML
    private TextField resident_id;

    @FXML
    private TextField resident_name;

    @FXML
    private TextField resident_phone;

    @FXML
    private ComboBox<?> resident_status;
    
    private AlertMessage alert = new AlertMessage();
    
    // close function
    
    public void close(){
        Stage stage;
        stage = (Stage)add_resident_form.getScene().getWindow();
        stage.close();
    }
    
    // gender
    private String[] genders = {"Male", "Female"};
    
    public void comboGender(){
        List<String> listGender = new ArrayList<>();
        for(String gender : genders){
            listGender.add(gender);
        }
        ObservableList listData = FXCollections.observableArrayList(listGender);
        resident_gender.setItems(listData);
    }
    
    // status
    private String[] statuses = {"Stay", "Absent"};
    
    public void comboStatus(){
        List<String> listStatus = new ArrayList<>();
        for(String status : statuses){
            listStatus.add(status);
        }
        ObservableList listData = FXCollections.observableArrayList(listStatus);
        resident_status.setItems(listData);
    }
    
    
    public void addResident(){
        Conn c = new Conn();
        
        String id = resident_id.getText();
        String name = resident_name.getText();
        String age = resident_age.getText();
        String gender = (String)resident_gender.getSelectionModel().getSelectedItem();
        String phone = resident_phone.getText();
        String status = (String)resident_status.getSelectionModel().getSelectedItem();
        
        String addResident = "insert into resident values('"+id+"', "
                + "'"+name+"', "
                + "'"+age+"', "
                + "'"+gender+"', "
                + "'"+phone+"', "
                + "'"+status+"')";
        try{
            if(resident_id.getText().isEmpty()||
                    resident_name.getText().isEmpty()||
                    resident_age.getText().isEmpty()||
                    resident_gender.getSelectionModel().isEmpty()||
                    resident_phone.getText().isEmpty()||
                    resident_status.getSelectionModel().isEmpty()){
                alert.errorMessage("Please fill out all the blank spaces");
                
                // Empty all the text
                resident_id.setText("");
                resident_name.setText("");
                resident_age.setText("");
                resident_gender.getSelectionModel().clearSelection();
                resident_phone.setText("");
                resident_status.getSelectionModel().clearSelection();
                
            }
            else {
                c.s.executeUpdate(addResident);
                alert.successMessage("Successfully Add Resident");
                Stage stage;
                stage = (Stage)add_resident_form.getScene().getWindow();
                stage.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboGender();
        comboStatus();
    }
}
