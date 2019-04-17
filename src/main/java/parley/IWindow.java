package parley;

public interface IWindow {
    // should probably update in batches, change parameter types
    void draw(int x, int y, char chr, Color foreground, Color background);
}
