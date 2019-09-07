package View;

import Model.Card;
import Model.Deck;
import processing.core.PApplet;
import processing.core.PImage;

public class MainLoop extends PApplet {

    Deck p1;

    public void settings(){
        size(1060, 720);
    }

    @Override
    public void setup() {
        background(255);
        frameRate(60);

        p1 = criaDeck();
    }

    private Deck criaDeck() {
        Deck deck = new Deck(10, 10);

        Card c1 = new Card(100, 100, "Nome");
        c1.setBack(loadImage("./Images/cardback.jpg"));
        deck.add(c1);

        return deck;
    }

    public void draw(){
        PImage img;
        img = loadImage("./Images/temporario.jpg");
        background(img);
        ellipse(mouseX, mouseY, 60, 20);

        p1.draw();
    }
}
