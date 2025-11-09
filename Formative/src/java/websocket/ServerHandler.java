/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package websocket;

import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;

/**
 *
 * @author Damna
 */

@ApplicationScoped
public class ServerHandler {
    Set<Session> sessions = new HashSet<>();

        public ServerHandler() {
        }
        
        public void addSession(Session session){
            sessions.add(session);
        }
        public void removeSession(Session session){
            sessions.remove(session);
        }

        public Set<Session> getSessions() {
            return sessions;
        }
}
