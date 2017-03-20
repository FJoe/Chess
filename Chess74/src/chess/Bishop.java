package chess;

/**
*This class constructs Pieces representing bishops
*@authors Dillon Heyck and Francis Joe
*/
public class Bishop extends Piece
{

	/**
	 * Creates a Bishop piece
	 * @param color Whether piece is black or white
	 * @param x starting x position
	 * @param y starting y position
	 */
	public Bishop(String color, int x, int y, Board board) {
		super(color, x, y, board);
	}

	public boolean tryMove(int x2, int y2) 
	{
		if(!tryMoveInit(x2,y2))
			return false;
		
		int xDif = Math.abs(x2 - this.x);
		int yDif = Math.abs(y2 - this.y);
		
		if(xDif != yDif)
			return false;
		
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
		
		Piece[][] board = this.board.board;
		
		for(int i = 1; i < xDif; i++)
			if(board[yStart + i][xStart + i] != null)
				return false;
		
		return true;
	}
	
	public String toString()
	{
		return "B";
	}

}
