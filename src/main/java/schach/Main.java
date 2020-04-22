package schach;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Console input = new Console();
        input.open();
        Board board = new Board();
        board.initializeBoard();
        System.out.println(board.Feld);
    }
}
