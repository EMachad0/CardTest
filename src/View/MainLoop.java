package View;

import Controller.GeraDeck;
import Model.Card;
import Model.Deck;
import processing.core.PApplet;
import processing.core.PImage;

public class MainLoop extends PApplet {

    private Deck p1, p2;
    private static final int BORDA = 30;
    private PImage background;

    public void settings(){
        size(1366, 768);
    }

    @Override
    public void setup() {
        background(255);
        frameRate(60);

        GeraDeck GD = new GeraDeck(this);
        p1 = GD.gera(BORDA, BORDA);
        p2 = GD.gera(width-BORDA-Card.WIDTH, height-BORDA-Card.HEIGHT);

        setBackground();
        background(background);
    }

    public void draw(){
        image(background, 0, 0);

        p1.draw();
        p2.draw();


//        System.out.println("That was a frame");
    }

    private void setBackground() {
        background = loadImage("./Images/background.jpg");
        background.resize(width, height);
    }
}
