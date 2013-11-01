package me.slashfix.white;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import lombok.Data;

/**
 *
 * @author burni_000
 */
@Data
public class Figure {

  private JsonObject json;

  public Figure(JsonObject json) {
    this.json = json;
  }

  @Override
  public String toString() {
    StringWriter writer = new StringWriter();
    Json.createWriter(writer).write(json);
    return writer.toString();
  }
}
