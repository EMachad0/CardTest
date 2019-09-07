package View;

import processing.core.PApplet;
import processing.core.PImage;

public class MainLoop extends PApplet {

    public void settings(){
        size(1060, 720);
    }

    @Override
    public void setup() {
        super.setup();
    }

    public void draw(){
        PImage img;
        img = loadImage("./Images/temporario.jpg");
        background(img);
        ellipse(mouseX, mouseY, 20, 20);
    }
}
