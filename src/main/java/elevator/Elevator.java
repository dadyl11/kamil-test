package elevator;

import java.util.Objects;
import java.util.TreeSet;

public class Elevator {

  private int id;
  private int currentFloor;
  private ElevatorState elevatorState;
  private TreeSet<Integer> upDestinationFloors;
  private TreeSet<Integer> downDestinationFloors;
  private boolean elevatorInUse;

  public Elevator(int id) {
    this.id = id;
  }

  public Elevator() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCurrentFloor() {
    return currentFloor;
  }

  public void setCurrentFloor(int currentFloor) {
    this.currentFloor = currentFloor;
  }

  public ElevatorState getDirection() {
    return elevatorState;
  }

  public void setElevatorState(ElevatorState elevatorState) {
    this.elevatorState = elevatorState;
  }

  public TreeSet<Integer> getUpDestinationFloors() {
    return upDestinationFloors;
  }

  public TreeSet<Integer> getDownDestinationFloors() {
    return downDestinationFloors;
  }

  public boolean getIsElevatorInUse() {
    return elevatorInUse;
  }

//  public Elevator(int id, int currentFloor) {
//    this.id = id;
//    this.currentFloor = currentFloor;
//    this.elevatorState = ElevatorState.IDLE;
//    this.upDestinationFloors = new TreeSet<Integer>();
//    this.downDestinationFloors = new TreeSet<Integer>(new Comparator<Integer>() {
//      public int compare(Integer object1, Integer object2) {
//        return object2.compareTo(object1);
//      }
//    });
//    this.elevatorInUse = elevatorInUse;
//  }

  public void update(Elevator elevator) {

  }

  public ElevatorState checkCurrentState() {
    if (upDestinationFloors.size() > 0 && this.currentFloor < upDestinationFloors.first()) {
      return ElevatorState.GOINGUP;
    } else if (downDestinationFloors.size() > 0 && this.currentFloor > downDestinationFloors.first()) {
      return ElevatorState.GOINGDOWN;
    } else {
      return ElevatorState.IDLE;
    }
  }

  public void addNewDestinatoins(ElevatorRequest elevatorRequest, int directionNumber) {
    if (directionNumber == 1) {
      upDestinationFloors.add(elevatorRequest.getRequestFloor());
      upDestinationFloors.add(elevatorRequest.getTargetFloor());
    } else {
      downDestinationFloors.add(elevatorRequest.getRequestFloor());
      downDestinationFloors.add(elevatorRequest.getTargetFloor());
    }
  }

  //  public int getTotalRequests() {
//    return upDestinationFloors.size() + downDestinationFloors.size();
//  }
  public void moveAndCheckIfServed() {
    if (checkCurrentState() == ElevatorState.GOINGUP) {
      if (upDestinationFloors.first() == currentFloor) {
        popUpDestination();
      } else {
        currentFloor++;
      }
    } else if (checkCurrentState() == ElevatorState.GOINGDOWN) {
      if (downDestinationFloors.first() == currentFloor) {
        popDownDestination();
      } else {
        currentFloor--;
      }
    } else {
      //Do Nothing. Elevator is not moving.
    }
  }

  private void popUpDestination() {
    upDestinationFloors.pollFirst();
    if (upDestinationFloors.size() == 0) {
      this.setElevatorState(ElevatorState.IDLE);
    }
  }

  private void popDownDestination() {
    downDestinationFloors.pollLast();
    if (downDestinationFloors.size() == 0) {
      this.setElevatorState(ElevatorState.IDLE);
    }
  }

  public int getTotalRequests() {
    return upDestinationFloors.size() + downDestinationFloors.size();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Elevator elevator = (Elevator) object;
    return getId() == elevator.getId();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Elevator: " + this.getId()).append(" | Current Floor: " + this.getCurrentFloor())
        .append(" | Direction: " + this.getDirection());
    return stringBuilder.toString();
  }

  public static class ElevatorBuilder {

    Elevator elevator = new Elevator();

    public ElevatorBuilder id(int id) {
      elevator.id = id;
      return this;
    }

    public ElevatorBuilder currentFloor(int currentFloor) {
      elevator.currentFloor = currentFloor;
      return this;
    }

    public ElevatorBuilder elevatorState(ElevatorState elevatorState) {
      elevator.elevatorState = elevatorState;
      return this;
    }

    public ElevatorBuilder upDestinationFloors(TreeSet<Integer> upDestinationFloors) {
      elevator.upDestinationFloors = upDestinationFloors;
      return this;
    }

    public ElevatorBuilder downDestinationFloors(TreeSet<Integer> downDestinationFloors) {
      elevator.downDestinationFloors = downDestinationFloors;
      return this;
    }

    public ElevatorBuilder elevatorInUse(boolean elevatorInUse) {
      elevator.elevatorInUse = elevatorInUse;
      return this;
    }

    public Elevator build() {
      return elevator;
    }
  }
}
