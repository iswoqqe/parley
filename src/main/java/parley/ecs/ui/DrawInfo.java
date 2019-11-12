package parley.ecs.ui;

import parley.ecs.components.Position;
import parley.ecs.components.Texture;
import parley.ecs.core.IEvent;

class DrawInfo implements IEvent<DrawInfo.Return> {
    private boolean seenPosition;
    private boolean seenTexture;
    private Return ret;

    public DrawInfo() {
        this.ret = new Return();
    }

    @Override
    public void visit(Position position) {
        ret.x = position.getX();
        ret.y = position.getY();
        seenPosition = true;
    }

    @Override
    public void visit(Texture texture) {
        ret.texture = texture.getTexture();
        seenTexture = true;
    }

    @Override
    public Return getValue() {
        if (!seenTexture || !seenPosition) {
            return null;
        }

        return ret;
    }

    public static class Return {
        private int x;
        private int y;
        private char texture;

        private Return() {
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
    }
}
