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
	
	public Board()
	{
		
		board = new Piece[8][8];
		
		for(int i = 0; i < 8; i++)
		{
			board[1][i] = new Pawn("black", 1, i);
			board[6][i] = new Pawn("white", 6, i);
		}
	}
	
	/**
	 *printBoard()
	 *
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
						System.out.print("## ");
					else
						System.out.print("   ");
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
