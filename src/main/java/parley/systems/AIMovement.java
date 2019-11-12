package parley.systems;

import parley.ecs.components.AI;
import parley.ecs.components.IEvent;
import parley.ecs.components.PhysicalObject;
import parley.ecs.core.IEntity;
import parley.ecs.core.IGameState;
import parley.ecs.core.ISystem;
import parley.events.Move;

import java.util.Random;

public class AIMovement implements ISystem, IEvent {
    private Random rng;

    private boolean queriedIsBlocked;
    private boolean foundPosition;
    private int queriedX;
    private int queriedY;

    public AIMovement() {
        this.rng = new Random();
    }

    @Override
    public void run(IGameState entities) {
        int dx = rng.nextInt(3) - 1;
        int dy = rng.nextInt(3) - 1;

        for (IEntity ai : entities.allWithComponents(AI.class)) {
            ai.fireEvent(this);
            int x = queriedX + dx;
            int y = queriedY + dy;


            for (IEntity entity : entities.all()) {
                foundPosition = false;
                queriedIsBlocked = false;

                entity.fireEvent(this);

                if (foundPosition && x == queriedX && y == queriedY && queriedIsBlocked) {
                    return;
                }
            }

            ai.fireEvent(new Move(x, y));
        }
    }

    @Override
    public void visit(PhysicalObject physicalObject, IEntity self) {
        this.queriedX = physicalObject.getX();
        this.queriedY = physicalObject.getY();
        this.queriedIsBlocked = true;
        this.foundPosition = true;
    }
}
