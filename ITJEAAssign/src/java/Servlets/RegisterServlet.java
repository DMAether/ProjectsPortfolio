/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Objects.Account;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Damna
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/Register", "/GoLogin"})
@MultipartConfig(maxFileSize = 16177215)
public class RegisterServlet extends HttpServlet {

    
    int id = 0;
    Set<Account> accounts = new HashSet<>();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/Register":
                String user = request.getParameter("username");
                String pass = request.getParameter("pass");
        
                Account temp = new Account(id, user, pass);
                id++;
                accounts.add(temp);
        
                try (FileOutputStream fileOut = 
                    new FileOutputStream(new File("accounts.ser")); 
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) { 
                    objectOut.writeObject(accounts); 
                    System.out.println("HashSet has been serialized.");
                }catch (IOException e) { 
                    e.printStackTrace(); 
                }
                response.sendRedirect("login.html");
                break;
            case "/GoLogin":
                response.sendRedirect("login.html");
                break;
            default:
                throw new AssertionError();
        } 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
