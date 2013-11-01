package me.slashfix.chat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import me.slashfix.Message;

/**
 *
 * @author burni_000
 */
@ConversationScoped
@Named
@Data
public class Chat implements Serializable {
  @Inject
  private Conversation conversation;
  
  private List<Message> messages = new ArrayList<Message>();

}
