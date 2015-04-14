package wewut;

public class Movie {
  public enum Type {
    REGULAR, NEW_RELEASE, CHILDREN, UNKNOWN;
  }

  private String title;
  Price price;

  public Movie(String title, Movie.Type priceCode) {
    this.title = title;
    setPriceCode(priceCode);
  }

  public String getTitle() {
    return title;
  }

  public String getTitle(String format, int actorsCount) {
    return title;
  }

  private void setPriceCode(Movie.Type priceCode) {
    switch (priceCode) {
    case CHILDREN:
      price = new ChildrensPrice();
      break;
    case NEW_RELEASE:
      price = new NewReleasePrice();
      break;
    case REGULAR:
      price = new RegularPrice();
      break;
    default:
      throw new IllegalArgumentException("invalid price code");
    }
  }

  public Money getCharge(int daysRented) {
    return new Money(price.getCharge(daysRented));
  }

  public int getPoints(int daysRented) {
    return price.getPoints(daysRented);
  }

}
