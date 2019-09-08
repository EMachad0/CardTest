package Model;

import processing.core.PApplet;

public class Button {
    private float x;
    private float y;
    private float w;
    private float h;
    private int rgb;
    private boolean fullfill;

    public Button(float x, float y, float w, float h, int rgb, boolean fullfill) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rgb = rgb;
        this.fullfill = fullfill;
    }

    public void drawButton(PApplet mainLoop){

        if(fullfill) {
            mainLoop.rect(x,y,w,h);
            mainLoop.fill(rgb);
        }
    }

    public boolean clicked(PApplet mainLoop){
        if(mainLoop.mousePressed){
            if(mainLoop.mouseX > x && mainLoop.mouseX < x + w && mainLoop.mouseY > y && mainLoop.mouseY < y + h){
                mainLoop.fill(0);
                //do stuff
                return true;
            }
            else return false;
        } else return false;
    }
}
