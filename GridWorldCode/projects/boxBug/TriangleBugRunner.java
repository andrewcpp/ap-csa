import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

public class TriangleBugRunner {

	public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        TriangleBug hamilton = new TriangleBug(6);
        hamilton.setColor(Color.BLUE);
        world.add(new Location(5, 2), hamilton);
        world.add(new Location(5, 5), new Rock());
        world.show();
    }
	
}