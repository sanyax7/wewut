package wewut.test;

import java.util.Map;
import java.util.HashMap;

import org.joda.time.DateTimeUtils;
import org.joda.time.DateTime;

import wewut.*;

public class a {
  public static CustomerBuilder customer = new CustomerBuilder();
  public static RentalBuilder rental = new RentalBuilder();
  public static MovieBuilder movie = new MovieBuilder();
  public static StoreBuilder store = new StoreBuilder();
  public static MoneyBuilder money = new MoneyBuilder();

  public static class CustomerBuilder {
    Rental[] rentals;
    String name;

    CustomerBuilder() {
      this("Jim", new Rental[0]);
    }

    CustomerBuilder(String name, Rental[] rentals) {
      this.name = name;
      this.rentals = rentals;
    }

    public CustomerBuilder w(RentalBuilder ... builders) {
      Rental[] rentals = new Rental[builders.length];
      for (int i = 0; i < builders.length; i++) {
        rentals[i] = builders[i].build();
      }
      return new CustomerBuilder(name, rentals);
    }

    public CustomerBuilder w(Rental ... rentals) {
      return new CustomerBuilder(name, rentals);
    }

    public CustomerBuilder w(String name) {
      return new CustomerBuilder(name, rentals);
    }

    public Customer build() {
      Customer result = new Customer(name);
      for (Rental rental : rentals) {
        result.addRental(rental);
      }
      return result;
    }
  }

  public static class RentalBuilder {
    final Movie movie;
    final int days;
    final DateTime creationDateTime;

    RentalBuilder() {
      this(new MovieBuilder().build(), 3, new DateTime(/*HACK*/1000/*HACK*/));
    }

    RentalBuilder(Movie movie, int days, DateTime creationDateTime) {
      this.movie = movie;
      this.days = days;
      this.creationDateTime = creationDateTime;
    }

    public RentalBuilder w(MovieBuilder movie) {
      return new RentalBuilder(movie.build(), days, creationDateTime);
    }

    public RentalBuilder w(Movie movie) {
      return new RentalBuilder(movie, days, creationDateTime);
    }

    public RentalBuilder w(DateTime creationDateTime) {
      return new RentalBuilder(movie, days, creationDateTime);
    }

    public Rental build() {
      return new Rental(movie, days, creationDateTime);
    }
  }

  public static class MovieBuilder {
    final String name;
    final Movie.Type type;

    MovieBuilder() {
      this("Godfather 4", Movie.Type.NEW_RELEASE);
    }

    MovieBuilder(String name, Movie.Type type) {
      this.name = name;
      this.type = type;
    }

    public MovieBuilder w(Movie.Type type) {
      return new MovieBuilder(name, type);
    }

    public MovieBuilder w(String name) {
      return new MovieBuilder(name, type);
    }
    
    public Movie build() {
      return new Movie(name, type);
    }
  }

  public static class StoreBuilder {
    final Map<Movie, Integer> movies;

    StoreBuilder() {
      this(new HashMap<Movie, Integer>());
    }

    StoreBuilder(Map<Movie, Integer> movies) {
      this.movies = movies;
    }

    public StoreBuilder w(Movie movie) {
      Map movies = new HashMap<Movie, Integer>();
      movies.put(movie, 1);
      return new StoreBuilder(movies);
    }

    public StoreBuilder w(Movie movie1, Movie movie2) {
      Map movies = new HashMap<Movie, Integer>();
      movies.put(movie1, 2); // hack
      return new StoreBuilder(movies);
    }

    public Store build() {
      return new Store(movies);
    }
  }

  public static class MoneyBuilder {
    final double val;

    MoneyBuilder() {
      this(1.0);
    }

    MoneyBuilder(double val) {
      this.val = val;
    }

    public MoneyBuilder w(double val) {
      return new MoneyBuilder(val);
    }

    public Money build() {
      return new Money(val);
    }

  }
}
