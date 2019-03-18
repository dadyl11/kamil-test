package romanNumerals.simpleImplementation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SimpleRomanNumeralsConverterTest {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  private SimpleRomanNumeralsConverter romanNumeralsConverter = new SimpleRomanNumeralsConverter();

  @Test
  @Parameters(method = "numbers")
  public void shouldConvertIntegersToRomanNumerals(int arabicNumber, String romanNumber) {
    //given

    //when
    String test = romanNumeralsConverter.convertIntToRoman(arabicNumber);

    //then
    assertThat(test, is(romanNumber));
  }

  private Object[] numbers() {
    return new Object[]{
        new Object[]{1, "I"},
        new Object[]{2, "II"},
        new Object[]{3, "III"},
        new Object[]{4, "IV"},
        new Object[]{5, "V"},
        new Object[]{6, "VI"},
        new Object[]{9, "IX"},
        new Object[]{10, "X"},
        new Object[]{13, "XIII"},
        new Object[]{15, "XV"},
        new Object[]{20, "XX"},
        new Object[]{24, "XXIV"},
        new Object[]{28, "XXVIII"},
        new Object[]{29, "XXIX"},
        new Object[]{38, "XXXVIII"},
        new Object[]{40, "XL"},
        new Object[]{49, "XLIX"},
        new Object[]{50, "L"},
        new Object[]{56, "LVI"},
        new Object[]{60, "LX"},
        new Object[]{70, "LXX"},
        new Object[]{80, "LXXX"},
        new Object[]{90, "XC"},
        new Object[]{100, "C"},
        new Object[]{209, "CCIX"},
        new Object[]{250, "CCL"},
        new Object[]{400, "CD"},
        new Object[]{500, "D"},
        new Object[]{843, "DCCCXLIII"},
        new Object[]{900, "CM"},
        new Object[]{999, "CMXCIX"},
        new Object[]{1000, "M"},
        new Object[]{1995, "MCMXCV"},
        new Object[]{2000, "MM"},
        new Object[]{2562, "MMDLXII"},
        new Object[]{3000, "MMM"},
        new Object[]{3276, "MMMCCLXXVI"},
        new Object[]{3999, "MMMCMXCIX"}
    };
  }
}