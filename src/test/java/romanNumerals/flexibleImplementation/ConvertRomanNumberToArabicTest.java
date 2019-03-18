package RomanNumerals.FlexibleImplementation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import RomanNumerals.FlexibleImplementation.TestParameters.RomanToArabic;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class ConvertRomanNumberToArabicTest {

  private ConvertRomanNumberToArabic romanNumeralsConverter = new ConvertRomanNumberToArabic();

  @ParameterizedTest
  @ArgumentsSource(RomanToArabic.class)
  void shouldConvertRomanNumberToArabic(String romanNumber, int arabicNumber) {
    //given

    //when
    int actual = romanNumeralsConverter.convert(romanNumber);

    //then
    assertThat(actual, is(arabicNumber));
  }
}