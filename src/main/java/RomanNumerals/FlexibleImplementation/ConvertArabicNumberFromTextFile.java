package RomanNumerals.FlexibleImplementation;

import RomanNumerals.FlexibleImplementation.Helpers.FileProcessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertArabicNumberFromTextFile implements Converter {

  private FileProcessor fileProcessor = new FileProcessor();
  private static final String REGEX_ACCEPT_DIGITS_AND_SPACES_ONLY = "[\\d\\s]+";

  public String convertRomaNumbersAndWriteToTextFile(String fileName, String resultFileName) {

    try {
      List<String> linesFromFile = fileProcessor.readLinesFromFile(fileName);
      List<String> resultLines = new ArrayList<>();
      for (String line : linesFromFile) {
        if (line.matches(REGEX_ACCEPT_DIGITS_AND_SPACES_ONLY)) {
          resultLines.add(convert(Integer.parseInt(line)));
        }
      }
      fileProcessor.writeLinesToFile(resultLines, resultFileName);
    } catch (IOException e) {
      e.printStackTrace();
      return "Process failed with the message " + e.getMessage();
    }

    return "Process succeed";
  }

  @Override
  public String convert(int arabicNumber) {
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
