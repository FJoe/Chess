package chess;

/**
 * Abstract class that all pieces (ie Pawn, rook) all extend as they all share 
 * same constructors and methods
 * @authors Dillon Heyck and Francis Joe
 *
 */
public abstract class Piece {

	String color;
	int x, y;
	boolean hasMoved = false;
	boolean hasMoved2 = false;

	/**
	 * Sees if the piece can move to a position on a board
	 * @param x x position to check
	 * @param y y position to check
	 * @param board board the piece tries to move to
	 * @return whether piece can move to desired position
	 */
	public abstract boolean tryMove(int x2, int y2, Piece[][] board);
	
	/**
	 * Moves piece to position
	 * @param x x position to move to
	 * @param y y position to move to
	 * @param board board the piece moves on
	 */
	public abstract void move(int x, int y, Piece[][] board);
	
	/**
	 * Constructor of Piece class
	 * @param color Whether piece is black or white
	 * @param x starting x position 
	 * @param y starting y position
	 */
	public Piece(String color, int x, int y){
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Checks whether position is out of bounds, the same position as current position, 
	 * or if a piece on the same team resides at the position. 
	 * Essentially, initial try move check that is common for all pieces
	 * @return preliminary determination of if piece can move to location
	 */
	protected boolean tryMoveInit(int x2, int y2, Piece[][] board)
	{
		if(x2 > 7 || x2 < 0)
			return false;
		if(y2 > 7 || y2 < 0)
			return false;
		
		if(this.x == x2 && this.y == y2)
			return false;
		
		if(board[y2][x2] != null && board[y2][x2].color.equals(this.color))
			return false;
		return true;
	}
}
