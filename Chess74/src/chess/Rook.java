package chess;

public class Rook extends Piece
{
	public Rook(String color, int x, int y){
		super(color, x, y);
	}

	public boolean tryMove(int x2, int y2, Piece[][] board) {
		if(this.X == x2 && this.Y == y2)
			return false;
		if(this.X != x2 && this.Y != y2)
			return false;
		if(board[x2][y2] != null && board[x2][y2].color.equals(this.color))
			return false;
		
		if(this.X == x2){
			int init;
			int end;
			if(this.Y > y2)
			{
				init = y2;
				end = this.Y;
			}
			else
			{
				init = y2;
				end = this.Y;
			}
			
			for(int i = init; i < end; i++)
			{
				if(board[x2][i] != null)
					return false;
			}
		}
		else
		{
			int init;
			int end;
			if(this.X > x2)
			{
				init = x2;
				end = this.X;
			}
			else
			{
				init = x2;
				end = this.X;
			}
			
			for(int i = init; i < end; i++)
			{
				if(board[i][x2] != null)
					return false;
			}
		}
		
		return true;
	}

	public void move(int X, int Y, Piece[][] board) {
		
	}
	
	public String toString()
	{
		return "r";
	}
}
