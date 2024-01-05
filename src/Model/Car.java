/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author pv
 */
public class Car {
    private String householdID;
    private String ownerID;
    private String company;
    private String number;
    private String type;

    public Car(String householdID, String ownerID, String company, String number, String type) {
        this.householdID = householdID;
        this.ownerID = ownerID;
        this.company = company;
        this.number = number;
        this.type = type;
    }

    public String getHouseholdID() {
        return householdID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public String getCompany() {
        return company;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public void setHouseholdID(String householdID) {
        this.householdID = householdID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
