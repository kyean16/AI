import java.util.ArrayList;

/** This class is meant to hold a collection of States as well as the total heuristic value and g;
 * 
 * @author Keyean
 *
 */
public class Node 
{
	public ArrayList <State> path;
	private int h;
	private int g;
	
	/**
	 * Adds a state to the ArrayList path;
	 * @param newState
	 */
	public Node()
	{
		path = new ArrayList<State>();
	}
	
	public void addState(State newState)
	{
		path.add(newState);
	}
	
	/**
	 * Returns all printStates in String.
	 * @return statePath;
	 */
	public String printAllStates()
	{
		String statePath ="";
		for(int i = 0; i < path.size(); i++)
		{
			statePath += ("Step: " + i +"\n");
			statePath += path.get(i).toString();
		}
		return statePath;
	}
}
