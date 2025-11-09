/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servawstestclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Damna
 */
public class ServAWSTestClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. SignUp\n2. LogIn");
        int choice = scanner.nextInt();
        System.out.println("Username: ");
        String username = scanner.next();
        System.out.println("Password: ");
        String pass = scanner.next();
        switch (choice) {
            case 1:
                try {
                    System.out.println("connecting...");
                    Socket socketSign = new Socket("ec2-13-60-65-172.eu-north-1.compute.amazonaws.com", 4098);
                    System.out.println("Connected");

                    DataInputStream inpServ = new DataInputStream(socketSign.getInputStream());
                    DataOutputStream outServ = new DataOutputStream(socketSign.getOutputStream());

                   
                    outServ.writeUTF(username);
                    outServ.writeUTF(pass);

                    System.out.println("Waiting reply");
                    String inp = inpServ.readUTF();
                    System.out.println(inp);
                } catch (Exception e) {
                    System.err.println(e);
                }
                break;
            case 2:
                try {
                    System.out.println("connecting...");
                    Socket socketSign = new Socket("ec2-13-60-65-172.eu-north-1.compute.amazonaws.com", 8096);
                    System.out.println("Connected");

                    DataInputStream inpServ = new DataInputStream(socketSign.getInputStream());
                    DataOutputStream outServ = new DataOutputStream(socketSign.getOutputStream());

                    
                    outServ.writeUTF(username);
                    outServ.writeUTF(pass);

                    System.out.println("Loging in");
                    String inp = inpServ.readUTF();
                    System.out.println(inp);
                } catch (Exception e) {
                    System.err.println(e);
                }
                break;
            default:
                System.out.println("No matching choice");
                throw new AssertionError();
        }
        
    }
    
}
