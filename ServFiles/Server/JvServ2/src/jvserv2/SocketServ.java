/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jvserv2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Damna
 */
public class SocketServ implements Runnable{
    private int clientNum;
    private ServerSocket servSoc;
    private User users;
    public boolean state;
    private Thread thread;
    
    public SocketServ(){
        clientNum = 0;
        state = true;
        try {
            servSoc = new ServerSocket(4098);
            
        } catch (Exception e) {
        }
    }
    
    @Override
    public void run(){
        try {
            while (state) {                
                System.out.println("[ServerSignUp] Waiting for clients...");
                Socket soc = servSoc.accept();
                clientNum++;
                
                CliHandler handle = new CliHandler(soc);
                
                thread = new Thread((Runnable) handle);
                thread.start();
                
                DataInputStream fromCli = new DataInputStream(soc.getInputStream());
                DataOutputStream toCli = new DataOutputStream(soc.getOutputStream());
                
                String cliUsername = fromCli.readUTF();
                String cliPass = fromCli.readUTF();
                System.out.println("Sign upMessage recieve");
                System.out.println(cliUsername + ", " + cliPass);
                users = new User(0, cliUsername, cliPass);
                users.Add();
                toCli.writeUTF("Accepted");
            }
            System.out.println("Thread stopping");
            
        } catch (Exception e) {
        }
    }
    
    public void StopServ(){
        state = false;
    }
}
