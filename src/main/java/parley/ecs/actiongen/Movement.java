package parley.ecs.actiongen;

import parley.ecs.components.Position;
import parley.ecs.core.Action;
import parley.ecs.core.Entity;
import parley.ecs.core.GameState;
import parley.ecs.events.Move;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    public Movement() {
    }

    public List<Action> generate(Entity entity) {
        Position position = entity.getComponent(Position.class);

        List<Action> ret = new ArrayList<>();

        ret.add(new Action(entity, new Move(position.getX() + 1, position.getY())));
        ret.add(new Action(entity, new Move(position.getX() - 1, position.getY())));
        ret.add(new Action(entity, new Move(position.getX(), position.getY() + 1)));
        ret.add(new Action(entity, new Move(position.getX(), position.getY() - 1)));

        return ret;
    }
}
