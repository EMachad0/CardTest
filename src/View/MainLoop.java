package View;

import processing.core.PApplet;

public class MainLoop extends PApplet {

    public void settings(){
        size(1060, 720);
    }

    public void draw(){
        background(0);
        ellipse(mouseX, mouseY, 20, 20);
    }
}
