package Model;

import processing.core.PApplet;
import processing.core.PImage;

public class Card extends PApplet {
    private int health;
    private int attack;
    private String name;
    private PImage front;
    private PImage back;

    public Card(int health, int attack, String txt) {
        this.health = health;
        this.attack = attack;
        this.name = txt;

        front = loadImage("cardfront.jpeg");
        back = loadImage("cardback.jpeg");
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PImage getFront() {
        return front;
    }

    public void setFront(PImage front) {
        this.front = front;
    }

    public PImage getBack() {
        return back;
    }

    public void setBack(PImage back) {
        this.back = back;
    }
}
