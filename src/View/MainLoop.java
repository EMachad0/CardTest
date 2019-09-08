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
    private Button finish = new Button(1130 , 325,150,50, 255, true, this);
    private Button drawDeck1;
    private Button drawDeck2;

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

        drawDeck1 = new Button(deck1.getX() - 10 ,deck1.getX() - 10 , Card.WIDTH, Card.HEIGHT, 255, false, this);
        drawDeck2 = new Button(deck2.getX() + 10, deck2.getY() - 10, Card.WIDTH, Card.HEIGHT, 255, false, this);

        setBackground();
        background(background);
    }

    public void draw(){
        image(background, 0, 0);

        deck1.draw(); //Actually enemy deck
        deck2.draw(); //Our deck

        p1.draw();    //Actually enemy hand
        p2.draw();    //Our hand

        drawDeck1.drawButton();
        drawDeck2.drawButton();

    }

    private void setBackground() {
        background = loadImage("./Images/background.jpg");
        background.resize(width, height);
    }

    @Override
    public void mouseClicked() {
        if (drawDeck1.clicked()) p1.drawFromDeck();
        if (drawDeck2.clicked()) p2.drawFromDeck();
    }

    @Override
    public void mousePressed() {
        p1.clicked();
        p2.clicked();
    }

    @Override
    public void mouseDragged() {
        p1.drag();
        p2.drag();
    }

    @Override
    public void mouseReleased() {
        p1.reset();
        p2.reset();
    }
}
