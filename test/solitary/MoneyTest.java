package wewut.test.solitory;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static wewut.test.Assert.assertMoney;

import wewut.test.a;

import wewut.Money;

public class MoneyTest {
  @Test
  public void doubleAddition() {
    assertMoney(11.0, a.money.w(1.0).build().add(10.0));
  }

  @Test
  public void moneyAddition() {
    assertMoney(
      11.0,
      a.money.w(1.0).build().add(
        a.money.w(10.0).build()
      )
    );
  }

  @Test
  public void oneDecimalToDouble() {
    assertMoney(
      1.0,
      a.money.w(1.0).build()
    );
  }

  @Test
  public void twoDecimalToDouble() {
    assertMoney(
      1.12,
      a.money.w(1.12).build()
    );
  }

  @Test
  public void threeDecimalUpToDouble() {
    assertMoney(
      1.12,
      a.money.w(1.123).build()
    );
  }

  @Test
  public void threeDecimalDownToDouble() {
    assertMoney(
      1.13,
      a.money.w(1.125).build()
    );
  }
}
