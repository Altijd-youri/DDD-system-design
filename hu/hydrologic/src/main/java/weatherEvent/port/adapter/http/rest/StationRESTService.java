package weatherEvent.port.adapter.http.rest;

import weatherEvent.Application.StationApplicationService;
import weatherEvent.domain.MeasurementStationIdentity;

import java.util.Date;
import java.util.List;

public class StationRESTService {
    StationApplicationService applicationService = new StationApplicationService();

    public void weatherEventOnStation(String Uid, String mStationId, List<List<String>> measurements) throws Exception {
        applicationService.weatherEventOnStation(Uid, mStationId, measurements);
    }

    public MeasurementStationIdentity create(String userId, Date lastCalibratedAt, double latitude, double longitude, String name) throws Exception {
        return this.applicationService.createMeasurementStation(userId, lastCalibratedAt, latitude, longitude, name);
    }
}
