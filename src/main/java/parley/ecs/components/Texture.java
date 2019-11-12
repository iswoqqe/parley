package parley.ecs.components;

import parley.ecs.core.IComponent;

public class Texture implements IComponent {
    private char texture;

    public Texture(char texture) {
        this.texture = texture;
    }

    public char getTexture() {
        return texture;
    }

    @Override
    public void accept(IComponentVisitor event) {
        event.visit(this);
    }
}
