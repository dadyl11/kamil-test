package elevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class GenerateRandomElevator {

  public Map<Integer, Elevator> createElevators(int numberOfElevators) {
    Map<Integer, Elevator> elevators = new HashMap<>();
    for (int i = 1; i <= numberOfElevators; i++) {
      Elevator elevator = new Elevator.ElevatorBuilder()
          .id(i)
          .currentFloor(i)
          .elevatorState(ElevatorState.getRandom())
          .upDestinationFloors(new TreeSet<>())
          .downDestinationFloors(new TreeSet<>())
          .elevatorInUse(true)
          .build();
      elevators.put(i, elevator);
    }
    return elevators;
  }
}
