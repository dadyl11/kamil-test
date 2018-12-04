package RomanNumerals.FlexibleImplementation;

public class ConvertRomanNumberToArabic implements Converter {

  @Override
  public String convert(int romanNumber) {
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
    return String.valueOf(result.length());
  }

  public int convertRomanNumberToIntiger(int romanNumber){
    return Integer.parseInt(convert(romanNumber));
  }
}
