/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author pv
 */
public class AlertMessage {
    private Alert alert;
    public void errorMessage(String message){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    public void successMessage(String message){
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    public boolean confirmationMessage(String message){
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setContentText(message);
        alert.setHeaderText(null);
        Optional<ButtonType> option = alert.showAndWait();
        
        if(option.get().equals(ButtonType.OK)){
            return true;
        }else 
            return false;
    }
}
