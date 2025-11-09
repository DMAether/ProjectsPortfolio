package com.mycompany.formapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        String name = "";
        String lN = "";
        String lang = "";
        stage.setTitle("Form");
        
        
        //this is the layout, they determine how components get placed in window
        VBox box = new VBox();
        
        Label lblName = new Label();
        lblName.setText("Name:");
        TextField nameField = new TextField();
        nameField.setMaxWidth(100);
        //nameField.setTranslateX(10);
        //nameField.setTranslateY(10);
        
        Label lblLName = new Label();
        lblLName.setText("Last Name");
        TextField lName = new TextField();
        lName.setMaxWidth(100);
        
        RadioButton rdMale = new RadioButton("Male");
        RadioButton rdFemale = new RadioButton("Female");
        RadioButton rdOther = new RadioButton("Other");
        
        ComboBox < String > cbo = new ComboBox < > ();

        cbo.getItems().addAll("Java", "Python", "C++");
        
        Button conf = new Button("Confirm");
        
        Label success = new Label();
        Data dt = new Data(name,lN,lang);
        conf.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                dt.setName(nameField.getText());
                dt.setlName(lName.getText());
                dt.DetGender(rdMale, rdFemale, rdOther);
                dt.setLang(cbo.getValue());
                success.setText("Success");
                success.setTextFill(Color.GREEN);
                System.out.println(dt.toString());
                if(dt.getLang().equals("Java")){
                    System.out.println("Approved");
                }
            }
        });
        
        box.getChildren().addAll(lblName,nameField,lblLName,lName,rdMale,rdFemale,rdOther,cbo,conf,success);
        Scene scene = new Scene(box,200,220);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}