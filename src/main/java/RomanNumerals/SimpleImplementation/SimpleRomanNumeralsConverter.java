package RomanNumerals.SimpleImplementation;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SimpleRomanNumeralsConverter {

  static Map<Integer, String> units = new HashMap<>();

  static Map<Integer, String> tens = new HashMap<>();

  static Map<Integer, String> hundreds = new HashMap<>();

  static Map<Integer, String> thousands = new HashMap<>();

  public String convertIntToRoman(int number) {

    if ((number <= 0) || (number > 4000)) {
      throw new IllegalArgumentException(number + " is not in range (0,3999]");
    }

    feedTensMap(tens);
    feedUnitsMap(units);
    feedHundredsMap(hundreds);
    feedThousandsMap(thousands);

    StringBuilder result = new StringBuilder("");

    int[] array = returnArrayOfIntegers(number);

    result = concatenateStringsFromMaps(result, array);

    return result.toString();
  }

  private int[] returnArrayOfIntegers(int number) {
    String numberAsString = String.valueOf(number);
    return Stream.of(numberAsString.trim().split(""))
        .mapToInt(token -> Integer.parseInt(token))
        .toArray();
  }

  private StringBuilder concatenateStringsFromMaps(StringBuilder result, int[] array) {

    int arraySize = array.length;
    Map<Integer, Map> maps = createMapOfMaps();
    int counter = arraySize;
    for (int i = 0; i < arraySize; i++) {
      if (array[i] > 0 && array[i] < 4) {
        for (int j = 0; j < array[i]; j++) {
          result = result.append(maps.get(counter).get(1));
        }
      } else if (array[i] > 5 && array[i] < 9) {
        result = result.append(maps.get(counter).get(5));
        for (int j = 5; j < array[i]; j++) {
          result = result.append(maps.get(counter).get(1));
        }
      } else {
        result = result.append(maps.get(counter).get(array[i]));
      }
      counter--;
    }
    return result;
  }

  private void feedUnitsMap(Map<Integer, String> units) {
    units.put(1, "I");
    units.put(4, "IV");
    units.put(5, "V");
    units.put(9, "IX");
  }

  private void feedTensMap(Map<Integer, String> tens) {
    tens.put(1, "X");
    tens.put(4, "XL");
    tens.put(5, "L");
    tens.put(9, "XC");
  }


  private void feedHundredsMap(Map<Integer, String> hundreds) {
    hundreds.put(1, "C");
    hundreds.put(4, "CD");
    hundreds.put(5, "D");
    hundreds.put(9, "CM");
  }

  private void feedThousandsMap(Map<Integer, String> thousands) {
    thousands.put(1, "M");
  }

  private Map<Integer, Map> createMapOfMaps() {
    Map<Integer, Map> map = new HashMap<>();
    map.put(4, thousands);
    map.put(3, hundreds);
    map.put(2, tens);
    map.put(1, units);
    return map;
  }
}
