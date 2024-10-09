package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        
        // The layout of the first view is done with the help of the BorderPane class. 
        // At the top there is the text "First view!". The center of the view contains 
        // By pressing that button the application swithces to the second view.
        // a button with the text "To the second view!". 
        BorderPane layout1 = new BorderPane();
        layout1.setTop(new Label("First view!"));
        Button buttonInFirstView = new Button("To the second view!");
        layout1.setCenter(buttonInFirstView);
        Scene firstScene = new Scene(layout1);
        
        // The layout of the second view is done with the help of the VBox class. 
        // The first element in the layout is a button with the text "To the third view!"
        // in it — by pressing the button the application switches to the third view.
        // The button is followed by the text "Second view!".
        VBox layout2 = new VBox();
        Button buttonInSecondView = new Button("To the third view!");
        layout2.getChildren().addAll(buttonInSecondView,new Label("Second view!"));
        Scene secondScene = new Scene(layout2);

        // The third view uses the GridPane class for its layout. At the coordinates (0, 0)
        // there is a text that reads "Third view!". At coordinates (1, 1) there is a 
        // button with the text "To the first view!". Pressing this button brings back the first view.
        GridPane layout3 = new GridPane();
        layout3.add(new Label("Third view!"), 0, 0);
        Button buttonInThirdView = new Button("To the first view!");
        layout3.add(buttonInThirdView, 1, 1);
        Scene thirdScene = new Scene(layout3);

        // By pressing that button the application swithces to the second view.
        buttonInFirstView.setOnAction(event -> {
            window.setScene(secondScene);
        });

        // by pressing the button the application switches to the third view.
        buttonInSecondView.setOnAction(event -> {
            window.setScene(thirdScene);
        });
        
        // button with the text "To the first view!". Pressing this button brings back the first view.
        buttonInThirdView.setOnAction(event -> {
            window.setScene(firstScene);
        });

        window.setScene(firstScene);
        window.show();
    }

}
