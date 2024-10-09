package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    final int canvasSize = 480;
    final int squareSize = canvasSize / 8;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage window) {

        Canvas paintingCanvas = new Canvas(this.canvasSize, this.canvasSize);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        // paintingCanvas.Fill

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);
        paintSmiley(painter);

        Scene view = new Scene(paintingLayout);

        window.setScene(view);
        window.show();
    }

    private void paintSmiley(GraphicsContext painter) {
        painter.setFill(Color.WHITE);
        painter.fillRect(0, 0, this.canvasSize, this.canvasSize);
        paintSquare(2, 1, painter); // ojo izquierdo
        paintSquare(5, 1, painter); // ojo derecho
        paintSquare(1, 4, painter); // labio izquierdo
        paintSquare(6, 4, painter); // labio derecho
        paintSquare(2, 5, painter); // labio derecho
        paintSquare(3, 5, painter); // labio derecho
        paintSquare(4, 5, painter); // labio derecho
        paintSquare(5, 5, painter); // labio derecho
    }

    private void paintSquare(int x, int y, GraphicsContext painter) {
        painter.setFill(Color.BLACK);
        int positionX = this.getCoordinate(x);
        int positionY = this.getCoordinate(y);
        painter.fillRect(positionX, positionY, this.squareSize, this.squareSize);
    }

    private int getCoordinate(int position) {
        return position * this.squareSize;
    }
}
