package simulator;

import java.util.ArrayList;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import aircraft.TypeNotFoundException;
import parser.AircraftData;
import tower.WeatherTower;
import coordinates.Coordinates;

public class Simulator
{
	private int max_runs;
	private ArrayList<AircraftData> aircrafts;

	public Simulator(int simulation_runs, ArrayList<AircraftData> aircrafts)
	{
		this.max_runs = simulation_runs;
		this.aircrafts = aircrafts;
	}

	public void runSimulation() throws SimulationErrorException
	{
		int runs = 0;

		Flyable aircraft;
		WeatherTower weather_tower = new WeatherTower();
		AircraftFactory aircraft_factory = AircraftFactory.getInstance();

		for (AircraftData aircraft_data : aircrafts)
		{
			try
			{
				aircraft = aircraft_factory.newAircraft(aircraft_data.getType(), aircraft_data.getName(),
					new Coordinates(aircraft_data.getLongitude(), aircraft_data.getLatitude(), aircraft_data.getHeight()));
			
				aircraft.registerTower(weather_tower);
			}
			catch (TypeNotFoundException e)
			{
				throw (new SimulationErrorException(e.getMessage()));
			}
		}

		while (runs < max_runs)
		{
			weather_tower.changeWeather();

			runs += 1;
		}
	}

}
