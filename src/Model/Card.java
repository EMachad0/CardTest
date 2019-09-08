package Model;

import processing.core.PApplet;
import processing.core.PImage;

public class Card implements Cloneable{

    //cards mantain a h = 1.4 W ratio
    public static final int WIDTH = 100;
    public static final int HEIGHT = (int) (1.4*WIDTH);

    //animation
    private boolean show = false;
    private int x = -1;
    private int y = -1;
    private int mx;
    private int my;
    private int speed;

    //status
    private int health;
    private int attack;
    private String name;

    //Processing
    private final PApplet view;
    private PImage front;
    private PImage back;

    public Card(PApplet view, int health, int attack, String img, String txt) {
        this.view = view;
        this.health = health;
        this.attack = attack;
        this.name = txt;

        loadImg("./Images/cards/" + img);
    }
    public Card(PApplet view, int health, int attack, String txt) {
        this.view = view;
        this.health = health;
        this.attack = attack;
        this.name = txt;

        loadImg("./Images/cardfront.jpg");
    }

    void draw() {
        view.pushMatrix();
        view.translate(x, y);

        if (show) view.image(front, 0, 0, WIDTH, HEIGHT);
        else view.image(back, 0, 0, WIDTH, HEIGHT);

        view.popMatrix();

        if (Math.abs(mx - x) < speed) x = mx;
        if (mx != x) x += (x > mx)? -speed : speed;
        if (Math.abs(my - y) < speed) y = my;
        if (my != y) y += (y > my)? -speed : speed;

//        if (show) System.out.println(x + " " + mx + " " + y + " "+ my + " " + name);
    }

    void drag() {
        if (x <= view.mouseX && view.mouseX <= x + WIDTH && y <= view.mouseY && view.mouseY <= y + HEIGHT) {
            move(view.mouseX - WIDTH/2, view.mouseY - HEIGHT/2, 300);
        }
    }

    void move(int x, int y, int speed) {
        this.speed = speed;
        if (this.x == -1) this.x = x;
        else this.mx = x;
        if (this.y == -1) this.y = y;
        else this.my = y;
    }

    private void loadImg(String path) {
        PImage back = view.loadImage("./Images/cardback.jpg");
        back.resize(WIDTH, HEIGHT);
        this.back = back;

        PImage front = view.loadImage(path);
        front.resize(WIDTH, HEIGHT);
        this.front = front;
    }

    void setVisibility(boolean show) {
        this.show = show;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
