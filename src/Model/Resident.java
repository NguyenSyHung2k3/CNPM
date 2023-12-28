/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.ObjectInputFilter;

/**
 *
 * @author pv
 */
public class Resident {
    
    private String ID;
    private String name;
    private int age;
    private String phone_number;
    private String gender;
    private String status;

    public Resident(String ID, String name, int age, String phone_number, String gender, String status) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.gender = gender;
        this.status = status;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
