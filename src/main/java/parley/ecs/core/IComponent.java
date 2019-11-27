package parley.ecs.core;

import parley.ecs.components.IComponentVisitor;

/**
 * @brief A component is a simple container of data that describes some property.
 *        This is effectively an adjective.
 */

public interface IComponent {
    /*
    @Override
    public void accept(IComponentVisitor event) {
        event.visit(this);
    }
    */
    void accept(IComponentVisitor event);
}
