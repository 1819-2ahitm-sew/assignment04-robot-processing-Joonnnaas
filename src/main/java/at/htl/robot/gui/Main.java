package at.htl.robot.gui;

import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    int leftMargin = 50;
    int upperMargin = 50;
    int boxLength = 50;
    Robot robot;

    // Hier die Member-Attribute eintragen

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/
        frameRate(360);
        robot = new Robot();
        robot.setX(1);
        robot.setY(1);

    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {

        drawTable();



        drawRobot(robot);





    }

    private void drawTable() {
        strokeWeight(1.1f);

        for (int i = 0; i < 11; i++) {
            line(leftMargin, upperMargin + i * boxLength, leftMargin + 10 * boxLength, upperMargin + i * boxLength);
            line(leftMargin + i * boxLength, upperMargin, leftMargin + i * boxLength, upperMargin + 10 * boxLength);
        }
    }

    public void drawRobot(Robot robot) {

        strokeWeight(1);

        int boxCenterX = leftMargin + robot.getX() * boxLength - boxLength / 2;
        int boxCenterY = upperMargin + robot.getY() * boxLength - boxLength / 2;

        ellipse(boxCenterX,
                boxCenterY,
                (int) (boxLength * 0.8),
                (int) (boxLength * 0.8));
    }

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
            robot.changeMode(robot.teleport);
        }

    }

    public void keyTyped() {
        println("typed " + key + " " + keyCode);
    }

    public void keyReleased() {
        println("released " + key + " " + keyCode);
    }

}
