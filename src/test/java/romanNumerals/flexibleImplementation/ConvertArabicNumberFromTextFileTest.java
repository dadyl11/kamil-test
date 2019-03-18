package romanNumerals.flexibleImplementation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ConvertArabicNumberFromTextFileTest {

  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder();

  @Test
  public void convertRomaNumbersAndWriteToTextFile() throws IOException {
    //given
    String inputFile = "romanNumberConverter/inputFileTest.txt";
    String outputFile = "romanNumberConverter/";
    List<String> expectedLines = Arrays.asList("I", "XIII", "XXV", "C", "CCL", "CM", "MD");
    File tempFile = tempFolder.newFile(outputFile);

    //when
    ConvertArabicNumberFromTextFile converterWithFile = new ConvertArabicNumberFromTextFile();
    converterWithFile.convertRomaNumbersAndWriteToTextFile(inputFile, tempFile.toString());
    List<String> linesFromFile = Files.readAllLines(tempFile.toPath());

    //then
    assertThat(linesFromFile, is(expectedLines));
  }
}