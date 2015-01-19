public class a {
  public static CustomerBuilder customer = new CustomerBuilder();
  public static RentalBuilder rental = new RentalBuilder();
  public static MovieBuilder movie = new MovieBuilder();

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

    public CustomerBuilder w(Rental ... instances) {
      Rental[] rentals = new Rental[instances.length];
      for (int i = 0; i < instances.length; i++) {
        rentals[i] = instances[i];
      }
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

    RentalBuilder() {
      this(new MovieBuilder().build(), 3);
    }

    RentalBuilder(Movie movie, int days) {
      this.movie = movie;
      this.days = days;
    }

    public RentalBuilder w(MovieBuilder movie) {
      return new RentalBuilder(movie.build(), days);
    }

    public Rental build() {
      return new Rental(movie, days);
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
}
