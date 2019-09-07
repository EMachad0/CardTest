package Model;

import processing.core.PApplet;
import processing.core.PImage;

public class Card extends PApplet {
    private int health;
    private int attack;
    private String txt;
    private PImage img;

    public Card(int health, int attack, String txt) {
        this.health = health;
        this.attack = attack;
        this.txt = txt;
        img = loadImage("cardSla.jpeg");
    }
}
