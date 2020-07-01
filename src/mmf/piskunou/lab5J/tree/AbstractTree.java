package mmf.piskunou.lab5J.tree;

import java.util.Optional;
import java.util.function.Consumer;

public interface AbstractTree {
    void insert(int newKey) throws SuchKeyIsExistException;

    void print();

    Optional<Integer> searchByProximityFromAbove(int key);
}
