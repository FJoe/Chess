package chess;

/**
*This class constructs Pieces representing queens
*@authors Dillon Heyck and Francis Joe
*/
public class Queen extends Piece
{

	/**
	 * Creates a queen piece
	 * @param color Whether piece is black or white
	 * @param x starting x position
	 * @param y starting y position
	 */
	public Queen(String color, int x, int y, Piece[][] board) {
		super(color, x, y, board);
	}

	public boolean tryMove(int x2, int y2) 
	{
		if(!tryMoveInit(x2,y2))
			return false;
		
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
		
		int xDif = Math.abs(x2 - this.x);
		int yDif = Math.abs(y2 - this.y);
		
		if(xDif == yDif)
		{		
			int xStart;
			int yStart;
			
			if(x2 < this.x)
				xStart = x2;
			else
				xStart = this.x;
			
			if(y2 < this.y)
				yStart = y2;
			else
				yStart = this.y;
			
			for(int i = 1; i < xDif; i++)
				if(board[yStart + i][xStart + i] != null)
					return false;
		}
		return true;
	}

	public void move(int x, int y) {
		board[this.y][this.x] = null;
		hasMoved = true;
		this.x = x;
		this.y = y;
		board[y][x] = this;
	}
	
	public String toString()
	{
		return "Q";
	}

}
