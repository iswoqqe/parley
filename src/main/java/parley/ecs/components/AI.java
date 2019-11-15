package parley.ecs.components;

import parley.ecs.core.IComponent;

public class AI implements IComponent {
    @Override
    public void accept(IComponentVisitor event) {
        event.visit(this);
    }
}
