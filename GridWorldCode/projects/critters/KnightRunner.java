import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

// import java.awt.Color;

public class KnightRunner {

	public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        // world.add(new Location(1, 5), new KnightCritter(world));
        world.add(new Location(7, 8), new Rock());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(2, 8), new Flower(Color.BLUE));
        world.add(new Location(5, 5), new Flower(Color.PINK));
        world.add(new Location(1, 5), new Flower(Color.RED));
        world.add(new Location(7, 2), new Flower(Color.YELLOW));
        // racism maybe not intended
        KnightCritter white = new KnightCritter();
        white.setColor(new Color(0xdddddd));
        world.add(new Location(0, 0), white);
        KnightCritter black = new KnightCritter();
        black.setColor(new Color(0x333333));
        world.add(new Location(world.getGrid().getNumRows() - 1, world.getGrid().getNumCols() - 1), black);
        // KnightMarker dummy = new KnightMarker();
        // world.add(new Location(4, 5), dummy);
        world.show();
        // world.remove(new Location(4, 5));
    }
	
}