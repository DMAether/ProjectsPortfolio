/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Objects.Account;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Damna
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login", "/GoRegister"})
public class LoginServlet extends HttpServlet {

    //initialize variable
    Account found;
    String user;
    String pass;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Failed</title>");
            out.println("<link rel=\"stylesheet\" href=\"login.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"post\" action=\"Login\">");
            out.println("<input type=\"text\" name=\"logUser\">");
            out.println("<input type=\"password\" name=\"logPass\">");
            out.println("<button value=\"submit\">submit</button>");
            out.println("Login Failed, please try again.");
            out.println("</form>");
            out.println("<form method=\"post\" action=\"GoRegister\"><button value=\"submit\">Register?</button></form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        
        switch (action) {
            case "/Login":
                Set<Account> set = new HashSet<>();
                try {
                    set = getHash();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
                user = request.getParameter("logUser");
                pass = request.getParameter("logPass");
                found = search(set, user);
            
                if(found != null && found.getPass().equals(pass)){
                   response.sendRedirect("main.html");
                } else {
                   System.out.println("Wrong Password");
                   processRequest(request, response);
                }
                break;
            case "/GoRegister":
                response.sendRedirect("index.html");
                break;
            default:
                throw new AssertionError();
        }  
    }
    
    public Set<Account> getHash() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("accounts.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Set<Account> newSet = (Set) ois.readObject();    
        ois.close();
            
        return newSet;
    }
    
    public Account search(Set<Account> accounts, String user){
        for(Account account: accounts){
            if(account.getUser().equals(user)){
                System.out.println("Found account");
                return account;
            }
        }
        return null;
    }
        
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
