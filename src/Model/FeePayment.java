/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author pv
 */
public class FeePayment {
    private int ID;
    private int ownerID;
    private String date;
    private String status;
 
    public FeePayment(int ID, int ownerID, String status, String date) {
        this.ID = ID;
        this.ownerID = ownerID;
        this.date = date;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public String getDate() {
        return date;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
