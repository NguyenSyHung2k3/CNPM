/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.Conn;
import Model.Car;
import Model.Fee;
import Model.FeePayment;
import Model.Household;
import Model.Resident;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
    
    @FXML
    private Label total_absent_resident;

    @FXML
    private Label total_citizen;
    
    @FXML
    private Label total_household;
    
    @FXML
    private Label total_staying_resident;
    
    @FXML
    private Label total_vehicle;
    
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
    private TextField resident_household_id_change;
    
    @FXML
    private TextField resident_role_change;
    
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
    private TextField resident_search_bar;
    
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
    
    @FXML
    private Label owner_relation;
    
    @FXML
    private Label resident_household_id;
    
    @FXML
    private ComboBox<?> resident_search_combo;
    
    
    // House hold form
    
    @FXML
    private AnchorPane house_hold_form;
    
    @FXML
    private Button house_hold_add_btn;
    
    @FXML
    private Button house_hold_change_btn;

    @FXML
    private Button house_hold_delete_btn;
    
    @FXML
    private TableView<Household> household_table;
    
    @FXML
    private TableColumn<Household, String> household_address_col;

    @FXML
    private TableColumn<Household, String> household_id_col;

    @FXML
    private TableColumn<Household, Integer> household_num_col;

    @FXML
    private TableColumn<Household, String> household_owner_name_col;

    @FXML
    private TableColumn<Household, String> household_phone_col;
    
    @FXML
    private Label household_address;
    
    @FXML
    private Label household_id;
    
    @FXML
    private Label household_num;
    
    @FXML
    private Label household_owner_name;
    
    @FXML
    private Label household_area;
    
    @FXML
    private Label household_phone;
    
    @FXML
    private AnchorPane household_change_info_form;
    
    @FXML
    private TextField household_id_change;
    
    @FXML
    private TextField household_owner_name_change;
    
    @FXML
    private TextField household_phone_change;
    
    @FXML
    private TextField household_address_change;
    
    @FXML
    private TextField household_area_change;
    
    @FXML
    private TableColumn<Household, Double> household_area_col;
    
    @FXML
    private TextField household_search_bar;
    
    @FXML
    private ComboBox<?> household_search_combo;
    
    // Fee form
    
    @FXML
    private AnchorPane fee_form;
    
    @FXML
    private TableColumn<Fee, Double> fee_amount_col;
    
    @FXML
    private TableColumn<Fee, String> fee_id_col;

    @FXML
    private TableColumn<Fee, String> fee_name_col;
    
    @FXML
    private TableView<Fee> fee_table;

    @FXML
    private TableColumn<Fee, String> fee_time_col;

    @FXML
    private TableColumn<Fee, String> fee_type_col;
    
    @FXML
    private AnchorPane fee_change_info_form;

    @FXML
    private TextField fee_name_change;
    
    @FXML
    private TextField fee_id_change;
    
    @FXML
    private TextField fee_type_change;
    
    @FXML
    private TextField fee_amount_change;
    
    @FXML
    private TextField fee_time_change;
    
    @FXML
    private Label fee_amount;
    
    @FXML
    private Label fee_id;
    
    @FXML
    private Label fee_name;
    
    @FXML
    private Label fee_time;
    
    @FXML
    private Label fee_type;
    
    @FXML
    private TextField fee_search_bar;
    
    @FXML
    private ComboBox<?> fee_search_combo;
    
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
    
    
    
    // Car Register form
    
    @FXML
    private Button car_register_btn;
    
    @FXML
    private AnchorPane car_register_form;
    
    @FXML
    private Button car_add_btn;

    @FXML
    private Button car_change_btn;

    @FXML
    private Button car_clear_btn;

    @FXML
    private TextField car_company;

    @FXML
    private TableColumn<Car, String> car_company_col;

    @FXML
    private Button car_delete_btn;

    @FXML
    private TextField car_household_id;

    @FXML
    private TableColumn<Car, String> car_household_id_col;

    @FXML
    private TextField car_number;

    @FXML
    private TableColumn<Car, String> car_number_col;

    @FXML
    private TextField car_owner_id;

    @FXML
    private TableColumn<Car, String> car_owner_id_col;

    @FXML
    private Button car_refresh_btn;

    @FXML
    private TextField car_search_bar;

    @FXML
    private ComboBox<?> car_search_combo;

    @FXML
    private TableView<Car> car_table;

    @FXML
    private ComboBox<?> car_type;

    @FXML
    private TableColumn<Car, String> car_type_col;
    
    
    // Statistical form

    @FXML
    private AnchorPane statistical_form;
    
    @FXML
    private TableView<FeePayment> payment_table;
    
    @FXML
    private TableColumn<FeePayment, String> payment_date_col;

    @FXML
    private TableColumn<FeePayment, Integer> payment_fee_id_col;

    @FXML
    private TableColumn<FeePayment, Integer> payment_owner_id_col;

    @FXML
    private TableColumn<FeePayment, String> payment_status_col;
    
    @FXML
    private TableColumn<FeePayment, Double> payment_price_col;
    
    @FXML
    private TableColumn<FeePayment, String> payment_fee_name_col;
    
    @FXML
    private AnchorPane bill_form;
    
    @FXML
    private Label bill_fee_id;
    
    @FXML
    private Label bill_owner_id;
    
    @FXML
    private Label bill_status;
    
    @FXML
    private Label bill_cost;

    @FXML
    private Label bill_date;
    
    @FXML
    private ComboBox<?> payment_search_combo;
    
    @FXML
    private TextField payment_search_bar;
    
    //Alert
    
    private AlertMessage alert = new AlertMessage();
    
    // Constraint
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Remove non-digit characters from the phone number
        String digitsOnly = phoneNumber.replaceAll("\\D", "");

        // Check if the resulting string has exactly 10 digits
        return digitsOnly.length() == 10;
    }
    
    
    
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
    
    // Close System
    
    public void close(){
        System.exit(0);
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
    
    // Main Menu Function
    
    public void showTotalCitizen(){
        
        Conn c = new Conn();
        String query = "select count(*) from resident";
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                total_citizen.setText(rs.getString("count(*)"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void showTotalHousehold(){
        Conn c = new Conn();
        String query = "select count(*) from household";
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                total_household.setText(rs.getString("count(*)"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void showTotalStayingResident(){
        Conn c = new Conn();
        String query = "select count(*) from resident where status = '"+"Stay"+"'";
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                total_staying_resident.setText(rs.getString("count(*)"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void showTotalAbsentResident(){
        Conn c = new Conn();
        String query = "select count(*) from resident where status = '"+"Absent"+"'";
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                total_absent_resident.setText(rs.getString("count(*)"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void showTotalCar(){
        Conn c = new Conn();
        String query = "select count(*) from car";
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                total_vehicle.setText(rs.getString("count(*)"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void refresh(){
        showTotalCitizen();
        showTotalHousehold();
        showTotalAbsentResident();
        showTotalStayingResident();
        showTotalCar();
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
        
        ObservableList<Resident> listResidentData = FXCollections.observableArrayList();
        
        String query = "select * from resident";
        Conn c = new Conn();
        Resident resident;
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                resident = new Resident(rs.getString("ID"), rs.getString("name"),
                rs.getInt("age"), rs.getString("phone_number"), rs.getString("gender"), rs.getString("status"));
                listResidentData.add(resident);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return listResidentData;
    }
    
    private ObservableList<Resident> listResidentData;
    
    public void showResidentData(){
        listResidentData = residentData();
        resident_ID_col.setCellValueFactory(new PropertyValueFactory<>("ID"));
        resident_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        resident_age_col.setCellValueFactory(new PropertyValueFactory<>("age"));
        resident_gender_col.setCellValueFactory(new PropertyValueFactory<>("gender"));
        resident_phone_col.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        resident_status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
        resident_table.setItems(listResidentData);
    }
    
    private String[] genders = {"Male", "Female"};
    
    public void comboGender(){
        List<String> listGender = new ArrayList<>();
        for(String gender : genders){
            listGender.add(gender);
        }
        ObservableList listData = FXCollections.observableArrayList(listGender);
        resident_gender_change.setItems(listData);
    }
    
    private String[] searchResidents = {"ID", "Gender", "Status", "Name"};
    
    public void comboResidentSearch(){
        List<String> listSearch = new ArrayList<>();
        for(String search : searchResidents){
            listSearch.add(search);
        }
        ObservableList listData = FXCollections.observableArrayList(listSearch);
        resident_search_combo.setItems(listData);
    }
    
    // status
    private String[] statuses = {"Stay", "Absent"};
    
    public void comboStatus(){
        List<String> listStatus = new ArrayList<>();
        for(String status : statuses){
            listStatus.add(status);
        }
        ObservableList listData = FXCollections.observableArrayList(listStatus);
        resident_status_change.setItems(listData);
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
        
        
        Conn c = new Conn();
        String query = "select * from role_in_household where member_id = '"+resident.getID()+"'";
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                owner_relation.setText(rs.getString("_role"));
                resident_household_id.setText(rs.getString("household_id"));
                resident_household_id_change.setText(rs.getString("household_id"));
                resident_role_change.setText(rs.getString("_role"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
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
        String delete = "delete from role_in_household where member_id = '"+resident_id.getText()+"'";
        String query = "delete from resident where ID = '"+resident_id.getText()+"'";
        String query1 = "delete from car where owner_id = '"+resident_id.getText()+"'";
        Conn c = new Conn();
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure that you want to delete it?");
            
            Optional<ButtonType> buttonType = alert.showAndWait();
            
            if(buttonType.get() == ButtonType.OK){
                c.s.execute(delete);
                c.s.execute(query1);
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
                + "status = '"+resident_status_change.getSelectionModel().getSelectedItem()+"' "
                + "where id = '"+resident_id_change.getText()+"'";
        
        String query1 = "update role_in_household set household_id = '"+resident_household_id_change.getText()+"', "
                + "_role = '"+resident_role_change.getText()+"' where member_id = '"+resident_id_change+"'";
        
        try{
            c.s.executeUpdate(query);
            c.s.executeUpdate(query1);
            alert.successMessage("Successfully Update");
            showResidentData();
            resident_change_info_form.setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void searchResident(){
        
        FilteredList<Resident> filteredData = new FilteredList<>(listResidentData, e -> true);
        resident_search_bar.textProperty().addListener((Observable, oldValue, newValue) -> {
            
            filteredData.setPredicate(Resident -> {
            
                if(newValue.isEmpty() || newValue == null){
                    return true;
                }
                
                String searchKeyword = newValue.toLowerCase();
                
                // search id
                if(resident_search_combo.getSelectionModel().getSelectedItem() == "ID"){
                    if(Resident.getID().toString().indexOf(searchKeyword) > -1){
                        return true;
                    } 
                    else return false;
                }
                if(resident_search_combo.getSelectionModel().getSelectedItem() == "Name"){
                    if(Resident.getName().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    } 
                    else return false;
                }
                if(resident_search_combo.getSelectionModel().getSelectedItem() == "Gender"){
                    if(Resident.getGender().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    } 
                    else return false;
                }
                if(resident_search_combo.getSelectionModel().getSelectedItem() == "Status"){
                    if(Resident.getStatus().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    } 
                    else return false;
                }

                else return false;

            });
            
        });
        
        SortedList<Resident> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(resident_table.comparatorProperty());
        resident_table.setItems(sortedData);
        
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
    
    private String[] searchHouseholds = {"IDHouse", "Address", "Owner"};
    
    public void comboHouseholdSearch(){
        List<String> listSearch = new ArrayList<>();
        for(String search : searchHouseholds){
            listSearch.add(search);
        }
        ObservableList listData = FXCollections.observableArrayList(listSearch);
        household_search_combo.setItems(listData);
    }
    
    public ObservableList<Household> houseHoldData(){
        ObservableList<Household> listData = FXCollections.observableArrayList();
        String query = "select * from household";
        Conn c = new Conn();
        Household household;
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                household = new Household(rs.getString("household_id"), 
                        rs.getString("household_address"),
                        rs.getInt("num_of_members"),
                        rs.getString("household_owner"), 
                        rs.getString("phone"),
                        rs.getDouble("area"));
                listData.add(household);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    
    private ObservableList<Household> listHouseHoldData = FXCollections.observableArrayList();
    
    public void showHouseHoldData(){
        listHouseHoldData = houseHoldData();
        household_id_col.setCellValueFactory(new PropertyValueFactory<>("ID"));
        household_owner_name_col.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        household_phone_col.setCellValueFactory(new PropertyValueFactory<>("phone"));
        household_address_col.setCellValueFactory(new PropertyValueFactory<>("address"));
        household_num_col.setCellValueFactory(new PropertyValueFactory<>("numOfMem"));
        household_area_col.setCellValueFactory(new PropertyValueFactory<>("area"));
        household_table.setItems(listHouseHoldData);
    }
    
    public void selectHouseHold(){
        Household household = household_table.getSelectionModel().getSelectedItem();
        int num = household_table.getSelectionModel().getSelectedIndex();
        
        if((num-1) < -1)
            return;
        
        household_id.setText(household.getID());
        household_owner_name.setText(household.getOwnerName());
        household_address.setText(household.getAddress());
        household_phone.setText(household.getPhone());
        household_num.setText(String.valueOf(household.getNumOfMem()));
        household_area.setText(String.valueOf(household.getArea()));
        
        household_id_change.setText(household.getID());
        household_address_change.setText(household.getAddress());
        household_owner_name_change.setText(household.getOwnerName());
        household_phone_change.setText(household.getPhone());
        household_area_change.setText(String.valueOf(household.getArea()));
        
        showHouseHoldData();
    }
    
    public void changeHouseHold(){
        household_change_info_form.setVisible(true);
        
    }
    
    public void closeChangeHouseHoldForm(){
        household_change_info_form.setVisible(false);
    }
    
    public void deleteHouseHold(){
        
        String query1 = "select member_id from role_in_household where household_id = '"+household_id.getText()+"'";
        String query = "delete from household where household_id = '"+household_id.getText()+"'";
        String deletePayment = "delete from fee_payment where id_owner = '"+household_id.getText()+"'";
        
        Conn c = new Conn();
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure that you want to delete it?");
            
            Optional<ButtonType> buttonType = alert.showAndWait();
            
            if(buttonType.get() == ButtonType.OK){
                
                try(ResultSet rs = c.s.executeQuery(query1)){
                    while(rs.next()){
                    
                        String id = rs.getString("member_id");
                        String deleteResident = "delete from resident where ID = '"+id+"'"; 
                        String deleteRole = "delete from role_in_household where member_id = '"+id+"'";
                        String deleteCar = "delete from car where owner_id = '"+id+"'";
                        
                        c.s.execute(deleteRole);
                        c.s.execute(deleteCar);
                        c.s.execute(deleteResident);
                    }
                    
                    c.s.execute(deletePayment);
                    c.s.executeUpdate(query);
                }
                
            } else {
                return;
            }
            showHouseHoldData();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updateHouseHold(){
        Conn c = new Conn();
        String query = "update household set "
                + "household_address = '"+household_address_change.getText()+"', "
                + "household_owner = '"+household_owner_name_change.getText()+"', "
                + "phone = '"+household_phone_change.getText()+"',"
                + "area = '"+household_area_change.getText()+"' "
                + "where household_id = '"+household_id_change.getText()+"'";
        try{
            c.s.executeUpdate(query);
            alert.successMessage("Successfully Update");
            showHouseHoldData();
            household_change_info_form.setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void searchHousehold(){
        FilteredList<Household> filteredData = new FilteredList<>(listHouseHoldData, b -> true);
        household_search_bar.textProperty().addListener(((observable, oldValue, newValue) -> {
            
            filteredData.setPredicate(predicateHouseHold -> {
            
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }
                
                String searchKeyword = newValue.toLowerCase();
                
                // search id
                if(household_search_combo.getSelectionModel().getSelectedItem() == "IDHouse"){
                    if(predicateHouseHold.getID().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(household_search_combo.getSelectionModel().getSelectedItem() == "Address"){
                    if(predicateHouseHold.getAddress().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(household_search_combo.getSelectionModel().getSelectedItem() == "Owner"){
                    if(predicateHouseHold.getOwnerName().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                else return false;
            });
            
        }));
        
        SortedList<Household> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(household_table.comparatorProperty());
        household_table.setItems(sortedData);
    }

    // Fee Function
    
    public void addFee() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/AddFee.fxml"));

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
    
    private String[] searchFees = {"IDFee", "Type", "Fee Name", "Time"};
    
    public void comboFeeSearch(){
        List<String> listSearch = new ArrayList<>();
        for(String search : searchFees){
            listSearch.add(search);
        }
        ObservableList listData = FXCollections.observableArrayList(listSearch);
        fee_search_combo.setItems(listData);
    }
    
    public ObservableList<Fee> feeData(){
        ObservableList<Fee> listData = FXCollections.observableArrayList();
        String query = "select * from fee";
        Conn c = new Conn();
        Fee fee;
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                fee = new Fee(rs.getString("fee_id"), 
                        rs.getString("fee_name"),
                        rs.getDouble("amount"),
                        rs.getString("fee_type"), 
                        rs.getString("fee_date"));
                listData.add(fee);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    
    private ObservableList<Fee> listFeeData = FXCollections.observableArrayList();
    
    public void showFeeData(){
        listFeeData = feeData();
        fee_id_col.setCellValueFactory(new PropertyValueFactory<>("ID"));
        fee_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        fee_amount_col.setCellValueFactory(new PropertyValueFactory<>("amount"));
        fee_type_col.setCellValueFactory(new PropertyValueFactory<>("type"));
        fee_time_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        fee_table.setItems(listFeeData);
    }
    
    public void selectFee(){
        Fee fee = fee_table.getSelectionModel().getSelectedItem();
        int num = fee_table.getSelectionModel().getSelectedIndex();
        
        if((num-1) < -1)
            return;
        
        fee_id.setText(fee.getID());
        fee_amount.setText(String.valueOf(fee.getAmount()));
        fee_name.setText(fee.getName());
        fee_type.setText(fee.getType());
        fee_time.setText(fee.getDate());
        
        fee_id_change.setText(fee.getID());
        fee_name_change.setText(fee.getName());
        fee_type_change.setText(fee.getType());
        fee_time_change.setText(fee.getDate());
        fee_amount_change.setText(String.valueOf(fee.getAmount()));
        
        showFeeData();
    }
    
    public void changeFee(){
        fee_change_info_form.setVisible(true);
        
    }
    
    public void closeChangeFeeForm(){
        fee_change_info_form.setVisible(false);
    }
    
    public void deleteFee(){
        String query = "delete from fee where fee_id = '"+fee_id.getText()+"'";
        String delete = "delete from fee_payment  where fee_id = '"+fee_id.getText()+"'";
        Conn c = new Conn();
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure that you want to delete it?");
            
            Optional<ButtonType> buttonType = alert.showAndWait();
            
            if(buttonType.get() == ButtonType.OK){
                c.s.executeUpdate(delete);
                c.s.executeUpdate(query);
            } else {
                return;
            }
            showFeeData();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updateFee(){
        Conn c = new Conn();
        String query = "update fee set "
                + "fee_name = '"+fee_name_change.getText()+"', "
                + "amount = '"+fee_amount_change.getText()+"' "
                + "where fee_id = '"+fee_id_change.getText()+"'";
        try{
            c.s.executeUpdate(query);
            alert.successMessage("Successfully Update");
            showFeeData();
            fee_change_info_form.setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void searchFee(){
        FilteredList<Fee> filteredData = new FilteredList<>(listFeeData, b -> true);
        fee_search_bar.textProperty().addListener(((observable, oldValue, newValue) -> {
            
            filteredData.setPredicate(feePredicate -> {
            
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }
                
                String searchKeyword = newValue.toLowerCase();
                
                // search id
                if(fee_search_combo.getSelectionModel().getSelectedItem() == "IDFee"){
                    if(feePredicate.getID().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(fee_search_combo.getSelectionModel().getSelectedItem() == "Type"){
                    if(feePredicate.getType().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(fee_search_combo.getSelectionModel().getSelectedItem() == "Fee Name"){
                    if(feePredicate.getName().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(fee_search_combo.getSelectionModel().getSelectedItem() == "Time"){
                    if(feePredicate.getDate().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                else return false;
            });
            
        }));
        
        SortedList<Fee> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(fee_table.comparatorProperty());
        fee_table.setItems(sortedData);
    }
    
    
    // Switch Fee Form (Mandatory Fee, Voluntary Fee, Total Fee)
    
    public void switchFeeForm(ActionEvent e){
        if(e.getSource() == mandatory_fee_btn){
            mandatory_fee_form.setVisible(true);
            voluntary_fee_form.setVisible(false);
            total_fee_form.setVisible(false);
            car_register_form.setVisible(false);
        }
        if(e.getSource() == voluntary_fee_btn){
            mandatory_fee_form.setVisible(false);
            voluntary_fee_form.setVisible(true);
            total_fee_form.setVisible(false);
            car_register_form.setVisible(false);
        }
        if(e.getSource() == total_fee_btn){
            mandatory_fee_form.setVisible(false);
            voluntary_fee_form.setVisible(false);
            total_fee_form.setVisible(true);
            car_register_form.setVisible(false);
        }
        if(e.getSource() == car_register_btn){
            mandatory_fee_form.setVisible(false);
            voluntary_fee_form.setVisible(false);
            total_fee_form.setVisible(false);
            car_register_form.setVisible(true);
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
    
    // Car
    
    private String[] searchCars = {"IDHouse", "IDOwner", "Car Type", "Car Company", "Car Number"};
    
    public void comboCarSearch(){
        List<String> listSearch = new ArrayList<>();
        for(String search : searchCars){
            listSearch.add(search);
        }
        ObservableList listData = FXCollections.observableArrayList(listSearch);
        car_search_combo.setItems(listData);
    }
    
    private String[] cars = {"Bike", "Motor", "Car", "Other"};
    
    public void comboCar(){
        List<String> listSearch = new ArrayList<>();
        for(String car : cars){
            listSearch.add(car);
        }
        ObservableList listData = FXCollections.observableArrayList(listSearch);
        car_type.setItems(listData);
    }
    
    public ObservableList<Car> carData(){
        ObservableList<Car> listData = FXCollections.observableArrayList();
        String query = "select * from car";
        Conn c = new Conn();
        Car car;
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                car = new Car(rs.getString("household_id"), 
                        rs.getString("owner_id"),
                        rs.getString("car_comp"),
                        rs.getString("car_num"), 
                        rs.getString("car_type"));
                listData.add(car);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    
    private ObservableList<Car> listCarData = FXCollections.observableArrayList();
    
    public void showCarData(){
        listCarData = carData();
        car_household_id_col.setCellValueFactory(new PropertyValueFactory<>("householdID"));
        car_owner_id_col.setCellValueFactory(new PropertyValueFactory<>("ownerID"));
        car_company_col.setCellValueFactory(new PropertyValueFactory<>("company"));
        car_number_col.setCellValueFactory(new PropertyValueFactory<>("number"));
        car_type_col.setCellValueFactory(new PropertyValueFactory<>("type"));
        car_table.setItems(listCarData);
    }
    
    public void addCar(){
        Conn c = new Conn();
        
        String query1 = "select * from role_in_household where household_id = '"+car_household_id.getText()+"' "
                + "and member_id = '"+car_owner_id.getText()+"'";
        
        try{
            ResultSet rs = c.s.executeQuery(query1);
            if(rs.next()){
                String query = "insert into car values('"+car_household_id.getText()+"',"
                + " '"+car_owner_id.getText()+"',"
                + " '"+car_company.getText()+"',"
                + " '"+car_number.getText()+"',"
                + " '"+car_type.getSelectionModel().getSelectedItem()+"')";
        
                try{
                    if(car_household_id.getText().isEmpty()||
                            car_company.getText().isEmpty()||
                            car_number.getText().isEmpty()||
                            car_owner_id.getText().isEmpty()||
                            car_type.getSelectionModel().isEmpty()){
                        alert.errorMessage("Please Fill all the blanks");
                    } else {
                        c.s.executeUpdate(query);
                        alert.confirmationMessage("Successfully add car");
                    }

                }catch(Exception e){

                }

                showCarData();
            } else {
                alert.errorMessage("This household/resident doesn't exist!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    public void selectCar(){
        Car car = car_table.getSelectionModel().getSelectedItem();
        int num = car_table.getSelectionModel().getSelectedIndex();
        
        if((num-1) < -1)
            return;
        
        car_household_id.setText(car.getHouseholdID());
        car_owner_id.setText(car.getOwnerID());
        car_company.setText(car.getCompany());
        car_number.setText(car.getNumber());
        car_type.getSelectionModel().getSelectedItem();
        
        showCarData();
    }
    
    public void deleteCar(){
        String query = "delete from car where household_id = '"+car_household_id.getText()+"' "
                + "and owner_id = '"+car_owner_id.getText()+"' "
                + "and car_comp = '"+car_company.getText()+"' "
                + "and car_num = '"+car_number.getText()+"' "
                + "and car_type = '"+car_type.getSelectionModel().getSelectedItem()+"'";
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
            showCarData();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void clearCar(){
        car_household_id.setText("");
        car_owner_id.setText("");
        car_company.setText("");
        car_number.setText("");
        car_type.getSelectionModel().clearSelection();
    }
    
    public void updateCar(){
        Conn c = new Conn();
        String query = "update car set "
                + "car_comp = '"+car_company.getText()+"', "
                + "car_type = '"+car_type.getSelectionModel().getSelectedItem()+"',"
                + "car_num = '"+car_number.getText()+"' "
                + "where household_id = '"+car_household_id.getText()+"' "
                + "and owner_id = '"+car_owner_id.getText()+"' ";
        try{
            c.s.executeUpdate(query);
            alert.successMessage("Successfully Update");
            showCarData();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void searchCar(){
        FilteredList<Car> filteredData = new FilteredList<>(listCarData, b -> true);
        car_search_bar.textProperty().addListener(((observable, oldValue, newValue) -> {
            
            filteredData.setPredicate(carPredicate -> {
            
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }
                
                String searchKeyword = newValue.toLowerCase();
                
                // search id
                if(car_search_combo.getSelectionModel().getSelectedItem() == "IDHouse"){
                    if(carPredicate.getHouseholdID().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(car_search_combo.getSelectionModel().getSelectedItem() == "IDOwner"){
                    if(carPredicate.getOwnerID().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(car_search_combo.getSelectionModel().getSelectedItem() == "Car Company"){
                    if(carPredicate.getCompany().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(car_search_combo.getSelectionModel().getSelectedItem() == "Car Type"){
                    if(carPredicate.getType().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(car_search_combo.getSelectionModel().getSelectedItem() == "Car Number"){
                    if(carPredicate.getNumber().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                else return false;
            });
            
        }));
        
        SortedList<Car> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(car_table.comparatorProperty());
        car_table.setItems(sortedData);
    }
    
    // Statistic 
    
    private String[] payments = {"Fee ID", "Household ID", "Status", "Pay Date", "Price", "Fee Name"};
    
    public void comboPaymentSearch(){
        List<String> listSearch = new ArrayList<>();
        for(String payment : payments){
            listSearch.add(payment);
        }
        ObservableList listData = FXCollections.observableArrayList(listSearch);
        payment_search_combo.setItems(listData);
    }
    
    public ObservableList<FeePayment> feePaymentData(){
        ObservableList<FeePayment> listData = FXCollections.observableArrayList();
        String query = "select * from fee_payment";
        Conn c = new Conn();
        FeePayment payment;
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                payment = new FeePayment(rs.getInt("fee_id"), 
                        rs.getInt("id_owner"),
                        rs.getString("status"),
                       rs.getString("pay_date"),
                         rs.getDouble("price"),
                       rs.getString("fee_name"));
                listData.add(payment);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    
    private ObservableList<FeePayment> listPaymentData;
    
    public void showFeePaymentData(){
        listPaymentData = feePaymentData();
        payment_fee_id_col.setCellValueFactory(new PropertyValueFactory<>("ID"));
        payment_owner_id_col.setCellValueFactory(new PropertyValueFactory<>("ownerID"));
        payment_date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        payment_status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
        payment_price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        payment_fee_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        payment_table.setItems(listPaymentData);
    }
    
    public void billForm(){
        bill_form.setVisible(true);
        
    }
    
    public void closeBillForm(){
        bill_form.setVisible(false);
    }
    
    public void selectFeePayment(){
        FeePayment payment = payment_table.getSelectionModel().getSelectedItem();
        int num = payment_table.getSelectionModel().getSelectedIndex();
        
        if((num-1) < -1)
            return;
        
        bill_fee_id.setText(String.valueOf(payment.getID()));
        bill_owner_id.setText(String.valueOf(payment.getOwnerID()));
        bill_status.setText(payment.getStatus());
        bill_date.setText(payment.getDate());
        bill_cost.setText(String.valueOf(payment.getPrice()));
        
        showFeePaymentData();
    }
    
    public void searchFeePayment(){
        FilteredList<FeePayment> filteredData = new FilteredList<>(listPaymentData, b -> true);
        payment_search_bar.textProperty().addListener(((observable, oldValue, newValue) -> {
            
            filteredData.setPredicate(paymentPredicate -> {
            
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }
                
                String searchKeyword = newValue.toLowerCase();
                
                // search id
                if(payment_search_combo.getSelectionModel().getSelectedItem() == "Fee ID"){
                    if(String.valueOf(paymentPredicate.getID()).toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(payment_search_combo.getSelectionModel().getSelectedItem() == "Household ID"){
                    if(String.valueOf(paymentPredicate.getOwnerID()).toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(payment_search_combo.getSelectionModel().getSelectedItem() == "Date"){
                    if(paymentPredicate.getDate().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(payment_search_combo.getSelectionModel().getSelectedItem() == "Status"){
                    if(paymentPredicate.getStatus().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(payment_search_combo.getSelectionModel().getSelectedItem() == "Price"){
                    if(String.valueOf(paymentPredicate.getPrice()).toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                if(payment_search_combo.getSelectionModel().getSelectedItem() == "Fee Name"){
                    if(paymentPredicate.getName().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else return false;
                }
                
                else return false;
            });
            
        }));
        
        SortedList<FeePayment> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(payment_table.comparatorProperty());
        payment_table.setItems(sortedData);
    }
    
    public void payBill(){
        Conn c = new Conn();
        
        String query = "update fee_payment set status = '"+"paid"+"' where fee_id = '"+bill_fee_id.getText()+"' and id_owner = '"+bill_owner_id.getText()+"'";
        String query1 = "update fee_payment set pay_date = current_date where fee_id = '"+bill_fee_id.getText()+"' and id_owner = '"+bill_owner_id.getText()+"'";
        try{
            c.s.executeUpdate(query);
            c.s.executeUpdate(query1);
        } catch(Exception e){
            e.printStackTrace();
        }
        showFeePaymentData();
        bill_form.setVisible(false);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        runTime();
        
        showTotalCitizen();
        showTotalHousehold();
        showTotalAbsentResident();
        showTotalStayingResident();
        showTotalCar();
        
        showResidentData();
        showHouseHoldData();
        showFeeData();
        showFeePaymentData();
        showCarData();
        
        comboGender();
        comboStatus();
        comboResidentSearch();
        comboHouseholdSearch();
        comboFeeSearch();
        comboCarSearch();
        comboCar();
        comboPaymentSearch();
    }
    
}
