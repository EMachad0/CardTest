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

   public boolean clicked() {
       return view.mouseX > x && view.mouseX < x + w && view.mouseY > y && view.mouseY < y + h;
   }

}
