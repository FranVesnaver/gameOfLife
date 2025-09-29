import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {
        GameOfLife gameOfLife = new BetterGameOfLife(10,10);
//        gameOfLife.setRule(new HighLifeRule());
//        gameOfLife.setRule(new BreederRule());
//        gameOfLife.setRule(new DiffusionRule());
//        gameOfLife.setRule(new LifeWithoutDeathRule());

//        gameOfLife.setColorRule(new RandomColorRule());
//        gameOfLife.setColorRule(new ImmigrationColorRule());

        Scanner scanner = new Scanner(System.in);

        gameOfLife.displayGrid();

        // glider
        gameOfLife.setLivingCell(1, 2);
        gameOfLife.setLivingCell(2, 2);
        gameOfLife.setLivingCell(3, 2);
        gameOfLife.setLivingCell(3, 1);
        gameOfLife.setLivingCell(2, 0);

        // helicopter
        gameOfLife.setLivingCell(1,8);
        gameOfLife.setLivingCell(2,8);
        gameOfLife.setLivingCell(3,8);

        gameOfLife.setLivingCell(9, 0);
        gameOfLife.setLivingCell(9, 1);
        gameOfLife.setLivingCell(9, 2);
        gameOfLife.setLivingCell(7, 0);
        gameOfLife.setLivingCell(7, 1);
        gameOfLife.setLivingCell(7, 2);


        System.out.print("Select number of generations to simulate: ");
        int generations = scanner.nextInt();

        for (int i = 1; i <= generations; i++) {
            gameOfLife.displayGrid();
            gameOfLife.computeNextGeneration();

            System.out.println("Generation: " + i);
            Thread.sleep(500);
        }
    }
}
