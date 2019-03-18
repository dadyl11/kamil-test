package romanNumerals.flexibleImplementation.helpers;

public class InputValidator {

  public void validateNumber(int number) {
    if ((number <= 0) || (number > 4000)) {
      throw new IllegalArgumentException(number + " is not in range (0,4000]");
    }
  }
}
