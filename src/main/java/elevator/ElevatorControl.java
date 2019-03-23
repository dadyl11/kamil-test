package elevator;

import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ElevatorControl {

  private static final int MAX_REQUESTS_PER_ELEVATOR = 4;
  protected ConcurrentLinkedQueue<ElevatorRequest> waitingRequests = new ConcurrentLinkedQueue<>();
  GenerateRandomElevator generateRandomElevator = new GenerateRandomElevator();
  public Map<Integer, Elevator> elevatorsMap;

  public Map<Integer, Elevator> initializeElevators(int numberOfElevators) {
    elevatorsMap = generateRandomElevator.createElevators(numberOfElevators);
    return elevatorsMap;
  }

  public boolean assignRequest(ElevatorRequest elevatorRequest) {
    int minUp = Integer.MAX_VALUE;
    Elevator minUpElevator = null;
    int minDown = Integer.MAX_VALUE;
    Elevator minDownElevator = null;
    if (!waitingRequests.isEmpty()) {
      waitingRequests.add(elevatorRequest);
      elevatorRequest = waitingRequests.poll();
    }
    int requestedFloor = elevatorRequest.getRequestFloor();
    int targetFloor = elevatorRequest.getTargetFloor();

    for (Elevator elevator : elevatorsMap.values()) {

      if (elevator.getIsElevatorInUse() == false || elevator.getTotalRequests() > MAX_REQUESTS_PER_ELEVATOR) {
        continue;
      }
      if ((elevator.checkCurrentState() == ElevatorState.GOINGUP
          || elevator.getDirection() == ElevatorState.IDLE)
          && elevator.getCurrentFloor() < requestedFloor && targetFloor > requestedFloor) {
        if (minUp > requestedFloor - elevator.getCurrentFloor()) {
          minUp = requestedFloor - elevator.getCurrentFloor();
          minUpElevator = elevator;
        }
      } else if ((elevator.checkCurrentState() == ElevatorState.GOINGDOWN
          || elevator.checkCurrentState() == ElevatorState.IDLE)
          && elevator.getCurrentFloor() > requestedFloor && targetFloor < requestedFloor) {
        if (minDown > elevator.getCurrentFloor() - requestedFloor) {
          minDown = elevator.getCurrentFloor() - requestedFloor;
          minDownElevator = elevator;
        }
      }
    }
    if (minUpElevator != null) {
      minUpElevator.addNewDestinatoins(elevatorRequest, 1);
    } else if (minDownElevator != null) {
      minDownElevator.addNewDestinatoins(elevatorRequest, -1);
    } else {
      waitingRequests.add(elevatorRequest);
    }
    return true;
  }

  public void step() {
    for (Elevator elevator : elevatorsMap.values()) {
      elevator.moveAndCheckIfServed();
      elevatorsMap.put(elevator.getId(), elevator);
    }
  }
}

