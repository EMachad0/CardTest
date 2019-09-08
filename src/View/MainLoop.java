package View;

import Controller.GeraDeck;
import Model.Button;
import Model.Card;
import Model.Deck;
import Model.Hand;
import processing.core.PApplet;
import processing.core.PImage;

public class MainLoop extends PApplet {

    private Deck deck1, deck2;
    private Hand p1, p2;
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
        deck1 = GD.gera(BORDA, BORDA);
        deck2 = GD.gera(width-BORDA-Card.WIDTH, height-BORDA-Card.HEIGHT);

        p1 = new Hand(this, deck1, 0);
        p2 = new Hand(this, deck2, 1);

        setBackground();
        background(background);
    }

    public void draw(){
        image(background, 0, 0);

        deck1.draw();
        deck2.draw();

        deck1.draw();//Actually enemy deck
        deck2.draw();//Our deck
      
        Button finish = new Button(1130 , 325,150,50, 255, true);
        finish.drawButton( this);

        Button drawDeck1 = new Button(deck1.getX() - 10 ,deck1.getX() - 10 , Card.WIDTH, Card.HEIGHT, 255, false);
        drawDeck1.drawButton(this);

        Button drawDeck2 = new Button(deck2.getX() + 10, deck2.getY() - 10, Card.WIDTH, Card.HEIGHT, 255, false);
        drawDeck2.drawButton(this);


        if (drawDeck1.clicked(this)){
            //TODO not Auto genereted method by @Korhal
        }
        if( drawDeck2.clicked(this)){
            //TODO not Auto genereted method by @Korhal
        }
    }
    private void setBackground() {
        background = loadImage("./Images/background.jpg");
        background.resize(width, height);
    }
}
