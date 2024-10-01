package es.ieslosmontecillos.ejemplocirculoinnerclass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    //Valores para el radio del circulo
    public static final double CHANGE_VALUE = 5;
    public static final double MIN_VALUE = 5;
    public static final double MAX_VALUE = 50;

    Circle circle;

    @Override
    public void start(Stage stage)
    {
        BorderPane root = new BorderPane();

        //Configuracion del circulo
        circle = new Circle();
        circle.setRadius(10);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        root.setCenter(circle);

        //Caja horizontal que contiene los botones
        HBox hbox = new HBox();

        //Botones y sus eventos
        Button shrinkButton = new Button("Shrink");
        Button enlargeButton = new Button("Enlarge");
        shrinkButton.addEventHandler(ActionEvent.ACTION, new ShrinkEvent());
        enlargeButton.addEventHandler(ActionEvent.ACTION, new EnlargeEvent());
        hbox.getChildren().addAll(shrinkButton, enlargeButton);

        //Configuracion de la caja horizontal
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10, 10, 10, 10));

        root.setBottom(hbox);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Ejemplo Innerclass");
        stage.setScene(scene);
        stage.show();
    }

    public class EnlargeEvent implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            if (circle.getRadius() >= MAX_VALUE) return;
            circle.setRadius(circle.getRadius() + CHANGE_VALUE);
        }
    }

    public class ShrinkEvent implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            if (circle.getRadius() <= MIN_VALUE) return;
            circle.setRadius(circle.getRadius() - CHANGE_VALUE);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}