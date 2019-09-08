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

    public void drawButton(PApplet view){
        if(fullfill) {
            view.rect(x,y,w,h);
            view.fill(rgb);
        }
    }

    public boolean clicked(PApplet mainLoop){
        if(mainLoop.mousePressed){
            return mainLoop.mouseX > x && mainLoop.mouseX < x + w && mainLoop.mouseY > y && mainLoop.mouseY < y + h;
        } else return false;
    }
}
