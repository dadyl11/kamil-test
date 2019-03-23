package elevator;

import java.util.Map;

public class ElevatorsSimulation {

  public static void main(String[] args) {

    ElevatorControl elevatorControl = new ElevatorControl();
    Map<Integer, Elevator> elevatorsMap =  elevatorControl.initializeElevators(4);
    System.out.println("16 Elevators initialized");
    ElevatorRequest elevatorRequest1 = new ElevatorRequest(5, 9);
    ElevatorRequest elevatorRequest2 = new ElevatorRequest(5, 7);
    ElevatorRequest elevatorRequest3 = new ElevatorRequest(6, 9);
    ElevatorRequest elevatorRequest4 = new ElevatorRequest(5, 1);
    ElevatorRequest elevatorRequest5 = new ElevatorRequest(6, 1);

    System.out.println("5 Requests prepared");
    for (Elevator elevator : elevatorsMap.values()) {
      System.out.println(elevator.toString());
      System.out.println(elevator.getUpDestinationFloors().toString());
    }

    elevatorControl.assignRequest(elevatorRequest1);
    elevatorControl.assignRequest(elevatorRequest2);
    elevatorControl.assignRequest(elevatorRequest3);
    elevatorControl.assignRequest(elevatorRequest4);
    elevatorControl.assignRequest(elevatorRequest5);


    System.out.println("Two requests assigned");

    for (Elevator elevator : elevatorsMap.values()) {
      System.out.println(elevator.toString());
      System.out.println(elevator.getUpDestinationFloors().toString());
    }
    elevatorControl.step();
    for (Elevator elevator : elevatorsMap.values()) {
      System.out.println(elevator.toString());
      System.out.println(elevator.getUpDestinationFloors().toString());
    }
    elevatorControl.step();
    elevatorControl.step();
    for (Elevator elevator : elevatorsMap.values()) {
      System.out.println(elevator.toString());
      System.out.println(elevator.getUpDestinationFloors().toString());
    }
  }

}