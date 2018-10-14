package at.htl.robot.gui;

import at.htl.robot.model.Direction;
import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    private Robot robot;
    private Direction direction = Direction.SOUTH;

    private int leftMargin = 50;
    private int upperMargin = 50;
    private int boxLength = 50;

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/
        frameRate(120);
        robot = new Robot();
        robot.setX(1);
        robot.setY(1);
    }

    public void draw() {

        writeText();

        drawTable();

        drawRobot(robot);
    }

    private void writeText() {
        textSize(20);
        text("<f> stepForward       <l> rotateLeft       <m> changeMode", boxLength * 0.5f, boxLength * 0.6f);

    }

    private void drawTable() {
        strokeWeight(1.1f);

        for (int i = 0; i < 11; i++) {
            line(leftMargin, upperMargin + i * boxLength, leftMargin + 10 * boxLength, upperMargin + i * boxLength);
            line(leftMargin + i * boxLength, upperMargin, leftMargin + i * boxLength, upperMargin + 10 * boxLength);
        }
    }

    private void drawRobot(Robot robot) {

        int boxCenterX = leftMargin + robot.getX() * boxLength - boxLength / 2;
        int boxCenterY = upperMargin + robot.getY() * boxLength - boxLength / 2;

        strokeWeight(1);

        ellipse(boxCenterX, boxCenterY, (int) (boxLength * 0.8), (int) (boxLength * 0.8));

//        drawRobotText();
    }

//    private void drawRobotText() {
//
//        int boxCenterX = leftMargin + robot.getX() * boxLength - boxLength / 2;
//        int boxCenterY = upperMargin + robot.getY() * boxLength - boxLength / 2;
//
//        if (robot.teleport  && direction == Direction.SOUTH) {
//            rotate(180);
//            text("T", boxCenterX, boxCenterY);
//        }
//    }

    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
            robot.stepForward();
            System.out.println("X = " + robot.getX());
            System.out.println("Y = " + robot.getY());
            background(209);
        } else if (key == 'l' || key == 'L') {
            robot.rotateLeft();
            background(209);
        } else if (key == 'm' || key == 'M') {
            if (robot.teleport){
                robot.teleport = false;
            } else if (!robot.teleport){
                robot.teleport = true;
            }
            System.out.println(robot.teleport);
        }

    }

    public void keyTyped() {
        println("typed " + key + " " + keyCode);
    }

    public void keyReleased() {
        println("released " + key + " " + keyCode);
    }

}