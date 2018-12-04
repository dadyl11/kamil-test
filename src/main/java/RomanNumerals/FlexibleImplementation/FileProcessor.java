package RomanNumerals.FlexibleImplementation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {

  public List<String> readLinesFromFile(String fileName) {
    List<String> lines = new ArrayList<>();
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream input = classLoader.getResourceAsStream(fileName);
    Scanner scanner = new Scanner(input);
    while (scanner.hasNextLine()) {
      lines.add(scanner.nextLine());
    }
    scanner.close();
    return lines;
  }

  public void writeLinesToFile(List<String> resultLines, String resultFileName) throws IOException {
    Writer writer = new FileWriter(new File(resultFileName));
    for (String line : resultLines) {
      writer.write(line + "\n");
    }
    writer.close();
  }
}
