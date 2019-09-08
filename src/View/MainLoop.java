package View;

import Controller.GeraDeck;
import Model.Button;
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
        System.out.println(width-BORDA-Card.WIDTH + " " + (height-BORDA-Card.HEIGHT));

        setBackground();
        background(background);
    }

    public void draw(){
        image(background, 0, 0);

        p1.draw();
        p2.draw();
        Button finish = new Button(1130 , 325,150,50, 255, true);
        finish.drawButton( this);
        Button a = new Button(p1.getX(), p1.getY(), 150, 100, 255, false);
        a.drawButton(this);
//        System.out.println("That was a frame");

        if (a.clicked(this)){
            System.out.println("A");
        }
    }
    private void setBackground() {
        background = loadImage("./Images/background.jpg");
        background.resize(width, height);
    }
}
