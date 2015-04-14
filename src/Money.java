package wewut;

import java.math.BigDecimal;

public class Money {
  private BigDecimal val;

  public Money(double val) {
    this(BigDecimal.valueOf(val));
  }

  public Money(BigDecimal val) {
    this.val = val;
  }

  public Money add(double d) {
    return new Money(val.add(BigDecimal.valueOf(d)));
  }

  public Money add(Money m) {
    return new Money(val.add(m.val));
  }

  public double toDouble() {
    return val
      .setScale(2, BigDecimal.ROUND_HALF_UP)
      .doubleValue();
  }
}
