package View;

import Model.Card;
import Model.Deck;
import processing.core.PApplet;
import processing.core.PImage;

public class MainLoop extends PApplet {

    private Deck p1;

    public void settings(){
        size(1060, 720);
    }

    @Override
    public void setup() {
        background(255);
        frameRate(60);

        p1 = criaDeck();

        background(loadImage("./Images/temporario.jpg"));
    }

    private Deck criaDeck() {
        Deck deck = new Deck(this, 10, 10);
        deck.add( new Card(this, 100, 100, "Nome"));
        return deck;
    }

    public void draw(){
        ellipse(mouseX, mouseY, 20, 20);

        p1.draw();
    }
}
