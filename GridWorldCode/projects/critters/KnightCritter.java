import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class KnightCritter extends Critter
{
    public KnightCritter()
    {
    	this.setColor(Color.GRAY);
    }

    public ArrayList<Actor> getActors()
    {
        return new ArrayList<Actor>();
    }

    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        for (Location loc : getLocationsInDirections()) {
        	Actor a = getGrid().get(loc);
            if (a == null || a instanceof KnightCritter) // eat
                locs.add(loc);
        }

        return locs;
    }
    
    /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections()
    {
    	int[] directions =
            { Location.NORTH, Location.SOUTH, Location.EAST, Location.WEST };
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(d);
            Location left = neighborLoc.getAdjacentLocation(Location.HALF_LEFT + d);
            Location right = neighborLoc.getAdjacentLocation(Location.HALF_RIGHT + d);
            if (gr.isValid(left))
                locs.add(left);
            if (gr.isValid(right))
                locs.add(right);
        }
        return locs;
    }    
}