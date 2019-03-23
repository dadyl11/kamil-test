package elevator;

import java.util.Objects;

public class ElevatorRequest {
    private int requestFloor;
    private int targetFloor;

    public ElevatorRequest(int requestFloor, int targetFloor){
        this.requestFloor = requestFloor;
        this.targetFloor = targetFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ElevatorRequest that = (ElevatorRequest) o;
        return requestFloor == that.requestFloor &&
            targetFloor == that.targetFloor;
    }

    @Override
    public int hashCode() {

        return Objects.hash(requestFloor, targetFloor);
    }

    public int getRequestFloor() {
        return requestFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }
}