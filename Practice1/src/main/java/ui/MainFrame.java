package ui;

import fuzzylogic.DatesApp;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFrame extends Stage {

    private Button calcularBtn;

    public MainFrame() {
        initComponents();
        createStage();
    }

    private void createStage() {

        BorderPane pane = new BorderPane();

        HBox layout = new HBox();

        VBox maleLayout = new VBox();
        maleLayout.getChildren().addAll(new Label("Campo 1 "),new TextField());
        maleLayout.getChildren().addAll(new Label("Campo 2 "),new TextField());
        maleLayout.getChildren().addAll(new Label("Campo 3 "),new TextField());
        maleLayout.getChildren().addAll(new Label("Campo 4 "),new TextField());

        VBox femaleLayout = new VBox();
        femaleLayout.getChildren().addAll(new Label("Campo 1 "),new TextField());
        femaleLayout.getChildren().addAll(new Label("Campo 2 "),new TextField());
        femaleLayout.getChildren().addAll(new Label("Campo 3 "),new TextField());
        femaleLayout.getChildren().addAll(new Label("Campo 4 "),new TextField());

        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        layout.getChildren().addAll(maleLayout, separator,femaleLayout,calcularBtn);

        pane.setCenter(layout);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(calcularBtn);
        pane.setBottom(stackPane);

        Scene scene = new Scene(pane,300,200);
        this.setScene(scene);
    }

    private void initComponents() {
        calcularBtn = new Button("Calcular");
        calcularBtn.setOnAction(event -> calcular());
    }


    private void calcular() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation Needed");
        alert.setHeaderText("Points: ");
        try {
            alert.setContentText("" + DatesApp.calculate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        alert.show();
    }
}
