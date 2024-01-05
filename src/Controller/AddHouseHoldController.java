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
public class AddHouseHoldController implements Initializable{
    
    @FXML
    private AnchorPane add_house_hold_form;

    @FXML
    private Button close_btn;

    @FXML
    private TextField house_hold_address;

    @FXML
    private Button house_hold_confirm_btn;

    @FXML
    private TextField house_hold_id;

    @FXML
    private TextField house_hold_owner_name;

    @FXML
    private TextField house_hold_phone;
    
    @FXML
    private TextField household_owner_age;

    @FXML
    private ComboBox<?> household_owner_gender;

    @FXML
    private TextField household_owner_id;

    @FXML
    private ComboBox<?> household_owner_status;
    
    @FXML
    private TextField house_hold_area;

    
    private AlertMessage alert = new AlertMessage();
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Remove non-digit characters from the phone number
        String digitsOnly = phoneNumber.replaceAll("\\D", "");

        // Check if the resulting string has exactly 10 digits
        return digitsOnly.length() == 10;
    }
    
    public void close(){
        Stage stage;
        stage = (Stage)add_house_hold_form.getScene().getWindow();
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
        household_owner_gender.setItems(listData);
    }
    
    // status
    private String[] statuses = {"Stay", "Absent"};
    
    public void comboStatus(){
        List<String> listStatus = new ArrayList<>();
        for(String status : statuses){
            listStatus.add(status);
        }
        ObservableList listData = FXCollections.observableArrayList(listStatus);
        household_owner_status.setItems(listData);
    }
    
    public void addHouseHold(){
        Conn c = new Conn();
        
        String id = house_hold_id.getText();
        String address = house_hold_address.getText();
        String name = house_hold_owner_name.getText();
        String phone = house_hold_phone.getText();
        String area = String.valueOf(house_hold_area.getText());
        
        String addHousehold = "insert into household values('"+id+"', "
                + "'"+address+"', "
                + "0, "
                + "'"+name+"', "
                + "'"+phone+"', "
                + "'"+area+"');";
        
        String addResident = "insert into resident values('"+household_owner_id.getText()+"', "
                + "'"+name+"', "
                + "'"+household_owner_age.getText()+"', "
                + "'"+phone+"', "
                + "'"+household_owner_gender.getSelectionModel().getSelectedItem()+"', "
                + "'"+household_owner_status.getSelectionModel().getSelectedItem()+"')";
        
        String addRole = "insert into role_in_household values('"+id+"', '"+household_owner_id.getText()+"', '"+"Owner"+"')";
        String updateMember = "update household set num_of_members = (select count(*) from role_in_household where role_in_household.household_id = '"+id+"') "
                + "where household.household_id = '"+id+"'";
        try{
            if(house_hold_id.getText().isEmpty()||
                    house_hold_address.getText().isEmpty()||
                    house_hold_owner_name.getText().isEmpty()||
                    house_hold_phone.getText().isEmpty() ||
                    house_hold_area.getText().isEmpty() ||
                    household_owner_age.getText().isEmpty() ||
                    household_owner_id.getText().isEmpty()){
                alert.errorMessage("Please fill out all the blank spaces");
                
                // Empty all the text
                house_hold_id.setText("");
                house_hold_address.setText("");
                house_hold_owner_name.setText("");
                house_hold_phone.setText("");
                house_hold_area.setText("");
                household_owner_age.setText("");
                household_owner_id.setText("");
            }
            
            else if(!isValidPhoneNumber(house_hold_phone.getText())){
                alert.errorMessage("Wrong phone number");
                house_hold_id.setText("");
                house_hold_address.setText("");
                house_hold_owner_name.setText("");
                house_hold_phone.setText("");
                house_hold_area.setText("");
                household_owner_age.setText("");
                household_owner_id.setText("");
            }
            
            else {
                
                c.s.executeUpdate(addHousehold);
                
                c.s.executeUpdate(addResident);
                
                c.s.executeUpdate(addRole);
                
                c.s.executeUpdate(updateMember);
                
                alert.successMessage("Successfully Add HouseHold");
                Stage stage;
                stage = (Stage)add_house_hold_form.getScene().getWindow();
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
