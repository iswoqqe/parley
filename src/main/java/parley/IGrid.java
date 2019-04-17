package parley;

import java.util.List;

public interface IGrid {
    List<GameObject> get(int x, int y);
    void add(int x, int y, GameObject object);
    bool isBlocked(int x, int y);
}
