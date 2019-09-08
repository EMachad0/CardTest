package Model;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private PApplet view;
    private ArrayList<Card> deck = new ArrayList<>();
    private int x;
    private int y;

    public Deck(PApplet view, int x, int y) {
        this.view = view;
        this.x = x;
        this.y = y;
    }

    public void add(Card card) {
        card.move(x, y, 1);
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
        final int space = 3;
        int i = 0;
        for (int c = 0; c < deck.size() && c < 8; c++, i += (x > view.width/2)? space : -space) {
            deck.get(c).move(x+i, y-Math.abs(i), 1);
            deck.get(c).draw();
        }
    }
}
