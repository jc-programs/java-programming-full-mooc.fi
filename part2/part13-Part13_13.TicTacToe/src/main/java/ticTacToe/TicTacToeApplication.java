package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private TicTacToeGrid tttGrid;
    private Player player;
    private Label labelInformation;
    private Label labelInformation2;
    private boolean end;

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        this.end = false;
        this.tttGrid = new TicTacToeGrid();
        this.player = Player.PLAYER1;
        BorderPane layout = new BorderPane();
        this.labelInformation = new Label("Turn: " + this.player);
        this.labelInformation.setFont(Font.font("Monospaced", 40));
        this.labelInformation2 = new Label("");
        GridPane grid = new GridPane();
        for (Point p : this.tttGrid.getGridPoints()) {
            final Point point = p;
            final Button button = new Button(this.tttGrid.getPlayer(point).toString());
            button.setFont(Font.font("Monospace", 40));
            grid.add(button, point.getX(), point.getY());
            button.setOnAction(event -> {
                buttonClicked(point, button);
            });
        }
        grid.setVgap(10);
        grid.setHgap(10);

        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setTop(labelInformation);
        layout.setCenter(grid);
        layout.setBottom(labelInformation2);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setTitle("Tic tac toe");
        window.show();
    }

    private void buttonClicked(Point point, Button button) {
        if (this.end || !this.tttGrid.isPlayable(point)) {
            if (this.end) {
                labelInformation2.setText("Game finished");
            } else {
                labelInformation2.setText("Is not empty!");
            }
            return;
        }

        button.setText(this.player.toString());
        this.tttGrid.setPlayer(point, this.player);
        Player winner = this.tttGrid.getWinner(point, this.player);
        if (winner.equals(this.player)) {
            labelInformation.setText("The end!");
            labelInformation2.setText("Winner: " + winner);
            this.end = true;
        } else {
            this.player = this.player.equals(Player.PLAYER1) ? Player.PLAYER2 : Player.PLAYER1;
            if (this.tttGrid.isFull()) {
                labelInformation.setText("The end!");
                labelInformation2.setText("Grid full");
                this.end = true;
            } else {
                labelInformation.setText("Turn: " + this.player);
            }
        }
    }
}
