package parley.ecs.components;

import parley.ecs.core.IComponent;

public class PhysicalObject implements IComponent {
    private char texture;
    private int x;
    private int y;

    public PhysicalObject(char texture, int x, int y) {
        this.texture = texture;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getTexture() {
        return texture;
    }

    @Override
    public void accept(IComponentVisitor event) {
        event.visit(this);
    }

    @Override
    public String toString() {
        return "PhysicalObject{" +
                "texture=" + texture +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

