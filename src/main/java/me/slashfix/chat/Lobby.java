package me.slashfix.chat;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author burni_000
 */
@ApplicationScoped
@Named
public class Lobby implements Serializable {
  
  private Map<String, Chat> chatrooms = new HashMap<String, Chat>();

}
