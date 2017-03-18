package chess;

/**
*This class constructs Pieces representing rooks
*@authors Dillon Heyck and Francis Joe
*/
public class Rook extends Piece
{
	/**
	 * Creates a Pawn piece
	 * @param color Whether piece is black or white
	 * @param x starting x position
	 * @param y starting y position
	 */
	public Rook(String color, int x, int y){
		super(color, x, y);
	}

	
	public boolean tryMove(int x2, int y2, Piece[][] board) {
		if(!tryMoveInit(x2,y2,board))
			return false;
		
		//Checks if another piece is in between start and end positions
		if(this.x == x2){
			int init;
			int end;
			if(this.y > y2)
			{
				init = y2 + 1;
				end = this.y;
			}
			else
			{
				init = this.y + 1;
				end = y2;
			}
			
			for(int i = init; i < end; i++)
			{
				if(board[i][x2] != null)
					return false;
			}
		}
		else if(this.y == y2)
		{
			int init;
			int end;
			if(this.x > x2)
			{
				init = x2 + 1;
				end = this.x;
			}
			else
			{
				init = this.x + 1;
				end = x2;
			}
			
			for(int i = init; i < end; i++)
				if(board[y2][i] != null)
					return false;
		}
		//End pos is not a legal move rooks can make
		else 
		{
			return false;

		}
		
		return true;
	}

	public void move(int x, int y, Piece[][] board) 
	{
		board[this.y][this.x] = null;
		hasMoved = true;
		this.x = x;
		this.y = y;
		board[y][x] = this;
	}
	
	public String toString()
	{
		return "r";
	}
}
