package View;

import processing.core.PApplet;

public class MainLoop extends PApplet {

    public void settings(){
        size(1060, 720);
    }

    @Override
    public void setup() {
        background(255);
        frameRate(60);
    }

    public void draw(){
        ellipse(mouseX, mouseY, 60, 60);
    }
}
