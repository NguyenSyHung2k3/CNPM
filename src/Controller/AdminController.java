/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.Conn;
import Model.Household;
import Model.Resident;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    //change form------------------------------------
    
    @FXML
    private AnchorPane resident_change_info_form;
    
    @FXML
    private Button close_change_resident_form_btn;
    
    @FXML
    private TextField resident_age_change;
    
    @FXML
    private ComboBox<?> resident_gender_change;
    
    @FXML
    private TextField resident_id_change;
    
    @FXML
    private TextField resident_name_change;
    
    @FXML
    private TextField resident_phone_change;
    
    @FXML
    private ComboBox<?> resident_status_change;
    
    @FXML
    private Button resident_update_btn;
    
    //--------------------------------------------------

    @FXML
    private Button resident_delete_btn;
    
    @FXML
    private Button resident_refresh_btn;
    
    @FXML
    private TableView<Resident> resident_table;
    
    @FXML
    private TableColumn<Resident, String> resident_ID_col;
    
    @FXML
    private TableColumn<Resident, String> resident_name_col;
    
    @FXML
    private TableColumn<Resident, Integer> resident_age_col;
    
    @FXML
    private TableColumn<Resident, String> resident_gender_col;
    
    @FXML
    private TableColumn<Resident, String> resident_phone_col;
    
    @FXML
    private TableColumn<Resident, String> resident_status_col;
    
    @FXML
    private Label resident_age;
    
    @FXML
    private Label resident_gender;
    
    @FXML
    private Label resident_id;

    @FXML
    private Label resident_name;
    
    @FXML
    private Label resident_phone;
    
    @FXML
    private Label resident_status;
    
    
    
    
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
    
    //Alert
    
    private AlertMessage alert = new AlertMessage();
    
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
    
    
    // Resident Function
    
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
    
    public ObservableList<Resident> residentData(){
        ObservableList<Resident> listData = FXCollections.observableArrayList();
        String query = "select * from resident";
        Conn c = new Conn();
        Resident resident;
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                resident = new Resident(rs.getString("ID"), rs.getString("name"),
                rs.getInt("age"), rs.getString("phone_number"), rs.getString("gender"), rs.getString("status"));
                listData.add(resident);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    
    public void showResidentData(){
        ObservableList<Resident> listData = residentData();
        resident_ID_col.setCellValueFactory(new PropertyValueFactory<>("ID"));
        resident_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        resident_age_col.setCellValueFactory(new PropertyValueFactory<>("age"));
        resident_gender_col.setCellValueFactory(new PropertyValueFactory<>("gender"));
        resident_phone_col.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        resident_status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
        resident_table.setItems(listData);
    }
    
    public void selectResident(){
        Resident resident = resident_table.getSelectionModel().getSelectedItem();
        int num = resident_table.getSelectionModel().getSelectedIndex();
        
        if((num-1) < -1)
            return;
        resident_id.setText(String.valueOf(resident.getID()));
        resident_name.setText(resident.getName());
        resident_age.setText(String.valueOf(resident.getAge()));
        resident_gender.setText(resident.getGender());
        resident_phone.setText(resident.getPhone_number());
        resident_status.setText(resident.getStatus());
        
        resident_id_change.setText(String.valueOf(resident.getID()));
        resident_name_change.setText(resident.getName());
        resident_age_change.setText(String.valueOf(resident.getAge()));
        resident_gender_change.getSelectionModel().getSelectedItem();
        resident_phone_change.setText(resident.getPhone_number());
        resident_status_change.getSelectionModel().getSelectedItem();
        
        showResidentData();
    }
    
    public void changeResident(){
        resident_change_info_form.setVisible(true);
        
    }
    
    public void closeChangeResidentForm(){
        resident_change_info_form.setVisible(false);
    }
    
    public void deleteResident(){
        String query = "delete from resident where ID = '"+resident_id.getText()+"'";
        Conn c = new Conn();
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure that you want to delete it?");
            
            Optional<ButtonType> buttonType = alert.showAndWait();
            
            if(buttonType.get() == ButtonType.OK){
                c.s.executeUpdate(query);
            } else {
                return;
            }
            showResidentData();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updateResident(){
        Conn c = new Conn();
        String query = "update resident set "
                + "name = '"+resident_name_change.getText()+"', "
                + "age = '"+resident_age_change.getText()+"', "
                + "gender = '"+resident_gender_change.getSelectionModel().getSelectedItem()+"', "
                + "phone = '"+resident_phone_change.getText()+"', "
                + "status = '"+resident_status_change.getSelectionModel().getSelectedItem()+"', "
                + "updateTime = current_date() where id = '"+resident_id_change.getText()+"'";
        try{
            c.s.executeUpdate(query);
            alert.successMessage("Successfully Update");
            showResidentData();
            resident_change_info_form.setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // House Hold Function
    
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
    
    public ObservableList<Household> houseHoldData(){
        ObservableList<Household> listData = FXCollections.observableArrayList();
        String query = "select * from household";
        Conn c = new Conn();
        Household household;
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                household = new Household(rs.getString("household_id"), rs.getString("household_address"),
                rs.getInt("num_of_members"));
                listData.add(household);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    
    public void showHouseHoldData(){
        ObservableList<Resident> listData = residentData();
        resident_ID_col.setCellValueFactory(new PropertyValueFactory<>("ID"));
        resident_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        resident_age_col.setCellValueFactory(new PropertyValueFactory<>("age"));
        resident_gender_col.setCellValueFactory(new PropertyValueFactory<>("gender"));
        resident_phone_col.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        resident_status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
        resident_table.setItems(listData);
    }
    
    public void selectHouseHold(){
        Resident resident = resident_table.getSelectionModel().getSelectedItem();
        int num = resident_table.getSelectionModel().getSelectedIndex();
        
        if((num-1) < -1)
            return;
        resident_id.setText(String.valueOf(resident.getID()));
        resident_name.setText(resident.getName());
        resident_age.setText(String.valueOf(resident.getAge()));
        resident_gender.setText(resident.getGender());
        resident_phone.setText(resident.getPhone_number());
        resident_status.setText(resident.getStatus());
        
        resident_id_change.setText(String.valueOf(resident.getID()));
        resident_name_change.setText(resident.getName());
        resident_age_change.setText(String.valueOf(resident.getAge()));
        resident_gender_change.getSelectionModel().getSelectedItem();
        resident_phone_change.setText(resident.getPhone_number());
        resident_status_change.getSelectionModel().getSelectedItem();
        
        showResidentData();
    }
    
    public void changeHouseHold(){
        resident_change_info_form.setVisible(true);
        
    }
    
    public void closeChangeHouseHoldForm(){
        resident_change_info_form.setVisible(false);
    }
    
    public void deleteHouseHold(){
        String query = "delete from resident where ID = '"+resident_id.getText()+"'";
        Conn c = new Conn();
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure that you want to delete it?");
            
            Optional<ButtonType> buttonType = alert.showAndWait();
            
            if(buttonType.get() == ButtonType.OK){
                c.s.executeUpdate(query);
            } else {
                return;
            }
            showResidentData();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updateHouseHold(){
        Conn c = new Conn();
        String query = "update resident set "
                + "name = '"+resident_name_change.getText()+"', "
                + "age = '"+resident_age_change.getText()+"', "
                + "gender = '"+resident_gender_change.getSelectionModel().getSelectedItem()+"', "
                + "phone = '"+resident_phone_change.getText()+"', "
                + "status = '"+resident_status_change.getSelectionModel().getSelectedItem()+"', "
                + "updateTime = current_date() where id = '"+resident_id_change.getText()+"'";
        try{
            c.s.executeUpdate(query);
            alert.successMessage("Successfully Update");
            showResidentData();
            resident_change_info_form.setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void searchHouseHold(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Fee Function
    
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
        
        showResidentData();
        
    }
    
}
