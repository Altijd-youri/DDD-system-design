package weatherEvent.domain;

public class Forecast {
    private ForecastID id;
    private WeatherEventID basedUpon;
    private MeasurementUnit unit;
    private String predictedValue;

    public Forecast(ForecastID id, WeatherEventID basedUpon, MeasurementUnit unit, String predictedValue) {
        this.id = id;
        this.basedUpon = basedUpon;
        this.unit = unit;
        this.predictedValue = predictedValue;
    }
}
