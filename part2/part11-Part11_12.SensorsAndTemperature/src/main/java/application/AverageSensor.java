package application;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    @Override
    public boolean isOn() {
        return this.sensors.stream().allMatch(sensor -> sensor.isOn() == true);
    }

    @Override
    public void setOn() {
        this.sensors.stream().forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        this.sensors.stream().forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read() {
        if (!this.isOn() || this.sensors.size() == 0) {
            throw new IllegalStateException("TemperatureSensor is off!");
        }

        OptionalDouble averageD = this.sensors.stream()
                .mapToInt(sensor -> sensor.read())
                .average();
        int average = (int) averageD.getAsDouble();
        this.readings.add(average);
        return average;
    }

    public List<Integer> readings() {
        // devuelve la lista de lecturas realizadas
        return this.readings;

        // devuelve la lista de lecturas de todos los sensores
        // return new ArrayList<Integer>(this.sensors.stream()
        // .map( sensor -> sensor.read())
        // .collect(Collectors.toList()));

        // return new ArrayList<Integer>( this.sensors.stream().mapToInt(s->s.read()).toCollection()
        // );
        // return this.sensors.stream()
        // .mapToInt( sensor -> sensor.read())
        // .collect(Collectors.toCollection(ArrayList::new));
    }
}
