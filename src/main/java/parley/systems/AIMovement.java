package parley.systems;

import parley.ecs.components.AI;
import parley.ecs.components.PhysicalObject;
import parley.ecs.core.IEntity;
import parley.ecs.core.IGameState;
import parley.ecs.core.ISystem;
import parley.events.GetPositionQuery;
import parley.events.IsBlockedQuery;
import parley.events.Move;

import java.util.Random;

public class AIMovement implements ISystem {
    private Random rng;

    public AIMovement() {
        this.rng = new Random(this.hashCode());
    }

    @Override
    public void run(IGameState entities) {
        for (IEntity ai : entities.allWithComponents(AI.class)) {
            GetPositionQuery getPositionQuery = new GetPositionQuery();
            ai.fireEvent(getPositionQuery);

            if (!getPositionQuery.foundPosition()) {
                continue;
            }

            int dx = rng.nextInt(3) - 1;
            int dy = rng.nextInt(3) - 1;

            int destX = getPositionQuery.getX() + dx;
            int destY = getPositionQuery.getY() + dy;


            for (IEntity entity : entities.all()) {
                IsBlockedQuery isBlockedQuery = new IsBlockedQuery(destX, destY);
                entity.fireEvent(isBlockedQuery);

                if (isBlockedQuery.result()) {
                    return;
                }
            }

            ai.fireEvent(new Move(destX, destY));
        }
    }
}
