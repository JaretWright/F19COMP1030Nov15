public class PlayingTicTacToe {
    public static void main(String[] args)
    {
        TicTacToe game=new TicTacToe();
        game.createSkylerGame();
        game.displayBoard();
        System.out.printf("There is a winner: %b%n", game.gameOver());
    }
}
