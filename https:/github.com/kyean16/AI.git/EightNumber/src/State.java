import java.util.ArrayList;

/** This class is meant to hold one State of the eight puzzle game.
 * A State holds a Node called path, which is a collection of the states visited in order to get to this state.
 * The State function has a Manhantan Distance to calculate the heuristic value.
 * 
 * @author Keyean
 *
 */

public class State 
{
	private ArrayList <Integer> state = new ArrayList<Integer>();
	private ArrayList <Integer> goal = new ArrayList<Integer>();
	private Node path;
	
	/**
	 * Default Constructor which sets up the goal ArrayList and creates a brand new path.
	 */
	public State()
	{
		goal.add(1);
		goal.add(2);
		goal.add(3);
		goal.add(8);
		goal.add(0);
		goal.add(4);
		goal.add(7);
		goal.add(6);
		goal.add(5);
		path = new Node();
	}
	
	/**
	 * Constructor that takes in a path that already exist.
	 * It sets up the goal ArrayList as well as copy every single element from the newPath to the new Path.
	 * @param newPath
	 */
	public State(Node newPath)
	{
		path = new Node();
		for(int i = 0 ; i< newPath.path.size(); i++)
		{
			path.path.add(newPath.path.get(i));
		}
		goal.add(1); //Sets up the Goal Array.
		goal.add(2);
		goal.add(3);
		goal.add(8);
		goal.add(0);
		goal.add(4);
		goal.add(7);
		goal.add(6);
		goal.add(5);
	}
	
	/**
	 * Receives an ArrayList as a parameter to copy and place into the State ArrayList;
	 * @param initState
	 */
	public void loadState(ArrayList<Integer> initState)
	{
		for(int i = 0 ; i < initState.size() ; i++)
		{
				state.add(initState.get(i));
		}
	}
	
	
	/**
	 * Locates the 0 position in the array and returns it
	 * Positions are: 0 1 2
	 * 				  3 4 5
	 * 				  6 7 8
	 */
	public int getZeroLocation()
	{
		int i = 0;
		for(int x = 0 ; x < state.size() ; x++)
		{
			if(state.get(x) == 0)
			{
				return i;
			}
			i++;
		}
		//No zero found return 9
		return 9;
	}
	
	/**
	 * Switches the value of the ArrayList between x and y.
	 * @param x
	 * @param y
	 */
	public void switchNum(int x, int y)
	{
		int oldZero = state.get(y);
	    state.set(x, oldZero);
	    state.set(y,0);
	}
	
	/**
	 * Returns a new grid which shifted to the left.
	 * @param originalState
	 * @param zeroLocation
	 * @return leftState
	 */
	public State moveLeft(State originalState, int zeroLocation)
	{
		State leftState = new State(originalState.path);
		leftState.loadState(originalState.state);
		leftState.switchNum(zeroLocation, zeroLocation-1);
		//System.out.println(leftState.toString());
		return leftState;
	}
	
	/**
	 * Returns a new grid which shifted to the right.
	 * @param originalState
	 * @param zeroLocation
	 * @return rightState
	 */
	public State moveRight(State originalState, int zeroLocation)
	{
		State rightState = new State(originalState.path);
		rightState.loadState(originalState.state);
		rightState.switchNum(zeroLocation, zeroLocation+1);
		//System.out.println(rightState.toString());
		return rightState;
	}
	
	/**
	 * Return a new grid which shifted down.
	 * @param originalState
	 * @param zeroLocation
	 * @return downState
	 */
	public State moveDown(State originalState, int zeroLocation)
	{
		State downState = new State(originalState.path);
		downState.loadState(originalState.state);
		downState.switchNum(zeroLocation, zeroLocation+3);
		//System.out.println(downState.toString());
		return downState;
	}
	
	/**
	 * Return a grid which shifted up.
	 * @param originalState
	 * @param zeroLocation
	 * @return upState
	 */
	public State moveUp(State originalState, int zeroLocation)
	{
		State upState = new State(originalState.path);
		upState.loadState(originalState.state);
		upState.switchNum(zeroLocation, zeroLocation-3);
		//System.out.println(upState.toString());
		return upState;
	}
	
	/**
	 * Return whether or not the state matches the goal state
	 */
	public boolean getGoalState()
	{
		for(int i = 0 ; i < goal.size() ; i++)
		{
			if(goal.get(i) != state.get(i))
			{
					return false; //Does not match goal State
			}
		}
		return true;
	}
	
	/**
	 * Return whether or not the provided State matches the current state.
	 */
	public boolean getCompare(State compareState)
	{
		for(int i = 0 ; i < compareState.state.size() ; i++)
		{
			if(this.state.get(i) != compareState.state.get(i))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns String format of the state ArrayList.
	 */
	public String toString()
	{
		String statePrint ="";
		int i = 0;
		for(int rows = 0 ; rows < 3 ; rows++)
		{
			for(int columns = 0 ; columns < 3 ; columns++)
			{
				statePrint += state.get(i) + " ";
				i++;
			}
			statePrint += "\n";
		}
		return statePrint;
	}
	
	/**
	 * Adds a State to the path.
	 * @param temp
	 */
	public void addPath(State temp)
	{
		path.addState(temp);
	}
	
	/**
	 * Return String format o all Path.
	 */
	public String printAllState()
	{
		return path.printAllStates();
	}
}
