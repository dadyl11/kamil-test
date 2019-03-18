package romanNumerals.flexibleImplementation.TestParameters;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class RomanToArabic implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
    return Stream.of(
        Arguments.of("I", 1),
        Arguments.of("II", 2),
        Arguments.of("III", 3),
        Arguments.of("IV", 4),
        Arguments.of("V", 5),
        Arguments.of("VI", 6),
        Arguments.of("IX", 9),
        Arguments.of("X", 10),
        Arguments.of("XIII", 13),
        Arguments.of("XV", 15),
        Arguments.of("XX", 20),
        Arguments.of("XXIV", 24),
        Arguments.of("XXV", 25),
        Arguments.of("XXVIII", 28),
        Arguments.of("XXIX", 29),
        Arguments.of("XXXVIII", 38),
        Arguments.of("XL", 40),
        Arguments.of("XLIX", 49),
        Arguments.of("L", 50),
        Arguments.of("LIV", 54),
        Arguments.of("LVI", 56),
        Arguments.of("LX", 60),
        Arguments.of("LXX", 70),
        Arguments.of("LXXV", 75),
        Arguments.of("LXXX", 80),
        Arguments.of("XC", 90),
        Arguments.of("C", 100),
        Arguments.of("CCIX", 209),
        Arguments.of("CCL", 250),
        Arguments.of("CD", 400),
        Arguments.of("D", 500),
        Arguments.of("DCCCXLIII", 843),
        Arguments.of("CM", 900),
        Arguments.of("CMXCIX", 999),
        Arguments.of("M", 1000),
        Arguments.of("MCMXCV", 1995),
        Arguments.of("MM", 2000),
        Arguments.of("MMDLXII", 2562),
        Arguments.of("MMM", 3000),
        Arguments.of("MMMCCLXXVI", 3276),
        Arguments.of("MMMCMXCIX", 3999)
    );
  }
}
