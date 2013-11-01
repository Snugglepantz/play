package me.slashfix.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author burni_000
 */
@ServerEndpoint("/person/sync")
public class PersonSync {

  @OnMessage
  public void onMessage(String message, Session client) throws IOException, EncodeException {
    for(Session peer : client.getOpenSessions()) {
      peer.getBasicRemote().sendObject(message);
      Logger.getLogger(PersonSync.class.getName()).log(Level.INFO, "User has updated the customers.");
    }
  }

}
