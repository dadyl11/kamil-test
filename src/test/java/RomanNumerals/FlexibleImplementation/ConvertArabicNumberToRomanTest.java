package RomanNumerals.FlexibleImplementation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import RomanNumerals.FlexibleImplementation.TestParameters.ArabicToRoman;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class ConvertArabicNumberToRomanTest {

  private ConvertArabicNumberToRoman romanNumeralsConverter = new ConvertArabicNumberToRoman();

  @ParameterizedTest
  @ArgumentsSource(ArabicToRoman.class)
  void shouldConvertRomanNumberToArabic(int arabicNumber, String romanNumber) {
    //given

    //when
    String actual = romanNumeralsConverter.convert(arabicNumber);

    //then
    assertThat(actual, is(romanNumber));
  }
}