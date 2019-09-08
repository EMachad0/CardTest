package Model;

import processing.core.PApplet;

public class Button {
    private float x;
    private float y;
    private float w;
    private float h;
    private int rgb;
    private boolean transparent;
    private PApplet view;
    private boolean clicked = false;

    public Button(float x, float y, float w, float h, int rgb, boolean fullfill, PApplet view) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rgb = rgb;
        this.transparent = fullfill;
        this.view = view;
    }
  
    public void drawButton(){

        if(transparent) {
            view.rect(x,y,w,h);
            view.fill(rgb);
        }
    }

   public boolean MouseIsOver() {
        if(view.mouseX > x && view.mouseX < x + w && view.mouseY > y && view.mouseY < y + h){
            //do stuff
            if (!clicked) {
                clicked = true;
                return true;
            }
        }
        return false;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
