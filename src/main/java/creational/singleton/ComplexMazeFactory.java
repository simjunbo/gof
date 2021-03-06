package creational.singleton;

public class ComplexMazeFactory {
    private static ComplexMazeFactory instance;

    protected ComplexMazeFactory() {

    }

    public static ComplexMazeFactory getInstance() {
        if (instance == null) {
            String mazeStyle = System.getenv("MAZESTYLE");
            if (mazeStyle.equals("bombed")) {
                instance = new BombedMazeFactory();
            } else if (mazeStyle.equals("enchanted")) {
                instance = new EnchantedMazeFactory();
            } else {
                instance = new ComplexMazeFactory();
            }
        }
        return instance;
    }
}
