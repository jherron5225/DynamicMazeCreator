
/*=============================================================================
 |   Assignment:  Program #6: A-Maizing!
 |       Author:  Jonathan Herron (jherron5225@email.arizona.edu)
 |       Grader:  Jesse Bartels
 |
 |       Course:  CSc 127B
 |   Instructor:  L. McCann
 |     Due Date:  10/14/16
 |
 |  Description:  This class runs the maze creation algorithm using an r by c
 |				  maze, given by the user in the command line. Using the methods
 |				  in MazeHolder, this class creates the 2*r+1 by 2*c+1 maze and
 |				  displays it to the console.
 |
 |     Language:  Java 1.7
 | Ex. Packages:  None.
 |                
 | Deficiencies:  None known.
 *===========================================================================*/

import java.util.Random;

public class Program6 {

	// creates the standard maze and the scaled maze
	public static char[][] maze;
	public static MazeHolder m;

	/*---------------------------------------------------------------------
	|  Method: main(String[] args)
	|
	|  Purpose:  Creates the maze by checking boundaries and positions in the
	|			 standard maze, and then saving those changes in the scaledMaze
	|			 using MazeHolder methods.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  String[] args
	|
	|  Returns:  void
	 *-------------------------------------------------------------------*/
	public static void main(String[] args) {

		int r = Integer.parseInt(args[0]);
		int c = Integer.parseInt(args[1]);
		if (r <= 1 || c <= 1) {
			System.out.println("Invalid scale: The number of rows and clolumns must be positive and greater than 1");
			return;
		}
		maze = new char[r][c];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				maze[i][j] = '#';
			}
		}
		m = new MazeHolder(r, c);

		// clear a randomly-selected starting location within the r by c maze
		Random rand = new Random();
		int startRow = rand.nextInt(maze.length);
		int startCol = rand.nextInt(maze[0].length);
		maze[startRow][startCol] = ' ';
		m.cut(startRow, startCol);

		// push the starting location onto the stack
		Stack s = new Stack();
		s.push(startRow, startCol);

		// while the stack is not empty:
		while (s.isEmpty() == false) {

			// peek at the top of stack to learn current location
			int[] start = s.peek();
			startRow = start[0];
			startCol = start[1];

			// determine possible directions to cut
			String directions = "";
			if (m.canCutRight(startRow, startCol, maze)) {
				directions += " Right";
			}
			if (m.canCutLeft(startRow, startCol, maze)) {
				directions += " Left";
			}
			if (m.canCutDown(startRow, startCol, maze)) {
				directions += " Down";
			}
			if (m.canCutUp(startRow, startCol, maze)) {
				directions += " Up";
			}
			directions = directions.trim();
			String[] options = directions.split(" ");

			// if there is at least one new direction in which to cut:
			if (options.length > 0) {
				// randomly select one of the available directions
				int randDirection = rand.nextInt(options.length);
				if (options[randDirection].contains("Right")) {
					startCol += 1;
					s.push(startRow, startCol);
					maze[startRow][startCol] = ' ';
					m.cutRight(startRow, startCol);
					continue;
				}
				if (options[randDirection].contains("Left")) {
					startCol -= 1;
					s.push(startRow, startCol);
					maze[startRow][startCol] = ' ';
					m.cutLeft(startRow, startCol);
					continue;
				}
				if (options[randDirection].contains("Down")) {
					startRow += 1;
					s.push(startRow, startCol);
					maze[startRow][startCol] = ' ';
					m.cutDown(startRow, startCol);
					continue;
				}
				if (options[randDirection].contains("Up")) {
					startRow -= 1;
					s.push(startRow, startCol);
					maze[startRow][startCol] = ' ';
					m.cutUp(startRow, startCol);
					continue;
				}

				// otherwise:
				else {
					// discard the location at the top of the stack
					s.pop();
				}
				// end if
			} // end while
		}

		// places entrance
		int[] entrance = m.pickEntrance(maze);
		maze[entrance[0]][entrance[1]] = ' ';
		m.cutEntrance(entrance[0]);

		// places exit
		int[] exit = m.pickExit(maze);
		maze[exit[0]][exit[1]] = ' ';
		m.cutExit(exit[0]);

		// displays maze
		m.displayMaze();
		
	} // main(String[] args)
} // Program6
