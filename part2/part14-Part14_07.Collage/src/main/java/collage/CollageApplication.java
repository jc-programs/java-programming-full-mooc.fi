package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    private int width;
    private int height;
    private PixelReader imageReader;
    private PixelWriter imageWriter;

    public static void main(String[] args) {
        launch(CollageApplication.class);
    }

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        this.imageReader = sourceImage.getPixelReader();

        this.width = (int) sourceImage.getWidth() / 2;
        this.height = (int) sourceImage.getHeight() / 2;

        WritableImage targetImage = new WritableImage(width * 2, height * 2);
        this.imageWriter = targetImage.getPixelWriter();

        copyImage(0, 0);
        copyImage(0,1);
        copyImage(1,0);
        copyImage(1,1);

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    private void copyImage(int gridX, int gridY) {

        final int startX = this.width * gridX;
        final int startY = this.height * gridY;

        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                Color color = this.imageReader.getColor(x * 2, y * 2);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                this.imageWriter.setColor(startX + x, startY + y, newColor);
            }
        }
    }
}