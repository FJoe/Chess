/**
 * This is a game of chess that receives
 * input from a text file and visualizes the
 * game with basic ASCII.
 * @authors Dillon Heyck and Francis Joe
 */
package chess;


import java.util.Scanner;

public class Chess {
	
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
		Board game = new Board();
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
				
		while(winner == -1)
		{
			game.printBoard();
			
			boolean thisTurn = true;
			while(thisTurn)
			{
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
					
					thisTurn = false;
				}
				
				else if(input.equals("draw"))
				{
					if(draw)
					{
						winner = 2;
						thisTurn = false;
					}
					else
						System.out.println("Illegal move, try again");
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
						if((moveType && toMove.color.equals("black")) || 
								(!moveType && toMove.color.equals("white")))
							System.out.println("Illegal move, try again");
						else
						{
							if(toMove.tryMove(endX, endY, board))
							{
								toMove.move(endX, endY, board);
								thisTurn = false;
								
								if(moveset[4] == 1)
									draw = true;
								else
									draw = false;
							}
							else
								System.out.println("Illegal move, try again");
						}
					}
					else
						System.out.println("Illegal move, try again");
				}
			}
			moveType = !moveType;
			
		}//end while loop
		
		if(winner == 0)
			System.out.println("Black wins!");
		else if(winner == 1)
			System.out.println("White wins!");
		else if(winner == 2)
			System.out.println("Draw");
	}//end playGame()
	
	/**
	 * translateFileRank
	 * Converts file/rank array numbering into the 
	 * numbering convention for arrays in programming
	 * Also checks if there is draw at the end
	 * @param oldFR inputed file/rank
	 * @return int[] appropriate row/column for board and whether draw is called
	 */
	public static int[] translateFileRank(String oldFR)
	{
		int[] newFR = new int[5];
		newFR[0] = ((int) oldFR.charAt(0)) - 97;
		newFR[1] = Math.abs(Integer.parseInt(oldFR.charAt(1) + "") - 8);
		newFR[2] = ((int) oldFR.charAt(3)) - 97;
		newFR[3] = Math.abs(Integer.parseInt(oldFR.charAt(4) + "") - 8);

		if(oldFR.endsWith("draw?"))
			newFR[4] = 1;
		
		for(int i = 0; i < 5; i++)
			System.out.println(newFR[i]);
		
		return newFR;
	}
}
