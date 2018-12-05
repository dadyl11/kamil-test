package RomanNumerals.FlexibleImplementation;

import RomanNumerals.FlexibleImplementation.Helpers.InputValidator;

public class ConvertArabicNumberToRoman implements Converter {

  private InputValidator inputValidator = new InputValidator();

  @Override
  public String convert(int arabicNumber) {

    inputValidator.validateNumber(arabicNumber);

    StringBuilder result = new StringBuilder();
    result.append(String.valueOf(new char[arabicNumber]).replace('\0', 'I')
        .replace("IIIII", "V")
        .replace("IIII", "IV")
        .replace("VV", "X")
        .replace("VIV", "IX")
        .replace("XXXXX", "L")
        .replace("XXXX", "XL")
        .replace("LL", "C")
        .replace("LXL", "XC")
        .replace("CCCCC", "D")
        .replace("CCCC", "CD")
        .replace("DD", "M")
        .replace("DCD", "CM"));
    return result.toString();
  }
}
