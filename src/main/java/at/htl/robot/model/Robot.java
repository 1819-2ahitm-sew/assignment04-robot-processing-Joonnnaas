package at.htl.robot.model;

import static at.htl.robot.model.Direction.*;

public class Robot {
    private int y = 1;
    private int x = 1;
    public Direction direction = Direction.SOUTH;
    public boolean teleport = false;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void stepForward() {

            if (teleport) {
                teleport();
                goForward();
            } else if (!teleport) {
                if (wantAway()){
                    goForward();
                }
            }
    }

    public void rotateLeft() {
            switch (this.direction) {
                case SOUTH:
                    this.direction = Direction.EAST;
                    break;
                case NORTH:
                    this.direction = Direction.WEST;
                    break;
                case EAST:
                    this.direction = NORTH;
                    break;
                case WEST:
                    this.direction = Direction.SOUTH;
                    break;
            }
        }

    private void teleport() {

        if (getX() == 1 && getY() == 10 && this.direction == SOUTH) {
            setY(0);
        } else if (getX() == 1 && getY() == 1 && this.direction == NORTH) {
            setY(11);
        } else if (getX() == 10 && getY() == 10 && this.direction == SOUTH) {
            setY(0);
        } else if (getX() == 10 && getY() == 1 && this.direction == EAST) {
            setX(0);
        }

        for (int i = 1; i <= 10; i++) {
            if (getX() == 1 && getY() == i && this.direction == WEST) {
                setX(11);
            } else if (getX() == 10 && getY() == i && this.direction == EAST) {
                setX(0);
            }
        }

        for (int i = 1; i <= 10; i++) {
            if (getY() == 1 && getX() == i && this.direction == NORTH) {
                setY(11);
            } else if (getY() == 10 && getY() == i && this.direction == SOUTH) {
                setY(0);
            }
        }
    }

    private void goForward() {
        switch (this.direction) {
            case SOUTH:
                y++;
                break;
            case NORTH:
                y--;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
        }
    }

    private boolean wantAway() {

        boolean stepForwad = true;

            if (getX() == 1 && getY() == 1 && (this.direction == NORTH || this.direction == WEST)) {
                stepForwad = false;
            } else if (getX() == 1 && getY() == 10 && (this.direction == NORTH || this.direction == NORTH)) {
                stepForwad = false;
            } else if (getX() == 10 && getY() == 10 && (this.direction == EAST || this.direction == SOUTH)) {
                stepForwad = false;
            } else if (getX() == 10 && getY() == 1 && (this.direction == NORTH || this.direction == EAST)) {
                stepForwad = false;
            }

            for (int i = 1; i <= 10; i++) {
                if (getX() == 1 && getY() == i && this.direction == WEST) {
                    stepForwad = false;
                } else if (getX() == 10 && getY() == i && this.direction == EAST) {
                    stepForwad = false;
                }
            }

            for (int i = 1; i <= 10; i++) {
                if (getY() == 1 && getX() == i && this.direction == NORTH) {
                    stepForwad = false;
                } else if (getY() == 10 && getY() == i && this.direction == SOUTH) {
                    stepForwad = false;
                }
            }

        return stepForwad;
        }

}