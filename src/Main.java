import View.MainLoop;
import processing.core.PApplet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Machadooo");
        System.out.println("Me mamas tu otario");

        MainLoop ml = new MainLoop();
        PApplet.runSketch(new String[]{"CardGame"}, ml);
    }
}
