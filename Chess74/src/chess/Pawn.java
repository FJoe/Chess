/**
*This class constructs Pieces representing pawns
*@authors Dillon Heyck and Francis Joe
*/
package chess;

public class Pawn extends Piece
{
	
	/**
	 * Creates a Pawn piece
	 * @param color Whether piece is black or white
	 * @param x starting x position
	 * @param y starting y position
	 */
	public Pawn(String color, int x, int y, Board board)
	{
		super(color, x, y, board);
	}

	
	public void move(int x, int y)
	{
		super.move(x, y);

		if(color.equals("white") && (this.y - y) == 2)
			hasMoved2 = true;
		else if(color.equals("black") && (y - this.y) == 2)
			hasMoved2 = true;
		else hasMoved2 = false;
		
		if(color.equals("white") && y == 0)
			;//WHITE PICKS WHAT PAWN BECOMES
		else if(color.equals("black") && y == 7)
			;//BLACK PICKS WHAT PAWN BECOMES
	}
	
	public boolean tryMove(int x2, int y2)
	{
		if(!tryMoveInit(x2,y2))
			return false;

		Piece[][] board = this.board.board;
		
		//This if-else cluster checks for moves where the
		//pawn is simply moving forward, and not diagonally
		if(color.equals("black"))
		{
			if((y2 - y) > 2 || (y2 - y) <= 0)
			{
				return false;
			}
			if(x != x2) //en passant check
			{
				if(board[y2][x2] != null)
					return true;
				else if(((x2 - x) > 0) && board[y][x+1] instanceof Pawn 
						&& board[y][x+1].hasMoved2)
							return true;
				else if(((x - x2) > 0) && board[y][x+1] instanceof Pawn 
						&& board[y][x-1].hasMoved2)
							return true;
				else
					return false;
			}
			if(hasMoved && (y2 - y) > 1)
				return false;
			else if(board[y+1][x] != null)
				return false;
			return true;
		} else
		{
			if((y - y2) > 2 || (y - y2) <= 0)
				return false;
			if(x != x2) //en passant check
			{
				if(board[y2][x2] != null)
					return true;
				else if(((x2 - x) > 0) && board[y][x+1] instanceof Pawn 
						&& board[x+1][y].hasMoved2)
							return true;
				else if(((x - x2) > 0) && board[y][x+1] instanceof Pawn 
						&& board[y][x-1].hasMoved2)
							return true;
				else
					return false;
			}
			if(hasMoved && (y - y2) > 1)
				return false;
			if(board[y-1][x] != null)
				return false;
			return true;
		}
	}//end tryMove
	
	public String toString()
	{
		return "p";
	}


}
