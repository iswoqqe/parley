package parley.ecs.components;

import parley.ecs.core.IComponent;

public class Player implements IComponent {
    public Player() {
    }

    @Override
    public void accept(IComponentVisitor event) {
        event.visit(this);
    }
}
