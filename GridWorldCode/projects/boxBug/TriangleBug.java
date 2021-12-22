import info.gridworld.actor.Bug;

public class TriangleBug extends Bug {
    private int steps;
    private int baseSteps;
    private int side = 0;

    public TriangleBug(int baseSteps) {
        steps = 0;
        this.baseSteps = baseSteps;
        this.setDirection(45);
        side = 0;
    }

    public void act() {
    	if (side == 0 || side == 1) {
    		if (steps < baseSteps / 2 && canMove()) {
    			move();
    			steps++;
    		} else {
                turn();
                turn();
                if (side == 1) turn();
                steps = 0;
                side++;
            }
    	} else if (side == 2) {
    		if (steps < baseSteps && canMove()) {
    			move();
    			steps++;
    		} else {
                turn();
                turn();
                turn();
                steps = 0;
                side = 0;
            }
    	}
    }
}