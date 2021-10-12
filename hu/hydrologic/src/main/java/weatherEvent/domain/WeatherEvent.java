package weatherEvent.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class WeatherEvent {
    private WeatherEventID id;
    private List<Measurement> measurements;
    private Location location;
    private Date timeStamp;
    private UserID reportedBy;
    private Picture picture;

    public WeatherEvent(WeatherEventID id, UserID reporter, Location location, Date timeStamp) {
        this.id = id;
        this.location = location;
        this.timeStamp = timeStamp;
        this.reportedBy = reporter;
        this.measurements = new ArrayList<>();
    }

    public WeatherEvent(WeatherEventID id, UserID reporter, List<List<String>> measurements, Location location, Date timeStamp) {
        this.id = id;

        // Parse measurements and then add them
        this.measurements = new ArrayList<>();
        for (List<String> measurement : measurements) {
            Double value = Double.parseDouble(measurement.get(0));
            MeasurementUnit unit = new MeasurementUnit(measurement.get(1));
            this.addMeasurement(unit, value);
        }

        this.location = location;
        this.timeStamp = timeStamp;
        this.reportedBy = reporter;
    }

    private void addMeasurement(MeasurementUnit unit, Double value) {
        this.measurements.add(new Measurement(unit, value));
    }

    public UserID getReporterId() {
        return reportedBy;
    }

    public Location getLocation() {
        return location;
    }

    public void addPicture(Picture newPicture) {
        this.picture = newPicture;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void addMeasurement(Measurement measurement) {
        measurements.add(measurement);
    }

    public void removeMeasurement(Measurement measurement) {
        measurements.remove(measurement);
    }

    public List<Measurement> getMeasurements() {
        return Collections.unmodifiableList(measurements);
    }

    public WeatherEventID getId() {
        return this.id;
    }
}