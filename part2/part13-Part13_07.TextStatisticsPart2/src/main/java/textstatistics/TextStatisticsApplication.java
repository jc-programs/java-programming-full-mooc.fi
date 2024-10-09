package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        HBox hbox = new HBox();
        Label labelLetters = new Label("Letters: 0");
        Label labelWords = new Label("Words: 0");
        Label labelLongest = new Label("The longest word is:");
        hbox.getChildren().addAll(labelLetters, labelWords, labelLongest);

        TextArea textArea = new TextArea();
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            String[] parts = newValue.split(" ");
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            labelLetters.setText("Letters: " + newValue.length());
            labelWords.setText("Words: " + parts.length);
            labelLongest.setText("The longest word is: " + longest);
        });

        layout.setCenter(textArea);
        layout.setBottom(hbox);

        Scene view = new Scene(layout);

        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        // System.out.println("Hello world!");
        launch(TextStatisticsApplication.class);
    }

}
