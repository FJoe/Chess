/**
 * This is a game of chess that receives
 * input from a text file and visualizes the
 * game with basic ASCII.
 * @authors Dillon Heyck and Francis Joe
 */
package chess;


import java.util.Scanner;

public class Chess {
	
	private static Board game;

	/**
	 * Initiates playGame()
	 * @param args
	 */
	public static void main(String[] args){

		playGame();

	}

	/**
	 * Prints board and takes input from next player
	 */
	public static void playGame()
	{
		game = new Board();
		Piece[][] board = game.board;

		Scanner in = new Scanner(System.in);

		//0 = black player's move
		//1 = white player's move
		boolean moveType = true;

		//-1 = game continues
		//0 = black wins
		//1 = white wins
		//2 = draw
		int winner = -1;

		boolean draw = false;
		boolean newTurn = true;

		while(winner == -1)
		{
			if(newTurn)
			{
				game.printBoard();
			
				String otherTeam;
				Piece[] thisTeam;
				Piece[] opponentTeam;
				
				if(moveType)
				{
					thisTeam = game.whitePieces;
					opponentTeam = game.blackPieces;
				}
				else
				{
					thisTeam = game.blackPieces;
					opponentTeam = game.whitePieces;
				}
				if(isCheck(thisTeam, opponentTeam))
					System.out.println("Check");
			}
			
			if(moveType)
				System.out.println("White's move: ");
			else
				System.out.println("Black's move: ");

			String input = in.nextLine();

			if(input.equals("resign"))
			{
				if(moveType)
					winner = 0;
				else
					winner = 1;					
			}

			else if(input.equals("draw"))
			{
				if(draw)
					winner = 2;
				else
				{
					System.out.println("Illegal move, try again");
					newTurn = false;
				}
			}

			else
			{
				int[] moveset = translateFileRank(input);
				int startX = moveset[0];
				int startY = moveset[1];
				int endX = moveset[2];
				int endY = moveset[3];

				Piece toMove = board[startY][startX];
				if(toMove != null)
				{
//					if((moveType && toMove.color.equals("black")) || 
//							(!moveType && toMove.color.equals("white")))
//					{
//						System.out.println("Illegal move, try again");
//						newTurn = false;
//					}
//					else
					{
						if(toMove.tryMove(endX, endY) && !wouldBeCheck(toMove, endX, endY))
						{
							toMove.move(endX, endY);
							newTurn = true;

							if(moveset[4] == 1)
								draw = true;
							else
								draw = false;
								
							moveType = !moveType;

						}
						else
						{
							System.out.println("Illegal move, try again");
							newTurn = false;
						}					}
				}
				else
				{
					System.out.println("Illegal move, try again");
					newTurn = false;
				}
			}
		}

		//end while loop

		if(winner == 0)
			System.out.println("Black wins!");
		else if(winner == 1)
			System.out.println("White wins!");
		else if(winner == 2)
			System.out.println("Draw");
		
		in.close();
	}//end playGame()
	
	/**
	 * Check whether team in given parameter is in check
	 * @param teamToCheck team to check
	 * @return if in check or not
	 */
	static boolean isCheck(Piece[] teamToCheck, Piece[] opponentTeam)
	{
		Piece thisKing = teamToCheck[Board.PIECESKINGPOS];
			
		for(int i = 0; i < 16; i++)
			if(opponentTeam[i] != null && opponentTeam[i].tryMove(thisKing.x, thisKing.y))
				return true;
		
		return false;
	}
	
	/**
	 * Checks if the given piece is moved to x2,y2 then if its team will be in check
	 * @param toMove piece to move
	 * @param x2 x position to move to
	 * @param y2 y position to move to
	 * @return if team is in check if it moves given piee to x2,y2
	 */
	static boolean wouldBeCheck(Piece toMove, int x2, int y2)
	{
		Piece[] teamScenario;
		Piece[] otherTeam;
		if(toMove.color.equals("black"))
		{
			teamScenario = game.blackPieces;
			otherTeam = game.whitePieces;
		}
		else
		{
			teamScenario = game.whitePieces;
			otherTeam = game.blackPieces;
		}
		
		Piece wasRemoved = game.board[y2][x2];
		int origX = toMove.x;
		int origY = toMove.y;
		boolean hasMovedPrev = toMove.hasMoved;
		boolean hasMoved2Prev = toMove.hasMoved2;
		
		Piece rookCastling;
		if(toMove instanceof King && ((King)toMove).canCastle(x2, y2))
		{
			
		}
		
		toMove.move(x2, y2);
		boolean toReturn = isCheck(teamScenario, otherTeam);
		

		
		toMove.move(origX, origY);
		toMove.hasMoved = hasMovedPrev;
		toMove.hasMoved2 = hasMoved2Prev;
		game.board[y2][x2] = wasRemoved;
		int i = 0;
		while(i < 16 && otherTeam[i] != null)
			i++;
		if(i < 16)
			otherTeam[i] = wasRemoved;
		
		return toReturn;	
	}
	

	/**
	 * translateFileRank
	 * Converts file/rank array numbering into the 
	 * numbering convention for arrays in programming
	 * Also checks if there is draw at the end
	 * @param oldFR inputed file/rank
	 * @return int[] appropriate row/column for board and whether draw is called
	 */
	static int[] translateFileRank(String oldFR)
	{
		int[] newFR = new int[5];
		newFR[0] = ((int) oldFR.charAt(0)) - 97;
		newFR[1] = Math.abs(Integer.parseInt(oldFR.charAt(1) + "") - 8);
		newFR[2] = ((int) oldFR.charAt(3)) - 97;
		newFR[3] = Math.abs(Integer.parseInt(oldFR.charAt(4) + "") - 8);

		if(oldFR.endsWith("draw?"))
			newFR[4] = 1;

		return newFR;
	}
}
