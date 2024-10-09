package hurraa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
// import javafx.scene.media.AudioClip; // breaks test on server

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button button = new Button("Hurraa!");
        pane.setCenter(button);

        // AudioClip audio = new AudioClip("file:Applause-Yannick_Lemieux.wav"); // breaks test on server

        button.setOnAction(event -> {
            // audio.play(); // breaks test on server
        });

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
