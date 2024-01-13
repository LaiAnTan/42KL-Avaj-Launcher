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
	
	private ArrayList<Flyable> observers = new ArrayList<>();

	public void register(Flyable p_flyable)
	{
		this.observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable)
	{
		this.observers.remove(p_flyable);
	}

	protected void conditionChanged()
	{

	}
}
