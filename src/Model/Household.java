/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author pv
 */
public class Household {
    private String ID;
    private String ownerName;
    private String phone;
    private String address;
    private int numOfMem;
    private Double area;

    public Household(String ID, String address, int numOfMem, String ownerName, String phone, Double area) {
        this.ID = ID;
        this.address = address;
        this.numOfMem = numOfMem;
        this.ownerName = ownerName;
        this.phone = phone;
        this.area = area;
    }

    public String getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public int getNumOfMem() {
        return numOfMem;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumOfMem(int numOfMem) {
        this.numOfMem = numOfMem;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
    
}
