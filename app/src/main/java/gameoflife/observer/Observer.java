package gameoflife.observer;

import gameoflife.model.Board;

public interface Observer {
    void update(Board board);
}