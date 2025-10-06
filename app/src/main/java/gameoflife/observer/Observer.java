package gameoflife.observer;

import gameoflife.Board;

public interface Observer {
    void update(Board board);
}