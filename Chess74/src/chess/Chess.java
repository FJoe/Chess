/**
 * This is a game of chess that receives
 * input from a text file and visualizes the
 * game with basic ASCII.
 * @authors Dillon Heyck and Francis Joe
 */
package chess;


import java.util.Scanner;

public class Chess {

	static Board game = new Board();
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		
		playGame();
		
	}
	
	public static void playGame()
	{
		//1 = white player's move
		//0 = black player's move
		boolean moveType = true;
		
		String input;
		
		while(true)
		{
			game.printBoard();
			
			if(moveType)
				System.out.println("White's move: ");
			else
				System.out.println("Black's move: ");
			
			input = in.nextLine();
		}//end while loop
	}//end playGame()
	
	/**
	 * translateFileRank
	 * Converts file/rank array numbering into the 
	 * numbering convention for arrays in programming
	 * @param oldFR
	 * @return int[]
	 */
	public static int[] translateFileRank(String oldFR)
	{
		int[] newFR = new int[4];
		newFR[0] = ((int) oldFR.charAt(0)) - 1;
		newFR[1] = Integer.parseInt(oldFR.charAt(1) + "") - 1;
		newFR[2] = ((int) oldFR.charAt(3)) - 1;
		newFR[3] = Integer.parseInt(oldFR.charAt(4) + "") - 1;

		return newFR;
	}
}
