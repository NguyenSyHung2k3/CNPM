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
    private String address;
    private int numOfMem;

    public Household(String ID, String address, int numOfMem) {
        this.ID = ID;
        this.address = address;
        this.numOfMem = numOfMem;
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
    
}
