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
        gameBoard[0][1]='O';
        gameBoard[0][2]='X';
        gameBoard[1][1]='O';
        gameBoard[1][2]='O';
        gameBoard[2][0]='O';
        gameBoard[2][1]='O';
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

    /**
     * This will check for a winner
     */
    public boolean gameOver() {
        //check for a winner on a row
        for (int row = 0; row < gameBoard.length; row++)
        {
            if (gameBoard[row][0]==gameBoard[row][1]&&gameBoard[row][0]==gameBoard[row][2]
                    &&gameBoard[row][0]!=' ')
                return true;
        }

        //check for a winner on a column
        for (int col = 0; col < gameBoard.length; col++)
        {
            if (gameBoard[0][col]==gameBoard[1][col]&&gameBoard[0][col]==gameBoard[2][col]
                    &&gameBoard[0][col]!=' ')
                return true;
        }

        //check for a winner on the diagonals
        if (gameBoard[0][0]==gameBoard[1][1]&&gameBoard[1][1]==gameBoard[2][2]
                &&gameBoard[0][0]!=' ')
            return true;

        if (gameBoard[0][2]==gameBoard[1][1]&&gameBoard[1][1]==gameBoard[2][0]
                &&gameBoard[1][1]!=' ')
            return true;



        return false;


    }
}
