package Model;

import processing.core.PApplet;
import processing.core.PFont;

public class TextPanel {
    private PFont font;
    private int x=27;
    private PApplet view;

    public TextPanel(PApplet view) {
        this.view = view;
    }

    public void setup() {
        view.smooth();
        /*
        font = view.loadFont("ArialMT-48.vlw");
        view.textFont(font);*/
    }
    public void draw(int mx) {
        while(x != mx){
            view.textSize(36);
            view.text("Korhal Foda", 25, 60);
            view.textSize(18);
            view.text("We Believe You Can", x, 90);
            x = x+1;
        }
    }
}
