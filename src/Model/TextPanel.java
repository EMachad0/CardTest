package Model;

import processing.core.PApplet;
import processing.core.PFont;

public class TextPanel {
    private int x;
    private int y;
    private int fontSize;
    private int speed;
    private String txt;
    private PApplet view;
    PFont font;

    public TextPanel(int x, int y, String txt, PApplet view, int fontSize) {
        this.x = x;
        this.y = y;
        this.txt = txt;
        this.view = view;
        //this.font = font;
        this.fontSize = fontSize;
    }

    void setup() {
        view.size(480, 120);
        view.smooth();
        font = view.loadFont("ArialMT-48.vlw");
        view.textFont(font);
    }
    public void draw() {
        view.textSize(fontSize);
        view.text("Korhal foda", 25, y);
        view.textSize(fontSize);
        int i = 0;
        for (int c = 0; c < 8; c++, i ++) {
            move(x + i);
        }
    }

    public void move(int mx){
        if (Math.abs(mx - x) < speed) x = mx;
        if (mx != x) x += (x > mx)? -speed : speed;

        for(; x < mx; x++){
            view.text("We Believe You Can", x, y);
        }
    }
}
