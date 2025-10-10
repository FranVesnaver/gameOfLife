package gameoflife.view;

public class ConsoleView implements View {
    public void startMessages() {
        System.out.println("⣀⣀⣀⣠⣾⣿⣿⣿⡿⠋⠉⠙⢿⣿⣿ CONWAY'S GAME OF LIFE ⣿⣿⡿⠋⠉⠙⢿⣿⣿⣿⣷⣄⣀⣀⣀\n");
    }

    @Override
    public void generationNumber(int generation) {
        System.out.println("Generation: " + generation);
    }

    public void generationsMessage() {
        System.out.print("Select number of generations to simulate: ");
    }

    public void toggleCellOnOffMessages() {
        System.out.println("Toggle cells ON/OFF");
        System.out.println("Write the cell you want to toggle in the next format");
        System.out.println("<row>, <column>");
        System.out.println("Type \"start\" when you are ready");
    }

    public void errorMessage(String error) {
        System.out.println("\n" + error + "\n");
    }
}
