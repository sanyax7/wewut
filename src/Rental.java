package wewut;

import org.joda.time.DateTime;

public class Rental {
  Movie movie;
  private int daysRented;
  private boolean started;
  private DateTime creationDateTime;

  public Rental(Movie movie, int daysRented, DateTime creationDateTime) {
    this.movie = movie;
    this.daysRented = daysRented;
    this.creationDateTime = creationDateTime;
  }

  public Rental(Movie movie, int daysRented) {
    this(movie, daysRented, new DateTime());
  }

  public Movie getMovie() {
    return movie;
  }

  public Movie getMovie(Boolean returnCopy) {
    if (returnCopy) return movie;
    return movie;
  }

  public String getTitle() {
    return movie.getTitle();
  }

  public int getDaysRented() {
    return daysRented;
  }

  public DateTime getCreationDateTime() {
    return creationDateTime;
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
