package parley.systems;

import parley.ecs.components.PhysicalObject;
import parley.ecs.components.Player;
import parley.ecs.core.IEntity;
import parley.ecs.core.IGameState;
import parley.ecs.core.ISystem;
import parley.events.IsBlockedQuery;
import parley.events.Move;
import parley.Inputs;

import java.awt.event.KeyEvent;

public class PlayerMovement implements ISystem {
    public PlayerMovement() {
    }

    @Override
    public void run(IGameState entities) {
        Dir dir = getInput();

        if (dir == Dir.NONE) {
            return;
        }

        int dx = getDX(dir);
        int dy = getDY(dir);

        for (IEntity player : entities.allWithComponents(Player.class, PhysicalObject.class)) {
            PhysicalObject object = player.getComponent(PhysicalObject.class);

            int destX = object.getX() + dx;
            int destY = object.getY() + dy;

            for (IEntity entity : entities.all()) {
                IsBlockedQuery isBlockedQuery = new IsBlockedQuery(destX, destY);
                entity.fireEvent(isBlockedQuery);

                if (isBlockedQuery.result()) {
                    return;
                }
            }

            player.fireEvent(new Move(destX, destY));
        }
    }

    private int getDX(Dir dir) {
        switch (dir) {
            case LEFT: return -1;
            case RIGHT: return 1;
            default: return 0;
        }
    }

    private int getDY(Dir dir) {
        switch (dir) {
            case UP: return -1;
            case DOWN: return 1;
            default: return 0;
        }
    }

    private Dir getInput() {
        switch (Inputs.lastKeyCode()) {
            case KeyEvent.VK_W: return Dir.UP;
            case KeyEvent.VK_S: return Dir.DOWN;
            case KeyEvent.VK_A: return Dir.LEFT;
            case KeyEvent.VK_D: return Dir.RIGHT;
            default: return Dir.NONE;
        }
    }

    private enum Dir {
        UP, DOWN, LEFT, RIGHT, NONE;
    }
}
