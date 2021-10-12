package weatherEvent.port.adapter.http.rest;

import weatherEvent.application.StationApplicationService;
import weatherEvent.domain.MeasurementStationID;

import java.util.Date;
import java.util.List;

public class StationRestService {
    StationApplicationService applicationService = new StationApplicationService();

    public void weatherEventOnStation(String Uid, String mStationId, List<List<String>> measurements) throws Exception {
        applicationService.weatherEventOnStation(Uid, mStationId, measurements);
    }

    public MeasurementStationID create(String userId, Date lastCalibratedAt, double latitude, double longitude, String name) throws Exception {
        return this.applicationService.createMeasurementStation(userId, lastCalibratedAt, latitude, longitude, name);
    }
}
