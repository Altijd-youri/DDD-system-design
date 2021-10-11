package weatherEvent.port.adapter.http.rest;

import weatherEvent.application.StationApplicationService;

import java.util.Date;
import java.util.List;

public class StationRESTService {
    StationApplicationService applicationService = new StationApplicationService();

    public void weatherEventOnStation(String Uid, String mStationId, List<List<String>> measurements) {
        try {
            applicationService.weatherEventOnStation(Uid, mStationId, measurements);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean create(String userId, Date lastCalibratedAt, double latitude, double longitude, String name) throws Exception {
        return this.applicationService.createMeasurementStation(userId, lastCalibratedAt, latitude, longitude, name);
    }
}
