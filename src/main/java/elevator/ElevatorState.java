package elevator;

public enum ElevatorState {

  GOINGUP,
  GOINGDOWN,
  IDLE;

  public static ElevatorState getRandom() {
    return values()[(int) (Math.random() * values().length)];
  }
}
