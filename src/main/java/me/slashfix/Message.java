package me.slashfix;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author burni_000
 */
@Entity
@XmlRootElement
@Data
public class Message implements Serializable {

  @Id
  @GeneratedValue
  private Long id;
  
  private String sender;
  
  private String content;
  
}
