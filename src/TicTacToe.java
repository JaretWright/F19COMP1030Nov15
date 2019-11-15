public class TicTacToe {

    private char[][] gameBoard;

    public TicTacToe()
    {
        gameBoard = new char[3][3];

        //put a space character in every position of the gameBoard
        for (int row=0; row<gameBoard.length;row++)
            for (int col=0;col<gameBoard[row].length;col++)
                gameBoard[row][col]=' ';
    }

    /**
     * This method is an example of the game played
     * between Jaret and Skyler
     */
    public void createSkylerGame()
    {
        gameBoard[0][0]='X';
        gameBoard[0][1]='X';
        gameBoard[0][2]='X';
        gameBoard[1][1]='O';
        gameBoard[1][2]='O';
        gameBoard[2][0]='O';
        gameBoard[2][2]='X';
    }

    /**
     * This method will display the current gameBoard
     */
    public void displayBoard()
    {
        for (int row=0; row<gameBoard.length; row++)
        {
            for (int col=0; col<gameBoard[row].length; col++)
            {
                System.out.printf(" %c %s", gameBoard[row][col], (col!=2)?"|":"");
            }
            System.out.printf("\n%s%n",(row!=2)?"------------":"");
        }
    }
}
