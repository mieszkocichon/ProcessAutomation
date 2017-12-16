package net.usermd.mcichon.body.shop;

import lombok.Data;
import net.functional.library.common.Function;

@Data
public class Price {

  public static final Price ZERO = new Price(0.0);

  public static Function<Price, Function<OrderLine, Price>> sum = x -> y -> x.add(y.getAmount());

  public final double value;

  private Price(double value) {
    this.value = value;
  }

  public static Price price(double value) {
    if (value <= 0) {
      throw new IllegalArgumentException("Cena musi być większa od 0");
    } else {
      return new Price(value);
    }
  }

  public Price add(Price that) {
    return price(this.value + that.value);
  }

  public Price mult(int count) {
    return price(this.value * count);
  }

  public String toString() {
    return Double.toString(this.value);
  }
}
