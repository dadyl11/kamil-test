package RomanNumerals.FlexibleImplementation.TestParameters;

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
        Arguments.of("X", 10),
        Arguments.of("XV", 15),
        Arguments.of("XXIV", 24),
        Arguments.of("L", 50),
        Arguments.of("LXX", 70)
    );
  }
}
