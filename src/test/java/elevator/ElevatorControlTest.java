package elevator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElevatorControlTest {

  @BeforeEach
  public void beforeMethod() {
    int numberOfElevators = 8;
    Map<Integer, Elevator> actualElevators = new GenerateRandomElevator().createElevators(numberOfElevators);
    new ElevatorControl().assignRequest(new ElevatorRequest(5, 9));
    new ElevatorControl().assignRequest(new ElevatorRequest(5, 9));
  }

  @Test
  public void assignRequest() {
    //given
    int minUp = Integer.MAX_VALUE;
    Elevator minUpElevator = null;
    int minDown = Integer.MAX_VALUE;
    Elevator minDownElevator = null;

    //when
    boolean test3 = new ElevatorControl().assignRequest(new ElevatorRequest(5, 9));

    //then
    assertTrue(test3);
  }

  @Test
  void initializeElevators() {
    //given
    int numberOfElevators = 6;

    //when
    Map<Integer, Elevator> actualElevators = new GenerateRandomElevator().createElevators(numberOfElevators);

    //then
    assertThat(actualElevators.size(), is(6));
  }
}