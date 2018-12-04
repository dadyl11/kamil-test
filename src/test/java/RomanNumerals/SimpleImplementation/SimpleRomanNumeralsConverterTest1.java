package RomanNumerals.SimpleImplementation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.matcher.ElementMatcher.Junction;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
class SimpleRomanNumeralsConverterTest1 {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  private SimpleRomanNumeralsConverter romanNumeralsConverter = new SimpleRomanNumeralsConverter();

  @Test
  @Parameters(method = "numbers")
  void shouldConvertIntegersToRomanNumerals(int arabicNumber, String romanNumber) {
    //given

    //when
    String actualRomanNumber = romanNumeralsConverter.convertIntToRoman(arabicNumber);

    //then
    assertThat(actualRomanNumber, is(romanNumber));
  }

  private Object[] number(){
    return new Object[]{
        new Object[]{1, "I"}
    };
  }
}