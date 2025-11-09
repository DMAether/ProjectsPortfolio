/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jvserv2;

import java.util.Scanner;

/**
 *
 * @author Damna
 */
public class JvServ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SocketServ server = new SocketServ();
        SocketServLogin serverlogin = new SocketServLogin();
        Thread thread1 = new Thread((Runnable) server);
        Thread thread2 = new Thread((Runnable) serverlogin);
        System.out.println("Starting servers...");
        thread1.start();
        System.out.println("Sign up server started");
        thread2.start();
        System.out.println("LogIn Server started");
        
        int uptime = 0;
        while(thread1.isAlive() && thread2.isAlive()){
            uptime++;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.err.println(e);
            }
            
        }
        System.out.println("Servers stopping\nTotal Uptime: " + uptime + " seconds");
        server.StopServ();
        serverlogin.StopServ();
        System.out.println("Servers stopped");
    }
    
}
