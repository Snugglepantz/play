package me.slashfix.white;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author burni_000
 */
public class FigureEncoder implements Encoder.Text<Figure> {

  @Override
  public String encode(Figure figure) throws EncodeException {
    return figure.getJson().toString();
  }

  @Override
  public void init(EndpointConfig ec) {
    System.out.println("init");
  }

  @Override
  public void destroy() {
    System.out.println("destroy");
  }
}
