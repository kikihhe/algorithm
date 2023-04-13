package 作业.作业四;

public class Bug {
//    Current position
    private int position;
//    Direction of movement
    private String direction;

    public Bug(int initialPosition) {
        position = initialPosition;
        direction = "right";
    }
//  Initialization direction
    public void turn() {
        if (direction.equals("right")) {
            direction = "left";
        } else {
            direction = "right";
        }
    }

//    Move it, left or right
    public void move() {
        if (direction.equals("right")) {
            position++;
        } else {
            position--;
        }
    }

    public int getPosition() {
        return position;
    }

    public String toString() {
        return "position: " + position + ", direction: " + direction;
    }
}