package aircraft;

import coordinates.Coordinates;

public class JetPlane extends Aircraft
{
	
	public JetPlane(long p_id, String[] p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		// TODO Auto-generated method stub
		super.updateConditions();
	}

}