package elevator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class GenerateRandomElevatorTest {

  @Test
  void createElevator() {
    //given
    int numberOfElevators = 5;

    //when
    Map<Integer, Elevator> actualElevators = new GenerateRandomElevator().createElevators(numberOfElevators);

    //then
    assertThat(actualElevators.size(), is(5));
  }
}