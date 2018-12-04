package RomanNumerals.SimpleImplementation;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SimpleRomanNumeralsConverter {

  Map<Integer, String> units = new HashMap<>();

  Map<Integer, String> tens = new HashMap<>();

  Map<Integer, String> hundreds = new HashMap<>();

  Map<Integer, String> thousands = new HashMap<>();


  String convertIntToRoman(int number) {

    if ((number <= 0) || (number > 4000)) {
      throw new IllegalArgumentException(number + " is not in range (0,4000]");
    }

    feedTensMap();
    feedUnitsMap(units);
    feedHundredsMap();
    feedThousandsMap();

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


  private Map<Integer, String> feedTensMap() {
    tens.put(0, "");
    tens.put(1, "X");
    tens.put(2, "XX");
    tens.put(3, "XXX");
    tens.put(4, "XL");
    tens.put(5, "L");
    tens.put(6, "LX");
    tens.put(7, "LXX");
    tens.put(8, "LXXX");
    tens.put(9, "XC");
    return tens;
  }


  private Map<Integer, String> feedHundredsMap() {
    hundreds.put(0, "");
    hundreds.put(1, "C");
    hundreds.put(2, "CC");
    hundreds.put(3, "CCC");
    hundreds.put(4, "CD");
    hundreds.put(5, "D");
    hundreds.put(6, "DC");
    hundreds.put(7, "DCC");
    hundreds.put(8, "DCCC");
    hundreds.put(9, "CM");
    return hundreds;
  }

  private void feedUnitsMap(Map<Integer, String> units) {
    units.put(0, "");
    units.put(1, "I");
    units.put(2, "II");
    units.put(3, "III");
    units.put(4, "IV");
    units.put(5, "V");
    units.put(6, "VI");
    units.put(7, "VII");
    units.put(8, "VIII");
    units.put(9, "IX");
    //return units;
  }

  private Map<Integer, String> feedThousandsMap() {
    thousands.put(1, "M");
    thousands.put(2, "MM");
    thousands.put(3, "MMM");
    return thousands;
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
