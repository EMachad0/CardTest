package Model;

import processing.core.PApplet;

import java.util.ArrayList;

public class Hand {

    private final PApplet view;

    private Deck deck;
    private ArrayList<Card> cards = new ArrayList<>();
    private int y;
    private int x;

    private static final int SPACE = 10;
    private static final int HARD_START = 5;
    private boolean init = true;

    public int getSize(){
        return cards.size();
    }

    public Hand(PApplet view, Deck deck, int bot) {
        this.view = view;
        this.deck = deck;
        this.y = bot * (view.height-10-Card.HEIGHT);
    }

    public void drawFromDeck() {
        if (!deck.isEmpty() && cards.size() < 7) {
            Card card = deck.drawCard();
            card.setVisibility(true);
            cards.add(card);

            move();
        }
    }

    public void draw() {
        if (init) init();

        for (Card card : cards) {
            card.draw();
        }
    }

    private void init() {
        if (cards.size() < HARD_START) {
            if (view.frameCount % 30 == 0) {
                drawFromDeck();
            }
        } else init = false;
    }

    public void drag() {
        for (Card c : cards) c.drag();
    }

    private void move() {
        x = (view.width - cards.size() * (Card.WIDTH + SPACE) - SPACE) / 2;
        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).move(x + i * (Card.WIDTH + SPACE), y, (init) ? 15 : 5);
        }
    }
    private void move(int speed) {
        x = (view.width - cards.size() * (Card.WIDTH + SPACE) - SPACE) / 2;
        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).move(x + i * (Card.WIDTH + SPACE), y, speed);
        }
    }

    public void reset() {
        move(25);
    }

    public void clicked() {
        for (Card c : cards) c.clicked();
    }
}
