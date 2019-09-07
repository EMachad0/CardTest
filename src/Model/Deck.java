package Model;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private PApplet view;
    private ArrayList<Card> deck = new ArrayList<>();
    private int x = 0;
    private int y = 0;
    private final int WIDTH = 150;
    private final int HEIGHT = 200;

    public Deck(PApplet view, int x, int y) {
        this.view = view;
        this.x = x;
        this.y = y;
    }

    public void add(Card card) {
        deck.add(card);
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        Card aux = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return aux;
    }

    public void draw() {
        deck.forEach(c -> view.image(c.getBack(), x, y, WIDTH, HEIGHT));
    }

}
