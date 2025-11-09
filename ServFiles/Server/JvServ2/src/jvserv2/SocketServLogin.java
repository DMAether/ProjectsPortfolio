/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jvserv2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Damna
 */
public class SocketServLogin implements Runnable{
    private int clientNum;
    private ServerSocket servSoc;
    private User users;
    private List<User> usersStore;
    public boolean state;
    private Thread thread;
    
    public SocketServLogin(){
        clientNum = 0;
        state = true;
        users = new User(0, "null", "null");
        try {
            servSoc = new ServerSocket(8096);
            
        } catch (Exception e) {
        }
    }
    @Override
    public void run(){
        try {
            while (state) {                
                System.out.println("[ServerLogin] Waiting for clients...");
                Socket soc = servSoc.accept();
                clientNum++;
                
                CliHandler handle = new CliHandler(soc);
                
                thread = new Thread((Runnable) handle);
                thread.start();
                
                DataInputStream fromCli = new DataInputStream(soc.getInputStream());
                DataOutputStream toCli = new DataOutputStream(soc.getOutputStream());
                
                String cliUsername = fromCli.readUTF();
                String cliPass = fromCli.readUTF();
                System.out.println("LogIn Message recieve");
                System.out.println(cliUsername + ", " + cliPass);
                
                usersStore = users.readObject();
                boolean loggedIn = false;
                String user="";
                int id;
                for(User u : usersStore){
                    if(u.getUsername() != null && u.getUsername().equals(cliUsername)){
                        if(u.getPass().equals(cliPass)){
                            loggedIn = true;
                            user = u.getUsername();
                            id = u.getId();
                        } 
                    }
                }
                if(loggedIn){
                    toCli.writeUTF("Log in Success, welcome " + user);
                }else{
                    toCli.writeUTF("Unable to log in, check details and try again");
                }
                
            }
            
        } catch (Exception e) {
        }
    }
    
    public void StopServ(){
        state = false;
    }
    
}
