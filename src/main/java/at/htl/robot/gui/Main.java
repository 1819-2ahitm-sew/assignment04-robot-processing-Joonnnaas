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
        robot = new Robot();
        robot.setX(1);
        robot.setY(1);



    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {

        strokeWeight(1.2f);

        for (int i = 0; i < 11; i++) {
            line(leftMargin, upperMargin + i * boxLength, leftMargin + 10 * boxLength, upperMargin + i * boxLength);
            line(leftMargin + i * boxLength, upperMargin, leftMargin + i * boxLength, upperMargin + 10 * boxLength);
        }

        strokeWeight(1);

        int boxCenterX = leftMargin + robot.getX() * boxLength - boxLength / 2;
        int boxCenterY = upperMargin + robot.getY() * boxLength - boxLength / 2;

        ellipse(boxCenterX,
                boxCenterY,
                (int) (boxLength * 0.8),
                (int) (boxLength * 0.8));


    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {


    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {

    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
        robot.stepForward();
        } else if (key == 'l' || key == 'L') {
        robot.rotateLeft();
        }

    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }

}
