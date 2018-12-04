package RomanNumerals.FlexibleImplementation;

public class ConvertRomanNumberToArabic {

  public int convert(String romanNumber) {
    StringBuilder result = new StringBuilder(romanNumber);
    result.append(String.valueOf(romanNumber)
        .replace("CM", "DCD")
        .replace("M", "DD")
        .replace("CD", "CCCC")
        .replace("D", "CCCCC")
        .replace("XC", "LXL")
        .replace("C", "LL")
        .replace("XL", "XXXX")
        .replace("L", "XXXXX")
        .replace("IX", "VIV")
        .replace("VV", "X")
        .replace("IV", "IIII")
        .replace("V", "IIIII"));
    return result.length();
  }
}
