package Model;

import processing.core.PApplet;

import java.util.ArrayList;

public class Hand {

    private final PApplet view;

    private Deck deck;
    private ArrayList<Card> cards = new ArrayList<>();
    private int y;

    public Hand(PApplet view, Deck deck, int bot) {
        this.deck = deck;
        this.y = bot * (view.height-10-Card.HEIGHT);
        this.view = view;

        for(int i = 0; i < 5; i ++) {
            cards.add(deck.drawCard());
            cards.get(i).setVisibility(true);
        }
    }

    public void drawFromDeck() {
        Card card = deck.drawCard();
        card.setVisibility(true);
        cards.add(card);
    }

    public void draw(){
        final int space = 10;

        int x = (view.width - cards.size() * (Card.WIDTH + space) - space)/2;

        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).move(x + i * (Card.WIDTH + space), y, 5);
            cards.get(i).draw();
        }
    }
}
