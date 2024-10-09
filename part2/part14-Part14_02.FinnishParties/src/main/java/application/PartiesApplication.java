package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    private class ElectionsDataset {

        public List<Integer> years;
        public Map<String, Map<Integer, Double>> data;

        public ElectionsDataset() {
            this.years = new ArrayList<>();
            this.data = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        ElectionsDataset eDataset = readData();
        int minYear = eDataset.years.get(0);
        int maxYear = eDataset.years.get(eDataset.years.size() - 1);
        
        NumberAxis xAxis = new NumberAxis(minYear, maxYear, 4);
        NumberAxis yAxis = new NumberAxis(0,30,5);

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");


        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support in the years 1968-2008");
        
        // go through the parties and add them to the chart
        eDataset.data.keySet().stream().forEach(party -> {
            // a different data set for every party
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            // add the party's support numbers to the data set
            eDataset.data.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            // and add the data set to the chart
            lineChart.getData().add(data);
        });        
        
        window.setScene(new Scene(lineChart, 640, 480));
        window.show();
    }

    private ElectionsDataset readData() {
        ElectionsDataset data = new ElectionsDataset();
        try {
            boolean first = true;
            for (String line : Files.readAllLines(Paths.get("partiesdata.tsv"))) {
                String[] parts = line.split("\t");
                if (first) {
                    first = false;
                    for (int i = 1; i < parts.length; i++) {
                        data.years.add(Integer.valueOf(parts[i]));
                    }
                } else {
                    String party = parts[0];
                    Map<Integer, Double> partyData = new HashMap<>();
                    for (int i = 1; i < parts.length; i++) {
                        Double percentage = parts[i].equals("-") ? null : Double.valueOf(parts[i]);
                        partyData.put(data.years.get(i - 1), percentage );
                    }
                    data.data.put(party, partyData);
                }
            }
            return data;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

}
