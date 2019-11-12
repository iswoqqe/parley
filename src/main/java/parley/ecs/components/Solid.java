package parley.ecs.components;

import parley.ecs.core.IComponent;

public class Solid implements IComponent {
    public Solid() {
    }

    @Override
    public void accept(IComponentVisitor event) {
        event.visit(this);
    }
}
