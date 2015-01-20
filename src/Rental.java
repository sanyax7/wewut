package wewut;

public class Rental {
  Movie movie;
  private int daysRented;
  private boolean started;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public double getCharge() {
    return movie.getCharge(daysRented);
  }

  public int getPoints() {
    return movie.getPoints(daysRented);
  }

  public String getLineItem() {
    return movie.getTitle() + " " + getCharge();
  }

  public boolean isStarted() {
    return started;
  }

  public void start(Store store) {
    if (store.getAvailability(movie) > 0) {
      store.remove(movie);
      this.started = true;
    }
  }
}
