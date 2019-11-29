package parley.frostbrandexample.components;

import parley.ecs.components.IComponentVisitor;
import parley.ecs.core.IComponent;

public class Health implements IComponent {
    private int health;

    public Health(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;

        if (health < 0) {
            System.out.println("Im dead");
        }
    }

    @Override
    public void accept(IComponentVisitor event) {
        event.visit(this);
    }
}
