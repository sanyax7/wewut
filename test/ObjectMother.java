public class ObjectMother {
  public static Customer
  customerWithOneOfEachRentalType(
    String name) {
    Customer result =
      customerWithOneNewReleaseAndOneRegular(
        name);
    result.addRental(
      new Rental(
        new Movie("Lion King", Movie.Type.CHILDREN), 3));
    return result;
  }

  public static Customer
  customerWithOneNewReleaseAndOneRegular(
    String n) {
    Customer result =
      customerWithOneNewRelease(n);
    result.addRental(
      new Rental(
        new Movie("Scarface", Movie.Type.REGULAR), 3));
    return result;
  }

  public static Customer
  customerWithOneNewRelease(
    String name) {
    Customer result =
      customerWithNoRentals(name);
    result.addRental(
      new Rental(
        new Movie(
          "Godfather 4", Movie.Type.NEW_RELEASE), 3));
    return result;
  }

  public static Customer
  customerWithNoRentals(String name) {
    return new Customer(name);
  }
}
