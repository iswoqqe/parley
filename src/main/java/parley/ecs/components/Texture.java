package parley.ecs.components;

import parley.ecs.core.Entity;
import parley.ecs.core.IComponent;
import parley.ecs.core.IEvent;

public class Texture implements IComponent {
    private char symbol;

    public Texture(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public void runEvent(IEvent event, Entity self) {
    }
}
