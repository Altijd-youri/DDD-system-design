package weatherEvent.port.adapter.http.rest;

import weatherEvent.Application.MeasurementStationApplicationService;
import weatherEvent.Application.StationApplicationService;
import weatherEvent.port.adapter.persistence.MemoryMeasurementStationRepository;

import java.util.Date;

public class StationRESTService {
    //TODO - Youri: Implement

    private final StationApplicationService applicationService;

    //Normally you would use dependency injection to inject the application service
    public StationRESTService() {
        this.applicationService = new StationApplicationService(new MemoryMeasurementStationRepository());
    }

    public boolean create(String userId, Date lastCalibratedAt, double latitude, double longitude, String name) throws Exception {
        return this.applicationService.createMeasurementStation(userId, lastCalibratedAt, latitude, longitude, name);
    }
}
