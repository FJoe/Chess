package chess;

/**
*This class constructs pieces representing kings
*@authors Dillon Heyck and Francis Joe
*/
public class King extends Piece
{

	/**
	 * Creates a King piece
	 * @param color Whether piece is black or white
	 * @param x starting x position
	 * @param y starting y position
	 */
	public King(String color, int x, int y, Piece[][] board) {
		super(color, x, y, board);
	}

	public boolean tryMove(int x2, int y2) 
	{
		if(!tryMoveInit(x2,y2))
			return false;
		
		int xDif = Math.abs(x2 - this.x);
		int yDif = Math.abs(y2 - this.y);
		
		if((xDif < 2) && (yDif < 2))
			return true;
		return false;
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
		return "K";
	}

}
