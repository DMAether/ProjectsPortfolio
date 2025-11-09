/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jvserv2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Damna
 */
public class User implements Serializable{
    private int id;
    private String username;
    private String pass;
    public List<User> users;
    public int useSize;

    public User(int id, String username, String pass) {
        //try remove this from constructor
        
        this.id = id;
        this.username = username;
        this.pass = pass;
    }
    
    public void Add(){
        setIdorSize();
        System.out.println(id + ", " + username + ", " + pass);
        users.add(new User(id, username, pass));
        System.out.println("write to file");
        WriteObject();
    }
    
    //need to add method for login
    
    public void setIdorSize(){
        users = readObject();//this might be issue
        if(users != null) {
            useSize = users.size();
        } else useSize = 0;
        id = useSize;
    }
    private void WriteObject(){
        try {
            FileOutputStream fos = new FileOutputStream("User.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
        } catch (Exception e) {
        }
    }
    public List<User> readObject(){
        File file = new File("User.ser");
        List<User> userStore = null;
        if(file.exists()){
            try {
                FileInputStream fis = new FileInputStream("User.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                userStore = (List<User>) ois.readObject();
            } catch (Exception e) {
            }
            
        }else{
            userStore = new ArrayList<>();
            try {
                File filetemp = new File("User.ser");
                if(filetemp.createNewFile()){
                    System.out.println("New file created" + filetemp.getName());
                }
            } catch (Exception e) {
            }
        }
        return userStore;
    }
    
    public String[] AllSys(){
        setIdorSize();
        int size = useSize;
        String[] allString = new String[size];
        int i = 0;
        for(User u: users){
            allString[i] = u.toString();
            i++;
        }
        return allString;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
    
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", pass=" + pass + '}';
    }
    
    
}
