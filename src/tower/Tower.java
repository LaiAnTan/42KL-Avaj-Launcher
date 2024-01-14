package tower;

import java.util.ArrayList;

import aircraft.Aircraft;
import aircraft.Flyable;
import util.Util;

public class Tower
{

	/*
	 Observer design pattern implementation:

	 - list of observers
	 - functions to add and remove observed items

	 */
	
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable p_flyable) throws DowncastFailedException
	{
		Aircraft a;
		
		if (p_flyable instanceof Aircraft)
			a = (Aircraft) p_flyable; // downcasting is generally a bad idea
		else
			throw (new DowncastFailedException());

		observers.add(p_flyable);
		Util.writeToFile("Tower says: " + a.getType() + "#" + a.getName() + "(" + a.getId() + ") registered to weather tower.\n");
	}

	public void unregister(Flyable p_flyable)
	{
		observers.remove(p_flyable);
	}

	protected void conditionChanged()
	{
		for (Flyable aircraft : new ArrayList<Flyable>(this.observers))
		{
			aircraft.updateConditions();
		}
	}

	public int getObserversSize()
	{
		return (this.observers.size());
	}
}
