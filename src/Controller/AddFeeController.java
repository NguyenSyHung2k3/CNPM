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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;

/**
 *
 * @author pv
 */
public class AddFeeController implements Initializable{
    
    @FXML
    private AnchorPane add_fee_form;

    @FXML
    private TextField fee_amount;

    @FXML
    private TextField fee_id;

    @FXML
    private TextField fee_name;

    @FXML
    private ComboBox<?> fee_type;
    
    private AlertMessage alert = new AlertMessage();
    
    public void close(){
        Stage stage;
        stage = (Stage)add_fee_form.getScene().getWindow();
        stage.close();
    }
    
    // fee type
    private String[] types = {"Mandatory", "Voluntary", "Vehicle", "Service Bill"};
    
    public void comboFee(){
        List<String> listFee = new ArrayList<>();
        for(String type : types){
            listFee.add(type);
        }
        ObservableList listData = FXCollections.observableArrayList(listFee);
        fee_type.setItems(listData);
    }
    
    
    
    public void addFee(){
        Conn c = new Conn();
        Conn c1 = new Conn();
        Conn c2 = new Conn();
        
        String id = fee_id.getText();
        String name = fee_name.getText();
        Double amount = Double.parseDouble(fee_amount.getText());
        String type = (String)fee_type.getSelectionModel().getSelectedItem();
        
        String addFee = "insert into fee values('"+id+"', "
                + "'"+name+"', "
                + "'"+amount+"', "
                + "'"+type+"', "
                + "current_date());";
        
        String query = "select household_id, area from household where num_of_members >= 1;";
        
        if(fee_id.getText().isEmpty()||
                    fee_name.getText().isEmpty()||
                    fee_amount.getText().isEmpty()){
                alert.errorMessage("Please fill out all the blank spaces");
                
                // Empty all the text
                fee_id.setText("");
                fee_amount.setText("");
                fee_name.setText("");
            } else if(type == "Mandatory"){
                
                try{
                    c1.s.executeUpdate(addFee);
                    alert.successMessage("Successfully Add Fee");
                    Stage stage;
                    stage = (Stage)add_fee_form.getScene().getWindow();
                    stage.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                
                Integer household_id;
                
                try{
                    try(ResultSet rs = c.s.executeQuery(query)){
                    
                        while(rs.next()){

                            household_id = rs.getInt("household_id");
                            Double area = rs.getDouble("area");
                            
                            try{
                                String query1 = "insert into fee_payment values('"+fee_id.getText()+"', "
                                        + "'"+household_id+"', "
                                        + "current_date(), "
                                        + "'"+"not done"+"', "
                                        + "'"+area*amount+"', "
                                        + "'"+fee_name.getText()+"');";
                                c1.s.executeUpdate(query1);
                            }catch(Exception e){

                            }
                        } 
                        
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                
            } else if(type == "Voluntary"){
                
                try{
                    c1.s.executeUpdate(addFee);
                    alert.successMessage("Successfully Add Fee");
                    Stage stage;
                    stage = (Stage)add_fee_form.getScene().getWindow();
                    stage.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                
                try{
                    try(ResultSet rs = c.s.executeQuery(query)){
                        
                        while(rs.next()){

                            Integer household_id = rs.getInt("household_id");
                            
                            try{
                                String query1 = "insert into fee_payment values('"+fee_id.getText()+"', "
                                        + "'"+household_id+"', "
                                        + "current_date(), "
                                        + "'"+"not done"+"', "
                                        + "'"+amount+"', "
                                        + "'"+fee_name.getText()+"')";
                                c1.s.executeUpdate(query1);
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                           
                        } 
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                
            } else if(type == "Vehicle"){
                
                try{
                    c1.s.executeUpdate(addFee);
                    alert.successMessage("Successfully Add Fee");
                    Stage stage;
                    stage = (Stage)add_fee_form.getScene().getWindow();
                    stage.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                
                
                try{
                    try(ResultSet rs = c.s.executeQuery(query)){
                        
                        while(rs.next()){

                            Integer household_id = rs.getInt("household_id");
                            
                            String car = "select * from car where household_id = '"+household_id+"'";
                            
                            try{
                                ResultSet rs1 = c2.s.executeQuery(car);
                                Double sum = 0.0;
                                while(rs1.next()){
                                    String veh_type = rs1.getString("car_type");
                                    if(veh_type.equals("Car")){
                                        sum += 1200000.0;
                                    } else if (veh_type.equals("Motor")){
                                        sum += 70000.0;
                                    } else if (veh_type.equals("Bike")){
                                        sum += 12000.0;
                                    }
                                }
                                
                                try{
                                    String query1 = "insert into fee_payment values('"+fee_id.getText()+"', "
                                        + "'"+household_id+"', "
                                        + "current_date(), "
                                        + "'"+"not done"+"', "
                                        + "'"+sum+"', "
                                        + "'"+fee_name.getText()+"')";
                                    c1.s.executeUpdate(query1);
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                                
                            }catch(Exception e){
                                
                            }

                        } 
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                
            }
         else if(type == "Service Bill"){
                
                try{
                    c1.s.executeUpdate(addFee);
                    alert.successMessage("Successfully Add Fee");
                    Stage stage;
                    stage = (Stage)add_fee_form.getScene().getWindow();
                    stage.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                
                
            }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboFee();
    }
    
}
