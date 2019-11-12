package parley.ecs.ui;

import parley.ecs.components.Position;
import parley.ecs.components.Texture;
import parley.ecs.core.IEntity;
import parley.ecs.core.IGameState;
import parley.ecs.core.ISystem;

class DrawSystem implements ISystem {
    private UIFrame ui;
    private DrawInfoEvent info;

    DrawSystem(UIFrame ui) {
        this.ui = ui;
        this.info = new DrawInfoEvent();
    }

    @Override
    public void run(IGameState entities) {
        ui.preUpdates();

        for (IEntity entity : entities.allWithComponents(Position.class, Texture.class)) {
            entity.fireEvent(info);
            ui.draw(info);
        }

        ui.postUpdates();
    }
}
