package RomanNumerals.FlexibleImplementation;

public class ConvertRomanNumberToArabic {

  public int convert(String romanNumber) {
    return romanNumber
        .replace("CM", "DCD")
        .replace("M", "DD")
        .replace("CD", "CCCC")
        .replace("D", "CCCCC")
        .replace("XC", "LXL")
        .replace("C", "LL")
        .replace("XL", "XXXX")
        .replace("L", "XXXXX")
        .replace("IX", "VIV")
        .replace("X", "VV")
        .replace("IV", "IIII")
        .replace("V", "IIIII").length();
  }
}
