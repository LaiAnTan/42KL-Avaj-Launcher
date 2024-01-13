package tower;

import java.util.ArrayList;

import aircraft.Flyable;

public class Tower
{

	/*
	 Observer design pattern implementation:

	 - list of observers
	 - functions to add and remove observed items

	 */
	
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable p_flyable)
	{
		observers.add(p_flyable);
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

		System.out.println(this.observers.size());
	}
}
