/*=============================================================================
 |   Assignment:  Program #6: A-Maizing!
 |       Author:  Jonathan Herron (jherron5225@email.arizona.edu)
 |       Grader:  Jesse Bartels
 |
 |       Course:  CSc 127B
 |   Instructor:  L. McCann
 |     Due Date:  10/14/16
 |
 |  Description:  This class scales an r by c array representing a maze
 |				  from Program6.java to an array of 2*r+1 by 2*c+1. Using
 |				  this representation, this class provides methods to check
 |				  boundaries, cut into the maze, and provide an entrance and
 |				  and exit. This is the representation that gets displayed to 
 |				  console.
 |
 |     Language:  Java 1.7
 | Ex. Packages:  None.
 |                
 | Deficiencies:  None known.
 *===========================================================================*/

import java.util.Random;

public class MazeHolder {

	// allocate a 2*r+1 by 2*c+1 2D array representing an r by c 2D corn
	// maze
	char[][] scaledMaze;

	/*---------------------------------------------------------------------
	|  Constructor: MazeHolder(int r, int c)
	|
	|  Purpose:  Initializes the number of rows and columns scaledMaze has.
	|			 Once the sizes are set, all of the characters in the array
	|			 are set to '#.'
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r
	|				int c
	 *-------------------------------------------------------------------*/
	public MazeHolder(int r, int c) {
		scaledMaze = new char[2 * r + 1][2 * c + 1];
		for (int i = 0; i < scaledMaze.length; i++) {
			for (int j = 0; j < scaledMaze[0].length; j++) {
				scaledMaze[i][j] = '#';
			}
		}
	} // MazeHolder(int r, int c)

	/*---------------------------------------------------------------------
	|  Method: canCutRight(int r, int c, char[][] maze)
	|
	|  Purpose:  Checks to the right of the given coordinates in the maze
	|			 to determine if it is safe to cut there. In order to be cut,
	|			 the position must not be empty and must not be out of bounds.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r 
	|				int c
	|				char[][] maze
	|
	|  Returns:  True if it is safe to cut right, false if not.
	 *-------------------------------------------------------------------*/
	public boolean canCutRight(int r, int c, char[][] maze) {
		if (c+1 < maze[0].length && maze[r][c+1] == '#')
			return true;
		return false;
	} // canCutRight(int r, int c, char[][] maze)
	
	/*---------------------------------------------------------------------
	|  Method: cutRight(int r, int c)
	|
	|  Purpose:  Cuts to the right in the scaledMaze. Since the smaller maze
	|			 was the base for checking if the position was safe to be 
	|			 cut into, this method must cut twice because the scaledMaze is
	|			 twice as large as the original.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r 
	|				int c
	|
	|  Returns:  void
	 *-------------------------------------------------------------------*/
	public void cutRight(int r, int c) {
		scaledMaze[2*r+1][2*c+1] = ' ';
		scaledMaze[2*r+1][2*c] = ' ';
	} // cutRight(int r, int c)
	
	/*---------------------------------------------------------------------
	|  Method: canCutLeft(int r, int c, char[][] maze)
	|
	|  Purpose:  Checks to the left of the given coordinates in the maze
	|			 to determine if it is safe to cut there. In order to be cut,
	|			 the position must not be empty and must not be out of bounds.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r 
	|				int c
	|				char[][] maze
	|
	|  Returns:  True if it is safe to cut left, false if not.
	 *-------------------------------------------------------------------*/
	public boolean canCutLeft(int r, int c, char[][] maze) {
		if (c-1 > -1 && maze[r][c-1] == '#')
			return true;
		return false;
	} // canCutLeft(int r, int c, char[][] maze)
	
	/*---------------------------------------------------------------------
	|  Method: cutLeft(int r, int c)
	|
	|  Purpose:  Cuts to the left in the scaledMaze. Since the smaller maze
	|			 was the base for checking if the position was safe to be 
	|			 cut into, this method must cut twice because the scaledMaze is
	|			 twice as large as the original.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r 
	|				int c
	|
	|  Returns:  void
	 *-------------------------------------------------------------------*/
	public void cutLeft(int r, int c) {
		scaledMaze[2*r+1][2*c+1] = ' ';
		scaledMaze[2*r+1][2*c+2] = ' ';
	} // cutLeft(int r, int c)
	
	/*---------------------------------------------------------------------
	|  Method: canCutDown(int r, int c, char[][] maze)
	|
	|  Purpose:  Checks below the given coordinates in the maze to determine
	|			 if it is safe to cut there. In order to be cut, the position
	|			 must not be empty and must not be out of bounds.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r 
	|				int c
	|				char[][] maze
	|
	|  Returns:  True if it is safe to cut down, false if not.
	 *-------------------------------------------------------------------*/
	public boolean canCutDown(int r, int c, char[][] maze) {
		if (r+1 < maze.length && maze[r+1][c] == '#')
			return true;
		return false;
	} // canCutDown(int r, int c, char[][] maze)
	
	/*---------------------------------------------------------------------
	|  Method: cutDown(int r, int c)
	|
	|  Purpose:  Cuts downwards in the scaledMaze. Since the smaller maze
	|			 was the base for checking if the position was safe to be 
	|			 cut into, this method must cut twice because the scaledMaze is
	|			 twice as large as the original.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r 
	|				int c
	|
	|  Returns:  void
	 *-------------------------------------------------------------------*/
	public void cutDown(int r, int c) {
		scaledMaze[2*r+1][2*c+1] = ' ';
		scaledMaze[2*r][2*c+1] = ' ';
	} // cutDown (int r, int c)
	
	/*---------------------------------------------------------------------
	|  Method: canCutUp(int r, int c, char[][] maze)
	|
	|  Purpose:  Checks above the given coordinates in the maze to determine
	|			 if it is safe to cut there. In order to be cut, the position
	|			 must not be empty and must not be out of bounds.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r 
	|				int c
	|				char[][] maze
	|
	|  Returns:  True if it is safe to cut up, false if not.
	 *-------------------------------------------------------------------*/
	public boolean canCutUp(int r, int c, char[][] maze) {
		if (r-1 > -1 && maze[r-1][c] == '#')
			return true;
		return false;
	} // canCutUp(int r, int c, char[][] maze)
	
	/*---------------------------------------------------------------------
	|  Method: cutUp(int r, int c)
	|
	|  Purpose:  Cuts upwards in the scaledMaze. Since the smaller maze
	|			 was the base for checking if the position was safe to be 
	|			 cut into, this method must cut twice because the scaledMaze is
	|			 twice as large as the original.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r 
	|				int c
	|
	|  Returns:  void
	 *-------------------------------------------------------------------*/
	public void cutUp(int r, int c) {
		scaledMaze[2*r+1][2*c+1] = ' ';
		scaledMaze[2*r+2][2*c+1] = ' ';
	} // cutUp(int r, int c)
	
	/*---------------------------------------------------------------------
	|  Method: cut(int r, int c)
	|
	|  Purpose:  Cuts into the scaledMaze at one point at the desired r and
	|			 c. This is only used to cut the starting position.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r 
	|				int c
	|
	|  Returns:  void
	 *-------------------------------------------------------------------*/
	public void cut(int r, int c) {
		scaledMaze[2*r+1][2*c+1] = ' ';
	} // cut(int r, int c)
	

	/*---------------------------------------------------------------------
	|  Method: pickEntrance(char[][] maze)
	|
	|  Purpose: Using the original maze, this method determines where to
	|			put the entrance of the maze. The decision is mostly random
	|			but it checks to make sure that there is an opening to the 
	|			right of the entrance. 
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  char[][] maze
	|
	|  Returns:  An int[], holding the two coordinate values of the
	|			 chosen entrance. 
	 *-------------------------------------------------------------------*/
	public int[] pickEntrance(char[][] maze) {
		// select and place the maze entrance
		Random rand = new Random();
		int entrance = rand.nextInt(maze.length-1)+1;
		if (maze[entrance][1] != ' ')
			entrance = rand.nextInt(maze.length-1)+1;
		int[] location = new int[2];
		location[0] = entrance;
		location[1] = 0;
		return location;
	} // pickEntrance(char[][] maze)
	
	/*---------------------------------------------------------------------
	|  Method: cutEntrance(int r)
	|
	|  Purpose: Since previous cut methods don't cut into the far ends of
	|			the maze, this method takes care of that. Using the coordinate
	|			from pickEntrance(), this method cuts into that location in the
	|			scaledMaze.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r
	|
	|  Returns:  void 
	 *-------------------------------------------------------------------*/
	public void cutEntrance(int r) {
		Random rand = new Random();
		int entrance = rand.nextInt(2*r+1)+1;
		if (scaledMaze[entrance][1] != ' ')
			entrance = rand.nextInt(2*r+1)+1;
		scaledMaze[entrance][0] = ' ';
	} // cutEntrance(int r)

	/*---------------------------------------------------------------------
	|  Method: pickExit(char[][] maze)
	|
	|  Purpose: Using the original maze, this method determines where to
	|			put the exit of the maze. The decision is mostly random
	|			but it checks to make sure that there is an opening to the 
	|			left of the exit. 
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  char[][] maze
	|
	|  Returns:  An int[], holding the two coordinate values of the
	|			 chosen exit. 
	 *-------------------------------------------------------------------*/
	public int[] pickExit(char[][] maze) {
		// select and place the maze exit
		Random rand = new Random();
		int exit = rand.nextInt(maze.length-1)+1;
		if (maze[exit][maze[0].length-2] != ' ')
			exit = rand.nextInt(maze.length-1)+1;
		int[] location = new int[2];
		location[0] = exit;
		location[1] = maze[0].length-1;
		return location;
	} // pickExit(char[][] maze)
	
	/*---------------------------------------------------------------------
	|  Method: cutExit(int r)
	|
	|  Purpose: Since previous cut methods don't cut into the far ends of
	|			the maze, this method takes care of that. Using the coordinate
	|			from pickExit(), this method cuts into that location in the
	|			scaledMaze.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  int r
	|
	|  Returns:  void 
	 *-------------------------------------------------------------------*/
	public void cutExit(int r) {
		Random rand = new Random();
		int exit = rand.nextInt(2*r+1)+1;
		if (scaledMaze[exit][scaledMaze[0].length-2] != ' ')
			exit = rand.nextInt(2*r+1)+1;
		scaledMaze[exit][scaledMaze[0].length-1] = ' ';
	} // cutExit(int r)

	/*---------------------------------------------------------------------
	|  Method: displayMaze
	|
	|  Purpose: This method prints out a text representation of the 
	|			scaledMaze to the console.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  None
	|
	|  Returns:  void 
	 *-------------------------------------------------------------------*/
	public void displayMaze() {
		// display maze
		for (int i = 0; i < scaledMaze.length; i++) {
			for (int j = 0; j < scaledMaze[0].length; j++) {
				System.out.print(scaledMaze[i][j]);
			}
			System.out.println();
		}
	} // displayMaze()
} // MazeHolder
