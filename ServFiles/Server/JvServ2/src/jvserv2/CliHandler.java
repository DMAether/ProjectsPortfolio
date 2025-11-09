/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jvserv2;

import java.net.Socket;

/**
 *
 * @author Damna
 */
public class CliHandler implements Runnable{
    Socket socket = new Socket();
    User use;
    static int clientNum;
    
    public CliHandler(Socket sac){
        this.socket = sac;
    }
    
    public void ConnectUser(User user){
        use = user;
    }
    
    @Override
    public void run(){
        System.out.println("Client connected ");
    }
}
