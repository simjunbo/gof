package creational.prototype.client;

import creational.common.product.Door;
import creational.common.product.Maze;
import creational.common.product.Room;
import creational.common.product.Wall;

public interface MazeFactory {
    Maze makeMaze();

    Wall makeWall();

    Room makeRoom(int n);

    Door makeDoor(Room r1, Room r2);
}
