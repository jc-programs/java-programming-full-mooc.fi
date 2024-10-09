package application;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        TreeMap<Integer, Integer> helsinkiData = new TreeMap<>(Map.ofEntries(
                Map.entry(2007, 73),
                Map.entry(2008, 68),
                Map.entry(2009, 72),
                Map.entry(2010, 72),
                Map.entry(2011, 74),
                Map.entry(2012, 73),
                Map.entry(2013, 76),
                Map.entry(2014, 73),
                Map.entry(2015, 67),
                Map.entry(2016, 56),
                Map.entry(2017, 56)
        ));

        int minYear = helsinkiData.firstKey();
        int maxYear = helsinkiData.lastKey();
        // int minYear = helsinkiData.keySet().stream().min(Integer::compare).get();
        // int maxYear = helsinkiData.keySet().stream().max(Integer::compare).get();
        NumberAxis xAxis = new NumberAxis(minYear - 1, maxYear + 1, 1);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        XYChart.Series data = new XYChart.Series();
        helsinkiData.entrySet().stream().forEach(pair -> {
            data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
        });
        data.setName("Helsinki");

        lineChart.getData().add(data);

        window.setScene(new Scene(lineChart, 640, 480));
        window.show();
    }

}
