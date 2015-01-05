import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Keyean
 *
 */
public class BFS 
{
	private Queue <State> open = new LinkedList <State>();
	private ArrayList <State> closed = new ArrayList <State>();
	private int memorySpace = 0;
	
	/**
	 * Initializes everything.
	 * @param start
	 */
	public BFS(State start)
	{
		boolean solution = false;
		int nodesExpanded = 0;
		open.add(start);
		while(open.size()!= 0)
		{
			State tempState = open.remove();
			nodesExpanded ++;
			if(tempState.getGoalState())
			{
				System.out.print("Solution Found,");
				//System.out.println(tempState.toString());
				System.out.println("Nodes expanded: " + nodesExpanded);
				System.out.println("Total Number of States stored: " + memorySpace);
				System.out.println("Path Taken: \n" + tempState.printAllState());
				//System.out.println("Last State:\n" + tempState.toString());
				solution = true;
				break;
			}
			else
			{
				nextMove(tempState);
			}
			closed.add(tempState);
		}
		if(!solution)
			System.out.println("Unable to find a solution");
	}
	
	/**
	 * Generates possible next moves for the grid.
	 * @param tempState
	 */
	public void nextMove(State tempState)
	{
		int loc = tempState.getZeroLocation();
		
		switch(loc){
		case 0:
			compareState(tempState.moveRight(tempState, loc));
			compareState(tempState.moveDown(tempState, loc));
			break;
		case 1:
			compareState(tempState.moveLeft(tempState, loc));
			compareState(tempState.moveRight(tempState, loc));
			compareState(tempState.moveDown(tempState, loc));
			break;
		case 2:
			compareState(tempState.moveLeft(tempState, loc));
			compareState(tempState.moveDown(tempState, loc));
			break;
		case 3:
			compareState(tempState.moveRight(tempState, loc));
			compareState(tempState.moveDown(tempState, loc));
			compareState(tempState.moveUp(tempState, loc));
			break;
		case 4:
			compareState(tempState.moveLeft(tempState, loc));
			compareState(tempState.moveRight(tempState, loc));
			compareState(tempState.moveDown(tempState, loc));
			compareState(tempState.moveUp(tempState, loc));
			break;
		case 5:
			compareState(tempState.moveLeft(tempState, loc));
			compareState(tempState.moveDown(tempState, loc));
			compareState(tempState.moveUp(tempState, loc));
			break;
		case 6:
			compareState(tempState.moveRight(tempState, loc));
			compareState(tempState.moveUp(tempState, loc));
			break;
		case 7:
			compareState(tempState.moveLeft(tempState, loc));
			compareState(tempState.moveRight(tempState, loc));
			compareState(tempState.moveUp(tempState, loc));
			break;
		case 8:
			compareState(tempState.moveLeft(tempState, loc));
			compareState(tempState.moveUp(tempState, loc));
			break;
		case 9:
			System.out.println("No Solutions can be found");
			break;
		}
	}
	
	/**
	 * Checks whether or not the grid has already been visited or not.
	 * @param compare
	 */
	public void compareState(State compare)
	{
		for(int i = 0 ; i < closed.size() ; i++)
		{
			if(compare.getCompare(closed.get(i)))
			{
				return;
			}
		}
		compare.addPath(compare); //No match so add to open
		open.add(compare);
		memorySpace++;
	}
}
