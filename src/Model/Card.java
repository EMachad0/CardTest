package Model;

import processing.core.PApplet;
import processing.core.PImage;

public class Card extends PApplet {
    private int health;
    private int attack;
    private String name;
    private PImage img;

    public Card(int health, int attack, String txt) {
        this.health = health;
        this.attack = attack;
        this.name = txt;
        img = loadImage("cardSla.jpeg");
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

    public PImage getImg() {
        return img;
    }

    public void setImg(PImage img) {
        this.img = img;
    }
}
