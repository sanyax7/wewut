package wewut;

public class NewReleasePrice extends Price {
  @Override
  public double getCharge(int daysRented) {
    return daysRented * 3;
  }

  @Override
  int getPoints(int daysRented) {
    if (daysRented > 1)
      return 2;
    return 1;
  }
}
