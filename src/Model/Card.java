package Model;

import processing.core.PApplet;
import processing.core.PImage;

public class Card {

    //cards mantain a h = 1.4 W ratio
    public static final int WIDTH = 100;
    public static final int HEIGHT = (int) (1.4*WIDTH);

    private boolean show = false;
    private int health;
    private int attack;
    private String name;

    private final PApplet view;
    private PImage front;
    private PImage back;

    public Card(PApplet view, int health, int attack, String txt) {
        this.view = view;
        this.health = health;
        this.attack = attack;
        this.name = txt;

        loadImg();
    }

    void draw(int x, int y) {
        view.pushMatrix();
        view.translate(x, y);

        if (show) view.image(front, 0, 0, WIDTH, HEIGHT);
        else view.image(back, 0, 0, WIDTH, HEIGHT);

        view.popMatrix();
    }

    private void loadImg() {
        PImage back = view.loadImage("./Images/cardback.jpg");
        back.resize(WIDTH, HEIGHT);
        this.back = back;

        PImage front = view.loadImage("./Images/cardfront.jpg");
        front.resize(WIDTH, HEIGHT);
        this.front = front;
    }

    public void setVisibility(boolean show) {
        this.show = show;
    }
}
