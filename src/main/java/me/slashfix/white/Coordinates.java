package me.slashfix.white;

import lombok.Data;

/**
 *
 * @author burni_000
 */
@Data
public class Coordinates {

  private float x;
  private float y;

  public Coordinates() {
  }

  public Coordinates(float x, float y) {
    this.x = x;
    this.y = y;
  }
}
