/**
*This class constructs Pieces representing pawns
*@authors Dillon Heyck and Francis Joe
*/
package chess;

public class Pawn extends Piece
{

	boolean hasMoved = false;
	//Tracks if the pawn JUST moved two spaces
	
	public Pawn(String color, int X, int Y)
	{
		super(color, X, Y);
	}

	
	public void move(int X, int Y, Piece[][] board)
	{
		hasMoved = true;
		this.X = X;
		this.Y = Y;
		if(color.equals("white") && (Y - this.Y) == 2)
			hasMoved2 = true;
		else if(color.equals("black") && (this.Y - Y) == 2)
			hasMoved2 = true;
		else hasMoved2 = false;
	}
	
	public boolean tryMove(int X2, int Y2, Piece[][] board)
	{
		//This if-else cluster checks for moves where the
		//pawn is simply moving forward, and not diagonally
		if(color.equals("white"))
		{
			if((Y2 - Y) > 2 || (Y2 - Y) <= 0)
				return false;
			if(X != X2) //en passant check
			{
				if(board[X2][Y2] != null)
					return true;
				else if(((X2 - X) > 0) && board[X+1][Y] instanceof Pawn 
						&& board[X+1][Y].hasMoved2)
							return true;
				else if(((X - X2) > 0) && board[X+1][Y] instanceof Pawn 
						&& board[X-1][Y].hasMoved2)
							return true;
			}
			if(hasMoved && (Y2 - Y) > 1)
				return false;
			return true;
		} else
		{
			if((Y - Y2) > 2 || (Y - Y2) <= 0)
				return false;
			if(X != X2) //en passant check
			{
				if(board[X2][Y2] != null)
					return true;
				else if(((X2 - X) > 0) && board[X+1][Y] instanceof Pawn 
						&& board[X+1][Y].hasMoved2)
							return true;
				else if(((X - X2) > 0) && board[X+1][Y] instanceof Pawn 
						&& board[X-1][Y].hasMoved2)
							return true;
			}
			if(hasMoved && (Y - Y2) > 1)
				return false;
			return true;
		}
	}//end tryMove
	
	public String toString()
	{
		return "p";
	}


}
