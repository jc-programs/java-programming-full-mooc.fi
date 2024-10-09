package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    private Slider savingsAmountSlider;
    private Slider interestRateSlider;
    private Label savingsAmountLabel;
    private Label interestRateLabel;
    private LineChart lineChart;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {

        BorderPane layoutSlider1 = new BorderPane();
        this.savingsAmountSlider = new Slider(25, 250, 25);
        this.savingsAmountSlider.setShowTickMarks(true);
        this.savingsAmountSlider.setShowTickLabels(true);
        this.savingsAmountLabel = new Label("25");
        layoutSlider1.setLeft(new Label("Monthly savings"));
        layoutSlider1.setCenter(this.savingsAmountSlider);
        layoutSlider1.setRight(this.savingsAmountLabel);

        BorderPane layoutSlider2 = new BorderPane();
        this.interestRateSlider = new Slider(0, 10, 2);
        this.interestRateSlider.setShowTickMarks(true);
        this.interestRateSlider.setShowTickLabels(true);
        // this.interestRateSlider.setMajorTickUnit(0.25f);
        // this.interestRateSlider.setBlockIncrement(0.1f);
        this.interestRateLabel = new Label("0");
        layoutSlider2.setLeft(new Label("Yearly interest rate"));
        layoutSlider2.setCenter(this.interestRateSlider);
        layoutSlider2.setRight(this.interestRateLabel);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(layoutSlider1, layoutSlider2);
        vBox.setPadding(new Insets(10, 10, 10, 10));

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year");
        yAxis.setLabel("Money");
        this.lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle("Savings");

        BorderPane layout = new BorderPane();
        layout.setTop(vBox);
        layout.setCenter(lineChart);

        this.savingsAmountSlider.valueProperty().addListener(observable -> {
            updateChart();
        });
        this.interestRateSlider.valueProperty().addListener(observable -> {
            updateChart();
        });
        
        this.updateChart();

        window.setScene(new Scene(layout, 640, 480));
        window.show();
    }

    private void updateChart() {
        int savingsAmount = (int) this.savingsAmountSlider.getValue();
        double interestRate = this.interestRateSlider.getValue();

        this.savingsAmountLabel.setText("" + savingsAmount);
        this.interestRateLabel.setText(String.format("%.2f", interestRate));


        // a different data set for every party
        XYChart.Series dataSavings = new XYChart.Series();
        XYChart.Series dataSavingsPlusInterest = new XYChart.Series();
        dataSavings.setName("savings");
        dataSavingsPlusInterest.setName("savings + interest");
        int totalSavings = 0;
        double totalSavingsWithInterest = 0;
        int savingsIncrement = savingsAmount * 12;
        for (int year = 0; year <= 30; year++) {
            dataSavings.getData().add(new XYChart.Data(year, totalSavings));
            dataSavingsPlusInterest.getData().add(new XYChart.Data(year, totalSavingsWithInterest));
            totalSavings += savingsIncrement;
            totalSavingsWithInterest += savingsIncrement;
            totalSavingsWithInterest *= 1.0 + interestRate / 100;
        }

        // and add the data set to the chart
        // this.lineChart.getData().removeAll(); // no funciona
        this.lineChart.getData().clear();
        lineChart.getData().addAll(dataSavings, dataSavingsPlusInterest);
    }

}
