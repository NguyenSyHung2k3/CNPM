/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.Conn;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author pv
 */
public class AddHouseHoldController implements Initializable{
    @FXML
    private Button house_hold_confirm_btn;

    @FXML
    private TextField house_hold_id;

    @FXML
    private TextField house_hold_room_id;
    
    @FXML
    private AnchorPane add_house_hold_form;
    
    private AlertMessage alert = new AlertMessage();
    
    @FXML
    private Button close_btn;
    
    public void close(){
        Stage stage;
        stage = (Stage)add_house_hold_form.getScene().getWindow();
        stage.close();
    }
    
    public void addHouseHold(){
        Conn c = new Conn();
        
        String id = house_hold_id.getText();
        String roomId = house_hold_room_id.getText();

        
        String addResident = "insert into household values('"+id+"', "
                + "'"+roomId+"', "
                + "0)";
        try{
            if(house_hold_id.getText().isEmpty()||
                    house_hold_room_id.getText().isEmpty()){
                alert.errorMessage("Please fill out all the blank spaces");
                
                // Empty all the text
                house_hold_id.setText("");
                house_hold_room_id.setText("");
                
            }
            else {
                c.s.executeUpdate(addResident);
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
        
    }
}
