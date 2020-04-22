package schach;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Console input = new Console();
        input.open();
        Board test1 = new Board();
        test1.anzeigen();
    }
}
