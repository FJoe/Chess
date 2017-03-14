package chess;

public abstract class Piece {

	String color;
	int X, Y;
	boolean hasMoved = false;
	//used for en passant checks
	boolean hasMoved2 = false;

	public abstract boolean tryMove(int X, int Y, Piece[][] board);
	public abstract void move(int X, int Y, Piece[][] board);
	
	public Piece(String color, int X, int Y){
		this.color = color;
		this.X = X;
		this.Y = Y;
	}
}
