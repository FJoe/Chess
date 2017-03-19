/**
 * class Board is used to represent a
 * chess board composed of a 2D array of pieces
 * from the class Piece.
 * @authors Dillon Heyck and Francis Joe
 */
package chess;

public class Board
{

	public Piece[][] board;
	
	
	/**
	 * Creates a board filled with pieces at appropriate locations
	 */
	public Board()
	{
		
		board = new Piece[8][8];
		
		for(int i = 0; i < 8; i++)
		{
			board[1][i] = new Pawn("black", 1, i, board);
			board[6][i] = new Pawn("white", 6, i, board);
		}
		board[0][0] = new Rook("black", 0, 0, board);
		board[0][7] = new Rook("black", 7, 0, board);
		board[7][0] = new Rook("white", 0, 7, board);
		board[7][7] = new Rook("white", 7, 7, board);
		
		board[0][1] = new Knight("black", 1, 0, board);
		board[0][6] = new Knight("black", 6, 0, board);
		board[7][1] = new Knight("white", 1, 7, board);
		board[7][6] = new Knight("white", 6, 7, board);

		board[0][2] = new Bishop("black", 2, 0, board);
		board[0][5] = new Bishop("black", 5, 0, board);
		board[7][2] = new Bishop("white", 2, 7, board);
		board[7][5] = new Bishop("white", 2, 7, board);
		
		board[0][3] = new Queen("black", 3, 0, board);
		board[7][3] = new Queen("white", 3, 7, board);
		
		board[0][4] = new King("black", 4, 0, board);
		board[7][4] = new King("white", 4, 7, board);
	}
	
	/**
	 *Traverses board to print text representation
	 */
	public void printBoard()
	{
		int rowNum = 8;
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//check if the space on the board does not
				//have a piece
				if(board[i][j] == null)
				{
					if((i + j)%2 == 0)
						System.out.print("   ");
					else
						System.out.print("## ");
				} else //case where space is occupied by a piece
				{
					System.out.print(board[i][j].color.charAt(0));
					System.out.print(board[i][j] + " ");
				}
			}//end inner for loop
			
			System.out.print(rowNum);
			System.out.println();
			rowNum--;
		}//end outer for loop
		
		System.out.println(" a  b  c  d  e  f  g  h");
	}//end printBoard()
}
