package me.slashfix.white;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author burni_000
 */
@ServerEndpoint(value = "/whiteend", encoders = {FigureEncoder.class}, decoders = {FigureDecoder.class})
public class MyWhiteBoard {

  private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

  @OnMessage
  public void broadcastSnapshot(ByteBuffer data, Session session) throws IOException {
    System.out.println("broadcastBinary: " + data);
    for (Session peer : peers) {
      if (!peer.equals(session)) {
        peer.getBasicRemote().sendBinary(data);
      }
    }
  }

  @OnOpen
  public void onOpen(Session peer) {
    peers.add(peer);
  }

  @OnClose
  public void onClose(Session peer) {
    peers.remove(peer);
  }

  @OnMessage
  public String onMessage(String message) {
    return null;
  }
}
