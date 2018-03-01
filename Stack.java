/*=============================================================================
 |   Assignment:  Program #6: A-Maizing!
 |       Author:  Jonathan Herron (jherron5225@email.arizona.edu)
 |       Grader:  Jesse Bartels
 |
 |       Course:  CSc 127B
 |   Instructor:  L. McCann
 |     Due Date:  10/14/16
 |
 |  Description:  This is a DIY Stack class that uses an integer array as the 
 |				  object on which elements are pushed/popped/peeked. It is used
 |				  in Program6 to navigate the maze.
 |
 |     Language:  Java 1.7
 | Ex. Packages:  None.
 |                
 | Deficiencies:  None known.
 *===========================================================================*/

import java.util.ArrayList;

public class Stack {

	private ArrayList<int[]> list = new ArrayList<int[]>();
	
	/*---------------------------------------------------------------------
	|  Method: push(int r, int c)
	|
	|  Purpose:  Adds the location (r,c) to the top of the stack
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
	public void push(int r, int c) {
		int[] location = {r, c};
		list.add(location);
	} // push(int r, int c)
	
	/*---------------------------------------------------------------------
	|  Method: pop()
	|
	|  Purpose:  Removes the last element from the top of the stack and 
	|			 returns its location.
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters: None
	|
	|  Returns:  int[] representing popped element
	 *-------------------------------------------------------------------*/
	public int[] pop() {
		int last = list.size()-1;
		int[] lastLocation = list.get(last);
		list.remove(last);
		return lastLocation;
	} // pop()
	
	/*---------------------------------------------------------------------
	|  Method: peek()
	|
	|  Purpose:  Returns the element at the top of the stack
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  None
	|
	|  Returns:  int[] of the last element
	 *-------------------------------------------------------------------*/
	public int[] peek() {
		int last = list.size()-1;
		int[] lastLocation = list.get(last);
		return lastLocation;
	} // peek()
	
	/*---------------------------------------------------------------------
	|  Method: isEmpty()
	|
	|  Purpose:  Checks if the stack is empty
	|
	|  Pre-condition:  None
	|
	|  Post-condition: None
	|
	|  Parameters:  None
	|
	|  Returns: True if the stack is empty, false if not.
	 *-------------------------------------------------------------------*/
	public boolean isEmpty() {
		if (list.size() > 0)
			return false;
		return true;
	} // isEmpty()
} // Stack
