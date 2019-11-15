import java.util.Scanner;

public class TicTacToe {

    private char[][] gameBoard;
    private String winner;

    public TicTacToe()
    {
        gameBoard = new char[3][3];
        winner = "tie";

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
        gameBoard[0][2]='O';
        gameBoard[1][1]='O';
        gameBoard[1][2]='O';
        gameBoard[2][0]='O';
        gameBoard[2][1]='X';
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
            {
                winner = Character.toString(gameBoard[row][0]);
                return true;
            }
        }

        //check for a winner on a column
        for (int col = 0; col < gameBoard.length; col++)
        {
            if (gameBoard[0][col]==gameBoard[1][col]&&gameBoard[0][col]==gameBoard[2][col]
                    &&gameBoard[0][col]!=' ')
            {
                winner = Character.toString(gameBoard[0][col]);
                return true;
            }
        }

        //check for a winner on the diagonals
        if (gameBoard[0][0]==gameBoard[1][1]&&gameBoard[1][1]==gameBoard[2][2]
                &&gameBoard[0][0]!=' ')
        {
            winner = Character.toString(gameBoard[0][0]);
            return true;
        }

        if (gameBoard[0][2]==gameBoard[1][1]&&gameBoard[1][1]==gameBoard[2][0]
                &&gameBoard[1][1]!=' ')
        {
            winner = Character.toString(gameBoard[1][1]);
            return true;
        }

        //check for a full board, but no winner
        for (int row=0;row<gameBoard.length;row++)
        {
            for (int col=0; col<gameBoard[row].length;col++)
            {
                if (gameBoard[row][col]==' ')
                    return false;
            }
        }
        return true;
    }

    /**
     * This method will receive a players character ('X' or 'O') and
     * a row / col to place the character in.  It will validate that the
     * position is available
     */
    public void makeMove(char player, int row, int col)
    {
        //check if the position is available
        if (gameBoard[row-1][col-1] == ' ')
            gameBoard[row-1][col-1]=player;
        else
            throw new IllegalArgumentException(
                    String.format("position (%d,%d) is taken already",row,col));
    }

    /**
     * This method will call the appropriate methods to play the full
     * TicTacToe game
     */
    public void playGame()
    {
        for (int moveNum=1; moveNum<=9; moveNum++)
        {
            displayBoard();
            if (moveNum%2==0)
                getPlayerMove('X');
            else
                getPlayerMove('O');
            if (gameOver())
                break;
        }
    }

    /**
     * This method will ask a player to provide a move on the game board
     */
    public void getPlayerMove(char player)
    {
        System.out.printf("Player %c, enter a coordinate (i.e. 1,1): ",player);
        Scanner keyboard = new Scanner(System.in);
        String coordinates = keyboard.nextLine();

        //split the user input into an array of String objects
        String[] position = coordinates.split(",");
        int row= Integer.parseInt(position[0]);  //convert a String to an Int
        int col = Integer.parseInt(position[1]);

        try {
            makeMove(player, row, col);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            getPlayerMove(player);
        }

    }
}
