/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formapp;

import javafx.scene.control.RadioButton;

/**
 *
 * @author Damien
 */
public class Data {
    private String name;
    private String lName;
    private String lang;
    private String gender;

    public Data(String name, String lName, String lang) {
        this.name = name;
        this.lName = lName;
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public String getlName() {
        return lName;
    }

    public String getLang() {
        return lang;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    public void setLang(String lang) {
        this.lang = lang;
    }
    
    public void DetGender(RadioButton rdMale,RadioButton rdFemale, RadioButton rdOther){
        if(rdMale.isSelected()){
            gender = "Male";
        }else if(rdFemale.isSelected()){
            gender = "Female";
        }else if(rdOther.isSelected()){
            gender = "Other";
        }else gender = "N/A";
    }
    @Override
    public String toString() {
        return name+" "+lName+" ("+gender+"): "+lang;
    }
    
    
}
