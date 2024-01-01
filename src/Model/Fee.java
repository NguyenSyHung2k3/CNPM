/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author pv
 */
public class Fee {
    private String ID;
    private String name;
    private Double amount;
    private String type;
    private String date;

    public Fee(String ID, String name, Double amount, String type, String date) {
        this.ID = ID;
        this.name = name;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
    
}
