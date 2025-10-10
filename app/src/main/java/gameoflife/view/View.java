package gameoflife.view;

public interface View {
    void startMessages();
    void toggleCellOnOffMessages();
    void generationsMessage();
    void errorMessage(String error);
    void generationNumber(int generation);
}
