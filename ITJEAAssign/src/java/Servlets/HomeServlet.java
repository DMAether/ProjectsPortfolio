package Servlets;

import java.io.IOException;
import java.net.ConnectException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Damna
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/Conversations", "/LogOut"})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/Conversations":
                response.sendRedirect("Conversations.html");
                break;
            case "/LogOut":
                response.sendRedirect("login.html");
                break;
            default:
                throw new AssertionError("Redirect Fail");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
