package parley.ecs.ui;

import parley.ecs.components.Position;
import parley.ecs.components.Texture;
import parley.ecs.core.IEvent;

class DrawInfoEvent implements IEvent<Void> {
    private int x;
    private int y;
    private char texture;

    public DrawInfoEvent() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getTexture() {
        return texture;
    }

    @Override
    public void visit(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    @Override
    public void visit(Texture texture) {
        this.texture = texture.getTexture();
    }

    @Override
    public Void getValue() {
        return null;
    }
}
