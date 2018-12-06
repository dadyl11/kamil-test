package RomanNumerals.FlexibleImplementation.TestParameters;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class ArabicToRoman implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
    return Stream.of(
        Arguments.of(1, "I"),
        Arguments.of(2, "II"),
        Arguments.of(3, "III"),
        Arguments.of(4, "IV"),
        Arguments.of(5, "V"),
        Arguments.of(6, "VI"),
        Arguments.of(9, "IX"),
        Arguments.of(10, "X"),
        Arguments.of(13, "XIII"),
        Arguments.of(15, "XV"),
        Arguments.of(20, "XX"),
        Arguments.of(24, "XXIV"),
        Arguments.of(28, "XXVIII"),
        Arguments.of(29, "XXIX"),
        Arguments.of(38, "XXXVIII"),
        Arguments.of(40, "XL"),
        Arguments.of(49, "XLIX"),
        Arguments.of(50, "L"),
        Arguments.of(56, "LVI"),
        Arguments.of(60, "LX"),
        Arguments.of(70, "LXX"),
        Arguments.of(80, "LXXX"),
        Arguments.of(90, "XC"),
        Arguments.of(100, "C"),
        Arguments.of(209, "CCIX"),
        Arguments.of(250, "CCL"),
        Arguments.of(400, "CD"),
        Arguments.of(500, "D"),
        Arguments.of(843, "DCCCXLIII"),
        Arguments.of(900, "CM"),
        Arguments.of(999, "CMXCIX"),
        Arguments.of(1000, "M"),
        Arguments.of(1995, "MCMXCV"),
        Arguments.of(2000, "MM"),
        Arguments.of(2562, "MMDLXII"),
        Arguments.of(3000, "MMM"),
        Arguments.of(3276, "MMMCCLXXVI"),
        Arguments.of(3999, "MMMCMXCIX")
    );
  }
}
