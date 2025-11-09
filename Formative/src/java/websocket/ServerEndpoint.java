/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package websocket;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
/**
 *
 * @author Damna
 */
@ApplicationScoped
@javax.websocket.server.ServerEndpoint("/actions")
public class ServerEndpoint {
    
    @Inject
    private ServerHandler sessionHandler;

    @OnOpen
    public void open(Session session){
        System.out.println("Connection established: " + session.getId());
        sessionHandler.addSession(session);
        //System.out.println(sessions.size());
    }
    
    @OnClose
    public void close(Session session){
        //System.out.println("websocket.ServerEndpoint.close()");
        sessionHandler.removeSession(session);
    }
    
    @OnError
        public void onError(Throwable error) {
            Logger.getLogger(ServerEndpoint.class.getName()).log(Level.SEVERE, null, error);
    }

    @OnMessage
    public void handleMessage(String message, Session session) {
        Set<Session> sessions = sessionHandler.getSessions();
        for(Session sendSession: sessions){
            try {
                sendSession.getBasicRemote().sendText(message);
            } catch (IOException e) {
                System.out.println("Error");
                sessions.remove(sendSession);
            }
        }
    }

}
