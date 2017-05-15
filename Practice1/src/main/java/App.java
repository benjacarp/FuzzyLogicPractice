import javafx.application.Application;
import javafx.stage.Stage;
import ui.MainFrame;

public class App extends Application{

    public static void main(String[] args) {
        System.out.println("Interfaz");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new MainFrame();
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
