package weatherEvent.domain;

public class Forecast {
    private ForecastIdentity id;
    private WeatherEventIdentity basedUpon;
    private MeasurementUnit unit;
    private String predictedValue;

    public Forecast(ForecastIdentity id, WeatherEventIdentity basedUpon, MeasurementUnit unit, String predictedValue) {
        this.id = id;
        this.basedUpon = basedUpon;
        this.unit = unit;
        this.predictedValue = predictedValue;
    }
}
